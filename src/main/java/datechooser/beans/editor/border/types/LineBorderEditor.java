/*     */ package datechooser.beans.editor.border.types;
/*     */ 
/*     */ import datechooser.beans.editor.utils.ColorChooseAction;
/*     */ import datechooser.beans.editor.utils.ColorHolder;
/*     */ import datechooser.beans.editor.utils.SpinPane;
/*     */ import datechooser.beans.locale.LocaleUtils;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Color;
/*     */ import java.awt.GridLayout;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.beans.PropertyChangeEvent;
/*     */ import java.beans.PropertyChangeListener;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.SpinnerNumberModel;
/*     */ import javax.swing.border.Border;
/*     */ import javax.swing.border.LineBorder;
/*     */ import javax.swing.event.ChangeEvent;
/*     */ import javax.swing.event.ChangeListener;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LineBorderEditor
/*     */   extends AbstractBorderEditor
/*     */   implements PropertyChangeListener
/*     */ {
/*  30 */   private static int MIN_THICK = 1;
/*  31 */   private static int MAX_THICK = 20;
/*     */   
/*     */   private ColorHolder color;
/*     */   
/*     */   private int thickness;
/*     */   private boolean roundedCorners;
/*     */   private JCheckBox rounded;
/*     */   private SpinnerNumberModel thickModel;
/*     */   
/*     */   public LineBorderEditor()
/*     */   {
/*  42 */     initialize();
/*     */     
/*  44 */     this.color = new ColorHolder();
/*  45 */     setCaption(LocaleUtils.getEditorLocaleString("Line"));
/*  46 */     assignValueToParameters();
/*     */     
/*  48 */     this.rounded = new JCheckBox(LocaleUtils.getEditorLocaleString("Rounded_corners"));
/*  49 */     this.rounded.setSelected(this.roundedCorners);
/*  50 */     this.rounded.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/*  52 */         LineBorderEditor.this.roundedCorners = LineBorderEditor.this.rounded.isSelected();
/*  53 */         LineBorderEditor.this.fireChange();
/*     */       }
/*     */       
/*  56 */     });
/*  57 */     this.thickModel = new SpinnerNumberModel(this.thickness, MIN_THICK, MAX_THICK, 1);
/*  58 */     SpinPane thickPane = new SpinPane(this.thickModel, LocaleUtils.getEditorLocaleString("Thickness"));
/*  59 */     this.thickModel.addChangeListener(new ChangeListener() {
/*     */       public void stateChanged(ChangeEvent e) {
/*  61 */         LineBorderEditor.this.thickness = LineBorderEditor.this.thickModel.getNumber().intValue();
/*  62 */         LineBorderEditor.this.fireChange();
/*     */       }
/*     */       
/*  65 */     });
/*  66 */     JButton bColor = new JButton(LocaleUtils.getEditorLocaleString("Color"));
/*  67 */     ColorChooseAction colorChooseAction = new ColorChooseAction(this.color, LocaleUtils.getEditorLocaleString("Color"), this);
/*     */     
/*  69 */     colorChooseAction.addPropertyChangeListener(this);
/*  70 */     bColor.addActionListener(colorChooseAction);
/*     */     
/*  72 */     setLayout(new BorderLayout());
/*  73 */     JPanel pane = new JPanel(new GridLayout(1, 2));
/*  74 */     pane.add(getCenteredPane(this.rounded));
/*  75 */     pane.add(getCenteredPane(thickPane));
/*  76 */     JPanel paneTotal = new JPanel(new GridLayout(2, 1));
/*  77 */     paneTotal.add(pane);
/*  78 */     paneTotal.add(getCenteredPane(bColor));
/*  79 */     add(paneTotal, "North");
/*     */     
/*  81 */     refreshInterface();
/*     */   }
/*     */   
/*     */   protected void prepareSelection() {
/*  85 */     setValue(new LineBorder(this.color.getColor(), this.thickness, this.roundedCorners));
/*     */   }
/*     */   
/*     */   private void assignValueToParameters() {
/*  89 */     this.color.setColor(getValue().getLineColor());
/*  90 */     this.thickness = getValue().getThickness();
/*  91 */     this.roundedCorners = getValue().getRoundedCorners();
/*     */   }
/*     */   
/*     */   protected LineBorder getValue() {
/*  95 */     return (LineBorder)this.value;
/*     */   }
/*     */   
/*     */   public void refreshInterface() {
/*  99 */     assignValueToParameters();
/* 100 */     this.rounded.setSelected(this.roundedCorners);
/* 101 */     this.thickModel.setValue(new Integer(this.thickness));
/*     */   }
/*     */   
/*     */   protected Border getDefaultValue() {
/* 105 */     return new LineBorder(Color.BLACK);
/*     */   }
/*     */   
/*     */   public void propertyChange(PropertyChangeEvent evt) {
/* 109 */     if (!"color".equals(evt.getPropertyName())) return;
/* 110 */     fireChange();
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/border/types/LineBorderEditor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */