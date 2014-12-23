package com.view.viewimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;

import com.function.MsgDialog;
import com.remote_interface.IBillService;
import com.view.gui.BillGUI;
import com.view.gui.SaleLichengGUI;
import com.view.view.SaleLichengView;

public class SaleLichengViewImpl implements SaleLichengView{
	
	private SaleLichengGUI gui;
	private IBillService service;
	private BillGUI gui2;
	
	private String info = "";
	
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
	

	transient ActionListener hcHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String[]temp = info.split("$");
			try {
				service.hongchongBill(temp[0],MainViewImpl.user.getId());
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};
	
	transient ActionListener hcfzHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String[]temp = info.split("$");
			try {
				service.hongchongBill(temp[0],MainViewImpl.user.getId());
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			gui2.dispose();
			if(temp[2].equals("进货单")||temp[2].equals("进货退货单")){
				JInternalFrame view = new ImportBillViewImpl().getImportBillView();
				MainViewImpl.gui.getContentPane().add(view);
				view.setVisible(true);
			}else {
				JInternalFrame view = new ExportBillViewImpl().getExportBillView();
				MainViewImpl.gui.getContentPane().add(view);
				view.setVisible(true);
			}
		}
	};
	
	transient ActionListener [] hcsHandlers = {hcHandler,hcfzHandler};

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
				JButton jbt = new JButton("查看");
				jbt.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						gui2 = new BillGUI();
						gui2.addListeners(hcsHandlers);
						gui2.setInfo(temp[2]);
						gui2.setVisible(true);
						
						info = s;
					}
				});
				
				Object[]arr = {temp[0],temp[1],jbt};
				
				model.addRow(arr);
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}



}
