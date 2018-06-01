/*    */ package datechooser.beans.editor.descriptor;
/*    */ 
/*    */ import datechooser.beans.locale.LocaleUtils;
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
/*    */ public class StringDescriptor
/*    */   extends ClassDescriptor
/*    */ {
/*    */   public StringDescriptor() {}
/*    */   
/*    */   public Class getDescriptedClass()
/*    */   {
/* 22 */     return String.class;
/*    */   }
/*    */   
/*    */   public String getJavaDescription(Object value) {
/* 26 */     return '"' + value.toString() + '"';
/*    */   }
/*    */   
/*    */   public String getDescription(Object value) {
/* 30 */     if (value == null) return LocaleUtils.getEditorLocaleString("null");
/* 31 */     return (String)value;
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/descriptor/StringDescriptor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */