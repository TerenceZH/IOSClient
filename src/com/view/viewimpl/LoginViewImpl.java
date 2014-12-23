package com.view.viewimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.function.MsgDialog;
import com.model.User;
import com.remote_interface.IUserService;
import com.view.gui.LoginGUI;
import com.view.view.LoginView;

public class LoginViewImpl implements LoginView{

	private transient LoginGUI gui;
	private IUserService service;

	
	public LoginViewImpl(IUserService s)throws Exception{
		gui = new LoginGUI();
		gui.addLoginListeners(loginListeners);
		
		service = s;
	}

	
	transient ActionListener submitHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent ev) {
			// TODO Auto-generated method stub
			String username = gui.getUsername();
			String password = gui.getPassword();
			
			login(username, password);
		}
	};
	
	transient ActionListener resetHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent ev) {
			// TODO Auto-generated method stub
			gui.reset();
		}
	};

	transient ActionListener[] loginListeners = {submitHandler,resetHandler};


	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		if(username.length()==0){
			MsgDialog.tip("请输入用户名");
		}else if (password.length()==0) {
			MsgDialog.tip("请输入密码");
		}else {
			try{
				User u = service.getUser(username, password);
				if(u==null){
					MsgDialog.tip("用户名、密码不匹配，请重新输入！");
				}else{
					gui.close();
					getMainView(u);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return false;
	}


	@Override
	public void getMainView(User user) {
		// TODO Auto-generated method stub
		 try {
			new MainViewImpl(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
