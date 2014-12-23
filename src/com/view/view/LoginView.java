package com.view.view;

import java.rmi.Remote;

import com.model.User;

public interface LoginView extends Remote{

	public boolean login(String uname, String password);
	
	public void getMainView(User user);
}