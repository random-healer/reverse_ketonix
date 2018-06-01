/*     */ package datechooser.beans.editor.utils;
/*     */ 
/*     */ import datechooser.beans.locale.LocaleUtils;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.FlowLayout;
/*     */ import java.awt.Frame;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.beans.PropertyEditorSupport;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EditorDialog
/*     */   extends JDialog
/*     */ {
/*     */   private PropertyEditorSupport propertyEditor;
/*     */   private JButton bOK;
/*     */   private JButton bCancel;
/*     */   private Object value;
/*     */   private Object defaultValue;
/*     */   private JPanel bPane;
/*     */   private boolean canceled;
/*     */   
/*     */   public EditorDialog(Frame owner, PropertyEditorSupport editor)
/*     */   {
/*  33 */     super(owner, true);
/*  34 */     this.propertyEditor = getClonedEditor(editor);
/*  35 */     setCanceled(false);
/*  36 */     Container pane = getContentPane();
/*  37 */     pane.setLayout(new BorderLayout());
/*  38 */     OnClick onClick = new OnClick(null);
/*  39 */     this.bOK = new JButton(LocaleUtils.getEditorLocaleString("OK"));
/*  40 */     this.bOK.addActionListener(onClick);
/*  41 */     this.bCancel = new JButton(LocaleUtils.getEditorLocaleString("Cancel"));
/*  42 */     this.bCancel.addActionListener(onClick);
/*  43 */     this.bPane = new JPanel(new FlowLayout(2));
/*  44 */     this.bPane.add(this.bOK);
/*  45 */     this.bPane.add(this.bCancel);
/*     */     
/*  47 */     pane.add(this.bPane, "South");
/*  48 */     tryToCreateEditorPanel(false);
/*  49 */     pack();
/*     */   }
/*     */   
/*     */   private PropertyEditorSupport getClonedEditor(PropertyEditorSupport editor) {
/*  53 */     PropertyEditorSupport newInst = null;
/*     */     try {
/*  55 */       newInst = (PropertyEditorSupport)editor.getClass().newInstance();
/*     */     } catch (InstantiationException ex) {
/*  57 */       ex.printStackTrace();
/*     */     } catch (IllegalAccessException ex) {
/*  59 */       ex.printStackTrace();
/*     */     }
/*  61 */     newInst.setValue(editor.getValue());
/*  62 */     return newInst;
/*     */   }
/*     */   
/*     */   private void tryToCreateEditorPanel(boolean forceCreation) {
/*  66 */     if ((getEditor().getValue() == null) && (!forceCreation)) {
/*  67 */       return;
/*     */     }
/*  69 */     getContentPane().add(getEditor().getCustomEditor(), "Center");
/*     */   }
/*     */   
/*     */   private class OnClick implements ActionListener { private OnClick() {}
/*     */     
/*  74 */     public void actionPerformed(ActionEvent e) { if (e.getSource() == EditorDialog.this.bCancel) {
/*  75 */         EditorDialog.this.setValue(null);
/*  76 */         EditorDialog.this.setEditorToDefault();
/*  77 */         EditorDialog.this.setCanceled(true);
/*     */       }
/*  79 */       if (e.getSource() == EditorDialog.this.bOK) {
/*  80 */         EditorDialog.this.setValue(EditorDialog.this.getEditor().getValue());
/*  81 */         EditorDialog.this.setCanceled(false);
/*     */       }
/*  83 */       EditorDialog.this.setVisible(false);
/*     */     }
/*     */   }
/*     */   
/*     */   private void setEditorToDefault() {
/*  88 */     getEditor().setValue(getDefaultValue());
/*  89 */     getEditor().firePropertyChange();
/*     */   }
/*     */   
/*     */   public Object getValue() {
/*  93 */     return this.value;
/*     */   }
/*     */   
/*     */   private void setValue(Object value) {
/*  97 */     this.value = value;
/*     */   }
/*     */   
/*     */   public Object showDialog(Object defaultValue, String prompt) {
/* 101 */     setDefaultValue(defaultValue);
/* 102 */     setEditorToDefault();
/* 103 */     tryToCreateEditorPanel(true);
/* 104 */     setTitle(prompt);
/* 105 */     setCanceled(true);
/* 106 */     showCentered();
/* 107 */     return getValue();
/*     */   }
/*     */   
/*     */   private void showCentered() {
/* 111 */     Dimension dim = getContentPane().getPreferredSize();
/* 112 */     setSize(dim.width + 100, dim.height + 80);
/* 113 */     Toolkit kit = Toolkit.getDefaultToolkit();
/* 114 */     Dimension screenSize = kit.getScreenSize();
/* 115 */     if ((dim.width > screenSize.width) || (dim.height > screenSize.height)) {
/* 116 */       setLocation(0, 0);
/*     */     } else {
/* 118 */       setLocation((screenSize.width - dim.width) / 2, (screenSize.height - dim.height) / 2);
/*     */     }
/*     */     
/*     */ 
/* 122 */     setVisible(true);
/*     */   }
/*     */   
/*     */   public PropertyEditorSupport getEditor() {
/* 126 */     return this.propertyEditor;
/*     */   }
/*     */   
/*     */   public boolean isCanceled() {
/* 130 */     return this.canceled;
/*     */   }
/*     */   
/*     */   public void setCanceled(boolean canceled) {
/* 134 */     this.canceled = canceled;
/*     */   }
/*     */   
/*     */   public Object getDefaultValue() {
/* 138 */     return this.defaultValue;
/*     */   }
/*     */   
/*     */   public void setDefaultValue(Object defaultValue) {
/* 142 */     this.defaultValue = defaultValue;
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/utils/EditorDialog.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */