package com.view.viewimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JInternalFrame;

import com.function.Common;
import com.function.MsgDialog;
import com.model.Commodity;
import com.model.ExportBill;
import com.model.PortBillItem;
import com.remote_interface.IExportService;
import com.view.gui.ExportBillGUI;
import com.view.gui.PortBillItemGUI;
import com.view.view.ExportBillView;

public class ExportBillViewImpl implements ExportBillView{
	private IExportService service;
	private ExportBillGUI gui;
	private PortBillItemGUI gui2;
	
	private ArrayList<String> list = new ArrayList<String>();

	@Override
	public JInternalFrame getExportBillView() {
		// TODO Auto-generated method stub
		return gui;
	}
	
	public ExportBillViewImpl(IExportService s)throws Exception{
		service = s;
		gui = new ExportBillGUI();
		gui.addImportListeners(handlers);
		gui.addDjqListener(djqListener);
		/*gui2 = new PortBillItemGUI();
		gui2.setVisible(false);
		gui2.addPortBillItemListeners(handlers2);*/
	}
	
	public ExportBillViewImpl(){
		gui = new ExportBillGUI();
		gui.addImportListeners(handlers);
		gui.addDjqListener(djqListener);
		/*gui2 = new PortBillItemGUI();
		gui2.setVisible(false);
		gui2.addPortBillItemListeners(handlers2);*/
	}
	
	
	transient FocusListener djqListener = new FocusListener() {
		
		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			double total = Double.parseDouble(gui.getTotal());
			double discount = Double.parseDouble(gui.getDiscount());
			double djq = (double)e.getSource();
			gui.setTotal2(total-discount-djq+"");
		}
		
		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
	transient ActionListener addItemHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			gui2 = new PortBillItemGUI();
			gui2.addPortBillItemListeners(handlers2);
			gui2.setVisible(true);
		}
	};
	
	transient ActionListener addHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String no = gui.getCusNo();
			String warehouse = gui.getWare();
			String total = gui.getTotal();
			String discount = gui.getDiscount();
			String djq = gui.getDjq();
			String total2 = gui.getTotal2();
			String desc = gui.getDesc();
			
			if(no.length()==0){
				MsgDialog.tip("请输入编号！");
			}else if(list.size()==0){
				MsgDialog.tip("请添加商品！");
			}else {
				handleAdd(no, warehouse,  Double.parseDouble(total), Double.parseDouble(discount),Double.parseDouble(djq),Double.parseDouble(total2),desc);
			}
			
		}
	};
	
	transient ActionListener resetHandler = new ActionListener() {
		
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
				handleSort(no);
			}
		}
	};
	
	transient ActionListener addCancelHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String no = gui.getNo2();
			String desc = gui.getDesc2();
			
			if(no.length()==0){
				MsgDialog.tip("请输入编号！");
			}else {
				handleAddCancel(no, desc);
			}
		}
	};
	
	
	transient ActionListener[] handlers = {addItemHandler,addHandler,resetHandler,sortHandler,addCancelHandler};
	
transient ActionListener sortHandler2 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String no = gui2.getComNo();
			if(no.length()==0){
				MsgDialog.tip("请输入编号！");
			}else {
				handleSort2(no);
			}
		}
	};
	
	transient ActionListener addhandler2 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String no = gui2.getComNo();
			String quantity = gui2.getQuantity();
			String total = gui.getTotal();
			String total2 = gui.getTotal2();
			
			String cusno = gui.getCusNo();
			
			if(no.length()==0){
				MsgDialog.tip("请输入编号！");
			}else if (quantity.length()==0) {
				MsgDialog.tip("请输入数量!");
			}else {
				handleAdd2(cusno,no, Integer.parseInt(quantity),Double.parseDouble(total),Double.parseDouble(total2));
			}
		}
	};
	
	transient ActionListener cancelHandler2 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			gui2.dispose();
		}
	};
	
	transient ActionListener [] handlers2 = {sortHandler2,addhandler2,cancelHandler2};
	
	
	
	

	@Override
	public void handleAdd(String cusno, String warehouse, 
			double total, double discount, double djq, double total2,
			String desc) {
		// TODO Auto-generated method stub
		try {
			service.addExportBill(cusno, warehouse, MainViewImpl.user.getId(), list, total, discount, djq, total2, desc, Common.time());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void handleSort(String no) {
		// TODO Auto-generated method stub
		try{
			ExportBill bill = service.getExportBill(no);
			if(bill==null){
				MsgDialog.tip("不存在！");
			}else {
				ArrayList<PortBillItem> list = service.getBillItem(no);
				String s = "";
				for(PortBillItem item:list){
					s+= item.getCommodityNo()+" "+item.getPrice()+" "+item.getQuantity()+" "+item.getTotal()+" ;\n";
				}
				gui.setInfo(bill.getCustomerNo(), bill.getTime(),bill.getDesc(),s);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void handleAddCancel(String no, String desc) {
		// TODO Auto-generated method stub
		try {
			service.addExportBackBill(no, MainViewImpl.user.getId(), desc, Common.time());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void handleSort2(String no) {
		// TODO Auto-generated method stub
		try{
			Commodity c = service.getCommodity(no);
			if(c==null){
				MsgDialog.tip("商品不存在！");
			}else {
				gui2.setInfo(c.getName(),c.getStyle(),c.getInPrice()+"");
			}
			}catch(Exception e){
				e.printStackTrace();
			}
	}

	@Override
	public void handleAdd2(String cusNo,String no, int quantity, double total,double total2) {
		// TODO Auto-generated method stub
		try{
			Commodity c = service.getCommodity(no);
			if(c==null){
				MsgDialog.tip("商品不存在！");
			}else {
				String s = no+" "+c.getName()+" "+c.getStyle()+" 数量: "+quantity+" 单价: "+c.getOutPrice()+" 总价: "+quantity*c.getOutPrice()+";";
				gui.addToInfo(s);
				gui.addToInfo("\n");
				gui.setTotal(total+quantity*c.getInPrice()+"");
				double dis = service.getDiscount(cusNo);
				gui.setDiscount((total+quantity*c.getInPrice())*(10-dis)/10+"");
				gui.setTotal2(total2-(total+quantity*c.getInPrice())*(10-dis)/10+"");
				String in = no+","+quantity+","+c.getInPrice()+","+c.getOutPrice()*quantity;
				list.add(in);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
