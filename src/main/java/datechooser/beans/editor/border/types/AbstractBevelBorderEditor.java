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
/*     */ import javax.swing.border.BevelBorder;
/*     */ import javax.swing.border.Border;
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
/*     */ public abstract class AbstractBevelBorderEditor
/*     */   extends AbstractBorderEditor
/*     */   implements PropertyChangeListener
/*     */ {
/*     */   protected int bevelType;
/*     */   protected ColorHolder highlightOuter;
/*     */   protected ColorHolder highlightInner;
/*     */   protected ColorHolder shadowOuter;
/*     */   protected ColorHolder shadowInner;
/*     */   private RiseLowPanel selType;
/*     */   private JButton bHighOut;
/*     */   private JButton bHighIn;
/*     */   private JButton bShadowOut;
/*     */   private JButton bShadowIn;
/*     */   
/*     */   protected abstract Border getBorderByParams();
/*     */   
/*     */   public AbstractBevelBorderEditor()
/*     */   {
/*  47 */     this.highlightInner = new ColorHolder();
/*  48 */     this.highlightOuter = new ColorHolder();
/*  49 */     this.shadowInner = new ColorHolder();
/*  50 */     this.shadowOuter = new ColorHolder();
/*     */     
/*  52 */     initialize();
/*     */     
/*  54 */     this.selType = new RiseLowPanel(this.bevelType, 0, 1);
/*     */     
/*  56 */     this.selType.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/*  58 */         AbstractBevelBorderEditor.this.bevelType = AbstractBevelBorderEditor.this.selType.getType();
/*  59 */         AbstractBevelBorderEditor.this.fireChange();
/*     */       }
/*     */       
/*  62 */     });
/*  63 */     this.bHighIn = new JButton(LocaleUtils.getEditorLocaleString("Highlight_innner"));
/*  64 */     ColorChooseAction colorChooseAction = new ColorChooseAction(this.highlightInner, LocaleUtils.getEditorLocaleString("Highlight_innner"), this);
/*     */     
/*  66 */     colorChooseAction.addPropertyChangeListener(this);
/*  67 */     this.bHighIn.addActionListener(colorChooseAction);
/*     */     
/*  69 */     this.bHighOut = new JButton(LocaleUtils.getEditorLocaleString("Highlight_outher"));
/*  70 */     colorChooseAction = new ColorChooseAction(this.highlightOuter, LocaleUtils.getEditorLocaleString("Highlight_outher"), this);
/*     */     
/*  72 */     colorChooseAction.addPropertyChangeListener(this);
/*  73 */     this.bHighOut.addActionListener(colorChooseAction);
/*     */     
/*  75 */     this.bShadowIn = new JButton(LocaleUtils.getEditorLocaleString("Shadow_innner"));
/*  76 */     colorChooseAction = new ColorChooseAction(this.shadowInner, LocaleUtils.getEditorLocaleString("Shadow_innner"), this);
/*     */     
/*  78 */     this.bShadowIn.addActionListener(colorChooseAction);
/*     */     
/*  80 */     this.bShadowOut = new JButton(LocaleUtils.getEditorLocaleString("Shadow_outher"));
/*  81 */     colorChooseAction = new ColorChooseAction(this.shadowOuter, LocaleUtils.getEditorLocaleString("Shadow_outher"), this);
/*     */     
/*  83 */     this.bShadowOut.addActionListener(colorChooseAction);
/*     */     
/*  85 */     setLayout(new BorderLayout());
/*  86 */     JPanel confPane = new JPanel(new BorderLayout());
/*  87 */     confPane.add(this.selType, "North");
/*  88 */     JPanel buttonPane = new JPanel(new GridLayout(2, 2));
/*  89 */     buttonPane.add(getCenteredPane(this.bHighIn));
/*  90 */     buttonPane.add(getCenteredPane(this.bHighOut));
/*  91 */     buttonPane.add(getCenteredPane(this.bShadowIn));
/*  92 */     buttonPane.add(getCenteredPane(this.bShadowOut));
/*  93 */     confPane.add(buttonPane, "South");
/*  94 */     add(confPane, "North");
/*     */     
/*  96 */     refreshInterface();
/*     */   }
/*     */   
/*     */   public void propertyChange(PropertyChangeEvent evt) {
/* 100 */     if (!"color".equals(evt.getPropertyName())) return;
/* 101 */     firePropertyChange("border", null, null);
/*     */   }
/*     */   
/*     */   public void prepareSelection() {
/* 105 */     setValue(getBorderByParams());
/*     */   }
/*     */   
/*     */   private void assignValueToParameters() {
/* 109 */     this.bevelType = getValue().getBevelType();
/* 110 */     this.highlightOuter.setColor(getValue().getHighlightOuterColor());
/* 111 */     this.highlightInner.setColor(getValue().getHighlightInnerColor());
/* 112 */     this.shadowOuter.setColor(getValue().getShadowOuterColor());
/* 113 */     this.shadowInner.setColor(getValue().getShadowInnerColor());
/*     */   }
/*     */   
/*     */   protected BevelBorder getValue() {
/* 117 */     return (BevelBorder)this.value;
/*     */   }
/*     */   
/*     */   public void refreshInterface() {
/* 121 */     assignValueToParameters();
/* 122 */     this.selType.setType(this.bevelType);
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/border/types/AbstractBevelBorderEditor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */