/*     */ package com.ketonix.ketonixpro;
/*     */ 
/*     */ import java.awt.event.ActionEvent;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ 
/*     */ public class ProfileDialog extends javax.swing.JDialog implements javax.swing.event.ListSelectionListener
/*     */ {
/*     */   KSync ksync;
/*     */   ProfileMgr pm;
/*     */   java.util.Vector listData;
/*     */   int updateIndex;
/*     */   private JButton addButton;
/*     */   private javax.swing.JSpinner ageSpinner;
/*     */   private javax.swing.JCheckBox agreeCheckBox;
/*     */   private JButton cancelButton;
/*     */   private JLabel dataFileLabel;
/*     */   private JLabel feedbackLabel;
/*     */   private javax.swing.JComboBox genderComboBox;
/*     */   private JButton jButton1;
/*     */   private javax.swing.JFormattedTextField jFormattedTextField1;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel10;
/*     */   private JLabel jLabel11;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   
/*     */   public void enableFields(boolean tf)
/*     */   {
/*  34 */     if (!tf) this.updateIndex = -1;
/*  35 */     this.nameTextField.enableInputMethods(tf);
/*  36 */     this.nameTextField.setEnabled(tf);
/*  37 */     this.usernameTextField.enableInputMethods(tf);
/*  38 */     this.usernameTextField.setEnabled(tf);
/*  39 */     this.passwordTextField.enableInputMethods(tf);
/*  40 */     this.passwordTextField.setEnabled(tf);
/*  41 */     this.saveProfileButton.enableInputMethods(tf);
/*  42 */     this.nameTextField.requestFocusInWindow();
/*  43 */     this.saveProfileButton.setEnabled(tf);
/*  44 */     this.verifyButton.setEnabled(tf);
/*     */     
/*  46 */     this.nameTextField.setText("");
/*  47 */     this.usernameTextField.setText("");
/*  48 */     this.passwordTextField.setText("");
/*     */   }
/*     */   
/*     */   public void addParent(KSync parent) {
/*  52 */     this.ksync = parent;
/*     */   }
/*     */   
/*     */   public void valueChanged(javax.swing.event.ListSelectionEvent lse)
/*     */   {
/*  57 */     int ix = lse.getFirstIndex();
/*  58 */     ix = this.profileList.getSelectedIndex();
/*     */     
/*  60 */     if (ix < 0)
/*     */     {
/*  62 */       return;
/*     */     }
/*  64 */     String udn = this.pm.getUserDisplayName(ix);
/*  65 */     String un = this.pm.getUserName(ix);
/*  66 */     String pw = this.pm.getUserPassword(ix);
/*  67 */     this.agreeCheckBox.setSelected(this.pm.allowAnonymousData(ix));
/*     */     
/*  69 */     String gender = this.pm.gender(ix);
/*     */     
/*  71 */     if (gender.equals("")) gender = "0";
/*     */     try {
/*  73 */       this.genderComboBox.setSelectedIndex(Integer.parseInt(gender));
/*     */     } catch (Exception e) {
/*  75 */       System.err.println(e.toString());
/*  76 */       e.printStackTrace();
/*     */     }
/*  78 */     javax.swing.SpinnerNumberModel snm = (javax.swing.SpinnerNumberModel)this.ageSpinner.getModel();
/*  79 */     String age = this.pm.age(ix);
/*  80 */     snm.setValue(new Integer(age));
/*  81 */     String usage = this.pm.usage(ix);
/*     */     try {
/*  83 */       this.usageComboBox.setSelectedIndex(Integer.parseInt(usage));
/*     */     } catch (Exception e) {
/*  85 */       System.err.println(e.toString());
/*  86 */       e.printStackTrace();
/*     */     }
/*  88 */     String smoking = this.pm.smoking(ix);
/*     */     try {
/*  90 */       this.smokingComboBox.setSelectedIndex(Integer.parseInt(smoking));
/*     */     } catch (Exception e) {
/*  92 */       System.err.println(e.toString());
/*  93 */       e.printStackTrace();
/*     */     }
/*     */     
/*  96 */     this.dataFileLabel.setText(this.pm.dataFile(ix));
/*     */     
/*  98 */     enableFields(true);
/*  99 */     this.nameTextField.setText(udn);
/* 100 */     this.usernameTextField.setText(un);
/* 101 */     this.passwordTextField.setText(pw);
/* 102 */     this.saveProfileButton.setText("Update Profile");
/* 103 */     this.updateIndex = ix;
/* 104 */     this.feedbackLabel.setText("");
/*     */   }
/*     */   
/*     */   public void updateListFromSource()
/*     */   {
/* 109 */     this.listData = new java.util.Vector();
/*     */     
/*     */ 
/* 112 */     this.pm.debugTree();
/* 113 */     this.profileList.removeAll();
/*     */     
/* 115 */     for (int i = 0; i < this.pm.numProfiles(); i++)
/*     */     {
/* 117 */       this.listData.addElement(this.pm.getUserDisplayName(i));
/*     */     }
/*     */     
/* 120 */     this.profileList.setListData(this.listData);
/*     */     
/*     */ 
/* 123 */     this.pm.debugTree();
/*     */   }
/*     */   
/*     */ 
/*     */   public ProfileDialog(java.awt.Frame parent, boolean modal)
/*     */   {
/* 129 */     super(parent, modal);
/*     */     
/* 131 */     int dismissDelay = javax.swing.ToolTipManager.sharedInstance().getDismissDelay();
/*     */     
/*     */ 
/* 134 */     dismissDelay = Integer.MAX_VALUE;
/* 135 */     javax.swing.ToolTipManager.sharedInstance().setDismissDelay(dismissDelay);
/*     */     
/*     */ 
/* 138 */     initComponents();
/* 139 */     enableFields(false);
/* 140 */     this.pm = new ProfileMgr();
/* 141 */     updateListFromSource();
/* 142 */     this.addButton.requestFocusInWindow();
/* 143 */     this.profileList.addListSelectionListener(this);
/* 144 */     this.updateIndex = -1; }
/*     */   
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   private JLabel jLabel6;
/*     */   private JLabel jLabel7;
/*     */   private JLabel jLabel8;
/*     */   private JLabel jLabel9;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private javax.swing.JScrollPane jScrollPane1;
/*     */   private javax.swing.JScrollPane jScrollPane2;
/*     */   
/* 156 */   private void initComponents() { this.jFormattedTextField1 = new javax.swing.JFormattedTextField();
/* 157 */     this.jPanel1 = new javax.swing.JPanel();
/* 158 */     this.saveProfileButton = new JButton();
/* 159 */     this.jLabel4 = new JLabel();
/* 160 */     this.removeButton = new JButton();
/* 161 */     this.addButton = new JButton();
/* 162 */     this.jLabel3 = new JLabel();
/* 163 */     this.usernameTextField = new javax.swing.JTextField();
/* 164 */     this.jLabel2 = new JLabel();
/* 165 */     this.jLabel1 = new JLabel();
/* 166 */     this.nameTextField = new javax.swing.JTextField();
/* 167 */     this.passwordTextField = new javax.swing.JPasswordField();
/* 168 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/* 169 */     this.profileList = new javax.swing.JList();
/* 170 */     this.cancelButton = new JButton();
/* 171 */     this.verifyButton = new JButton();
/* 172 */     this.jLabel6 = new JLabel();
/* 173 */     this.jLabel7 = new JLabel();
/* 174 */     this.jScrollPane2 = new javax.swing.JScrollPane();
/* 175 */     this.jTextPane1 = new javax.swing.JTextPane();
/* 176 */     this.agreeCheckBox = new javax.swing.JCheckBox();
/* 177 */     this.jLabel8 = new JLabel();
/* 178 */     this.genderComboBox = new javax.swing.JComboBox();
/* 179 */     this.jLabel9 = new JLabel();
/* 180 */     this.ageSpinner = new javax.swing.JSpinner();
/* 181 */     this.smokingComboBox = new javax.swing.JComboBox();
/* 182 */     this.jLabel10 = new JLabel();
/* 183 */     this.usageComboBox = new javax.swing.JComboBox();
/* 184 */     this.jLabel11 = new JLabel();
/* 185 */     this.dataFileLabel = new JLabel();
/* 186 */     this.jButton1 = new JButton();
/* 187 */     this.feedbackLabel = new JLabel();
/* 188 */     this.jLabel5 = new JLabel();
/*     */     
/* 190 */     this.jFormattedTextField1.setText("jFormattedTextField1");
/*     */     
/* 192 */     setDefaultCloseOperation(2);
/* 193 */     setTitle("Profiles");
/* 194 */     setAlwaysOnTop(true);
/* 195 */     setLocation(new java.awt.Point(300, 75));
/* 196 */     setPreferredSize(new java.awt.Dimension(624, 490));
/* 197 */     setResizable(false);
/*     */     
/* 199 */     this.jPanel1.setBackground(new java.awt.Color(255, 255, 255));
/* 200 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
/* 201 */     this.jPanel1.setPreferredSize(new java.awt.Dimension(624, 480));
/*     */     
/* 203 */     this.saveProfileButton.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 204 */     this.saveProfileButton.setText("Save Profile");
/* 205 */     this.saveProfileButton.setToolTipText("Save the profile");
/* 206 */     this.saveProfileButton.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 208 */         ProfileDialog.this.saveProfileButtonActionPerformed(evt);
/*     */       }
/*     */       
/* 211 */     });
/* 212 */     this.jLabel4.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 213 */     this.jLabel4.setText("Profiles");
/*     */     
/* 215 */     this.removeButton.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 216 */     this.removeButton.setText("Delete");
/* 217 */     this.removeButton.setActionCommand("DeleteProfile");
/* 218 */     this.removeButton.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 220 */         ProfileDialog.this.removeButtonActionPerformed(evt);
/*     */       }
/*     */       
/* 223 */     });
/* 224 */     this.addButton.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 225 */     this.addButton.setText("New");
/* 226 */     this.addButton.setActionCommand("NewProfile");
/* 227 */     this.addButton.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 229 */         ProfileDialog.this.addButtonActionPerformed(evt);
/*     */       }
/*     */       
/* 232 */     });
/* 233 */     this.jLabel3.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 234 */     this.jLabel3.setText("Password");
/* 235 */     this.jLabel3.setToolTipText("Leave this blank if you only want to store locally");
/*     */     
/* 237 */     this.usernameTextField.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/*     */     
/* 239 */     this.jLabel2.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 240 */     this.jLabel2.setText("Username");
/* 241 */     this.jLabel2.setToolTipText("Leave this blank if you only want to store locally");
/*     */     
/* 243 */     this.jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 244 */     this.jLabel1.setText("Profile Name");
/* 245 */     this.jLabel1.setToolTipText("Name your profile, example: your name");
/*     */     
/* 247 */     this.nameTextField.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 248 */     this.nameTextField.addInputMethodListener(new java.awt.event.InputMethodListener() {
/*     */       public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
/* 250 */         ProfileDialog.this.ProfileNameChanged(evt);
/*     */       }
/*     */       
/*     */       public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {}
/* 254 */     });
/* 255 */     this.nameTextField.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 257 */         ProfileDialog.this.nameTextFieldActionPerformed(evt);
/*     */       }
/* 259 */     });
/* 260 */     this.nameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
/*     */       public void keyPressed(java.awt.event.KeyEvent evt) {
/* 262 */         ProfileDialog.this.KeyPressedCB(evt);
/*     */       }
/*     */       
/* 265 */     });
/* 266 */     this.passwordTextField.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/*     */     
/* 268 */     this.profileList.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 269 */     this.profileList.setSelectionMode(0);
/* 270 */     this.profileList.setPreferredSize(new java.awt.Dimension(100, 400));
/* 271 */     this.profileList.setSelectionBackground(new java.awt.Color(204, 204, 204));
/* 272 */     this.jScrollPane1.setViewportView(this.profileList);
/*     */     
/* 274 */     this.cancelButton.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 275 */     this.cancelButton.setText("Close");
/* 276 */     this.cancelButton.setToolTipText("Close window and go on measure your ketones");
/* 277 */     this.cancelButton.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 279 */         ProfileDialog.this.cancelButtonActionPerformed(evt);
/*     */       }
/*     */       
/* 282 */     });
/* 283 */     this.verifyButton.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 284 */     this.verifyButton.setText("Verify");
/* 285 */     this.verifyButton.setToolTipText("Check that username and password match your account at www.ketonix.com");
/* 286 */     this.verifyButton.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 288 */         ProfileDialog.this.verifyButtonActionPerformed(evt);
/*     */       }
/*     */       
/* 291 */     });
/* 292 */     this.jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 10));
/* 293 */     this.jLabel6.setText(" Same username and password as on www.ketonix.com");
/*     */     
/* 295 */     this.jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/KetonixLogo.png")));
/*     */     
/* 297 */     this.jTextPane1.setEditable(false);
/* 298 */     this.jTextPane1.setBorder(null);
/* 299 */     this.jTextPane1.setFont(new java.awt.Font("Lucida Sans", 0, 10));
/* 300 */     this.jTextPane1.setText("I agree to let this data be used anonymously to improve the product \nand in studies analyzing the effects of low-carb/ketogenic diets.");
/* 301 */     this.jTextPane1.setDragEnabled(false);
/* 302 */     this.jTextPane1.setFocusCycleRoot(false);
/* 303 */     this.jTextPane1.setFocusTraversalKeysEnabled(false);
/* 304 */     this.jTextPane1.setFocusable(false);
/* 305 */     this.jTextPane1.setRequestFocusEnabled(false);
/* 306 */     this.jTextPane1.setVerifyInputWhenFocusTarget(false);
/* 307 */     this.jScrollPane2.setViewportView(this.jTextPane1);
/*     */     
/* 309 */     this.jLabel8.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 310 */     this.jLabel8.setText("Gender");
/*     */     
/* 312 */     this.genderComboBox.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 313 */     this.genderComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Female", "Male" }));
/*     */     
/* 315 */     this.jLabel9.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 316 */     this.jLabel9.setText("Age");
/*     */     
/* 318 */     this.ageSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 150, 5));
/*     */     
/* 320 */     this.smokingComboBox.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 321 */     this.smokingComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Non Smoker", "Smoker" }));
/*     */     
/* 323 */     this.jLabel10.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 324 */     this.jLabel10.setText("Usage");
/*     */     
/* 326 */     this.usageComboBox.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 327 */     this.usageComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Weight loss", "Sport", "Diabetes", "Epilepsy", "Cancer", "Alzheimer", "Parkinson", "ADHD", "Fertility", "Other" }));
/*     */     
/* 329 */     this.jLabel11.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/* 330 */     this.jLabel11.setText("Data file");
/* 331 */     this.jLabel11.setToolTipText("Define a filename (.csv) where data is to be stored locally");
/*     */     
/* 333 */     this.dataFileLabel.setBackground(new java.awt.Color(255, 238, 238));
/* 334 */     this.dataFileLabel.setFont(new java.awt.Font("Lucida Sans", 2, 14));
/* 335 */     this.dataFileLabel.setAutoscrolls(true);
/*     */     
/* 337 */     this.jButton1.setFont(new java.awt.Font("Lucida Grande", 1, 14));
/* 338 */     this.jButton1.setText("Place ...");
/* 339 */     this.jButton1.setToolTipText("Set where the data file should be located");
/* 340 */     this.jButton1.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 342 */         ProfileDialog.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */       
/* 345 */     });
/* 346 */     this.feedbackLabel.setFont(new java.awt.Font("Lucida Sans", 1, 14));
/*     */     
/* 348 */     this.jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 13));
/* 349 */     this.jLabel5.setText("Help");
/* 350 */     this.jLabel5.setToolTipText("<html>\n<pre>\nA profile is information of where to store the data captured.\n\nRequired:\nAt a minimum you need to create a profile with a name and a data file.\nThis enables the application to store data locally in that file.\n\n1) Click New \n2) Enter a name for your profile.\n2) Click on Place ... and select where your data file should live.\n3) Click Save Profile, then Close\n\nOptional:\nIf you want to store your data in the Ketonix database online to share results \nwith your doctor or nutritionist, you need to enter your username and password\nfor your account on www.ketonix.com. Use the Verify button to check that you\nentered your username and password correct.\n</pre>\n</html>");
/*     */     
/* 352 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 353 */     this.jPanel1.setLayout(jPanel1Layout);
/* 354 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 355 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 356 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 357 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 358 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 359 */       .addGap(30, 30, 30)
/* 360 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 361 */       .addComponent(this.jLabel4)
/* 362 */       .addComponent(this.jScrollPane1, -2, 151, -2)
/* 363 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 364 */       .addComponent(this.addButton, -2, 60, -2)
/* 365 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 366 */       .addComponent(this.removeButton, -2, 1, 32767))))
/* 367 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 368 */       .addGap(20, 20, 20)
/* 369 */       .addComponent(this.jLabel7)))
/* 370 */       .addGap(46, 46, 46)
/* 371 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 372 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 373 */       .addComponent(this.feedbackLabel, -2, 300, -2)
/* 374 */       .addGap(18, 18, 18)
/* 375 */       .addComponent(this.jLabel5))
/* 376 */       .addComponent(this.jLabel6, -2, 305, -2)
/* 377 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 378 */       .addComponent(this.jLabel2)
/* 379 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
/* 380 */       .addComponent(this.usernameTextField, -2, 282, -2))
/* 381 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 382 */       .addComponent(this.verifyButton, -2, 102, -2)
/* 383 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 384 */       .addComponent(this.saveProfileButton)
/* 385 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 386 */       .addComponent(this.cancelButton, -2, 100, -2))
/* 387 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 388 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 389 */       .addComponent(this.jLabel3)
/* 390 */       .addComponent(this.jLabel8)
/* 391 */       .addComponent(this.jLabel10))
/* 392 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
/* 393 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 394 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 395 */       .addComponent(this.genderComboBox, -2, 119, -2)
/* 396 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
/* 397 */       .addComponent(this.jLabel9)
/* 398 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 399 */       .addComponent(this.ageSpinner, -2, 55, -2))
/* 400 */       .addComponent(this.passwordTextField, -2, 282, -2)
/* 401 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 402 */       .addComponent(this.usageComboBox, -2, -1, -2)
/* 403 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
/* 404 */       .addComponent(this.smokingComboBox, -2, 144, -2))))
/* 405 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 406 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 407 */       .addComponent(this.agreeCheckBox)
/* 408 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 409 */       .addComponent(this.jScrollPane2, -2, -1, -2))
/* 410 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 411 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 412 */       .addComponent(this.jLabel11, -2, 62, -2)
/* 413 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 414 */       .addComponent(this.dataFileLabel, -2, 168, -2)
/* 415 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 416 */       .addComponent(this.jButton1, -2, 82, -2))
/* 417 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 418 */       .addComponent(this.jLabel1)
/* 419 */       .addGap(18, 18, 18)
/* 420 */       .addComponent(this.nameTextField, -2, 259, -2)))))
/* 421 */       .addGap(106, 106, 106)));
/*     */     
/* 423 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 424 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 425 */       .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/* 426 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 427 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 428 */       .addGap(20, 20, 20)
/* 429 */       .addComponent(this.jLabel7))
/* 430 */       .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
/* 431 */       .addGap(35, 35, 35)
/* 432 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 433 */       .addComponent(this.jLabel5)
/* 434 */       .addComponent(this.feedbackLabel, -2, 27, -2))))
/* 435 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 436 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 437 */       .addGap(23, 23, 23)
/* 438 */       .addComponent(this.jLabel4))
/* 439 */       .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/* 440 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 441 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 442 */       .addComponent(this.jLabel1)
/* 443 */       .addComponent(this.nameTextField, -2, -1, -2))))
/* 444 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 445 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 446 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 447 */       .addComponent(this.jScrollPane1, -2, 240, -2)
/* 448 */       .addContainerGap(-1, 32767))
/* 449 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 450 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 451 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 452 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 453 */       .addComponent(this.jButton1, -1, -1, 32767)
/* 454 */       .addComponent(this.dataFileLabel, -1, -1, 32767))
/* 455 */       .addGap(5, 5, 5))
/* 456 */       .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/* 457 */       .addComponent(this.jLabel11)
/* 458 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
/* 459 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 460 */       .addComponent(this.jScrollPane2, -2, -1, -2)
/* 461 */       .addComponent(this.agreeCheckBox))
/* 462 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 463 */       .addComponent(this.jLabel6)
/* 464 */       .addGap(15, 15, 15)
/* 465 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 466 */       .addComponent(this.jLabel2)
/* 467 */       .addComponent(this.usernameTextField, -2, -1, -2))
/* 468 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 469 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 470 */       .addComponent(this.jLabel3)
/* 471 */       .addComponent(this.passwordTextField, -2, -1, -2))
/* 472 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 473 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 474 */       .addComponent(this.jLabel8)
/* 475 */       .addComponent(this.genderComboBox, -2, -1, -2)
/* 476 */       .addComponent(this.ageSpinner, -2, -1, -2)
/* 477 */       .addComponent(this.jLabel9))
/* 478 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
/* 479 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 480 */       .addComponent(this.jLabel10)
/* 481 */       .addComponent(this.usageComboBox, -2, -1, -2)
/* 482 */       .addComponent(this.smokingComboBox, -2, -1, -2))
/* 483 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
/* 484 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 485 */       .addComponent(this.verifyButton)
/* 486 */       .addComponent(this.saveProfileButton)
/* 487 */       .addComponent(this.cancelButton)
/* 488 */       .addComponent(this.removeButton)
/* 489 */       .addComponent(this.addButton))
/* 490 */       .addGap(0, 84, 32767)))));
/*     */     
/*     */ 
/* 493 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 494 */     getContentPane().setLayout(layout);
/* 495 */     layout.setHorizontalGroup(layout
/* 496 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 497 */       .addGroup(layout.createSequentialGroup()
/* 498 */       .addComponent(this.jPanel1, -2, 688, -2)
/* 499 */       .addGap(0, 0, 32767)));
/*     */     
/* 501 */     layout.setVerticalGroup(layout
/* 502 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 503 */       .addGroup(layout.createSequentialGroup()
/* 504 */       .addComponent(this.jPanel1, -2, 467, -2)
/* 505 */       .addGap(0, 0, 32767)));
/*     */     
/*     */ 
/* 508 */     pack();
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 512 */     javax.swing.JFileChooser jfc = new javax.swing.JFileChooser();
/* 513 */     jfc.setSelectedFile(new java.io.File(this.dataFileLabel.getText()));
/* 514 */     jfc.setApproveButtonText("OK");
/* 515 */     int returnval = jfc.showOpenDialog(this);
/*     */     
/* 517 */     if (returnval == 0)
/*     */     {
/* 519 */       this.dataFileLabel.setText(jfc.getSelectedFile().getAbsolutePath());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void verifyButtonActionPerformed(ActionEvent evt)
/*     */   {
/* 527 */     if (this.usernameTextField.getText().isEmpty()) { this.feedbackLabel.setText("a local profile");return; }
/* 528 */     if (this.ksync.testAuthenticate(this.usernameTextField.getText(), new String(this.passwordTextField.getPassword()))) {
/* 529 */       this.feedbackLabel.setText("User authentication success");
/*     */     } else {
/* 531 */       this.feedbackLabel.setText("User authentication failure");
/*     */     }
/*     */   }
/*     */   
/*     */   private void cancelButtonActionPerformed(ActionEvent evt)
/*     */   {
/* 537 */     this.ksync.initProfileList();
/* 538 */     dispose();
/*     */   }
/*     */   
/*     */ 
/*     */   private void nameTextFieldActionPerformed(ActionEvent evt) {}
/*     */   
/*     */   private void addButtonActionPerformed(ActionEvent evt)
/*     */   {
/* 546 */     enableFields(true);
/* 547 */     this.updateIndex = -1;
/* 548 */     this.saveProfileButton.setText("Create Profile");
/*     */   }
/*     */   
/*     */   private void removeButtonActionPerformed(ActionEvent evt) {
/* 552 */     int ix = this.profileList.getSelectedIndex();
/*     */     
/* 554 */     this.pm.delUserIx(ix);
/*     */     
/* 556 */     updateListFromSource();
/*     */   }
/*     */   
/*     */   private void saveProfileButtonActionPerformed(ActionEvent evt) {
/* 560 */     String name = this.nameTextField.getText();
/* 561 */     String user = this.usernameTextField.getText();
/* 562 */     String password = new String(this.passwordTextField.getPassword());
/* 563 */     if (name.length() < 1) {
/* 564 */       javax.swing.JOptionPane.showMessageDialog(this, "Name is required");
/* 565 */       return;
/*     */     }
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
/* 577 */     String agree = "no";
/*     */     
/* 579 */     if (this.agreeCheckBox.isSelected()) {
/* 580 */       agree = "yes";
/*     */     } else {
/* 582 */       agree = "no";
/*     */     }
/*     */     
/* 585 */     String gender = "" + this.genderComboBox.getSelectedIndex();
/* 586 */     javax.swing.SpinnerNumberModel snm = (javax.swing.SpinnerNumberModel)this.ageSpinner.getModel();
/* 587 */     String age = "" + snm.getNumber().toString();
/* 588 */     String usage = "" + this.usageComboBox.getSelectedIndex();
/* 589 */     String smoking = "" + this.smokingComboBox.getSelectedIndex();
/* 590 */     String dataFile = this.dataFileLabel.getText();
/*     */     
/* 592 */     if (this.updateIndex < 0) {
/* 593 */       this.pm.addUser(name, user, password, agree, gender, age, usage, smoking, dataFile);
/*     */     } else {
/* 595 */       this.pm.updateUser(this.updateIndex, name, user, password, agree, gender, age, usage, smoking, dataFile);
/*     */     }
/* 597 */     updateListFromSource();
/*     */     
/* 599 */     enableFields(false);
/* 600 */     this.feedbackLabel.setText("");
/*     */   }
/*     */   
/*     */   private void ProfileNameChanged(java.awt.event.InputMethodEvent evt) {
/* 604 */     System.out.println(this.nameTextField.getText());
/*     */   }
/*     */   
/*     */   private void KeyPressedCB(java.awt.event.KeyEvent evt) {
/* 608 */     String datafile = this.nameTextField.getText().replace(' ', '_');
/* 609 */     this.dataFileLabel.setText(datafile + ".csv");
/*     */   }
/*     */   
/*     */   private javax.swing.JTextPane jTextPane1;
/*     */   private javax.swing.JTextField nameTextField;
/*     */   private javax.swing.JPasswordField passwordTextField;
/*     */   private javax.swing.JList profileList;
/*     */   private JButton removeButton;
/*     */   private JButton saveProfileButton;
/*     */   private javax.swing.JComboBox smokingComboBox;
/*     */   private javax.swing.JComboBox usageComboBox;
/*     */   private javax.swing.JTextField usernameTextField;
/*     */   private JButton verifyButton;
/* 622 */   public static void main(String[] args) { try { for (javax.swing.UIManager.LookAndFeelInfo info : ) {
/* 623 */         if ("Nimbus".equals(info.getName())) {
/* 624 */           javax.swing.UIManager.setLookAndFeel(info.getClassName());
/* 625 */           break;
/*     */         }
/*     */       }
/*     */     } catch (ClassNotFoundException ex) {
/* 629 */       java.util.logging.Logger.getLogger(ProfileDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 631 */       java.util.logging.Logger.getLogger(ProfileDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 633 */       java.util.logging.Logger.getLogger(ProfileDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
/* 635 */       java.util.logging.Logger.getLogger(ProfileDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 640 */     java.awt.EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 642 */         ProfileDialog dialog = new ProfileDialog(new javax.swing.JFrame(), true);
/* 643 */         dialog.addWindowListener(new java.awt.event.WindowAdapter()
/*     */         {
/*     */           public void windowClosing(java.awt.event.WindowEvent e) {
/* 646 */             System.exit(0);
/*     */           }
/* 648 */         });
/* 649 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/com/ketonix/ketonixpro/ProfileDialog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */