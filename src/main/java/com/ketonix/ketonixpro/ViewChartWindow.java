/*     */ package com.ketonix.ketonixpro;
/*     */ 
/*     */ import java.awt.Container;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.awt.event.WindowStateListener;
/*     */ import java.util.Date;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.JFrame;
/*     */ 
/*     */ public class ViewChartWindow extends JFrame
/*     */ {
/*     */   private ViewChart applet;
/*     */   private int ix;
/*     */   private KetonixViewer parent;
/*     */   
/*     */   public int getIx()
/*     */   {
/*  21 */     return this.ix;
/*     */   }
/*     */   
/*     */   public void setDataFile(String path)
/*     */   {
/*  26 */     this.applet.setDataFile(path);
/*     */   }
/*     */   
/*     */   public void setFilter(String filter)
/*     */   {
/*  31 */     setTitle("Ketonix® - " + filter);
/*  32 */     this.applet.setFilter(filter);
/*     */   }
/*     */   
/*     */   public void setRange(Date startDate, Date endDate)
/*     */   {
/*  37 */     this.applet.setRange(startDate, endDate);
/*     */   }
/*     */   
/*     */ 
/*     */   public void refresh()
/*     */   {
/*  43 */     this.applet.createScene();
/*  44 */     this.applet.invalidate();
/*  45 */     this.applet.setVisible(false);
/*  46 */     this.applet.setVisible(true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public ViewChartWindow(KetonixViewer parin, int ixin, String filter, String path, Date startDate, Date endDate)
/*     */   {
/*  54 */     initComponents();
/*  55 */     setDefaultCloseOperation(1);
/*  56 */     this.ix = ixin;
/*  57 */     this.parent = parin;
/*  58 */     this.applet = new ViewChart();
/*  59 */     this.applet.setRange(startDate, endDate);
/*  60 */     this.applet.setFilter(filter);
/*  61 */     this.applet.setDataFile(path);
/*  62 */     this.applet.init();
/*  63 */     setContentPane(this.applet.getContentPane());
/*  64 */     pack();
/*  65 */     setLocationRelativeTo(null);
/*  66 */     setVisible(true);
/*  67 */     this.applet.start();
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
/*     */   private void initComponents()
/*     */   {
/*  80 */     setDefaultCloseOperation(3);
/*  81 */     setTitle("Ketonix® Viewer");
/*  82 */     addWindowStateListener(new WindowStateListener() {
/*     */       public void windowStateChanged(WindowEvent evt) {
/*  84 */         ViewChartWindow.this.windowStateChanged(evt);
/*     */       }
/*  86 */     });
/*  87 */     addWindowListener(new WindowAdapter() {
/*     */       public void windowClosing(WindowEvent evt) {
/*  89 */         ViewChartWindow.this.formWindowClosing(evt);
/*     */       }
/*     */       
/*  92 */       public void windowClosed(WindowEvent evt) { ViewChartWindow.this.windowsClosedHandler(evt);
/*     */       }
/*     */ 
/*  95 */     });
/*  96 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  97 */     getContentPane().setLayout(layout);
/*  98 */     layout.setHorizontalGroup(layout
/*  99 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 100 */       .addGap(0, 400, 32767));
/*     */     
/* 102 */     layout.setVerticalGroup(layout
/* 103 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 104 */       .addGap(0, 300, 32767));
/*     */     
/*     */ 
/* 107 */     pack();
/*     */   }
/*     */   
/*     */   private void formWindowClosing(WindowEvent evt)
/*     */   {
/* 112 */     this.parent.removeMe(this);
/*     */   }
/*     */   
/*     */   private void windowsClosedHandler(WindowEvent evt) {}
/*     */   
/*     */   private void windowStateChanged(WindowEvent evt) {}
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/com/ketonix/ketonixpro/ViewChartWindow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */