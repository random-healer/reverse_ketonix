/*     */ package datechooser.beans.editor.utils;
/*     */ 
/*     */ import datechooser.beans.locale.LocaleUtils;
/*     */ import java.awt.Component;
/*     */ import java.awt.GridLayout;
/*     */ import java.awt.Insets;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.SpinnerNumberModel;
/*     */ import javax.swing.event.ChangeEvent;
/*     */ import javax.swing.event.ChangeListener;
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
/*     */ public class InsetsPanel
/*     */   extends JPanel
/*     */ {
/*  24 */   private static int MIN_VALUE = 1;
/*  25 */   private static int MAX_VALUE = 50;
/*     */   
/*     */   public static final String INSETS_EVENT_NAME = "insets";
/*     */   
/*     */   private Insets insets;
/*     */   private SpinnerNumberModel left;
/*     */   private SpinnerNumberModel top;
/*     */   private SpinnerNumberModel right;
/*     */   private SpinnerNumberModel bottom;
/*     */   private boolean autoEditing;
/*     */   
/*     */   public InsetsPanel(Insets insets)
/*     */   {
/*  38 */     setAutoEditing(false);
/*  39 */     this.insets = insets;
/*  40 */     OnChange onChange = new OnChange();
/*  41 */     this.left = new SpinnerNumberModel(getInsets().left, MIN_VALUE, MAX_VALUE, 1);
/*  42 */     this.left.addChangeListener(onChange);
/*  43 */     this.top = new SpinnerNumberModel(getInsets().top, MIN_VALUE, MAX_VALUE, 1);
/*  44 */     this.top.addChangeListener(onChange);
/*  45 */     this.right = new SpinnerNumberModel(getInsets().right, MIN_VALUE, MAX_VALUE, 1);
/*  46 */     this.right.addChangeListener(onChange);
/*  47 */     this.bottom = new SpinnerNumberModel(getInsets().bottom, MIN_VALUE, MAX_VALUE, 1);
/*  48 */     this.bottom.addChangeListener(onChange);
/*     */     
/*  50 */     setLayout(new GridLayout(3, 3));
/*     */     
/*     */ 
/*     */ 
/*  54 */     add(getFoo());
/*  55 */     add(new SpinPane(this.top, LocaleUtils.getEditorLocaleString("top")));
/*  56 */     add(getFoo());
/*     */     
/*  58 */     add(new SpinPane(this.left, LocaleUtils.getEditorLocaleString("left")));
/*  59 */     add(getFoo());
/*  60 */     add(new SpinPane(this.right, LocaleUtils.getEditorLocaleString("right")));
/*     */     
/*  62 */     add(getFoo());
/*  63 */     add(new SpinPane(this.bottom, LocaleUtils.getEditorLocaleString("bottom")));
/*  64 */     add(getFoo());
/*     */   }
/*     */   
/*     */   private Component getFoo() {
/*  68 */     return new JPanel();
/*     */   }
/*     */   
/*     */ 
/*  72 */   public Insets getInsets() { return this.insets; }
/*     */   
/*     */   class OnChange implements ChangeListener {
/*     */     OnChange() {}
/*     */     
/*  77 */     public void stateChanged(ChangeEvent e) { if (InsetsPanel.this.isAutoEditing()) return;
/*  78 */       InsetsPanel.this.insets.set(InsetsPanel.this.top.getNumber().intValue(), InsetsPanel.this.left.getNumber().intValue(), InsetsPanel.this.bottom.getNumber().intValue(), InsetsPanel.this.right.getNumber().intValue());
/*     */       
/*  80 */       InsetsPanel.this.firePropertyChange("insets", null, null);
/*     */     }
/*     */   }
/*     */   
/*     */   public void setInsets(Insets insets) {
/*  85 */     this.insets = insets;
/*  86 */     refresh();
/*     */   }
/*     */   
/*     */   public void refresh() {
/*  90 */     setAutoEditing(true);
/*  91 */     this.left.setValue(new Integer(this.insets.left));
/*  92 */     this.right.setValue(new Integer(this.insets.right));
/*  93 */     this.top.setValue(new Integer(this.insets.top));
/*  94 */     this.bottom.setValue(new Integer(this.insets.bottom));
/*  95 */     setAutoEditing(false);
/*     */   }
/*     */   
/*     */   public boolean isAutoEditing() {
/*  99 */     return this.autoEditing;
/*     */   }
/*     */   
/*     */   public void setAutoEditing(boolean autoEditing) {
/* 103 */     this.autoEditing = autoEditing;
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/utils/InsetsPanel.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */