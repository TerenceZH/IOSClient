package com.view.view;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public interface SaleAccountView {
	public JInternalFrame getSaleAccountView();
	public void handleShow(String stime,String etime,DefaultTableModel model);
	public void handleExport(JTable table);

}
