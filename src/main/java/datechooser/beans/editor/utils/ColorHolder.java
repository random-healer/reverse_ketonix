/*    */ package datechooser.beans.editor.utils;
/*    */ 
/*    */ import java.awt.Color;
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
/*    */ 
/*    */ public class ColorHolder
/*    */ {
/*    */   private Color color;
/*    */   
/*    */   public ColorHolder(Color color)
/*    */   {
/* 23 */     setColor(color);
/*    */   }
/*    */   
/*    */   public ColorHolder() {
/* 27 */     setColor(Color.WHITE);
/*    */   }
/*    */   
/*    */   public Color getColor() {
/* 31 */     return this.color;
/*    */   }
/*    */   
/*    */   public void setColor(Color color) {
/* 35 */     this.color = color;
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/utils/ColorHolder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */