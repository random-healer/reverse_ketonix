/*     */ package datechooser.beans;
/*     */ 
/*     */ import datechooser.beans.pic.Pictures;
/*     */ import datechooser.events.CommitEvent;
/*     */ import datechooser.events.CommitListener;
/*     */ import datechooser.events.CursorMoveListener;
/*     */ import datechooser.events.SelectionChangedEvent;
/*     */ import datechooser.events.SelectionChangedListener;
/*     */ import datechooser.model.DateChoose;
/*     */ import datechooser.model.exeptions.IncompatibleDataExeption;
/*     */ import datechooser.model.multiple.DateOutputStyle;
/*     */ import datechooser.model.multiple.MultyModelBehavior;
/*     */ import datechooser.model.multiple.Period;
/*     */ import datechooser.model.multiple.PeriodSet;
/*     */ import datechooser.view.WeekDaysStyle;
/*     */ import datechooser.view.appearance.AppearancesList;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.FocusListener;
/*     */ import java.beans.PropertyChangeEvent;
/*     */ import java.beans.PropertyChangeListener;
/*     */ import java.text.DateFormat;
/*     */ import java.text.ParseException;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.GregorianCalendar;
/*     */ import java.util.Locale;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFormattedTextField;
/*     */ import javax.swing.JPopupMenu;
/*     */ import javax.swing.SwingUtilities;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.border.Border;
/*     */ import javax.swing.event.PopupMenuEvent;
/*     */ import javax.swing.event.PopupMenuListener;
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
/*     */ public class DateChooserCombo
/*     */   extends DateChooserVisual
/*     */ {
/*     */   public static final long serialVersionUID = -7510689410235869108L;
/*     */   public static final String COMBO_PREFIX = "dch_combo_";
/*     */   public static final String PROPERTY_BORDER = "dch_combo_border";
/*     */   public static final String PROPERTY_FIELD_FONT = "dch_combo_fieldFont";
/*     */   public static final String PROPERTY_DATE_FORMAT = "dch_combo_dateFormat";
/*     */   private static final int DROP_BUTTON_WIDTH = 25;
/*     */   private static final float GOLD = 0.62F;
/*     */   private DateChooserPanel chooser;
/*     */   private JPopupMenu menu;
/*     */   private JFormattedTextField field;
/*     */   private JButton bShowPopup;
/*     */   private PeriodSet selection;
/*     */   protected boolean autoEdit;
/*  85 */   private DateFormat dateFormat = null;
/*     */   
/*     */   public DateChooserCombo()
/*     */   {
/*  89 */     setAutoEdit(false);
/*     */     
/*  91 */     this.chooser = new DateChooserPanel();
/*  92 */     this.chooser.setCurrentNavigateIndex(1);
/*  93 */     this.chooser.addSelectionChangedListener(new OnSelectionChanged(null));
/*  94 */     this.chooser.addCommitListener(new CommitListener() {
/*     */       public void onCommit(CommitEvent evt) {
/*  96 */         DateChooserCombo.this.menu.setVisible(false);
/*  97 */         DateChooserCombo.this.dateToField();
/*     */       }
/*     */       
/* 100 */     });
/* 101 */     this.menu = new JPopupMenu();
/* 102 */     this.menu.add(this.chooser);
/* 103 */     this.menu.addPopupMenuListener(new PopupMenuListener() {
/*     */       public void popupMenuCanceled(PopupMenuEvent e) {
/* 105 */         DateChooserCombo.this.restoreState();
/* 106 */         DateChooserCombo.this.dateToField();
/* 107 */         DateChooserCombo.this.commit();
/*     */       }
/*     */       
/*     */       public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {}
/*     */       
/* 112 */       public void popupMenuWillBecomeVisible(PopupMenuEvent e) { DateChooserCombo.this.saveState();
/*     */       }
/*     */ 
/* 115 */     });
/* 116 */     setLayout(new BorderLayout());
/* 117 */     this.field = new JFormattedTextField();
/*     */     
/* 119 */     this.bShowPopup = new JButton(new ImageIcon(Pictures.getResource("down.gif")));
/*     */     
/* 121 */     this.bShowPopup.setPressedIcon(new ImageIcon(Pictures.getResource("down_active.gif")));
/*     */     
/* 123 */     this.bShowPopup.setPreferredSize(new Dimension(25, this.field.getPreferredSize().height));
/* 124 */     add(this.field, "Center");
/* 125 */     add(this.bShowPopup, "East");
/*     */     
/* 127 */     setPreferredSize(new Dimension((int)(this.chooser.getPreferredSize().width * 0.62F), this.field.getPreferredSize().height));
/*     */     
/*     */ 
/*     */ 
/* 131 */     this.bShowPopup.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 133 */         DateChooserCombo.this.showDropDown();
/*     */       }
/*     */       
/*     */ 
/* 137 */     });
/* 138 */     dateToField();
/* 139 */     testEditability();
/*     */     
/* 141 */     this.field.addFocusListener(new FocusListener() {
/*     */       public void focusGained(FocusEvent e) {}
/*     */       
/*     */       public void focusLost(FocusEvent e) {
/* 145 */         if (!DateChooserCombo.this.isEditable()) return;
/* 146 */         DateChooserCombo.this.fieldToDate();
/*     */       }
/*     */       
/* 149 */     });
/* 150 */     UIManager.addPropertyChangeListener(new PropertyChangeListener() {
/*     */       public void propertyChange(PropertyChangeEvent evt) {
/* 152 */         SwingUtilities.updateComponentTreeUI(DateChooserCombo.this.getComboPanel());
/* 153 */         SwingUtilities.updateComponentTreeUI(DateChooserCombo.this.menu);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   private DateChooserCombo getComboPanel() {
/* 159 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBorder(Border border)
/*     */   {
/* 167 */     Border oldBorder = getBorder();
/* 168 */     super.setBorder(border);
/* 169 */     firePropertyChange("dch_combo_border", oldBorder, getBorder());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getText()
/*     */   {
/* 179 */     return this.field.getText();
/*     */   }
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
/*     */   public boolean setText(String text)
/*     */   {
/* 200 */     if (!isEditable()) return false;
/* 201 */     if ((text == null) || (text.equals(""))) {
/* 202 */       this.chooser.getModel().selectNothing();
/* 203 */       this.field.setText("");
/* 204 */       return true;
/*     */     }
/* 206 */     this.field.setText(text);
/* 207 */     return fieldToDate();
/*     */   }
/*     */   
/*     */   private void showDropDown() {
/* 211 */     if (!isEnabled()) return;
/* 212 */     this.menu.show(getParent(), getX(), getY() + getHeight());
/*     */   }
/*     */   
/*     */   private void saveState() {
/* 216 */     this.selection = ((PeriodSet)this.chooser.getSelectedPeriodSet().clone());
/*     */   }
/*     */   
/*     */   private void restoreState() {
/* 220 */     this.chooser.setSelection(this.selection);
/*     */   }
/*     */   
/*     */   public Dimension getCalendarPreferredSize() {
/* 224 */     return this.chooser.getCalendarPreferredSize();
/*     */   }
/*     */   
/*     */   public void setCalendarPreferredSize(Dimension dim) {
/* 228 */     this.chooser.setCalendarPreferredSize(dim);
/* 229 */     this.menu.revalidate();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Font getFieldFont()
/*     */   {
/* 237 */     return this.field.getFont();
/*     */   }
/*     */   
/*     */ 
/*     */   public void setFieldFont(Font font)
/*     */   {
/* 243 */     Font oldFont = getFieldFont();
/* 244 */     this.field.setFont(font);
/* 245 */     firePropertyChange("dch_combo_fieldFont", oldFont, getFieldFont());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getFormat()
/*     */   {
/* 254 */     return DateOutputStyle.getFormat();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFormat(int format)
/*     */   {
/* 261 */     int oldFormat = getFormat();
/* 262 */     DateOutputStyle.setFormat(format);
/* 263 */     dateToField();
/* 264 */     firePropertyChange("dch_combo_dateFormat", oldFormat, getFormat());
/*     */   }
/*     */   
/*     */   public MultyModelBehavior getBehavior() {
/* 268 */     return this.chooser.getBehavior();
/*     */   }
/*     */   
/*     */   public AppearancesList getCurrentView() {
/* 272 */     return this.chooser.getCurrentView();
/*     */   }
/*     */   
/*     */   public PeriodSet getDefaultPeriods() {
/* 276 */     return this.chooser.getDefaultPeriods();
/*     */   }
/*     */   
/*     */   public PeriodSet getForbiddenPeriods() {
/* 280 */     return this.chooser.getForbiddenPeriods();
/*     */   }
/*     */   
/*     */   public Calendar getMaxDate() {
/* 284 */     return this.chooser.getMaxDate();
/*     */   }
/*     */   
/*     */   public Calendar getMinDate() {
/* 288 */     return this.chooser.getMinDate();
/*     */   }
/*     */   
/*     */   public Calendar getSelectedDate() {
/* 292 */     return this.chooser.getSelectedDate();
/*     */   }
/*     */   
/*     */   public PeriodSet getSelectedPeriodSet() {
/* 296 */     return this.chooser.getSelectedPeriodSet();
/*     */   }
/*     */   
/*     */   public Iterable<Period> getSelection() {
/* 300 */     return this.chooser.getSelection();
/*     */   }
/*     */   
/*     */   public boolean isAutoScroll() {
/* 304 */     return this.chooser.isAutoScroll();
/*     */   }
/*     */   
/*     */   public boolean isShowOneMonth() {
/* 308 */     return this.chooser.isShowOneMonth();
/*     */   }
/*     */   
/*     */   public void setAutoScroll(boolean autoScroll) {
/* 312 */     this.chooser.setAutoScroll(autoScroll);
/*     */   }
/*     */   
/*     */   private void testEditability() {
/* 316 */     this.field.setEditable(isEditable());
/*     */   }
/*     */   
/*     */   private boolean isEditable() {
/* 320 */     return getBehavior().equals(MultyModelBehavior.SELECT_SINGLE);
/*     */   }
/*     */   
/*     */   public void setBehavior(MultyModelBehavior behavior) {
/* 324 */     this.chooser.setBehavior(behavior);
/* 325 */     testEditability();
/*     */   }
/*     */   
/*     */   public void setCurrentView(AppearancesList aList) {
/* 329 */     this.chooser.setCurrentView(aList);
/*     */   }
/*     */   
/*     */   public void setDefaultPeriods(PeriodSet periods) throws IncompatibleDataExeption {
/* 333 */     this.chooser.setDefaultPeriods(periods);
/* 334 */     dateToField();
/*     */   }
/*     */   
/*     */   public void setEnabled(boolean enabled) {
/* 338 */     super.setEnabled(enabled);
/* 339 */     this.chooser.setEnabled(enabled);
/* 340 */     this.field.setEnabled(enabled);
/* 341 */     this.bShowPopup.setEnabled(enabled);
/*     */   }
/*     */   
/*     */   public void setForbidden(Iterable<Period> forbiddenPeriods) {
/* 345 */     this.chooser.setForbidden(forbiddenPeriods);
/*     */   }
/*     */   
/*     */   public void setForbiddenPeriods(PeriodSet periods) throws IncompatibleDataExeption {
/* 349 */     this.chooser.setForbiddenPeriods(periods);
/*     */   }
/*     */   
/*     */   public void setMaxDate(Calendar aDate) {
/* 353 */     this.chooser.setMaxDate(aDate);
/*     */   }
/*     */   
/*     */   public void setMinDate(Calendar aDate) {
/* 357 */     this.chooser.setMinDate(aDate);
/*     */   }
/*     */   
/*     */   public void setSelectedDate(Calendar aDate) {
/* 361 */     this.chooser.setSelectedDate(aDate);
/* 362 */     dateToField();
/*     */   }
/*     */   
/*     */   public void setSelection(Iterable<Period> periods) {
/* 366 */     this.chooser.setSelection(periods);
/* 367 */     dateToField();
/*     */   }
/*     */   
/*     */   public void setSelection(PeriodSet periods) {
/* 371 */     this.chooser.setSelection(periods);
/* 372 */     dateToField();
/*     */   }
/*     */   
/*     */   public void setShowOneMonth(boolean showOneMonth) {
/* 376 */     this.chooser.setShowOneMonth(showOneMonth);
/*     */   }
/*     */   
/*     */   public Font getNavigateFont() {
/* 380 */     return this.chooser.getNavigateFont();
/*     */   }
/*     */   
/*     */   public void setNavigateFont(Font font) {
/* 384 */     this.chooser.setNavigateFont(font);
/*     */   }
/*     */   
/*     */   public void setLocale(Locale locale) {
/* 388 */     super.setLocale(locale);
/* 389 */     this.chooser.setLocale(locale);
/* 390 */     DateOutputStyle.setLocale(locale);
/* 391 */     dateToField();
/*     */   }
/*     */   
/*     */   public int getCurrentNavigateIndex() {
/* 395 */     return this.chooser.getCurrentNavigateIndex();
/*     */   }
/*     */   
/*     */   public void setCurrentNavigateIndex(int currentNavigateIndex) {
/* 399 */     if (currentNavigateIndex != 1)
/*     */     {
/*     */ 
/* 402 */       return;
/*     */     }
/* 404 */     this.chooser.setCurrentNavigateIndex(currentNavigateIndex);
/*     */   }
/*     */   
/*     */   private void dateToField() {
/* 408 */     setAutoEdit(true);
/* 409 */     this.field.setText(this.chooser.getSelectedPeriodSet().toString(getDateFormat()));
/* 410 */     setAutoEdit(false);
/*     */   }
/*     */   
/*     */   private boolean fieldToDate() {
/* 414 */     if (isAutoEdit()) return true;
/*     */     try {
/* 416 */       Date dat = getDateFormat().parse(this.field.getText().trim());
/* 417 */       Calendar newDat = new GregorianCalendar();
/* 418 */       newDat.setTime(dat);
/* 419 */       setSelectedDate(newDat);
/*     */     } catch (ParseException ex) {
/* 421 */       dateToField();
/* 422 */       return false;
/*     */     }
/* 424 */     return true;
/*     */   }
/*     */   
/*     */   private class OnSelectionChanged implements SelectionChangedListener { private OnSelectionChanged() {}
/*     */     
/* 429 */     public void onSelectionChange(SelectionChangedEvent evt) { DateChooserCombo.this.dateToField(); }
/*     */   }
/*     */   
/*     */   public void addCommitListener(CommitListener listener)
/*     */   {
/* 434 */     this.chooser.addCommitListener(listener);
/*     */   }
/*     */   
/*     */   public void removeCommitListener(CommitListener listener) {
/* 438 */     this.chooser.removeCommitListener(listener);
/*     */   }
/*     */   
/*     */   public void addSelectionChangedListener(SelectionChangedListener listener) {
/* 442 */     this.chooser.addSelectionChangedListener(listener);
/*     */   }
/*     */   
/*     */   public void removeSelectionChangedListener(SelectionChangedListener listener) {
/* 446 */     this.chooser.removeSelectionChangedListener(listener);
/*     */   }
/*     */   
/*     */   public void commit() {
/* 450 */     this.chooser.commit();
/*     */   }
/*     */   
/*     */   private boolean isAutoEdit() {
/* 454 */     return this.autoEdit;
/*     */   }
/*     */   
/*     */   private void setAutoEdit(boolean autoEdit) {
/* 458 */     this.autoEdit = autoEdit;
/*     */   }
/*     */   
/*     */   public boolean isLocked() {
/* 462 */     return this.chooser.isLocked();
/*     */   }
/*     */   
/*     */   public void setLocked(boolean lock) {
/* 466 */     this.chooser.setLocked(lock);
/*     */   }
/*     */   
/*     */   public WeekDaysStyle getWeekStyle() {
/* 470 */     return this.chooser.getWeekStyle();
/*     */   }
/*     */   
/*     */   public void setWeekStyle(WeekDaysStyle weekStyle) {
/* 474 */     this.chooser.setWeekStyle(weekStyle);
/*     */   }
/*     */   
/*     */   public void addCursorMoveListener(CursorMoveListener listener) {
/* 478 */     this.chooser.addCursorMoveListener(listener);
/*     */   }
/*     */   
/*     */   public void removeCursorMoveListener(CursorMoveListener listener) {
/* 482 */     this.chooser.removeCursorMoveListener(listener);
/*     */   }
/*     */   
/*     */   public Calendar getCurrent() {
/* 486 */     return this.chooser.getCurrent();
/*     */   }
/*     */   
/*     */   public boolean setCurrent(Calendar aDate) {
/* 490 */     return this.chooser.setCurrent(aDate);
/*     */   }
/*     */   
/*     */   public void setNothingAllowed(boolean allow) {
/* 494 */     this.chooser.setNothingAllowed(allow);
/*     */   }
/*     */   
/*     */   public boolean isNothingAllowed() {
/* 498 */     return this.chooser.isNothingAllowed();
/*     */   }
/*     */   
/*     */   public Color getCalendarBackground() {
/* 502 */     return this.chooser.getCalendarBackground();
/*     */   }
/*     */   
/*     */   public void setCalendarBackground(Color backColor) {
/* 506 */     this.chooser.setCalendarBackground(backColor);
/*     */   }
/*     */   
/*     */   public AppearancesList getAppearancesList() {
/* 510 */     return this.chooser.getAppearancesList();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public DateFormat getDateFormat()
/*     */   {
/* 522 */     if (this.dateFormat != null) return this.dateFormat;
/* 523 */     DateFormat fmt = DateFormat.getDateInstance(getFormat(), getLocale());
/* 524 */     return fmt;
/*     */   }
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
/*     */   public void setDateFormat(DateFormat dateFormat)
/*     */   {
/* 538 */     this.dateFormat = dateFormat;
/* 539 */     dateToField();
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/DateChooserCombo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */