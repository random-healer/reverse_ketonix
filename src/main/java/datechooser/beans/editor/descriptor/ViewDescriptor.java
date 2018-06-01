/*    */ package datechooser.beans.editor.descriptor;
/*    */ 
/*    */ import datechooser.view.BackRenderer;
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
/*    */ 
/*    */ public class ViewDescriptor
/*    */   extends ClassDescriptor
/*    */ {
/*    */   public ViewDescriptor() {}
/*    */   
/*    */   public Class getDescriptedClass()
/*    */   {
/* 23 */     return ViewAppearance.class;
/*    */   }
/*    */   
/*    */   public String getJavaDescription(Object value) {
/* 27 */     StringBuffer buf = new StringBuffer();
/* 28 */     ViewAppearance view = (ViewAppearance)value;
/* 29 */     buf.append("new " + getClassName() + '(');
/* 30 */     buf.append('"' + view.getName() + '"');
/* 31 */     buf.append(getSeparator());
/* 32 */     buf.append(DescriptionManager.describeJava(view.getUsual(), view.getUsual().getClass()));
/* 33 */     buf.append(getSeparator());
/* 34 */     buf.append(DescriptionManager.describeJava(view.getSelected(), view.getSelected().getClass()));
/* 35 */     buf.append(getSeparator());
/* 36 */     buf.append(DescriptionManager.describeJava(view.getNow(), view.getNow().getClass()));
/* 37 */     buf.append(getSeparator());
/* 38 */     buf.append(DescriptionManager.describeJava(view.getScroll(), view.getScroll().getClass()));
/* 39 */     buf.append(getSeparator());
/* 40 */     buf.append(DescriptionManager.describeJava(view.getCaption(), view.getCaption().getClass()));
/* 41 */     buf.append(getSeparator());
/* 42 */     buf.append(DescriptionManager.describeJava(view.getDisabled(), view.getDisabled().getClass()));
/* 43 */     buf.append(getSeparator());
/* 44 */     buf.append(DescriptionManager.describeJava(view.getRenderer(), BackRenderer.class));
/* 45 */     buf.append(getSeparator());
/* 46 */     buf.append(view.isSupportsTransparency() ? "true" : "false");
/* 47 */     buf.append(getSeparator());
/* 48 */     buf.append(view.isEditable() ? "true" : "false");
/* 49 */     buf.append(")");
/* 50 */     return buf.toString();
/*    */   }
/*    */   
/*    */   public String getDescription(Object value) {
/* 54 */     return ((ViewAppearance)value).getName();
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/descriptor/ViewDescriptor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */