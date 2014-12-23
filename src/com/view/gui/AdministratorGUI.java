package com.view.gui;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JInternalFrame;

public class AdministratorGUI extends JInternalFrame{
	private String type = "系统管理员";
	
	 public AdministratorGUI() {
	        initComponents();
	       
	    }

	 
	 public void addAdministratorListeners(ActionListener[]a){
		 if(a.length!=2){
			 return;
		 }
		 
		 jButton1.addActionListener(a[0]);
		 jButton2.addActionListener(a[1]);
	 }

	 public String getUName(){
		 return jTextField1.getText().trim();
	 }
	 
	 public String getPwd(){
		 return jTextField2.getText().trim();
	 }
	 
	 public String getNo(){
		 return jTextField3.getText().trim();
	 }
	 
	 public String getType(){
		 return type;
	 }
	 
	 public int getTopAuth(){
		 return jRadioButton1.isSelected()?1:0;
	 }
	 
	 public int getTopAuth2(){
		 return jRadioButton3.isSelected()?1:0;
	 }
	 
	 
	    @SuppressWarnings("unchecked")
	    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	    private void initComponents() {
	

	        jTabbedPane1 = new javax.swing.JTabbedPane();
	        jPanel1 = new javax.swing.JPanel();
	        jLabel1 = new javax.swing.JLabel();
	        jLabel2 = new javax.swing.JLabel();
	        jLabel3 = new javax.swing.JLabel();
	        jLabel4 = new javax.swing.JLabel();
	        jTextField1 = new javax.swing.JTextField();
	        jTextField2 = new javax.swing.JTextField();
	        jComboBox1 = new javax.swing.JComboBox();
	        jButton1 = new javax.swing.JButton();
	        jLabel6 = new javax.swing.JLabel();
	        jRadioButton1 = new javax.swing.JRadioButton();
	        jRadioButton2 = new javax.swing.JRadioButton();
	        jPanel2 = new javax.swing.JPanel();
	        jLabel5 = new javax.swing.JLabel();
	        jTextField3 = new javax.swing.JTextField();
	        jLabel7 = new javax.swing.JLabel();
	        jRadioButton3 = new javax.swing.JRadioButton();
	        jRadioButton4 = new javax.swing.JRadioButton();
	        jButton2 = new javax.swing.JButton();
	        buttonGroup1 = new javax.swing.ButtonGroup();
	        buttonGroup2 = new javax.swing.ButtonGroup();

	        this.setTitle("管理员");
	        this.setVisible(true);
	        this.setClosable(true);
	        this.setIconifiable(true);
	        this.setResizable(false);
	        this.setMaximizable(false);

	        jLabel1.setText("请输入用户基本信息：");

	        jLabel2.setText("用户名：");

	        jLabel3.setText("密码：");

	        jLabel4.setText("类型：");

	        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "系统管理员","库存管理员","进销人员","财务人员","总经理" }));
	        jComboBox1.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					if(e.getStateChange()==ItemEvent.SELECTED){
						type = (String)jComboBox1.getSelectedItem();
					}
				}
			});

	        jButton1.setText("添加");

	        jLabel6.setText("最高权限：");

	        buttonGroup1.add(jRadioButton1);
	        jRadioButton1.setText("是");

	        buttonGroup1.add(jRadioButton2);
	        jRadioButton2.setSelected(true);
	        jRadioButton2.setText("否");

	        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(jPanel1Layout.createSequentialGroup()
	                                .addGap(82, 82, 82)
	                                .addComponent(jLabel1))
	                            .addGroup(jPanel1Layout.createSequentialGroup()
	                                .addGap(150, 150, 150)
	                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addComponent(jLabel3)
	                                    .addComponent(jLabel2)))
	                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
	                                .addContainerGap()
	                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                                    .addComponent(jLabel6)
	                                    .addComponent(jLabel4))
	                                .addGap(16, 16, 16)))
	                        .addGap(60, 60, 60)
	                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
	                                .addComponent(jTextField2))
	                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addGroup(jPanel1Layout.createSequentialGroup()
	                                .addComponent(jRadioButton1)
	                                .addGap(18, 18, 18)
	                                .addComponent(jRadioButton2))))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addGap(144, 144, 144)
	                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap(262, Short.MAX_VALUE))
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addGap(34, 34, 34)
	                .addComponent(jLabel1)
	                .addGap(33, 33, 33)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel2)
	                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(44, 44, 44)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel3)
	                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(50, 50, 50)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel4)
	                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(35, 35, 35)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel6)
	                    .addComponent(jRadioButton1)
	                    .addComponent(jRadioButton2))
	                .addGap(54, 54, 54)
	                .addComponent(jButton1)
	                .addContainerGap(32, Short.MAX_VALUE))
	        );

	        jTabbedPane1.addTab("添加用户", jPanel1);

	        jLabel5.setText("输入用户ID：");

	        jLabel7.setText("最高权限：");

	        buttonGroup2.add(jRadioButton3);
	        jRadioButton3.setText("是");

	        buttonGroup2.add(jRadioButton4);
	        jRadioButton4.setSelected(true);
	        jRadioButton4.setText("否");

	        jButton2.setText("修改");

	        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
	        jPanel2.setLayout(jPanel2Layout);
	        jPanel2Layout.setHorizontalGroup(
	            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel2Layout.createSequentialGroup()
	                .addGap(124, 124, 124)
	                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jButton2)
	                    .addGroup(jPanel2Layout.createSequentialGroup()
	                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jLabel5)
	                            .addComponent(jLabel7))
	                        .addGap(31, 31, 31)
	                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(jPanel2Layout.createSequentialGroup()
	                                .addComponent(jRadioButton3)
	                                .addGap(18, 18, 18)
	                                .addComponent(jRadioButton4))
	                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
	                .addContainerGap(286, Short.MAX_VALUE))
	        );
	        jPanel2Layout.setVerticalGroup(
	            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel2Layout.createSequentialGroup()
	                .addGap(86, 86, 86)
	                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel5)
	                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(53, 53, 53)
	                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel7)
	                    .addComponent(jRadioButton3)
	                    .addComponent(jRadioButton4))
	                .addGap(63, 63, 63)
	                .addComponent(jButton2)
	                .addContainerGap(137, Short.MAX_VALUE))
	        );

	        jTabbedPane1.addTab("修改权限", jPanel2);

	        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(this.getContentPane());
	        this.getContentPane().setLayout(jInternalFrame1Layout);
	        jInternalFrame1Layout.setHorizontalGroup(
	            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jTabbedPane1)
	        );
	        jInternalFrame1Layout.setVerticalGroup(
	            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jInternalFrame1Layout.createSequentialGroup()
	                .addComponent(jTabbedPane1)
	                .addContainerGap())
	        );

	      
	        pack();
	        
	        
	    }// </editor-fold>                        

	    
	    // Variables declaration - do not modify                     
	    private javax.swing.ButtonGroup buttonGroup1;
	    private javax.swing.ButtonGroup buttonGroup2;
	    private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JComboBox jComboBox1;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JLabel jLabel4;
	    private javax.swing.JLabel jLabel5;
	    private javax.swing.JLabel jLabel6;
	    private javax.swing.JLabel jLabel7;
	    private javax.swing.JPanel jPanel1;
	    private javax.swing.JPanel jPanel2;
	    private javax.swing.JRadioButton jRadioButton1;
	    private javax.swing.JRadioButton jRadioButton2;
	    private javax.swing.JRadioButton jRadioButton3;
	    private javax.swing.JRadioButton jRadioButton4;
	    private javax.swing.JTabbedPane jTabbedPane1;
	    private javax.swing.JTextField jTextField1;
	    private javax.swing.JTextField jTextField2;
	    private javax.swing.JTextField jTextField3;
	    // End of variables declaration     
	    
}
