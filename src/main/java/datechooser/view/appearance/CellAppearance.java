/*    */ package datechooser.view.appearance;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Component;
/*    */ import java.awt.Composite;
/*    */ import java.awt.Graphics2D;
/*    */ import java.io.Serializable;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class CellAppearance
/*    */   extends CellRenderer
/*    */   implements Serializable, Cloneable, CellAttributes
/*    */ {
/*    */   private boolean selectable;
/*    */   
/*    */   protected abstract CellRenderer getRenderer();
/*    */   
/*    */   public abstract Object clone();
/*    */   
/*    */   public CellAppearance()
/*    */   {
/* 39 */     setSelectable(true);
/*    */   }
/*    */   
/*    */   public boolean isSelectable() {
/* 43 */     return this.selectable;
/*    */   }
/*    */   
/*    */   public void setSelectable(boolean selectable) {
/* 47 */     this.selectable = selectable;
/*    */   }
/*    */   
/*    */   public void render(Graphics2D g, Component c, String text, int width, int height, boolean isCursor) {
/* 51 */     Composite composite = getComposite();
/* 52 */     if (composite != null) g.setComposite(composite);
/* 53 */     getRenderer().render(g, c, text, width, height, isCursor);
/*    */   }
/*    */   
/*    */   public abstract Composite getComposite();
/*    */   
/*    */   public abstract Color getCursorColor();
/*    */   
/*    */   public abstract void setCursorColor(Color paramColor);
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/view/appearance/CellAppearance.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */