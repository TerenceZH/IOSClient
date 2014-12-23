package com.view.viewimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;

import com.function.MsgDialog;
import com.remote_interface.ICommodityService;
import com.view.gui.StockQueryGUI;
import com.view.view.StockQueryView;

public class StockQueryViewImpl implements StockQueryView{
	private StockQueryGUI gui;
	private ICommodityService service;
	
	public StockQueryViewImpl(ICommodityService s)throws Exception{
		service = s;
		gui = new StockQueryGUI();
		gui.addStockQUeryListener(handler);
	}
	
	public StockQueryViewImpl(){
		gui = new StockQueryGUI();
		gui.addStockQUeryListener(handler);
	}
	
	transient ActionListener handler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String stime = gui.getStime();
			String etime = gui.getEtime();
			
			if(stime.length()==0||etime.length()==0){
				MsgDialog.tip("请输入时间区间！");
			}else {
				DefaultTableModel model = (DefaultTableModel)gui.getTable().getModel();
				handleShow(stime, etime, model);
				gui.getTable().validate();
			}
		}
	};
	
	

	@Override
	public JInternalFrame getStockQueryView() {
		// TODO Auto-generated method stub
		return gui;
	}

	@Override
	public void handleShow(String stime, String etime, DefaultTableModel model) {
		// TODO Auto-generated method stub
		try{
		gui.setQuantity(service.getOutQuantity(stime, etime)+"");
		gui.setMoney(service.getOutMoney(stime, etime)+"");
		
		ArrayList<String> list = service.getStock(stime, etime);
		if(list.size()!=0){
			for(String s:list){
				String[]temp = s.split(",");
				String[]arr = {temp[0],temp[1],temp[2],temp[3],temp[4],temp[5],temp[6],temp[7]};
				
				model.addRow(arr);
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
