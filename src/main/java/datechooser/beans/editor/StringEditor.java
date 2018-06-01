/*    */ package datechooser.beans.editor;
/*    */ 
/*    */ import datechooser.beans.editor.descriptor.DescriptionManager;
/*    */ import java.beans.PropertyEditorSupport;
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
/*    */ public class StringEditor
/*    */   extends PropertyEditorSupport
/*    */ {
/*    */   public StringEditor() {}
/*    */   
/*    */   public String getAsText()
/*    */   {
/* 24 */     return (String)getValue();
/*    */   }
/*    */   
/*    */   public void setAsText(String text) throws IllegalArgumentException {
/* 28 */     setValue(text);
/* 29 */     firePropertyChange();
/*    */   }
/*    */   
/*    */   public String getJavaInitializationString() {
/* 33 */     return DescriptionManager.describeJava(getValue(), String.class);
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/StringEditor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */