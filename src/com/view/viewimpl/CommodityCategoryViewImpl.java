package com.view.viewimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.function.MsgDialog;
import com.model.CommodityCategory;
import com.remote_interface.ICommodityService;
import com.view.gui.CommodityCategoryGUI;
import com.view.view.CommodityCategoryView;

public class CommodityCategoryViewImpl implements CommodityCategoryView{
	
	private CommodityCategoryGUI gui;
	private ICommodityService service;
	
	public CommodityCategoryViewImpl(ICommodityService s)throws Exception{
		service = s;
		gui = new CommodityCategoryGUI();
		gui.addCategoryListeners(handlers);
	}
	
	public CommodityCategoryViewImpl(){
		gui = new CommodityCategoryGUI();
		gui.addCategoryListeners(handlers);
	}
	
	transient ActionListener seeTopCatesHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			DefaultTableModel model = (DefaultTableModel)gui.getTable().getModel();		
			
			try {
				ArrayList<CommodityCategory> list = service.queryCategoryByParentNo("000");
				model.setColumnCount(0);
				show(list,model);
				gui.getTable().validate();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	};
	
	transient ActionListener addTopCateHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			DefaultTableModel model = (DefaultTableModel)gui.getTable().getModel();	
			String name = JOptionPane.showInputDialog("���������ƣ�");
			if(name.length()!=0){
				handleAdd("000", name);
				try{
				ArrayList<CommodityCategory> list = service.queryCategoryByParentNo("000");
				model.setColumnCount(0);
				show(list,model);
				gui.getTable().validate();
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		}
	};
	
	transient ActionListener preHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};

	
	transient ActionListener[] handlers = {seeTopCatesHandler,addTopCateHandler,preHandler};
	
	
	
	@Override
	public JInternalFrame getCommodityCategoryView() {
		// TODO Auto-generated method stub
		return gui;
	}	

	@Override
	public void handleNext(String no,DefaultTableModel model) {
		// TODO Auto-generated method stub
		try {
			ArrayList<CommodityCategory> list = service.queryCategoryByParentNo(no);
			model.setColumnCount(0);
			show(list,model);
			gui.getTable().validate();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void handlePreCate(String no) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleMod(String parent, String name) {
		// TODO Auto-generated method stub
		
		if(name.length()!=0){
			try {
				service.modCommodityCategory(name, parent, MainViewImpl.user.getId());
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void handleDel(String no) {
		// TODO Auto-generated method stub
		try {
			service.delCommdoityCategory(no, MainViewImpl.user.getId());
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void handleAdd(String no, String name) {
		// TODO Auto-generated method stub
		try {
			service.addCommodityCategory(name, no, MainViewImpl.user.getId());
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void show(ArrayList<CommodityCategory> list,DefaultTableModel model) {
		// TODO Auto-generated method stub
		if(list.size()==0){
			MsgDialog.tip("�������ӷ��࣡");
		}else {
			for(CommodityCategory cc:list){
				Object[]arr = new Object[4];
				arr[0] = cc.getName();
				JButton modButton = new JButton("�޸�");
				JButton delButton = new JButton("ɾ��");
				JButton addButton = new JButton("���");
				JButton nextButton = new JButton("��һ��");
				
				modButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String name = JOptionPane.showInputDialog("�������޸ĺ�����ƣ�");
						handleMod(cc.getNo(), name);
					}
				});
				
				delButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						handleDel(cc.getNo());
					}
				});
				
				addButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String name = JOptionPane.showInputDialog("�������µ�������ƣ�");
						handleAdd(cc.getNo(), name);
					}
				});
				
				nextButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub	
						handleNext(cc.getNo(),model);
					}
				});
				
				arr[1] = modButton;
				arr[2] = addButton;
				arr[3] = delButton;
				arr[4] = nextButton;
				
				model.addRow(arr);
			}
		}
		
	}

}
