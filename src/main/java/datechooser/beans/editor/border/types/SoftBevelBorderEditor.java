/*    */ package datechooser.beans.editor.border.types;
/*    */ 
/*    */ import datechooser.beans.editor.utils.ColorHolder;
/*    */ import datechooser.beans.locale.LocaleUtils;
/*    */ import javax.swing.border.SoftBevelBorder;
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
/*    */ public class SoftBevelBorderEditor
/*    */   extends AbstractBevelBorderEditor
/*    */ {
/*    */   public SoftBevelBorderEditor()
/*    */   {
/* 23 */     setCaption(LocaleUtils.getEditorLocaleString("Soft_bevel"));
/*    */   }
/*    */   
/*    */   protected SoftBevelBorder getDefaultValue() {
/* 27 */     return new SoftBevelBorder(0);
/*    */   }
/*    */   
/*    */   protected SoftBevelBorder getBorderByParams() {
/* 31 */     return new SoftBevelBorder(this.bevelType, this.highlightOuter.getColor(), this.highlightInner.getColor(), this.shadowOuter.getColor(), this.shadowInner.getColor());
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/border/types/SoftBevelBorderEditor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */