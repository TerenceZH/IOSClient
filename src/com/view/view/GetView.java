package com.view.view;

import java.util.ArrayList;

import javax.swing.JInternalFrame;

public interface GetView {
	
	public JInternalFrame getGetView();
	
	public void handleAddItem(double total,String account,double money,String desc );
	public void handleAdd(String customer,ArrayList<String> list,double money);

}
