package com.view.viewimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.function.ExcelExporter;
import com.function.MsgDialog;
import com.remote_interface.IBillService;
import com.view.gui.SaleAccountGUI;
import com.view.view.SaleAccountView;

public class SaleAccountViewImpl implements SaleAccountView{
	private SaleAccountGUI gui;
	private IBillService service;
	
	public SaleAccountViewImpl(IBillService s)throws RemoteException{
		service = s;
		gui = new SaleAccountGUI();
		gui.addListeners(handlers);
	}
	
	public SaleAccountViewImpl(){
		gui = new SaleAccountGUI();
		gui.addListeners(handlers);
	}
	
	transient ActionListener showHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String stime = gui.getStime();
			String etime = gui.getEtime();
			
			DefaultTableModel model = (DefaultTableModel)gui.getTable().getModel();
			
			if(stime.length()==0||etime.length()==0){
				MsgDialog.tip("请输入时间区间！");
			}else {
				handleShow(stime, etime, model);
				gui.getTable().validate();
			}
		}
	};
	
	transient ActionListener exportHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JTable table = gui.getTable();
			handleExport(table);
		}
	};
	
	transient ActionListener[]handlers = {showHandler,exportHandler};

	@Override
	public JInternalFrame getSaleAccountView() {
		// TODO Auto-generated method stub
		return gui;
	}

	@Override
	public void handleShow(String stime, String etime, DefaultTableModel model) {
		// TODO Auto-generated method stub
		model.setColumnCount(0);
		try{
		ArrayList<String> list = service.getSaleAccount(stime, etime);
		for(int i=0;i<3;i++){
			String temp[] = list.get(i).split("$");
			String[]arr = new String[4];
			//{"收入类",temp[0],temp[1],temp[2]};
			arr[0] = i==0?"收入类":i==1?"支出类":"利润";
			arr[1] = temp[1];
			arr[2]  = temp[2];
			arr[3]  =temp[3];
			model.addRow(arr);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void handleExport(JTable table) {
		// TODO Auto-generated method stub
		 try {  
             ExcelExporter exp = new ExcelExporter();  
             exp.exportTable(table, new File("results.xls"));  
         } catch (IOException ex) {  
             System.out.println(ex.getMessage());  
             ex.printStackTrace();  
         }  
	}

}
