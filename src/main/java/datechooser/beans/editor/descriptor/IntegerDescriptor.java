/*    */ package datechooser.beans.editor.descriptor;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IntegerDescriptor
/*    */   extends ClassDescriptor
/*    */ {
/*    */   public IntegerDescriptor() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public Class getDescriptedClass()
/*    */   {
/* 20 */     return Integer.class;
/*    */   }
/*    */   
/*    */   public String getJavaDescription(Object value) {
/* 24 */     return value != null ? ((Integer)value).intValue() + "" : "0";
/*    */   }
/*    */   
/*    */   public String getDescription(Object value) {
/* 28 */     return value != null ? ((Integer)value).intValue() + "" : "0";
/*    */   }
/*    */   
/*    */   public boolean canProcessNull() {
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/descriptor/IntegerDescriptor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */