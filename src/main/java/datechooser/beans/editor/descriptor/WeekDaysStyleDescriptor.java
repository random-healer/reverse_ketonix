/*    */ package datechooser.beans.editor.descriptor;
/*    */ 
/*    */ import datechooser.beans.locale.LocaleUtils;
/*    */ import datechooser.view.WeekDaysStyle;
/*    */ import java.text.MessageFormat;
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
/*    */ public class WeekDaysStyleDescriptor
/*    */   extends ClassDescriptor
/*    */ {
/*    */   public WeekDaysStyleDescriptor() {}
/*    */   
/*    */   public Class getDescriptedClass()
/*    */   {
/* 24 */     return WeekDaysStyle.class;
/*    */   }
/*    */   
/*    */   public String getJavaDescription(Object value) {
/* 28 */     StringBuffer buf = new StringBuffer();
/* 29 */     buf.append(getClassName() + ".");
/* 30 */     WeekDaysStyle style = (WeekDaysStyle)value;
/* 31 */     switch (style) {
/*    */     case FULL: 
/* 33 */       buf.append("FULL");
/* 34 */       break;
/*    */     case NORMAL: 
/* 36 */       buf.append("NORMAL");
/* 37 */       break;
/*    */     case SHORT: 
/* 39 */       buf.append("SHORT");
/* 40 */       break;
/*    */     default: 
/* 42 */       buf.append("NORMAL/* " + MessageFormat.format(LocaleUtils.getEditorLocaleString("value_not_found"), new Object[] { value.toString() }) + " */");
/*    */     }
/*    */     
/*    */     
/* 46 */     return buf.toString();
/*    */   }
/*    */   
/*    */   public String getDescription(Object value) {
/* 50 */     WeekDaysStyle style = (WeekDaysStyle)value;
/* 51 */     switch (style) {
/*    */     case FULL: 
/* 53 */       return LocaleUtils.getEditorLocaleString("WeekStyle_Full");
/*    */     case NORMAL: 
/* 55 */       return LocaleUtils.getEditorLocaleString("WeekStyle_Normal");
/*    */     case SHORT: 
/* 57 */       return LocaleUtils.getEditorLocaleString("WeekStyle_Short");
/*    */     }
/* 59 */     return value.toString();
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/descriptor/WeekDaysStyleDescriptor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */