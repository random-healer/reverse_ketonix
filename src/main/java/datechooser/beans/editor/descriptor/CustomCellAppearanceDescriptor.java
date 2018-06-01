/*    */ package datechooser.beans.editor.descriptor;
/*    */ 
/*    */ import datechooser.view.appearance.custom.CustomCellAppearance;
/*    */ import java.awt.Color;
/*    */ import java.awt.Font;
/*    */ import javax.swing.border.Border;
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
/*    */ public class CustomCellAppearanceDescriptor
/*    */   extends ClassDescriptor
/*    */ {
/*    */   public CustomCellAppearanceDescriptor() {}
/*    */   
/*    */   public Class getDescriptedClass()
/*    */   {
/* 24 */     return CustomCellAppearance.class;
/*    */   }
/*    */   
/*    */   public String getJavaDescription(Object value) {
/* 28 */     StringBuffer buf = new StringBuffer();
/* 29 */     buf.append("new " + getClassName() + "(");
/* 30 */     CustomCellAppearance appears = (CustomCellAppearance)value;
/* 31 */     buf.append(DescriptionManager.describeJava(appears.getBackgroundColor(), Color.class));
/* 32 */     buf.append(getSeparator());
/* 33 */     buf.append(DescriptionManager.describeJava(appears.getTextColor(), Color.class));
/* 34 */     buf.append(getSeparator());
/* 35 */     buf.append(DescriptionManager.describeJava(appears.getCellBorder(), Border.class));
/* 36 */     buf.append(getSeparator());
/* 37 */     buf.append(DescriptionManager.describeJava(appears.getFont(), Font.class));
/* 38 */     buf.append(getSeparator());
/* 39 */     buf.append(DescriptionManager.describeJava(appears.getCursorColor(), Color.class));
/* 40 */     buf.append(getSeparator());
/* 41 */     buf.append(appears.getTransparency());
/* 42 */     buf.append("f");
/* 43 */     buf.append(")");
/* 44 */     return buf.toString();
/*    */   }
/*    */   
/*    */   public String getDescription(Object value) {
/* 48 */     return getClassName();
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/descriptor/CustomCellAppearanceDescriptor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */