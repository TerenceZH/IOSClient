package com.view.viewimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.function.ExcelExporter;
import com.remote_interface.ICommodityService;
import com.view.gui.StockPandianGUI;
import com.view.view.StockPandianView;

public class StockPandianViewImpl implements StockPandianView {
	private StockPandianGUI gui;
	private ICommodityService service;
	
	public StockPandianViewImpl(ICommodityService s)throws Exception{
		service  = s;
		gui = new StockPandianGUI();
		gui.addPandianListeners(handlers);
	}
	
	public StockPandianViewImpl(){
		gui = new StockPandianGUI();
		gui.addPandianListeners(handlers);
	}
	
	
	transient ActionListener exportHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JTable table = gui.getTable();
			handleExport(table);
		}
	};
	
	
	transient ActionListener pandianHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			DefaultTableModel model = (DefaultTableModel)gui.getTable().getModel();
			handlePandian(model);
			gui.getTable().validate();
			
		}
	};
	
	transient ActionListener [] handlers = {pandianHandler,exportHandler};

	@Override
	public JInternalFrame getStockPandianView() {
		// TODO Auto-generated method stub
		return gui;
	}

	@Override
	public void handleExport(JTable  table) {
		// TODO Auto-generated method stub
		 try {  
             ExcelExporter exp = new ExcelExporter();  
             exp.exportTable(table, new File("results.xls"));  
         } catch (IOException ex) {  
             System.out.println(ex.getMessage());  
             ex.printStackTrace();  
         }  
	}

	@Override
	public void handlePandian(DefaultTableModel model) {
		// TODO Auto-generated method stub
		try{
		ArrayList<String> list = service.getStock2();
		if(list.size()!=0){
			int i = 1;
			for(String s:list){
				String[]temp = s.split(",");			
				String[]arr = {i+"",temp[0],temp[1],temp[2],temp[3],temp[4],temp[5],temp[6],temp[7]};
				model.addRow(arr);
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	

}
