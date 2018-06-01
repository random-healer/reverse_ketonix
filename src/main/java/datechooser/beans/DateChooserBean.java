package datechooser.beans;

import datechooser.events.CommitListener;
import datechooser.events.CursorMoveListener;
import datechooser.events.SelectionChangedListener;
import datechooser.model.exeptions.IncompatibleDataExeption;
import datechooser.model.multiple.MultyModelBehavior;
import datechooser.model.multiple.Period;
import datechooser.model.multiple.PeriodSet;
import datechooser.view.WeekDaysStyle;
import datechooser.view.appearance.AppearancesList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Calendar;
import java.util.Locale;

public abstract interface DateChooserBean
{
  public static final String PREFIX = "dch_";
  public static final String PROPERTY_AUTOSCROLL = "dch_autoScroll";
  public static final String PROPERTY_BEHAVIOR = "dch_behavior";
  public static final String PROPERTY_CURRENT = "dch_current";
  public static final String PROPERTY_DEFAULT_DATES = "dch_defaultDates";
  public static final String PROPERTY_ENABLED = "dch_enabled";
  public static final String PROPERTY_FORBID_DATES = "dch_forbidDates";
  public static final String PROPERTY_LOCKED = "dch_locked";
  public static final String PROPERTY_MAX_DATE = "dch_maxDate";
  public static final String PROPERTY_MIN_DATE = "dch_minDate";
  public static final String PROPERTY_NOTHING_ALLOWED = "dch_nothingAllowed";
  public static final String PROPERTY_ONE_MONTH = "dch_oneMonth";
  public static final String PROPERTY_NAVIG_FONT = "dch_navFont";
  public static final String PROPERTY_VIEW = "dch_view";
  public static final String PROPERTY_LOCALE = "dch_locale";
  public static final String PROPERTY_NAVIG_PANE = "dch_navigPane";
  public static final String PROPERTY_WEEK_STYLE = "dch_weekDayStyle";
  public static final String PROPERTY_BACK_COLOR = "dch_backgroundColor";
  public static final String PROPERTY_CALENDAR_SIZE = "dch_calSize";
  
  public abstract MultyModelBehavior getBehavior();
  
  public abstract void setBehavior(MultyModelBehavior paramMultyModelBehavior);
  
  public abstract AppearancesList getCurrentView();
  
  public abstract void setCurrentView(AppearancesList paramAppearancesList);
  
  public abstract PeriodSet getDefaultPeriods();
  
  public abstract void setDefaultPeriods(PeriodSet paramPeriodSet)
    throws IncompatibleDataExeption;
  
  public abstract PeriodSet getForbiddenPeriods();
  
  public abstract void setForbiddenPeriods(PeriodSet paramPeriodSet)
    throws IncompatibleDataExeption;
  
  public abstract void setForbidden(Iterable<Period> paramIterable)
    throws IncompatibleDataExeption;
  
  public abstract Calendar getMaxDate();
  
  public abstract void setMaxDate(Calendar paramCalendar);
  
  public abstract Calendar getMinDate();
  
  public abstract void setMinDate(Calendar paramCalendar);
  
  public abstract Calendar getSelectedDate();
  
  public abstract void setSelectedDate(Calendar paramCalendar);
  
  public abstract PeriodSet getSelectedPeriodSet();
  
  public abstract void setSelection(PeriodSet paramPeriodSet);
  
  public abstract Iterable<Period> getSelection();
  
  public abstract void setSelection(Iterable<Period> paramIterable);
  
  public abstract boolean isAutoScroll();
  
  public abstract void setAutoScroll(boolean paramBoolean);
  
  public abstract boolean isEnabled();
  
  public abstract void setEnabled(boolean paramBoolean);
  
  public abstract boolean isLocked();
  
  public abstract void setLocked(boolean paramBoolean);
  
  public abstract boolean isShowOneMonth();
  
  public abstract void setShowOneMonth(boolean paramBoolean);
  
  public abstract WeekDaysStyle getWeekStyle();
  
  public abstract void setWeekStyle(WeekDaysStyle paramWeekDaysStyle);
  
  public abstract Font getNavigateFont();
  
  public abstract void setNavigateFont(Font paramFont);
  
  public abstract Locale getLocale();
  
  public abstract void setLocale(Locale paramLocale);
  
  public abstract int getCurrentNavigateIndex();
  
  public abstract void setCurrentNavigateIndex(int paramInt);
  
  public abstract Color getCalendarBackground();
  
  public abstract void setCalendarBackground(Color paramColor);
  
  public abstract Dimension getCalendarPreferredSize();
  
  public abstract void setCalendarPreferredSize(Dimension paramDimension);
  
  public abstract Calendar getCurrent();
  
  public abstract boolean setCurrent(Calendar paramCalendar);
  
  public abstract void setNothingAllowed(boolean paramBoolean);
  
  public abstract boolean isNothingAllowed();
  
  public abstract AppearancesList getAppearancesList();
  
  public abstract void commit();
  
  public abstract void addCommitListener(CommitListener paramCommitListener);
  
  public abstract void removeCommitListener(CommitListener paramCommitListener);
  
  public abstract void addSelectionChangedListener(SelectionChangedListener paramSelectionChangedListener);
  
  public abstract void removeSelectionChangedListener(SelectionChangedListener paramSelectionChangedListener);
  
  public abstract void addCursorMoveListener(CursorMoveListener paramCursorMoveListener);
  
  public abstract void removeCursorMoveListener(CursorMoveListener paramCursorMoveListener);
  
  public abstract DateChooserBean clone();
}


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/DateChooserBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */