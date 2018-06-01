/*    */ package datechooser.beans.editor.border.types;
/*    */ 
/*    */ import datechooser.beans.editor.utils.ColorHolder;
/*    */ import datechooser.beans.locale.LocaleUtils;
/*    */ import javax.swing.border.BevelBorder;
/*    */ import javax.swing.border.Border;
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
/*    */ public class BevelBorderEditor
/*    */   extends AbstractBevelBorderEditor
/*    */ {
/*    */   public BevelBorderEditor()
/*    */   {
/* 23 */     setCaption(LocaleUtils.getEditorLocaleString("Bevel"));
/*    */   }
/*    */   
/*    */   protected BevelBorder getBorderByParams() {
/* 27 */     return new BevelBorder(this.bevelType, this.highlightOuter.getColor(), this.highlightInner.getColor(), this.shadowOuter.getColor(), this.shadowInner.getColor());
/*    */   }
/*    */   
/*    */ 
/*    */   protected Border getDefaultValue()
/*    */   {
/* 33 */     return new BevelBorder(0);
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/border/types/BevelBorderEditor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */