package com.view.viewimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument.LeafElement;

import com.function.Common;
import com.function.MsgDialog;
import com.model.Commodity;
import com.model.CommodityCategory;
import com.remote_interface.ICommodityService;
import com.view.gui.CommodityGUI;
import com.view.view.CommodityCategoryView;
import com.view.view.CommodityView;

public class CommodityViewImpl implements CommodityView{
	private ICommodityService service;
	private CommodityGUI gui;
	
	public CommodityViewImpl(ICommodityService s)throws Exception{
		service = s;
		gui = new CommodityGUI(service.getAllCommodityCategories());
		gui.addCommodityListeners(handlers);
	}
	
	public CommodityViewImpl(){
		gui = new CommodityGUI(new ArrayList<String>());
		gui.addCommodityListeners(handlers);
	}
	
	transient ActionListener addHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String name = gui.getCname();
			String style = gui.getStyle();
			String type = gui.getType();
			String inprice = gui.getInPrice();
			String ourprice = gui.getOutPrice();
			String warning = gui.getWarning();
			
			if(name.length()==0||style.length()==0){
				MsgDialog.tip("请输入名称和型号!");
			}else if(type.equals("请选择")){
				MsgDialog.tip("请选择类型!");
				
			}else {
				handleAddCommodity(name, style, type,Double.parseDouble(inprice),
						Double.parseDouble(ourprice),Integer.parseInt(warning));
			}
			
		}
	};
	
	transient ActionListener resetAddHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			gui.setNull();
		}
	};
	
	transient ActionListener sortHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String no = gui.getNo2();
			
			if(no.length()==0){
				MsgDialog.tip("请输入编号！");
			}else {
				try{
				Commodity c = service.queryCommodity(no);
				if(c==null){
					MsgDialog.tip("商品不存在！");
				}else {
					gui.setName(c.getName());
					gui.setStyle(c.getStyle());
				}
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		}
	};
	
	
	transient ActionListener modHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String no = gui.getNo2();
			String inprice = gui.getInPrice2();
			String outprice = gui.getOutPrice2();
			String warning = gui.getWarning2();
			
			if(no.length()==0){
				MsgDialog.tip("请输入编号！");
			}else {
				handleModCommodity(no, Double.parseDouble(inprice), Double.parseDouble(outprice),Integer.parseInt(warning));
			}
		}
	};
	
	
	transient ActionListener resetModHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			gui.setNull2();
		}
	};
	
	transient ActionListener sort2Handler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String no = gui.getNo3();
			
			if(no.length()==0){
				MsgDialog.tip("请输入编号！");
			}else {
				try{
				Commodity c = service.queryCommodity(no);
				if(c==null){
					MsgDialog.tip("商品不存在！");
				}else {
					gui.setNo3(no);
					gui.setCname3(c.getName());
					gui.setStyle3(c.getStyle());
				}
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		}
	};
	
	transient ActionListener delHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String no = gui.getNo3();
			
			if(no.length()==0){
				MsgDialog.tip("请输入编号！");
			}else {
				handleDelCommodity(no);
			}
		}
	};
	
	transient ActionListener[] handlers = {addHandler,resetAddHandler,sortHandler,modHandler,resetModHandler,sort2Handler,delHandler};
	

	@Override
	public JInternalFrame getCommodityView() {
		// TODO Auto-generated method stub
		return gui;
	}

	@Override
	public void handleAddCommodity(String name, String style, String type,
			double inprice, double outprice, int warning) {
		// TODO Auto-generated method stub
		
		try {
			service.addCommodity(name, style, type, inprice, outprice, warning, MainViewImpl.user.getId());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void handleModCommodity(String no, double inprice, double outprice,
			int warning) {
		// TODO Auto-generated method stub
		try {
			service.modCommodity(no, inprice, outprice, warning, MainViewImpl.user.getId());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void handleDelCommodity(String no) {
		// TODO Auto-generated method stub
		try {
			service.delCommdoityCategory(no, MainViewImpl.user.getId());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
