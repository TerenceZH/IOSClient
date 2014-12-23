package com.view.view;

import javax.swing.JInternalFrame;

public interface AccountView {
	public JInternalFrame getAccountView();
	public void handleAdd(String name,double money);
	public void handleReset();
	public void handleSort(String no);
	public void handleMod(String no,String name);
}
