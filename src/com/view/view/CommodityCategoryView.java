package com.view.view;

import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;

import com.model.CommodityCategory;

public interface CommodityCategoryView {
	public JInternalFrame getCommodityCategoryView();
	public void handlePreCate(String no);
	public void handleAdd(String parent,String name);
	public void handleDel(String no);
	public void handleMod(String no,String name);
	public void show(ArrayList<CommodityCategory> list,DefaultTableModel model);
	public void handleNext(String no,DefaultTableModel model);
}
