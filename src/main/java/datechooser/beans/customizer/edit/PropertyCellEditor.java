/*     */ package datechooser.beans.customizer.edit;
/*     */ 
/*     */ import datechooser.beans.customizer.PropertyDescriptorsHolder;
/*     */ import datechooser.beans.editor.utils.EditorDialog;
/*     */ import java.awt.Component;
/*     */ import java.awt.Insets;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.beans.PropertyChangeEvent;
/*     */ import java.beans.PropertyDescriptor;
/*     */ import java.beans.PropertyEditorSupport;
/*     */ import java.util.EventObject;
/*     */ import javax.swing.AbstractCellEditor;
/*     */ import javax.swing.AbstractListModel;
/*     */ import javax.swing.ComboBoxModel;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.event.DocumentEvent;
/*     */ import javax.swing.table.TableCellEditor;
/*     */ import javax.swing.text.Document;
/*     */ 
/*     */ public class PropertyCellEditor extends AbstractCellEditor implements TableCellEditor
/*     */ {
/*     */   private PropertyDescriptorsHolder holder;
/*     */   private String property;
/*     */   private PropertyDescriptor descriptor;
/*     */   private PropertyEditorSupport editor;
/*     */   private boolean needsCustomEditor;
/*     */   private JTextField textEditor;
/*     */   private JCheckBox boolEditor;
/*     */   private JComboBox comboEditor;
/*     */   private EditorDialog customEditor;
/*     */   private JPanel editPanel;
/*     */   private JButton customEditorButton;
/*     */   private JComponent cellEditorCashed;
/*     */   private TagsModel tagsModel;
/*     */   
/*     */   public PropertyCellEditor(PropertyDescriptorsHolder holder)
/*     */   {
/*  46 */     this.holder = holder;
/*  47 */     this.tagsModel = new TagsModel(null);
/*  48 */     this.comboEditor = new JComboBox(this.tagsModel);
/*  49 */     this.boolEditor = new JCheckBox();
/*  50 */     this.boolEditor.addActionListener(new OnBoolChanged(null));
/*  51 */     this.textEditor = new JTextField();
/*  52 */     this.textEditor.setBorder(null);
/*  53 */     this.textEditor.getDocument().addDocumentListener(new OnTextChange(null));
/*  54 */     this.editPanel = new JPanel(new java.awt.BorderLayout());
/*  55 */     this.customEditorButton = createCustomEditorButton();
/*  56 */     this.editPanel.add(this.customEditorButton, "East");
/*  57 */     this.cellEditorCashed = null;
/*     */     
/*  59 */     UIManager.addPropertyChangeListener(new OnUIChange(null));
/*     */   }
/*     */   
/*     */   private JButton createCustomEditorButton() {
/*  63 */     JButton customEditorButton = new JButton("...");
/*  64 */     customEditorButton.setMargin(new Insets(2, 2, 2, 2));
/*  65 */     customEditorButton.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/*  67 */         PropertyCellEditor.this.setNeedsCustomEditor(false);
/*  68 */         PropertyCellEditor.this.customEditor = new EditorDialog(null, PropertyCellEditor.this.getEditor());
/*  69 */         Object newVal = PropertyCellEditor.this.customEditor.showDialog(PropertyCellEditor.this.getEditor().getValue(), PropertyCellEditor.this.getDescriptor().getDisplayName());
/*  70 */         if (!PropertyCellEditor.this.customEditor.isCanceled()) {
/*  71 */           PropertyCellEditor.this.getEditor().setValue(newVal);
/*  72 */           PropertyCellEditor.this.stopCellEditing();
/*     */         }
/*     */       }
/*  75 */     });
/*  76 */     return customEditorButton;
/*     */   }
/*     */   
/*     */   public Object getCellEditorValue() {
/*  80 */     return this.property;
/*     */   }
/*     */   
/*     */   public boolean shouldSelectCell(EventObject anEvent) {
/*  84 */     if (isNeedsCustomEditor()) {
/*  85 */       this.customEditor = new EditorDialog(null, getEditor());
/*  86 */       Object newVal = this.customEditor.showDialog(getEditor().getValue(), getDescriptor().getDisplayName());
/*  87 */       if (this.customEditor.isCanceled()) {
/*  88 */         cancelCellEditing();
/*     */       } else {
/*  90 */         getEditor().setValue(newVal);
/*     */         
/*  92 */         stopCellEditing();
/*     */       }
/*     */     }
/*  95 */     return true;
/*     */   }
/*     */   
/*     */   public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
/*  99 */     this.property = ((String)value);
/* 100 */     setDescriptor(this.holder.getPropertydescriptor(this.property));
/* 101 */     setEditor(this.holder.getPropertyEditor(this.property));
/* 102 */     setNeedsCustomEditor(false);
/* 103 */     JComponent cellEditor = null;
/* 104 */     if (getEditor().getTags() != null) {
/* 105 */       this.tagsModel.fireDataChanged();
/* 106 */       cellEditor = this.comboEditor;
/* 107 */     } else if (PropertyDescriptorsHolder.isBooleanDescriptor(getDescriptor())) {
/* 108 */       this.boolEditor.setSelected(((Boolean)getEditor().getValue()).booleanValue());
/* 109 */       cellEditor = this.boolEditor;
/* 110 */     } else if (PropertyDescriptorsHolder.isStringDescriptor(getDescriptor())) {
/* 111 */       this.textEditor.setText((String)getEditor().getValue());
/* 112 */       cellEditor = this.textEditor;
/* 113 */     } else if (getEditor().getCustomEditor() != null) {
/* 114 */       setNeedsCustomEditor(true);
/* 115 */       return table.getCellRenderer(row, column).getTableCellRendererComponent(table, value, isSelected, true, row, column);
/*     */     }
/*     */     
/*     */ 
/* 119 */     if ((getEditor().getCustomEditor() != null) && (cellEditor != null)) {
/* 120 */       if (this.cellEditorCashed != null) {
/* 121 */         this.editPanel.remove(this.cellEditorCashed);
/*     */       }
/* 123 */       this.editPanel.add(cellEditor, "Center");
/* 124 */       this.cellEditorCashed = cellEditor;
/* 125 */       this.editPanel.revalidate();
/* 126 */       return this.editPanel;
/*     */     }
/*     */     
/* 129 */     return cellEditor;
/*     */   }
/*     */   
/*     */   public PropertyDescriptor getDescriptor() {
/* 133 */     return this.descriptor;
/*     */   }
/*     */   
/*     */   public void setDescriptor(PropertyDescriptor descriptor) {
/* 137 */     this.descriptor = descriptor;
/*     */   }
/*     */   
/*     */   public PropertyEditorSupport getEditor() {
/* 141 */     return this.editor;
/*     */   }
/*     */   
/*     */ 
/* 145 */   public void setEditor(PropertyEditorSupport editor) { this.editor = editor; }
/*     */   
/*     */   private class OnBoolChanged implements ActionListener {
/*     */     private OnBoolChanged() {}
/*     */     
/* 150 */     public void actionPerformed(ActionEvent e) { if (PropertyCellEditor.this.getEditor() == null) return;
/* 151 */       PropertyCellEditor.this.getEditor().setValue(Boolean.valueOf(PropertyCellEditor.this.boolEditor.isSelected()));
/*     */     }
/*     */   }
/*     */   
/*     */   private class OnTextChange extends TextChangeListener { private OnTextChange() {}
/*     */     
/* 157 */     public void textChanged(DocumentEvent e) { if (PropertyCellEditor.this.getEditor() == null) return;
/* 158 */       PropertyCellEditor.this.getEditor().setValue(PropertyCellEditor.this.textEditor.getText());
/*     */     }
/*     */   }
/*     */   
/*     */   private class TagsModel extends AbstractListModel implements ComboBoxModel {
/*     */     private TagsModel() {}
/*     */     
/* 165 */     public int getSize() { if ((PropertyCellEditor.this.getEditor() == null) || (PropertyCellEditor.this.getEditor().getTags() == null)) return 0;
/* 166 */       return PropertyCellEditor.this.getEditor().getTags().length;
/*     */     }
/*     */     
/*     */     public Object getElementAt(int index) {
/* 170 */       return PropertyCellEditor.this.getEditor().getTags()[index];
/*     */     }
/*     */     
/*     */     public void setSelectedItem(Object anItem) {
/* 174 */       PropertyCellEditor.this.getEditor().setAsText((String)anItem);
/*     */     }
/*     */     
/*     */     public Object getSelectedItem() {
/* 178 */       if (PropertyCellEditor.this.getEditor() == null) return null;
/* 179 */       return PropertyCellEditor.this.getEditor().getAsText();
/*     */     }
/*     */     
/*     */     public void fireDataChanged() {
/* 183 */       fireContentsChanged(this, 0, getSize() - 1);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isNeedsCustomEditor()
/*     */   {
/* 189 */     return this.needsCustomEditor;
/*     */   }
/*     */   
/*     */ 
/* 193 */   public void setNeedsCustomEditor(boolean needsCustomEditor) { this.needsCustomEditor = needsCustomEditor; }
/*     */   
/*     */   private class OnUIChange implements java.beans.PropertyChangeListener {
/*     */     private OnUIChange() {}
/*     */     
/* 198 */     public void propertyChange(PropertyChangeEvent evt) { PropertyCellEditor.this.textEditor.updateUI();
/* 199 */       PropertyCellEditor.this.boolEditor.updateUI();
/* 200 */       PropertyCellEditor.this.comboEditor.updateUI();
/* 201 */       javax.swing.SwingUtilities.updateComponentTreeUI(PropertyCellEditor.this.editPanel);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/customizer/edit/PropertyCellEditor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */