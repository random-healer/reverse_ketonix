/*    */ package datechooser.beans.editor.border.types;
/*    */ 
/*    */ import datechooser.beans.locale.LocaleUtils;
/*    */ import java.awt.FlowLayout;
/*    */ import javax.swing.JLabel;
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
/*    */ 
/*    */ 
/*    */ public class NoBorderEditor
/*    */   extends AbstractBorderEditor
/*    */ {
/*    */   public NoBorderEditor()
/*    */   {
/* 24 */     setCaption(LocaleUtils.getEditorLocaleString("No_borded"));
/* 25 */     setLayout(new FlowLayout(1));
/* 26 */     add(new JLabel("x"));
/*    */   }
/*    */   
/*    */   protected Border getDefaultValue() {
/* 30 */     return null;
/*    */   }
/*    */   
/*    */   protected void prepareSelection() {
/* 34 */     this.value = null;
/*    */   }
/*    */   
/*    */   protected void refreshInterface() {}
/*    */   
/*    */   public void setCurrentBorder(Border border)
/*    */   {
/* 41 */     this.value = null;
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/border/types/NoBorderEditor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */