/*    */ package datechooser.beans.editor.utils;
/*    */ 
/*    */ import java.awt.Font;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.Rectangle;
/*    */ import java.awt.geom.Rectangle2D;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TextOutput
/*    */ {
/* 22 */   private static Font defaultFont = new Font("Dialog", 0, 14);
/*    */   
/*    */   public TextOutput() {}
/*    */   
/* 26 */   public static void paintBoxed(Graphics g, Rectangle bounds, String text, Font font) { Graphics2D g2d = (Graphics2D)g;
/* 27 */     Rectangle2D rec = font.getStringBounds(text, g2d.getFontRenderContext());
/* 28 */     double x = (bounds.width - rec.getWidth()) / 2.0D;
/* 29 */     if (x < 0.0D) x = 0.0D;
/* 30 */     g2d.drawString(text, (float)x, (float)((bounds.height - rec.getHeight()) / 2.0D - rec.getY()));
/*    */   }
/*    */   
/*    */ 
/*    */   public static void paintBoxed(Graphics g, Rectangle bounds, String text)
/*    */   {
/* 36 */     paintBoxed(g, bounds, text, defaultFont);
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/utils/TextOutput.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */