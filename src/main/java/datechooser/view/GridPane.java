/*     */ package datechooser.view;
/*     */ 
/*     */ import datechooser.controller.DateChooseController;
/*     */ import datechooser.controller.FooEventHandler;
/*     */ import datechooser.model.DateChoose;
/*     */ import datechooser.model.FooModel;
/*     */ import datechooser.view.appearance.AppearancesList;
/*     */ import datechooser.view.appearance.CellAppearance;
/*     */ import datechooser.view.appearance.ViewAppearance;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.FocusListener;
/*     */ import java.beans.PropertyChangeEvent;
/*     */ import java.beans.PropertyChangeListener;
/*     */ import java.text.DateFormatSymbols;
/*     */ import java.util.Calendar;
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
/*     */ public class GridPane
/*     */   extends JPanel
/*     */   implements PropertyChangeListener
/*     */ {
/*     */   private static final int TEXT_SHIFT = 8;
/*     */   private DateChoose model;
/*     */   private DateChooseController controller;
/*     */   private AppearancesList appearance;
/*     */   private transient CellAppearance currentAppearance;
/*     */   private String[] weekDays;
/*     */   private Locale locale;
/*     */   private boolean focused;
/*     */   private boolean autoFontSize;
/*     */   private WeekDaysStyle weekStyle;
/*     */   private Rectangle cell;
/*     */   private transient int rows;
/*     */   private transient int cols;
/*     */   private transient int cellWidth;
/*     */   private transient int cellHeight;
/*     */   private transient int widthShift;
/*     */   private transient int heightShift;
/*     */   private transient int widthCounter;
/*     */   private transient int heightCounter;
/*     */   private transient int curWidth;
/*     */   private transient int curHeight;
/*     */   
/*     */   public GridPane()
/*     */   {
/*  62 */     this(new AppearancesList());
/*     */   }
/*     */   
/*     */   public GridPane(AppearancesList appearanceList) {
/*  66 */     setAppearanceList(appearanceList);
/*  67 */     getAppearance().addPropertyChangeListener(new PropertyChangeListener() {
/*     */       public void propertyChange(PropertyChangeEvent evt) {
/*  69 */         GridPane.this.firePropertyChange("currentAppearance", null, null);
/*  70 */         GridPane.this.repaint();
/*     */       }
/*     */       
/*  73 */     });
/*  74 */     setFocused(false);
/*  75 */     setEnabled(true);
/*     */     
/*  77 */     addFocusListener(new FocusListener() {
/*     */       public void focusGained(FocusEvent e) {
/*  79 */         GridPane.this.setFocused(true);
/*     */       }
/*     */       
/*  82 */       public void focusLost(FocusEvent e) { GridPane.this.setFocused(false);
/*     */       }
/*     */ 
/*  85 */     });
/*  86 */     this.cell = new Rectangle();
/*     */     
/*     */ 
/*  89 */     setFocusable(true);
/*     */     
/*  91 */     setModel(new FooModel());
/*  92 */     setController(new FooEventHandler());
/*  93 */     this.locale = Locale.getDefault();
/*  94 */     this.weekStyle = WeekDaysStyle.NORMAL;
/*  95 */     initWeekDays();
/*     */   }
/*     */   
/*     */   public void setLocale(Locale l) {
/*  99 */     if (getLocale().equals(l)) return;
/* 100 */     super.setLocale(l);
/* 101 */     this.locale = l;
/* 102 */     initWeekDays();
/* 103 */     repaint();
/*     */   }
/*     */   
/*     */   public Locale getLocale() {
/* 107 */     return this.locale;
/*     */   }
/*     */   
/*     */   private void initWeekDays() {
/* 111 */     DateFormatSymbols dateSymbols = new DateFormatSymbols(getLocale());
/* 112 */     String[] allDays = null;
/* 113 */     switch (getWeekStyle()) {
/*     */     case FULL: 
/* 115 */       allDays = dateSymbols.getWeekdays();
/* 116 */       break;
/*     */     case NORMAL: 
/* 118 */       allDays = dateSymbols.getShortWeekdays();
/* 119 */       break;
/*     */     case SHORT: 
/* 121 */       allDays = dateSymbols.getShortWeekdays();
/* 122 */       for (int i = 0; i < allDays.length; i++) {
/* 123 */         if (allDays[i].length() >= 2) {
/* 124 */           allDays[i] = allDays[i].substring(0, 1).toLowerCase();
/*     */         }
/*     */       }
/*     */     }
/* 128 */     this.weekDays = new String[allDays.length - 1];
/* 129 */     int firstWD = Calendar.getInstance(getLocale()).getFirstDayOfWeek();
/* 130 */     for (int i = 0; i < allDays.length - 1; i++) {
/* 131 */       this.weekDays[i] = allDays[firstWD];
/* 132 */       if (firstWD < allDays.length - 1) {
/* 133 */         firstWD++;
/*     */       } else {
/* 135 */         firstWD = 1;
/*     */       }
/*     */     }
/* 138 */     allDays = null;
/*     */   }
/*     */   
/*     */   protected void paintComponent(Graphics g) {
/* 142 */     super.paintComponent(g);
/*     */     
/* 144 */     Graphics2D g2d = (Graphics2D)g;
/* 145 */     getController().reBound();
/*     */     
/* 147 */     Rectangle bounds = getBounds();
/*     */     
/* 149 */     BackRenderer renderer = getAppearance().isSupportsTransparency() ? getAppearance().getRenderer() : null;
/*     */     
/* 151 */     if (renderer != null) { renderer.render(g2d, bounds);
/*     */     }
/* 153 */     this.rows = (getModel().getRowsCount() + 1);
/* 154 */     this.cols = getModel().getColsCount();
/*     */     
/* 156 */     this.cellWidth = ((int)bounds.getWidth() / this.cols);
/* 157 */     this.cellHeight = ((int)bounds.getHeight() / this.rows);
/*     */     
/* 159 */     this.widthShift = ((int)bounds.getWidth() % this.cols);
/* 160 */     this.heightShift = ((int)bounds.getHeight() % this.rows);
/*     */     
/*     */ 
/*     */ 
/* 164 */     this.curWidth = 0;
/*     */     
/* 166 */     this.widthCounter = this.widthShift;
/* 167 */     this.heightCounter = this.heightShift;
/* 168 */     this.curHeight = (this.cellHeight + (this.heightCounter-- > 0 ? 1 : 0));
/* 169 */     for (int c = 0; c < this.cols; c++) {
/* 170 */       this.curWidth = (this.cellWidth + (this.widthCounter-- > 0 ? 1 : 0));
/* 171 */       paintCaption(g2d, c, this.curWidth, this.curHeight);
/* 172 */       g2d.translate(this.curWidth, 0);
/*     */     }
/* 174 */     g2d.translate(-this.cellWidth * this.cols - this.widthShift, this.curHeight);
/*     */     
/* 176 */     this.widthCounter = this.widthShift;
/* 177 */     for (int i = 1; i < this.rows; i++) {
/* 178 */       this.curHeight = (this.cellHeight + (this.heightCounter-- > 0 ? 1 : 0));
/* 179 */       for (int j = 0; j < this.cols; j++) {
/* 180 */         this.curWidth = (this.cellWidth + (this.widthCounter-- > 0 ? 1 : 0));
/* 181 */         paintCell(g2d, i - 1, j, this.curWidth, this.curHeight);
/* 182 */         if (j == this.cols - 1) {
/* 183 */           g2d.translate(-this.cellWidth * (this.cols - 1) - this.widthShift, this.curHeight);
/* 184 */           this.widthCounter = this.widthShift;
/*     */         } else {
/* 186 */           g2d.translate(this.curWidth, 0);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void paintCell(Graphics2D g2d, int row, int column, int width, int height) {
/* 193 */     boolean isText = true;
/* 194 */     switch (getModel().getCellState(row, column)) {
/*     */     case NORMAL: 
/* 196 */       this.currentAppearance = getAppearance().getUsual();
/* 197 */       break;
/*     */     case NOW: 
/* 199 */       this.currentAppearance = getAppearance().getNow();
/* 200 */       break;
/*     */     case SELECTED: 
/* 202 */       this.currentAppearance = getAppearance().getSelected();
/* 203 */       break;
/*     */     case UNACCESSIBLE: 
/* 205 */       this.currentAppearance = getAppearance().getDisabled();
/* 206 */       break;
/*     */     case NORMAL_SCROLL: 
/* 208 */       isText = getModel().isShowNeighbourMonth();
/* 209 */       this.currentAppearance = getAppearance().getScroll();
/*     */     }
/*     */     
/* 212 */     if (this.currentAppearance == null) {
/* 213 */       return;
/*     */     }
/* 215 */     this.currentAppearance.render(g2d, this, isText ? getModel().getCellCaption(row, column) : "", width, height, (isFocused()) && (getModel().isCursor(row, column)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void paintCaption(Graphics2D g2d, int c, int width, int height)
/*     */   {
/* 222 */     getAppearance().getCaption().render(g2d, this, this.weekDays[c], width, height);
/*     */   }
/*     */   
/*     */   public DateChooseController getController() {
/* 226 */     return this.controller;
/*     */   }
/*     */   
/*     */   public void setController(DateChooseController controller) {
/* 230 */     this.controller = controller;
/* 231 */     controller.setView(this);
/*     */   }
/*     */   
/*     */   public DateChoose getModel() {
/* 235 */     return this.model;
/*     */   }
/*     */   
/*     */   public void setModel(DateChoose model) {
/* 239 */     if (getModel() != null) {
/* 240 */       getModel().removePropertyChangeListener(this);
/*     */     }
/* 242 */     this.model = model;
/* 243 */     getModel().addPropertyChangeListener(this);
/*     */   }
/*     */   
/*     */   public boolean isFocused()
/*     */   {
/* 248 */     return this.focused;
/*     */   }
/*     */   
/*     */   public void setFocused(boolean focused) {
/* 252 */     this.focused = focused;
/* 253 */     repaint();
/*     */   }
/*     */   
/*     */   public boolean isAutoFontSize() {
/* 257 */     return this.autoFontSize;
/*     */   }
/*     */   
/*     */   public void setAutoFontSize(boolean autoFontSize) {
/* 261 */     this.autoFontSize = autoFontSize;
/*     */   }
/*     */   
/*     */   public ViewAppearance getAppearance() {
/* 265 */     return this.appearance.getCurrent();
/*     */   }
/*     */   
/*     */   public void setEnabled(boolean enabled) {
/* 269 */     super.setEnabled(enabled);
/* 270 */     setFocusable(enabled);
/*     */   }
/*     */   
/*     */   public AppearancesList getAppearanceList() {
/* 274 */     return this.appearance;
/*     */   }
/*     */   
/*     */   public void setAppearanceList(AppearancesList appearance) {
/* 278 */     this.appearance = appearance;
/*     */   }
/*     */   
/*     */   public WeekDaysStyle getWeekStyle() {
/* 282 */     return this.weekStyle;
/*     */   }
/*     */   
/*     */   public void setWeekStyle(WeekDaysStyle weekStyle) {
/* 286 */     if (weekStyle == this.weekStyle) return;
/* 287 */     this.weekStyle = weekStyle;
/* 288 */     initWeekDays();
/*     */   }
/*     */   
/*     */   public void propertyChange(PropertyChangeEvent evt) {
/* 292 */     repaint();
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/view/GridPane.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */