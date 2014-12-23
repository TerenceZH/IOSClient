package com.view.viewimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JInternalFrame;

import com.function.Common;
import com.function.MsgDialog;
import com.model.Commodity;
import com.model.ImportBill;
import com.model.PortBillItem;
import com.remote_interface.IImportService;
import com.view.gui.ImportBIllGUI;
import com.view.gui.PortBillItemGUI;
import com.view.view.ImportBillView;

public class ImportBillViewImpl implements ImportBillView{
	private IImportService service;
	private ImportBIllGUI gui;
	private PortBillItemGUI gui2;
	
	private ArrayList<String> list = new ArrayList<String>();
	
	public ImportBillViewImpl(IImportService s)throws Exception{
		service = s;
		gui = new ImportBIllGUI();
		gui.addImportListeners(handlers);
		/*gui2 = new PortBillItemGUI();
		gui2.setVisible(false);
		gui2.addPortBillItemListeners(handlers2);*/
	}
	
	public ImportBillViewImpl(){
		gui = new ImportBIllGUI();
		gui.addImportListeners(handlers);
		/*gui2 = new PortBillItemGUI();
		gui2.setVisible(false);
		gui2.addPortBillItemListeners(handlers2);*/
	}

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
			String desc = gui.getDesc();
			
			if(no.length()==0){
				MsgDialog.tip("请输入编号！");
			}else if(list.size()==0){
				MsgDialog.tip("请添加商品！");
			}else {
				handleAdd(no, warehouse, Double.parseDouble(total), desc);
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
			
			if(no.length()==0){
				MsgDialog.tip("请输入编号！");
			}else if (quantity.length()==0) {
				MsgDialog.tip("请输入数量!");
			}else {
				handleAdd2(no, Integer.parseInt(quantity),Double.parseDouble(total));
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
	public JInternalFrame getImportBillView() {
		// TODO Auto-generated method stub
		return gui;
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
	public void handleAdd2(String no, int quantity,double total) {
		// TODO Auto-generated method stub
		try{
			Commodity c = service.getCommodity(no);
			if(c==null){
				MsgDialog.tip("商品不存在！");
			}else {
				String s = no+" "+c.getName()+" "+c.getStyle()+" 数量: "+quantity+" 单价: "+c.getInPrice()+" 总价: "+quantity*c.getInPrice()+";";
				gui.addToInfo(s);
				gui.addToInfo("\n");
				gui.setTotal(total+quantity*c.getInPrice()+"");
				String in = no+","+quantity+","+c.getInPrice()+","+c.getInPrice()*quantity;
				list.add(in);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void handleAdd(String cusno, String warehouse,double total, String desc) {
		// TODO Auto-generated method stub
		try {
			service.addImportBill( cusno, warehouse, MainViewImpl.user.getId(), list, total, desc, Common.time());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void handleSort(String no) {
		// TODO Auto-generated method stub
		try{
			ImportBill bill = service.getImportBill(no);
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
			service.addImportBackBill(no, MainViewImpl.user.getId(), desc, Common.time());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
