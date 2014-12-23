package com.view.view;

import javax.swing.JInternalFrame;

public interface ChangePwdView {
	
	public JInternalFrame getChangePwdView();
	public void handleChangePwd(String oldPwd,String newPwd,String newPwd2);

}
