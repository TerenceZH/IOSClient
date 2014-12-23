package com.view.view;

import javax.swing.JInternalFrame;

public interface ImportBillView {
	public JInternalFrame getImportBillView();
	
	public void handleAdd(String cusno,String warehouse,double total,String desc);
	public void handleSort(String no);
	public void handleAddCancel(String no,String desc);
	
	public void handleSort2(String no);
	public void handleAdd2(String no,int quantity,double total);

}
