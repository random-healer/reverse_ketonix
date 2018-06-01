/*     */ package datechooser.beans.editor.border.types;
/*     */ 
/*     */ import datechooser.beans.editor.utils.ColorChooseAction;
/*     */ import datechooser.beans.editor.utils.ColorHolder;
/*     */ import datechooser.beans.editor.utils.RiseLowPanel;
/*     */ import datechooser.beans.locale.LocaleUtils;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.GridLayout;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.beans.PropertyChangeEvent;
/*     */ import java.beans.PropertyChangeListener;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.border.Border;
/*     */ import javax.swing.border.EtchedBorder;
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
/*     */ public class EtchedBorderEditor
/*     */   extends AbstractBorderEditor
/*     */   implements PropertyChangeListener
/*     */ {
/*     */   private int etchType;
/*     */   private ColorHolder highlight;
/*     */   private ColorHolder shadow;
/*     */   private RiseLowPanel selType;
/*     */   
/*     */   public EtchedBorderEditor()
/*     */   {
/*  39 */     initialize();
/*     */     
/*  41 */     this.highlight = new ColorHolder();
/*  42 */     this.shadow = new ColorHolder();
/*     */     
/*  44 */     setCaption(LocaleUtils.getEditorLocaleString("Etched"));
/*  45 */     assignValueToParameters();
/*     */     
/*  47 */     this.selType = new RiseLowPanel(this.etchType, 0, 1);
/*     */     
/*  49 */     this.selType.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/*  51 */         EtchedBorderEditor.this.etchType = EtchedBorderEditor.this.selType.getType();
/*  52 */         EtchedBorderEditor.this.fireChange();
/*     */       }
/*     */       
/*  55 */     });
/*  56 */     JButton bHigh = new JButton(LocaleUtils.getEditorLocaleString("Highlight"));
/*  57 */     ColorChooseAction colorChooseAction = new ColorChooseAction(this.highlight, LocaleUtils.getEditorLocaleString("Highlight"), this);
/*     */     
/*  59 */     colorChooseAction.addPropertyChangeListener(this);
/*  60 */     bHigh.addActionListener(colorChooseAction);
/*     */     
/*  62 */     JButton bShadow = new JButton(LocaleUtils.getEditorLocaleString("Shadow"));
/*  63 */     colorChooseAction = new ColorChooseAction(this.shadow, LocaleUtils.getEditorLocaleString("Shadow"), this);
/*     */     
/*  65 */     colorChooseAction.addPropertyChangeListener(this);
/*  66 */     bShadow.addActionListener(colorChooseAction);
/*     */     
/*  68 */     setLayout(new BorderLayout());
/*  69 */     JPanel totalPane = new JPanel(new GridLayout(2, 1));
/*  70 */     totalPane.add(this.selType);
/*  71 */     JPanel buttonPane = new JPanel(new GridLayout(1, 2));
/*  72 */     buttonPane.add(getCenteredPane(bHigh));
/*  73 */     buttonPane.add(getCenteredPane(bShadow));
/*  74 */     totalPane.add(buttonPane);
/*  75 */     add(totalPane, "North");
/*     */     
/*  77 */     refreshInterface();
/*     */   }
/*     */   
/*     */   protected void prepareSelection() {
/*  81 */     setValue(new EtchedBorder(this.etchType, this.highlight.getColor(), this.shadow.getColor()));
/*     */   }
/*     */   
/*     */   private void assignValueToParameters() {
/*  85 */     this.etchType = getValue().getEtchType();
/*  86 */     this.highlight.setColor(getValue().getHighlightColor());
/*  87 */     this.shadow.setColor(getValue().getShadowColor());
/*     */   }
/*     */   
/*     */   protected EtchedBorder getValue() {
/*  91 */     return (EtchedBorder)this.value;
/*     */   }
/*     */   
/*     */   public void refreshInterface() {
/*  95 */     assignValueToParameters();
/*     */   }
/*     */   
/*     */   protected Border getDefaultValue() {
/*  99 */     return new EtchedBorder();
/*     */   }
/*     */   
/*     */   public void propertyChange(PropertyChangeEvent evt) {
/* 103 */     if (!"color".equals(evt.getPropertyName())) return;
/* 104 */     fireChange();
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/border/types/EtchedBorderEditor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */