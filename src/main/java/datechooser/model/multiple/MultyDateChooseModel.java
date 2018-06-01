/*     */ package datechooser.model.multiple;
/*     */ 
/*     */ import datechooser.beans.locale.LocaleUtils;
/*     */ import datechooser.model.AbstractDateChooseModel;
/*     */ import datechooser.model.CellState;
/*     */ import datechooser.model.DaysGrid;
/*     */ import datechooser.model.exeptions.IncompatibleDataExeption;
/*     */ import java.util.Calendar;
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
/*     */ public class MultyDateChooseModel
/*     */   extends AbstractDateChooseModel
/*     */   implements MultyDateChoose
/*     */ {
/*     */   private PeriodSet selection;
/*     */   private PeriodSet defaultPeriods;
/*     */   private MultySelectModes mode;
/*     */   private Calendar previous;
/*     */   private MultyModelBehavior behavior;
/*     */   private boolean add;
/*     */   private boolean periodSelectionStarted;
/*     */   
/*     */   public MultyDateChooseModel(Calendar current)
/*     */   {
/*  44 */     super(current, DaysGrid.getRowsCount(), DaysGrid.getColsCount());
/*  45 */     setAdd(false);
/*  46 */     setBehavior(MultyModelBehavior.SELECT_ALL);
/*  47 */     setPeriodSelectionStarted(false);
/*     */     
/*  49 */     this.selection = new PeriodSet();
/*  50 */     this.defaultPeriods = new PeriodSet();
/*  51 */     this.defaultPeriods.add(super.getDefaultDate());
/*     */     
/*  53 */     this.selection.add(new Period(getCurrent()));
/*     */     
/*  55 */     this.previous = ((Calendar)current.clone());
/*  56 */     this.mode = MultySelectModes.SINGLE;
/*     */   }
/*     */   
/*     */   public boolean isSelected(Calendar aDate) {
/*  60 */     return this.selection.contains(aDate);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Calendar getSelectedDate()
/*     */   {
/*  69 */     if (isNothingSelected()) return null;
/*  70 */     return getCurrent();
/*     */   }
/*     */   
/*     */   public void reset() {
/*  74 */     this.selection.clear();
/*     */   }
/*     */   
/*     */   public Iterable<Calendar> getSelectedDates() {
/*  78 */     return this.selection.getDates();
/*     */   }
/*     */   
/*     */   public Iterable<Period> getSelectedPeriods() {
/*  82 */     return this.selection.getPeriods();
/*     */   }
/*     */   
/*     */   public PeriodSet getSelectedPeriodSet() {
/*  86 */     return this.selection;
/*     */   }
/*     */   
/*     */   public void setSelectedPeriods(Iterable<Period> newSelection) {
/*  90 */     reset();
/*  91 */     if (newSelection != null) {
/*  92 */       this.selection.set(newSelection);
/*  93 */       select(this.selection.getFirstDate());
/*     */     }
/*  95 */     firePropertyChange("selected", null, null);
/*     */   }
/*     */   
/*     */   public void setSelectedPeriods(PeriodSet newSelection) {
/*  99 */     reset();
/* 100 */     if (newSelection != null) {
/* 101 */       this.selection.set(newSelection);
/* 102 */       select(this.selection.getFirstDate());
/*     */     }
/* 104 */     firePropertyChange("selected", null, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Period getSelectedPeriod()
/*     */   {
/* 113 */     return this.selection.getLastAddedPeriod();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void addPeriod(Period aPeriod)
/*     */   {
/* 122 */     if (isPeriodForbidden(aPeriod)) {
/* 123 */       return;
/*     */     }
/* 125 */     this.selection.add(aPeriod);
/*     */   }
/*     */   
/*     */   public void setMode(MultySelectModes mode, boolean add) {
/* 129 */     switch (getBehavior()) {
/*     */     case SELECT_SINGLE: 
/* 131 */       this.mode = MultySelectModes.SINGLE;
/* 132 */       setAdd(false);
/* 133 */       return;
/*     */     case SELECT_PERIOD: 
/* 135 */       this.mode = mode;
/* 136 */       setAdd(false);
/* 137 */       return;
/*     */     case SELECT_ALL: 
/* 139 */       this.mode = mode;
/* 140 */       setAdd(add);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isAdd()
/*     */   {
/* 146 */     return this.add;
/*     */   }
/*     */   
/*     */   public void setAdd(boolean add) {
/* 150 */     this.add = add;
/*     */   }
/*     */   
/*     */   public boolean isPeriodSelectionStarted() {
/* 154 */     return this.periodSelectionStarted;
/*     */   }
/*     */   
/*     */   public void setPeriodSelectionStarted(boolean periodSelectionStarted) {
/* 158 */     this.periodSelectionStarted = periodSelectionStarted;
/*     */   }
/*     */   
/*     */   protected void applySelection() {
/* 162 */     if (isDateForbidden(getCurrent())) {
/* 163 */       return;
/*     */     }
/* 165 */     if ((!isAdd()) && (!isPeriodSelectionStarted())) {
/* 166 */       reset();
/*     */     }
/* 168 */     switch (this.mode) {
/*     */     case SINGLE: 
/* 170 */       addPeriod(new Period(getCurrent()));
/* 171 */       break;
/*     */     case PERIOD: 
/* 173 */       setPeriodSelectionStarted(true);
/* 174 */       addPeriod(new Period(this.previous, getCurrent()));
/*     */     }
/*     */     
/* 177 */     this.previous.setTime(getCurrent().getTime());
/* 178 */     firePropertyChange("selected", null, null);
/* 179 */     fireSelectionChange();
/* 180 */     if (getBehavior().equals(MultyModelBehavior.SELECT_SINGLE)) {
/* 181 */       commit();
/*     */     }
/*     */   }
/*     */   
/*     */   public void setBehavior(MultyModelBehavior behavior) {
/* 186 */     this.behavior = behavior;
/* 187 */     if ((behavior == MultyModelBehavior.SELECT_SINGLE) && 
/* 188 */       (!getSelection().isSingleDate())) {
/* 189 */       selectOneDate(getSelection().getFirstDate());
/* 190 */       firePropertyChange("behavior", null, null);
/*     */     }
/*     */   }
/*     */   
/*     */   public MultyModelBehavior getBehavior()
/*     */   {
/* 196 */     return this.behavior;
/*     */   }
/*     */   
/*     */   public PeriodSet getDefaultPeriodSet() {
/* 200 */     return this.defaultPeriods;
/*     */   }
/*     */   
/*     */   public void setDefaultPeriodSet(PeriodSet periodSet) throws IncompatibleDataExeption {
/* 204 */     if (isPeriodSetForbidden(periodSet)) {
/* 205 */       throw new IncompatibleDataExeption(LocaleUtils.getErrorsLocaleString("Periods_forbidden"));
/*     */     }
/* 207 */     this.defaultPeriods.set(periodSet);
/* 208 */     setSelectedPeriods(this.defaultPeriods);
/* 209 */     firePropertyChange("defaultDates", null, null);
/*     */   }
/*     */   
/*     */   protected boolean isPeriodSetForbidden(PeriodSet periods) {
/* 213 */     for (Period period : periods.getPeriods()) {
/* 214 */       if (isPeriodForbidden(period)) return true;
/*     */     }
/* 216 */     return false;
/*     */   }
/*     */   
/*     */   public Calendar getDefaultDate() {
/* 220 */     return this.defaultPeriods.getCount() > 0 ? this.defaultPeriods.getFirstDate() : null;
/*     */   }
/*     */   
/*     */   public Iterable<Period> getDefaultPeriods() {
/* 224 */     return this.defaultPeriods.getPeriods();
/*     */   }
/*     */   
/*     */   public void setDefaultPeriods(Iterable<Period> newPeriods) throws IncompatibleDataExeption {
/* 228 */     this.defaultPeriods.clear();
/* 229 */     if (newPeriods != null) {
/* 230 */       this.defaultPeriods.set(newPeriods);
/* 231 */       Calendar defDate = this.defaultPeriods.getFirstDate();
/* 232 */       if (defDate != null) {
/* 233 */         setDefaultDate(defDate);
/* 234 */         select(defDate);
/*     */       }
/* 236 */       if (getBehavior() == MultyModelBehavior.SELECT_SINGLE) {
/* 237 */         selectOneDate(defDate);
/*     */       } else {
/* 239 */         setSelectedPeriods(newPeriods);
/*     */       }
/*     */     }
/* 242 */     firePropertyChange("defaultDates", null, null);
/*     */   }
/*     */   
/*     */   private void selectOneDate(Calendar aDate) {
/* 246 */     reset();
/* 247 */     addPeriod(new Period(aDate));
/* 248 */     firePropertyChange("selected", null, null);
/*     */   }
/*     */   
/*     */   public CellState getCellState(int row, int column) {
/* 252 */     CellState cellState = super.getCellState(row, column);
/* 253 */     if ((cellState == CellState.NORMAL) && 
/* 254 */       (this.defaultPeriods != null) && 
/* 255 */       (this.defaultPeriods.contains(getCellDate(row, column)))) {
/* 256 */       return CellState.NOW;
/*     */     }
/*     */     
/*     */ 
/* 260 */     return cellState;
/*     */   }
/*     */   
/*     */   protected void selectColumn(int column) {}
/*     */   
/*     */   public MultySelectModes getMode()
/*     */   {
/* 267 */     return this.mode;
/*     */   }
/*     */   
/*     */   protected PeriodSet getSelection() {
/* 271 */     return this.selection;
/*     */   }
/*     */   
/*     */   public void applySelectNothing() {
/* 275 */     reset();
/* 276 */     firePropertyChange("selected", null, null);
/* 277 */     fireSelectionChange();
/* 278 */     commit();
/*     */   }
/*     */   
/*     */   protected boolean isForbiddenDefault(PeriodSet forbiddenPeriods) {
/* 282 */     return getDefaultPeriodSet().intersects(forbiddenPeriods);
/*     */   }
/*     */   
/*     */   public boolean isNothingSelected() {
/* 286 */     if (this.selection == null) return true;
/* 287 */     return this.selection.isEmpty();
/*     */   }
/*     */   
/*     */   public void setNothingSelected(boolean nothingSelected) {
/* 291 */     if ((!isNothingAllowed()) && (nothingSelected)) return;
/* 292 */     if (nothingSelected) reset();
/*     */   }
/*     */   
/*     */   private boolean isTouchesSomeSelected(Period period) {
/* 296 */     return this.selection.near(period);
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/model/multiple/MultyDateChooseModel.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */