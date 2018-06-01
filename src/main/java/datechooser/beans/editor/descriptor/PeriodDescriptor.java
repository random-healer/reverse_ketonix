/*    */ package datechooser.beans.editor.descriptor;
/*    */ 
/*    */ import datechooser.model.multiple.Period;
/*    */ import java.util.Calendar;
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
/*    */ public class PeriodDescriptor
/*    */   extends ClassDescriptor
/*    */ {
/*    */   public PeriodDescriptor() {}
/*    */   
/*    */   public Class getDescriptedClass()
/*    */   {
/* 22 */     return Period.class;
/*    */   }
/*    */   
/*    */   public String getJavaDescription(Object value) {
/* 26 */     StringBuffer buf = new StringBuffer();
/* 27 */     Period period = (Period)value;
/* 28 */     Calendar start = period.getStartDate();
/* 29 */     Calendar end = period.getEndDate();
/* 30 */     buf.append("new " + getClassName() + "(");
/* 31 */     buf.append(DescriptionManager.describeJava(start, GregorianCalendar.class));
/* 32 */     buf.append(getSeparator());
/* 33 */     buf.append(DescriptionManager.describeJava(end, GregorianCalendar.class));
/* 34 */     buf.append(")");
/* 35 */     return buf.toString();
/*    */   }
/*    */   
/*    */   public String getDescription(Object value) {
/* 39 */     return getDescription(value, Locale.getDefault());
/*    */   }
/*    */   
/*    */   public String getDescription(Object value, Locale locale) {
/* 43 */     Period period = (Period)value;
/* 44 */     return DescriptionManager.describe(period.getStartDate(), locale) + (period.isOneDate() ? "" : new StringBuilder().append(" - ").append(DescriptionManager.describe(period.getEndDate(), locale)).toString());
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/descriptor/PeriodDescriptor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */