package com.view.view;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public interface SaleDetailView {
	public JInternalFrame getSaleDetailView();
	public void handleShow(String stime,String etime,String comno,String cusno,String bus,String ware,DefaultTableModel model);
	public void handleExport(JTable table);
}
