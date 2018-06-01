/*    */ package datechooser.beans.editor.backrender;
/*    */ 
/*    */ import datechooser.beans.editor.VisualEditorCashed;
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
/*    */ public class BackRendererEditor
/*    */   extends VisualEditorCashed
/*    */ {
/*    */   public BackRendererEditor() {}
/*    */   
/*    */   protected JComponent createEditor()
/*    */   {
/* 24 */     return new BackRendererEditorPane(this);
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/backrender/BackRendererEditor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */