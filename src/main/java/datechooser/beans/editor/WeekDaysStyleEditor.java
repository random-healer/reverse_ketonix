/*    */ package datechooser.beans.editor;
/*    */ 
/*    */ import datechooser.beans.editor.descriptor.DescriptionManager;
/*    */ import datechooser.beans.locale.LocaleUtils;
/*    */ import datechooser.view.WeekDaysStyle;
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
/*    */ public class WeekDaysStyleEditor
/*    */   extends PropertyEditorSupport
/*    */ {
/* 23 */   private String[] tagsText = { LocaleUtils.getEditorLocaleString("WeekStyle_Full"), LocaleUtils.getEditorLocaleString("WeekStyle_Normal"), LocaleUtils.getEditorLocaleString("WeekStyle_Short") };
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 28 */   private WeekDaysStyle[] tags = { WeekDaysStyle.FULL, WeekDaysStyle.NORMAL, WeekDaysStyle.SHORT };
/*    */   
/*    */   public WeekDaysStyleEditor() {}
/*    */   
/* 32 */   private int getValueIndex() { if (getValue() == null) return -1;
/* 33 */     WeekDaysStyle style = (WeekDaysStyle)getValue();
/* 34 */     switch (style) {
/*    */     case FULL: 
/* 36 */       return 0;
/*    */     case NORMAL: 
/* 38 */       return 1;
/*    */     case SHORT: 
/* 40 */       return 2;
/*    */     }
/* 42 */     return -1;
/*    */   }
/*    */   
/*    */   public String[] getTags() {
/* 46 */     return this.tagsText;
/*    */   }
/*    */   
/*    */   public String getAsText() {
/* 50 */     return this.tagsText[getValueIndex()];
/*    */   }
/*    */   
/*    */   public void setAsText(String text) throws IllegalArgumentException {
/* 54 */     for (int i = 0; i < this.tagsText.length; i++) {
/* 55 */       if (this.tagsText[i].equals(text)) {
/* 56 */         setValue(this.tags[i]);
/* 57 */         return;
/*    */       }
/*    */     }
/* 60 */     throw new IllegalArgumentException();
/*    */   }
/*    */   
/*    */   public String getJavaInitializationString() {
/* 64 */     return DescriptionManager.describeJava(getValue(), WeekDaysStyle.class);
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/WeekDaysStyleEditor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */