package com.view.viewimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JInternalFrame;

import com.function.MsgDialog;
import com.model.Customer;
import com.remote_interface.ICustomerService;
import com.view.gui.CustomerGUI;
import com.view.view.CustomerView;

public class CustomerViewImpl implements CustomerView{
	
	private CustomerGUI gui;
	private ICustomerService service;
	
	
	
	public CustomerViewImpl(ICustomerService s)throws Exception{
		service = s;
		gui = new CustomerGUI();
		gui.addCustomerListeners(handlers);
	}
	
	
	public CustomerViewImpl(){
		gui = new CustomerGUI();
		gui.addCustomerListeners(handlers);
	}

	
	transient ActionListener addHandler =  new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String name = gui.getCname();
			String address = gui.getAddress();
			String mail = gui.getMail();
			String max = gui.getMax();
			String phone = gui.getPhone();
			String zip = gui.getZip();
			
			int type = gui.getType();
			
			if(name.length()==0){
				MsgDialog.tip("请输入名称!");
			}else if(phone.length()==0){
				MsgDialog.tip("请输入联系方式！");
			}else {
				handleAdd(name, type, phone,address,zip,mail,Double.parseDouble(max));
			}
		}
	};
	
	transient ActionListener resetHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			gui.setNull();
		}
	};
	
	transient ActionListener delHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String no = gui.getNo2();
			
			if(no.length()==0){
				MsgDialog.tip("请输入编号！");
			}else
				handleDel(no);
		}
	};
	
	
	transient ActionListener sortHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String no = gui.getNo2();
			
			handleSort(no);
		}
	};
	
	transient ActionListener sort2Handler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String no = gui.getNo3();
			
			handleSort2(no);
		}
	};
	
	
	transient ActionListener modHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String no = gui.getNo3();
			String name = gui.getCname3();
			String phone = gui.getPhone3();
			String mail = gui.getMail3();
			String max = gui.getMax3();
			String zip = gui.getZip3();
			String address = gui.getAddress3();
			
			if(no.length()==0){
				MsgDialog.tip("请输入编号！");
			}else {
				handleMod(no, name, phone,address,zip,mail,Double.parseDouble(max));
			}
		}
	};
	
	
	
	transient ActionListener[] handlers = {addHandler,resetHandler,sortHandler,delHandler,sort2Handler,modHandler};
	
	
	
	
	
	@Override
	public JInternalFrame getCustomerView() {
		// TODO Auto-generated method stub
		return gui;
	}

	@Override
	public void handleAdd(String name, int type,String p, String a, String z, String m,
			double max) {
		// TODO Auto-generated method stub
		try {
			service.addCustomer(name, type, a,p,z,m,max,MainViewImpl.user.getId());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void handleDel(String no) {
		// TODO Auto-generated method stub
		try {
			service.delCustomer(no, MainViewImpl.user.getId());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void handleMod(String no, String name, String p, String a, String z,
			String m, double max) {
		// TODO Auto-generated method stub
		try {
			service.modCustomer(no, name,a,p,z,m,max,MainViewImpl.user.getId());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void handleSort(String no) {
		// TODO Auto-generated method stub
		if(no.length()==0){
			MsgDialog.tip("请输入编号");
		}else {
			try{
			Customer c = service.queryCustomer(no);
			if(c==null){
				MsgDialog.tip("客户不存在！");
			}else{
				gui.setCname2(c.getName());
			}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}


	@Override
	public void handleSort2(String no) {
		// TODO Auto-generated method stub
		if(no.length()==0){
			MsgDialog.tip("请输入编号");
		}else {
			try{
			Customer c = service.queryCustomer(no);
			if(c==null){
				MsgDialog.tip("客户不存在！");
			}else{
				gui.setCname3(c.getName());
				gui.setPhone3(c.getPhone());
				gui.setAddress3(c.getAddress());
				gui.setMail3(c.getMail());
				gui.setMax3(c.getMax()+"");
				gui.setZip3(c.getZip());
			}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}
