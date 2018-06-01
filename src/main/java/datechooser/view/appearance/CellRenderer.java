/*     */ package datechooser.view.appearance;
/*     */ 
/*     */ import java.awt.BasicStroke;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.Stroke;
/*     */ import java.io.Serializable;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class CellRenderer
/*     */   implements Serializable
/*     */ {
/*     */   private static final int CURSOR_PART = 5;
/*     */   private static final int CURSOR_SHIFT = 2;
/*     */   private static final int CURSOR_BOLD = 3;
/*  37 */   private static final BasicStroke boldStroke = new BasicStroke(2.0F);
/*  38 */   private static final BasicStroke usualStroke = new BasicStroke(1.0F);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static Stroke savedStroke;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CellRenderer() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public abstract void render(Graphics2D paramGraphics2D, Component paramComponent, String paramString, int paramInt1, int paramInt2, boolean paramBoolean);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void render(Graphics2D g, Component c, String text, int width, int height)
/*     */   {
/*  64 */     render(g, c, text, width, height, false);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void paintCursor(Graphics2D g2d, Rectangle rec, Color color)
/*     */   {
/*  71 */     g2d.setColor(color);
/*  72 */     int minSize = rec.height < rec.width ? rec.height : rec.width;
/*  73 */     int cursorSize = minSize / 5;
/*     */     
/*  75 */     savedStroke = g2d.getStroke();
/*     */     
/*  77 */     if (cursorSize > 3) {
/*  78 */       g2d.setStroke(boldStroke);
/*     */     } else {
/*  80 */       g2d.setStroke(usualStroke);
/*     */     }
/*  82 */     int cursorShift = 2;
/*     */     
/*  84 */     int x = rec.x + cursorShift;
/*  85 */     int y = rec.y + cursorShift;
/*  86 */     g2d.drawLine(x, y, x + cursorSize, y);
/*  87 */     g2d.drawLine(x, y, x, y + cursorSize);
/*     */     
/*  89 */     x = rec.x + rec.width - cursorShift;
/*  90 */     y = rec.y + cursorShift;
/*  91 */     g2d.drawLine(x, y, x - cursorSize, y);
/*  92 */     g2d.drawLine(x, y, x, y + cursorSize);
/*     */     
/*  94 */     x = rec.x + rec.width - cursorShift;
/*  95 */     y = rec.y + rec.height - cursorShift;
/*  96 */     g2d.drawLine(x, y, x - cursorSize, y);
/*  97 */     g2d.drawLine(x, y, x, y - cursorSize);
/*     */     
/*  99 */     x = rec.x + cursorShift;
/* 100 */     y = rec.y + rec.height - cursorShift;
/* 101 */     g2d.drawLine(x, y, x + cursorSize, y);
/* 102 */     g2d.drawLine(x, y, x, y - cursorSize);
/*     */     
/* 104 */     g2d.setStroke(savedStroke);
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/view/appearance/CellRenderer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */