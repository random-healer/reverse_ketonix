/*     */ package com.ketonix.ketonixpro;
/*     */ 
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JSpinner;
/*     */ 
/*     */ public class BloodTestDialog extends javax.swing.JDialog
/*     */ {
/*     */   KSync gui;
/*     */   private JSpinner bhobSpinner;
/*     */   private javax.swing.JButton cancelButton;
/*     */   private JSpinner cholesterolSpinner;
/*     */   private JSpinner diastolicSpinner;
/*     */   private JSpinner glucoseSpinner;
/*     */   private JSpinner hdlcSpinner;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel10;
/*     */   private JLabel jLabel11;
/*     */   private JLabel jLabel12;
/*     */   
/*     */   public BloodTestDialog(java.awt.Frame parent, boolean modal, KSync caller)
/*     */   {
/*  24 */     super(parent, modal);
/*  25 */     initComponents();
/*  26 */     this.gui = caller;
/*     */   }
/*     */   
/*     */ 
/*     */   private JLabel jLabel13;
/*     */   private JLabel jLabel14;
/*     */   private JLabel jLabel15;
/*     */   private JLabel jLabel16;
/*     */   private JLabel jLabel17;
/*     */   
/*     */   private void initComponents()
/*     */   {
/*  38 */     this.jPanel1 = new javax.swing.JPanel();
/*  39 */     this.jLabel1 = new JLabel();
/*  40 */     this.jLabel2 = new JLabel();
/*  41 */     this.jLabel3 = new JLabel();
/*  42 */     this.jLabel4 = new JLabel();
/*  43 */     this.jLabel5 = new JLabel();
/*  44 */     this.jLabel6 = new JLabel();
/*  45 */     this.jLabel7 = new JLabel();
/*  46 */     this.jLabel8 = new JLabel();
/*  47 */     this.jLabel9 = new JLabel();
/*  48 */     this.jLabel10 = new JLabel();
/*  49 */     this.timestampSpinner = new JSpinner();
/*  50 */     this.ldlpSpinner = new JSpinner();
/*  51 */     this.ldlcSpinner = new JSpinner();
/*  52 */     this.hdlcSpinner = new JSpinner();
/*  53 */     this.triglycerideSpinner = new JSpinner();
/*  54 */     this.cholesterolSpinner = new JSpinner();
/*  55 */     this.smallldlpSpinner = new JSpinner();
/*  56 */     this.vldlSpinner = new JSpinner();
/*  57 */     this.saveButton = new javax.swing.JButton();
/*  58 */     this.cancelButton = new javax.swing.JButton();
/*  59 */     this.jLabel11 = new JLabel();
/*  60 */     this.jLabel12 = new JLabel();
/*  61 */     this.jLabel13 = new JLabel();
/*  62 */     this.systolicSpinner = new JSpinner();
/*  63 */     this.diastolicSpinner = new JSpinner();
/*  64 */     this.pulseSpinner = new JSpinner();
/*  65 */     this.jLabel14 = new JLabel();
/*  66 */     this.jLabel15 = new JLabel();
/*  67 */     this.jLabel16 = new JLabel();
/*  68 */     this.jLabel17 = new JLabel();
/*  69 */     this.jLabel18 = new JLabel();
/*  70 */     this.jLabel19 = new JLabel();
/*  71 */     this.jLabel20 = new JLabel();
/*  72 */     this.jLabel22 = new JLabel();
/*  73 */     this.jLabel23 = new JLabel();
/*  74 */     this.jLabel24 = new JLabel();
/*  75 */     this.jLabel21 = new JLabel();
/*  76 */     this.jLabel26 = new JLabel();
/*  77 */     this.bhobSpinner = new JSpinner();
/*  78 */     this.jLabel27 = new JLabel();
/*  79 */     this.glucoseSpinner = new JSpinner();
/*  80 */     this.jLabel28 = new JLabel();
/*     */     
/*  82 */     setDefaultCloseOperation(2);
/*  83 */     setTitle("Add Blood Test");
/*  84 */     setAlwaysOnTop(true);
/*  85 */     setLocation(new java.awt.Point(300, 200));
/*     */     
/*  87 */     this.jPanel1.setBackground(new java.awt.Color(255, 255, 255));
/*     */     
/*  89 */     this.jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/KetonixLogo.png")));
/*     */     
/*  91 */     this.jLabel2.setFont(new java.awt.Font("Lucida Sans", 1, 24));
/*  92 */     this.jLabel2.setText("Add Blood Test");
/*     */     
/*  94 */     this.jLabel3.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/*  95 */     this.jLabel3.setText("Date");
/*     */     
/*  97 */     this.jLabel4.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/*  98 */     this.jLabel4.setText("LDL-P");
/*     */     
/* 100 */     this.jLabel5.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 101 */     this.jLabel5.setText("LDL-C");
/*     */     
/* 103 */     this.jLabel6.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 104 */     this.jLabel6.setText("HDL-C");
/*     */     
/* 106 */     this.jLabel7.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 107 */     this.jLabel7.setText("Triglycerides");
/*     */     
/* 109 */     this.jLabel8.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 110 */     this.jLabel8.setText("Total Cholesterol");
/*     */     
/* 112 */     this.jLabel9.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 113 */     this.jLabel9.setText("Small LDL-P");
/*     */     
/* 115 */     this.jLabel10.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 116 */     this.jLabel10.setText("VLDL");
/*     */     
/* 118 */     this.timestampSpinner.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 119 */     this.timestampSpinner.setModel(new javax.swing.SpinnerDateModel());
/*     */     
/* 121 */     this.ldlpSpinner.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 122 */     this.ldlpSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(100)));
/*     */     
/* 124 */     this.ldlcSpinner.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 125 */     this.ldlcSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(10)));
/*     */     
/* 127 */     this.hdlcSpinner.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 128 */     this.hdlcSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(10)));
/*     */     
/* 130 */     this.triglycerideSpinner.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 131 */     this.triglycerideSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(100)));
/*     */     
/* 133 */     this.cholesterolSpinner.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 134 */     this.cholesterolSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(50)));
/*     */     
/* 136 */     this.smallldlpSpinner.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 137 */     this.smallldlpSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(100)));
/*     */     
/* 139 */     this.vldlSpinner.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 140 */     this.vldlSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(5)));
/*     */     
/* 142 */     this.saveButton.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 143 */     this.saveButton.setText("Save");
/* 144 */     this.saveButton.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 146 */         BloodTestDialog.this.saveButtonActionPerformed(evt);
/*     */       }
/*     */       
/* 149 */     });
/* 150 */     this.cancelButton.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 151 */     this.cancelButton.setText("Cancel");
/* 152 */     this.cancelButton.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 154 */         BloodTestDialog.this.cancelButtonActionPerformed(evt);
/*     */       }
/*     */       
/* 157 */     });
/* 158 */     this.jLabel11.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 159 */     this.jLabel11.setText("Systolic Blood Pressure");
/*     */     
/* 161 */     this.jLabel12.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 162 */     this.jLabel12.setText("Diastolic Blood Pressure");
/*     */     
/* 164 */     this.jLabel13.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 165 */     this.jLabel13.setText("Pulse");
/*     */     
/* 167 */     this.systolicSpinner.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 168 */     this.systolicSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(10)));
/*     */     
/* 170 */     this.diastolicSpinner.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 171 */     this.diastolicSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(10)));
/*     */     
/* 173 */     this.pulseSpinner.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 174 */     this.pulseSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 250, 10));
/*     */     
/* 176 */     this.jLabel14.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 177 */     this.jLabel14.setText("nmol/L");
/*     */     
/* 179 */     this.jLabel15.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 180 */     this.jLabel15.setText("mg/dL");
/*     */     
/* 182 */     this.jLabel16.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 183 */     this.jLabel16.setText("mg/dL");
/*     */     
/* 185 */     this.jLabel17.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 186 */     this.jLabel17.setText("mg/dL");
/*     */     
/* 188 */     this.jLabel18.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 189 */     this.jLabel18.setText("mg/dL");
/*     */     
/* 191 */     this.jLabel19.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 192 */     this.jLabel19.setText("nmol/L");
/*     */     
/* 194 */     this.jLabel20.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 195 */     this.jLabel20.setText("mg/dL");
/*     */     
/* 197 */     this.jLabel22.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 198 */     this.jLabel22.setText("mm Hg");
/*     */     
/* 200 */     this.jLabel23.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 201 */     this.jLabel23.setText("bpm");
/*     */     
/* 203 */     this.jLabel24.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 204 */     this.jLabel24.setText("Beta-Hydroxybutyrate");
/*     */     
/* 206 */     this.jLabel21.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 207 */     this.jLabel21.setText("mm Hg");
/*     */     
/* 209 */     this.jLabel26.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 210 */     this.jLabel26.setText("Glucose");
/*     */     
/* 212 */     this.bhobSpinner.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 213 */     this.bhobSpinner.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0D), Double.valueOf(0.0D), null, Double.valueOf(0.5D)));
/*     */     
/* 215 */     this.jLabel27.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 216 */     this.jLabel27.setText("mmol/L");
/*     */     
/* 218 */     this.glucoseSpinner.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 219 */     this.glucoseSpinner.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0D), Double.valueOf(0.0D), null, Double.valueOf(0.5D)));
/*     */     
/* 221 */     this.jLabel28.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 222 */     this.jLabel28.setText("mmol/L");
/*     */     
/* 224 */     javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(this.jPanel1);
/* 225 */     this.jPanel1.setLayout(jPanel1Layout);
/* 226 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 227 */       .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 228 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 229 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 230 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 231 */       .addGap(20, 20, 20)
/* 232 */       .addComponent(this.jLabel1))
/* 233 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 234 */       .addGap(30, 30, 30)
/* 235 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 236 */       .addComponent(this.jLabel3)
/* 237 */       .addComponent(this.jLabel4)
/* 238 */       .addComponent(this.jLabel5)
/* 239 */       .addComponent(this.jLabel6)
/* 240 */       .addComponent(this.jLabel7)
/* 241 */       .addComponent(this.jLabel8)
/* 242 */       .addComponent(this.jLabel9)
/* 243 */       .addComponent(this.jLabel10))
/* 244 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
/* 245 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 246 */       .addComponent(this.timestampSpinner, -2, -1, -2)
/* 247 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 248 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 249 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
/* 250 */       .addComponent(this.vldlSpinner, javax.swing.GroupLayout.Alignment.LEADING, -2, 70, -2)
/* 251 */       .addComponent(this.cholesterolSpinner, javax.swing.GroupLayout.Alignment.LEADING, -2, 70, -2)
/* 252 */       .addComponent(this.triglycerideSpinner, javax.swing.GroupLayout.Alignment.LEADING, -2, 70, -2)
/* 253 */       .addComponent(this.hdlcSpinner, javax.swing.GroupLayout.Alignment.LEADING, -2, 70, -2)
/* 254 */       .addComponent(this.ldlcSpinner, javax.swing.GroupLayout.Alignment.LEADING, -2, 70, -2)
/* 255 */       .addComponent(this.smallldlpSpinner, javax.swing.GroupLayout.Alignment.LEADING, -2, 70, -2))
/* 256 */       .addComponent(this.ldlpSpinner, -2, 70, -2))
/* 257 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 258 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 259 */       .addComponent(this.jLabel14)
/* 260 */       .addComponent(this.jLabel19)
/* 261 */       .addComponent(this.jLabel15)
/* 262 */       .addComponent(this.jLabel16)
/* 263 */       .addComponent(this.jLabel17)
/* 264 */       .addComponent(this.jLabel18)
/* 265 */       .addComponent(this.jLabel20))))
/* 266 */       .addGap(18, 18, 18)
/* 267 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 268 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 269 */       .addComponent(this.jLabel11)
/* 270 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
/* 271 */       .addComponent(this.systolicSpinner, -2, 70, -2)
/* 272 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 273 */       .addComponent(this.jLabel21))
/* 274 */       .addComponent(this.jLabel24)
/* 275 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 276 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 277 */       .addComponent(this.jLabel12)
/* 278 */       .addComponent(this.jLabel13))
/* 279 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 280 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 281 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 282 */       .addComponent(this.diastolicSpinner, -2, 70, -2)
/* 283 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 284 */       .addComponent(this.jLabel22))
/* 285 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 286 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
/* 287 */       .addComponent(this.glucoseSpinner)
/* 288 */       .addComponent(this.pulseSpinner)
/* 289 */       .addComponent(this.bhobSpinner))
/* 290 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 291 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 292 */       .addComponent(this.jLabel23)
/* 293 */       .addComponent(this.jLabel27)
/* 294 */       .addComponent(this.jLabel28)))))
/* 295 */       .addComponent(this.jLabel26)))
/* 296 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 297 */       .addGap(209, 209, 209)
/* 298 */       .addComponent(this.saveButton, -2, 100, -2)
/* 299 */       .addGap(55, 55, 55)
/* 300 */       .addComponent(this.cancelButton, -2, 100, -2))
/* 301 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 302 */       .addGap(246, 246, 246)
/* 303 */       .addComponent(this.jLabel2)))
/* 304 */       .addContainerGap(23, 32767)));
/*     */     
/* 306 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 307 */       .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 308 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 309 */       .addGap(20, 20, 20)
/* 310 */       .addComponent(this.jLabel1)
/* 311 */       .addGap(20, 20, 20)
/* 312 */       .addComponent(this.jLabel2)
/* 313 */       .addGap(18, 18, 18)
/* 314 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
/* 315 */       .addComponent(this.jLabel3)
/* 316 */       .addComponent(this.timestampSpinner, -2, -1, -2)
/* 317 */       .addComponent(this.jLabel11)
/* 318 */       .addComponent(this.systolicSpinner, -2, -1, -2)
/* 319 */       .addComponent(this.jLabel21))
/* 320 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 321 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
/* 322 */       .addComponent(this.jLabel4)
/* 323 */       .addComponent(this.ldlpSpinner, -2, -1, -2)
/* 324 */       .addComponent(this.jLabel14)
/* 325 */       .addComponent(this.jLabel12)
/* 326 */       .addComponent(this.diastolicSpinner, -2, -1, -2)
/* 327 */       .addComponent(this.jLabel22))
/* 328 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 329 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
/* 330 */       .addComponent(this.jLabel9)
/* 331 */       .addComponent(this.smallldlpSpinner, -2, -1, -2)
/* 332 */       .addComponent(this.jLabel19)
/* 333 */       .addComponent(this.jLabel13)
/* 334 */       .addComponent(this.pulseSpinner, -2, -1, -2)
/* 335 */       .addComponent(this.jLabel23))
/* 336 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 337 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
/* 338 */       .addComponent(this.jLabel5)
/* 339 */       .addComponent(this.ldlcSpinner, -2, -1, -2)
/* 340 */       .addComponent(this.jLabel15)
/* 341 */       .addComponent(this.jLabel24)
/* 342 */       .addComponent(this.bhobSpinner, -2, -1, -2)
/* 343 */       .addComponent(this.jLabel27))
/* 344 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 345 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
/* 346 */       .addComponent(this.jLabel6)
/* 347 */       .addComponent(this.hdlcSpinner, -2, -1, -2)
/* 348 */       .addComponent(this.jLabel16)
/* 349 */       .addComponent(this.jLabel26)
/* 350 */       .addComponent(this.glucoseSpinner, -2, -1, -2)
/* 351 */       .addComponent(this.jLabel28))
/* 352 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 353 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
/* 354 */       .addComponent(this.jLabel7)
/* 355 */       .addComponent(this.triglycerideSpinner, -2, -1, -2)
/* 356 */       .addComponent(this.jLabel17))
/* 357 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 358 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
/* 359 */       .addComponent(this.jLabel8)
/* 360 */       .addComponent(this.cholesterolSpinner, -2, -1, -2)
/* 361 */       .addComponent(this.jLabel18))
/* 362 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 363 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
/* 364 */       .addComponent(this.jLabel10)
/* 365 */       .addComponent(this.vldlSpinner, -2, -1, -2)
/* 366 */       .addComponent(this.jLabel20))
/* 367 */       .addGap(18, 18, 18)
/* 368 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 369 */       .addComponent(this.cancelButton)
/* 370 */       .addComponent(this.saveButton))
/* 371 */       .addGap(30, 30, 30)));
/*     */     
/*     */ 
/* 374 */     javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
/* 375 */     getContentPane().setLayout(layout);
/* 376 */     layout.setHorizontalGroup(layout
/* 377 */       .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 378 */       .addComponent(this.jPanel1, -1, -1, 32767));
/*     */     
/* 380 */     layout.setVerticalGroup(layout
/* 381 */       .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 382 */       .addComponent(this.jPanel1, -1, -1, 32767));
/*     */     
/*     */ 
/* 385 */     pack(); }
/*     */   
/*     */   private JLabel jLabel18;
/*     */   
/* 389 */   private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) { dispose(); }
/*     */   
/*     */   private JLabel jLabel19;
/*     */   private JLabel jLabel2;
/*     */   
/* 394 */   private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) { javax.swing.SpinnerNumberModel snm = (javax.swing.SpinnerNumberModel)this.bhobSpinner.getModel();
/* 395 */     double bhob = snm.getNumber().doubleValue();
/* 396 */     snm = (javax.swing.SpinnerNumberModel)this.cholesterolSpinner.getModel();
/* 397 */     int cholesterol = snm.getNumber().intValue();
/* 398 */     snm = (javax.swing.SpinnerNumberModel)this.diastolicSpinner.getModel();
/* 399 */     int diastolic = snm.getNumber().intValue();
/* 400 */     snm = (javax.swing.SpinnerNumberModel)this.glucoseSpinner.getModel();
/* 401 */     double glucose = snm.getNumber().doubleValue();
/* 402 */     snm = (javax.swing.SpinnerNumberModel)this.hdlcSpinner.getModel();
/* 403 */     int hdlc = snm.getNumber().intValue();
/* 404 */     snm = (javax.swing.SpinnerNumberModel)this.ldlcSpinner.getModel();
/* 405 */     int ldlc = snm.getNumber().intValue();
/* 406 */     snm = (javax.swing.SpinnerNumberModel)this.ldlpSpinner.getModel();
/* 407 */     int ldlp = snm.getNumber().intValue();
/* 408 */     snm = (javax.swing.SpinnerNumberModel)this.pulseSpinner.getModel();
/* 409 */     int pulse = snm.getNumber().intValue();
/* 410 */     snm = (javax.swing.SpinnerNumberModel)this.smallldlpSpinner.getModel();
/* 411 */     int smallldl = snm.getNumber().intValue();
/* 412 */     snm = (javax.swing.SpinnerNumberModel)this.systolicSpinner.getModel();
/* 413 */     int systolic = snm.getNumber().intValue();
/* 414 */     javax.swing.SpinnerDateModel sdm = (javax.swing.SpinnerDateModel)this.timestampSpinner.getModel();
/* 415 */     java.util.Date timestamp = sdm.getDate();
/* 416 */     snm = (javax.swing.SpinnerNumberModel)this.triglycerideSpinner.getModel();
/* 417 */     int triglycerides = snm.getNumber().intValue();
/* 418 */     snm = (javax.swing.SpinnerNumberModel)this.vldlSpinner.getModel();
/* 419 */     int vldl = snm.getNumber().intValue();
/* 420 */     this.gui.saveBloodTest(timestamp, bhob, glucose, cholesterol, hdlc, ldlc, ldlp, pulse, smallldl, triglycerides, vldl, diastolic, systolic);
/*     */     
/* 422 */     dispose();
/*     */   }
/*     */   
/*     */   private JLabel jLabel20;
/*     */   private JLabel jLabel21;
/*     */   private JLabel jLabel22;
/*     */   private JLabel jLabel23;
/*     */   private JLabel jLabel24;
/*     */   private JLabel jLabel26;
/*     */   private JLabel jLabel27;
/*     */   private JLabel jLabel28;
/*     */   private JLabel jLabel3;
/*     */   
/* 435 */   public static void main(String[] args) { try { for (javax.swing.UIManager.LookAndFeelInfo info : ) {
/* 436 */         if ("Nimbus".equals(info.getName())) {
/* 437 */           javax.swing.UIManager.setLookAndFeel(info.getClassName());
/* 438 */           break;
/*     */         }
/*     */       }
/*     */     } catch (ClassNotFoundException ex) {
/* 442 */       java.util.logging.Logger.getLogger(BloodTestDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 444 */       java.util.logging.Logger.getLogger(BloodTestDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 446 */       java.util.logging.Logger.getLogger(BloodTestDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
/* 448 */       java.util.logging.Logger.getLogger(BloodTestDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 453 */     java.awt.EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 455 */         BloodTestDialog dialog = new BloodTestDialog(new javax.swing.JFrame(), true, null);
/* 456 */         dialog.addWindowListener(new java.awt.event.WindowAdapter()
/*     */         {
/*     */           public void windowClosing(java.awt.event.WindowEvent e) {
/* 459 */             System.exit(0);
/*     */           }
/* 461 */         });
/* 462 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   private JLabel jLabel6;
/*     */   private JLabel jLabel7;
/*     */   private JLabel jLabel8;
/*     */   private JLabel jLabel9;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private JSpinner ldlcSpinner;
/*     */   private JSpinner ldlpSpinner;
/*     */   private JSpinner pulseSpinner;
/*     */   private javax.swing.JButton saveButton;
/*     */   private JSpinner smallldlpSpinner;
/*     */   private JSpinner systolicSpinner;
/*     */   private JSpinner timestampSpinner;
/*     */   private JSpinner triglycerideSpinner;
/*     */   private JSpinner vldlSpinner;
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/com/ketonix/ketonixpro/BloodTestDialog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */