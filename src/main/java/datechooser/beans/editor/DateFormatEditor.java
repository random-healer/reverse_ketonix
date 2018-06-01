/*    */ package datechooser.beans.editor;
/*    */ 
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DateFormatEditor
/*    */   extends PropertyEditorSupport
/*    */ {
/* 24 */   private String[] tagsText = { LocaleUtils.getEditorLocaleString("Full"), LocaleUtils.getEditorLocaleString("Long"), LocaleUtils.getEditorLocaleString("Medium"), LocaleUtils.getEditorLocaleString("Short") };
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 30 */   private int[] tags = { 0, 1, 2, 3 };
/*    */   
/*    */   public DateFormatEditor() {}
/*    */   
/* 34 */   private int getValueIndex() { if (getValue() == null) return -1;
/* 35 */     int format = ((Integer)getValue()).intValue();
/* 36 */     switch (format) {
/*    */     case 0: 
/* 38 */       return 0;
/*    */     case 1: 
/* 40 */       return 1;
/*    */     case 2: 
/* 42 */       return 2;
/*    */     case 3: 
/* 44 */       return 3;
/*    */     }
/* 46 */     return -1;
/*    */   }
/*    */   
/*    */   public String[] getTags() {
/* 50 */     return this.tagsText;
/*    */   }
/*    */   
/*    */   public String getAsText() {
/* 54 */     return this.tagsText[getValueIndex()];
/*    */   }
/*    */   
/*    */   public void setAsText(String text) throws IllegalArgumentException {
/* 58 */     for (int i = 0; i < this.tagsText.length; i++) {
/* 59 */       if (this.tagsText[i].equals(text)) {
/* 60 */         setValue(Integer.valueOf(this.tags[i]));
/* 61 */         return;
/*    */       }
/*    */     }
/* 64 */     throw new IllegalArgumentException();
/*    */   }
/*    */   
/*    */   public String getJavaInitializationString() {
/* 68 */     return ((Integer)getValue()).intValue() + "";
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/DateFormatEditor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */