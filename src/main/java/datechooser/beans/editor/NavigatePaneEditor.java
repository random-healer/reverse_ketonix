/*    */ package datechooser.beans.editor;
/*    */ 
/*    */ import datechooser.beans.editor.descriptor.DescriptionManager;
/*    */ import datechooser.beans.locale.LocaleUtils;
/*    */ import java.beans.PropertyEditorSupport;
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
/*    */ public class NavigatePaneEditor
/*    */   extends PropertyEditorSupport
/*    */ {
/* 22 */   private String[] tagsText = { LocaleUtils.getEditorLocaleString("Fields_navigator"), LocaleUtils.getEditorLocaleString("Button_navigator") };
/*    */   
/*    */   public NavigatePaneEditor() {}
/*    */   
/*    */   public String[] getTags() {
/* 27 */     return this.tagsText;
/*    */   }
/*    */   
/*    */   public String getAsText() {
/* 31 */     return this.tagsText[getValueIndex()];
/*    */   }
/*    */   
/*    */   public void setAsText(String text) throws IllegalArgumentException {
/* 35 */     for (int i = 0; i < this.tagsText.length; i++) {
/* 36 */       if (this.tagsText[i].equals(text)) {
/* 37 */         setValue(new Integer(i));
/* 38 */         return;
/*    */       }
/*    */     }
/* 41 */     throw new IllegalArgumentException();
/*    */   }
/*    */   
/*    */   public String getJavaInitializationString() {
/* 45 */     return DescriptionManager.describeJava(getValue(), Integer.class);
/*    */   }
/*    */   
/*    */   private int getValueIndex() {
/* 49 */     return ((Integer)getValue()).intValue();
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/NavigatePaneEditor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */