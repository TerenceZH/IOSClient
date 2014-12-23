package com.view.viewimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JInternalFrame;

import com.function.Common;
import com.function.MsgDialog;
import com.remote_interface.ICommodityService;
import com.view.gui.StockBydGUI;
import com.view.view.StockBydView;

public class StockBydViewImpl implements StockBydView{
	private ICommodityService service;
	private StockBydGUI gui;
	
	public StockBydViewImpl(ICommodityService s)throws Exception{
		service  = s;
		gui = new StockBydGUI();
		gui.addBydListener(handler);
	}
	
	public StockBydViewImpl(){
		gui = new StockBydGUI();
		gui.addBydListener(handler);
	}
	
	transient ActionListener handler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String no = gui.getNo();
			String quantity = gui.getQuantity();
			
			if(no.length()==0){
				MsgDialog.tip("请输入编号！");
			}else if(Integer.parseInt(quantity)<=0){
				MsgDialog.tip("数量非法！");
			}else {
				handleAdd(no, Integer.parseInt(quantity));
			}
		}
	};

	@Override
	public JInternalFrame getStockBydView() {
		// TODO Auto-generated method stub
		return gui;
	}

	@Override
	public void handleAdd(String no, int quantity) {
		// TODO Auto-generated method stub
		try {
			service.addStockBill(0, no, quantity, Common.time(), MainViewImpl.user.getId());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
