/*    */ package datechooser.beans.editor.descriptor;
/*    */ 
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
/*    */ public class LocaleDescriptor
/*    */   extends ClassDescriptor
/*    */ {
/*    */   public LocaleDescriptor() {}
/*    */   
/*    */   public Class getDescriptedClass()
/*    */   {
/* 22 */     return Locale.class;
/*    */   }
/*    */   
/*    */   public String getJavaDescription(Object value) {
/* 26 */     Locale locale = (Locale)value;
/* 27 */     StringBuffer buf = new StringBuffer();
/* 28 */     buf.append("new " + getClassName() + "(");
/* 29 */     buf.append('"' + locale.getLanguage() + '"');
/* 30 */     buf.append(", ");
/* 31 */     buf.append('"' + locale.getCountry() + '"');
/* 32 */     if (locale.getVariant() != null) {
/* 33 */       buf.append(", ");
/* 34 */       buf.append('"' + locale.getVariant() + '"');
/*    */     }
/* 36 */     buf.append(")");
/* 37 */     return buf.toString();
/*    */   }
/*    */   
/*    */   public String getDescription(Object value) {
/* 41 */     return ((Locale)value).getDisplayName((Locale)value);
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/descriptor/LocaleDescriptor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */