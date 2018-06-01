/*     */ package com.ketonix.ketonixpro;
/*     */ 
/*     */ import java.awt.Canvas;
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.RenderingHints;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.ComponentAdapter;
/*     */ import java.awt.event.ComponentEvent;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseMotionAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.awt.event.WindowStateListener;
/*     */ import java.io.PrintStream;
/*     */ import javax.accessibility.AccessibleContext;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JSlider;
/*     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*     */ 
/*     */ public class Settings extends javax.swing.JFrame
/*     */ {
/*     */   private static final long READ_UPDATE_DELAY_MS = 50L;
/*     */   static final int VENDOR_ID = 1240;
/*     */   static final int PRODUCT_ID = 62547;
/*     */   private static final int BUFSIZE = 64;
/*     */   private static int igreen;
/*     */   private static int iyellow;
/*     */   private static int ired;
/*     */   private static int icorr;
/*     */   int current_green;
/*     */   int current_yellow;
/*     */   int current_red;
/*     */   int current_cal;
/*     */   int curr_value;
/*     */   int current_type;
/*     */   int current_id;
/*     */   int current_corr;
/*     */   int current_raw;
/*     */   KSync gui;
/*     */   Thread updateThread;
/*     */   public boolean stopThread;
/*     */   private JButton ApplyButton;
/*     */   private JButton CloseButton;
/*     */   private JButton NK;
/*     */   private JLabel RedValueLabel;
/*     */   private JButton SportSettingsButton;
/*     */   private JButton StandardSettingsButton;
/*     */   private JLabel YellowValueLabel;
/*     */   private JLabel currentValueLabel;
/*     */   private JSlider greenEdgeSlider;
/*     */   private JLabel greenValueLabel;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   private JLabel jLabel6;
/*     */   private JPanel jPanel1;
/*     */   private Canvas rangeCanvas;
/*     */   private JSlider redEdgeSlider;
/*     */   private JSlider yellowEdgeSlider;
/*     */   
/*     */   public Settings(KSync caller)
/*     */   {
/*  79 */     this.gui = caller;
/*  80 */     this.stopThread = false;
/*  81 */     initComponents();
/*  82 */     readDevice();
/*  83 */     if (this.current_type == 2) {
/*  84 */       System.out.println("green:" + this.current_green + ", yellow:" + this.current_yellow + ", red:" + this.current_red);
/*  85 */       this.greenEdgeSlider.setValue(this.current_green);
/*  86 */       this.yellowEdgeSlider.setValue(this.current_yellow);
/*  87 */       this.redEdgeSlider.setValue(this.current_red);
/*     */     } else {
/*  89 */       this.greenEdgeSlider.setValue(this.current_green * 1000 / 1024);
/*  90 */       this.yellowEdgeSlider.setValue(this.current_yellow * 1000 / 1024);
/*  91 */       this.redEdgeSlider.setValue(this.current_red * 1000 / 1024);
/*     */     }
/*  93 */     updateValueLabels();
/*     */     
/*  95 */     Thread updateThread = new Thread(new UpdateValues(this));
/*  96 */     updateThread.start();
/*     */   }
/*     */   
/*     */   private synchronized int readDevice()
/*     */   {
/* 101 */     this.current_green = this.gui.current_green;
/* 102 */     this.current_yellow = this.gui.current_yellow;
/* 103 */     this.current_red = this.gui.current_red;
/* 104 */     this.current_cal = this.gui.current_cal;
/* 105 */     this.curr_value = this.gui.current_value;
/* 106 */     this.current_type = this.gui.current_type;
/* 107 */     this.current_id = this.gui.current_id;
/* 108 */     this.current_corr = this.gui.current_corr;
/* 109 */     this.current_raw = this.gui.current_raw;
/* 110 */     return this.curr_value;
/*     */   }
/*     */   
/*     */   void drawShadowRect(Graphics g, Color color, int x, int y, int w, int h)
/*     */   {
/* 115 */     g.setColor(new Color(100, 100, 100));
/* 116 */     g.fillRect(x, y, w, h);
/* 117 */     g.setColor(new Color(50, 50, 50));
/* 118 */     g.fillRect(x + 1, y + 1, w - 1, h - 1);
/* 119 */     g.setColor(color);
/* 120 */     g.fillRect(x + 1, y + 1, w - 2, h - 2);
/*     */   }
/*     */   
/*     */ 
/*     */   public double getCurrentPPM()
/*     */   {
/* 126 */     double raw = 1.0D * this.curr_value;
/* 127 */     double daValue = 0.1385D * Math.exp(0.0077D * raw);
/*     */     
/*     */ 
/* 130 */     daValue -= 0.3385D;
/* 131 */     return daValue > 0.0D ? daValue : 0.0D;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   double value2PPM(int val)
/*     */   {
/* 140 */     double raw = 1.0D * val;
/* 141 */     double daValue = 0.1385D * Math.exp(0.0077D * raw);
/*     */     
/*     */ 
/* 144 */     return daValue > 0.0D ? daValue : 0.0D;
/*     */   }
/*     */   
/*     */ 
/*     */   void updateGui()
/*     */   {
/* 150 */     int green = this.greenEdgeSlider.getValue();
/* 151 */     int yellow = this.yellowEdgeSlider.getValue();
/* 152 */     int red = this.redEdgeSlider.getValue();
/*     */     
/* 154 */     Graphics2D g = (Graphics2D)this.rangeCanvas.getGraphics();
/* 155 */     if (g == null) return;
/* 156 */     g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
/* 157 */     Rectangle r = g.getClipBounds();
/* 158 */     int w = this.rangeCanvas.getWidth();
/* 159 */     int h = this.rangeCanvas.getHeight();
/*     */     
/* 161 */     readDevice();
/*     */     
/* 163 */     drawShadowRect(g, new Color(255, 255, 255), 0, 0, w - 1, h - 1);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 172 */     drawShadowRect(g, new Color(255, 102, 0), 0, 0, this.curr_value * w / 1024, h / 3);
/*     */     
/* 174 */     drawShadowRect(g, new Color(0, 0, 255), 0, h / 3, green * w / 1000, h * 2 / 3);
/*     */     
/* 176 */     drawShadowRect(g, new Color(0, 255, 0), green * w / 1000, h / 3, yellow * w / 1000, h * 2 / 3);
/*     */     
/* 178 */     drawShadowRect(g, new Color(255, 255, 0), yellow * w / 1000, h / 3, red * w / 1000, h * 2 / 3);
/*     */     
/* 180 */     drawShadowRect(g, new Color(255, 0, 0), red * w / 1000, h / 3, w - 50, h * 2 / 3);
/*     */     
/* 182 */     String unit = "";
/* 183 */     if (this.current_type == 2) {
/* 184 */       unit = "PPM";
/* 185 */       this.currentValueLabel.setText("" + String.format("%.1f", new Object[] { Double.valueOf(getCurrentPPM()) }) + " " + unit);
/*     */     } else {
/* 187 */       unit = "";
/* 188 */       this.currentValueLabel.setText("" + Math.round(100.0D * this.curr_value / 1024.0D));
/*     */     }
/*     */   }
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
/*     */   synchronized void setKetonixValues(int ig, int iy, int ir)
/*     */   {
/* 206 */     System.out.println("setKetonixValues(" + ig + "," + iy + "," + ir + ")");
/* 207 */     this.gui.setKetonixValues(ig, iy, ir);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void OnlyDigitsPlease() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void initComponents()
/*     */   {
/* 223 */     this.jPanel1 = new JPanel();
/* 224 */     this.jLabel1 = new JLabel();
/* 225 */     this.rangeCanvas = new Canvas();
/* 226 */     this.jLabel3 = new JLabel();
/* 227 */     this.greenEdgeSlider = new JSlider();
/* 228 */     this.jLabel4 = new JLabel();
/* 229 */     this.yellowEdgeSlider = new JSlider();
/* 230 */     this.jLabel6 = new JLabel();
/* 231 */     this.redEdgeSlider = new JSlider();
/* 232 */     this.ApplyButton = new JButton();
/* 233 */     this.jLabel5 = new JLabel();
/* 234 */     this.CloseButton = new JButton();
/* 235 */     this.SportSettingsButton = new JButton();
/* 236 */     this.StandardSettingsButton = new JButton();
/* 237 */     this.greenValueLabel = new JLabel();
/* 238 */     this.YellowValueLabel = new JLabel();
/* 239 */     this.RedValueLabel = new JLabel();
/* 240 */     this.currentValueLabel = new JLabel();
/* 241 */     this.jLabel2 = new JLabel();
/* 242 */     this.NK = new JButton();
/*     */     
/* 244 */     setDefaultCloseOperation(3);
/* 245 */     setTitle("Settings");
/* 246 */     setAlwaysOnTop(true);
/* 247 */     setLocation(new java.awt.Point(320, 220));
/* 248 */     setResizable(false);
/* 249 */     addWindowListener(new java.awt.event.WindowAdapter() {
/*     */       public void windowOpened(WindowEvent evt) {
/* 251 */         Settings.this.formWindowOpened(evt);
/*     */       }
/* 253 */     });
/* 254 */     addFocusListener(new java.awt.event.FocusAdapter() {
/*     */       public void focusGained(FocusEvent evt) {
/* 256 */         Settings.this.formFocusGained(evt);
/*     */       }
/* 258 */     });
/* 259 */     addWindowStateListener(new WindowStateListener() {
/*     */       public void windowStateChanged(WindowEvent evt) {
/* 261 */         Settings.this.windowStateChange(evt);
/*     */       }
/*     */       
/* 264 */     });
/* 265 */     this.jPanel1.setBackground(new Color(255, 255, 255));
/*     */     
/* 267 */     this.jLabel1.setFont(new Font("Lucida Sans", 1, 24));
/* 268 */     this.jLabel1.setText("Settings");
/*     */     
/* 270 */     this.rangeCanvas.setBackground(new Color(204, 204, 204));
/*     */     
/* 272 */     this.jLabel3.setFont(new Font("Lucida Sans", 1, 14));
/* 273 */     this.jLabel3.setText("Green");
/*     */     
/* 275 */     this.greenEdgeSlider.setMaximum(1000);
/* 276 */     this.greenEdgeSlider.setValue(25);
/* 277 */     this.greenEdgeSlider.addMouseMotionListener(new MouseMotionAdapter() {
/*     */       public void mouseDragged(MouseEvent evt) {
/* 279 */         Settings.this.greenEdgeSliderMouseDragged(evt);
/*     */       }
/* 281 */     });
/* 282 */     this.greenEdgeSlider.addMouseListener(new MouseAdapter() {
/*     */       public void mouseReleased(MouseEvent evt) {
/* 284 */         Settings.this.greenEdgeSliderMouseReleased(evt);
/*     */       }
/* 286 */     });
/* 287 */     this.greenEdgeSlider.addComponentListener(new ComponentAdapter() {
/*     */       public void componentShown(ComponentEvent evt) {
/* 289 */         Settings.this.greenEdgeSliderComponentShown(evt);
/*     */       }
/*     */       
/* 292 */     });
/* 293 */     this.jLabel4.setFont(new Font("Lucida Sans", 1, 14));
/* 294 */     this.jLabel4.setText("Yellow");
/*     */     
/* 296 */     this.yellowEdgeSlider.setMaximum(1000);
/* 297 */     this.yellowEdgeSlider.addMouseMotionListener(new MouseMotionAdapter() {
/*     */       public void mouseDragged(MouseEvent evt) {
/* 299 */         Settings.this.yellowEdgeSliderMouseDragged(evt);
/*     */       }
/* 301 */     });
/* 302 */     this.yellowEdgeSlider.addMouseListener(new MouseAdapter() {
/*     */       public void mouseReleased(MouseEvent evt) {
/* 304 */         Settings.this.yellowEdgeSliderMouseReleased(evt);
/*     */       }
/*     */       
/* 307 */     });
/* 308 */     this.jLabel6.setFont(new Font("Lucida Sans", 1, 14));
/* 309 */     this.jLabel6.setText("Red");
/*     */     
/* 311 */     this.redEdgeSlider.setMaximum(1000);
/* 312 */     this.redEdgeSlider.setValue(75);
/* 313 */     this.redEdgeSlider.addMouseMotionListener(new MouseMotionAdapter() {
/*     */       public void mouseDragged(MouseEvent evt) {
/* 315 */         Settings.this.redEdgeSliderMouseDragged(evt);
/*     */       }
/* 317 */     });
/* 318 */     this.redEdgeSlider.addMouseListener(new MouseAdapter() {
/*     */       public void mouseReleased(MouseEvent evt) {
/* 320 */         Settings.this.redEdgeSliderMouseReleased(evt);
/*     */       }
/*     */       
/* 323 */     });
/* 324 */     this.ApplyButton.setFont(new Font("Lucida Sans", 1, 14));
/* 325 */     this.ApplyButton.setText("Apply");
/* 326 */     this.ApplyButton.addMouseListener(new MouseAdapter() {
/*     */       public void mouseReleased(MouseEvent evt) {
/* 328 */         Settings.this.ApplyButtonMouseReleased(evt);
/*     */       }
/*     */       
/* 331 */     });
/* 332 */     this.jLabel5.setFont(new Font("Lucida Sans", 1, 14));
/* 333 */     this.jLabel5.setText("Ranges");
/*     */     
/* 335 */     this.CloseButton.setFont(new Font("Lucida Sans", 1, 14));
/* 336 */     this.CloseButton.setText("Close");
/* 337 */     this.CloseButton.setMaximumSize(new Dimension(85, 29));
/* 338 */     this.CloseButton.setMinimumSize(new Dimension(85, 29));
/* 339 */     this.CloseButton.setPreferredSize(new Dimension(85, 29));
/* 340 */     this.CloseButton.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 342 */         Settings.this.CloseButtonActionPerformed(evt);
/*     */       }
/*     */       
/* 345 */     });
/* 346 */     this.SportSettingsButton.setFont(new Font("Lucida Sans", 1, 14));
/* 347 */     this.SportSettingsButton.setForeground(new Color(255, 0, 51));
/* 348 */     this.SportSettingsButton.setText("Red");
/* 349 */     this.SportSettingsButton.setToolTipText("Set to factory sport settings");
/* 350 */     this.SportSettingsButton.setMaximumSize(new Dimension(100, 30));
/* 351 */     this.SportSettingsButton.setMinimumSize(new Dimension(100, 30));
/* 352 */     this.SportSettingsButton.setSize(new Dimension(100, 30));
/* 353 */     this.SportSettingsButton.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 355 */         Settings.this.SportSettingsButtonActionPerformed(evt);
/*     */       }
/*     */       
/* 358 */     });
/* 359 */     this.StandardSettingsButton.setFont(new Font("Lucida Sans", 1, 14));
/* 360 */     this.StandardSettingsButton.setForeground(new Color(0, 102, 255));
/* 361 */     this.StandardSettingsButton.setText("Blue");
/* 362 */     this.StandardSettingsButton.setToolTipText("Set to factory standard settings");
/* 363 */     this.StandardSettingsButton.setPreferredSize(new Dimension(100, 30));
/* 364 */     this.StandardSettingsButton.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 366 */         Settings.this.StandardSettingsButtonActionPerformed(evt);
/*     */       }
/*     */       
/* 369 */     });
/* 370 */     this.greenValueLabel.setText("30");
/*     */     
/* 372 */     this.YellowValueLabel.setText("50");
/*     */     
/* 374 */     this.RedValueLabel.setText("75");
/*     */     
/* 376 */     this.currentValueLabel.setText("10");
/*     */     
/* 378 */     this.jLabel2.setIcon(new ImageIcon(getClass().getResource("/resources/images/KetonixLogo.png")));
/*     */     
/* 380 */     this.NK.setFont(new Font("Lucida Grande", 1, 13));
/* 381 */     this.NK.setForeground(new Color(255, 0, 0));
/* 382 */     this.NK.setText("USB");
/* 383 */     this.NK.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 385 */         Settings.this.USBSettingsActionPerformed(evt);
/*     */       }
/*     */       
/* 388 */     });
/* 389 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 390 */     this.jPanel1.setLayout(jPanel1Layout);
/* 391 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 392 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 393 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 394 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 395 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 396 */       .addGap(20, 20, 20)
/* 397 */       .addComponent(this.jLabel2))
/* 398 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 399 */       .addGap(50, 50, 50)
/* 400 */       .addComponent(this.ApplyButton, -2, 100, -2))
/* 401 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 402 */       .addGap(50, 50, 50)
/* 403 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 404 */       .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/* 405 */       .addComponent(this.StandardSettingsButton, -1, 125, 32767)
/* 406 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 407 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 408 */       .addGap(155, 155, 155)
/* 409 */       .addComponent(this.CloseButton, -2, 100, -2))
/* 410 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 411 */       .addGap(18, 18, 18)
/* 412 */       .addComponent(this.SportSettingsButton, -2, 100, -2)
/* 413 */       .addGap(18, 18, 18)
/* 414 */       .addComponent(this.NK, -2, 100, -2))))
/* 415 */       .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/* 416 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 417 */       .addComponent(this.jLabel3)
/* 418 */       .addComponent(this.jLabel5)
/* 419 */       .addComponent(this.jLabel4)
/* 420 */       .addComponent(this.jLabel6))
/* 421 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 422 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 423 */       .addComponent(this.rangeCanvas, -2, 248, -2)
/* 424 */       .addComponent(this.greenEdgeSlider, -2, 250, -2)
/* 425 */       .addComponent(this.yellowEdgeSlider, -2, 250, -2)
/* 426 */       .addComponent(this.redEdgeSlider, -2, 250, -2))
/* 427 */       .addGap(18, 18, 18)
/* 428 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 429 */       .addComponent(this.greenValueLabel, -1, 50, 32767)
/* 430 */       .addComponent(this.YellowValueLabel, -1, -1, 32767)
/* 431 */       .addComponent(this.RedValueLabel, -1, -1, 32767)
/* 432 */       .addComponent(this.currentValueLabel, -1, -1, 32767))))))
/* 433 */       .addContainerGap(37, 32767))
/* 434 */       .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/* 435 */       .addGap(0, 0, 32767)
/* 436 */       .addComponent(this.jLabel1)
/* 437 */       .addGap(179, 179, 179)));
/*     */     
/* 439 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 440 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 441 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 442 */       .addGap(20, 20, 20)
/* 443 */       .addComponent(this.jLabel2)
/* 444 */       .addGap(10, 10, 10)
/* 445 */       .addComponent(this.jLabel1)
/* 446 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 447 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
/* 448 */       .addComponent(this.jLabel5)
/* 449 */       .addComponent(this.rangeCanvas, -2, 40, -2)
/* 450 */       .addComponent(this.currentValueLabel))
/* 451 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 452 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
/* 453 */       .addComponent(this.jLabel3)
/* 454 */       .addComponent(this.greenEdgeSlider, -2, -1, -2)
/* 455 */       .addComponent(this.greenValueLabel))
/* 456 */       .addGap(10, 10, 10)
/* 457 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
/* 458 */       .addComponent(this.jLabel4)
/* 459 */       .addComponent(this.yellowEdgeSlider, -2, -1, -2)
/* 460 */       .addComponent(this.YellowValueLabel))
/* 461 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 462 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
/* 463 */       .addComponent(this.jLabel6)
/* 464 */       .addComponent(this.redEdgeSlider, -2, -1, -2)
/* 465 */       .addComponent(this.RedValueLabel))
/* 466 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 467 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 468 */       .addComponent(this.StandardSettingsButton, -2, -1, -2)
/* 469 */       .addComponent(this.SportSettingsButton, -2, 30, -2)
/* 470 */       .addComponent(this.NK))
/* 471 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 472 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 473 */       .addComponent(this.ApplyButton, -2, 30, -2)
/* 474 */       .addComponent(this.CloseButton, -2, 30, -2))
/* 475 */       .addContainerGap(55, 32767)));
/*     */     
/*     */ 
/* 478 */     this.greenEdgeSlider.getAccessibleContext().setAccessibleName("");
/*     */     
/* 480 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 481 */     getContentPane().setLayout(layout);
/* 482 */     layout.setHorizontalGroup(layout
/* 483 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 484 */       .addComponent(this.jPanel1, -1, -1, 32767));
/*     */     
/* 486 */     layout.setVerticalGroup(layout
/* 487 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 488 */       .addComponent(this.jPanel1, -1, -1, 32767));
/*     */     
/*     */ 
/* 491 */     pack();
/*     */   }
/*     */   
/*     */   private void updateValueLabels()
/*     */   {
/* 496 */     String unit = "";
/* 497 */     if (this.current_type == 2) {
/* 498 */       unit = "PPM";
/*     */     } else {
/* 500 */       unit = "";
/*     */     }
/* 502 */     int r = this.redEdgeSlider.getValue();
/* 503 */     int g = this.greenEdgeSlider.getValue();
/* 504 */     int y = this.yellowEdgeSlider.getValue();
/* 505 */     if (this.current_type == 2) {
/* 506 */       this.YellowValueLabel.setText("" + String.format("%.1f", new Object[] { Double.valueOf(value2PPM(y)) }) + " " + unit);
/* 507 */       this.greenValueLabel.setText("" + String.format("%.1f", new Object[] { Double.valueOf(value2PPM(g)) }) + " " + unit);
/* 508 */       this.RedValueLabel.setText("" + String.format("%.1f", new Object[] { Double.valueOf(value2PPM(r)) }) + " " + unit);
/*     */     } else {
/* 510 */       this.YellowValueLabel.setText("" + y / 10 + " " + unit);
/* 511 */       this.greenValueLabel.setText("" + g / 10 + " " + unit);
/* 512 */       this.RedValueLabel.setText("" + r / 10 + " " + unit);
/*     */     }
/* 514 */     String prefix = "+";
/* 515 */     this.ApplyButton.setEnabled(true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void formWindowOpened(WindowEvent evt) {}
/*     */   
/*     */ 
/*     */ 
/*     */   private void formFocusGained(FocusEvent evt) {}
/*     */   
/*     */ 
/*     */ 
/*     */   private void windowStateChange(WindowEvent evt) {}
/*     */   
/*     */ 
/*     */ 
/*     */   private void StandardSettingsButtonActionPerformed(ActionEvent evt)
/*     */   {
/* 535 */     this.greenEdgeSlider.setValue(250);
/* 536 */     this.yellowEdgeSlider.setValue(400);
/* 537 */     this.redEdgeSlider.setValue(550);
/* 538 */     updateValueLabels();
/*     */   }
/*     */   
/*     */   private void SportSettingsButtonActionPerformed(ActionEvent evt)
/*     */   {
/* 543 */     this.greenEdgeSlider.setValue(250);
/* 544 */     this.yellowEdgeSlider.setValue(500);
/* 545 */     this.redEdgeSlider.setValue(750);
/* 546 */     updateValueLabels();
/*     */   }
/*     */   
/*     */   private void CloseButtonActionPerformed(ActionEvent evt) {
/* 550 */     this.stopThread = true;
/* 551 */     dispose();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void ApplyButtonMouseReleased(MouseEvent evt)
/*     */   {
/* 558 */     if (this.current_type == 2) {
/* 559 */       int g = this.greenEdgeSlider.getValue();
/* 560 */       int y = this.yellowEdgeSlider.getValue();
/* 561 */       int r = this.redEdgeSlider.getValue();
/*     */       
/* 563 */       setKetonixValues(g, y, r);
/*     */     } else {
/* 565 */       int g = (int)Math.round(this.greenEdgeSlider.getValue() * 1024.0D / 1000.0D + 5.0D);
/* 566 */       int y = (int)Math.round(this.yellowEdgeSlider.getValue() * 1024.0D / 1000.0D + 5.0D);
/* 567 */       int r = (int)Math.round(this.redEdgeSlider.getValue() * 1024.0D / 1000.0D + 5.0D);
/*     */       
/* 569 */       setKetonixValues(g, y, r);
/*     */     }
/* 571 */     this.ApplyButton.setEnabled(false);
/*     */   }
/*     */   
/*     */   private void redEdgeSliderMouseDragged(MouseEvent evt)
/*     */   {
/* 576 */     int r = this.redEdgeSlider.getValue();
/* 577 */     int g = this.greenEdgeSlider.getValue();
/* 578 */     int y = this.yellowEdgeSlider.getValue();
/* 579 */     if (r < y) this.yellowEdgeSlider.setValue(r);
/* 580 */     if (r < g) this.greenEdgeSlider.setValue(r);
/* 581 */     updateValueLabels();
/*     */   }
/*     */   
/*     */   private void redEdgeSliderMouseReleased(MouseEvent evt)
/*     */   {
/* 586 */     int r = this.redEdgeSlider.getValue();
/* 587 */     int g = this.greenEdgeSlider.getValue();
/* 588 */     int y = this.yellowEdgeSlider.getValue();
/* 589 */     if (r < y) this.yellowEdgeSlider.setValue(r);
/* 590 */     if (r < g) this.greenEdgeSlider.setValue(r);
/* 591 */     updateValueLabels();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void yellowEdgeSliderMouseDragged(MouseEvent evt)
/*     */   {
/* 598 */     int r = this.redEdgeSlider.getValue();
/* 599 */     int y = this.yellowEdgeSlider.getValue();
/* 600 */     int g = this.greenEdgeSlider.getValue();
/* 601 */     if (y < g) this.greenEdgeSlider.setValue(y);
/* 602 */     if (y > r) this.redEdgeSlider.setValue(y);
/* 603 */     updateValueLabels();
/*     */   }
/*     */   
/*     */   private void yellowEdgeSliderMouseReleased(MouseEvent evt)
/*     */   {
/* 608 */     int r = this.redEdgeSlider.getValue();
/* 609 */     int y = this.yellowEdgeSlider.getValue();
/* 610 */     int g = this.greenEdgeSlider.getValue();
/* 611 */     if (y < g) this.greenEdgeSlider.setValue(y);
/* 612 */     if (y > r) this.redEdgeSlider.setValue(y);
/* 613 */     updateValueLabels();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void greenEdgeSliderComponentShown(ComponentEvent evt) {}
/*     */   
/*     */ 
/*     */   private void greenEdgeSliderMouseDragged(MouseEvent evt)
/*     */   {
/* 623 */     int r = this.redEdgeSlider.getValue();
/* 624 */     int g = this.greenEdgeSlider.getValue();
/* 625 */     int y = this.yellowEdgeSlider.getValue();
/* 626 */     if (g > y) this.yellowEdgeSlider.setValue(g);
/* 627 */     if (g > r) this.redEdgeSlider.setValue(g);
/* 628 */     updateValueLabels();
/*     */   }
/*     */   
/*     */   private void greenEdgeSliderMouseReleased(MouseEvent evt)
/*     */   {
/* 633 */     int r = this.redEdgeSlider.getValue();
/* 634 */     int g = this.greenEdgeSlider.getValue();
/* 635 */     int y = this.yellowEdgeSlider.getValue();
/* 636 */     if (g > y) this.yellowEdgeSlider.setValue(g);
/* 637 */     if (g > r) this.redEdgeSlider.setValue(g);
/* 638 */     updateValueLabels();
/*     */   }
/*     */   
/*     */   private void USBSettingsActionPerformed(ActionEvent evt)
/*     */   {
/* 643 */     this.greenEdgeSlider.setValue(437);
/* 644 */     this.yellowEdgeSlider.setValue(699);
/* 645 */     this.redEdgeSlider.setValue(826);
/* 646 */     updateValueLabels();
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/com/ketonix/ketonixpro/Settings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */