/*     */ package com.ketonix.ketonixpro;
/*     */ 
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ 
/*     */ public class ExerciseDialog extends javax.swing.JDialog { private javax.swing.JComboBox typeComboBox;
/*     */   private javax.swing.JSpinner timestampSpinner;
/*     */   private javax.swing.JSpinner timeSpinner;
/*     */   private javax.swing.JButton saveButton;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private javax.swing.JLabel jLabel9;
/*     */   private javax.swing.JLabel jLabel8;
/*     */   private javax.swing.JLabel jLabel7;
/*     */   private javax.swing.JLabel jLabel6;
/*     */   private javax.swing.JLabel jLabel4;
/*     */   private javax.swing.JLabel jLabel3;
/*     */   private javax.swing.JLabel jLabel2;
/*     */   private javax.swing.JLabel jLabel1;
/*     */   private javax.swing.JComboBox intensityComboBox;
/*  19 */   private javax.swing.JComboBox funComboBox; private javax.swing.Box.Filler filler1; private javax.swing.JButton cancelButton; private javax.swing.JSpinner calorieSpinner; java.util.Date theDate; int typeAmount = 0; int funAmount = 0; int intensityAmount = 0; int caloriesAmount = 0; int timeAmount = 0;
/*     */   
/*     */   KSync gui;
/*     */   
/*     */ 
/*     */   public ExerciseDialog(java.awt.Frame parent, boolean modal, KSync caller)
/*     */   {
/*  26 */     super(parent, modal);
/*  27 */     initComponents();
/*  28 */     this.gui = caller;
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
/*  40 */     this.jPanel1 = new javax.swing.JPanel();
/*  41 */     this.jLabel1 = new javax.swing.JLabel();
/*  42 */     this.jLabel2 = new javax.swing.JLabel();
/*  43 */     this.jLabel3 = new javax.swing.JLabel();
/*  44 */     this.jLabel4 = new javax.swing.JLabel();
/*  45 */     this.intensityComboBox = new javax.swing.JComboBox();
/*  46 */     this.saveButton = new javax.swing.JButton();
/*  47 */     this.cancelButton = new javax.swing.JButton();
/*  48 */     this.timestampSpinner = new javax.swing.JSpinner();
/*  49 */     this.jLabel6 = new javax.swing.JLabel();
/*  50 */     this.timeSpinner = new javax.swing.JSpinner();
/*  51 */     this.calorieSpinner = new javax.swing.JSpinner();
/*  52 */     this.jLabel7 = new javax.swing.JLabel();
/*  53 */     this.filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(163, 0), new java.awt.Dimension(163, 0), new java.awt.Dimension(163, 32767));
/*  54 */     this.jLabel8 = new javax.swing.JLabel();
/*  55 */     this.funComboBox = new javax.swing.JComboBox();
/*  56 */     this.jLabel9 = new javax.swing.JLabel();
/*  57 */     this.typeComboBox = new javax.swing.JComboBox();
/*     */     
/*  59 */     setDefaultCloseOperation(2);
/*  60 */     setTitle("Add Exercise");
/*  61 */     setAlwaysOnTop(true);
/*  62 */     setLocation(new java.awt.Point(300, 200));
/*     */     
/*  64 */     this.jPanel1.setBackground(new java.awt.Color(255, 255, 255));
/*     */     
/*  66 */     this.jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 24));
/*  67 */     this.jLabel1.setText("Add Exercise");
/*     */     
/*  69 */     this.jLabel2.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/*  70 */     this.jLabel2.setText("Length (minutes)");
/*     */     
/*  72 */     this.jLabel3.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/*  73 */     this.jLabel3.setText("Calories");
/*     */     
/*  75 */     this.jLabel4.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/*  76 */     this.jLabel4.setText("Intensity (Borg)");
/*     */     
/*  78 */     this.intensityComboBox.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/*  79 */     this.intensityComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "6 No exertion at all", "7 Extremely light", "8 Very light", "9 Very light", "10 Light", "11 Light", "12 Somewhat hard", "13 Somewhat hard", "14 Hard", "15 Hard", "16 Very hard", "17 Very hard", "18 Extremely hard", "19 Extremely hard", "20 Maximal exertion" }));
/*  80 */     this.intensityComboBox.setToolTipText("1 is low, 10 is super high");
/*     */     
/*  82 */     this.saveButton.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/*  83 */     this.saveButton.setText("Save");
/*  84 */     this.saveButton.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/*  86 */         ExerciseDialog.this.saveButtonActionPerformed(evt);
/*     */       }
/*     */       
/*  89 */     });
/*  90 */     this.cancelButton.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/*  91 */     this.cancelButton.setText("Cancel");
/*  92 */     this.cancelButton.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/*  94 */         ExerciseDialog.this.cancelButtonActionPerformed(evt);
/*     */       }
/*     */       
/*  97 */     });
/*  98 */     this.timestampSpinner.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/*  99 */     this.timestampSpinner.setModel(new javax.swing.SpinnerDateModel());
/*     */     
/* 101 */     this.jLabel6.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 102 */     this.jLabel6.setText("Date and Time");
/*     */     
/* 104 */     this.timeSpinner.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 105 */     this.timeSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(10)));
/*     */     
/* 107 */     this.calorieSpinner.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 108 */     this.calorieSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(50)));
/*     */     
/* 110 */     this.jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/KetonixLogo.png")));
/*     */     
/* 112 */     this.jLabel8.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 113 */     this.jLabel8.setText("Fun factor");
/* 114 */     this.jLabel8.setToolTipText("1 is low, 10 is super high");
/*     */     
/* 116 */     this.funComboBox.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 117 */     this.funComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
/*     */     
/* 119 */     this.jLabel9.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 120 */     this.jLabel9.setText("Type of exercise");
/*     */     
/* 122 */     this.typeComboBox.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 123 */     this.typeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Aerobic", "Anaerobic", "Flexibility" }));
/* 124 */     this.typeComboBox.setToolTipText("<html>\n<b>Aerobic</b> \nexercise is any physical activity that uses large muscle groups<br>\n and causes your body to use more oxygen than it would while resting.<br>\n Examples of aerobic exercise include cycling, swimming, brisk walking,<br>\n skipping rope, rowing, hiking, playing tennis, continuous training,<br>\n and long slow distance training.\n<br>\n<b>Anaerobic</b> \nexercise is also called strength or resistance training.<br>\n Examples of anaerobic training is are pushups, lunges, weight training,<br>\n functional training, eccentric training, Interval training, sprinting and <br>\nhigh-intensity interval training increase short-term muscle strength.<br>\n<br>\n<b>Flexibility</b> exercises stretch and lengthen your muscles.<br>\n</html>");
/* 125 */     this.typeComboBox.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 127 */         ExerciseDialog.this.typeComboBoxActionPerformed(evt);
/*     */       }
/*     */       
/* 130 */     });
/* 131 */     javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(this.jPanel1);
/* 132 */     this.jPanel1.setLayout(jPanel1Layout);
/* 133 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 134 */       .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 135 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 136 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 137 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 138 */       .addGap(20, 20, 20)
/* 139 */       .addComponent(this.jLabel7, -2, 175, -2))
/* 140 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 141 */       .addGap(57, 57, 57)
/* 142 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 143 */       .addComponent(this.jLabel6)
/* 144 */       .addComponent(this.jLabel4)
/* 145 */       .addComponent(this.jLabel3)
/* 146 */       .addComponent(this.jLabel8)
/* 147 */       .addComponent(this.jLabel2)
/* 148 */       .addComponent(this.jLabel9))
/* 149 */       .addGap(17, 17, 17)
/* 150 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 151 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
/* 152 */       .addComponent(this.calorieSpinner, javax.swing.GroupLayout.Alignment.LEADING)
/* 153 */       .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
/* 154 */       .addGap(1, 1, 1)
/* 155 */       .addComponent(this.timeSpinner, -2, 73, -2)))
/* 156 */       .addComponent(this.intensityComboBox, -2, -1, -2)
/* 157 */       .addComponent(this.typeComboBox, -2, -1, -2)
/* 158 */       .addComponent(this.funComboBox, -2, -1, -2)))
/* 159 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 160 */       .addGap(197, 197, 197)
/* 161 */       .addComponent(this.timestampSpinner, -2, -1, -2)))
/* 162 */       .addContainerGap(49, 32767))
/* 163 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 164 */       .addGap(0, 0, 32767)
/* 165 */       .addComponent(this.filler1, -2, -1, -2)
/* 166 */       .addContainerGap(-1, 32767))
/* 167 */       .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/* 168 */       .addContainerGap(-1, 32767)
/* 169 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 170 */       .addComponent(this.cancelButton, javax.swing.GroupLayout.Alignment.TRAILING, -2, 100, -2)
/* 171 */       .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/* 172 */       .addComponent(this.saveButton, -2, 100, -2)
/* 173 */       .addGap(134, 134, 134)))
/* 174 */       .addGap(101, 101, 101))
/* 175 */       .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/* 176 */       .addContainerGap(-1, 32767)
/* 177 */       .addComponent(this.jLabel1)
/* 178 */       .addGap(133, 133, 133)));
/*     */     
/* 180 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 181 */       .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 182 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 183 */       .addGap(20, 20, 20)
/* 184 */       .addComponent(this.jLabel7)
/* 185 */       .addGap(18, 18, 18)
/* 186 */       .addComponent(this.jLabel1)
/* 187 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 188 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
/* 189 */       .addComponent(this.timestampSpinner, -2, -1, -2)
/* 190 */       .addComponent(this.jLabel6))
/* 191 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 192 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
/* 193 */       .addComponent(this.jLabel2)
/* 194 */       .addComponent(this.timeSpinner, -2, -1, -2))
/* 195 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 196 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
/* 197 */       .addComponent(this.jLabel3)
/* 198 */       .addComponent(this.calorieSpinner, -2, -1, -2))
/* 199 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 200 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
/* 201 */       .addComponent(this.jLabel4)
/* 202 */       .addComponent(this.intensityComboBox, -2, -1, -2))
/* 203 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 204 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 205 */       .addComponent(this.jLabel9)
/* 206 */       .addComponent(this.typeComboBox, -2, -1, -2))
/* 207 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 208 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 209 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 210 */       .addGap(35, 35, 35)
/* 211 */       .addComponent(this.filler1, -2, -1, -2))
/* 212 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
/* 213 */       .addComponent(this.funComboBox, -2, -1, -2)
/* 214 */       .addComponent(this.jLabel8)))
/* 215 */       .addGap(18, 18, 18)
/* 216 */       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
/* 217 */       .addComponent(this.saveButton)
/* 218 */       .addComponent(this.cancelButton))
/* 219 */       .addContainerGap(30, 32767)));
/*     */     
/*     */ 
/* 222 */     javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
/* 223 */     getContentPane().setLayout(layout);
/* 224 */     layout.setHorizontalGroup(layout
/* 225 */       .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 226 */       .addComponent(this.jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, -2, -1, -2));
/*     */     
/* 228 */     layout.setVerticalGroup(layout
/* 229 */       .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 230 */       .addComponent(this.jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, -2, -1, -2));
/*     */     
/*     */ 
/* 233 */     pack();
/*     */   }
/*     */   
/*     */   private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
/* 237 */     dispose();
/*     */   }
/*     */   
/*     */   private void saveButtonActionPerformed(java.awt.event.ActionEvent evt)
/*     */   {
/*     */     try {
/* 243 */       javax.swing.SpinnerNumberModel nm = (javax.swing.SpinnerNumberModel)this.timeSpinner.getModel();
/* 244 */       this.timeAmount = nm.getNumber().intValue();
/* 245 */       nm = (javax.swing.SpinnerNumberModel)this.calorieSpinner.getModel();
/* 246 */       this.caloriesAmount = nm.getNumber().intValue();
/* 247 */       String intensityAmountStr = (String)this.intensityComboBox.getSelectedItem();
/*     */       try {
/* 249 */         int i = intensityAmountStr.indexOf(' ');
/* 250 */         String valu = intensityAmountStr.substring(0, i);
/* 251 */         this.intensityAmount = Integer.parseInt(valu);
/*     */       } catch (Exception e) {
/* 253 */         this.intensityAmount = 0;
/*     */       }
/* 255 */       this.funAmount = this.funComboBox.getSelectedIndex();
/* 256 */       this.typeAmount = this.typeComboBox.getSelectedIndex();
/* 257 */       javax.swing.SpinnerDateModel model = (javax.swing.SpinnerDateModel)this.timestampSpinner.getModel();
/* 258 */       this.theDate = model.getDate();
/* 259 */       this.gui.saveExercise(this.timeAmount, this.caloriesAmount, this.intensityAmount, this.theDate, this.funAmount, this.typeAmount);
/*     */     } catch (Exception ex) {
/* 261 */       System.err.println(ex.toString());
/*     */     }
/* 263 */     dispose();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void typeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 280 */       for (javax.swing.UIManager.LookAndFeelInfo info : ) {
/* 281 */         if ("Nimbus".equals(info.getName())) {
/* 282 */           javax.swing.UIManager.setLookAndFeel(info.getClassName());
/* 283 */           break;
/*     */         }
/*     */       }
/*     */     } catch (ClassNotFoundException ex) {
/* 287 */       java.util.logging.Logger.getLogger(ExerciseDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 289 */       java.util.logging.Logger.getLogger(ExerciseDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 291 */       java.util.logging.Logger.getLogger(ExerciseDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
/* 293 */       java.util.logging.Logger.getLogger(ExerciseDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 298 */     java.awt.EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 300 */         ExerciseDialog dialog = new ExerciseDialog(new javax.swing.JFrame(), true, null);
/* 301 */         dialog.addWindowListener(new java.awt.event.WindowAdapter()
/*     */         {
/*     */           public void windowClosing(java.awt.event.WindowEvent e) {
/* 304 */             System.exit(0);
/*     */           }
/* 306 */         });
/* 307 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/com/ketonix/ketonixpro/ExerciseDialog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */