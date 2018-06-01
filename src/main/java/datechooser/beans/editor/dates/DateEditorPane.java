/*    */ package datechooser.beans.editor.dates;
/*    */ 
/*    */ import datechooser.beans.DateChooserPanel;
/*    */ import datechooser.model.DateChoose;
/*    */ import datechooser.model.multiple.MultyModelBehavior;
/*    */ import java.awt.BorderLayout;
/*    */ import java.beans.PropertyChangeEvent;
/*    */ import java.beans.PropertyChangeListener;
/*    */ import java.beans.PropertyEditorSupport;
/*    */ import java.util.Calendar;
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
/*    */ 
/*    */ class DateEditorPane
/*    */   extends JPanel
/*    */ {
/*    */   private PropertyEditorSupport editor;
/*    */   private DateChooserPanel chooser;
/*    */   private boolean innerEdit;
/*    */   
/*    */   public DateEditorPane(PropertyEditorSupport editor)
/*    */   {
/* 34 */     setEditor(editor);
/* 35 */     this.chooser = new DateChooserPanel();
/* 36 */     this.chooser.setBehavior(MultyModelBehavior.SELECT_SINGLE);
/* 37 */     initEditor();
/* 38 */     setLayout(new BorderLayout());
/* 39 */     add(this.chooser, "Center");
/* 40 */     this.chooser.getModel().addPropertyChangeListener(new PropertyChangeListener() {
/*    */       public void propertyChange(PropertyChangeEvent evt) {
/* 42 */         DateEditorPane.this.innerSetValue(DateEditorPane.this.chooser.getSelectedDate());
/*    */       }
/*    */       
/* 45 */     });
/* 46 */     getEditor().addPropertyChangeListener(new PropertyChangeListener() {
/*    */       public void propertyChange(PropertyChangeEvent evt) {
/* 48 */         DateEditorPane.this.initEditor();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   private void initEditor() {
/* 54 */     if (!isInnerEdit()) {
/* 55 */       innerSetValue(getEditorValue());
/* 56 */       setInnerEdit(true);
/* 57 */       this.chooser.setSelectedDate(getEditorValue());
/* 58 */       setInnerEdit(false);
/*    */     }
/*    */   }
/*    */   
/*    */   private void innerSetValue(Calendar value) {
/* 63 */     if (isInnerEdit()) {
/* 64 */       return;
/*    */     }
/* 66 */     setInnerEdit(true);
/* 67 */     Calendar date = value != null ? (Calendar)value.clone() : null;
/* 68 */     getEditor().setValue(date);
/* 69 */     setInnerEdit(false);
/*    */   }
/*    */   
/*    */   private Calendar getEditorValue() {
/* 73 */     return (Calendar)this.editor.getValue();
/*    */   }
/*    */   
/*    */   public PropertyEditorSupport getEditor() {
/* 77 */     return this.editor;
/*    */   }
/*    */   
/*    */   public void setEditor(PropertyEditorSupport editor) {
/* 81 */     this.editor = editor;
/*    */   }
/*    */   
/*    */   public boolean isInnerEdit() {
/* 85 */     return this.innerEdit;
/*    */   }
/*    */   
/*    */   public void setInnerEdit(boolean innerEdit) {
/* 89 */     this.innerEdit = innerEdit;
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/dates/DateEditorPane.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */