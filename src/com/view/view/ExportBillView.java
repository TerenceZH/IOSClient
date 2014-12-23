package com.view.view;

import javax.swing.JInternalFrame;

public interface ExportBillView {
	public JInternalFrame getExportBillView();
	
	public void handleAdd(String cusno,String warehouse,String detail,double total,double discount,double djq,double total2,String desc);
	public void handleSort(String no);
	public void handleAddCancel(String no,String desc);
	
	public void handleSort2(String no);
	public void handleAdd2(String cusNo,String no,int quantity,double total,double total2);

}
