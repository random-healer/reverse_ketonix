/*    */ package datechooser.beans.editor.descriptor;
/*    */ 
/*    */ import datechooser.view.appearance.AppearancesList;
/*    */ import datechooser.view.appearance.ViewAppearance;
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
/*    */ public class AppearancesListDescriptor
/*    */   extends ClassDescriptor
/*    */ {
/*    */   public AppearancesListDescriptor() {}
/*    */   
/*    */   public Class getDescriptedClass()
/*    */   {
/* 22 */     return AppearancesList.class;
/*    */   }
/*    */   
/*    */   public String getJavaDescription(Object value) {
/* 26 */     AppearancesList list = (AppearancesList)value;
/* 27 */     StringBuffer buf = new StringBuffer();
/* 28 */     buf.append("new " + getClassName() + "(");
/* 29 */     buf.append('"' + list.getCurrent().getName() + '"');
/* 30 */     for (String key : list.getKeys()) {
/* 31 */       if (list.getAppearance(key).isEditable())
/*    */       {
/*    */ 
/* 34 */         buf.append(getSeparator());
/* 35 */         buf.append(DescriptionManager.describeJava(list.getAppearance(key), ViewAppearance.class));
/*    */       }
/*    */     }
/* 38 */     buf.append(")");
/* 39 */     return buf.toString();
/*    */   }
/*    */   
/*    */   public String getDescription(Object value) {
/* 43 */     return "[" + ((AppearancesList)value).getCurrent().getName() + "]...";
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/descriptor/AppearancesListDescriptor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */