package com.view.viewimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JInternalFrame;

import com.function.Common;
import com.function.MsgDialog;
import com.remote_interface.IUserService;
import com.view.gui.AdministratorGUI;
import com.view.view.AdministratorView;

public class AdministratorViewImpl implements AdministratorView{
	private IUserService service;
	private AdministratorGUI gui;
	
	public AdministratorViewImpl(IUserService s) throws Exception{
		gui = new AdministratorGUI();
		gui.addAdministratorListeners(handlers);
		
		service  = s;
	}
	
	public AdministratorViewImpl(){
		gui = new AdministratorGUI();
//		gui.setBounds(0, 0, 200, 200);
		gui.addAdministratorListeners(handlers);
	}
	
	transient ActionListener addHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String name = gui.getUName();
			String password = gui.getPwd();
			String type = gui.getType();
			int authority = gui.getTopAuth();
			
			int typeInt = Common.getType(type);
			
			handleAddUser(name, password, typeInt,authority);
		}
	};
	
	
	transient ActionListener modHandler  = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String no = gui.getNo();
			int auth = gui.getTopAuth2();
			
			handleModUser(no, auth);
		}
	};
	
	transient ActionListener [] handlers = {addHandler,modHandler};

	@Override
	public JInternalFrame getAdministratorView() {
		// TODO Auto-generated method stub
		return gui;
	}

	@Override
	public void handleAddUser(String name, String pwd, int type, int auth) {
		// TODO Auto-generated method stub
		if(name.length()==0||pwd.length()==0){
			MsgDialog.tip("用户名或者密码不能为空！");
		}else {
			try {
				service.addUser(name, pwd, type, auth,MainViewImpl.user.getId());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void handleModUser(String no, int auth) {
		// TODO Auto-generated method stub
		if(no.length()==0){
			MsgDialog.tip("请输入编号！");
		}else {
			try {
				service.modUser(no,auth,MainViewImpl.user.getId());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
