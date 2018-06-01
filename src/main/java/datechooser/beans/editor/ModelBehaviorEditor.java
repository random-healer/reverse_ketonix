/*    */ package datechooser.beans.editor;
/*    */ 
/*    */ import datechooser.beans.editor.descriptor.DescriptionManager;
/*    */ import datechooser.beans.locale.LocaleUtils;
/*    */ import datechooser.model.multiple.MultyModelBehavior;
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
/*    */ public class ModelBehaviorEditor
/*    */   extends PropertyEditorSupport
/*    */ {
/* 22 */   private String[] tagsText = { LocaleUtils.getEditorLocaleString("Single"), LocaleUtils.getEditorLocaleString("Period"), LocaleUtils.getEditorLocaleString("Multy") };
/*    */   
/*    */ 
/*    */ 
/* 26 */   private MultyModelBehavior[] tags = { MultyModelBehavior.SELECT_SINGLE, MultyModelBehavior.SELECT_PERIOD, MultyModelBehavior.SELECT_ALL };
/*    */   
/*    */   public ModelBehaviorEditor() {}
/*    */   
/* 30 */   private int getValueIndex() { if (getValue() == null) return -1;
/* 31 */     MultyModelBehavior behavior = (MultyModelBehavior)getValue();
/* 32 */     switch (behavior) {
/*    */     case SELECT_SINGLE: 
/* 34 */       return 0;
/*    */     case SELECT_PERIOD: 
/* 36 */       return 1;
/*    */     case SELECT_ALL: 
/* 38 */       return 2;
/*    */     }
/* 40 */     return -1;
/*    */   }
/*    */   
/*    */   public String[] getTags() {
/* 44 */     return this.tagsText;
/*    */   }
/*    */   
/*    */   public String getAsText() {
/* 48 */     return this.tagsText[getValueIndex()];
/*    */   }
/*    */   
/*    */   public void setAsText(String text) throws IllegalArgumentException {
/* 52 */     for (int i = 0; i < this.tagsText.length; i++) {
/* 53 */       if (this.tagsText[i].equals(text)) {
/* 54 */         setValue(this.tags[i]);
/* 55 */         return;
/*    */       }
/*    */     }
/* 58 */     throw new IllegalArgumentException();
/*    */   }
/*    */   
/*    */   public String getJavaInitializationString() {
/* 62 */     return DescriptionManager.describeJava(getValue(), MultyModelBehavior.class);
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/ModelBehaviorEditor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */