package com.view.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MainGUI extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainGUI(String name,String power,int type,int auth) {
    	super("���������ϵͳV1.0009        ��ӭ�� "+name+"   ���Ľ�ɫ�ǣ� "+power);
        initComponents();
        addLimits(type,auth);
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        this.setVisible(true);
    }
    
    //���Ӽ���
    public void addMainListeners(ActionListener [] a){
    	JMenuItem [] items = {jMenuItem1,jMenuItem2,jMenuItem3,jMenuItem4,jMenuItem5,jMenuItem6,jMenuItem7,
    			jMenuItem8,jMenuItem9,jMenuItem10,jMenuItem11,jMenuItem12,jMenuItem13,jMenuItem14,
    			jMenuItem15,jMenuItem16,jMenuItem17,jMenuItem18,jMenuItem19,jMenuItem20,jMenuItem21,jMenuItem22,
    			jMenuItem23,jMenuItem24,jMenuItem25,jMenuItem26};
    	for(int i=0;i<items.length;i++){
    		items[i].addActionListener(a[i]);
    	}
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

//    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        this.setBounds(screenSize.width/6,screenSize.height/6, screenSize.width*2/3,
//				screenSize.height*2/3);
    	
        jDesktopPane1 = new javax.swing.JDesktopPane();
        
		
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenuItem26 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setOpaque(true);
		this.setContentPane(jDesktopPane1);
		jDesktopPane1.setBackground(new Color(200,218,235));
		jDesktopPane1.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 925, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 571, Short.MAX_VALUE)
        );

        jMenu1.setText("������Ϣ");

        jMenuItem1.setText("��Ʒ����");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("��Ʒ�������");
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("�ͻ�����");
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("�˻�����");
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("��������");

        jMenuItem5.setText("������");
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("���۵�");
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        jMenu5.setText("��浥");

        jMenuItem7.setText("���絥");
        jMenu5.add(jMenuItem7);

        jMenuItem8.setText("����");
        jMenu5.add(jMenuItem8);

        jMenuItem9.setText("���͵�");
        jMenu5.add(jMenuItem9);

        jMenuItem10.setText("������");
        jMenu5.add(jMenuItem10);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("������ѯ");

        jMenuItem11.setText("��Ʒ��ѯ");
        jMenu6.add(jMenuItem11);

        jMenuItem12.setText("����ѯ");
        jMenu6.add(jMenuItem12);

        jMenuItem13.setText("����̵�");
        jMenu6.add(jMenuItem13);

        jMenuItem14.setText("�ͻ���ѯ");
        jMenu6.add(jMenuItem14);

        jMenuItem15.setText("�˻���ѯ");
        jMenu6.add(jMenuItem15);

        jMenuBar1.add(jMenu6);

        jMenu8.setText("��ϸ��ѯ");

        jMenuItem16.setText("��Ӫ���");
        jMenu8.add(jMenuItem16);

        jMenuItem17.setText("��Ӫ����");
        jMenu8.add(jMenuItem17);

        jMenuItem18.setText("������ϸ");
        jMenu8.add(jMenuItem18);

        jMenuBar1.add(jMenu8);

        jMenu9.setText("����");

        jMenuItem19.setText("��־");
        jMenu9.add(jMenuItem19);

        jMenuItem20.setText("����");
        jMenu9.add(jMenuItem20);

        jMenuItem21.setText("����");
        jMenu9.add(jMenuItem21);

        jMenuItem22.setText("�ڳ�����");
        jMenu9.add(jMenuItem22);

        jMenuBar1.add(jMenu9);

        jMenu10.setText("ϵͳ");

        jMenuItem23.setText("��Ϣ");
        jMenu10.add(jMenuItem23);

        jMenuItem24.setText("�޸�����");
        jMenu10.add(jMenuItem24);

        jMenuItem25.setText("����Ա");
        jMenu10.add(jMenuItem25);

        jMenuItem26.setText("�˳�ϵͳ");
        jMenu10.add(jMenuItem26);

        jMenuBar1.add(jMenu10);

        setJMenuBar(jMenuBar1);
        
        
//        jDesktopPane1.setBackground(new java.awt.Color(204, 204, 204));
//        jDesktopPane1.setDragMode(javax.swing.JDesktopPane.OUTLINE_DRAG_MODE);
//        jDesktopPane1.setOpaque(true);
//        
//        this.setContentPane(jDesktopPane1);

        pack();
    }// </editor-fold>         
    
    //��������
    private void addLimits(int type,int auth){
    	JMenu[] a = null;
    	JMenuItem [] b = null;
    	switch (type) {
		case 0:
			a = new JMenu[]{jMenu1,jMenu2,jMenu5,jMenu6,jMenu8,jMenu9};
			b = new JMenuItem[]{jMenuItem23};
			setEnable(a, b);
			break;
		case 1:
			a = new JMenu[]{jMenu2,jMenu8,jMenu9};
			b = new JMenuItem[]{jMenuItem3,jMenuItem4,jMenuItem14,jMenuItem15,jMenuItem25};
			setEnable(a, b);
			break;
		case 2:
			a = new JMenu[]{jMenu5,jMenu8,jMenu9};
			b = new JMenuItem[]{jMenuItem1,jMenuItem2,jMenuItem4,jMenuItem11,jMenuItem12,jMenuItem13,
					jMenuItem15,jMenuItem25};
			setEnable(a, b);
			break;
		case 3:
			a =  new JMenu[]{jMenu2,jMenu5};
			b = new JMenuItem[]{jMenuItem1,jMenuItem2,jMenuItem3,jMenuItem11,jMenuItem12,jMenuItem13,
					jMenuItem14,jMenuItem15,jMenuItem20,jMenuItem21,jMenuItem25};
			setEnable(a, b);
			break;
		case 4:
			a = new JMenu[]{jMenu1,jMenu2,jMenu5,jMenu6};
			b = new JMenuItem[]{jMenuItem15,jMenuItem22,jMenuItem25};
			setEnable(a, b);
			break;
		default:
			break;
		}
    	if(auth==1){
    		jMenuItem15.setEnabled(true);
    	}
    }
    
    private void setEnable(JMenu[]a,JMenuItem[]b){
    	if(a!=null){
    		for(int i=0;i<a.length;i++){
    			a[i].setEnabled(false);
    		}
    	}
    	
    	if(b!=null){
    		for(int i=0;i<b.length;i++){
    			b[i].setEnabled(false);
    		}
    	}
    }

    // Variables declaration - do not modify                     
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    // End of variables declaration                   
}
	