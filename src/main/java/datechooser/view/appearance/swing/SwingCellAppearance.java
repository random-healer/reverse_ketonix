/*     */ package datechooser.view.appearance.swing;
/*     */ 
/*     */ import datechooser.view.appearance.CellAppearance;
/*     */ import datechooser.view.appearance.CellRenderer;
/*     */ import java.awt.Color;
/*     */ import java.awt.Composite;
/*     */ import java.awt.Font;
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
/*     */ 
/*     */ public class SwingCellAppearance
/*     */   extends CellAppearance
/*     */   implements SwingCellAttributes
/*     */ {
/*     */   private boolean pressed;
/*     */   private boolean enabled;
/*     */   private SwingCellRenderer renderer;
/*     */   private Painter painter;
/*     */   private Color cursorColor;
/*     */   
/*     */   public SwingCellAppearance(Font font, Color color, Color cursorColor, boolean pressed, boolean enabled, Painter painter)
/*     */   {
/*  34 */     this.renderer = new SwingCellRenderer(this, painter);
/*  35 */     this.painter = painter;
/*  36 */     setTextColor(color);
/*  37 */     setFont(font);
/*  38 */     setPressed(pressed);
/*  39 */     setEnabled(enabled);
/*  40 */     setCursorColor(cursorColor);
/*     */   }
/*     */   
/*     */   public Painter getPainter() {
/*  44 */     return this.renderer.getPainter();
/*     */   }
/*     */   
/*     */   protected CellRenderer getRenderer() {
/*  48 */     return this.renderer;
/*     */   }
/*     */   
/*     */   public Object clone() {
/*  52 */     SwingCellAppearance newInst = new SwingCellAppearance(getFont(), getTextColor(), getCursorColor(), isPressed(), isEnabled(), (Painter)this.renderer.getPainter().clone());
/*     */     
/*  54 */     newInst.setSelectable(isSelectable());
/*  55 */     return newInst;
/*     */   }
/*     */   
/*     */   public void assign(CellAppearance newAppearance) {
/*  59 */     if (newAppearance == null) return;
/*  60 */     SwingCellAppearance swingAppearance = (SwingCellAppearance)newAppearance;
/*  61 */     setTextColor(swingAppearance.getTextColor());
/*  62 */     setFont(swingAppearance.getFont());
/*  63 */     setCursorColor(swingAppearance.getCursorColor());
/*  64 */     setSelectable(swingAppearance.isSelectable());
/*     */   }
/*     */   
/*     */   public boolean equals(Object obj) {
/*  68 */     if (obj == null) return false;
/*  69 */     if (this == obj) return true;
/*  70 */     if (getClass() != obj.getClass()) return false;
/*  71 */     SwingCellAppearance value = (SwingCellAppearance)obj;
/*  72 */     return (getTextColor().equals(value.getTextColor())) && (getCursorColor().equals(value.getCursorColor())) && (getFont().equals(value.getFont()));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean isPressed()
/*     */   {
/*  79 */     return this.pressed;
/*     */   }
/*     */   
/*     */   public void setPressed(boolean pressed) {
/*  83 */     this.pressed = pressed;
/*     */   }
/*     */   
/*     */   public boolean isEnabled() {
/*  87 */     return this.enabled;
/*     */   }
/*     */   
/*     */   public void setEnabled(boolean enabled) {
/*  91 */     this.enabled = enabled;
/*     */   }
/*     */   
/*     */   public Font getFont() {
/*  95 */     Font aFont = this.painter.getFont();
/*  96 */     if (aFont == null) {
/*  97 */       return this.renderer.getDefaultFont();
/*     */     }
/*  99 */     return aFont;
/*     */   }
/*     */   
/*     */   public Color getCursorColor() {
/* 103 */     return this.cursorColor;
/*     */   }
/*     */   
/*     */   public void setCursorColor(Color cursorColor) {
/* 107 */     this.cursorColor = cursorColor;
/*     */   }
/*     */   
/*     */   public Color getTextColor() {
/* 111 */     return this.painter.getTextColor();
/*     */   }
/*     */   
/*     */   public void setFont(Font font) {
/* 115 */     this.painter.setFont(font);
/*     */   }
/*     */   
/*     */   public void setTextColor(Color textColor) {
/* 119 */     this.painter.setTextColor(textColor);
/*     */   }
/*     */   
/*     */   public Composite getComposite() {
/* 123 */     return null;
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/view/appearance/swing/SwingCellAppearance.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */