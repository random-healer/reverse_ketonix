/*    */ package datechooser.beans.editor;
/*    */ 
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class VisualEditorCashed
/*    */   extends VisualEditor
/*    */ {
/*    */   public VisualEditorCashed() {}
/*    */   
/* 26 */   private JComponent editor = null;
/*    */   
/*    */   protected JComponent getEditorCash() {
/* 29 */     return this.editor;
/*    */   }
/*    */   
/*    */   protected void setEditorCash(JComponent editor) {
/* 33 */     this.editor = editor;
/*    */   }
/*    */   
/*    */   public JComponent getCustomEditor() {
/* 37 */     if (getEditorCash() == null) {
/* 38 */       setEditorCash(createEditor());
/*    */     }
/* 40 */     return getEditorCash();
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/VisualEditorCashed.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */