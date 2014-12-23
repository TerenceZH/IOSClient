package com.view.view;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public interface SaleLichengView {
	public JInternalFrame getSaleLichengView();
	public void handleShow(String stime,String etime,String cusno,int type,String ware,String bus,DefaultTableModel model);
}
