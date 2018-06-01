/*     */ package com.ketonix.ketonixpro;
/*     */ 
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ 
/*     */ public class CommentDialog extends javax.swing.JDialog
/*     */ {
/*     */   KSync gui;
/*     */   private javax.swing.JButton CancelButton;
/*     */   private javax.swing.JButton SaveButton;
/*     */   private datechooser.beans.DateChooserCombo commentDate;
/*     */   private javax.swing.JTextField commentText;
/*     */   private javax.swing.JLabel jLabel1;
/*     */   private javax.swing.JLabel jLabel2;
/*     */   private javax.swing.JLabel jLabel3;
/*     */   private javax.swing.JLabel jLabel4;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   
/*     */   public CommentDialog(KSync parent, boolean modal)
/*     */   {
/*  21 */     super(parent, modal);
/*  22 */     this.gui = parent;
/*  23 */     initComponents();
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
/*  35 */     this.jPanel1 = new javax.swing.JPanel();
/*  36 */     this.jLabel1 = new javax.swing.JLabel();
/*  37 */     this.jLabel2 = new javax.swing.JLabel();
/*  38 */     this.commentDate = new datechooser.beans.DateChooserCombo();
/*  39 */     this.commentText = new javax.swing.JTextField();
/*  40 */     this.jLabel3 = new javax.swing.JLabel();
/*  41 */     this.CancelButton = new javax.swing.JButton();
/*  42 */     this.SaveButton = new javax.swing.JButton();
/*  43 */     this.jLabel4 = new javax.swing.JLabel();
/*     */     
/*  45 */     setDefaultCloseOperation(2);
/*  46 */     setBackground(new java.awt.Color(255, 255, 255));
/*     */     
/*  48 */     this.jPanel1.setBackground(new java.awt.Color(255, 255, 255));
/*     */     
/*  50 */     this.jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/KetonixLogoR.png")));
/*     */     
/*  52 */     this.jLabel2.setText("Date:");
/*     */     
/*  54 */     this.jLabel3.setText("Comment: ");
/*     */     
/*  56 */     this.CancelButton.setText("Cancel");
/*  57 */     this.CancelButton.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/*  59 */         CommentDialog.this.CancelButtonActionPerformed(evt);
/*     */       }
/*     */       
/*  62 */     });
/*  63 */     this.SaveButton.setText("Save");
/*  64 */     this.SaveButton.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/*  66 */         CommentDialog.this.SaveButtonActionPerformed(evt);
/*     */       }
/*     */       
/*  69 */     });
/*  70 */     this.jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 10));
/*  71 */     this.jLabel4.setText("The comment is (currently) saved to your local data file");
/*     */     
/*  73 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  74 */     this.jPanel1.setLayout(jPanel1Layout);
/*  75 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/*  76 */       .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/*  77 */       .addGroup(jPanel1Layout.createSequentialGroup()
/*  78 */       .addGap(23, 23, 23)
/*  79 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/*  80 */       .addGroup(jPanel1Layout.createSequentialGroup()
/*  81 */       .addGap(15, 15, 15)
/*  82 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/*  83 */       .addComponent(this.jLabel3)
/*  84 */       .addComponent(this.jLabel2))
/*  85 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/*  86 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/*  87 */       .addComponent(this.commentDate, -2, -1, -2)
/*  88 */       .addGroup(jPanel1Layout.createSequentialGroup()
/*  89 */       .addComponent(this.CancelButton)
/*  90 */       .addGap(32, 32, 32)
/*  91 */       .addComponent(this.SaveButton))
/*  92 */       .addComponent(this.commentText, -2, 273, -2)
/*  93 */       .addComponent(this.jLabel4)))
/*  94 */       .addComponent(this.jLabel1))
/*  95 */       .addContainerGap(51, 32767)));
/*     */     
/*  97 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/*  98 */       .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/*  99 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 100 */       .addGap(25, 25, 25)
/* 101 */       .addComponent(this.jLabel1)
/* 102 */       .addGap(18, 18, 18)
/* 103 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
/* 104 */       .addComponent(this.commentDate, -2, -1, -2)
/* 105 */       .addComponent(this.jLabel2))
/* 106 */       .addGap(18, 18, 18)
/* 107 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
/* 108 */       .addComponent(this.commentText, -2, -1, -2)
/* 109 */       .addComponent(this.jLabel3))
/* 110 */       .addGap(5, 5, 5)
/* 111 */       .addComponent(this.jLabel4)
/* 112 */       .addGap(18, 18, 18)
/* 113 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
/* 114 */       .addComponent(this.CancelButton)
/* 115 */       .addComponent(this.SaveButton))
/* 116 */       .addContainerGap(31, 32767)));
/*     */     
/*     */ 
/* 119 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 120 */     getContentPane().setLayout(layout);
/* 121 */     layout.setHorizontalGroup(layout
/* 122 */       .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 123 */       .addComponent(this.jPanel1, -2, -1, -2));
/*     */     
/* 125 */     layout.setVerticalGroup(layout
/* 126 */       .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 127 */       .addComponent(this.jPanel1, -1, -1, 32767));
/*     */     
/*     */ 
/* 130 */     pack();
/*     */   }
/*     */   
/*     */   private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
/* 134 */     dispose();
/*     */   }
/*     */   
/*     */   private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {
/* 138 */     this.gui.saveComment(this.commentDate.getCurrent().getTime(), this.commentText.getText());
/* 139 */     dispose();
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/com/ketonix/ketonixpro/CommentDialog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */