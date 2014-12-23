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
import com.view.gui.SaleDetailGUI;
import com.view.view.SaleDetailView;

public class SaleDetailViewImpl implements SaleDetailView{
	private SaleDetailGUI gui;
	private IBillService service;
	
	public SaleDetailViewImpl(IBillService s)throws RemoteException{
		service = s;
		gui = new SaleDetailGUI();
		gui.addListeners(handlers);
	}
	
	public SaleDetailViewImpl(){
		gui = new SaleDetailGUI();
		gui.addListeners(handlers);
	}
	
transient ActionListener showHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String stime = gui.getStime();
			String etime = gui.getEtime();
			String comno = gui.getComno();
			String cusno = gui.getCusno();
			String bus = gui.getBus();
			String ware = gui.getWare();
			
			DefaultTableModel model = (DefaultTableModel)gui.getTable().getModel();
			
			if((stime.length()==0&&etime.length()!=0)   || (stime.length()!=0&&etime.length()==0) ){
				MsgDialog.tip("请输入时间区间！");
			}else {
				handleShow( stime, etime, comno, cusno, bus, ware, model);
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
	public JInternalFrame getSaleDetailView() {
		// TODO Auto-generated method stub
		return gui;
	}

	@Override
	public void handleShow(String stime, String etime, String comno,
			String cusno, String bus, String ware, DefaultTableModel model) {
		// TODO Auto-generated method stub
		model.setColumnCount(0);
		try{
		ArrayList<String> list = service.getSaleDetail(stime, etime, comno, cusno, bus, ware);
		if(list.size()==0){
			MsgDialog.tip("无匹配结果！");
		}else {
			int i = 0;
			for(String s:list){
				String[]temp = s.split("$");
				String[]arr = {i+"",temp[0],temp[1],temp[2],temp[3],temp[4],temp[5],temp[6]};
				i++;
				
				model.addRow(arr);
			}
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
