/*    */ package datechooser.beans.editor.descriptor;
/*    */ 
/*    */ import datechooser.beans.locale.LocaleUtils;
/*    */ import datechooser.model.multiple.Period;
/*    */ import datechooser.model.multiple.PeriodSet;
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
/*    */ 
/*    */ public class PeriodSetDescriptor
/*    */   extends ClassDescriptor
/*    */ {
/*    */   public PeriodSetDescriptor() {}
/*    */   
/*    */   public Class getDescriptedClass()
/*    */   {
/* 25 */     return PeriodSet.class;
/*    */   }
/*    */   
/*    */   public String getJavaDescription(Object value) {
/* 29 */     PeriodSet pList = (PeriodSet)value;
/* 30 */     if (pList.getCount() == 0) {
/* 31 */       return "new " + getClassName() + "()";
/*    */     }
/* 33 */     StringBuffer buf = new StringBuffer();
/* 34 */     buf.append("new " + getClassName() + "(");
/* 35 */     for (Period period : pList.getPeriods()) {
/* 36 */       buf.append(DescriptionManager.describeJava(period, Period.class));
/* 37 */       buf.append(getSeparator());
/*    */     }
/* 39 */     buf.delete(buf.length() - getSeparator().length(), buf.length());
/* 40 */     buf.append(")");
/* 41 */     return buf.toString();
/*    */   }
/*    */   
/*    */   public String getDescription(Object value) {
/* 45 */     return getDescription(value, Locale.getDefault());
/*    */   }
/*    */   
/*    */   public String getDescription(Object value, Locale locale) {
/* 49 */     PeriodSet pList = (PeriodSet)value;
/* 50 */     if (pList.getCount() == 0) {
/* 51 */       return LocaleUtils.getEditorLocaleString("null");
/*    */     }
/* 53 */     return DescriptionManager.describe(pList.getFirstPeriod(), locale) + (pList.getCount() > 1 ? " ..." : "");
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/descriptor/PeriodSetDescriptor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */