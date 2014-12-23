package com.view.viewimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;

import com.function.MsgDialog;
import com.model.Account;
import com.model.Customer;
import com.remote_interface.IAccountService;
import com.view.gui.AccountQueryGUI;
import com.view.view.AccountQueryView;

public class AccountQueryViewImpl implements AccountQueryView{
	
	private AccountQueryGUI gui;
	private IAccountService service;
	
	public AccountQueryViewImpl(IAccountService s)throws Exception{
		service = s;
		gui = new AccountQueryGUI();
		gui.addAccountQueryListener(handler);
	}
	
	public AccountQueryViewImpl(){
		gui = new AccountQueryGUI();
		gui.addAccountQueryListener(handler);
	}
	
transient ActionListener handler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String no = gui.getNo();
			String key = gui.getKeyword();
			
			DefaultTableModel model = (DefaultTableModel)gui.getTable().getModel();
			
			if(no.length()==0&&key.length()==0){
				handleQuery("1", 2, model);
			}else {
				if(no.length()==0){
					handleQuery(key,1 , model);
				}else {
					handleQuery(no, 0, model);
				}
			}
			gui.getTable().validate();
		}
	};

	@Override
	public JInternalFrame getAccountQueryView() {
		// TODO Auto-generated method stub
		return gui;
	}

	@Override
	public void handleQuery(String s, int type, DefaultTableModel model) {
		// TODO Auto-generated method stub
		ArrayList<Account> accounts = new ArrayList<Account>();
		try{
		if(type==0){
			Account a = service.queryAccount(s);
			if(a==null){
				MsgDialog.tip("账户不存在！");
			}else {
				accounts.add(a);
			}
		}else {
			if(type==1){
				accounts = service.queryAccountByKeyword(s);
				if(accounts.size()==0){
					MsgDialog.tip("账户不存在！");
				}
			}else {
				accounts = service.queryAllAccount();
			}
		}
		
		if(accounts.size()!=0){
			for(Account acc:accounts){
				String[]arr = new String[]{acc.getId(),acc.getName(),acc.getMoney()+""};
				model.addRow(arr);
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
