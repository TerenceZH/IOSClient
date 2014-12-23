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
import com.view.gui.GetGUI;
import com.view.view.GetView;

public class GetViewImpl implements GetView{
	private IAccountService service;
	private GetGUI gui;
	private AccountItem gui2;
	private ArrayList<String> infoList = new ArrayList<String>();

	public GetViewImpl(IAccountService s)throws RemoteException{
		service = s;
		gui = new GetGUI();
		gui.addListeners(handlers);
	}
	
	public GetViewImpl(){
		gui = new GetGUI();
		gui.addListeners(handlers);
	}
	
	transient ActionListener additembtn = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			gui2 = new AccountItem();
			gui2.addListener(addItemHandler);
			gui2.setVisible(true);
		}
	};
	
	transient ActionListener addItemHandler = new ActionListener() {
		
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
	
	transient ActionListener addHandler  = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
	transient ActionListener [] handlers = {addItemHandler,addHandler};

	@Override
	public JInternalFrame getGetView() {
		// TODO Auto-generated method stub
		return gui;
	}

	@Override
	public void handleAddItem(double total, String account, double money,
			String desc) {
		// TODO Auto-generated method stub
		String info  = "\n"+"账户："+account+"金额："+money+"备注："+desc;
		String s  = account+"$"+money+"$"+desc;
		gui.setInfo(info);
		gui.setMoney(total+money+"");
		infoList.add(s);
		gui2.dispose();
	}

	@Override
	public void handleAdd(String customer, ArrayList<String> list, double money) {
		// TODO Auto-generated method stub
		try {
			service.addGetBill(customer, Common.time(), MainViewImpl.user.getId(), list);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
