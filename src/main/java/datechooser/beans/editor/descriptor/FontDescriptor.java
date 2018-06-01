/*    */ package datechooser.beans.editor.descriptor;
/*    */ 
/*    */ import datechooser.beans.locale.LocaleUtils;
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
/*    */ 
/*    */ public class FontDescriptor
/*    */   extends ClassDescriptor
/*    */ {
/*    */   public FontDescriptor() {}
/*    */   
/*    */   public Class getDescriptedClass()
/*    */   {
/* 23 */     return Font.class;
/*    */   }
/*    */   
/*    */   public String getDescription(Object value) {
/* 27 */     StringBuffer buf = new StringBuffer();
/* 28 */     Font selFont = (Font)value;
/* 29 */     buf.append(selFont.getFamily());
/* 30 */     buf.append(", ");
/* 31 */     if (selFont.isItalic()) {
/* 32 */       buf.append(LocaleUtils.getEditorLocaleString("italic") + ", ");
/*    */     }
/* 34 */     if (selFont.isBold()) {
/* 35 */       buf.append(LocaleUtils.getEditorLocaleString("bold") + ", ");
/*    */     }
/* 37 */     buf.append(selFont.getSize());
/* 38 */     return buf.toString();
/*    */   }
/*    */   
/*    */   public String getJavaDescription(Object value) {
/* 42 */     StringBuffer buf = new StringBuffer();
/* 43 */     Font selFont = (Font)value;
/* 44 */     buf.append("new " + getClassName() + "(");
/* 45 */     buf.append('"' + selFont.getFamily() + '"');
/* 46 */     buf.append(", ");
/* 47 */     if ((selFont.isBold()) && (selFont.isItalic())) {
/* 48 */       buf.append(getClassName() + ".BOLD + " + getClassName() + ".ITALIC");
/* 49 */     } else if (selFont.isBold()) {
/* 50 */       buf.append(getClassName() + ".BOLD");
/* 51 */     } else if (selFont.isItalic()) {
/* 52 */       buf.append(getClassName() + ".ITALIC");
/*    */     } else {
/* 54 */       buf.append(getClassName() + ".PLAIN");
/*    */     }
/* 56 */     buf.append(", ");
/* 57 */     buf.append(selFont.getSize());
/* 58 */     buf.append(")");
/* 59 */     return buf.toString();
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/descriptor/FontDescriptor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */