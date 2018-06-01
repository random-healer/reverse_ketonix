/*     */ package datechooser.beans.editor.font;
/*     */ 
/*     */ import datechooser.beans.locale.LocaleUtils;
/*     */ import java.awt.FlowLayout;
/*     */ import java.awt.Font;
/*     */ import java.awt.GraphicsEnvironment;
/*     */ import java.awt.GridLayout;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.DefaultComboBoxModel;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JSpinner;
/*     */ import javax.swing.SpinnerNumberModel;
/*     */ import javax.swing.event.ChangeEvent;
/*     */ import javax.swing.event.ChangeListener;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class FontSelectPane
/*     */   extends JPanel
/*     */ {
/*     */   public static final String FONT_EVENT_NAME = "font";
/*  31 */   public static int MIN_FONT_SIZE = 3;
/*  32 */   public static int MAX_FONT_SIZE = 96;
/*     */   
/*     */   private Font font;
/*     */   
/*     */   private JComboBox selFont;
/*     */   private JCheckBox selStyleBold;
/*     */   private JCheckBox selStyleItalic;
/*     */   private SpinnerNumberModel selSize;
/*     */   private JSpinner selSizeSpinner;
/*     */   
/*     */   public FontSelectPane(Font font)
/*     */   {
/*  44 */     this.selFont = new JComboBox(new DefaultComboBoxModel(getAllFonts()));
/*  45 */     this.selStyleBold = new JCheckBox(LocaleUtils.getEditorLocaleString("Bold"));
/*  46 */     this.selStyleItalic = new JCheckBox(LocaleUtils.getEditorLocaleString("Italic"));
/*  47 */     this.selSize = new SpinnerNumberModel(font.getSize(), MIN_FONT_SIZE, MAX_FONT_SIZE, 1);
/*     */     
/*  49 */     this.selSizeSpinner = new JSpinner(this.selSize);
/*     */     
/*  51 */     setLayout(new FlowLayout(1));
/*  52 */     JPanel style = new JPanel(new GridLayout(1, 2));
/*  53 */     style.add(this.selStyleBold);
/*  54 */     style.add(this.selStyleItalic);
/*  55 */     add(this.selFont);
/*  56 */     add(style);
/*  57 */     add(this.selSizeSpinner);
/*     */     
/*  59 */     OnChange changeHandler = new OnChange();
/*  60 */     this.selFont.addActionListener(changeHandler);
/*  61 */     this.selStyleBold.addActionListener(changeHandler);
/*  62 */     this.selStyleItalic.addActionListener(changeHandler);
/*  63 */     this.selSize.addChangeListener(changeHandler);
/*     */     
/*  65 */     setSelectedFont(font);
/*     */   }
/*     */   
/*     */   public Font getSelectedFont() {
/*  69 */     Font newFont = this.font;
/*  70 */     newFont = new Font((String)this.selFont.getSelectedItem(), getStyle(), this.selSize.getNumber().intValue());
/*     */     
/*  72 */     return newFont;
/*     */   }
/*     */   
/*     */   public void setSelectedFont(Font font) {
/*  76 */     this.font = font;
/*  77 */     this.selFont.setSelectedItem(font.getFamily());
/*  78 */     this.selStyleBold.setSelected(font.isBold());
/*  79 */     this.selStyleItalic.setSelected(font.isItalic());
/*  80 */     this.selSize.setValue(Integer.valueOf(font.getSize()));
/*     */   }
/*     */   
/*     */   private String[] getAllFonts() {
/*  84 */     return GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
/*     */   }
/*     */   
/*     */   private int getStyle()
/*     */   {
/*  89 */     if ((this.selStyleBold.isSelected()) && (this.selStyleItalic.isSelected())) {
/*  90 */       return 3;
/*     */     }
/*  92 */     if (this.selStyleBold.isSelected()) {
/*  93 */       return 1;
/*     */     }
/*  95 */     if (this.selStyleItalic.isSelected()) {
/*  96 */       return 2;
/*     */     }
/*  98 */     return 0;
/*     */   }
/*     */   
/*     */   public void fireChange() {
/* 102 */     firePropertyChange("font", null, null);
/*     */   }
/*     */   
/*     */   class OnChange implements ActionListener, ChangeListener {
/*     */     OnChange() {}
/*     */     
/* 108 */     public void actionPerformed(ActionEvent e) { FontSelectPane.this.fireChange(); }
/*     */     
/*     */     public void stateChanged(ChangeEvent e)
/*     */     {
/* 112 */       FontSelectPane.this.fireChange();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/font/FontSelectPane.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */