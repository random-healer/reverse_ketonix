/*    */ package datechooser.beans.editor.descriptor;
/*    */ 
/*    */ import java.text.DateFormat;
/*    */ import java.util.GregorianCalendar;
/*    */ import java.util.Locale;
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
/*    */ public class GregorianCalendarDescriptor
/*    */   extends ClassDescriptor
/*    */ {
/*    */   public GregorianCalendarDescriptor() {}
/*    */   
/*    */   public Class getDescriptedClass()
/*    */   {
/* 23 */     return GregorianCalendar.class;
/*    */   }
/*    */   
/*    */   public String getJavaDescription(Object value) {
/* 27 */     StringBuffer buf = new StringBuffer();
/* 28 */     GregorianCalendar date = (GregorianCalendar)value;
/* 29 */     buf.append("new " + getClassName() + "(");
/* 30 */     buf.append(date.get(1));
/* 31 */     buf.append(", ");
/* 32 */     buf.append(date.get(2));
/* 33 */     buf.append(", ");
/* 34 */     buf.append(date.get(5));
/* 35 */     buf.append(")");
/* 36 */     return buf.toString();
/*    */   }
/*    */   
/*    */   public String getDescription(Object value) {
/* 40 */     return getDescription(value, Locale.getDefault());
/*    */   }
/*    */   
/*    */   public String getDescription(Object value, Locale locale) {
/* 44 */     GregorianCalendar calendar = (GregorianCalendar)value;
/* 45 */     return DateFormat.getDateInstance(3, locale).format(calendar.getTime());
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/descriptor/GregorianCalendarDescriptor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */