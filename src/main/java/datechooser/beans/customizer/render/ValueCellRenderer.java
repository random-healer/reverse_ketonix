/*     */ package datechooser.beans.customizer.render;
/*     */ 
/*     */ import datechooser.beans.customizer.PropertyDescriptorsHolder;
/*     */ import java.awt.Component;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Insets;
/*     */ import java.awt.Rectangle;
/*     */ import java.beans.PropertyChangeEvent;
/*     */ import java.beans.PropertyDescriptor;
/*     */ import java.beans.PropertyEditor;
/*     */ import java.beans.PropertyEditorSupport;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.SwingUtilities;
/*     */ import javax.swing.UIManager;
/*     */ 
/*     */ public class ValueCellRenderer extends CellRenderer
/*     */ {
/*     */   private RenderPane paneRenderer;
/*     */   private JLabel labelRenderer;
/*     */   private JCheckBox checkRenderer;
/*     */   private JComboBox comboRenderer;
/*     */   private JButton editorButton;
/*     */   private JPanel editorPane;
/*  29 */   private Component rendererCash = null;
/*     */   
/*     */   public ValueCellRenderer(PropertyDescriptorsHolder holder) {
/*  32 */     super(holder);
/*  33 */     this.paneRenderer = new RenderPane(null);
/*  34 */     this.labelRenderer = new JLabel();
/*  35 */     this.labelRenderer.setOpaque(true);
/*  36 */     this.labelRenderer.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
/*  37 */     this.checkRenderer = new JCheckBox();
/*  38 */     this.comboRenderer = new JComboBox();
/*  39 */     this.comboRenderer.setBorder(null);
/*  40 */     this.editorButton = new JButton("...");
/*  41 */     this.editorButton.setMargin(new Insets(2, 2, 2, 2));
/*  42 */     this.editorPane = new JPanel(new java.awt.BorderLayout());
/*  43 */     this.editorPane.add(this.editorButton, "East");
/*     */     
/*  45 */     UIManager.addPropertyChangeListener(new OnUIChange(null));
/*     */   }
/*     */   
/*     */   protected Component getRenderer(PropertyDescriptor propertyDescriptor, PropertyEditorSupport propertyEditorSupport, JTable table, boolean isSelected, boolean hasFocus) {
/*  49 */     Component renderer = null;
/*  50 */     if (PropertyDescriptorsHolder.isBooleanDescriptor(propertyDescriptor)) {
/*  51 */       this.checkRenderer.setSelected(((Boolean)propertyEditorSupport.getValue()).booleanValue());
/*  52 */       renderer = this.checkRenderer;
/*  53 */     } else if (propertyEditorSupport.getTags() != null) {
/*  54 */       this.comboRenderer.removeAllItems();
/*  55 */       this.comboRenderer.addItem(propertyEditorSupport.getAsText());
/*  56 */       renderer = this.comboRenderer;
/*  57 */     } else if (propertyEditorSupport.isPaintable()) {
/*  58 */       this.paneRenderer.setEditor(propertyEditorSupport);
/*  59 */       renderer = this.paneRenderer;
/*     */     } else {
/*  61 */       String text = propertyEditorSupport.getAsText();
/*  62 */       this.labelRenderer.setFont(table.getFont());
/*  63 */       this.labelRenderer.setText(text);
/*  64 */       renderer = this.labelRenderer;
/*     */     }
/*  66 */     renderer.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
/*  67 */     renderer.setForeground(isSelected ? table.getSelectionForeground() : table.getForeground());
/*     */     
/*  69 */     if (propertyEditorSupport.supportsCustomEditor()) {
/*  70 */       if (this.rendererCash != null) {
/*  71 */         this.editorPane.remove(this.rendererCash);
/*     */       }
/*  73 */       this.editorPane.add(renderer, "Center");
/*  74 */       this.rendererCash = renderer;
/*  75 */       this.editorPane.revalidate();
/*  76 */       return this.editorPane;
/*     */     }
/*     */     
/*  79 */     return renderer; }
/*     */   
/*     */   private class RenderPane extends JPanel { private RenderPane() {}
/*     */     
/*  83 */     private PropertyEditor editor = null;
/*     */     
/*     */     public void setEditor(PropertyEditor editor) {
/*  86 */       this.editor = editor;
/*  87 */       setOpaque(true);
/*     */     }
/*     */     
/*     */     protected void paintComponent(Graphics g) {
/*  91 */       super.paintComponent(g);
/*  92 */       if (this.editor == null) return;
/*  93 */       Rectangle bounds = getBounds();
/*  94 */       bounds.setLocation(5, 0);
/*  95 */       this.editor.paintValue(g, bounds);
/*     */     }
/*     */   }
/*     */   
/*     */   private class OnUIChange implements java.beans.PropertyChangeListener { private OnUIChange() {}
/*     */     
/* 101 */     public void propertyChange(PropertyChangeEvent evt) { SwingUtilities.updateComponentTreeUI(ValueCellRenderer.this.editorPane);
/* 102 */       ValueCellRenderer.this.comboRenderer.updateUI();
/* 103 */       ValueCellRenderer.this.labelRenderer.updateUI();
/* 104 */       ValueCellRenderer.this.checkRenderer.updateUI();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/customizer/render/ValueCellRenderer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */