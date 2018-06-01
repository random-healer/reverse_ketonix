/*     */ package com.ketonix.ketonixpro;
/*     */ 
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ 
/*     */ public class BodyMeasureDialog extends javax.swing.JDialog
/*     */ {
/*     */   KSync gui;
/*     */   private javax.swing.JSpinner calfSpinner;
/*     */   private javax.swing.JSpinner chestSpinner;
/*     */   private javax.swing.JSpinner hipsSpinner;
/*     */   private javax.swing.JButton jButton1;
/*     */   private javax.swing.JButton jButton2;
/*     */   private javax.swing.JLabel jLabel1;
/*     */   private javax.swing.JLabel jLabel10;
/*     */   private javax.swing.JLabel jLabel11;
/*     */   private javax.swing.JLabel jLabel12;
/*     */   private javax.swing.JLabel jLabel13;
/*     */   private javax.swing.JLabel jLabel14;
/*     */   private javax.swing.JLabel jLabel2;
/*     */   private javax.swing.JLabel jLabel3;
/*     */   
/*     */   public BodyMeasureDialog(java.awt.Frame parent, boolean modal, KSync caller)
/*     */   {
/*  24 */     super(parent, modal);
/*  25 */     initComponents();
/*  26 */     this.gui = caller;
/*     */   }
/*     */   
/*     */   private javax.swing.JLabel jLabel4;
/*     */   private javax.swing.JLabel jLabel5;
/*     */   private javax.swing.JLabel jLabel6;
/*     */   private javax.swing.JLabel jLabel7;
/*     */   private javax.swing.JLabel jLabel8;
/*     */   private javax.swing.JLabel jLabel9;
/*     */   private javax.swing.JPanel jPanel2;
/*     */   
/*     */   private void initComponents() {
/*  38 */     this.jPanel2 = new javax.swing.JPanel();
/*  39 */     this.jLabel1 = new javax.swing.JLabel();
/*  40 */     this.jLabel2 = new javax.swing.JLabel();
/*  41 */     this.jButton1 = new javax.swing.JButton();
/*  42 */     this.jButton2 = new javax.swing.JButton();
/*  43 */     this.jLabel3 = new javax.swing.JLabel();
/*  44 */     this.jLabel4 = new javax.swing.JLabel();
/*  45 */     this.unitComboBox = new javax.swing.JComboBox();
/*  46 */     this.lengthSpinner = new javax.swing.JSpinner();
/*  47 */     this.jLabel5 = new javax.swing.JLabel();
/*  48 */     this.jLabel6 = new javax.swing.JLabel();
/*  49 */     this.jLabel7 = new javax.swing.JLabel();
/*  50 */     this.jLabel8 = new javax.swing.JLabel();
/*  51 */     this.jLabel9 = new javax.swing.JLabel();
/*  52 */     this.jLabel10 = new javax.swing.JLabel();
/*  53 */     this.jLabel11 = new javax.swing.JLabel();
/*  54 */     this.neckSpinner = new javax.swing.JSpinner();
/*  55 */     this.upperArmSpinner = new javax.swing.JSpinner();
/*  56 */     this.chestSpinner = new javax.swing.JSpinner();
/*  57 */     this.waistSpinner = new javax.swing.JSpinner();
/*  58 */     this.hipsSpinner = new javax.swing.JSpinner();
/*  59 */     this.thighSpinner = new javax.swing.JSpinner();
/*  60 */     this.calfSpinner = new javax.swing.JSpinner();
/*  61 */     this.jLabel13 = new javax.swing.JLabel();
/*  62 */     this.jLabel12 = new javax.swing.JLabel();
/*  63 */     this.timestampSpinner = new javax.swing.JSpinner();
/*  64 */     this.jLabel14 = new javax.swing.JLabel();
/*  65 */     this.weightSpinner = new javax.swing.JSpinner();
/*     */     
/*  67 */     setDefaultCloseOperation(2);
/*  68 */     setTitle("Add Body Measure");
/*  69 */     setAlwaysOnTop(true);
/*  70 */     setLocation(new java.awt.Point(300, 200));
/*     */     
/*  72 */     this.jPanel2.setBackground(new java.awt.Color(255, 255, 255));
/*     */     
/*  74 */     this.jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/KetonixLogo.png")));
/*     */     
/*  76 */     this.jLabel2.setFont(new java.awt.Font("Lucida Sans", 1, 24));
/*  77 */     this.jLabel2.setText("Add Body Measure");
/*     */     
/*  79 */     this.jButton1.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/*  80 */     this.jButton1.setText("Save");
/*  81 */     this.jButton1.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/*  83 */         BodyMeasureDialog.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */       
/*  86 */     });
/*  87 */     this.jButton2.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/*  88 */     this.jButton2.setText("Cancel");
/*  89 */     this.jButton2.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/*  91 */         BodyMeasureDialog.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */       
/*  94 */     });
/*  95 */     this.jLabel3.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/*  96 */     this.jLabel3.setText("Height");
/*     */     
/*  98 */     this.jLabel4.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/*  99 */     this.jLabel4.setText("Unit");
/*     */     
/* 101 */     this.unitComboBox.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 102 */     this.unitComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "cm", "inch" }));
/*     */     
/* 104 */     this.lengthSpinner.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 105 */     this.lengthSpinner.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0D), Double.valueOf(0.0D), null, Double.valueOf(10.0D)));
/*     */     
/* 107 */     this.jLabel5.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 108 */     this.jLabel5.setText("Neck");
/*     */     
/* 110 */     this.jLabel6.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 111 */     this.jLabel6.setText("Upper Arm");
/*     */     
/* 113 */     this.jLabel7.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 114 */     this.jLabel7.setText("Chest");
/*     */     
/* 116 */     this.jLabel8.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 117 */     this.jLabel8.setText("Waist");
/*     */     
/* 119 */     this.jLabel9.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 120 */     this.jLabel9.setText("Hips");
/*     */     
/* 122 */     this.jLabel10.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 123 */     this.jLabel10.setText("Thigh");
/*     */     
/* 125 */     this.jLabel11.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 126 */     this.jLabel11.setText("Calf");
/*     */     
/* 128 */     this.neckSpinner.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 129 */     this.neckSpinner.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0D), Double.valueOf(0.0D), null, Double.valueOf(1.0D)));
/*     */     
/* 131 */     this.upperArmSpinner.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 132 */     this.upperArmSpinner.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0D), Double.valueOf(0.0D), null, Double.valueOf(1.0D)));
/*     */     
/* 134 */     this.chestSpinner.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 135 */     this.chestSpinner.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0D), Double.valueOf(0.0D), null, Double.valueOf(1.0D)));
/*     */     
/* 137 */     this.waistSpinner.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 138 */     this.waistSpinner.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0D), Double.valueOf(0.0D), null, Double.valueOf(1.0D)));
/*     */     
/* 140 */     this.hipsSpinner.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 141 */     this.hipsSpinner.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0D), null, null, Double.valueOf(1.0D)));
/*     */     
/* 143 */     this.thighSpinner.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 144 */     this.thighSpinner.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0D), Double.valueOf(0.0D), null, Double.valueOf(1.0D)));
/*     */     
/* 146 */     this.calfSpinner.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 147 */     this.calfSpinner.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0D), Double.valueOf(0.0D), null, Double.valueOf(1.0D)));
/*     */     
/* 149 */     this.jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/MeasurementsSheet.png")));
/*     */     
/* 151 */     this.jLabel12.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 152 */     this.jLabel12.setText("Date");
/*     */     
/* 154 */     this.timestampSpinner.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 155 */     this.timestampSpinner.setModel(new javax.swing.SpinnerDateModel());
/*     */     
/* 157 */     this.jLabel14.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 158 */     this.jLabel14.setText("Weight");
/*     */     
/* 160 */     this.weightSpinner.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 161 */     this.weightSpinner.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0D), Double.valueOf(0.0D), null, Double.valueOf(1.0D)));
/*     */     
/* 163 */     javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(this.jPanel2);
/* 164 */     this.jPanel2.setLayout(jPanel2Layout);
/* 165 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 166 */       .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 167 */       .addGroup(jPanel2Layout.createSequentialGroup()
/* 168 */       .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 169 */       .addGroup(jPanel2Layout.createSequentialGroup()
/* 170 */       .addGap(20, 20, 20)
/* 171 */       .addComponent(this.jLabel1))
/* 172 */       .addGroup(jPanel2Layout.createSequentialGroup()
/* 173 */       .addGap(158, 158, 158)
/* 174 */       .addComponent(this.jLabel2)))
/* 175 */       .addContainerGap(-1, 32767))
/* 176 */       .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
/* 177 */       .addContainerGap(65, 32767)
/* 178 */       .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 179 */       .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
/* 180 */       .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 181 */       .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
/* 182 */       .addComponent(this.jLabel4)
/* 183 */       .addGap(74, 74, 74))
/* 184 */       .addGroup(jPanel2Layout.createSequentialGroup()
/* 185 */       .addComponent(this.jLabel12)
/* 186 */       .addGap(71, 71, 71)))
/* 187 */       .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 188 */       .addComponent(this.unitComboBox, -2, -1, -2)
/* 189 */       .addComponent(this.timestampSpinner, -2, -1, -2))
/* 190 */       .addGap(126, 126, 126))
/* 191 */       .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
/* 192 */       .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 193 */       .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
/* 194 */       .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
/* 195 */       .addGroup(jPanel2Layout.createSequentialGroup()
/* 196 */       .addComponent(this.jLabel11)
/* 197 */       .addGap(75, 75, 75)
/* 198 */       .addComponent(this.calfSpinner, -2, 83, -2))
/* 199 */       .addGroup(jPanel2Layout.createSequentialGroup()
/* 200 */       .addComponent(this.jLabel10)
/* 201 */       .addGap(62, 62, 62)
/* 202 */       .addComponent(this.thighSpinner, -2, 83, -2))
/* 203 */       .addGroup(jPanel2Layout.createSequentialGroup()
/* 204 */       .addComponent(this.jLabel9)
/* 205 */       .addGap(71, 71, 71)
/* 206 */       .addComponent(this.hipsSpinner, -2, 83, -2))
/* 207 */       .addGroup(jPanel2Layout.createSequentialGroup()
/* 208 */       .addComponent(this.jLabel8)
/* 209 */       .addGap(64, 64, 64)
/* 210 */       .addComponent(this.waistSpinner, -2, 83, -2))
/* 211 */       .addGroup(jPanel2Layout.createSequentialGroup()
/* 212 */       .addComponent(this.jLabel7)
/* 213 */       .addGap(63, 63, 63)
/* 214 */       .addComponent(this.chestSpinner, -2, 83, -2))
/* 215 */       .addGroup(jPanel2Layout.createSequentialGroup()
/* 216 */       .addComponent(this.jLabel6)
/* 217 */       .addGap(27, 27, 27)
/* 218 */       .addComponent(this.upperArmSpinner, -2, 83, -2))
/* 219 */       .addGroup(jPanel2Layout.createSequentialGroup()
/* 220 */       .addComponent(this.jLabel5)
/* 221 */       .addGap(69, 69, 69)
/* 222 */       .addComponent(this.neckSpinner, -2, 83, -2))
/* 223 */       .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
/* 224 */       .addComponent(this.jLabel3)
/* 225 */       .addGap(55, 55, 55)
/* 226 */       .addComponent(this.lengthSpinner, -2, 83, -2))
/* 227 */       .addGroup(jPanel2Layout.createSequentialGroup()
/* 228 */       .addComponent(this.jLabel14)
/* 229 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 230 */       .addComponent(this.weightSpinner, -2, 83, -2)))
/* 231 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
/* 232 */       .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
/* 233 */       .addComponent(this.jButton1)
/* 234 */       .addGap(53, 53, 53)))
/* 235 */       .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 236 */       .addComponent(this.jButton2)
/* 237 */       .addComponent(this.jLabel13))))
/* 238 */       .addGap(47, 47, 47)));
/*     */     
/* 240 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 241 */       .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 242 */       .addGroup(jPanel2Layout.createSequentialGroup()
/* 243 */       .addGap(20, 20, 20)
/* 244 */       .addComponent(this.jLabel1)
/* 245 */       .addGap(31, 31, 31)
/* 246 */       .addComponent(this.jLabel2)
/* 247 */       .addGap(18, 18, 18)
/* 248 */       .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
/* 249 */       .addComponent(this.jLabel12)
/* 250 */       .addComponent(this.timestampSpinner, -2, -1, -2))
/* 251 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 252 */       .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 253 */       .addGroup(jPanel2Layout.createSequentialGroup()
/* 254 */       .addGap(3, 3, 3)
/* 255 */       .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
/* 256 */       .addComponent(this.unitComboBox, -2, -1, -2)
/* 257 */       .addComponent(this.jLabel4))
/* 258 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 259 */       .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
/* 260 */       .addComponent(this.jLabel3)
/* 261 */       .addComponent(this.lengthSpinner, -2, -1, -2))
/* 262 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 263 */       .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
/* 264 */       .addComponent(this.jLabel5)
/* 265 */       .addComponent(this.neckSpinner, -2, -1, -2))
/* 266 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 267 */       .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
/* 268 */       .addComponent(this.jLabel6)
/* 269 */       .addComponent(this.upperArmSpinner, -2, -1, -2))
/* 270 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 271 */       .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
/* 272 */       .addComponent(this.jLabel7)
/* 273 */       .addComponent(this.chestSpinner, -2, -1, -2))
/* 274 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 275 */       .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
/* 276 */       .addComponent(this.jLabel8)
/* 277 */       .addComponent(this.waistSpinner, -2, -1, -2))
/* 278 */       .addGap(2, 2, 2)
/* 279 */       .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
/* 280 */       .addComponent(this.jLabel9)
/* 281 */       .addComponent(this.hipsSpinner, -2, -1, -2))
/* 282 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 283 */       .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
/* 284 */       .addComponent(this.jLabel10)
/* 285 */       .addComponent(this.thighSpinner, -2, -1, -2))
/* 286 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 287 */       .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
/* 288 */       .addComponent(this.jLabel11)
/* 289 */       .addComponent(this.calfSpinner, -2, -1, -2)))
/* 290 */       .addComponent(this.jLabel13))
/* 291 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 292 */       .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
/* 293 */       .addComponent(this.jLabel14)
/* 294 */       .addComponent(this.weightSpinner, -2, -1, -2))
/* 295 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 296 */       .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
/* 297 */       .addComponent(this.jButton1)
/* 298 */       .addComponent(this.jButton2))
/* 299 */       .addGap(29, 29, 29)));
/*     */     
/*     */ 
/* 302 */     javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
/* 303 */     getContentPane().setLayout(layout);
/* 304 */     layout.setHorizontalGroup(layout
/* 305 */       .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 306 */       .addComponent(this.jPanel2, -1, -1, 32767));
/*     */     
/* 308 */     layout.setVerticalGroup(layout
/* 309 */       .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 310 */       .addComponent(this.jPanel2, -1, -1, 32767));
/*     */     
/*     */ 
/* 313 */     pack();
/*     */   }
/*     */   
/*     */   public double ctrl2Double(javax.swing.JSpinner spinner)
/*     */   {
/* 318 */     javax.swing.SpinnerNumberModel model = (javax.swing.SpinnerNumberModel)spinner.getModel();
/* 319 */     double value = model.getNumber().doubleValue();
/* 320 */     return value;
/*     */   }
/*     */   
/* 323 */   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) { double length = ctrl2Double(this.lengthSpinner);
/* 324 */     double neck = ctrl2Double(this.neckSpinner);
/* 325 */     double upperArm = ctrl2Double(this.upperArmSpinner);
/* 326 */     double chest = ctrl2Double(this.chestSpinner);
/* 327 */     double waist = ctrl2Double(this.waistSpinner);
/* 328 */     double hip = ctrl2Double(this.hipsSpinner);
/* 329 */     double calf = ctrl2Double(this.calfSpinner);
/* 330 */     double thigh = ctrl2Double(this.thighSpinner);
/* 331 */     double weight = ctrl2Double(this.weightSpinner);
/* 332 */     javax.swing.SpinnerDateModel sdm = (javax.swing.SpinnerDateModel)this.timestampSpinner.getModel();
/* 333 */     java.util.Date theDate = sdm.getDate();
/* 334 */     double unit = this.unitComboBox.getSelectedIndex() == 0 ? 1.0D : 2.54D;
/* 335 */     this.gui.saveBodyMeasures(theDate, length * unit, neck * unit, upperArm * unit, chest * unit, waist * unit, hip * unit, thigh * unit, calf * unit, weight);
/* 336 */     dispose();
/*     */   }
/*     */   
/*     */   private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
/* 340 */     dispose();
/*     */   }
/*     */   
/*     */   private javax.swing.JSpinner lengthSpinner;
/*     */   private javax.swing.JSpinner neckSpinner;
/*     */   private javax.swing.JSpinner thighSpinner;
/*     */   private javax.swing.JSpinner timestampSpinner;
/*     */   private javax.swing.JComboBox unitComboBox;
/*     */   private javax.swing.JSpinner upperArmSpinner;
/*     */   private javax.swing.JSpinner waistSpinner;
/*     */   private javax.swing.JSpinner weightSpinner;
/*     */   public static void main(String[] args) {
/*     */     try {
/* 353 */       for (javax.swing.UIManager.LookAndFeelInfo info : ) {
/* 354 */         if ("Nimbus".equals(info.getName())) {
/* 355 */           javax.swing.UIManager.setLookAndFeel(info.getClassName());
/* 356 */           break;
/*     */         }
/*     */       }
/*     */     } catch (ClassNotFoundException ex) {
/* 360 */       java.util.logging.Logger.getLogger(BodyMeasureDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 362 */       java.util.logging.Logger.getLogger(BodyMeasureDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 364 */       java.util.logging.Logger.getLogger(BodyMeasureDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
/* 366 */       java.util.logging.Logger.getLogger(BodyMeasureDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 371 */     java.awt.EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 373 */         BodyMeasureDialog dialog = new BodyMeasureDialog(new javax.swing.JFrame(), true, null);
/* 374 */         dialog.addWindowListener(new java.awt.event.WindowAdapter()
/*     */         {
/*     */           public void windowClosing(java.awt.event.WindowEvent e) {
/* 377 */             System.exit(0);
/*     */           }
/* 379 */         });
/* 380 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/com/ketonix/ketonixpro/BodyMeasureDialog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */