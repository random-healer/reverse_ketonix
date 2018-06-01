/*    */ package datechooser.beans.editor.appear;
/*    */ 
/*    */ import datechooser.beans.editor.VisualEditorCashed;
/*    */ import datechooser.beans.editor.descriptor.DescriptionManager;
/*    */ import datechooser.view.appearance.AppearancesList;
/*    */ import datechooser.view.appearance.ViewAppearance;
/*    */ import javax.swing.JComponent;
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
/*    */ 
/*    */ 
/*    */ public class AppearEditor
/*    */   extends VisualEditorCashed
/*    */ {
/*    */   public AppearEditor() {}
/*    */   
/*    */   public AppearancesList getAppearancesList()
/*    */   {
/* 33 */     return (AppearancesList)getValue();
/*    */   }
/*    */   
/*    */   public void setValue(Object value) {
/* 37 */     super.setValue(((AppearancesList)value).clone());
/*    */   }
/*    */   
/*    */   public void setInnerValue(Object value) {
/* 41 */     super.setValue(value);
/*    */   }
/*    */   
/*    */   public String getAsText() {
/* 45 */     return getAppearancesList().getCurrent().getName();
/*    */   }
/*    */   
/*    */   public void setAsText(String text) throws IllegalArgumentException {
/* 49 */     if (!getAppearancesList().setCurrent(text)) {
/* 50 */       throw new IllegalArgumentException();
/*    */     }
/* 52 */     setValue(getAppearancesList().notDeepClone());
/*    */   }
/*    */   
/*    */   public String[] getTags() {
/* 56 */     return getAppearancesList().getRegisteredNames();
/*    */   }
/*    */   
/*    */   public String getJavaInitializationString() {
/* 60 */     return DescriptionManager.describeJava(getValue(), AppearancesList.class);
/*    */   }
/*    */   
/*    */   protected JComponent createEditor() {
/* 64 */     return new AppearEditorPane(this);
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/appear/AppearEditor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */