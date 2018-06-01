/*     */ package datechooser.beans.editor.cell;
/*     */ 
/*     */ import datechooser.beans.editor.border.SimpleBorderEditor;
/*     */ import datechooser.beans.editor.utils.EditorDialog;
/*     */ import datechooser.beans.locale.LocaleUtils;
/*     */ import datechooser.view.appearance.custom.CustomCellAppearance;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Frame;
/*     */ import java.awt.GridLayout;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JSlider;
/*     */ import javax.swing.border.Border;
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
/*     */ class CustomCellEditorPane
/*     */   extends CellEditorPane
/*     */ {
/*     */   private EditorDialog borderEditorDialog;
/*     */   private boolean innerEdit;
/*     */   private JSlider slider;
/*     */   
/*     */   public CustomCellEditorPane(MainCellEditorPane parentEditor)
/*     */   {
/*  37 */     super(parentEditor);
/*  38 */     setInnerEdit(false);
/*  39 */     this.borderEditorDialog = new EditorDialog((Frame)getParent(), new SimpleBorderEditor());
/*     */   }
/*     */   
/*     */   protected void updateEditorState()
/*     */   {
/*  44 */     if (isInnerEdit()) return;
/*  45 */     if (this.slider == null) return;
/*  46 */     this.slider.setValue((int)(getCustomValue().getTransparency() * 100.0D));
/*     */   }
/*     */   
/*     */   protected void generateInterface() {
/*  50 */     setLayout(new BorderLayout(2, 2));
/*  51 */     JPanel buttons = new JPanel(new GridLayout(2, 1, 5, 5));
/*  52 */     JPanel line1 = new JPanel(new GridLayout(1, 2, 5, 5));
/*  53 */     JPanel line2 = new JPanel(new GridLayout(1, 3, 5, 5));
/*  54 */     JPanel line3 = new JPanel(new GridLayout(1, 1, 5, 5));
/*     */     
/*  56 */     line1.add(createBackgroundChooseButton());
/*  57 */     line1.add(createCursorColorChooseButton());
/*  58 */     line2.add(createTextColorChooseButton());
/*  59 */     line2.add(createFontChooseButton());
/*  60 */     line2.add(createBorderChooseButton());
/*  61 */     line3.add(createTransparencySlider());
/*     */     
/*  63 */     buttons.add(line1);
/*  64 */     buttons.add(line2);
/*  65 */     add(buttons, "North");
/*  66 */     add(line3, "South");
/*  67 */     setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
/*     */   }
/*     */   
/*     */   private JPanel createTransparencySlider() {
/*  71 */     JPanel sliderPane = new JPanel(new BorderLayout(2, 5));
/*  72 */     JLabel sliderText = new JLabel(LocaleUtils.getEditorLocaleString("Transparency"));
/*  73 */     this.slider = new JSlider(0, 100, 100);
/*  74 */     this.slider.setMajorTickSpacing(20);
/*  75 */     this.slider.setMinorTickSpacing(10);
/*  76 */     this.slider.setPaintLabels(true);
/*  77 */     this.slider.setPaintTicks(true);
/*  78 */     this.slider.setSnapToTicks(true);
/*  79 */     this.slider.setInverted(true);
/*  80 */     this.slider.setExtent(10);
/*  81 */     this.slider.addChangeListener(new ChangeListener() {
/*     */       public void stateChanged(ChangeEvent e) {
/*  83 */         CustomCellEditorPane.this.setInnerEdit(true);
/*  84 */         CustomCellEditorPane.this.getCustomValue().setTransparency(CustomCellEditorPane.this.slider.getValue() / 100.0F);
/*  85 */         CustomCellEditorPane.this.getMainEditor().fireLocalPropertyChange();
/*  86 */         CustomCellEditorPane.this.setInnerEdit(false);
/*     */       }
/*  88 */     });
/*  89 */     sliderPane.add(sliderText, "West");
/*  90 */     sliderPane.add(this.slider, "Center");
/*  91 */     return sliderPane;
/*     */   }
/*     */   
/*     */   private JButton createBackgroundChooseButton() {
/*  95 */     JButton selBackColor = new JButton(LocaleUtils.getEditorLocaleString("Background_color"));
/*  96 */     selBackColor.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/*  98 */         CustomCellEditorPane.this.getCustomValue().setBackgroundColor(CustomCellEditorPane.this.selectColor(CustomCellEditorPane.this.getCustomValue().getBackgroundColor(), LocaleUtils.getEditorLocaleString("Select_background_color")));
/*     */         
/*     */ 
/* 101 */         CustomCellEditorPane.this.getMainEditor().fireLocalPropertyChange();
/*     */       }
/* 103 */     });
/* 104 */     return selBackColor;
/*     */   }
/*     */   
/*     */   private JButton createBorderChooseButton() {
/* 108 */     JButton bBorder = new JButton(LocaleUtils.getEditorLocaleString("Border"));
/* 109 */     bBorder.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 111 */         Border newBorder = (Border)CustomCellEditorPane.this.borderEditorDialog.showDialog(CustomCellEditorPane.this.getCustomValue().getCellBorder(), LocaleUtils.getEditorLocaleString("Select_border"));
/*     */         
/* 113 */         if (!CustomCellEditorPane.this.borderEditorDialog.isCanceled()) {
/* 114 */           CustomCellEditorPane.this.getCustomValue().setCellBorder(newBorder);
/* 115 */           CustomCellEditorPane.this.getMainEditor().fireLocalPropertyChange();
/*     */         }
/*     */       }
/* 118 */     });
/* 119 */     return bBorder;
/*     */   }
/*     */   
/*     */   private CustomCellAppearance getCustomValue() {
/* 123 */     return (CustomCellAppearance)getValue();
/*     */   }
/*     */   
/*     */   public boolean isInnerEdit() {
/* 127 */     return this.innerEdit;
/*     */   }
/*     */   
/*     */   public void setInnerEdit(boolean innerEdit) {
/* 131 */     this.innerEdit = innerEdit;
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/cell/CustomCellEditorPane.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */