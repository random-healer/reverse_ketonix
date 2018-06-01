/*     */ package datechooser.beans.editor.border.types;
/*     */ 
/*     */ import datechooser.beans.editor.border.SimpleBorderEditor;
/*     */ import datechooser.beans.editor.font.SimpleFontEditor;
/*     */ import datechooser.beans.editor.utils.ColorChooseAction;
/*     */ import datechooser.beans.editor.utils.ColorHolder;
/*     */ import datechooser.beans.editor.utils.EditorDialog;
/*     */ import datechooser.beans.editor.utils.NamedInt;
/*     */ import datechooser.beans.locale.LocaleUtils;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.Frame;
/*     */ import java.awt.GridLayout;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.beans.PropertyChangeEvent;
/*     */ import java.beans.PropertyChangeListener;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.border.Border;
/*     */ import javax.swing.border.TitledBorder;
/*     */ import javax.swing.event.DocumentEvent;
/*     */ import javax.swing.text.Document;
/*     */ 
/*     */ public class TitledBorderEditor extends AbstractBorderEditor implements PropertyChangeListener
/*     */ {
/*  31 */   private static String SAMPLE_TEXT = LocaleUtils.getEditorLocaleString("sample");
/*     */   
/*     */   private String title;
/*     */   private int titleJustification;
/*     */   private int titlePosition;
/*     */   private Font titleFont;
/*     */   private ColorHolder titleColor;
/*     */   private Border titledBorder;
/*  39 */   private Dimension comboDim = new Dimension(100, 20);
/*     */   
/*     */   private JComboBox comboPos;
/*     */   private JComboBox comboJust;
/*     */   private EditorDialog borderEditorDialog;
/*     */   private EditorDialog fontEditorDialog;
/*     */   
/*     */   public TitledBorderEditor()
/*     */   {
/*  48 */     initialize();
/*     */     
/*  50 */     this.titleColor = new ColorHolder();
/*  51 */     this.borderEditorDialog = new EditorDialog((Frame)getParent(), new SimpleBorderEditor());
/*  52 */     this.fontEditorDialog = new EditorDialog((Frame)getParent(), new SimpleFontEditor());
/*  53 */     setCaption(LocaleUtils.getEditorLocaleString("Titled"));
/*  54 */     assignValueToParameters();
/*     */     
/*  56 */     setLayout(new BorderLayout());
/*  57 */     JPanel pControls = new JPanel(new GridLayout(3, 1));
/*  58 */     pControls.add(createCaptionField());
/*  59 */     JPanel buttons = getCenteredPane(null);
/*  60 */     buttons.add(createFontChooseButton());
/*  61 */     buttons.add(createBorderChooseButton());
/*  62 */     buttons.add(createColorChooseButton());
/*  63 */     pControls.add(buttons);
/*  64 */     JPanel selectors = getCenteredPane(null);
/*  65 */     selectors.add(createTitlePositionSelector());
/*  66 */     selectors.add(createTitleJustifySelector());
/*  67 */     pControls.add(selectors);
/*  68 */     add(pControls, "North");
/*     */     
/*  70 */     refreshInterface();
/*     */   }
/*     */   
/*     */   private void setText(String text) {
/*  74 */     this.title = text;
/*  75 */     fireChange();
/*     */   }
/*     */   
/*     */   private JPanel createCaptionField() {
/*  79 */     final JTextField field = new JTextField(15);
/*  80 */     field.setText(SAMPLE_TEXT);
/*  81 */     field.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
/*     */       public void changedUpdate(DocumentEvent e) {
/*  83 */         TitledBorderEditor.this.setText(field.getText());
/*     */       }
/*     */       
/*  86 */       public void insertUpdate(DocumentEvent e) { TitledBorderEditor.this.setText(field.getText()); }
/*     */       
/*     */       public void removeUpdate(DocumentEvent e) {
/*  89 */         TitledBorderEditor.this.setText(field.getText());
/*     */       }
/*  91 */     });
/*  92 */     return getCenteredPane(field);
/*     */   }
/*     */   
/*     */   private JPanel createBorderChooseButton() {
/*  96 */     JButton bBorder = new JButton(LocaleUtils.getEditorLocaleString("Border"));
/*  97 */     bBorder.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/*  99 */         Border newBorder = (Border)TitledBorderEditor.this.borderEditorDialog.showDialog(TitledBorderEditor.this.titledBorder, LocaleUtils.getEditorLocaleString("Select_border"));
/*     */         
/* 101 */         if (!TitledBorderEditor.this.borderEditorDialog.isCanceled()) {
/* 102 */           TitledBorderEditor.this.titledBorder = newBorder;
/* 103 */           TitledBorderEditor.this.fireChange();
/*     */         }
/*     */       }
/* 106 */     });
/* 107 */     return getCenteredPane(bBorder);
/*     */   }
/*     */   
/*     */   private JPanel createColorChooseButton() {
/* 111 */     JButton bColor = new JButton(LocaleUtils.getEditorLocaleString("Color"));
/* 112 */     ColorChooseAction colorChooseAction = new ColorChooseAction(this.titleColor, LocaleUtils.getEditorLocaleString("Title_color"), this);
/*     */     
/* 114 */     colorChooseAction.addPropertyChangeListener(this);
/* 115 */     bColor.addActionListener(colorChooseAction);
/* 116 */     return getCenteredPane(bColor);
/*     */   }
/*     */   
/*     */   private JPanel createTitleJustifySelector() {
/* 120 */     NamedInt[] data = { new NamedInt(LocaleUtils.getEditorLocaleString("left"), 1), new NamedInt(LocaleUtils.getEditorLocaleString("center"), 2), new NamedInt(LocaleUtils.getEditorLocaleString("right"), 3), new NamedInt(LocaleUtils.getEditorLocaleString("leading"), 4), new NamedInt(LocaleUtils.getEditorLocaleString("trailing"), 5) };
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 126 */     this.comboJust = new JComboBox(data);
/* 127 */     this.comboJust.setPreferredSize(this.comboDim);
/* 128 */     setSelectedInt(this.comboJust, this.titleJustification);
/* 129 */     this.comboJust.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 131 */         TitledBorderEditor.this.titleJustification = ((NamedInt)TitledBorderEditor.this.comboJust.getSelectedItem()).getValue();
/* 132 */         TitledBorderEditor.this.fireChange();
/*     */       }
/* 134 */     });
/* 135 */     return getCenteredPane(this.comboJust);
/*     */   }
/*     */   
/*     */   private JPanel createTitlePositionSelector() {
/* 139 */     NamedInt[] data = { new NamedInt(LocaleUtils.getEditorLocaleString("above_top"), 1), new NamedInt(LocaleUtils.getEditorLocaleString("top"), 2), new NamedInt(LocaleUtils.getEditorLocaleString("below_top"), 3), new NamedInt(LocaleUtils.getEditorLocaleString("above_bottom"), 4), new NamedInt(LocaleUtils.getEditorLocaleString("bottom"), 5), new NamedInt(LocaleUtils.getEditorLocaleString("below_bottom"), 6) };
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 146 */     this.comboPos = new JComboBox(data);
/* 147 */     setSelectedInt(this.comboPos, this.titlePosition);
/* 148 */     this.comboPos.setPreferredSize(this.comboDim);
/* 149 */     this.comboPos.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 151 */         TitledBorderEditor.this.titlePosition = ((NamedInt)TitledBorderEditor.this.comboPos.getSelectedItem()).getValue();
/* 152 */         TitledBorderEditor.this.fireChange();
/*     */       }
/* 154 */     });
/* 155 */     return getCenteredPane(this.comboPos);
/*     */   }
/*     */   
/*     */   private void setSelectedInt(JComboBox combo, int intValue) {
/* 159 */     int items = combo.getItemCount();
/* 160 */     for (int i = 0; i < items; i++) {
/* 161 */       if (((NamedInt)combo.getItemAt(i)).getValue() == intValue) {
/* 162 */         combo.setSelectedIndex(i);
/* 163 */         break;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private JPanel createFontChooseButton() {
/* 169 */     JButton bFont = new JButton(LocaleUtils.getEditorLocaleString("Font"));
/* 170 */     bFont.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 172 */         Font newFont = (Font)TitledBorderEditor.this.fontEditorDialog.showDialog(TitledBorderEditor.this.titleFont, LocaleUtils.getEditorLocaleString("Select_font"));
/*     */         
/* 174 */         if (!TitledBorderEditor.this.fontEditorDialog.isCanceled()) {
/* 175 */           TitledBorderEditor.this.titleFont = newFont;
/* 176 */           TitledBorderEditor.this.fireChange();
/*     */         }
/*     */       }
/* 179 */     });
/* 180 */     return getCenteredPane(bFont);
/*     */   }
/*     */   
/*     */   protected void prepareSelection() {
/* 184 */     setValue(new TitledBorder(this.titledBorder, this.title, this.titleJustification, this.titlePosition, this.titleFont, this.titleColor.getColor()));
/*     */   }
/*     */   
/*     */   private void assignValueToParameters() {
/* 188 */     this.titledBorder = getValue().getBorder();
/* 189 */     this.title = getValue().getTitle();
/* 190 */     this.titleJustification = getValue().getTitleJustification();
/* 191 */     this.titlePosition = getValue().getTitlePosition();
/* 192 */     this.titleFont = getValue().getTitleFont();
/* 193 */     this.titleColor.setColor(getValue().getTitleColor());
/*     */   }
/*     */   
/*     */   protected TitledBorder getValue() {
/* 197 */     return (TitledBorder)this.value;
/*     */   }
/*     */   
/*     */   public void refreshInterface() {
/* 201 */     assignValueToParameters();
/* 202 */     setSelectedInt(this.comboPos, this.titlePosition);
/* 203 */     setSelectedInt(this.comboJust, this.titleJustification);
/*     */   }
/*     */   
/*     */   protected Border getDefaultValue() {
/* 207 */     return new TitledBorder(BorderFactory.createEtchedBorder(), SAMPLE_TEXT);
/*     */   }
/*     */   
/*     */   public void propertyChange(PropertyChangeEvent evt) {
/* 211 */     if (!"color".equals(evt.getPropertyName())) return;
/* 212 */     fireChange();
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/border/types/TitledBorderEditor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */