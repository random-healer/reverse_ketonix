/*     */ package datechooser.view.appearance.custom;
/*     */ 
/*     */ import datechooser.view.appearance.CellAppearance;
/*     */ import datechooser.view.appearance.CellRenderer;
/*     */ import java.awt.AlphaComposite;
/*     */ import java.awt.Color;
/*     */ import java.awt.Composite;
/*     */ import java.awt.Font;
/*     */ import java.awt.Image;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import javax.swing.border.Border;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CustomCellAppearance
/*     */   extends CellAppearance
/*     */   implements CustomCellAttributes
/*     */ {
/*     */   private Color cursorColor;
/*     */   private Font font;
/*     */   private Color textColor;
/*     */   private Color backgroundColor;
/*     */   private Border cellBorder;
/*     */   private float transparency;
/*  30 */   private transient float transparencyCash = -1.0F;
/*     */   
/*     */   private transient Composite composite;
/*     */   private CustomCellRenderer renderer;
/*     */   
/*     */   public CustomCellAppearance(Color backgroundColor, Color textColor, Border cellBorder, Font font, Color cursorColor, float transparency, Image texture)
/*     */   {
/*  37 */     setBackgroundColor(backgroundColor);
/*  38 */     setTextColor(textColor);
/*  39 */     setCellBorder(cellBorder);
/*  40 */     setFont(font);
/*  41 */     setCursorColor(cursorColor);
/*  42 */     setTransparency(transparency);
/*  43 */     this.renderer = new CustomCellRenderer(this);
/*     */   }
/*     */   
/*     */   public CustomCellAppearance(Color backgroundColor, Color textColor, Border cellBorder, Font font, Color cursorColor, float transparency)
/*     */   {
/*  48 */     this(backgroundColor, textColor, cellBorder, font, cursorColor, transparency, null);
/*     */   }
/*     */   
/*     */   public Color getBackgroundColor() {
/*  52 */     return this.backgroundColor;
/*     */   }
/*     */   
/*     */   public void setBackgroundColor(Color backgroundColor) {
/*  56 */     this.backgroundColor = backgroundColor;
/*     */   }
/*     */   
/*     */   public Border getCellBorder() {
/*  60 */     return this.cellBorder;
/*     */   }
/*     */   
/*     */   public void setCellBorder(Border cellBorder) {
/*  64 */     this.cellBorder = cellBorder;
/*     */   }
/*     */   
/*     */   public Object clone() {
/*  68 */     CellAppearance newInst = new CustomCellAppearance(getBackgroundColor(), getTextColor(), getCellBorder(), getFont(), getCursorColor(), getTransparency());
/*     */     
/*  70 */     newInst.setSelectable(isSelectable());
/*  71 */     return newInst;
/*     */   }
/*     */   
/*     */   public void assign(CellAppearance newAppearance) {
/*  75 */     if (newAppearance == null) return;
/*  76 */     CustomCellAppearance customAppearance = (CustomCellAppearance)newAppearance;
/*  77 */     setBackgroundColor(customAppearance.getBackgroundColor());
/*  78 */     setTextColor(customAppearance.getTextColor());
/*  79 */     setCellBorder(customAppearance.getCellBorder());
/*  80 */     setFont(customAppearance.getFont());
/*  81 */     setCursorColor(customAppearance.getCursorColor());
/*  82 */     setSelectable(customAppearance.isSelectable());
/*  83 */     setTransparency(customAppearance.getTransparency());
/*     */   }
/*     */   
/*     */   public boolean equals(Object obj) {
/*  87 */     if (obj == null) return false;
/*  88 */     if (this == obj) return true;
/*  89 */     if (getClass() != obj.getClass()) return false;
/*  90 */     CustomCellAppearance value = (CustomCellAppearance)obj;
/*  91 */     return (getBackgroundColor().equals(value.getBackgroundColor())) && (getTextColor().equals(value.getTextColor())) && (getCursorColor().equals(value.getCursorColor())) && (getCellBorder().equals(value.getCellBorder())) && (getFont().equals(value.getFont())) && (getTransparency() == value.getTransparency());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected CellRenderer getRenderer()
/*     */   {
/*  99 */     return this.renderer;
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
/*     */   public Font getFont() {
/* 111 */     return this.font;
/*     */   }
/*     */   
/*     */   public Color getTextColor() {
/* 115 */     return this.textColor;
/*     */   }
/*     */   
/*     */   public void setFont(Font font) {
/* 119 */     this.font = font;
/*     */   }
/*     */   
/*     */   public void setTextColor(Color textColor) {
/* 123 */     this.textColor = textColor;
/*     */   }
/*     */   
/*     */   public float getTransparency() {
/* 127 */     return this.transparency;
/*     */   }
/*     */   
/*     */   public void setTransparency(float transparency) {
/* 131 */     this.transparency = transparency;
/*     */   }
/*     */   
/*     */   public Composite getComposite() {
/* 135 */     if (this.transparency != this.transparencyCash) {
/* 136 */       this.transparencyCash = this.transparency;
/* 137 */       this.composite = AlphaComposite.getInstance(3, this.transparency);
/*     */     }
/* 139 */     return this.composite;
/*     */   }
/*     */   
/*     */   private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
/* 143 */     in.defaultReadObject();
/* 144 */     this.transparencyCash = -1.0F;
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/view/appearance/custom/CustomCellAppearance.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */