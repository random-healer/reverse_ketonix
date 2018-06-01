/*     */ package datechooser.beans.editor.cell;
/*     */ 
/*     */ import datechooser.view.appearance.CellAppearance;
/*     */ import datechooser.view.appearance.custom.CustomCellAppearance;
/*     */ import datechooser.view.appearance.swing.SwingCellAppearance;
/*     */ import java.awt.BorderLayout;
/*     */ import java.beans.PropertyChangeEvent;
/*     */ import java.beans.PropertyChangeListener;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MainCellEditorPane
/*     */   extends JPanel
/*     */   implements PropertyChangeListener
/*     */ {
/*     */   private CellViewEditor editor;
/*     */   private CellPreview preview;
/*     */   private CellAppearance value;
/*     */   private boolean tempEdit;
/*     */   private Map<Class, CellEditorPane> editPanels;
/*     */   private Class currentEditingStyle;
/*     */   
/*     */   public MainCellEditorPane(CellViewEditor editor)
/*     */   {
/*  46 */     setEditor(editor);
/*  47 */     initializeEditors();
/*  48 */     this.preview = new CellPreview(getValue());
/*  49 */     generateClonedValue();
/*  50 */     setCurrentEditingStyle(getEditor().getValue().getClass());
/*  51 */     setLayout(new BorderLayout());
/*  52 */     addCurrentSelector();
/*  53 */     add(this.preview, "Center");
/*     */   }
/*     */   
/*     */   private void addCurrentSelector() {
/*  57 */     add(getSelectors(), "North");
/*     */   }
/*     */   
/*     */   private void initializeEditors() {
/*  61 */     this.editPanels = new HashMap();
/*  62 */     this.editPanels.put(CustomCellAppearance.class, new CustomCellEditorPane(this));
/*  63 */     this.editPanels.put(SwingCellAppearance.class, new SwingCellEditorPane(this));
/*     */   }
/*     */   
/*     */   private CellEditorPane getCurrentEditorPane() {
/*  67 */     return (CellEditorPane)this.editPanels.get(getCurrentEditingStyle());
/*     */   }
/*     */   
/*     */   private void generateClonedValue() {
/*  71 */     if (!isTempEdit()) {
/*  72 */       setTempEdit(true);
/*  73 */       getEditor().setValue(((CellAppearance)getEditor().getValue()).clone());
/*     */       
/*  75 */       getEditor().firePropertyChange();
/*  76 */       this.preview.setLook((CellAppearance)getEditor().getValue());
/*  77 */       setTempEdit(false);
/*     */     }
/*     */   }
/*     */   
/*     */   private JPanel getSelectors()
/*     */   {
/*  83 */     return getCurrentEditorPane();
/*     */   }
/*     */   
/*     */   void fireLocalPropertyChange() {
/*  87 */     getEditor().firePropertyChange();
/*     */   }
/*     */   
/*     */   CellAppearance getValue()
/*     */   {
/*  92 */     return (CellAppearance)getEditor().getValue();
/*     */   }
/*     */   
/*     */   public CellViewEditor getEditor() {
/*  96 */     return this.editor;
/*     */   }
/*     */   
/*     */   public void setEditor(CellViewEditor editor) {
/* 100 */     if ((getEditor() != editor) && (getEditor() != null)) {
/* 101 */       getEditor().removePropertyChangeListener(this);
/*     */     }
/* 103 */     this.editor = editor;
/* 104 */     if (getEditor() != null) {
/* 105 */       getEditor().addPropertyChangeListener(this);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isTempEdit() {
/* 110 */     return this.tempEdit;
/*     */   }
/*     */   
/*     */   public void setTempEdit(boolean tempEdit) {
/* 114 */     this.tempEdit = tempEdit;
/*     */   }
/*     */   
/*     */   private Class getCurrentEditingStyle() {
/* 118 */     return this.currentEditingStyle;
/*     */   }
/*     */   
/*     */   private void setCurrentEditingStyle(Class currentEditingStyle) {
/* 122 */     boolean styleChanged = false;
/* 123 */     if ((currentEditingStyle != getCurrentEditingStyle()) && (getCurrentEditingStyle() != null)) {
/* 124 */       remove(getSelectors());
/* 125 */       styleChanged = true;
/*     */     }
/* 127 */     this.currentEditingStyle = currentEditingStyle;
/* 128 */     if (styleChanged) {
/* 129 */       addCurrentSelector();
/* 130 */       revalidate();
/*     */     }
/*     */   }
/*     */   
/*     */   public void propertyChange(PropertyChangeEvent evt) {
/* 135 */     setCurrentEditingStyle(getEditor().getValue().getClass());
/* 136 */     getCurrentEditorPane().updateState();
/* 137 */     generateClonedValue();
/* 138 */     this.preview.repaint();
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/cell/MainCellEditorPane.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */