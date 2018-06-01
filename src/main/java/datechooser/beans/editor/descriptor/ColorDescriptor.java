/*    */ package datechooser.beans.editor.descriptor;
/*    */ 
/*    */ import datechooser.beans.locale.LocaleUtils;
/*    */ import java.awt.Color;
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
/*    */ public class ColorDescriptor
/*    */   extends ClassDescriptor
/*    */ {
/*    */   public ColorDescriptor() {}
/*    */   
/*    */   public Class getDescriptedClass()
/*    */   {
/* 22 */     return Color.class;
/*    */   }
/*    */   
/*    */   public String getJavaDescription(Object value) {
/* 26 */     Color colorValue = (Color)value;
/* 27 */     return "new " + getClassName() + "(" + colorValue.getRed() + ", " + colorValue.getGreen() + ", " + colorValue.getBlue() + ")";
/*    */   }
/*    */   
/*    */   public String getDescription(Object value)
/*    */   {
/* 32 */     Color colorValue = (Color)value;
/* 33 */     return LocaleUtils.getEditorLocaleString("Color") + " " + LocaleUtils.getEditorLocaleString("red") + " " + colorValue.getRed() + " " + LocaleUtils.getEditorLocaleString("green") + " " + colorValue.getGreen() + " " + LocaleUtils.getEditorLocaleString("blue") + " " + colorValue.getBlue();
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/descriptor/ColorDescriptor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */