/*    */ package datechooser.beans.editor.border.types;
/*    */ 
/*    */ import datechooser.beans.locale.LocaleUtils;
/*    */ import javax.swing.BorderFactory;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DefaultBorderEditor
/*    */   extends AbstractBorderEditor
/*    */ {
/*    */   public DefaultBorderEditor()
/*    */   {
/* 25 */     initialize();
/* 26 */     setCaption(LocaleUtils.getEditorLocaleString("Default"));
/* 27 */     refreshInterface();
/*    */   }
/*    */   
/*    */   protected Border getDefaultValue() {
/* 31 */     return BorderFactory.createEmptyBorder();
/*    */   }
/*    */   
/*    */   protected void prepareSelection() {}
/*    */   
/*    */   protected void refreshInterface() {}
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/border/types/DefaultBorderEditor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */