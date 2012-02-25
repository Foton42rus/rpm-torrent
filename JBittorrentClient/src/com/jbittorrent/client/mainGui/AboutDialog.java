package com.jbittorrent.client.mainGui;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
*
* @author Rajeev
*/
public class AboutDialog extends javax.swing.JDialog {

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** Creates new form AboutDialog */
   public AboutDialog(java.awt.Frame parent) {
       super(parent);
       getContentPane().setPreferredSize(new Dimension(1000, 250));
       setPreferredSize(new Dimension(730, 290));
       setMaximumSize(new Dimension(21474, 21474));
       getContentPane().setBackground(Color.WHITE);
       initComponents();
       getContentPane().setLayout(new BorderLayout(0, 0));
       getRootPane().setDefaultButton(jButton1);
       jButton1 = new javax.swing.JButton();
       
              jButton1.setText("close");
              jButton1.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                      jButton1ActionPerformed(evt);
                  }
              });
       
       panelWest = new JPanel();
       panelSouth=new JPanel();
       panelSouth.add(jButton1);
       getContentPane().add(panelWest, BorderLayout.WEST);
       getContentPane().add(panelSouth,BorderLayout.SOUTH);
       
              jLabel1 = new javax.swing.JLabel();
              panelWest.add(jLabel1);
              jLabel1.setPreferredSize(new Dimension(200, 200));
              
                     jLabel1.setIcon(new ImageIcon(AboutDialog.class.getResource("/images/DigitalSign2.png"))); // NOI18N
                     
                     panelEast = new JPanel();
                     panelEast.setPreferredSize(new Dimension(500, 500));
                     panelEast.setMaximumSize(new Dimension(1500, 1600));
                     getContentPane().add(panelEast, BorderLayout.EAST);
                     jLabel2 = new javax.swing.JLabel();
                     
                            jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18));
                            jLabel2.setText("A Simple Java Torrent Downloader");
                            jLabel3 = new javax.swing.JLabel();
                            
                                   jLabel3.setText("<html><align=\"center\">This is a simple java torrent downloader implemented in swing with MVC.<br/> This software can be further extended to a full featured torrent client like Azureas.<br/>.");
                                   jLabel4 = new javax.swing.JLabel();
                                   
                                          jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14));
                                          jLabel4.setText("Software Version:");
                                          jLabel5 = new javax.swing.JLabel();
                                          
                                                 jLabel5.setText("1.0");
                                          jLabel6 = new javax.swing.JLabel();
                                          
                                                 jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14));
                                                 jLabel6.setText("Developers:");
                                                 jLabel7 = new javax.swing.JLabel();
                                                 jLabel7.setText("<html>Rajeev<br/>Manoj<br/>Pushpendra</html>");
                                                 jLabel8 = new javax.swing.JLabel();
                                                 jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14));
                                                 jLabel8.setText("Website:");
                                                 jLabel9 = new javax.swing.JLabel();
                                                 
                                                        jLabel9.setText("www.techyrajeev.blogspot.com");
                                                        GroupLayout gl_panelEast = new GroupLayout(panelEast);
                                                        gl_panelEast.setHorizontalGroup(
                                                        	gl_panelEast.createParallelGroup(Alignment.LEADING)
                                                        		.addGroup(gl_panelEast.createSequentialGroup()
                                                        			.addGap(5)
                                                        			.addGroup(gl_panelEast.createParallelGroup(Alignment.LEADING)
                                                        				.addComponent(jLabel2)
                                                        				.addGroup(gl_panelEast.createSequentialGroup()
                                                        					.addGroup(gl_panelEast.createParallelGroup(Alignment.LEADING)
                                                        						.addComponent(jLabel4)
                                                        						.addComponent(jLabel6)
                                                        						.addComponent(jLabel8))
                                                        					.addPreferredGap(ComponentPlacement.RELATED)
                                                        					.addGroup(gl_panelEast.createParallelGroup(Alignment.LEADING)
                                                        						.addComponent(jLabel9)
                                                        						.addComponent(jLabel7)
                                                        						.addComponent(jLabel5)))
                                                        				.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 484, GroupLayout.PREFERRED_SIZE))
                                                        			.addGap(775))
                                                        );
                                                        gl_panelEast.setVerticalGroup(
                                                        	gl_panelEast.createParallelGroup(Alignment.LEADING)
                                                        		.addGroup(gl_panelEast.createSequentialGroup()
                                                        			.addGap(18)
                                                        			.addComponent(jLabel2)
                                                        			.addPreferredGap(ComponentPlacement.RELATED)
                                                        			.addComponent(jLabel3)
                                                        			.addPreferredGap(ComponentPlacement.RELATED)
                                                        			.addGroup(gl_panelEast.createParallelGroup(Alignment.BASELINE)
                                                        				.addComponent(jLabel4)
                                                        				.addComponent(jLabel5))
                                                        			.addPreferredGap(ComponentPlacement.RELATED)
                                                        			.addGroup(gl_panelEast.createParallelGroup(Alignment.LEADING)
                                                        				.addComponent(jLabel6)
                                                        				.addComponent(jLabel7))
                                                        			.addPreferredGap(ComponentPlacement.RELATED)
                                                        			.addGroup(gl_panelEast.createParallelGroup(Alignment.LEADING)
                                                        				.addComponent(jLabel8)
                                                        				.addComponent(jLabel9))
                                                        			.addContainerGap(31, Short.MAX_VALUE))
                                                        );
                                                        panelEast.setLayout(gl_panelEast);
       setVisible(true);
       
   }
                   
   private void initComponents() {

       setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
       setTitle("About J-torrent\r\n");
       setBackground(java.awt.Color.white);

       getAccessibleContext().setAccessibleParent(null);

       pack();
   }// </editor-fold>                        

   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
       dispose();
   }                                        

   /**
    * @param args the command line arguments
    */
   public static void main(String args[]) {
       java.awt.EventQueue.invokeLater(new Runnable() {

           public void run() {
               AboutDialog dialog = new AboutDialog(new javax.swing.JFrame());
               dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                   public void windowClosing(java.awt.event.WindowEvent e) {
                       System.exit(0);
                   }
               });
               dialog.setVisible(true);
           }
       });
   }
   // Variables declaration - do not modify                     
   private javax.swing.JButton jButton1;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JLabel jLabel5;
   private javax.swing.JLabel jLabel6;
   private javax.swing.JLabel jLabel7;
   private javax.swing.JLabel jLabel8;
   private javax.swing.JLabel jLabel9;
   private JPanel panelWest;
   private JPanel panelEast;
   private JPanel panelSouth;
}
