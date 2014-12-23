package com.view.gui;

import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;

public class CustomerGUI extends JInternalFrame {
	public CustomerGUI(){
		initComponents();
	}
	
	public void addCustomerListeners(ActionListener []a){
		if(a.length!=6){
			return;
		}
		
		jButton1.addActionListener(a[0]);
		jButton2.addActionListener(a[1]);
		jButton3.addActionListener(a[2]);
		jButton4.addActionListener(a[3]);
		jButton5.addActionListener(a[4]);
		jButton6.addActionListener(a[5]);
	}
	
	public String getCname(){
		return jTextField1.getText().trim();
	}
	
	public String getPhone(){
		return jTextField2.getText().trim();
	}
	
	public String getAddress(){
		return jTextField3.getText().trim();
	}
	
	public String getZip(){
		return jTextField4.getText().trim();
	}
	
	public String getMail(){
		return jTextField5.getText().trim();
	}
	
	public String getMax(){
		return jTextField6.getText().trim();
	}
	
	public String getNo2(){
		return jTextField7.getText().trim();
	}
	
	public void setCname2(String s){
		jTextField8.setText(s);
	}
	
	public String getNo3(){
		return jTextField9.getText().trim();
	}
	
	public String getCname3(){
		return jTextField10.getText().trim();
	}
	
	public String getPhone3(){
		return jTextField11.getText().trim();
	}
	
	public String getAddress3(){
		return jTextField12.getText().trim();
	}
	
	public String getZip3(){
		return jTextField13.getText().trim();
	}
	
	public String getMail3(){
		return jTextField14.getText().trim();
	}
	
	public String getMax3(){
		return jTextField15.getText().trim();
	}
	
	
	public void setCname3(String s){
		jTextField10.setText(s);
	}
	
	public void setPhone3(String s){
		jTextField11.setText(s);
	}
	
	public void setAddress3(String s){
		jTextField12.setText(s);
	}
	
	public void setZip3(String s){
		jTextField13.setText(s);
	}
	
	public void setMail3(String s){
		jTextField14.setText(s);
	}
	
	public void setMax3(String s){
		jTextField15.setText(s);
	}
	
	public int getType(){
		return jRadioButton1.isSelected()?0:1;
	}
	
	public void setNull(){
		jTextField1.setText(null);
		jTextField2.setText(null);
		jTextField3.setText(null);
		jTextField4.setText(null);
		jTextField5.setText(null);
		jTextField6.setText(null);
	}
	
	
	 @SuppressWarnings("unchecked")
	    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	    private void initComponents() {

	        buttonGroup1 = new javax.swing.ButtonGroup();
	        jTabbedPane1 = new javax.swing.JTabbedPane();
	        jPanel1 = new javax.swing.JPanel();
	        jLabel1 = new javax.swing.JLabel();
	        jLabel2 = new javax.swing.JLabel();
	        jLabel3 = new javax.swing.JLabel();
	        jTextField1 = new javax.swing.JTextField();
	        jTextField2 = new javax.swing.JTextField();
	        jLabel4 = new javax.swing.JLabel();
	        jLabel6 = new javax.swing.JLabel();
	        jTextField3 = new javax.swing.JTextField();
	        jTextField4 = new javax.swing.JTextField();
	        jLabel5 = new javax.swing.JLabel();
	        jLabel7 = new javax.swing.JLabel();
	        jTextField5 = new javax.swing.JTextField();
	        jTextField6 = new javax.swing.JTextField();
	        jButton1 = new javax.swing.JButton();
	        jButton2 = new javax.swing.JButton();
	        jLabel8 = new javax.swing.JLabel();
	        jRadioButton1 = new javax.swing.JRadioButton();
	        jRadioButton2 = new javax.swing.JRadioButton();
	        jLabel20 = new javax.swing.JLabel();
	        jPanel2 = new javax.swing.JPanel();
	        jLabel9 = new javax.swing.JLabel();
	        jLabel10 = new javax.swing.JLabel();
	        jButton3 = new javax.swing.JButton();
	        jButton4 = new javax.swing.JButton();
	        jLabel13 = new javax.swing.JLabel();
	        jTextField7 = new javax.swing.JTextField();
	        jTextField8 = new javax.swing.JTextField();
	        jLabel19 = new javax.swing.JLabel();
	        jPanel3 = new javax.swing.JPanel();
	        jLabel11 = new javax.swing.JLabel();
	        jTextField9 = new javax.swing.JTextField();
	        jButton5 = new javax.swing.JButton();
	        jLabel14 = new javax.swing.JLabel();
	        jTextField10 = new javax.swing.JTextField();
	        jLabel12 = new javax.swing.JLabel();
	        jLabel15 = new javax.swing.JLabel();
	        jLabel16 = new javax.swing.JLabel();
	        jLabel17 = new javax.swing.JLabel();
	        jLabel18 = new javax.swing.JLabel();
	        jButton6 = new javax.swing.JButton();
	        jTextField11 = new javax.swing.JTextField();
	        jTextField12 = new javax.swing.JTextField();
	        jTextField13 = new javax.swing.JTextField();
	        jTextField14 = new javax.swing.JTextField();
	        jTextField15 = new javax.swing.JTextField();

	        this.setTitle("客户管理");
	        this.setVisible(true);
	        this.setClosable(true);
	        this.setIconifiable(true);
	        this.setResizable(false);
	        this.setMaximizable(false);

	        jLabel1.setText("请输入客户基本信息：");

	        jLabel2.setText("名称：");

	        jLabel3.setText("电话：");

	        jLabel4.setText("地址：");

	        jLabel6.setText("邮编：");

	        jLabel5.setText("邮箱：");

	        jLabel7.setText("最大额度：");

	        jButton1.setText("添加");

	        jButton2.setText("重置");
	

	        jLabel8.setText("（默认是0）");

	        buttonGroup1.add(jRadioButton1);
	        jRadioButton1.setSelected(true);
	        jRadioButton1.setText("进货商");

	        buttonGroup1.add(jRadioButton2);
	        jRadioButton2.setText("销售商");

	        jLabel20.setText("jLabel20");

	        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addGap(118, 118, 118)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jLabel1)
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                            .addGroup(jPanel1Layout.createSequentialGroup()
	                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
	                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
	                            .addGroup(jPanel1Layout.createSequentialGroup()
	                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addComponent(jLabel2)
	                                    .addComponent(jLabel3)
	                                    .addComponent(jLabel4)
	                                    .addComponent(jLabel6)
	                                    .addComponent(jLabel5)
	                                    .addComponent(jLabel7)
	                                    .addComponent(jLabel20))
	                                .addGap(70, 70, 70)
	                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                                    .addGroup(jPanel1Layout.createSequentialGroup()
	                                        .addComponent(jRadioButton1)
	                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                        .addComponent(jRadioButton2))
	                                    .addComponent(jTextField1)
	                                    .addComponent(jTextField2)
	                                    .addComponent(jTextField3)
	                                    .addComponent(jTextField4)
	                                    .addComponent(jTextField5)
	                                    .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))))
	                        .addGap(56, 56, 56)
	                        .addComponent(jLabel8)))
	                .addContainerGap(285, Short.MAX_VALUE))
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addGap(33, 33, 33)
	                .addComponent(jLabel1)
	                .addGap(28, 28, 28)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel2)
	                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel3)
	                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel4)
	                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jLabel6)
	                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jLabel5)
	                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jLabel7)
	                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jLabel8)))
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addGap(13, 13, 13)
	                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(jRadioButton1)
	                            .addComponent(jRadioButton2)))
	                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(jLabel20)))
	                .addGap(39, 39, 39)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jButton1)
	                    .addComponent(jButton2))
	                .addContainerGap(668, Short.MAX_VALUE))
	        );

	        jTabbedPane1.addTab("添加客户", jPanel1);

	        jLabel10.setText("客户编号：");

	        jButton3.setText("搜索");

	        jButton4.setText("删除");

	        jLabel13.setText("客户名称：");

	        jLabel19.setText("注：删除的客户不能恢复！");

	        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
	        jPanel2.setLayout(jPanel2Layout);
	        jPanel2Layout.setHorizontalGroup(
	            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel2Layout.createSequentialGroup()
	                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(jPanel2Layout.createSequentialGroup()
	                        .addGap(187, 187, 187)
	                        .addComponent(jLabel9))
	                    .addGroup(jPanel2Layout.createSequentialGroup()
	                        .addGap(122, 122, 122)
	                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                            .addGroup(jPanel2Layout.createSequentialGroup()
	                                .addComponent(jLabel10)
	                                .addGap(16, 16, 16)
	                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                            .addGroup(jPanel2Layout.createSequentialGroup()
	                                .addComponent(jLabel13)
	                                .addGap(18, 18, 18)
	                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                            .addComponent(jLabel19))))
	                .addContainerGap(493, Short.MAX_VALUE))
	        );
	        jPanel2Layout.setVerticalGroup(
	            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel2Layout.createSequentialGroup()
	                .addGap(53, 53, 53)
	                .addComponent(jLabel9)
	                .addGap(10, 10, 10)
	                .addComponent(jLabel19)
	                .addGap(98, 98, 98)
	                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel10)
	                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(29, 29, 29)
	                .addComponent(jButton3)
	                .addGap(31, 31, 31)
	                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel13)
	                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(94, 94, 94)
	                .addComponent(jButton4)
	                .addContainerGap(640, Short.MAX_VALUE))
	        );

	        jTabbedPane1.addTab("删除客户", jPanel2);

	        jLabel11.setText("客户编号：");

	        jButton5.setText("搜索");

	        jLabel14.setText("客户名称：");

	        jLabel12.setText("电话：");

	        jLabel15.setText("地址：");

	        jLabel16.setText("邮编：");

	        jLabel17.setText("邮箱：");

	        jLabel18.setText("最大额度：");

	        jButton6.setText("修改");

	        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
	        jPanel3.setLayout(jPanel3Layout);
	        jPanel3Layout.setHorizontalGroup(
	            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel3Layout.createSequentialGroup()
	                .addGap(120, 120, 120)
	                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(jPanel3Layout.createSequentialGroup()
	                        .addComponent(jLabel11)
	                        .addGap(18, 18, 18)
	                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                    .addGroup(jPanel3Layout.createSequentialGroup()
	                        .addGap(2, 2, 2)
	                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jLabel14)
	                            .addComponent(jLabel12)
	                            .addComponent(jLabel15)
	                            .addComponent(jLabel16)
	                            .addComponent(jLabel17)
	                            .addComponent(jLabel18))
	                        .addGap(18, 18, 18)
	                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                            .addComponent(jTextField10, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
	                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jTextField11)
	                            .addComponent(jTextField12)
	                            .addComponent(jTextField13)
	                            .addComponent(jTextField14)
	                            .addComponent(jTextField15))))
	                .addContainerGap(493, Short.MAX_VALUE))
	        );
	        jPanel3Layout.setVerticalGroup(
	            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel3Layout.createSequentialGroup()
	                .addGap(54, 54, 54)
	                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel11)
	                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(29, 29, 29)
	                .addComponent(jButton5)
	                .addGap(31, 31, 31)
	                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel14)
	                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(31, 31, 31)
	                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jLabel12)
	                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(26, 26, 26)
	                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jLabel15)
	                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(23, 23, 23)
	                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel16)
	                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(21, 21, 21)
	                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel17)
	                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(24, 24, 24)
	                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel18)
	                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(25, 25, 25)
	                .addComponent(jButton6)
	                .addContainerGap(601, Short.MAX_VALUE))
	        );

	        jTabbedPane1.addTab("修改客户", jPanel3);

	        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(this.getContentPane());
	        this.getContentPane().setLayout(jInternalFrame1Layout);
	        jInternalFrame1Layout.setHorizontalGroup(
	            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jTabbedPane1)
	        );
	        jInternalFrame1Layout.setVerticalGroup(
	            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1087, Short.MAX_VALUE)
	        );

	       

	        pack();
	    }// </editor-fold>                        



	    // Variables declaration - do not modify                     
	    private javax.swing.ButtonGroup buttonGroup1;
	    private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JButton jButton3;
	    private javax.swing.JButton jButton4;
	    private javax.swing.JButton jButton5;
	    private javax.swing.JButton jButton6;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel10;
	    private javax.swing.JLabel jLabel11;
	    private javax.swing.JLabel jLabel12;
	    private javax.swing.JLabel jLabel13;
	    private javax.swing.JLabel jLabel14;
	    private javax.swing.JLabel jLabel15;
	    private javax.swing.JLabel jLabel16;
	    private javax.swing.JLabel jLabel17;
	    private javax.swing.JLabel jLabel18;
	    private javax.swing.JLabel jLabel19;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel20;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JLabel jLabel4;
	    private javax.swing.JLabel jLabel5;
	    private javax.swing.JLabel jLabel6;
	    private javax.swing.JLabel jLabel7;
	    private javax.swing.JLabel jLabel8;
	    private javax.swing.JLabel jLabel9;
	    private javax.swing.JPanel jPanel1;
	    private javax.swing.JPanel jPanel2;
	    private javax.swing.JPanel jPanel3;
	    private javax.swing.JRadioButton jRadioButton1;
	    private javax.swing.JRadioButton jRadioButton2;
	    private javax.swing.JTabbedPane jTabbedPane1;
	    private javax.swing.JTextField jTextField1;
	    private javax.swing.JTextField jTextField10;
	    private javax.swing.JTextField jTextField11;
	    private javax.swing.JTextField jTextField12;
	    private javax.swing.JTextField jTextField13;
	    private javax.swing.JTextField jTextField14;
	    private javax.swing.JTextField jTextField15;
	    private javax.swing.JTextField jTextField2;
	    private javax.swing.JTextField jTextField3;
	    private javax.swing.JTextField jTextField4;
	    private javax.swing.JTextField jTextField5;
	    private javax.swing.JTextField jTextField6;
	    private javax.swing.JTextField jTextField7;
	    private javax.swing.JTextField jTextField8;
	    private javax.swing.JTextField jTextField9;
	    // End of variables declaration         
}
