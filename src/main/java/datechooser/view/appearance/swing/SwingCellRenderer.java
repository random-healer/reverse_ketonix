/*     */ package datechooser.view.appearance.swing;
/*     */ 
/*     */ import datechooser.view.appearance.CellRenderer;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Insets;
/*     */ import java.awt.Rectangle;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SwingCellRenderer
/*     */   extends CellRenderer
/*     */ {
/*     */   private static final int ALLOW_DECREASE = 7;
/*     */   private Painter painter;
/*     */   private SwingCellAppearance appearance;
/*     */   private Font defaultFont;
/*     */   
/*     */   public SwingCellRenderer(SwingCellAppearance appearance, Painter painter)
/*     */   {
/*  37 */     this.painter = painter;
/*  38 */     this.defaultFont = painter.getFont();
/*  39 */     setAppearance(appearance);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void testDecreasing(Insets insets, Rectangle bounds)
/*     */   {
/*  50 */     int horizontalMax = bounds.width / 7;
/*  51 */     int verticalMax = bounds.height / 7;
/*  52 */     if (insets.left > horizontalMax) insets.left = horizontalMax;
/*  53 */     if (insets.right > horizontalMax) insets.right = horizontalMax;
/*  54 */     if (insets.top > verticalMax) insets.top = verticalMax;
/*  55 */     if (insets.bottom > verticalMax) insets.bottom = verticalMax;
/*     */   }
/*     */   
/*     */   public void render(Graphics2D g, Component c, String text, int width, int height, boolean isCursor)
/*     */   {
/*  60 */     getPainter().updateUI();
/*  61 */     getPainter().setText(text);
/*  62 */     getPainter().setSize(width, height);
/*  63 */     Font aFont = getAppearance().getFont();
/*  64 */     if (aFont != null) getPainter().setFont(aFont);
/*  65 */     Color aColor = getAppearance().getTextColor();
/*  66 */     if (aColor != null) { getPainter().setTextColor(aColor);
/*     */     }
/*  68 */     getPainter().setPressed(getAppearance().isPressed());
/*  69 */     getPainter().setEnabled(getAppearance().isEnabled());
/*     */     
/*  71 */     getPainter().paint(g);
/*     */     
/*  73 */     Rectangle cellRect = new Rectangle(0, 0, width, height);
/*  74 */     Border border = getPainter().getBorder();
/*  75 */     if (border != null) {
/*  76 */       Insets borderInsets = border.getBorderInsets(getPainter().getComponent(c));
/*  77 */       testDecreasing(borderInsets, cellRect);
/*  78 */       cellRect.setRect(borderInsets.left, borderInsets.top, cellRect.width - (borderInsets.left + borderInsets.right), cellRect.height - (borderInsets.top + borderInsets.bottom));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  83 */     if (isCursor) {
/*  84 */       paintCursor(g, cellRect, getAppearance().getCursorColor());
/*     */     }
/*     */   }
/*     */   
/*     */   public SwingCellAppearance getAppearance() {
/*  89 */     return this.appearance;
/*     */   }
/*     */   
/*     */   public void setAppearance(SwingCellAppearance appearance) {
/*  93 */     this.appearance = appearance;
/*     */   }
/*     */   
/*     */   public Font getDefaultFont() {
/*  97 */     return this.defaultFont;
/*     */   }
/*     */   
/*     */   public Painter getPainter() {
/* 101 */     return this.painter;
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/view/appearance/swing/SwingCellRenderer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */