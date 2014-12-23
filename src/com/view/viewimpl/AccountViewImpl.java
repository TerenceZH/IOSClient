package com.view.viewimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JInternalFrame;

import com.function.Common;
import com.function.MsgDialog;
import com.model.Account;
import com.remote_interface.IAccountService;
import com.view.gui.AccountGUI;
import com.view.view.AccountView;

public class AccountViewImpl implements AccountView{
	
	private AccountGUI gui;
	private IAccountService service;
	
	public AccountViewImpl(IAccountService s)throws Exception{
		service = s;
		gui = new AccountGUI();
		gui.addAccountListeners(handlers);
	}
	
	public AccountViewImpl(){
		gui = new AccountGUI();
		gui.addAccountListeners(handlers);
	}
	
	transient ActionListener addHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String name = gui.getAname();
			String money = gui.getMoney();
			
			if(name.length()==0){
				MsgDialog.tip("名称不能为空！");
			}else if(money.length()==0){
				MsgDialog.tip("请输入金额！");
			}else
				handleAdd(name, Double.parseDouble(money));
		}
	};
	
	transient ActionListener resetHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			gui.setNull();
		}
	};
	
	transient ActionListener sortHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String no = gui.getNo3();
			
			if(no.length()==0){
				MsgDialog.tip("请输入编号！");
			}else {
				handleSort(no);
			}
		}
	};
	
	transient ActionListener modHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String no = gui.getNo3();
			String name = gui.getAname3();
			
			if(no.length()==0){
				MsgDialog.tip("请输入编号！");
			}else if(name.length()==0){
				MsgDialog.tip("请输入名称！");
			}else {
				handleMod(no, name);
			}
		}
	};

	
	transient ActionListener[] handlers = {addHandler,resetHandler,sortHandler,modHandler};
	
	
	@Override
	public JInternalFrame getAccountView() {
		// TODO Auto-generated method stub
		return gui;
	}

	@Override
	public void handleAdd(String name, double money) {
		// TODO Auto-generated method stub
		try {
			service.addAccount(name, money, Common.time(), MainViewImpl.user.getId());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void handleReset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleSort(String no) {
		// TODO Auto-generated method stub
		try{
		Account a = service.queryAccount(no);
		if(a==null){
			MsgDialog.tip("账户不存在！");
		}else {
			gui.setAname(a.getName());
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void handleMod(String no, String name) {
		// TODO Auto-generated method stub
		try {
			service.modAccount(no, name, MainViewImpl.user.getId());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
