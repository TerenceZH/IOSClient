package com.view.viewimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;

import com.function.MsgDialog;
import com.model.Customer;
import com.remote_interface.ICustomerService;
import com.view.gui.CustomerQueryGUI;
import com.view.view.CustomerQueryView;

public class CustomerQueryViewImpl implements CustomerQueryView{
	private ICustomerService service;
	private CustomerQueryGUI gui;
	
	public CustomerQueryViewImpl(ICustomerService s)throws Exception{
		service  = s;
		gui = new CustomerQueryGUI();
		gui.addCustomerQueryListener(handler);
	}
	
	public CustomerQueryViewImpl(){
		gui = new CustomerQueryGUI();
		gui.addCustomerQueryListener(handler);
	}
	
	transient ActionListener handler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String no = gui.getNo();
			String key = gui.getKeyword();
			
			DefaultTableModel model = (DefaultTableModel)gui.getTable().getModel();
			
			if(no.length()==0&&key.length()==0){
				handleQuery("1", 2, model);
			}else {
				if(no.length()==0){
					handleQuery(key,1 , model);
				}else {
					handleQuery(no, 0, model);
				}
			}
			gui.getTable().validate();
		}
	};

	@Override
	public JInternalFrame getCustomerQueryView() {
		// TODO Auto-generated method stub
		return gui;
	}

	@Override
	public void handleQuery(String s, int type, DefaultTableModel model) {
		// TODO Auto-generated method stub
		ArrayList<Customer> customers = new ArrayList<Customer>();
		try{
		if(type==0){
			Customer c = service.queryCustomer(s);
			if(c==null){
				MsgDialog.tip("客户不存在！");
			}else {
				customers.add(c);
			}
		}else {
			if(type==1){
				customers = service.queryCustomerByKeyword(s);
				if(customers.size()==0){
					MsgDialog.tip("客户不存在！");
				}
			}else {
				customers = service.queryAllCustomer();
			}
		}
		
		if(customers.size()!=0){
			for(Customer cus:customers){
				String[]arr = new String[]{cus.getNo(),cus.getName(),cus.getType()==0?"进货商":"销售商",cus.getLevel()+"",
						cus.getPoint()+"",cus.getPhone(),cus.getAddress(),cus.getZip(),cus.getMail(),cus.getMax()+"",
						cus.getBusinessmanNo()};
				model.addRow(arr);
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
