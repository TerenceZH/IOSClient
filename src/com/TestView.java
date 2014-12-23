package com;

import com.model.User;
import com.view.gui.LoginGUI;
import com.view.viewimpl.MainViewImpl;

public class TestView {
	public static void main(String[] args) {
		new MainViewImpl(new User("001","11","123",4,0));
	}

}
