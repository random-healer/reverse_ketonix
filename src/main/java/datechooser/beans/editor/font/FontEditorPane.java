/*    */ package datechooser.beans.editor.font;
/*    */ 
/*    */ import java.awt.BorderLayout;
/*    */ import java.awt.Font;
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
/*    */ class FontEditorPane
/*    */   extends JPanel
/*    */   implements PropertyChangeListener
/*    */ {
/*    */   private PropertyEditorSupport editor;
/*    */   private FontSelectPane selector;
/*    */   private FontPreviewPane preview;
/*    */   
/*    */   public FontEditorPane(PropertyEditorSupport editor)
/*    */   {
/* 29 */     setEditor(editor);
/* 30 */     this.selector = new FontSelectPane((Font)editor.getValue());
/* 31 */     this.preview = new FontPreviewPane((Font)editor.getValue());
/* 32 */     setLayout(new BorderLayout());
/* 33 */     add(this.selector, "North");
/* 34 */     add(this.preview, "Center");
/*    */     
/* 36 */     this.selector.addPropertyChangeListener(new PropertyChangeListener() {
/*    */       public void propertyChange(PropertyChangeEvent evt) {
/* 38 */         if (!"font".equals(evt.getPropertyName())) return;
/* 39 */         Font newFont = FontEditorPane.this.selector.getSelectedFont();
/* 40 */         FontEditorPane.this.preview.setFont(newFont);
/* 41 */         FontEditorPane.this.getEditor().setValue(newFont);
/* 42 */         FontEditorPane.this.getEditor().firePropertyChange();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public PropertyEditorSupport getEditor()
/*    */   {
/* 49 */     return this.editor;
/*    */   }
/*    */   
/*    */   public void setEditor(PropertyEditorSupport editor) {
/* 53 */     if (this.editor != null) this.editor.removePropertyChangeListener(this);
/* 54 */     this.editor = editor;
/* 55 */     editor.addPropertyChangeListener(this);
/*    */   }
/*    */   
/*    */   public void propertyChange(PropertyChangeEvent evt) {
/* 59 */     Font font = (Font)getEditor().getValue();
/* 60 */     this.selector.setSelectedFont(font);
/* 61 */     this.preview.setFont(font);
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/font/FontEditorPane.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */