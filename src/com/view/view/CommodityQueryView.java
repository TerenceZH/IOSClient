package com.view.view;

import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;

public interface CommodityQueryView {
	public JInternalFrame getCommodityQueryView();
	public void handleQuery(String s,int type,DefaultTableModel model);

}
