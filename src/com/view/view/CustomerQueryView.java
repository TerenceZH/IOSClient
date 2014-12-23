package com.view.view;

import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;

public interface CustomerQueryView {
	public JInternalFrame getCustomerQueryView();
	public void handleQuery(String s,int type,DefaultTableModel model);
}
