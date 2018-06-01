/*     */ package datechooser.model;
/*     */ 
/*     */ import datechooser.beans.locale.LocaleUtils;
/*     */ import datechooser.events.CommitEvent;
/*     */ import datechooser.events.CommitListener;
/*     */ import datechooser.events.CursorMoveEvent;
/*     */ import datechooser.events.CursorMoveListener;
/*     */ import datechooser.events.SelectionChangedEvent;
/*     */ import datechooser.events.SelectionChangedListener;
/*     */ import datechooser.model.exeptions.IncompatibleDataExeption;
/*     */ import datechooser.model.multiple.Period;
/*     */ import datechooser.model.multiple.PeriodSet;
/*     */ import java.beans.PropertyChangeListener;
/*     */ import java.beans.PropertyChangeSupport;
/*     */ import java.util.Calendar;
/*     */ import java.util.Locale;
/*     */ import javax.swing.event.EventListenerList;
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
/*     */ public abstract class AbstractDateChooseModel
/*     */   implements DateChoose
/*     */ {
/*     */   private int rowsCount;
/*     */   private int colsCount;
/*     */   private int selRow;
/*     */   private int selCol;
/*     */   private boolean isValid;
/*     */   private boolean enabled;
/*     */   private boolean autoScroll;
/*     */   private boolean showNeighbourMonth;
/*     */   private Locale locale;
/*     */   private int firstWeekDay;
/*     */   private PropertyChangeSupport changeSupport;
/*     */   protected boolean changeEventsOn;
/*  54 */   private EventListenerList listenerList = new EventListenerList();
/*     */   
/*     */ 
/*     */   private Calendar first;
/*     */   
/*     */ 
/*     */   private Calendar minConstraint;
/*     */   
/*     */ 
/*     */   private Calendar maxConstraint;
/*     */   
/*     */ 
/*     */   private Calendar current;
/*     */   
/*     */ 
/*     */   private Calendar cursor;
/*     */   
/*     */ 
/*     */   private Calendar defaultDate;
/*     */   
/*     */ 
/*     */   private Calendar tempDate;
/*     */   
/*  77 */   private PeriodSet forbidden = null;
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean locked;
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean nothingAllowed;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected abstract void selectColumn(int paramInt);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public AbstractDateChooseModel(Calendar current, int rowsCount, int colsCount)
/*     */   {
/*  97 */     this.changeSupport = new PropertyChangeSupport(this);
/*  98 */     setChangeEventsOn(false);
/*     */     
/* 100 */     this.current = ((Calendar)current.clone());
/*     */     
/* 102 */     this.tempDate = ((Calendar)current.clone());
/* 103 */     this.first = ((Calendar)current.clone());
/* 104 */     this.defaultDate = ((Calendar)current.clone());
/* 105 */     this.cursor = ((Calendar)current.clone());
/*     */     
/* 107 */     this.forbidden = new PeriodSet();
/*     */     
/* 109 */     setAutoScroll(true);
/* 110 */     setShowNeighbourMonth(true);
/* 111 */     setEnabled(true);
/* 112 */     setLocked(false);
/* 113 */     setNothingAllowed(true);
/*     */     
/* 115 */     this.defaultDate = ((Calendar)current.clone());
/* 116 */     this.rowsCount = rowsCount;
/* 117 */     this.colsCount = colsCount;
/*     */     
/* 119 */     setLocale(Locale.getDefault());
/*     */     
/* 121 */     initFirst();
/* 122 */     invalidate();
/*     */     
/* 124 */     setMinConstraint(null);
/* 125 */     setMaxConstraint(null);
/*     */     
/* 127 */     setChangeEventsOn(true);
/*     */   }
/*     */   
/*     */   public int getRowsCount() {
/* 131 */     return this.rowsCount;
/*     */   }
/*     */   
/*     */   public int getColsCount() {
/* 135 */     return this.colsCount;
/*     */   }
/*     */   
/*     */   public boolean isCursor(int row, int column) {
/* 139 */     this.tempDate = getCellDate(row, column);
/* 140 */     return DateUtils.equals(this.tempDate, getCurrent());
/*     */   }
/*     */   
/*     */   public CellState getCellState(int row, int column) {
/* 144 */     this.tempDate = getCellDate(row, column);
/* 145 */     if (this.tempDate.get(2) != getNextMonth(this.first.get(2)))
/*     */     {
/* 147 */       return CellState.NORMAL_SCROLL;
/*     */     }
/* 149 */     if (!isEnabled()) {
/* 150 */       return CellState.UNACCESSIBLE;
/*     */     }
/* 152 */     if ((!checkConstraints(this.tempDate)) || (isDateForbidden(this.tempDate))) {
/* 153 */       return CellState.UNACCESSIBLE;
/*     */     }
/* 155 */     if (isSelected(this.tempDate)) {
/* 156 */       return CellState.SELECTED;
/*     */     }
/* 158 */     if ((getDefaultDate() != null) && (DateUtils.equals(this.tempDate, getDefaultDate()))) {
/* 159 */       return CellState.NOW;
/*     */     }
/* 161 */     return CellState.NORMAL;
/*     */   }
/*     */   
/*     */   public String getCellCaption(int row, int column) {
/* 165 */     return getCellDate(row, column).get(5) + "";
/*     */   }
/*     */   
/*     */   public Calendar getCellDate(int row, int column)
/*     */   {
/* 170 */     this.tempDate.setTime(this.first.getTime());
/* 171 */     this.tempDate.add(5, row * 7 + column);
/* 172 */     return this.tempDate;
/*     */   }
/*     */   
/*     */   public void setConstraints(Calendar min, Calendar max) {
/* 176 */     setMinConstraint(min);
/* 177 */     setMaxConstraint(max);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean needsFullValidation()
/*     */   {
/* 186 */     if (this.isValid) {
/* 187 */       return false;
/*     */     }
/* 189 */     this.isValid = false;
/* 190 */     return true;
/*     */   }
/*     */   
/*     */   public boolean select(int row, int column)
/*     */   {
/* 195 */     if ((row < 0) && (column >= 0)) {
/* 196 */       selectColumn(column);
/*     */     }
/* 198 */     if (!isEnabled()) return false;
/* 199 */     this.tempDate = getCellDate(row, column);
/* 200 */     return select(this.tempDate);
/*     */   }
/*     */   
/*     */   private boolean isInVisibleMonth(Calendar aDate) {
/* 204 */     int visibleMonth = getNextMonth(this.first.get(2));
/* 205 */     if (aDate.get(2) == visibleMonth) {} return aDate.get(1) == this.first.get(1) + (visibleMonth == 0 ? 1 : 0);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean select(Calendar aDate)
/*     */   {
/* 211 */     if (aDate == null) {
/* 212 */       return true;
/*     */     }
/* 214 */     if (!isEnabled()) return false;
/* 215 */     this.tempDate.setTime(aDate.getTime());
/* 216 */     if ((!isInVisibleMonth(this.tempDate)) && (!isAutoScroll())) {
/* 217 */       return false;
/*     */     }
/* 219 */     if (DateUtils.equals(this.tempDate, getCurrent())) {
/* 220 */       return false;
/*     */     }
/* 222 */     if (!checkConstraints(this.tempDate)) {
/* 223 */       return false;
/*     */     }
/* 225 */     getCurrent().setTime(this.tempDate.getTime());
/*     */     
/* 227 */     this.selRow = getSelectedRow();
/* 228 */     this.selCol = getSelectedColumn();
/*     */     
/* 230 */     if (!isInVisibleMonth(this.tempDate)) {
/* 231 */       initFirst();
/* 232 */       invalidate();
/*     */     }
/* 234 */     firePropertyChange("selected", null, aDate);
/* 235 */     fireCursorMove();
/* 236 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private int getDaysPassed()
/*     */   {
/* 243 */     return this.first.getActualMaximum(5) - this.first.get(5) + 1 + getCurrent().get(5);
/*     */   }
/*     */   
/*     */ 
/*     */   private int getSelectedRow()
/*     */   {
/* 249 */     return getDaysPassed() / getColsCount();
/*     */   }
/*     */   
/*     */   private int getSelectedColumn() {
/* 253 */     return getDaysPassed() % getColsCount();
/*     */   }
/*     */   
/*     */   protected void invalidate() {
/* 257 */     this.isValid = false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkConstraints(Calendar check)
/*     */   {
/* 266 */     if ((getMinConstraint() != null) && 
/* 267 */       (getMinConstraint().after(check))) {
/* 268 */       return false;
/*     */     }
/*     */     
/* 271 */     if ((getMaxConstraint() != null) && 
/* 272 */       (getMaxConstraint().before(check))) {
/* 273 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 281 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private int getDayOfWeek(int calendarConstant)
/*     */   {
/* 289 */     return calendarConstant >= getFirstWeekDay() ? calendarConstant - getFirstWeekDay() + 1 : 7 - getFirstWeekDay() + 1 + calendarConstant;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int getNextMonth(int month)
/*     */   {
/* 299 */     if (month == 11) {
/* 300 */       return 0;
/*     */     }
/* 302 */     return month + 1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void initFirst()
/*     */   {
/* 310 */     initFirst(getCurrent());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void initFirst(Calendar aDate)
/*     */   {
/* 318 */     this.first.set(aDate.get(1), aDate.get(2), 1);
/* 319 */     int cellsPassed = 0;
/*     */     
/*     */ 
/* 322 */     int firstDayOfWeek = getDayOfWeek(this.first.get(7));
/* 323 */     if (firstDayOfWeek == 1)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 329 */       cellsPassed = 7;
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/* 335 */       cellsPassed = firstDayOfWeek - 1;
/*     */     }
/* 337 */     this.first.add(5, -cellsPassed);
/*     */     
/*     */ 
/*     */ 
/* 341 */     cellsPassed += aDate.get(5);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 346 */     this.selRow = (cellsPassed / getColsCount());
/* 347 */     this.selCol = (cellsPassed - getColsCount() * this.selRow - 1);
/*     */   }
/*     */   
/*     */   private static boolean equalsYearMonth(Calendar dat1, Calendar dat2) {
/* 351 */     return (dat1.get(1) == dat2.get(1)) && (dat1.get(2) == dat2.get(2));
/*     */   }
/*     */   
/*     */   public Calendar getCurrent()
/*     */   {
/* 356 */     return this.current;
/*     */   }
/*     */   
/*     */   public void showMonthYear(int month, int year) {
/* 360 */     this.tempDate.set(year, month, 1);
/* 361 */     initFirst(this.tempDate);
/* 362 */     invalidate();
/* 363 */     firePropertyChange("year_month", null, null);
/*     */   }
/*     */   
/*     */   public Calendar getVisibleDate()
/*     */   {
/* 368 */     this.tempDate.setTime(this.first.getTime());
/* 369 */     this.tempDate.set(5, 1);
/* 370 */     this.tempDate.add(2, 1);
/* 371 */     return this.tempDate;
/*     */   }
/*     */   
/*     */   public Calendar getDefaultDate() {
/* 375 */     return this.defaultDate;
/*     */   }
/*     */   
/*     */   public void setDefaultDate(Calendar aDate) throws IncompatibleDataExeption {
/* 379 */     if (isDateForbidden(aDate)) {
/* 380 */       throw new IncompatibleDataExeption(LocaleUtils.getErrorsLocaleString("Date_forbidden"));
/*     */     }
/* 382 */     this.defaultDate.setTime(aDate.getTime());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void dateShift(int field, int shift)
/*     */   {
/* 389 */     this.tempDate.setTime(getCurrent().getTime());
/* 390 */     this.tempDate.add(field, shift);
/* 391 */     select(this.tempDate);
/*     */   }
/*     */   
/*     */   public void shift(int rowShift, int columnShift) {
/* 395 */     if ((rowShift == 0) && (columnShift == 0)) return;
/* 396 */     dateShift(5, rowShift * getColsCount() + columnShift);
/*     */   }
/*     */   
/*     */   public void monthShift(int shift) {
/* 400 */     if (shift == 0) return;
/* 401 */     dateShift(2, shift);
/*     */   }
/*     */   
/*     */   public void yearShift(int shift) {
/* 405 */     if (shift == 0) return;
/* 406 */     dateShift(1, shift);
/*     */   }
/*     */   
/*     */   public boolean isAutoScroll() {
/* 410 */     return this.autoScroll;
/*     */   }
/*     */   
/*     */   public void setAutoScroll(boolean autoScroll) {
/* 414 */     this.autoScroll = autoScroll;
/*     */   }
/*     */   
/*     */   public boolean isShowNeighbourMonth() {
/* 418 */     return this.showNeighbourMonth;
/*     */   }
/*     */   
/*     */   public void setShowNeighbourMonth(boolean showNeighbourMonth) {
/* 422 */     this.showNeighbourMonth = showNeighbourMonth;
/*     */   }
/*     */   
/*     */   public boolean isEnabled() {
/* 426 */     return this.enabled;
/*     */   }
/*     */   
/*     */   public void setEnabled(boolean enabled) {
/* 430 */     boolean oldEnabled = isEnabled();
/* 431 */     this.enabled = enabled;
/* 432 */     firePropertyChange("enabled", Boolean.valueOf(oldEnabled), Boolean.valueOf(enabled));
/*     */   }
/*     */   
/*     */   public PeriodSet getForbiddenSet() {
/* 436 */     return this.forbidden;
/*     */   }
/*     */   
/*     */   protected boolean isForbiddenDefault(PeriodSet forbiddenPeriods) {
/* 440 */     return (forbiddenPeriods != null) && (forbiddenPeriods.contains(getDefaultDate()));
/*     */   }
/*     */   
/*     */   public void setForbiddenSet(PeriodSet forbiddenPeriods) throws IncompatibleDataExeption {
/* 444 */     if (isForbiddenDefault(forbiddenPeriods)) {
/* 445 */       throw new IncompatibleDataExeption(LocaleUtils.getErrorsLocaleString("Forbidden_default"));
/*     */     }
/* 447 */     PeriodSet oldForbid = getForbiddenSet();
/* 448 */     this.forbidden.set(forbiddenPeriods);
/* 449 */     firePropertyChange("forbidDates", null, null);
/*     */   }
/*     */   
/*     */   public Iterable<Period> getForbidden() {
/* 453 */     return this.forbidden.getPeriods();
/*     */   }
/*     */   
/*     */   public void setForbidden(Iterable<Period> forbiddenPeriods) {
/* 457 */     this.forbidden.set(forbiddenPeriods);
/* 458 */     firePropertyChange("forbidDates", null, null);
/*     */   }
/*     */   
/*     */   protected boolean isPeriodForbidden(Period period) {
/* 462 */     return (this.forbidden != null) && (this.forbidden.intersects(period));
/*     */   }
/*     */   
/*     */   protected boolean isDateForbidden(Calendar date) {
/* 466 */     return (this.forbidden != null) && (this.forbidden.contains(date));
/*     */   }
/*     */   
/*     */   public Calendar getMinConstraint() {
/* 470 */     return this.minConstraint;
/*     */   }
/*     */   
/*     */   public void setMinConstraint(Calendar minConstraint) {
/* 474 */     this.minConstraint = minConstraint;
/*     */   }
/*     */   
/*     */   public Calendar getMaxConstraint() {
/* 478 */     return this.maxConstraint;
/*     */   }
/*     */   
/*     */   public void setMaxConstraint(Calendar maxConstraint) {
/* 482 */     this.maxConstraint = maxConstraint;
/*     */   }
/*     */   
/*     */   public void setSelectedDate(Calendar aDate) {
/* 486 */     select(aDate);
/* 487 */     tryApplySelection();
/*     */   }
/*     */   
/*     */   public Locale getLocale() {
/* 491 */     return this.locale;
/*     */   }
/*     */   
/*     */   public void setLocale(Locale locale) {
/* 495 */     if (locale == null) return;
/* 496 */     Locale oldLocale = getLocale();
/* 497 */     this.locale = locale;
/* 498 */     setFirstWeekDay(Calendar.getInstance(locale).getFirstDayOfWeek());
/* 499 */     initFirst();
/* 500 */     firePropertyChange("locale", oldLocale, locale);
/*     */   }
/*     */   
/*     */   private int getFirstWeekDay() {
/* 504 */     return this.firstWeekDay;
/*     */   }
/*     */   
/*     */   private void setFirstWeekDay(int firstWeekDay) {
/* 508 */     this.firstWeekDay = firstWeekDay;
/*     */   }
/*     */   
/*     */   public void commit() {
/* 512 */     fireCommit();
/*     */   }
/*     */   
/*     */   public final void tryApplySelection() {
/* 516 */     if (isLocked()) return;
/* 517 */     applySelection();
/*     */   }
/*     */   
/*     */   public boolean isLocked() {
/* 521 */     return this.locked;
/*     */   }
/*     */   
/*     */   public void setLocked(boolean locked) {
/* 525 */     this.locked = locked;
/*     */   }
/*     */   
/*     */   public void setNothingAllowed(boolean allow) {
/* 529 */     if ((isNothingSelected()) && (!allow)) return;
/* 530 */     boolean wasAllowed = isNothingAllowed();
/* 531 */     this.nothingAllowed = allow;
/* 532 */     firePropertyChange("nothingAllowed", Boolean.valueOf(wasAllowed), Boolean.valueOf(isNothingAllowed()));
/*     */   }
/*     */   
/*     */   public boolean isNothingAllowed() {
/* 536 */     return this.nothingAllowed;
/*     */   }
/*     */   
/*     */   public boolean isChangeEventsOn() {
/* 540 */     return this.changeEventsOn;
/*     */   }
/*     */   
/*     */   public void setChangeEventsOn(boolean changeEventsOn) {
/* 544 */     this.changeEventsOn = changeEventsOn;
/*     */   }
/*     */   
/*     */   public void selectNothing() {
/* 548 */     if (!isNothingAllowed()) return;
/* 549 */     applySelectNothing();
/*     */   }
/*     */   
/*     */ 
/*     */   public void addSelectionChangedListener(SelectionChangedListener listener)
/*     */   {
/* 555 */     this.listenerList.add(SelectionChangedListener.class, listener);
/*     */   }
/*     */   
/*     */   public void removeSelectionChangedListener(SelectionChangedListener listener) {
/* 559 */     this.listenerList.remove(SelectionChangedListener.class, listener);
/*     */   }
/*     */   
/*     */   public void fireSelectionChange() {
/* 563 */     SelectionChangedEvent evt = new SelectionChangedEvent(this);
/* 564 */     SelectionChangedListener[] listeners = (SelectionChangedListener[])this.listenerList.getListeners(SelectionChangedListener.class);
/*     */     
/* 566 */     for (SelectionChangedListener listener : listeners) {
/* 567 */       listener.onSelectionChange(evt);
/*     */     }
/*     */   }
/*     */   
/*     */   public void addCommitListener(CommitListener listener) {
/* 572 */     this.listenerList.add(CommitListener.class, listener);
/*     */   }
/*     */   
/*     */   public void removeCommitListener(CommitListener listener) {
/* 576 */     this.listenerList.remove(CommitListener.class, listener);
/*     */   }
/*     */   
/*     */   private void fireCommit() {
/* 580 */     CommitEvent evt = new CommitEvent(this);
/* 581 */     CommitListener[] listeners = (CommitListener[])this.listenerList.getListeners(CommitListener.class);
/*     */     
/* 583 */     for (CommitListener listener : listeners) {
/* 584 */       listener.onCommit(evt);
/*     */     }
/*     */   }
/*     */   
/*     */   public void addCursorMoveListener(CursorMoveListener listener) {
/* 589 */     this.listenerList.add(CursorMoveListener.class, listener);
/*     */   }
/*     */   
/*     */   public void removeCursorMoveListener(CursorMoveListener listener) {
/* 593 */     this.listenerList.remove(CursorMoveListener.class, listener);
/*     */   }
/*     */   
/*     */   protected void fireCursorMove() {
/* 597 */     CursorMoveEvent evt = new CursorMoveEvent(this);
/* 598 */     CursorMoveListener[] listeners = (CursorMoveListener[])this.listenerList.getListeners(CursorMoveListener.class);
/*     */     
/* 600 */     for (CursorMoveListener listener : listeners) {
/* 601 */       listener.onCursorMove(evt);
/*     */     }
/*     */   }
/*     */   
/*     */   public void addPropertyChangeListener(PropertyChangeListener listener) {
/* 606 */     this.changeSupport.addPropertyChangeListener(listener);
/*     */   }
/*     */   
/*     */   public void removePropertyChangeListener(PropertyChangeListener listener) {
/* 610 */     this.changeSupport.removePropertyChangeListener(listener);
/*     */   }
/*     */   
/*     */   public void firePropertyChange(String name, Object oldValue, Object newValue) {
/* 614 */     if (!isChangeEventsOn()) return;
/* 615 */     this.changeSupport.firePropertyChange(name, oldValue, newValue);
/*     */   }
/*     */   
/*     */   protected abstract void applySelection();
/*     */   
/*     */   protected abstract void applySelectNothing();
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/model/AbstractDateChooseModel.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */