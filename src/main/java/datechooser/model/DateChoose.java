package datechooser.model;

import datechooser.events.CommitListener;
import datechooser.events.CursorMoveListener;
import datechooser.events.SelectionChangedListener;
import datechooser.model.exeptions.IncompatibleDataExeption;
import datechooser.model.multiple.Period;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Locale;

public abstract interface DateChoose
  extends Serializable
{
  public abstract int getRowsCount();
  
  public abstract int getColsCount();
  
  public abstract CellState getCellState(int paramInt1, int paramInt2);
  
  public abstract String getCellCaption(int paramInt1, int paramInt2);
  
  public abstract Calendar getCellDate(int paramInt1, int paramInt2);
  
  public abstract void setConstraints(Calendar paramCalendar1, Calendar paramCalendar2);
  
  public abstract boolean needsFullValidation();
  
  public abstract boolean select(int paramInt1, int paramInt2);
  
  public abstract boolean isSelected(Calendar paramCalendar);
  
  public abstract Calendar getSelectedDate();
  
  public abstract void setSelectedDate(Calendar paramCalendar);
  
  public abstract void showMonthYear(int paramInt1, int paramInt2);
  
  public abstract Calendar getVisibleDate();
  
  public abstract Calendar getDefaultDate();
  
  public abstract void setDefaultDate(Calendar paramCalendar)
    throws IncompatibleDataExeption;
  
  public abstract void shift(int paramInt1, int paramInt2);
  
  public abstract void tryApplySelection();
  
  public abstract void selectNothing();
  
  public abstract boolean isCursor(int paramInt1, int paramInt2);
  
  public abstract void monthShift(int paramInt);
  
  public abstract void yearShift(int paramInt);
  
  public abstract boolean isShowNeighbourMonth();
  
  public abstract void setShowNeighbourMonth(boolean paramBoolean);
  
  public abstract boolean isEnabled();
  
  public abstract void setEnabled(boolean paramBoolean);
  
  public abstract Iterable<Period> getForbidden();
  
  public abstract void setForbidden(Iterable<Period> paramIterable);
  
  public abstract Calendar getMaxConstraint();
  
  public abstract Calendar getMinConstraint();
  
  public abstract void setMaxConstraint(Calendar paramCalendar);
  
  public abstract void setMinConstraint(Calendar paramCalendar);
  
  public abstract Locale getLocale();
  
  public abstract void setLocale(Locale paramLocale);
  
  public abstract void fireSelectionChange();
  
  public abstract void commit();
  
  public abstract boolean isAutoScroll();
  
  public abstract void setAutoScroll(boolean paramBoolean);
  
  public abstract boolean isLocked();
  
  public abstract void setLocked(boolean paramBoolean);
  
  public abstract boolean isNothingSelected();
  
  public abstract void setNothingSelected(boolean paramBoolean);
  
  public abstract Calendar getCurrent();
  
  public abstract boolean select(Calendar paramCalendar);
  
  public abstract void setNothingAllowed(boolean paramBoolean);
  
  public abstract boolean isNothingAllowed();
  
  public abstract void addPropertyChangeListener(PropertyChangeListener paramPropertyChangeListener);
  
  public abstract void removePropertyChangeListener(PropertyChangeListener paramPropertyChangeListener);
  
  public abstract void addCursorMoveListener(CursorMoveListener paramCursorMoveListener);
  
  public abstract void removeCursorMoveListener(CursorMoveListener paramCursorMoveListener);
  
  public abstract void addSelectionChangedListener(SelectionChangedListener paramSelectionChangedListener);
  
  public abstract void removeSelectionChangedListener(SelectionChangedListener paramSelectionChangedListener);
  
  public abstract void addCommitListener(CommitListener paramCommitListener);
  
  public abstract void removeCommitListener(CommitListener paramCommitListener);
}


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/model/DateChoose.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */