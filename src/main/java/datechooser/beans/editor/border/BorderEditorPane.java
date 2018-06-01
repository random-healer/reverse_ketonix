/*     */ package datechooser.beans.editor.border;
/*     */ 
/*     */ import datechooser.beans.editor.border.types.AbstractBorderEditor;
/*     */ import datechooser.beans.editor.border.types.BevelBorderEditor;
/*     */ import datechooser.beans.editor.border.types.CompoundBorderEditor;
/*     */ import datechooser.beans.editor.border.types.EtchedBorderEditor;
/*     */ import datechooser.beans.editor.border.types.MatteBorderEditor;
/*     */ import datechooser.beans.editor.border.types.SoftBevelBorderEditor;
/*     */ import datechooser.beans.editor.border.types.TitledBorderEditor;
/*     */ import datechooser.beans.editor.utils.TextOutput;
/*     */ import datechooser.beans.locale.LocaleUtils;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.FlowLayout;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.GridLayout;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.beans.PropertyChangeEvent;
/*     */ import java.beans.PropertyChangeListener;
/*     */ import javax.swing.AbstractListModel;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JList;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.ListCellRenderer;
/*     */ import javax.swing.border.Border;
/*     */ import javax.swing.event.ListSelectionEvent;
/*     */ import javax.swing.event.ListSelectionListener;
/*     */ 
/*     */ public class BorderEditorPane extends JPanel implements PropertyChangeListener
/*     */ {
/*     */   private static final int NO_BORDER_EDITOR = 0;
/*  35 */   private static String EMPTY = "";
/*     */   
/*     */   private BorderPreviewPane preview;
/*     */   
/*     */   private JPanel control;
/*     */   private SimpleBorderEditor editor;
/*     */   private JList selType;
/*     */   private JLabel typeName;
/*  43 */   private AbstractBorderEditor[] typesEditors = null;
/*     */   private int current;
/*     */   
/*     */   public BorderEditorPane(SimpleBorderEditor editor)
/*     */   {
/*  48 */     setEditor(editor);
/*     */     
/*  50 */     this.typeName = new JLabel();
/*  51 */     JPanel top = new JPanel(new BorderLayout());
/*  52 */     JPanel content = new JPanel(new GridLayout(2, 1, 1, 10));
/*  53 */     setLayout(new BorderLayout());
/*  54 */     this.control = new JPanel(new BorderLayout());
/*  55 */     top.add(this.control, "Center");
/*  56 */     top.add(this.typeName, "South");
/*  57 */     this.preview = new BorderPreviewPane(null);
/*  58 */     this.preview.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5), BorderFactory.createEtchedBorder()));
/*     */     
/*     */ 
/*     */ 
/*  62 */     JButton reset = new JButton(LocaleUtils.getEditorLocaleString("Reset"));
/*  63 */     JPanel resetPane = new JPanel(new FlowLayout(0));
/*  64 */     resetPane.add(reset);
/*  65 */     reset.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/*  67 */         BorderEditorPane.this.getCurrentEditor().reset();
/*  68 */         BorderEditorPane.this.refreshPreview();
/*     */       }
/*     */       
/*  71 */     });
/*  72 */     initEditors();
/*     */     
/*  74 */     content.add(top);
/*  75 */     content.add(this.preview);
/*  76 */     add(content, "Center");
/*  77 */     add(new javax.swing.JScrollPane(this.selType), "East");
/*  78 */     add(resetPane, "North");
/*     */     
/*  80 */     revalidate();
/*     */   }
/*     */   
/*     */   private void initEditors() {
/*  84 */     this.typesEditors = new AbstractBorderEditor[] { new datechooser.beans.editor.border.types.NoBorderEditor(), new BevelBorderEditor(), new CompoundBorderEditor(), new datechooser.beans.editor.border.types.EmptyBorderEditor(), new EtchedBorderEditor(), new datechooser.beans.editor.border.types.LineBorderEditor(), new MatteBorderEditor(), new SoftBevelBorderEditor(), new TitledBorderEditor() };
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
/*  95 */     setCurrentEditor();
/*  96 */     if (getEditor().getValue() != null) {
/*  97 */       getCurrentEditor().setCurrentBorder((Border)getEditor().getValue());
/*     */     }
/*     */     
/* 100 */     OnBorderChange onSelect = new OnBorderChange(null);
/* 101 */     for (AbstractBorderEditor visualEditor : this.typesEditors) {
/* 102 */       visualEditor.addPropertyChangeListener(onSelect);
/*     */     }
/*     */     
/* 105 */     this.selType = new JList(new EditorsListModel());
/* 106 */     this.selType.setCellRenderer(new TypesListRenderer(null));
/* 107 */     this.selType.setSelectedIndex(this.current);
/* 108 */     this.selType.setVisibleRowCount(this.typesEditors.length + 1);
/* 109 */     this.selType.setOpaque(false);
/* 110 */     this.selType.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
/* 111 */     updateCaption();
/* 112 */     this.selType.addListSelectionListener(new ListSelectionListener() {
/*     */       public void valueChanged(ListSelectionEvent e) {
/* 114 */         BorderEditorPane.this.refreshEditor();
/*     */       }
/*     */       
/* 117 */     });
/* 118 */     refreshPreview();
/*     */   }
/*     */   
/*     */   private void refreshEditor() {
/* 122 */     setCurrentEditor(this.selType.getSelectedIndex());
/* 123 */     updateCaption();
/* 124 */     updateProperty();
/* 125 */     refreshPreview();
/*     */   }
/*     */   
/*     */   private AbstractBorderEditor getDefaultEditor() {
/* 129 */     return this.typesEditors[0];
/*     */   }
/*     */   
/*     */   private void updateCaption() {
/* 133 */     this.typeName.setText(" " + getCurrentEditor().getCaption());
/*     */   }
/*     */   
/*     */   private void updateProperty() {
/* 137 */     getEditor().setValue(getSelectedBorder());
/*     */   }
/*     */   
/*     */   private void refreshPreview() {
/* 141 */     this.preview.setSelectedBorder((Border)getEditor().getValue());
/* 142 */     this.preview.repaint();
/*     */   }
/*     */   
/*     */   private void showCurrentEditor() {
/* 146 */     this.control.removeAll();
/* 147 */     this.control.add(getCurrentEditor(), "Center");
/* 148 */     this.control.revalidate();
/* 149 */     this.control.repaint();
/*     */   }
/*     */   
/*     */   private Border getSelectedBorder() {
/* 153 */     return getCurrentEditor().getSelectedBorder();
/*     */   }
/*     */   
/*     */   private AbstractBorderEditor getCurrentEditor() {
/* 157 */     return this.typesEditors[this.current];
/*     */   }
/*     */   
/*     */   private int getCurrentEditorIndex() {
/* 161 */     if (this.editor.getValue() == null) {
/* 162 */       return 0;
/*     */     }
/* 164 */     for (int i = 1; i < this.typesEditors.length; i++) {
/* 165 */       if (this.typesEditors[i].getSelectedBorder() != null)
/*     */       {
/*     */ 
/* 168 */         Class curr = this.typesEditors[i].getSelectedBorder().getClass();
/* 169 */         if ((curr != null) && 
/* 170 */           (curr.equals(this.editor.getValue().getClass()))) {
/* 171 */           return i;
/*     */         }
/*     */       }
/*     */     }
/* 175 */     return 0;
/*     */   }
/*     */   
/*     */   private void setCurrentEditor() {
/* 179 */     setCurrentEditor(getCurrentEditorIndex());
/*     */   }
/*     */   
/*     */   private void setCurrentEditor(int index) {
/* 183 */     if (this.typesEditors == null) return;
/* 184 */     if ((index < 0) || (index >= this.typesEditors.length)) {
/* 185 */       this.current = 0;
/*     */     } else {
/* 187 */       this.current = index;
/*     */     }
/* 189 */     if (this.selType != null) this.selType.setSelectedIndex(this.current);
/* 190 */     showCurrentEditor();
/*     */   }
/*     */   
/*     */   class EditorsListModel extends AbstractListModel { EditorsListModel() {}
/*     */     
/* 195 */     public int getSize() { return BorderEditorPane.this.typesEditors.length; }
/*     */     
/*     */     public Object getElementAt(int index)
/*     */     {
/* 199 */       return BorderEditorPane.this.typesEditors[index];
/*     */     }
/*     */   }
/*     */   
/*     */   public SimpleBorderEditor getEditor()
/*     */   {
/* 205 */     return this.editor;
/*     */   }
/*     */   
/*     */   public void setEditor(SimpleBorderEditor editor) {
/* 209 */     if (getEditor() != null) {
/* 210 */       getEditor().removePropertyChangeListener(this);
/*     */     }
/* 212 */     this.editor = editor;
/* 213 */     getEditor().addPropertyChangeListener(this);
/*     */   }
/*     */   
/*     */   public void propertyChange(PropertyChangeEvent evt)
/*     */   {
/* 218 */     setCurrentEditor(getCurrentEditorIndex());
/* 219 */     getCurrentEditor().setCurrentBorder((Border)this.editor.getValue());
/* 220 */     refreshPreview();
/*     */   }
/*     */   
/*     */   private AbstractBorderEditor getTypeEditor(int index) {
/* 224 */     if ((index < 0) || (index >= this.typesEditors.length)) {
/* 225 */       return getDefaultEditor();
/*     */     }
/* 227 */     return this.typesEditors[index]; }
/*     */   
/*     */   private class BorderPreviewPane extends JPanel { private BorderPreviewPane() {}
/*     */     
/* 231 */     private Border selectedBorder = null;
/*     */     
/*     */     public Border getSelectedBorder() {
/* 234 */       return this.selectedBorder;
/*     */     }
/*     */     
/*     */     public void setSelectedBorder(Border selectedBorder) {
/* 238 */       this.selectedBorder = selectedBorder;
/*     */     }
/*     */     
/*     */     protected void paintComponent(Graphics g)
/*     */     {
/* 243 */       super.paintComponent(g);
/* 244 */       if (getSelectedBorder() == null) return;
/* 245 */       Rectangle rec = getBounds();
/* 246 */       if (getSelectedBorder().getClass().equals(javax.swing.border.EmptyBorder.class)) {
/* 247 */         TextOutput.paintBoxed(g, rec, LocaleUtils.getEditorLocaleString("Invisible"));
/*     */       } else {
/* 249 */         getSelectedBorder().paintBorder(this, g, rec.width / 4, rec.height / 4, rec.width / 2, rec.height / 2);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private class OnBorderChange implements PropertyChangeListener
/*     */   {
/*     */     private OnBorderChange() {}
/*     */     
/*     */     public void propertyChange(PropertyChangeEvent evt)
/*     */     {
/* 260 */       if (!"border".equals(evt.getPropertyName())) return;
/* 261 */       BorderEditorPane.this.updateProperty();
/* 262 */       BorderEditorPane.this.refreshPreview();
/*     */     }
/*     */   }
/*     */   
/*     */   private class TypesListRenderer implements ListCellRenderer {
/*     */     private TypesListRenderer() {}
/*     */     
/* 269 */     public java.awt.Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) { JLabel label = BorderEditorPane.this.getTypeEditor(index).getPreviewLabel();
/*     */       
/*     */ 
/* 272 */       label.setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());
/*     */       
/* 274 */       JPanel content = new JPanel(new GridLayout(1, 1));
/* 275 */       content.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
/* 276 */       content.setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
/*     */       
/* 278 */       content.add(label);
/*     */       
/* 280 */       return content;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/border/BorderEditorPane.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */