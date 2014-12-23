package com.view.viewimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;

import com.function.MsgDialog;
import com.remote_interface.IBillService;
import com.view.gui.SaleLichengGUI;
import com.view.view.SaleLichengView;

public class SaleLichengViewImpl implements SaleLichengView{
	
	private SaleLichengGUI gui;
	private IBillService service;
	
	public SaleLichengViewImpl(IBillService s)throws RemoteException{
		service = s;
		gui = new SaleLichengGUI();
		gui.addListener(showHandler);
	}
	
	public SaleLichengViewImpl(){
		gui = new SaleLichengGUI();
		gui.addListener(showHandler);
	}
	
	transient ActionListener showHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String stime = gui.getStime();
			String etime = gui.getEtime();
			String cusno = gui.getCusno();
			int type = gui.getType();
			String warehouse = gui.getWare();
			String business  = gui.getBus();
			
			DefaultTableModel model = (DefaultTableModel)gui.getTable().getModel();
			
			if((stime.length()==0&&etime.length()!=0)   || (stime.length()!=0&&etime.length()==0) ){
				MsgDialog.tip("请输入时间区间！");
			}else {
				handleShow( stime, etime, cusno,type, business, warehouse, model);
				gui.getTable().validate();
			}
		}
	};
	


	@Override
	public JInternalFrame getSaleLichengView() {
		// TODO Auto-generated method stub
		return gui;
	}

	@Override
	public void handleShow(String stime, String etime, String cusno, int type,
			String ware, String bus, DefaultTableModel model) {
		// TODO Auto-generated method stub
		model.setColumnCount(0);
		try{
		ArrayList<String> list = service.getSaleLicheng(stime, etime, type, cusno, bus, ware);
		if(list.size()==0){
			MsgDialog.tip("无匹配结果！");
		}else {
			for(String s:list){
				String[]temp = s.split("$");
				String[]arr = {temp[0],temp[1],temp[2]};
				
				model.addRow(arr);
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}



}
