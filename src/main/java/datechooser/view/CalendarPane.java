/*     */ package datechooser.view;
/*     */ 
/*     */ import datechooser.controller.DateChooseController;
/*     */ import datechooser.model.DateChoose;
/*     */ import datechooser.view.appearance.AppearancesList;
/*     */ import datechooser.view.appearance.ViewAppearance;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.beans.PropertyChangeEvent;
/*     */ import java.beans.PropertyChangeListener;
/*     */ import java.util.Locale;
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
/*     */ public class CalendarPane
/*     */   extends JPanel
/*     */   implements PropertyChangeListener
/*     */ {
/*     */   private GridPane gp;
/*     */   private AbstractNavigatePane[] navigPanes;
/*     */   private DateChoose model;
/*     */   private Locale locale;
/*  36 */   private int currentNavigateIndex = 0;
/*     */   
/*     */   public void initialize(DateChoose model, DateChooseController controller) {
/*  39 */     setPreferredSize(new Dimension(100, 100));
/*  40 */     this.gp = new GridPane();
/*  41 */     setLayout(new BorderLayout());
/*  42 */     this.navigPanes = new AbstractNavigatePane[] { new ComboNavigatePane(), new ButtonNavigatePane() };
/*     */     
/*  44 */     setNavigateFont(new Font("serif", 0, 11));
/*  45 */     setModel(model);
/*  46 */     this.gp.setModel(model);
/*  47 */     setLocale(Locale.getDefault());
/*     */     
/*  49 */     this.gp.setController(controller);
/*  50 */     add(this.gp, "Center");
/*  51 */     setCurrentNavigateIndex(0);
/*  52 */     add(getCurrentNavigPane(), "North");
/*     */   }
/*     */   
/*     */   private AbstractNavigatePane getCurrentNavigPane() {
/*  56 */     return this.navigPanes[getCurrentNavigateIndex()];
/*     */   }
/*     */   
/*     */   private void setAllNavigCurrentModel() {
/*  60 */     for (int i = 0; i < this.navigPanes.length; i++) {
/*  61 */       this.navigPanes[i].setModel(getModel());
/*     */     }
/*     */   }
/*     */   
/*     */   public void reInitialize(DateChoose model, DateChooseController controller) {
/*  66 */     if (this.gp == null) return;
/*  67 */     setModel(model);
/*  68 */     this.gp.setModel(model);
/*  69 */     this.gp.setController(controller);
/*     */   }
/*     */   
/*     */   public CalendarPane(DateChoose model, DateChooseController controller) {
/*  73 */     initialize(model, controller);
/*     */   }
/*     */   
/*     */   public CalendarPane() {}
/*     */   
/*     */   public DateChoose getModel()
/*     */   {
/*  80 */     return this.model;
/*     */   }
/*     */   
/*     */   public void setModel(DateChoose model) {
/*  84 */     DateChoose oldModel = getModel();
/*  85 */     if (getModel() != null) {
/*  86 */       getModel().removePropertyChangeListener(this);
/*     */     }
/*  88 */     this.model = model;
/*  89 */     setAllNavigCurrentModel();
/*  90 */     getModel().addPropertyChangeListener(this);
/*  91 */     firePropertyChange("model", oldModel, model);
/*     */   }
/*     */   
/*     */   public Font getNavigateFont() {
/*  95 */     return getCurrentNavigPane().getFont();
/*     */   }
/*     */   
/*     */   public void setNavigateFont(Font font) {
/*  99 */     Font oldFont = getNavigateFont();
/* 100 */     for (int i = 0; i < this.navigPanes.length; i++) {
/* 101 */       this.navigPanes[i].setFont(font);
/*     */     }
/* 103 */     updateUI();
/* 104 */     firePropertyChange("dch_navFont", oldFont, font);
/*     */   }
/*     */   
/*     */   public ViewAppearance getCurrentCellAppearance() {
/* 108 */     return this.gp.getAppearance();
/*     */   }
/*     */   
/*     */   public AppearancesList getAppearancesList() {
/* 112 */     return this.gp.getAppearanceList();
/*     */   }
/*     */   
/*     */   public void setAppearancesList(AppearancesList aList) {
/* 116 */     AppearancesList oldView = getAppearancesList();
/* 117 */     this.gp.setAppearanceList(aList);
/* 118 */     firePropertyChange("dch_view", oldView, aList);
/*     */   }
/*     */   
/*     */   public Locale getLocale() {
/* 122 */     return this.locale;
/*     */   }
/*     */   
/*     */   public void setLocale(Locale locale) {
/* 126 */     if ((getLocale() != null) && (getLocale().equals(locale))) return;
/* 127 */     Locale oldLocale = getLocale();
/* 128 */     this.locale = locale;
/* 129 */     this.model.setLocale(locale);
/* 130 */     this.gp.setLocale(locale);
/* 131 */     for (AbstractNavigatePane pane : this.navigPanes) {
/* 132 */       pane.setLocale(locale);
/*     */     }
/* 134 */     firePropertyChange("dch_locale", oldLocale, locale);
/*     */   }
/*     */   
/*     */   public int getCurrentNavigateIndex() {
/* 138 */     return this.currentNavigateIndex;
/*     */   }
/*     */   
/*     */   public void setCurrentNavigateIndex(int currentNavigateIndex) {
/* 142 */     int newPaneIndex = 0;
/* 143 */     if ((currentNavigateIndex >= 0) && (currentNavigateIndex < this.navigPanes.length)) {
/* 144 */       newPaneIndex = currentNavigateIndex;
/*     */     }
/* 146 */     if (newPaneIndex != getCurrentNavigateIndex()) {
/* 147 */       int oldIndex = getCurrentNavigateIndex();
/* 148 */       remove(getCurrentNavigPane());
/* 149 */       this.currentNavigateIndex = currentNavigateIndex;
/* 150 */       add(getCurrentNavigPane(), "North");
/* 151 */       revalidate();
/* 152 */       getCurrentNavigPane().setEnabled(getModel().isEnabled());
/* 153 */       firePropertyChange("dch_navigPane", oldIndex, newPaneIndex);
/*     */     }
/*     */   }
/*     */   
/*     */   public WeekDaysStyle getWeekStyle() {
/* 158 */     return this.gp.getWeekStyle();
/*     */   }
/*     */   
/*     */   public void setWeekStyle(WeekDaysStyle weekStyle) {
/* 162 */     WeekDaysStyle oldStyle = getWeekStyle();
/* 163 */     this.gp.setWeekStyle(weekStyle);
/* 164 */     firePropertyChange("dch_weekDayStyle", oldStyle, weekStyle);
/*     */   }
/*     */   
/*     */   public void propertyChange(PropertyChangeEvent evt) {
/* 168 */     DateChoose model = getModel();
/* 169 */     this.gp.setEnabled(model.isEnabled());
/* 170 */     AbstractNavigatePane navig = getCurrentNavigPane();
/* 171 */     navig.setNothingSelectEnabled(model.isNothingAllowed());
/* 172 */     navig.setEnabled(model.isEnabled());
/*     */   }
/*     */   
/*     */   public void setGridBackground(Color color) {
/* 176 */     this.gp.setBackground(color);
/*     */   }
/*     */   
/*     */   public Color getGridBackground() {
/* 180 */     return this.gp.getBackground();
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/view/CalendarPane.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */