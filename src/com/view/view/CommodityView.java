package com.view.view;

import javax.swing.JInternalFrame;

public interface CommodityView {
	public JInternalFrame getCommodityView();
	public void handleAddCommodity(String name,String style,String type,double inprice,double outprice,int warning);
	public void handleModCommodity(String no,double inprice,double outprice,int warning);
	public void handleDelCommodity(String no);

}
