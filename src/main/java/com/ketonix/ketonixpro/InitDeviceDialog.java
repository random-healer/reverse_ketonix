/*     */ package com.ketonix.ketonixpro;
/*     */ 
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ 
/*     */ public class InitDeviceDialog extends javax.swing.JDialog
/*     */ {
/*     */   private static final long READ_UPDATE_DELAY_MS = 50L;
/*     */   static final int VENDOR_ID = 1240;
/*     */   static final int PRODUCT_ID = 62547;
/*     */   private static final int BUFSIZE = 64;
/*     */   KSync ksync;
/*     */   private javax.swing.JButton applyButton;
/*     */   private javax.swing.ButtonGroup buttonGroup1;
/*     */   private javax.swing.JButton closeButton;
/*     */   private javax.swing.JTextField idTextField;
/*     */   private javax.swing.JLabel jLabel1;
/*     */   private javax.swing.JLabel jLabel2;
/*     */   private javax.swing.JLabel jLabel3;
/*     */   private javax.swing.JLabel jLabel4;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private javax.swing.JRadioButton sportRadioButton;
/*     */   private javax.swing.JRadioButton standardRadioButton;
/*     */   
/*     */   public InitDeviceDialog(java.awt.Frame parent, boolean modal, KSync k)
/*     */   {
/*  28 */     super(parent, modal);
/*  29 */     this.ksync = k;
/*  30 */     initComponents();
/*  31 */     if (this.ksync.getCurrentType() == 0) {
/*  32 */       System.out.println("currentType is 0(standard)");
/*  33 */       this.standardRadioButton.setSelected(true);
/*  34 */       this.sportRadioButton.setSelected(false);
/*     */     } else {
/*  36 */       System.out.println("currentType is 1 (sport)");
/*  37 */       this.standardRadioButton.setSelected(false);
/*  38 */       this.sportRadioButton.setSelected(true);
/*     */     }
/*  40 */     System.out.println("currentId is " + this.ksync.getCurrentId());
/*  41 */     this.idTextField.setText("" + this.ksync.getCurrentId());
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
/*  53 */     this.buttonGroup1 = new javax.swing.ButtonGroup();
/*  54 */     this.jPanel1 = new javax.swing.JPanel();
/*  55 */     this.jLabel1 = new javax.swing.JLabel();
/*  56 */     this.applyButton = new javax.swing.JButton();
/*  57 */     this.closeButton = new javax.swing.JButton();
/*  58 */     this.jLabel2 = new javax.swing.JLabel();
/*  59 */     this.idTextField = new javax.swing.JTextField();
/*  60 */     this.jLabel3 = new javax.swing.JLabel();
/*  61 */     this.jLabel4 = new javax.swing.JLabel();
/*  62 */     this.standardRadioButton = new javax.swing.JRadioButton();
/*  63 */     this.sportRadioButton = new javax.swing.JRadioButton();
/*     */     
/*  65 */     setDefaultCloseOperation(2);
/*  66 */     setLocation(new java.awt.Point(320, 220));
/*     */     
/*  68 */     this.jPanel1.setBackground(new java.awt.Color(255, 255, 255));
/*     */     
/*  70 */     this.jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 18));
/*  71 */     this.jLabel1.setText("Initialize Device");
/*     */     
/*  73 */     this.applyButton.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/*  74 */     this.applyButton.setText("Apply");
/*  75 */     this.applyButton.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/*  77 */         InitDeviceDialog.this.applyButtonActionPerformed(evt);
/*     */       }
/*     */       
/*  80 */     });
/*  81 */     this.closeButton.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/*  82 */     this.closeButton.setText("Close");
/*  83 */     this.closeButton.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/*  85 */         InitDeviceDialog.this.closeButtonActionPerformed(evt);
/*     */       }
/*     */       
/*  88 */     });
/*  89 */     this.jLabel2.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/*  90 */     this.jLabel2.setText("ID");
/*     */     
/*  92 */     this.jLabel3.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/*  93 */     this.jLabel3.setIcon(new javax.swing.ImageIcon("/Users/michel/ketonix/prod/A02/design/software/NetBeans/KetonixPro/src/main/java/com/ketonix/ketonixpro/KetonixBlue.png"));
/*     */     
/*  95 */     this.jLabel4.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/*  96 */     this.jLabel4.setIcon(new javax.swing.ImageIcon("/Users/michel/ketonix/prod/A02/design/software/NetBeans/KetonixPro/src/main/java/com/ketonix/ketonixpro/KetonixRed.png"));
/*     */     
/*  98 */     this.buttonGroup1.add(this.standardRadioButton);
/*  99 */     this.standardRadioButton.setSelected(true);
/* 100 */     this.standardRadioButton.setActionCommand("StandardSelected");
/*     */     
/* 102 */     this.buttonGroup1.add(this.sportRadioButton);
/* 103 */     this.sportRadioButton.setActionCommand("SportSelected");
/*     */     
/* 105 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 106 */     this.jPanel1.setLayout(jPanel1Layout);
/* 107 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 108 */       .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 109 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 110 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 111 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 112 */       .addGap(56, 56, 56)
/* 113 */       .addComponent(this.standardRadioButton))
/* 114 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 115 */       .addGap(56, 56, 56)
/* 116 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
/* 117 */       .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/* 118 */       .addComponent(this.applyButton)
/* 119 */       .addGap(63, 63, 63)
/* 120 */       .addComponent(this.closeButton))
/* 121 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 122 */       .addComponent(this.sportRadioButton)
/* 123 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 124 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 125 */       .addComponent(this.jLabel3)
/* 126 */       .addComponent(this.jLabel4)))))
/* 127 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 128 */       .addGap(120, 120, 120)
/* 129 */       .addComponent(this.jLabel2)
/* 130 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 131 */       .addComponent(this.idTextField, -2, 98, -2))
/* 132 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 133 */       .addGap(109, 109, 109)
/* 134 */       .addComponent(this.jLabel1)))
/* 135 */       .addGap(56, 56, 56)));
/*     */     
/* 137 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 138 */       .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 139 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 140 */       .addContainerGap(-1, 32767)
/* 141 */       .addComponent(this.jLabel1)
/* 142 */       .addGap(18, 18, 18)
/* 143 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
/* 144 */       .addComponent(this.standardRadioButton)
/* 145 */       .addComponent(this.jLabel3))
/* 146 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 147 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
/* 148 */       .addComponent(this.sportRadioButton)
/* 149 */       .addComponent(this.jLabel4))
/* 150 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 151 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
/* 152 */       .addComponent(this.jLabel2)
/* 153 */       .addComponent(this.idTextField, -2, -1, -2))
/* 154 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
/* 155 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
/* 156 */       .addComponent(this.applyButton)
/* 157 */       .addComponent(this.closeButton))
/* 158 */       .addGap(20, 20, 20)));
/*     */     
/*     */ 
/* 161 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 162 */     getContentPane().setLayout(layout);
/* 163 */     layout.setHorizontalGroup(layout
/* 164 */       .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 165 */       .addComponent(this.jPanel1, -1, -1, 32767));
/*     */     
/* 167 */     layout.setVerticalGroup(layout
/* 168 */       .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 169 */       .addComponent(this.jPanel1, -1, -1, 32767));
/*     */     
/*     */ 
/* 172 */     pack();
/*     */   }
/*     */   
/*     */   private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {
/* 176 */     System.out.println("Write type and id to device");
/*     */     try
/*     */     {
/* 179 */       com.codeminders.hidapi.HIDManager hid_mgr = com.codeminders.hidapi.HIDManager.getInstance();
/* 180 */       com.codeminders.hidapi.HIDDevice dev = hid_mgr.openById(1240, 62547, null);
/* 181 */       System.err.print("Manufacturer: " + dev.getManufacturerString() + "\n");
/* 182 */       System.err.print("Product: " + dev.getProductString() + "\n");
/* 183 */       System.err.print("Serial Number: " + dev.getSerialNumberString() + "\n");
/*     */       try
/*     */       {
/* 186 */         int type = this.sportRadioButton.isSelected() ? 1 : 0;
/* 187 */         String id_txt = this.idTextField.getText();
/* 188 */         int id = 0;
/*     */         try {
/* 190 */           id = Integer.parseInt(id_txt);
/*     */         } catch (Exception ex) {
/* 192 */           System.out.println(ex.toString());
/* 193 */           return;
/*     */         }
/* 195 */         int raise = 0;
/* 196 */         byte[] buf = new byte[64];
/* 197 */         byte[] cmd = new byte[1];
/*     */         
/*     */ 
/* 200 */         System.out.println("Reading values from device ...");
/* 201 */         cmd[0] = 55;
/* 202 */         dev.enableBlocking();
/* 203 */         dev.write(cmd);
/* 204 */         dev.read(buf);
/*     */         
/* 206 */         buf[15] = ((byte)(type >> 0));
/* 207 */         buf[16] = ((byte)(type >> 8));
/* 208 */         buf[17] = ((byte)(id >> 0));
/* 209 */         buf[18] = ((byte)(id >> 8));
/*     */         
/* 211 */         System.out.println("Writing values to device ...");
/* 212 */         buf[0] = 54;
/*     */         
/* 214 */         dev.write(buf);
/* 215 */         dev.disableBlocking();
/*     */         
/* 217 */         buf[15] = 0;
/* 218 */         buf[16] = 0;
/* 219 */         buf[17] = 0;
/* 220 */         buf[18] = 0;
/*     */         
/*     */ 
/* 223 */         System.out.println("Reading back values from device ...");
/* 224 */         cmd[0] = 55;
/* 225 */         dev.enableBlocking();
/* 226 */         dev.write(cmd);
/* 227 */         dev.read(buf);
/* 228 */         dev.disableBlocking();
/* 229 */         int type2 = (buf[15] << 0) + (buf[16] << 8);
/* 230 */         int id2 = (buf[17] << 0) + (buf[18] << 8);
/* 231 */         System.out.println("type(" + type + "):" + type2 + ", id(" + id + "):" + id2);
/*     */         
/* 233 */         System.out.println("wrote type " + type + ", id " + id);
/*     */         try
/*     */         {
/* 236 */           Thread.sleep(50L);
/*     */         }
/*     */         catch (InterruptedException e) {
/* 239 */           e.printStackTrace();
/*     */         }
/*     */       } finally {
/* 242 */         dev.close();
/* 243 */         hid_mgr.release();
/* 244 */         System.gc();
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 248 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   private void closeButtonActionPerformed(java.awt.event.ActionEvent evt)
/*     */   {
/* 254 */     dispose();
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
/* 267 */       for (javax.swing.UIManager.LookAndFeelInfo info : ) {
/* 268 */         if ("Nimbus".equals(info.getName())) {
/* 269 */           javax.swing.UIManager.setLookAndFeel(info.getClassName());
/* 270 */           break;
/*     */         }
/*     */       }
/*     */     } catch (ClassNotFoundException ex) {
/* 274 */       java.util.logging.Logger.getLogger(InitDeviceDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 276 */       java.util.logging.Logger.getLogger(InitDeviceDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 278 */       java.util.logging.Logger.getLogger(InitDeviceDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
/* 280 */       java.util.logging.Logger.getLogger(InitDeviceDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 285 */     java.awt.EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 287 */         InitDeviceDialog dialog = new InitDeviceDialog(new javax.swing.JFrame(), true, null);
/* 288 */         dialog.addWindowListener(new java.awt.event.WindowAdapter()
/*     */         {
/*     */           public void windowClosing(java.awt.event.WindowEvent e) {
/* 291 */             System.exit(0);
/*     */           }
/* 293 */         });
/* 294 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/com/ketonix/ketonixpro/InitDeviceDialog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */