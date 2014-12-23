package com.view.viewimpl;

import javax.swing.JInternalFrame;

import com.view.gui.InitAccountGUI;
import com.view.view.InitAccountView;

public class InitAccountViewImpl implements InitAccountView{
	private InitAccountGUI gui;
	
	public InitAccountViewImpl(){
		gui = new InitAccountGUI();
	}

	@Override
	public JInternalFrame getInitAccountView() {
		// TODO Auto-generated method stub
		return gui;
	}

}
