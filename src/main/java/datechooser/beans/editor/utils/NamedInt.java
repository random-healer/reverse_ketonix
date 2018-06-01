/*    */ package datechooser.beans.editor.utils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NamedInt
/*    */ {
/*    */   private String name;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private int value;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public NamedInt(String name, int value)
/*    */   {
/* 24 */     this.name = name;
/* 25 */     this.value = value;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 29 */     return this.name;
/*    */   }
/*    */   
/*    */   public int getValue() {
/* 33 */     return this.value;
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/utils/NamedInt.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */