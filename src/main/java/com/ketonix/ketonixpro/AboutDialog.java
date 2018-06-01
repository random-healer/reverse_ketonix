/*     */ package com.ketonix.ketonixpro;
/*     */ 
/*     */ import javax.swing.JLabel;
/*     */ 
/*     */ public class AboutDialog extends javax.swing.JDialog { private javax.swing.JButton jButton1;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private JLabel javaLibraryPath;
/*     */   private JLabel javaRuntimeVersion;
/*     */   private JLabel javaSpecificationVersion;
/*     */   private JLabel javaVersion;
/*     */   private JLabel javaVmVersion;
/*     */   
/*  18 */   public AboutDialog(java.awt.Frame parent, boolean modal) { super(parent, modal);
/*  19 */     initComponents();
/*  20 */     String jlp = System.getProperty("java.library.path");
/*  21 */     this.javaLibraryPath.setText(jlp);
/*  22 */     this.javaRuntimeVersion.setText("java.runtime.version: " + System.getProperty("java.runtime.version"));
/*  23 */     this.javaSpecificationVersion.setText("java.specification.version: " + System.getProperty("java.specification.version"));
/*  24 */     this.javaVersion.setText("java.version: " + System.getProperty("java.version"));
/*  25 */     this.javaVmVersion.setText("java.vm.version: " + System.getProperty("java.vm.version"));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  37 */     this.jPanel1 = new javax.swing.JPanel();
/*  38 */     this.jLabel1 = new JLabel();
/*  39 */     this.jLabel2 = new JLabel();
/*  40 */     this.jLabel3 = new JLabel();
/*  41 */     this.jLabel4 = new JLabel();
/*  42 */     this.jLabel5 = new JLabel();
/*  43 */     this.jButton1 = new javax.swing.JButton();
/*  44 */     this.javaSpecificationVersion = new JLabel();
/*  45 */     this.javaVersion = new JLabel();
/*  46 */     this.javaVmVersion = new JLabel();
/*  47 */     this.javaRuntimeVersion = new JLabel();
/*  48 */     this.javaLibraryPath = new JLabel();
/*     */     
/*  50 */     setDefaultCloseOperation(2);
/*  51 */     setTitle("About Ketonix");
/*     */     
/*  53 */     this.jPanel1.setBackground(new java.awt.Color(255, 255, 255));
/*     */     
/*  55 */     this.jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/KetonixLogo.png")));
/*     */     
/*  57 */     this.jLabel2.setText("Build 1, 2017-03-10");
/*     */     
/*  59 */     this.jLabel3.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/*  60 */     this.jLabel3.setText("Copyright Ketonix AB, 2015,2016");
/*     */     
/*  62 */     this.jLabel4.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/*  63 */     this.jLabel4.setText("Website: www.ketonix.com");
/*     */     
/*  65 */     this.jLabel5.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/*  66 */     this.jLabel5.setText("Email: support@ketonix.com");
/*     */     
/*  68 */     this.jButton1.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/*  69 */     this.jButton1.setText("OK");
/*  70 */     this.jButton1.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/*  72 */         AboutDialog.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */       
/*  75 */     });
/*  76 */     this.javaSpecificationVersion.setHorizontalAlignment(0);
/*  77 */     this.javaSpecificationVersion.setText("java.specification.version ");
/*     */     
/*  79 */     this.javaVersion.setHorizontalAlignment(0);
/*  80 */     this.javaVersion.setText("java.version");
/*     */     
/*  82 */     this.javaVmVersion.setHorizontalAlignment(0);
/*  83 */     this.javaVmVersion.setText("java.vm.version");
/*     */     
/*  85 */     this.javaRuntimeVersion.setHorizontalAlignment(0);
/*  86 */     this.javaRuntimeVersion.setText("java.runtime.version");
/*     */     
/*  88 */     this.javaLibraryPath.setHorizontalAlignment(0);
/*  89 */     this.javaLibraryPath.setText("java.library.path");
/*     */     
/*  91 */     javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(this.jPanel1);
/*  92 */     this.jPanel1.setLayout(jPanel1Layout);
/*  93 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/*  94 */       .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/*  95 */       .addGroup(jPanel1Layout.createSequentialGroup()
/*  96 */       .addGap(31, 31, 31)
/*  97 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
/*  98 */       .addComponent(this.jLabel1)
/*  99 */       .addComponent(this.jLabel2)
/* 100 */       .addComponent(this.javaSpecificationVersion, -1, -1, 32767)
/* 101 */       .addComponent(this.javaVersion, -2, 238, -2)
/* 102 */       .addComponent(this.javaVmVersion, -2, 254, -2)
/* 103 */       .addComponent(this.javaRuntimeVersion, -2, 236, -2)
/* 104 */       .addComponent(this.javaLibraryPath, -2, 342, -2)
/* 105 */       .addComponent(this.jLabel3)
/* 106 */       .addComponent(this.jLabel4)
/* 107 */       .addComponent(this.jLabel5)
/* 108 */       .addComponent(this.jButton1))
/* 109 */       .addGap(23, 23, 23)));
/*     */     
/* 111 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 112 */       .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 113 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 114 */       .addGap(31, 31, 31)
/* 115 */       .addComponent(this.jLabel1)
/* 116 */       .addGap(18, 18, 18)
/* 117 */       .addComponent(this.jLabel2)
/* 118 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 119 */       .addComponent(this.javaSpecificationVersion)
/* 120 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 121 */       .addComponent(this.javaVersion)
/* 122 */       .addGap(5, 5, 5)
/* 123 */       .addComponent(this.javaVmVersion)
/* 124 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 125 */       .addComponent(this.javaRuntimeVersion)
/* 126 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, 32767)
/* 127 */       .addComponent(this.javaLibraryPath)
/* 128 */       .addGap(18, 18, 18)
/* 129 */       .addComponent(this.jLabel3)
/* 130 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 131 */       .addComponent(this.jLabel4)
/* 132 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 133 */       .addComponent(this.jLabel5)
/* 134 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
/* 135 */       .addComponent(this.jButton1)
/* 136 */       .addGap(19, 19, 19)));
/*     */     
/*     */ 
/* 139 */     javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
/* 140 */     getContentPane().setLayout(layout);
/* 141 */     layout.setHorizontalGroup(layout
/* 142 */       .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 143 */       .addGroup(layout.createSequentialGroup()
/* 144 */       .addContainerGap()
/* 145 */       .addComponent(this.jPanel1, -1, -1, 32767)));
/*     */     
/* 147 */     layout.setVerticalGroup(layout
/* 148 */       .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 149 */       .addComponent(this.jPanel1, -1, -1, 32767));
/*     */     
/*     */ 
/* 152 */     pack();
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
/* 156 */     dispose();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 169 */       for (javax.swing.UIManager.LookAndFeelInfo info : ) {
/* 170 */         if ("Nimbus".equals(info.getName())) {
/* 171 */           javax.swing.UIManager.setLookAndFeel(info.getClassName());
/* 172 */           break;
/*     */         }
/*     */       }
/*     */     } catch (ClassNotFoundException ex) {
/* 176 */       java.util.logging.Logger.getLogger(AboutDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 178 */       java.util.logging.Logger.getLogger(AboutDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 180 */       java.util.logging.Logger.getLogger(AboutDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
/* 182 */       java.util.logging.Logger.getLogger(AboutDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 187 */     java.awt.EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 189 */         AboutDialog dialog = new AboutDialog(new javax.swing.JFrame(), true);
/* 190 */         dialog.addWindowListener(new java.awt.event.WindowAdapter()
/*     */         {
/*     */           public void windowClosing(java.awt.event.WindowEvent e) {
/* 193 */             System.exit(0);
/*     */           }
/* 195 */         });
/* 196 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/com/ketonix/ketonixpro/AboutDialog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */