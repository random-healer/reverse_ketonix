/*     */ package datechooser.beans.editor.border.types;
/*     */ 
/*     */ import java.awt.Component;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.FlowLayout;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.border.Border;
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
/*     */ public abstract class AbstractBorderEditor
/*     */   extends JPanel
/*     */ {
/*     */   protected Border value;
/*     */   private String caption;
/*     */   private boolean changed;
/*     */   public static final String BORDER_EVENT_NAME = "border";
/*     */   
/*     */   public AbstractBorderEditor()
/*     */   {
/*  30 */     setCaption("");
/*  31 */     setChanged(false);
/*     */   }
/*     */   
/*     */   public void fireChange() {
/*  35 */     setChanged(true);
/*  36 */     firePropertyChange("border", null, null);
/*     */   }
/*     */   
/*     */   protected Border getCurrentBorder()
/*     */   {
/*  41 */     return this.value;
/*     */   }
/*     */   
/*     */   public void setCurrentBorder(Border border) {
/*  45 */     setValue(border);
/*  46 */     refreshInterface();
/*     */   }
/*     */   
/*     */   public Border getSelectedBorder() {
/*  50 */     if (isChanged()) {
/*  51 */       prepareSelection();
/*  52 */       setChanged(false);
/*     */     }
/*  54 */     return getCurrentBorder();
/*     */   }
/*     */   
/*     */   public boolean isChanged() {
/*  58 */     return this.changed;
/*     */   }
/*     */   
/*     */   public void setChanged(boolean changed) {
/*  62 */     this.changed = changed;
/*     */   }
/*     */   
/*     */   public String getCaption() {
/*  66 */     return this.caption;
/*     */   }
/*     */   
/*     */   protected void setCaption(String caption) {
/*  70 */     this.caption = caption;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  74 */     return getCaption();
/*     */   }
/*     */   
/*     */   public Dimension getPreferredSize() {
/*  78 */     return new Dimension(200, 200);
/*     */   }
/*     */   
/*     */   protected JPanel getCenteredPane(Component component) {
/*  82 */     JPanel pane = new JPanel(new FlowLayout(1));
/*  83 */     if (component != null) pane.add(component);
/*  84 */     return pane;
/*     */   }
/*     */   
/*     */   public void initialize() {
/*  88 */     if (this.value == null) {
/*  89 */       this.value = getDefaultValue();
/*     */     }
/*     */   }
/*     */   
/*     */   public void reset() {
/*  94 */     setValue(getDefaultValue());
/*  95 */     refreshInterface();
/*  96 */     fireChange();
/*     */   }
/*     */   
/*     */   public void setValue(Border value) {
/* 100 */     this.value = value;
/*     */   }
/*     */   
/*     */   public JLabel getPreviewLabel() {
/* 104 */     JLabel label = new JLabel();
/* 105 */     label.setBorder(this.value);
/* 106 */     label.setText(getCaption());
/* 107 */     label.setOpaque(false);
/* 108 */     return label;
/*     */   }
/*     */   
/*     */   protected abstract Border getDefaultValue();
/*     */   
/*     */   protected abstract void prepareSelection();
/*     */   
/*     */   protected abstract void refreshInterface();
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/border/types/AbstractBorderEditor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */