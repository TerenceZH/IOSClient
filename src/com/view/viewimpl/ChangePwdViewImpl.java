package com.view.viewimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JInternalFrame;

import com.function.MsgDialog;
import com.remote_interface.IUserService;
import com.view.gui.ChangePwdGUI;
import com.view.view.ChangePwdView;

public class ChangePwdViewImpl implements ChangePwdView{
	
	private ChangePwdGUI gui;
	private IUserService service;
	
	public ChangePwdViewImpl(IUserService s)throws Exception{
		this.service = s;
		
		gui = new ChangePwdGUI();
		gui.addChangePwdListener(handler);
	}
	
	public ChangePwdViewImpl(){
		gui = new ChangePwdGUI();
		gui.addChangePwdListener(handler);
	}
	
	transient ActionListener handler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String old = gui.getOldPwd();
			String new1 = gui.getNewPwd();
			String new2 = gui.getNewPwd2();
			
			handleChangePwd(old, new1,new2);
		}
	};

	@Override
	public JInternalFrame getChangePwdView() {
		// TODO Auto-generated method stub
		return gui;
	}

	@Override
	public void handleChangePwd(String oldPwd, String newPwd,String newPwd2) {
		// TODO Auto-generated method stub
		if(oldPwd.length()==0||newPwd.length()==0||newPwd2.length()==0){
			MsgDialog.tip("����д������Ϣ��");
		}else if(!newPwd.equals(newPwd2)) {
			MsgDialog.tip("���������벻һ�£�");
		}else if(newPwd.equals(oldPwd)){
			MsgDialog.tip("�����벻�ܺ;�������ͬ��");
		}else if(!MainViewImpl.user.getPassword().equals(oldPwd)){
			MsgDialog.tip("�������������");
		}else {
			try {
				service.modifyPassword(MainViewImpl.user, newPwd);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
