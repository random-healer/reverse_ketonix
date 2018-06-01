/*     */ package datechooser.beans.editor.cell;
/*     */ 
/*     */ import datechooser.beans.editor.utils.SpinPane;
/*     */ import datechooser.beans.locale.LocaleUtils;
/*     */ import datechooser.view.appearance.CellAppearance;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.FlowLayout;
/*     */ import java.awt.event.ComponentEvent;
/*     */ import java.awt.event.ComponentListener;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.JPanel;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CellPreview
/*     */   extends JPanel
/*     */ {
/*     */   private static final int MIN_SIZE = 25;
/*     */   private CellDraw drawer;
/*     */   private SpinnerNumberModel width;
/*     */   private SpinnerNumberModel height;
/*     */   private boolean autoEdit;
/*     */   
/*     */   public CellPreview(CellAppearance look)
/*     */   {
/*  40 */     setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5), BorderFactory.createEtchedBorder()));
/*     */     
/*     */ 
/*  43 */     this.drawer = new CellDraw(look);
/*  44 */     setAutoEdit(false);
/*     */     
/*  46 */     this.width = new SpinnerNumberModel(25, 25, 10000, 1);
/*  47 */     this.height = new SpinnerNumberModel(25, 25, 10000, 1);
/*  48 */     JPanel spinnersPane = new JPanel(new FlowLayout(1));
/*  49 */     SpinPane spinWidth = new SpinPane(this.width, LocaleUtils.getEditorLocaleString("Width"));
/*  50 */     SpinPane spinHeight = new SpinPane(this.height, LocaleUtils.getEditorLocaleString("Height"));
/*     */     
/*  52 */     initListeners();
/*     */     
/*  54 */     spinnersPane.add(spinWidth);
/*  55 */     spinnersPane.add(spinHeight);
/*  56 */     setLayout(new BorderLayout());
/*  57 */     add(spinnersPane, "North");
/*  58 */     add(this.drawer, "Center");
/*     */     
/*  60 */     updateCellSize();
/*     */   }
/*     */   
/*     */   public void setLook(CellAppearance look) {
/*  64 */     this.drawer.setLook(look);
/*  65 */     this.drawer.repaint();
/*     */   }
/*     */   
/*     */   private void initListeners()
/*     */   {
/*  70 */     this.width.addChangeListener(new ChangeListener() {
/*     */       public void stateChanged(ChangeEvent e) {
/*  72 */         if (CellPreview.this.isAutoEdit()) return;
/*  73 */         CellPreview.this.setAutoValue(CellPreview.this.width, Integer.valueOf(CellPreview.this.drawer.setCellWidth(CellPreview.this.width.getNumber().intValue())));
/*  74 */         CellPreview.this.drawer.repaint();
/*     */       }
/*     */       
/*  77 */     });
/*  78 */     this.height.addChangeListener(new ChangeListener() {
/*     */       public void stateChanged(ChangeEvent e) {
/*  80 */         if (CellPreview.this.isAutoEdit()) return;
/*  81 */         CellPreview.this.setAutoValue(CellPreview.this.height, Integer.valueOf(CellPreview.this.drawer.setCellHeight(CellPreview.this.height.getNumber().intValue())));
/*  82 */         CellPreview.this.drawer.repaint();
/*     */       }
/*     */       
/*  85 */     });
/*  86 */     this.drawer.addComponentListener(new ComponentListener() {
/*     */       public void componentHidden(ComponentEvent e) {}
/*     */       
/*     */       public void componentMoved(ComponentEvent e) {}
/*     */       
/*     */       public void componentResized(ComponentEvent e) {
/*  92 */         CellPreview.this.updateCellSize();
/*     */       }
/*     */       
/*     */       public void componentShown(ComponentEvent e) {}
/*     */     });
/*     */   }
/*     */   
/*     */   private void updateCellSize() {
/* 100 */     this.drawer.processCurrentSize();
/* 101 */     setAutoValue(this.width, Integer.valueOf(this.drawer.getCellWidth()));
/* 102 */     setAutoValue(this.height, Integer.valueOf(this.drawer.getCellHeight()));
/*     */   }
/*     */   
/*     */   private void setAutoValue(SpinnerNumberModel model, Integer value) {
/* 106 */     setAutoEdit(true);
/* 107 */     model.setValue(value);
/* 108 */     setAutoEdit(false);
/*     */   }
/*     */   
/*     */   public boolean isAutoEdit() {
/* 112 */     return this.autoEdit;
/*     */   }
/*     */   
/*     */   public void setAutoEdit(boolean autoEdit) {
/* 116 */     this.autoEdit = autoEdit;
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/cell/CellPreview.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */