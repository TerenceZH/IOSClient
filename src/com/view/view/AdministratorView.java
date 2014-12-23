package com.view.view;

import javax.swing.JInternalFrame;

public interface AdministratorView {
	public JInternalFrame getAdministratorView();
	public void handleAddUser(String name,String pwd,int type,int auth);
	public void handleModUser(String no,int auth);
}
