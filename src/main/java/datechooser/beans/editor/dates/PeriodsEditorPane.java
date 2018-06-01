/*    */ package datechooser.beans.editor.dates;
/*    */ 
/*    */ import datechooser.beans.DateChooserPanel;
/*    */ import datechooser.model.DateChoose;
/*    */ import datechooser.model.multiple.PeriodSet;
/*    */ import java.awt.BorderLayout;
/*    */ import java.beans.PropertyChangeEvent;
/*    */ import java.beans.PropertyChangeListener;
/*    */ import java.beans.PropertyEditorSupport;
/*    */ import javax.swing.JPanel;
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
/*    */ class PeriodsEditorPane
/*    */   extends JPanel
/*    */   implements PropertyChangeListener
/*    */ {
/* 27 */   private PropertyEditorSupport editor = null;
/*    */   private DateChooserPanel chooser;
/* 29 */   private static int c = 0;
/*    */   private boolean innerEdit;
/*    */   
/* 32 */   public PeriodsEditorPane(PropertyEditorSupport editor) { setEditor(editor);
/* 33 */     this.chooser = new DateChooserPanel();
/* 34 */     initEditor();
/* 35 */     setLayout(new BorderLayout());
/* 36 */     add(this.chooser, "Center");
/* 37 */     this.chooser.getModel().addPropertyChangeListener(new PropertyChangeListener() {
/*    */       public void propertyChange(PropertyChangeEvent evt) {
/* 39 */         PeriodsEditorPane.this.innerSetValue(PeriodsEditorPane.this.chooser.getSelectedPeriodSet());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   private void initEditor() {
/* 45 */     if (isInnerEdit()) return;
/* 46 */     setInnerEdit(true);
/* 47 */     if (getEditorValue() != null) {
/* 48 */       this.chooser.setSelection(getEditorValue());
/*    */     }
/* 50 */     setInnerEdit(false);
/*    */   }
/*    */   
/*    */   private void innerSetValue(PeriodSet value) {
/* 54 */     if (isInnerEdit()) {
/* 55 */       return;
/*    */     }
/* 57 */     setInnerEdit(true);
/* 58 */     getEditor().setValue(value.clone());
/* 59 */     setInnerEdit(false);
/*    */   }
/*    */   
/*    */   private PeriodSet getEditorValue() {
/* 63 */     return (PeriodSet)this.editor.getValue();
/*    */   }
/*    */   
/*    */   public PropertyEditorSupport getEditor() {
/* 67 */     return this.editor;
/*    */   }
/*    */   
/*    */   public void setEditor(PropertyEditorSupport editor) {
/* 71 */     if (getEditor() != null) {
/* 72 */       getEditor().removePropertyChangeListener(this);
/*    */     }
/* 74 */     this.editor = editor;
/* 75 */     getEditor().addPropertyChangeListener(this);
/*    */   }
/*    */   
/*    */   public boolean isInnerEdit() {
/* 79 */     return this.innerEdit;
/*    */   }
/*    */   
/*    */   public void setInnerEdit(boolean innerEdit) {
/* 83 */     this.innerEdit = innerEdit;
/*    */   }
/*    */   
/*    */   public void propertyChange(PropertyChangeEvent evt) {
/* 87 */     initEditor();
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/dates/PeriodsEditorPane.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */