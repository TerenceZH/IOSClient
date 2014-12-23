package com.view.view;

import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;

public interface LogView {
	public JInternalFrame getLogView();
	public void handleShow(String []s,int type,DefaultTableModel model);

}
