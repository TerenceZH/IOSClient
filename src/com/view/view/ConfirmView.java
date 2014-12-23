package com.view.view;

import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;

public interface ConfirmView {
	public JInternalFrame getConfirmView();
	public void  handleShow(DefaultTableModel model);
	public void handleConfirm(String no);
}
