package com.view.viewimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JInternalFrame;

import com.function.Common;
import com.function.MsgDialog;
import com.remote_interface.ICommodityService;
import com.view.gui.StockZsdGUI;
import com.view.view.StockZsdView;

public class StockZsdViewImpl implements StockZsdView{
	private ICommodityService service;
	private StockZsdGUI gui;
	
	public StockZsdViewImpl(ICommodityService s)throws Exception{
		service = s;
		
		gui = new StockZsdGUI();
		gui.addStockZsdListener(handler);
	}
	
	public StockZsdViewImpl(){
		gui = new StockZsdGUI();
		gui.addStockZsdListener(handler);
	}

	transient ActionListener handler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String no1 = gui.getCusNo();
			String no2 = gui.getComNo();
			String quantity = gui.getQuantity();
			
			if(no1.length()==0||no2.length()==0||Integer.parseInt(quantity)<=0){
				MsgDialog.tip("ÊäÈë·Ç·¨£¡");
			}else {
				handleAdd(no1, no2, Integer.parseInt(quantity));
			}
		}
	};

	@Override
	public JInternalFrame getStockZsdView() {
		// TODO Auto-generated method stub
		return gui;
	}

	@Override
	public void handleAdd(String cusNo, String comNo, int quantity) {
		// TODO Auto-generated method stub
		try {
			service.addStockBill(3, comNo,quantity,Common.time(),MainViewImpl.user.getId());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
