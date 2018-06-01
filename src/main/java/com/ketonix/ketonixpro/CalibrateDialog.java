/*     */ package com.ketonix.ketonixpro;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.Font;
/*     */ import java.awt.Frame;
/*     */ import java.awt.Panel;
/*     */ import java.awt.Point;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JProgressBar;
/*     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.UIManager.LookAndFeelInfo;
/*     */ import javax.swing.UnsupportedLookAndFeelException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CalibrateDialog
/*     */   extends JDialog
/*     */ {
/*     */   KSync gui;
/*     */   Thread calibrationThread;
/*     */   static final int VENDOR_ID = 1240;
/*     */   static final int PRODUCT_ID = 62547;
/*     */   private static final int BUFSIZE = 64;
/*     */   private static final long READ_UPDATE_DELAY_MS = 50L;
/*  86 */   public boolean stopCalibrating = true;
/*     */   private JLabel calibrationLabel;
/*     */   private JLabel iconLabel;
/*     */   private JLabel jLabel1;
/*     */   
/*     */   public CalibrateDialog(Frame parent, boolean modal, KSync caller) {
/*  92 */     super(parent, modal);
/*  93 */     this.gui = caller;
/*  94 */     initComponents();
/*  95 */     this.progressBar.setMinimum(0);
/*  96 */     this.progressBar.setMaximum(100);
/*  97 */     if (this.gui.current_type == 0) {
/*  98 */       this.iconLabel.setIcon(new ImageIcon(getClass().getResource("/resources/images/KetonixBlue.png")));
/*  99 */     } else if (this.gui.current_type == 1) {
/* 100 */       this.iconLabel.setIcon(new ImageIcon(getClass().getResource("/resources/images/KetonixRed.png")));
/* 101 */     } else if (this.gui.current_type == 2) {
/* 102 */       this.iconLabel.setIcon(new ImageIcon(getClass().getResource("/resources/images/KetonixUSB.png")));
/*     */     } else {
/* 104 */       this.iconLabel.setIcon(new ImageIcon(getClass().getResource("/resources/images/KetonixGrey.png")));
/*     */     }
/*     */   }
/*     */   
/*     */   public void finishedCalibrating()
/*     */   {
/* 110 */     this.startButton.setEnabled(true);
/*     */     
/*     */ 
/* 113 */     dispose();
/*     */   }
/*     */   
/* 116 */   void setCalibration(int value) { int corr = 0;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 124 */     corr = 0;
/*     */     
/*     */ 
/* 127 */     this.gui.setCalibration(value, corr);
/*     */   }
/*     */   
/*     */ 
/*     */   public void setProgress(int v, int max)
/*     */   {
/* 133 */     this.progressBar.setValue(100 * v / max);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void initComponents()
/*     */   {
/* 144 */     this.panel1 = new Panel();
/* 145 */     this.calibrationLabel = new JLabel();
/* 146 */     this.startButton = new JButton();
/* 147 */     this.progressBar = new JProgressBar();
/* 148 */     this.iconLabel = new JLabel();
/* 149 */     this.jLabel1 = new JLabel();
/*     */     
/* 151 */     setDefaultCloseOperation(2);
/* 152 */     setTitle("Calibration");
/* 153 */     setAlwaysOnTop(true);
/* 154 */     setLocation(new Point(300, 200));
/*     */     
/* 156 */     this.panel1.setBackground(new Color(255, 255, 255));
/* 157 */     this.panel1.setPreferredSize(new Dimension(402, 266));
/*     */     
/* 159 */     this.calibrationLabel.setFont(new Font("Lucida Sans", 1, 24));
/* 160 */     this.calibrationLabel.setText("Calibration");
/*     */     
/* 162 */     this.startButton.setFont(new Font("Lucida Sans", 1, 14));
/* 163 */     this.startButton.setText("Start Calibration");
/* 164 */     this.startButton.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 166 */         CalibrateDialog.this.startButtonActionPerformed(evt);
/*     */       }
/*     */       
/* 169 */     });
/* 170 */     this.progressBar.setBackground(new Color(204, 255, 204));
/* 171 */     this.progressBar.setForeground(new Color(51, 102, 255));
/* 172 */     this.progressBar.setDoubleBuffered(true);
/*     */     
/* 174 */     this.iconLabel.setIcon(new ImageIcon(getClass().getResource("/resources/images/KetonixGrey.png")));
/*     */     
/* 176 */     this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/resources/images/KetonixLogo.png")));
/*     */     
/* 178 */     GroupLayout panel1Layout = new GroupLayout(this.panel1);
/* 179 */     this.panel1.setLayout(panel1Layout);
/* 180 */     panel1Layout.setHorizontalGroup(panel1Layout
/* 181 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 182 */       .addGroup(panel1Layout.createSequentialGroup()
/* 183 */       .addGap(20, 20, 20)
/* 184 */       .addComponent(this.jLabel1)
/* 185 */       .addContainerGap(235, 32767))
/* 186 */       .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
/* 187 */       .addContainerGap()
/* 188 */       .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
/* 189 */       .addComponent(this.calibrationLabel, -2, 147, -2)
/* 190 */       .addComponent(this.iconLabel, -2, 217, -2)
/* 191 */       .addComponent(this.progressBar, -2, 275, -2)
/* 192 */       .addComponent(this.startButton, -2, 150, -2))
/* 193 */       .addGap(60, 60, 60)));
/*     */     
/* 195 */     panel1Layout.setVerticalGroup(panel1Layout
/* 196 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 197 */       .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
/* 198 */       .addContainerGap()
/* 199 */       .addComponent(this.jLabel1)
/* 200 */       .addGap(18, 18, 18)
/* 201 */       .addComponent(this.calibrationLabel)
/* 202 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 203 */       .addComponent(this.iconLabel)
/* 204 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 205 */       .addComponent(this.progressBar, -2, 32, -2)
/* 206 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 207 */       .addComponent(this.startButton)
/* 208 */       .addGap(45, 45, 45)));
/*     */     
/*     */ 
/* 211 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 212 */     getContentPane().setLayout(layout);
/* 213 */     layout.setHorizontalGroup(layout
/* 214 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 215 */       .addComponent(this.panel1, -1, -1, 32767));
/*     */     
/* 217 */     layout.setVerticalGroup(layout
/* 218 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 219 */       .addComponent(this.panel1, -2, -1, -2));
/*     */     
/*     */ 
/* 222 */     pack();
/*     */   }
/*     */   
/*     */   private void startButtonActionPerformed(ActionEvent evt)
/*     */   {
/* 227 */     if (this.stopCalibrating == true)
/*     */     {
/* 229 */       this.stopCalibrating = false;
/* 230 */       this.calibrationThread = new Thread(new CalibrationThread(this, this.gui));
/* 231 */       this.calibrationThread.start();
/*     */       
/* 233 */       this.startButton.setEnabled(false);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private Panel panel1;
/*     */   
/*     */   private JProgressBar progressBar;
/*     */   
/*     */   private JButton startButton;
/*     */   
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 248 */       for (UIManager.LookAndFeelInfo info : ) {
/* 249 */         if ("Nimbus".equals(info.getName())) {
/* 250 */           UIManager.setLookAndFeel(info.getClassName());
/* 251 */           break;
/*     */         }
/*     */       }
/*     */     } catch (ClassNotFoundException ex) {
/* 255 */       Logger.getLogger(CalibrateDialog.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 257 */       Logger.getLogger(CalibrateDialog.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 259 */       Logger.getLogger(CalibrateDialog.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (UnsupportedLookAndFeelException ex) {
/* 261 */       Logger.getLogger(CalibrateDialog.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 266 */     EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 268 */         CalibrateDialog dialog = new CalibrateDialog(new JFrame(), true, null);
/* 269 */         dialog.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent e) {
/* 272 */             System.exit(0);
/*     */           }
/* 274 */         });
/* 275 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/com/ketonix/ketonixpro/CalibrateDialog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */