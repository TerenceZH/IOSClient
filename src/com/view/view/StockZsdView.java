package com.view.view;

import javax.swing.JInternalFrame;

public interface StockZsdView {
	public JInternalFrame getStockZsdView();
	public void handleAdd(String cusNo,String comNo,int quantity);
}
