/*    */ package datechooser.view.appearance.custom;
/*    */ 
/*    */ import datechooser.view.appearance.CellRenderer;
/*    */ import java.awt.AlphaComposite;
/*    */ import java.awt.Color;
/*    */ import java.awt.Component;
/*    */ import java.awt.Composite;
/*    */ import java.awt.Font;
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.Insets;
/*    */ import java.awt.Rectangle;
/*    */ import java.awt.font.FontRenderContext;
/*    */ import java.awt.geom.Rectangle2D;
/*    */ import java.io.IOException;
/*    */ import java.io.ObjectInputStream;
/*    */ import javax.swing.border.Border;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CustomCellRenderer
/*    */   extends CellRenderer
/*    */ {
/*    */   private CustomCellAppearance appearance;
/*    */   private transient Composite fillComposite;
/*    */   
/*    */   public CustomCellRenderer(CustomCellAppearance anAppearance)
/*    */   {
/* 30 */     setAppearance(anAppearance);
/* 31 */     this.fillComposite = AlphaComposite.getInstance(3);
/*    */   }
/*    */   
/*    */   public void render(Graphics2D g, Component c, String text, int width, int height, boolean isCursor) {
/* 35 */     Border border = getAppearance().getCellBorder();
/* 36 */     g.setColor(getAppearance().getBackgroundColor());
/* 37 */     g.fillRect(0, 0, width, height);
/* 38 */     g.setComposite(this.fillComposite);
/* 39 */     Rectangle cellRect = new Rectangle(0, 0, width, height);
/* 40 */     if (border != null) {
/* 41 */       Insets borderInsets = border.getBorderInsets(c);
/* 42 */       cellRect.setRect(cellRect.x + borderInsets.left, cellRect.y + borderInsets.top, cellRect.width - (borderInsets.left + borderInsets.right), cellRect.height - (borderInsets.top + borderInsets.bottom));
/*    */       
/*    */ 
/*    */ 
/* 46 */       border.paintBorder(c, g, 0, 0, width, height);
/*    */     }
/* 48 */     g.setFont(this.appearance.getFont());
/* 49 */     paintText(g, text, getAppearance().getTextColor(), cellRect, this.appearance.getFont());
/* 50 */     if ((isCursor) && (getAppearance().isSelectable())) {
/* 51 */       paintCursor(g, cellRect, getAppearance().getCursorColor());
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   private void paintText(Graphics2D g, String text, Color color, Rectangle rec, Font font)
/*    */   {
/* 58 */     g.setColor(color);
/* 59 */     FontRenderContext context = g.getFontRenderContext();
/* 60 */     Rectangle2D bounds = font.getStringBounds(text, context);
/*    */     
/* 62 */     double x = rec.getX() + (rec.getWidth() - bounds.getWidth()) / 2.0D;
/* 63 */     double y = rec.getY() + (rec.getHeight() - bounds.getHeight()) / 2.0D;
/*    */     
/* 65 */     double ascent = -bounds.getY();
/* 66 */     double baseY = y + ascent;
/* 67 */     g.drawString(text, (int)x, (int)baseY);
/*    */   }
/*    */   
/*    */   public CustomCellAppearance getAppearance() {
/* 71 */     return this.appearance;
/*    */   }
/*    */   
/*    */   public void setAppearance(CustomCellAppearance appearance) {
/* 75 */     this.appearance = appearance;
/*    */   }
/*    */   
/*    */   private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
/* 79 */     in.defaultReadObject();
/* 80 */     this.fillComposite = AlphaComposite.getInstance(3);
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/view/appearance/custom/CustomCellRenderer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */