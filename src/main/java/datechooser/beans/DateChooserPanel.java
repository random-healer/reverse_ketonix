/*     */ package datechooser.beans;
/*     */ 
/*     */ import datechooser.controller.EventHandlerMultiply;
/*     */ import datechooser.events.CommitListener;
/*     */ import datechooser.events.CursorMoveListener;
/*     */ import datechooser.events.SelectionChangedListener;
/*     */ import datechooser.model.DateChoose;
/*     */ import datechooser.model.exeptions.IncompatibleDataExeption;
/*     */ import datechooser.model.multiple.MultyDateChooseModel;
/*     */ import datechooser.model.multiple.MultyModelBehavior;
/*     */ import datechooser.model.multiple.Period;
/*     */ import datechooser.model.multiple.PeriodSet;
/*     */ import datechooser.view.CalendarPane;
/*     */ import datechooser.view.WeekDaysStyle;
/*     */ import datechooser.view.appearance.AppearancesList;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.beans.PropertyChangeEvent;
/*     */ import java.beans.PropertyChangeListener;
/*     */ import java.util.Calendar;
/*     */ import java.util.GregorianCalendar;
/*     */ import java.util.Locale;
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
/*     */ 
/*     */ 
/*     */ public class DateChooserPanel
/*     */   extends DateChooserVisual
/*     */   implements PropertyChangeListener
/*     */ {
/*     */   public static final long serialVersionUID = -267882659809359160L;
/*     */   public static final String PANEL_PREFIX = "dch_panel_";
/*     */   public static final String PROPERTY_BORDER = "dch_panel_border";
/*     */   private MultyDateChooseModel model;
/*     */   private CalendarPane calendarPane;
/*     */   
/*     */   public DateChooserPanel()
/*     */   {
/*  65 */     this.calendarPane = new CalendarPane();
/*  66 */     this.model = new MultyDateChooseModel(new GregorianCalendar());
/*  67 */     this.calendarPane.initialize(this.model, new EventHandlerMultiply());
/*  68 */     this.calendarPane.setPreferredSize(new Dimension(250, 180));
/*  69 */     this.calendarPane.addPropertyChangeListener(this);
/*  70 */     setLayout(new BorderLayout());
/*  71 */     add(this.calendarPane, "Center");
/*     */   }
/*     */   
/*     */   public boolean isAutoScroll() {
/*  75 */     return this.model.isAutoScroll();
/*     */   }
/*     */   
/*     */   public void setLocale(Locale locale) {
/*  79 */     super.setLocale(locale);
/*  80 */     this.calendarPane.setLocale(locale);
/*     */   }
/*     */   
/*     */   public boolean isDateChooserPanelProperty(String name)
/*     */   {
/*  85 */     if (name == null) return false;
/*  86 */     return name.startsWith("dch_");
/*     */   }
/*     */   
/*     */   public void setAutoScroll(boolean autoScroll) {
/*  90 */     boolean oldAutoScroll = isAutoScroll();
/*  91 */     this.model.setAutoScroll(autoScroll);
/*  92 */     firePropertyChange("dch_autoScroll", isAutoScroll(), autoScroll);
/*     */   }
/*     */   
/*     */   public boolean isShowOneMonth() {
/*  96 */     return !this.model.isShowNeighbourMonth();
/*     */   }
/*     */   
/*     */   public void setShowOneMonth(boolean showOneMonth) {
/* 100 */     boolean oldShowOneMonth = isShowOneMonth();
/* 101 */     this.model.setShowNeighbourMonth(!showOneMonth);
/* 102 */     firePropertyChange("dch_oneMonth", oldShowOneMonth, showOneMonth);
/*     */   }
/*     */   
/*     */   public boolean isEnabled() {
/* 106 */     return this.model.isEnabled();
/*     */   }
/*     */   
/*     */   public void setEnabled(boolean enabled) {
/* 110 */     boolean oldEnabled = isEnabled();
/* 111 */     this.model.setEnabled(enabled);
/* 112 */     firePropertyChange("dch_enabled", oldEnabled, enabled);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBorder(Border border)
/*     */   {
/* 121 */     Border oldBorder = getBorder();
/* 122 */     super.setBorder(border);
/* 123 */     firePropertyChange("dch_panel_border", oldBorder, getBorder());
/*     */   }
/*     */   
/*     */   public MultyModelBehavior getBehavior() {
/* 127 */     return this.model.getBehavior();
/*     */   }
/*     */   
/*     */   public void setBehavior(MultyModelBehavior behavior) {
/* 131 */     MultyModelBehavior oldBehavior = getBehavior();
/* 132 */     this.model.setBehavior(behavior);
/* 133 */     firePropertyChange("dch_behavior", oldBehavior, behavior);
/*     */   }
/*     */   
/*     */   public AppearancesList getCurrentView() {
/* 137 */     return this.calendarPane.getAppearancesList();
/*     */   }
/*     */   
/*     */   public void setCurrentView(AppearancesList aList)
/*     */   {
/* 142 */     this.calendarPane.setAppearancesList(aList);
/*     */   }
/*     */   
/*     */   public PeriodSet getDefaultPeriods() {
/* 146 */     return this.model.getDefaultPeriodSet();
/*     */   }
/*     */   
/*     */   public void setDefaultPeriods(PeriodSet periods) throws IncompatibleDataExeption {
/* 150 */     PeriodSet oldDefault = getDefaultPeriods();
/* 151 */     this.model.setDefaultPeriodSet(periods);
/* 152 */     firePropertyChange("dch_defaultDates", oldDefault, periods);
/*     */   }
/*     */   
/*     */   public Iterable<Period> getSelection() {
/* 156 */     return this.model.getSelectedPeriods();
/*     */   }
/*     */   
/*     */   public PeriodSet getSelectedPeriodSet() {
/* 160 */     return this.model.getSelectedPeriodSet();
/*     */   }
/*     */   
/*     */   public Calendar getSelectedDate() {
/* 164 */     return this.model.getSelectedDate();
/*     */   }
/*     */   
/*     */   public void setSelectedDate(Calendar aDate) {
/* 168 */     if (aDate == null) {
/* 169 */       this.model.selectNothing();
/*     */     } else {
/* 171 */       this.model.setSelectedDate(aDate);
/*     */     }
/*     */   }
/*     */   
/*     */   public void setSelection(Iterable<Period> periods) {
/* 176 */     if (periods == null) {
/* 177 */       this.model.selectNothing();
/*     */     } else {
/* 179 */       this.model.setSelectedPeriods(periods);
/*     */     }
/*     */   }
/*     */   
/*     */   public void setSelection(PeriodSet periods) {
/* 184 */     if (periods == null) {
/* 185 */       this.model.selectNothing();
/*     */     } else {
/* 187 */       this.model.setSelectedPeriods(periods);
/*     */     }
/*     */   }
/*     */   
/*     */   public PeriodSet getForbiddenPeriods() {
/* 192 */     return this.model.getForbiddenSet();
/*     */   }
/*     */   
/*     */   public void setForbiddenPeriods(PeriodSet periods) throws IncompatibleDataExeption {
/* 196 */     PeriodSet oldForbid = getForbiddenPeriods();
/* 197 */     this.model.setForbiddenSet(periods);
/* 198 */     firePropertyChange("dch_forbidDates", oldForbid, periods);
/*     */   }
/*     */   
/*     */   public void setForbidden(Iterable<Period> forbiddenPeriods) {
/* 202 */     this.model.setForbidden(forbiddenPeriods);
/*     */   }
/*     */   
/*     */   public Calendar getMaxDate() {
/* 206 */     return this.model.getMaxConstraint();
/*     */   }
/*     */   
/*     */   public void setMaxDate(Calendar aDate) {
/* 210 */     Calendar oldMax = getMaxDate();
/* 211 */     this.model.setMaxConstraint(aDate);
/* 212 */     firePropertyChange("dch_maxDate", oldMax, aDate);
/*     */   }
/*     */   
/*     */   public Calendar getMinDate() {
/* 216 */     return this.model.getMinConstraint();
/*     */   }
/*     */   
/*     */   public void setMinDate(Calendar aDate) {
/* 220 */     Calendar oldMin = getMinDate();
/* 221 */     this.model.setMinConstraint(aDate);
/* 222 */     firePropertyChange("dch_minDate", oldMin, aDate);
/*     */   }
/*     */   
/*     */   public void addCommitListener(CommitListener listener) {
/* 226 */     this.model.addCommitListener(listener);
/*     */   }
/*     */   
/*     */   public void removeCommitListener(CommitListener listener) {
/* 230 */     this.model.removeCommitListener(listener);
/*     */   }
/*     */   
/*     */   public void addSelectionChangedListener(SelectionChangedListener listener) {
/* 234 */     this.model.addSelectionChangedListener(listener);
/*     */   }
/*     */   
/*     */   public void removeSelectionChangedListener(SelectionChangedListener listener) {
/* 238 */     this.model.removeSelectionChangedListener(listener);
/*     */   }
/*     */   
/*     */   public void commit() {
/* 242 */     this.model.commit();
/*     */   }
/*     */   
/*     */   public boolean isLocked() {
/* 246 */     return this.model.isLocked();
/*     */   }
/*     */   
/*     */   public void setLocked(boolean lock) {
/* 250 */     boolean oldLock = isLocked();
/* 251 */     this.model.setLocked(lock);
/* 252 */     firePropertyChange("dch_locked", oldLock, lock);
/*     */   }
/*     */   
/*     */   public void addCursorMoveListener(CursorMoveListener listener) {
/* 256 */     this.model.addCursorMoveListener(listener);
/*     */   }
/*     */   
/*     */   public void removeCursorMoveListener(CursorMoveListener listener) {
/* 260 */     this.model.removeCursorMoveListener(listener);
/*     */   }
/*     */   
/*     */   public Calendar getCurrent() {
/* 264 */     return this.model.getCurrent();
/*     */   }
/*     */   
/*     */   public boolean setCurrent(Calendar aDate) {
/* 268 */     Calendar oldDate = getCurrent();
/* 269 */     if (aDate == null) {
/* 270 */       this.model.selectNothing();
/* 271 */       return true;
/*     */     }
/* 273 */     boolean result = this.model.select(aDate);
/* 274 */     firePropertyChange("dch_current", oldDate, aDate);
/* 275 */     return result;
/*     */   }
/*     */   
/*     */   public void setNothingAllowed(boolean allow) {
/* 279 */     boolean oldAllow = isNothingAllowed();
/* 280 */     this.model.setNothingAllowed(allow);
/* 281 */     firePropertyChange("dch_nothingAllowed", oldAllow, allow);
/*     */   }
/*     */   
/*     */   public boolean isNothingAllowed() {
/* 285 */     return this.model.isNothingAllowed();
/*     */   }
/*     */   
/*     */   public Color getCalendarBackground() {
/* 289 */     return this.calendarPane.getGridBackground();
/*     */   }
/*     */   
/*     */   public void setCalendarBackground(Color backColor) {
/* 293 */     Color was = getCalendarBackground();
/* 294 */     this.calendarPane.setGridBackground(backColor);
/* 295 */     firePropertyChange("dch_backgroundColor", was, backColor);
/*     */   }
/*     */   
/*     */   public Dimension getCalendarPreferredSize() {
/* 299 */     return getPreferredSize();
/*     */   }
/*     */   
/*     */   public void setCalendarPreferredSize(Dimension dim) {
/* 303 */     Dimension oldSize = getCalendarPreferredSize();
/* 304 */     setPreferredSize(dim);
/* 305 */     firePropertyChange("dch_calSize", oldSize, getCalendarPreferredSize());
/*     */   }
/*     */   
/*     */   public WeekDaysStyle getWeekStyle() {
/* 309 */     return this.calendarPane.getWeekStyle();
/*     */   }
/*     */   
/*     */   public void setWeekStyle(WeekDaysStyle weekStyle) {
/* 313 */     this.calendarPane.setWeekStyle(weekStyle);
/*     */   }
/*     */   
/*     */   public Font getNavigateFont() {
/* 317 */     return this.calendarPane.getNavigateFont();
/*     */   }
/*     */   
/*     */   public void setNavigateFont(Font font) {
/* 321 */     this.calendarPane.setNavigateFont(font);
/*     */   }
/*     */   
/*     */   public int getCurrentNavigateIndex() {
/* 325 */     return this.calendarPane.getCurrentNavigateIndex();
/*     */   }
/*     */   
/*     */   public void setCurrentNavigateIndex(int currentNavigateIndex) {
/* 329 */     this.calendarPane.setCurrentNavigateIndex(currentNavigateIndex);
/*     */   }
/*     */   
/*     */   public DateChoose getModel() {
/* 333 */     return this.model;
/*     */   }
/*     */   
/*     */   public void propertyChange(PropertyChangeEvent evt) {
/* 337 */     firePropertyChange(evt.getPropertyName(), evt.getOldValue(), evt.getNewValue());
/*     */   }
/*     */   
/*     */   public AppearancesList getAppearancesList() {
/* 341 */     return this.calendarPane.getAppearancesList();
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/DateChooserPanel.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */