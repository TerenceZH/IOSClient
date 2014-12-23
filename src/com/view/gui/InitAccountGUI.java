package com.view.gui;

import javax.swing.JInternalFrame;

public class InitAccountGUI extends JInternalFrame{
	public InitAccountGUI(){
		
	}
	
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {


        jLabel1 = new javax.swing.JLabel();

        this.setTitle("期初建账");
        this.setVisible(true);
        this.setClosable(true);
        this.setIconifiable(true);
        this.setResizable(false);
        this.setMaximizable(false);

        jLabel1.setText("此功能正在维护中，请稍后再试...");

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(407, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(363, Short.MAX_VALUE))
        );

      

        pack();
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    // End of variables declaration  

}
