/*    */ package datechooser.beans.editor.locale;
/*    */ 
/*    */ import datechooser.beans.DateChooserPanel;
/*    */ import java.awt.BorderLayout;
/*    */ import java.awt.Font;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import java.beans.PropertyChangeEvent;
/*    */ import java.beans.PropertyChangeListener;
/*    */ import java.beans.PropertyEditorSupport;
/*    */ import java.util.Locale;
/*    */ import javax.swing.BorderFactory;
/*    */ import javax.swing.JComboBox;
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
/*    */ class LocaleEditorPane
/*    */   extends JPanel
/*    */ {
/*    */   private PropertyEditorSupport editor;
/* 29 */   private static LocaleSet data = null;
/*    */   private JComboBox selLocale;
/*    */   private boolean innerEdit;
/*    */   private DateChooserPanel dc;
/*    */   
/*    */   public LocaleEditorPane(PropertyEditorSupport editor) {
/* 35 */     if (data == null) data = new LocaleSet();
/* 36 */     setEditor(editor);
/* 37 */     setInnerEdit(false);
/* 38 */     this.selLocale = new JComboBox(data.getNames());
/* 39 */     this.dc = new DateChooserPanel();
/*    */     
/* 41 */     this.dc.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5), BorderFactory.createEtchedBorder()));
/*    */     
/*    */ 
/*    */ 
/* 45 */     this.selLocale.setFont(new Font("Serif", 0, 12));
/* 46 */     updateValue();
/* 47 */     this.selLocale.addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/* 49 */         if (LocaleEditorPane.this.isInnerEdit()) return;
/* 50 */         LocaleEditorPane.this.getEditor().setValue(LocaleEditorPane.data.getLocales()[LocaleEditorPane.this.selLocale.getSelectedIndex()]);
/*    */       }
/* 52 */     });
/* 53 */     getEditor().addPropertyChangeListener(new PropertyChangeListener() {
/*    */       public void propertyChange(PropertyChangeEvent evt) {
/* 55 */         LocaleEditorPane.this.updateValue();
/*    */       }
/* 57 */     });
/* 58 */     setLayout(new BorderLayout());
/* 59 */     add(this.selLocale, "North");
/* 60 */     add(this.dc, "Center");
/*    */   }
/*    */   
/*    */   private void updateValue() {
/* 64 */     if (isInnerEdit()) return;
/* 65 */     setInnerEdit(true);
/* 66 */     this.selLocale.setSelectedIndex(data.getIndex(getEditorValue()));
/* 67 */     this.dc.setLocale(getEditorValue());
/* 68 */     setInnerEdit(false);
/*    */   }
/*    */   
/*    */   private Locale getEditorValue() {
/* 72 */     return (Locale)getEditor().getValue();
/*    */   }
/*    */   
/*    */   public PropertyEditorSupport getEditor() {
/* 76 */     return this.editor;
/*    */   }
/*    */   
/*    */   public void setEditor(PropertyEditorSupport editor) {
/* 80 */     this.editor = editor;
/*    */   }
/*    */   
/*    */   public boolean isInnerEdit() {
/* 84 */     return this.innerEdit;
/*    */   }
/*    */   
/*    */   public void setInnerEdit(boolean innerEdit) {
/* 88 */     this.innerEdit = innerEdit;
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/locale/LocaleEditorPane.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */