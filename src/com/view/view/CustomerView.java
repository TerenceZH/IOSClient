package com.view.view;

import javax.swing.JInternalFrame;

public interface CustomerView {
	public JInternalFrame getCustomerView();
	public void handleAdd(String name,int type,String p,String a,String z,String m,double max);
	public void handleDel(String no);
	public void handleMod(String no,String name,String p,String a,String z,String m,double max);
	public void handleSort(String no);
	public void handleSort2(String no);
}
