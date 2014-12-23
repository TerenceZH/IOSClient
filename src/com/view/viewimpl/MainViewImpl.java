package com.view.viewimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;

import com.function.Common;
import com.model.User;
import com.view.gui.MainGUI;
import com.view.view.MainView;

public class MainViewImpl implements MainView{
	private MainGUI gui;
	
	public static User user;

	public MainViewImpl(User user){
		this.user = user;
		String power =  Common.getType(user.getType());
		gui = new MainGUI(user.getUsername(),power,user.getType(),user.getGetTopAuthority());
		gui.addMainListeners(listeners);
	}
	
	transient ActionListener listener1 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JInternalFrame view = new CommodityViewImpl().getCommodityView();
			gui.getContentPane().add(view);
			view.setVisible(true);
		}
	};
	
transient ActionListener listener2 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JInternalFrame view = new CommodityCategoryViewImpl().getCommodityCategoryView();
			gui.getContentPane().add(view);
			view.setVisible(true);
		}
	};
	
transient ActionListener listener3 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JInternalFrame view = new CustomerViewImpl().getCustomerView();
			gui.getContentPane().add(view);
			view.setVisible(true);
		}
	};
	
transient ActionListener listener4 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JInternalFrame view = new AccountViewImpl().getAccountView();
			gui.getContentPane().add(view);
			view.setVisible(true);
		}
	};
	
transient ActionListener listener5 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JInternalFrame view = new ImportBillViewImpl().getImportBillView();
			gui.getContentPane().add(view);
			view.setVisible(true);
		}
	};
	
transient ActionListener listener6 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JInternalFrame view = new ExportBillViewImpl().getExportBillView();
			gui.getContentPane().add(view);
			view.setVisible(true);
		}
	};
	
transient ActionListener listener7 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JInternalFrame view = new StockBydViewImpl().getStockBydView();
			gui.getContentPane().add(view);
			view.setVisible(true);
		}
	};
	
transient ActionListener listener8 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JInternalFrame view = new StockBsdViewImpl().getStockBsdView();
			gui.getContentPane().add(view);
			view.setVisible(true);
		}
	};
	
transient ActionListener listener9 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JInternalFrame view = new StockZsdViewImpl().getStockZsdView();
			gui.getContentPane().add(view);
			view.setVisible(true);
		}
	};
	
transient ActionListener listener10 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JInternalFrame view = new StockBjdViewImpl().getStockBjdView();
			gui.getContentPane().add(view);
			view.setVisible(true);
		}
	};
	
transient ActionListener listener11 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JInternalFrame view = new CommodityQueryViewImpl().getCommodityQueryView();
			gui.getContentPane().add(view);
			view.setVisible(true);
		}
	};
	
transient ActionListener listener12 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JInternalFrame view = new StockQueryViewImpl().getStockQueryView();
			gui.getContentPane().add(view);
			view.setVisible(true);
		}
	};
	
transient ActionListener listener13 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JInternalFrame view = new StockPandianViewImpl().getStockPandianView();
			gui.getContentPane().add(view);
			view.setVisible(true);
		}
	};
	
transient ActionListener listener14 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JInternalFrame view = new CustomerQueryViewImpl().getCustomerQueryView();
			gui.getContentPane().add(view);
			view.setVisible(true);
		}
	};
	
transient ActionListener listener15 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JInternalFrame view = new AccountQueryViewImpl().getAccountQueryView();
			gui.getContentPane().add(view);
			view.setVisible(true);
		}
	};
	
transient ActionListener listener16 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
transient ActionListener listener17 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
transient ActionListener listener18 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
transient ActionListener listener19 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JInternalFrame view = new LogViewImpl().getLogView();
			gui.getContentPane().add(view);
			view.setVisible(true);
		}
	};
	
transient ActionListener listener20 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
transient ActionListener listener21 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JInternalFrame view = new ConfirmViewImpl().getConfirmView();
			gui.getContentPane().add(view);
			view.setVisible(true);
		}
	};
	
transient ActionListener listener22 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JInternalFrame view = new InitAccountViewImpl().getInitAccountView();
			gui.getContentPane().add(view);
			view.setVisible(true);
		}
	};
	
transient ActionListener listener23 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JInternalFrame view = new MessageViewImpl().getMessageView();
			gui.getContentPane().add(view);
			view.setVisible(true);
		}
	};
	
transient ActionListener listener24 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JInternalFrame view = new ChangePwdViewImpl().getChangePwdView();
			gui.getContentPane().add(view);
			view.setVisible(true);
		}
	};
	
transient ActionListener listener25 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			JInternalFrame view = new AdministratorViewImpl().getAdministratorView();
			gui.getContentPane().add(view);
			view.setVisible(true);
		}
	};
	
transient ActionListener listener26 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
	};
	
	transient ActionListener [] listeners = {listener1,listener2,listener3,listener4,listener5
			,listener6,listener7,listener8,listener9,listener10,listener11,listener12,listener13,listener14,
			listener15,listener16,listener17,listener18,listener19,listener20,listener21,
			listener22,listener23,listener24,listener25,listener26};
}
