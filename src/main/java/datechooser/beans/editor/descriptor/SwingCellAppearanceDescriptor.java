/*    */ package datechooser.beans.editor.descriptor;
/*    */ 
/*    */ import datechooser.view.appearance.swing.SwingCellAppearance;
/*    */ import java.awt.Color;
/*    */ import java.awt.Font;
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
/*    */ public class SwingCellAppearanceDescriptor
/*    */   extends ClassDescriptor
/*    */ {
/*    */   public SwingCellAppearanceDescriptor() {}
/*    */   
/*    */   public Class getDescriptedClass()
/*    */   {
/* 23 */     return SwingCellAppearance.class;
/*    */   }
/*    */   
/*    */   public String getJavaDescription(Object value) {
/* 27 */     StringBuffer buf = new StringBuffer();
/* 28 */     buf.append("new " + getClassName() + "(");
/*    */     
/* 30 */     SwingCellAppearance appears = (SwingCellAppearance)value;
/* 31 */     buf.append(DescriptionManager.describeJava(appears.getFont(), Font.class));
/* 32 */     buf.append(getSeparator());
/* 33 */     buf.append(DescriptionManager.describeJava(appears.getTextColor(), Color.class));
/* 34 */     buf.append(getSeparator());
/* 35 */     buf.append(DescriptionManager.describeJava(appears.getCursorColor(), Color.class));
/* 36 */     buf.append(getSeparator());
/* 37 */     buf.append(appears.isPressed());
/* 38 */     buf.append(getSeparator());
/* 39 */     buf.append(appears.isEnabled());
/* 40 */     buf.append(getSeparator());
/* 41 */     buf.append("new " + appears.getPainter().getClass().getName() + "()");
/* 42 */     buf.append(")");
/* 43 */     return buf.toString();
/*    */   }
/*    */   
/*    */   public String getDescription(Object value) {
/* 47 */     return getClassName();
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/descriptor/SwingCellAppearanceDescriptor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */