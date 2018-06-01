/*    */ package datechooser.beans;
/*    */ 
/*    */ import datechooser.beans.customizer.DateChooserCustomizer;
/*    */ import java.beans.IntrospectionException;
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
/*    */ public class DateChooserComboCustomizer
/*    */   extends DateChooserCustomizer
/*    */ {
/*    */   public DateChooserComboCustomizer()
/*    */     throws IntrospectionException
/*    */   {
/* 23 */     super(new DateChooserComboBeanInfo());
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/DateChooserComboCustomizer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */