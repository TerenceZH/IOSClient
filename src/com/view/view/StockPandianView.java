package com.view.view;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public interface StockPandianView {
	public JInternalFrame getStockPandianView();
	
	public void handleExport(JTable table);
	public void handlePandian(DefaultTableModel model);

}
