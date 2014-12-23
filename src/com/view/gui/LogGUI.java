package com.view.gui;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JInternalFrame;
import javax.swing.JTable;

public class LogGUI extends JInternalFrame{
	//types = {"��Ʒ","��Ʒ����","�ͻ�","�˻�","����","�ո���","����","�û�"};
	private String type = "��ѡ��";
	
	public LogGUI(){
		initComponents();
	}
	
	public JTable getTable(){
		return jTable1;
	}
	
	public void addLogListener(ActionListener a){
		jButton1.addActionListener(a);
	}
	
	public String getStime(){
		return jTextField1.getText().trim();
	}
	
	public String getEtime(){
		return jTextField2.getText().trim();
	}
	
	public String getType(){
		return type;
	}
	
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
		
	        jLabel1 = new javax.swing.JLabel();
	        jTextField1 = new javax.swing.JTextField();
	        jLabel2 = new javax.swing.JLabel();
	        jTextField2 = new javax.swing.JTextField();
	        jLabel3 = new javax.swing.JLabel();
	        jComboBox1 = new javax.swing.JComboBox();
	        jScrollPane1 = new javax.swing.JScrollPane();
	        jTable1 = new javax.swing.JTable();
	        jButton1 = new javax.swing.JButton();

	        this.setTitle("��־");
	        this.setVisible(true);
	        this.setClosable(true);
	        this.setIconifiable(true);
	        this.setResizable(false);
	        this.setMaximizable(false);

	        jLabel1.setText("��ʼʱ�䣺");

	        jLabel2.setText("����ʱ�䣺");

	        jLabel3.setText("���");

	        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "��ѡ��","��Ʒ","��Ʒ����","�ͻ�","�˻�","����","�ո���","����","�û�" }));
	        jComboBox1.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					if(e.getStateChange()==ItemEvent.SELECTED){
						type = (String)jComboBox1.getSelectedItem();
					}
				}
			});

	        jTable1.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {

	            },
	            new String [] {
	                "����", "ʱ��", "����", "����Ա"
	            }
	        ));
	        jScrollPane1.setViewportView(jTable1);

	        jButton1.setText("jButton1");

	        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(this.getContentPane());
	        this.getContentPane().setLayout(jInternalFrame1Layout);
	        jInternalFrame1Layout.setHorizontalGroup(
	            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jInternalFrame1Layout.createSequentialGroup()
	                .addGap(21, 21, 21)
	                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                        .addComponent(jScrollPane1)
	                        .addGroup(jInternalFrame1Layout.createSequentialGroup()
	                            .addComponent(jLabel1)
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                            .addComponent(jLabel2)
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                            .addComponent(jLabel3)
	                            .addGap(18, 18, 18)
	                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addContainerGap(57, Short.MAX_VALUE))
	        );
	        jInternalFrame1Layout.setVerticalGroup(
	            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jInternalFrame1Layout.createSequentialGroup()
	                .addGap(19, 19, 19)
	                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel1)
	                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel2)
	                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel3)
	                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addComponent(jButton1)
	                .addGap(17, 17, 17)
	                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(106, Short.MAX_VALUE))
	        );


	        pack();
	    }// </editor-fold>                        

	   

	    // Variables declaration - do not modify                     
	    private javax.swing.JButton jButton1;
	    private javax.swing.JComboBox jComboBox1;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JTable jTable1;
	    private javax.swing.JTextField jTextField1;
	    private javax.swing.JTextField jTextField2;
	    // End of variables declaration         

}
