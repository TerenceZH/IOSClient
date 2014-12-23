package com.view.gui;

import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;

public class GetGUI extends JInternalFrame{
	
	public GetGUI(){
		initComponents();
	}
	
	public void addListeners(ActionListener[]a){
		jButton1.addActionListener(a[0]);
		jButton2.addActionListener(a[1]);
	}
	
	public String getCusno(){
		return jTextField1.getText().trim();
	}
	
	public void setOperator(String s){
		jTextField2.setText(s);
	}
	
	
	public void setMoney(String s){
		jTextField3.setText(s);
	}
	
	public void setInfo(String s){
		jTextArea1.append(s);
	}
	
	public String getMoney(){
		return jTextField3.getText().trim();
	}
	
	 @SuppressWarnings("unchecked")
	    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	    private void initComponents() {

	        jLabel1 = new javax.swing.JLabel();
	        jLabel2 = new javax.swing.JLabel();
	        jTextField1 = new javax.swing.JTextField();
	        jTextField2 = new javax.swing.JTextField();
	        jButton1 = new javax.swing.JButton();
	        jScrollPane1 = new javax.swing.JScrollPane();
	        jTextArea1 = new javax.swing.JTextArea();
	        jLabel3 = new javax.swing.JLabel();
	        jTextField3 = new javax.swing.JTextField();
	        jButton2 = new javax.swing.JButton();

	        this.setTitle("收款单");
	        this.setVisible(true);
	        this.setClosable(true);
	        this.setIconifiable(true);
	        this.setResizable(false);
	        this.setMaximizable(false);

	        jLabel1.setText("客户编号：");

	        jLabel2.setText("操作员：");

	        jTextField2.setEnabled(false);

	        jButton1.setText("添加账单");

	        jTextArea1.setColumns(20);
	        jTextArea1.setRows(5);
	        jTextArea1.setEnabled(false);
	        jScrollPane1.setViewportView(jTextArea1);

	        jLabel3.setText("总额：");

	        jTextField3.setText("0");
	        jTextField3.setEnabled(false);

	        jButton2.setText("添加");

	        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(this.getContentPane());
	        this.getContentPane().setLayout(jInternalFrame1Layout);
	        jInternalFrame1Layout.setHorizontalGroup(
	            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jInternalFrame1Layout.createSequentialGroup()
	                .addGap(61, 61, 61)
	                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                        .addGroup(jInternalFrame1Layout.createSequentialGroup()
	                            .addComponent(jLabel3)
	                            .addGap(79, 79, 79)
	                            .addComponent(jTextField3))
	                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGroup(jInternalFrame1Layout.createSequentialGroup()
	                            .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                .addComponent(jLabel1)
	                                .addComponent(jLabel2))
	                            .addGap(49, 49, 49)
	                            .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                                .addComponent(jTextField1)
	                                .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)))
	                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE))
	                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addContainerGap(250, Short.MAX_VALUE))
	        );
	        jInternalFrame1Layout.setVerticalGroup(
	            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jInternalFrame1Layout.createSequentialGroup()
	                .addGap(44, 44, 44)
	                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel1)
	                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel2)
	                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(34, 34, 34)
	                .addComponent(jButton1)
	                .addGap(30, 30, 30)
	                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(30, 30, 30)
	                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel3)
	                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
	                .addComponent(jButton2)
	                .addGap(21, 21, 21))
	        );

	       

	        pack();
	    }// </editor-fold>                        

	   

	    // Variables declaration - do not modify                     
	    private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JTextArea jTextArea1;
	    private javax.swing.JTextField jTextField1;
	    private javax.swing.JTextField jTextField2;
	    private javax.swing.JTextField jTextField3;
	    // End of variables declaration      

}
