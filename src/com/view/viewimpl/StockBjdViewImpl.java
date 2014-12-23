package com.view.viewimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JInternalFrame;

import com.function.Common;
import com.function.MsgDialog;
import com.remote_interface.ICommodityService;
import com.view.gui.StockBjdGUI;
import com.view.view.StockBjdView;

public class StockBjdViewImpl implements StockBjdView{
	private StockBjdGUI gui;
	private ICommodityService service;
	
	public StockBjdViewImpl(ICommodityService s)throws Exception{
		service = s;
		gui = new StockBjdGUI();
		gui.addBjdListener(handler);
	}
	
	public StockBjdViewImpl(){
		gui = new StockBjdGUI();
		gui.addBjdListener(handler);
	}
	
	transient ActionListener handler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String no = gui.getNo();
			
			if(no.length()==0){
				MsgDialog.tip("«Î ‰»Î±‡∫≈£°");
			}else
				handleAdd(no);
		}
	};

	@Override
	public JInternalFrame getStockBjdView() {
		// TODO Auto-generated method stub
		return gui;
	}

	@Override
	public void handleAdd(String no) {
		// TODO Auto-generated method stub
		try {
			service.addStockBill(2, no, 0,Common.time(),MainViewImpl.user.getId());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
