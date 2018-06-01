/*    */ package datechooser.beans.editor.descriptor;
/*    */ 
/*    */ import datechooser.beans.locale.LocaleUtils;
/*    */ import datechooser.model.multiple.MultyModelBehavior;
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
/*    */ public class ModelBehaviorDescriptor
/*    */   extends ClassDescriptor
/*    */ {
/*    */   public ModelBehaviorDescriptor() {}
/*    */   
/*    */   public Class getDescriptedClass()
/*    */   {
/* 24 */     return MultyModelBehavior.class;
/*    */   }
/*    */   
/*    */   public String getJavaDescription(Object value) {
/* 28 */     StringBuffer buf = new StringBuffer();
/* 29 */     buf.append(getClassName() + ".");
/* 30 */     MultyModelBehavior behavior = (MultyModelBehavior)value;
/* 31 */     switch (behavior) {
/*    */     case SELECT_SINGLE: 
/* 33 */       buf.append("SELECT_SINGLE");
/* 34 */       break;
/*    */     case SELECT_PERIOD: 
/* 36 */       buf.append("SELECT_PERIOD");
/* 37 */       break;
/*    */     case SELECT_ALL: 
/* 39 */       buf.append("SELECT_ALL");
/* 40 */       break;
/*    */     default: 
/* 42 */       buf.append("SELECT_ALL/* " + MessageFormat.format(LocaleUtils.getEditorLocaleString("value_not_found"), new Object[] { value.toString() }) + " */");
/*    */     }
/*    */     
/*    */     
/* 46 */     return buf.toString();
/*    */   }
/*    */   
/*    */   public String getDescription(Object value) {
/* 50 */     MultyModelBehavior behavior = (MultyModelBehavior)value;
/* 51 */     switch (behavior) {
/*    */     case SELECT_SINGLE: 
/* 53 */       return LocaleUtils.getEditorLocaleString("Single");
/*    */     case SELECT_PERIOD: 
/* 55 */       return LocaleUtils.getEditorLocaleString("Period");
/*    */     case SELECT_ALL: 
/* 57 */       return LocaleUtils.getEditorLocaleString("All");
/*    */     }
/* 59 */     return value.toString();
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/descriptor/ModelBehaviorDescriptor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */