package com.view.viewimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;

import com.function.MsgDialog;
import com.remote_interface.IBillService;
import com.view.gui.ConfirmGUI;
import com.view.view.ConfirmView;

public class ConfirmViewImpl implements ConfirmView {
	private ConfirmGUI gui;
	private IBillService service;
	
	private List<String> list;
	
	public ConfirmViewImpl(IBillService s)throws Exception{
		service = s;
		gui = new ConfirmGUI();
		gui.addConfirmListeners(handlers);
	}
	
	public ConfirmViewImpl(){
		gui = new ConfirmGUI();
		gui.addConfirmListeners(handlers);
	}
	
	
	transient ActionListener seeHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			DefaultTableModel model =  (DefaultTableModel)gui.getTable().getModel();
			handleShow(model);
			gui.getTable().validate();
		}
	};
	
	transient ActionListener confirmHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ArrayList<Boolean> l = gui.getRowConfirm();
			if(l.size()==0){
				MsgDialog.tip("请选择后审批！");
			}else {
				for(int i=0;i<l.size();i++){
					if(l.get(i)){
						String string = list.get(i);
						String[]temp = string.split("$");
						handleConfirm(temp[0]);
					}
				}
			}
			
		}
	};
	
	transient ActionListener[] handlers = {seeHandler,confirmHandler};
	

	@Override
	public JInternalFrame getConfirmView() {
		// TODO Auto-generated method stub
		return gui;
	}

	@Override
	public void handleShow(DefaultTableModel model) {
		// TODO Auto-generated method stub
		try{
		list = service.queryBillToConfirm();
		if(list.size()==0){
			MsgDialog.tip("无待审核的单子！");
		}else{
			for(String s:list){
				String[] temp = s.split("$");
				Object[]arr = new Object[4];
				arr[0] = false;
				arr[1] = temp[1];
				arr[2] = temp[2];
				arr[3] = temp[3];
				
				model.addRow(arr);
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void handleConfirm(String no) {
		// TODO Auto-generated method stub
		try {
			service.modBillState(no,MainViewImpl.user.getId());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
