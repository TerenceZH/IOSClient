package com.view.gui;

import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;

public class StockBydGUI extends JInternalFrame{
	
	public StockBydGUI (){
		initComponents();
	}
	
	public void addBydListener(ActionListener a){
		jButton1.addActionListener(a);
	}
	
	public String getNo(){
		return jTextField1.getText().trim();
	}
	
	public String getQuantity(){
		return jTextField2.getText().trim();
	}
	
	 @SuppressWarnings("unchecked")
	    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	    private void initComponents() {

	        jLabel1 = new javax.swing.JLabel();
	        jLabel2 = new javax.swing.JLabel();
	        jLabel3 = new javax.swing.JLabel();
	        jTextField1 = new javax.swing.JTextField();
	        jTextField2 = new javax.swing.JTextField();
	        jButton1 = new javax.swing.JButton();

	        this.setTitle("报溢单");
	        this.setVisible(true);
	        this.setClosable(true);
	        this.setIconifiable(true);
	        this.setResizable(false);
	        this.setMaximizable(false);

	        jLabel1.setText("注：实际数量多于系统数量是添加");
	        jLabel1.setToolTipText("");

	        jLabel2.setText("商品编号：");

	        jLabel3.setText("数量：");

	        jTextField2.setText("0");

	        jButton1.setText("添加");

	        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(this.getContentPane());
	        this.getContentPane().setLayout(jInternalFrame2Layout);
	        jInternalFrame2Layout.setHorizontalGroup(
	            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jInternalFrame2Layout.createSequentialGroup()
	                .addGap(77, 77, 77)
	                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jLabel1)
	                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
	                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jLabel2)
	                            .addComponent(jLabel3))
	                        .addGap(37, 37, 37)
	                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                            .addComponent(jTextField1)
	                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)))
	                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addContainerGap(389, Short.MAX_VALUE))
	        );
	        jInternalFrame2Layout.setVerticalGroup(
	            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jInternalFrame2Layout.createSequentialGroup()
	                .addGap(48, 48, 48)
	                .addComponent(jLabel1)
	                .addGap(34, 34, 34)
	                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel2)
	                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(31, 31, 31)
	                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel3)
	                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(68, 68, 68)
	                .addComponent(jButton1)
	                .addContainerGap(244, Short.MAX_VALUE))
	        );

	       

	        pack();
	    }// </editor-fold>                        

	  

	    // Variables declaration - do not modify                     
	    private javax.swing.JButton jButton1;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JTextField jTextField1;
	    private javax.swing.JTextField jTextField2;
	    // End of variables declaration 

}
