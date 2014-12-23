package com.view.viewimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JInternalFrame;

import com.function.Common;
import com.function.MsgDialog;
import com.remote_interface.IAccountService;
import com.view.gui.AccountItem;
import com.view.gui.AccountItem2;
import com.view.gui.PayGUI;
import com.view.view.PayView;

public class PayViewImpl implements PayView{
	private PayGUI gui;
	private AccountItem gui2;
	private AccountItem2 gui3;
	
	private ArrayList<String> infoList = new ArrayList<String>();
	private ArrayList<String> infoList2 = new ArrayList<String>();
	
	private IAccountService service;
	
	public PayViewImpl(IAccountService s)throws Exception{
		service = s;
		gui = new PayGUI();
		gui.addPayListeners(handlers);
	}
	
	public PayViewImpl(){
		gui = new PayGUI();
		gui.addPayListeners(handlers);
	}
	
	transient ActionListener addItemHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			handleAddItemBtn();
		}
	};
	
	transient ActionListener addHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String customer = gui.getCusNo();
			String money = gui.getMoney();
			
			if(customer.length()==0){
				MsgDialog.tip("请输入客户编号");
			}else if(infoList.size()==0){
				MsgDialog.tip("请添加账单");
			}else {
				handleAdd(customer, infoList, Double.parseDouble(money));
			}
			
		}
	};
	
	transient ActionListener addItemConfirmHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String account = gui2.getAccount();
			String money = gui2.getMoney();
			String desc = gui2.getDesc();
			String total = gui.getMoney();
			
			if(account.length()==0||money.length()==0){
				MsgDialog.tip("请输入完整信息！");
			}else {
				handleAddItem(Double.parseDouble(total),account,Double.parseDouble(money),desc);
			}
		}
	};
	
	
transient ActionListener addItemHandle2r = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			handleAddItemBtn2();
		}
	};
	
	transient ActionListener addHandler2 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String account = gui.getAccount2();
			String money = gui.getMoney2();
			
			if(account.length()==0){
				MsgDialog.tip("请输入账户编号");
			}else if(infoList2.size()==0){
				MsgDialog.tip("请添加条目");
			}else {
				handleAdd2(account, infoList2, Double.parseDouble(money));
			}
			
		}
	};
	
	transient ActionListener addItemConfirmHandler2 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String item = gui3.getItem();
			String money = gui3.getMoney();
			String desc = gui3.getDesc();
			String total = gui.getMoney2();
			
			if(item.length()==0||money.length()==0){
				MsgDialog.tip("请输入完整信息！");
			}else {
				handleAddItem2(Double.parseDouble(total), item, Double.parseDouble(money), desc);
			}
		}
	};
	
	transient ActionListener[] handlers = {addItemHandler,addHandler,addItemHandle2r,addHandler2};

	@Override
	public JInternalFrame getPayView() {
		// TODO Auto-generated method stub
		return gui;
	}

	@Override
	public void handleAddItemBtn() {
		// TODO Auto-generated method stub
		gui2 = new AccountItem();
		gui2.addListener(addItemConfirmHandler);
		gui2.setVisible(true);
	}

	@Override
	public void handleAdd(String customer,ArrayList<String> list,double money) {
		// TODO Auto-generated method stub
		try {
			service.addPayBill(customer, Common.time(), MainViewImpl.user.getId(), list);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void handleAddItem(double total,String account,double money,String desc) {
		// TODO Auto-generated method stub
		String info  = "\n"+"账户："+account+"金额："+money+"备注："+desc;
		String s  = account+"$"+money+"$"+desc;
		gui.setInfo(info);
		gui.setMoney(total+money+"");
		infoList.add(s);
		gui2.dispose();
	}

	@Override
	public void handleAddItemBtn2() {
		// TODO Auto-generated method stub
		gui3 = new AccountItem2();
		gui3.addListener(addItemConfirmHandler2);
		gui3.setVisible(true);
	}

	@Override
	public void handleAdd2(String account,ArrayList<String> list,double money) {
		// TODO Auto-generated method stub
		try {
			service.addCashPayBill(account, Common.time(), MainViewImpl.user.getId(), list);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void handleAddItem2(double total,String item,double money,String desc) {
		// TODO Auto-generated method stub
		String info  = "\n"+"条目："+item+"金额："+money+"备注："+desc;
		String s  = item+"$"+money+"$"+desc;
		gui.setInfo2(info);
		gui.setMoney2(total+money+"");
		infoList2.add(s);
		gui3.dispose();
	}
	

}
