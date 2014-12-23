package com.view.viewimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;

import com.function.MsgDialog;
import com.model.Message;
import com.remote_interface.IUserService;
import com.view.gui.MessageGUI;
import com.view.view.MessageView;

public class MessageViewImpl implements MessageView{
	private MessageGUI gui;
	private IUserService service;
	
	public MessageViewImpl(IUserService s)throws Exception{
		this.service = s;
		
		gui = new MessageGUI();
		gui.addMessageListeners(handlers);
	}
	
	public MessageViewImpl(){
		gui = new MessageGUI();
		gui.addMessageListeners(handlers);
	}
	
	transient ActionListener updateHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			DefaultTableModel model = (DefaultTableModel)gui.getTable().getModel();
			
			handleUpdate(model);
			gui.getTable().validate();
		}
	};
	
	transient ActionListener seeUnreadHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			DefaultTableModel model = (DefaultTableModel)gui.getTable().getModel();
			
			handleUnread(model);
			gui.getTable().validate();
		}
	};

	transient ActionListener[] handlers = {updateHandler,seeUnreadHandler};
	
	
	@Override
	public JInternalFrame getMessageView() {
		// TODO Auto-generated method stub
		return gui;
	}

	@Override
	public void handleUpdate(DefaultTableModel model) {
		// TODO Auto-generated method stub
		model.setColumnCount(0);
		
		try {
			ArrayList<Message> list = service.getMessage(MainViewImpl.user, 0);
			if(list.size()==0){
				MsgDialog.tip("没有消息！");
			}else {
				for(Message m:list){
					Object[] arr = new Object[4];
					arr[0] = m.getTime();
					arr[1] = m.getFrom();
					arr[2] = m.getText();
					JButton jb = new JButton("查看");
					jb.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							MsgDialog.tip(m.getText());
							try {
								service.readMessage(m.getId());
							} catch (RemoteException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					});
					arr[3] = jb;
					
					model.addRow(arr);
				}	
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void handleUnread(DefaultTableModel model) {
		// TODO Auto-generated method stub
		model.setColumnCount(0);
		
		try {
			ArrayList<Message> list = service.getMessage(MainViewImpl.user, 1);
			if(list.size()==0){
				MsgDialog.tip("没有消息！");
			}else {
				for(Message m:list){
					Object[] arr = new Object[4];
					arr[0] = m.getTime();
					arr[1] = m.getFrom();
					arr[2] = m.getText();
					JButton jb = new JButton("查看");
					jb.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							MsgDialog.tip(m.getText());
							try {
								service.readMessage(m.getId());
							} catch (RemoteException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					});
					arr[3] = jb;
					
					model.addRow(arr);
				}	
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
