/*    */ package datechooser.beans.editor;
/*    */ 
/*    */ import java.beans.PropertyEditorSupport;
/*    */ import javax.swing.JComponent;
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
/*    */ public abstract class VisualEditor
/*    */   extends PropertyEditorSupport
/*    */ {
/*    */   public VisualEditor() {}
/*    */   
/*    */   public boolean supportsCustomEditor()
/*    */   {
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public JComponent getCustomEditor() {
/* 26 */     return createEditor();
/*    */   }
/*    */   
/*    */   protected abstract JComponent createEditor();
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/VisualEditor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */