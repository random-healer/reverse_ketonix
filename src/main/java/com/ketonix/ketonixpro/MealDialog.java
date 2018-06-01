/*     */ package com.ketonix.ketonixpro;
/*     */ 
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JSpinner;
/*     */ import javax.swing.SpinnerNumberModel;
/*     */ 
/*     */ public class MealDialog extends javax.swing.JDialog
/*     */ {
/*     */   KSync gui;
/*     */   java.util.Date theDate;
/*     */   int fatAmount;
/*     */   int proteinAmount;
/*     */   int carbAmount;
/*     */   int waterAmount;
/*     */   double alcoholAmount;
/*     */   double ketoRatio;
/*     */   int caloriesAmount;
/*     */   private JSpinner alcoholSpinner;
/*     */   private JLabel caloriesLabel;
/*     */   private javax.swing.JButton cancelButton;
/*     */   private JSpinner carbSpinner;
/*     */   private JSpinner fatSpinner;
/*     */   private JLabel jLabel1;
/*     */   
/*     */   public void updateValues()
/*     */   {
/*  31 */     SpinnerNumberModel snm = (SpinnerNumberModel)this.fatSpinner.getModel();
/*  32 */     this.fatAmount = snm.getNumber().intValue();
/*  33 */     snm = (SpinnerNumberModel)this.proteinSpinner.getModel();
/*  34 */     this.proteinAmount = snm.getNumber().intValue();
/*  35 */     snm = (SpinnerNumberModel)this.carbSpinner.getModel();
/*  36 */     this.carbAmount = snm.getNumber().intValue();
/*  37 */     snm = (SpinnerNumberModel)this.waterSpinner.getModel();
/*  38 */     this.waterAmount = snm.getNumber().intValue();
/*  39 */     snm = (SpinnerNumberModel)this.alcoholSpinner.getModel();
/*  40 */     this.alcoholAmount = snm.getNumber().doubleValue();
/*  41 */     this.caloriesAmount = (this.fatAmount * 9 + this.proteinAmount * 4 + this.carbAmount * 4);
/*     */     
/*  43 */     this.ketoRatio = ((this.fatAmount * 0.9D + this.proteinAmount * 0.46D) / (this.fatAmount * 0.1D + this.proteinAmount * 0.54D + this.carbAmount));
/*  44 */     java.text.DecimalFormat df = new java.text.DecimalFormat("#.#");
/*  45 */     String ketoStr = df.format(this.ketoRatio).replace(',', '.');
/*  46 */     javax.swing.SpinnerDateModel sdm = (javax.swing.SpinnerDateModel)this.timestampSpinner.getModel();
/*  47 */     this.theDate = sdm.getDate();
/*     */     
/*  49 */     this.ketogenicRatioLabel.setText(ketoStr + ":1");
/*  50 */     this.caloriesLabel.setText("" + this.caloriesAmount);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public MealDialog(java.awt.Frame parent, boolean modal, KSync caller)
/*     */   {
/*  57 */     super(parent, modal);
/*  58 */     initComponents();
/*  59 */     this.gui = caller;
/*     */   }
/*     */   
/*     */   private JLabel jLabel11;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   private JLabel jLabel6;
/*     */   private JLabel jLabel7;
/*     */   
/*     */   private void initComponents() {
/*  71 */     this.jPanel1 = new javax.swing.JPanel();
/*  72 */     this.jLabel1 = new JLabel();
/*  73 */     this.jLabel2 = new JLabel();
/*  74 */     this.jLabel3 = new JLabel();
/*  75 */     this.jLabel4 = new JLabel();
/*  76 */     this.jLabel5 = new JLabel();
/*  77 */     this.jLabel6 = new JLabel();
/*  78 */     this.fatSpinner = new JSpinner();
/*  79 */     this.proteinSpinner = new JSpinner();
/*  80 */     this.carbSpinner = new JSpinner();
/*  81 */     this.timestampSpinner = new JSpinner();
/*  82 */     this.jLabel7 = new JLabel();
/*  83 */     this.ketogenicRatioLabel = new JLabel();
/*  84 */     this.jLabel9 = new JLabel();
/*  85 */     this.caloriesLabel = new JLabel();
/*  86 */     this.jLabel11 = new JLabel();
/*  87 */     this.waterSpinner = new JSpinner();
/*  88 */     this.saveButton = new javax.swing.JButton();
/*  89 */     this.cancelButton = new javax.swing.JButton();
/*  90 */     this.jLabel8 = new JLabel();
/*  91 */     this.alcoholSpinner = new JSpinner();
/*     */     
/*  93 */     setDefaultCloseOperation(2);
/*  94 */     setTitle("Add Meal");
/*  95 */     setAlwaysOnTop(true);
/*  96 */     setLocation(new java.awt.Point(300, 200));
/*     */     
/*  98 */     this.jPanel1.setBackground(new java.awt.Color(255, 255, 255));
/*     */     
/* 100 */     this.jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/KetonixLogo.png")));
/*     */     
/* 102 */     this.jLabel2.setFont(new java.awt.Font("Lucida Sans", 1, 24));
/* 103 */     this.jLabel2.setText("Add Meal");
/*     */     
/* 105 */     this.jLabel3.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 106 */     this.jLabel3.setText("Fat (gram)");
/*     */     
/* 108 */     this.jLabel4.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 109 */     this.jLabel4.setText("Protein (gram)");
/*     */     
/* 111 */     this.jLabel5.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 112 */     this.jLabel5.setText("Carbohydrates (gram)");
/*     */     
/* 114 */     this.jLabel6.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 115 */     this.jLabel6.setText("Date and time");
/*     */     
/* 117 */     this.fatSpinner.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(25)));
/* 118 */     this.fatSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
/*     */       public void stateChanged(javax.swing.event.ChangeEvent evt) {
/* 120 */         MealDialog.this.stateChanged(evt);
/*     */       }
/*     */       
/* 123 */     });
/* 124 */     this.proteinSpinner.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(25)));
/* 125 */     this.proteinSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
/*     */       public void stateChanged(javax.swing.event.ChangeEvent evt) {
/* 127 */         MealDialog.this.stateChanged(evt);
/*     */       }
/*     */       
/* 130 */     });
/* 131 */     this.carbSpinner.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
/* 132 */     this.carbSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
/*     */       public void stateChanged(javax.swing.event.ChangeEvent evt) {
/* 134 */         MealDialog.this.stateChanged(evt);
/*     */       }
/*     */       
/* 137 */     });
/* 138 */     this.timestampSpinner.setModel(new javax.swing.SpinnerDateModel());
/*     */     
/* 140 */     this.jLabel7.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 141 */     this.jLabel7.setText("Ketogenic Ratio:");
/*     */     
/* 143 */     this.ketogenicRatioLabel.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 144 */     this.ketogenicRatioLabel.setHorizontalAlignment(4);
/* 145 */     this.ketogenicRatioLabel.setText("0:1");
/* 146 */     this.ketogenicRatioLabel.setToolTipText("");
/*     */     
/* 148 */     this.jLabel9.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 149 */     this.jLabel9.setText("Calories");
/*     */     
/* 151 */     this.caloriesLabel.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 152 */     this.caloriesLabel.setHorizontalAlignment(4);
/* 153 */     this.caloriesLabel.setText("1000");
/*     */     
/* 155 */     this.jLabel11.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 156 */     this.jLabel11.setText("Water (ml)");
/*     */     
/* 158 */     this.waterSpinner.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(100)));
/* 159 */     this.waterSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
/*     */       public void stateChanged(javax.swing.event.ChangeEvent evt) {
/* 161 */         MealDialog.this.stateChanged(evt);
/*     */       }
/*     */       
/* 164 */     });
/* 165 */     this.saveButton.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 166 */     this.saveButton.setText("Save");
/* 167 */     this.saveButton.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 169 */         MealDialog.this.saveButtonActionPerformed(evt);
/*     */       }
/*     */       
/* 172 */     });
/* 173 */     this.cancelButton.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 174 */     this.cancelButton.setText("Cancel");
/* 175 */     this.cancelButton.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 177 */         MealDialog.this.cancelButtonActionPerformed(evt);
/*     */       }
/*     */       
/* 180 */     });
/* 181 */     this.jLabel8.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 182 */     this.jLabel8.setText("Alcohol (units)");
/*     */     
/* 184 */     this.alcoholSpinner.setModel(new SpinnerNumberModel(Double.valueOf(0.0D), Double.valueOf(0.0D), null, Double.valueOf(1.0D)));
/* 185 */     this.alcoholSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
/*     */       public void stateChanged(javax.swing.event.ChangeEvent evt) {
/* 187 */         MealDialog.this.stateChanged(evt);
/*     */       }
/*     */       
/* 190 */     });
/* 191 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 192 */     this.jPanel1.setLayout(jPanel1Layout);
/* 193 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 194 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 195 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 196 */       .addGap(20, 20, 20)
/* 197 */       .addComponent(this.jLabel1)
/* 198 */       .addContainerGap(-1, 32767))
/* 199 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 200 */       .addGap(29, 29, 29)
/* 201 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 202 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 203 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 204 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 205 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 206 */       .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/* 207 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 208 */       .addComponent(this.jLabel3)
/* 209 */       .addComponent(this.jLabel4))
/* 210 */       .addGap(74, 74, 74))
/* 211 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 212 */       .addComponent(this.jLabel5)
/* 213 */       .addGap(22, 22, 22)))
/* 214 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 215 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 216 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 217 */       .addComponent(this.carbSpinner, GroupLayout.Alignment.TRAILING, -2, 70, -2)
/* 218 */       .addComponent(this.proteinSpinner, GroupLayout.Alignment.TRAILING, -2, 70, -2))
/* 219 */       .addComponent(this.fatSpinner, GroupLayout.Alignment.TRAILING, -2, 70, -2)))
/* 220 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 221 */       .addComponent(this.jLabel6)
/* 222 */       .addGap(18, 18, 18)
/* 223 */       .addComponent(this.timestampSpinner)))
/* 224 */       .addGap(18, 18, 18)
/* 225 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 226 */       .addComponent(this.jLabel7)
/* 227 */       .addComponent(this.jLabel11)
/* 228 */       .addComponent(this.jLabel9)
/* 229 */       .addComponent(this.jLabel8))
/* 230 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 231 */       .addComponent(this.ketogenicRatioLabel, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 232 */       .addComponent(this.caloriesLabel, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 233 */       .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/* 234 */       .addGap(0, 0, 32767)
/* 235 */       .addComponent(this.waterSpinner, -2, 70, -2))
/* 236 */       .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/* 237 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 238 */       .addComponent(this.alcoholSpinner, -2, 70, -2)))
/* 239 */       .addGap(20, 20, 20))
/* 240 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 241 */       .addGap(120, 120, 120)
/* 242 */       .addComponent(this.saveButton, -2, 100, -2)
/* 243 */       .addGap(44, 44, 44)
/* 244 */       .addComponent(this.cancelButton, -2, 100, -2)
/* 245 */       .addContainerGap(-1, 32767))))
/* 246 */       .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/* 247 */       .addContainerGap(-1, 32767)
/* 248 */       .addComponent(this.jLabel2, -2, 137, -2)
/* 249 */       .addGap(173, 173, 173)));
/*     */     
/* 251 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 252 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 253 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 254 */       .addGap(20, 20, 20)
/* 255 */       .addComponent(this.jLabel1, -2, 46, -2)
/* 256 */       .addGap(18, 18, 18)
/* 257 */       .addComponent(this.jLabel2)
/* 258 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
/* 259 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 260 */       .addComponent(this.jLabel3)
/* 261 */       .addComponent(this.fatSpinner, -2, -1, -2)
/* 262 */       .addComponent(this.jLabel7)
/* 263 */       .addComponent(this.ketogenicRatioLabel))
/* 264 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 265 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 266 */       .addComponent(this.jLabel4)
/* 267 */       .addComponent(this.proteinSpinner, -2, -1, -2)
/* 268 */       .addComponent(this.jLabel9)
/* 269 */       .addComponent(this.caloriesLabel))
/* 270 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 271 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 272 */       .addComponent(this.jLabel5)
/* 273 */       .addComponent(this.carbSpinner, -2, -1, -2)
/* 274 */       .addComponent(this.jLabel11)
/* 275 */       .addComponent(this.waterSpinner, -2, -1, -2))
/* 276 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 277 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 278 */       .addComponent(this.jLabel6)
/* 279 */       .addComponent(this.timestampSpinner, -2, -1, -2)
/* 280 */       .addComponent(this.jLabel8)
/* 281 */       .addComponent(this.alcoholSpinner, -2, -1, -2))
/* 282 */       .addGap(18, 18, 32767)
/* 283 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 284 */       .addComponent(this.saveButton)
/* 285 */       .addComponent(this.cancelButton))
/* 286 */       .addGap(30, 30, 30)));
/*     */     
/*     */ 
/* 289 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 290 */     getContentPane().setLayout(layout);
/* 291 */     layout.setHorizontalGroup(layout
/* 292 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 293 */       .addComponent(this.jPanel1, -2, -1, -2));
/*     */     
/* 295 */     layout.setVerticalGroup(layout
/* 296 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 297 */       .addComponent(this.jPanel1, -1, -1, 32767));
/*     */     
/*     */ 
/* 300 */     pack();
/*     */   }
/*     */   
/*     */   private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {
/* 304 */     updateValues();
/* 305 */     this.gui.saveMeal(this.theDate, this.fatAmount, this.proteinAmount, this.carbAmount, this.waterAmount, this.caloriesAmount, this.alcoholAmount, this.ketoRatio);
/* 306 */     dispose();
/*     */   }
/*     */   
/*     */   private void stateChanged(javax.swing.event.ChangeEvent evt)
/*     */   {
/* 311 */     updateValues();
/*     */   }
/*     */   
/*     */   private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
/* 315 */     dispose();
/*     */   }
/*     */   
/*     */   private JLabel jLabel8;
/*     */   private JLabel jLabel9;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private JLabel ketogenicRatioLabel;
/*     */   private JSpinner proteinSpinner;
/*     */   private javax.swing.JButton saveButton;
/*     */   private JSpinner timestampSpinner;
/*     */   private JSpinner waterSpinner;
/*     */   public static void main(String[] args) {
/*     */     try {
/* 328 */       for (javax.swing.UIManager.LookAndFeelInfo info : ) {
/* 329 */         if ("Nimbus".equals(info.getName())) {
/* 330 */           javax.swing.UIManager.setLookAndFeel(info.getClassName());
/* 331 */           break;
/*     */         }
/*     */       }
/*     */     } catch (ClassNotFoundException ex) {
/* 335 */       java.util.logging.Logger.getLogger(MealDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 337 */       java.util.logging.Logger.getLogger(MealDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 339 */       java.util.logging.Logger.getLogger(MealDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
/* 341 */       java.util.logging.Logger.getLogger(MealDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 346 */     java.awt.EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 348 */         MealDialog dialog = new MealDialog(new javax.swing.JFrame(), true, null);
/* 349 */         dialog.addWindowListener(new java.awt.event.WindowAdapter()
/*     */         {
/*     */           public void windowClosing(java.awt.event.WindowEvent e) {
/* 352 */             System.exit(0);
/*     */           }
/* 354 */         });
/* 355 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/com/ketonix/ketonixpro/MealDialog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */