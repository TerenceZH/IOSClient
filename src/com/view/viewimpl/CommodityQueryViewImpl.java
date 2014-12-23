package com.view.viewimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;

import com.function.MsgDialog;
import com.model.Commodity;
import com.remote_interface.ICommodityService;
import com.view.gui.CommodityQueryGUI;
import com.view.view.CommodityQueryView;

public class CommodityQueryViewImpl implements CommodityQueryView{
	private CommodityQueryGUI gui;
	private ICommodityService service;
	
	public CommodityQueryViewImpl(ICommodityService s)throws Exception{
		service = s;
		gui = new CommodityQueryGUI();
		gui.addCommodityQueryListener(handler);
	}
	
	public CommodityQueryViewImpl(){
		gui = new CommodityQueryGUI();
		gui.addCommodityQueryListener(handler);
	}

	
	transient ActionListener handler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			DefaultTableModel model = (DefaultTableModel)gui.getTable().getModel();
			
			String no  =gui.getNo();
			String key = gui.getKeyword();
			
			if(no.length()==0&&key.length()==0){
				handleQuery("1", 2,model);
			}else {
				if(no.length()!=0){
					handleQuery(no, 0,model);
				}else {
					handleQuery(key, 1,model);
				}
			}
			
			gui.getTable().validate();
		}
	};

	@Override
	public JInternalFrame getCommodityQueryView() {
		// TODO Auto-generated method stub
		return gui;
	}

	@Override
	public void handleQuery(String s, int type,DefaultTableModel model) {
		// TODO Auto-generated method stub
		ArrayList<Commodity> commodities = new ArrayList<Commodity>();
		try{
		if(type==0){
			Commodity c = service.queryCommodity(s);
			if(c==null){
				MsgDialog.tip("商品不存在！");
			}else {
				commodities.add(c);
			}			
		}else if(type==1) {
			commodities = service.queryCommodityByKeyword(s);
			if(commodities.size()==0){
				MsgDialog.tip("商品不存在！");
			}
		}else {
			commodities = service.queryAllCommodity();
		}
		
		if(commodities.size()!=0){
			for(Commodity com:commodities){
				String[]arr = new String[]{com.getNo(),com.getName(),com.getStyle(),com.getCategory(),com.getQuantity()+"",
						com.getInPrice()+"",com.getOutPrice()+"",com.getWarningQuantity()+""};
				
				model.addRow(arr);
			}
		}
	}catch(Exception e1){
		e1.printStackTrace();
	}
		}
}
