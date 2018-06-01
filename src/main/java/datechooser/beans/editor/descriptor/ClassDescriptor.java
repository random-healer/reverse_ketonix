/*    */ package datechooser.beans.editor.descriptor;
/*    */ 
/*    */ import datechooser.beans.locale.LocaleUtils;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class ClassDescriptor
/*    */ {
/*    */   protected static final String ONE_LINE_SEPARATOR = ", ";
/*    */   protected static final String NEW_LINE_SEPARATOR = ",\n";
/* 26 */   private static boolean newLineParameters = true;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public ClassDescriptor() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public abstract Class getDescriptedClass();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public abstract String getJavaDescription(Object paramObject);
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public abstract String getDescription(Object paramObject);
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public String getDescription(Object value, Locale locale)
/*    */   {
/* 57 */     return getDescription(value) + " (" + LocaleUtils.getEditorLocaleString("default_locale_used") + ")";
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected String getClassName()
/*    */   {
/* 65 */     return getDescriptedClass().getName();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected String getSeparator()
/*    */   {
/* 73 */     return isNewLineParameters() ? ",\n" : ", ";
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean isNewLineParameters()
/*    */   {
/* 83 */     return newLineParameters;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static void setNewLineParameters(boolean aNewLineParameters)
/*    */   {
/* 90 */     newLineParameters = aNewLineParameters;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean canProcessNull()
/*    */   {
/* 98 */     return false;
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/descriptor/ClassDescriptor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */