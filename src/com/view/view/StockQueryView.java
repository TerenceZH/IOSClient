package com.view.view;

import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;

public interface StockQueryView {
	public JInternalFrame getStockQueryView();
	
	public void handleShow(String stime,String etime,DefaultTableModel model);

}
