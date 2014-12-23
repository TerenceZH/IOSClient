package com.view.view;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public interface MessageView {

	public JInternalFrame getMessageView();
	public void handleUpdate(DefaultTableModel model);
	public void handleUnread(DefaultTableModel model);
}
