package com.view.view;

import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;

public interface AccountQueryView {

	public JInternalFrame getAccountQueryView();
	public void handleQuery(String s,int type,DefaultTableModel model);
}
