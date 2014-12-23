package com.view.view;

import java.util.ArrayList;

import javax.swing.JInternalFrame;

public interface PayView {
	public JInternalFrame getPayView();
	
	public void handleAddItemBtn();
	public void handleAdd(String customer,ArrayList<String> list,double money);
	public void handleAddItem(double total,String account,double money,String desc);
	
	public void handleAddItemBtn2();
	public void handleAdd2(String customer,ArrayList<String> list,double money);
	public void handleAddItem2(double total,String item,double money,String desc);

}
