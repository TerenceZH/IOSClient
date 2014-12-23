package com.view.viewimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;

import com.function.MsgDialog;
import com.model.Log;
import com.remote_interface.ILogService;
import com.view.gui.LogGUI;
import com.view.view.LogView;

public class LogViewImpl implements LogView{
	
	private LogGUI gui;
	private ILogService service;
	
	public LogViewImpl(ILogService s)throws Exception{
		service = s;
		gui = new LogGUI();
		gui.addLogListener(handler);
	}
	
	public LogViewImpl(){
		gui = new LogGUI();
		gui.addLogListener(handler);
	}
	
	transient ActionListener handler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String stime = gui.getStime();
			String etime = gui.getEtime();
			String type = gui.getType();
			
			DefaultTableModel model = (DefaultTableModel)gui.getTable().getModel();
			
			String s[] = {stime,etime,type};
			
			if(stime.length()==0&&etime.length()==0&&type.equals("请选择")){			
				handleShow(s, 0,model);
			}else if(stime.length()==0&&etime.length()==0&&!type.equals("请选择")){
				handleShow(s, 2,model);
			}else if(type.equals("请选择")&&stime.length()!=0&&etime.length()!=0){
				handleShow(s, 1,model);
			}else if(!(stime.length()==0||etime.length()==0||type.equals("请选择"))){
				handleShow(s, 3, model);
			}else {
				MsgDialog.tip("时间填写完整！");
			}
			
			gui.getTable().validate();
		}
	};

	@Override
	public JInternalFrame getLogView() {
		// TODO Auto-generated method stub
		return gui;
	}

	@Override
	public void handleShow(String[] s, int type,DefaultTableModel model) {
		// TODO Auto-generated method stub
		ArrayList<Log> list = new ArrayList<Log>();
		try{
		if(type==0){
			list  = service.queryLog();
		}else if(type==1){
			list = service.queryLog(s[0], s[1]);
		}else if (type==2) {
			list = service.queryLog(s[2]);
		}else if(type==3){
			list = service.queryLog(s[0], s[1],s[2]);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(list.size()==0){
			MsgDialog.tip("不存在日志！");
		}else{
			for(Log l:list){
				String[]arr = {l.getType(),l.getTime(),l.getDesc(),l.getOperatorNo()};
				model.addRow(arr);
			}
		}
			
		
		
	}

}
