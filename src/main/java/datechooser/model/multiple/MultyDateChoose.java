package datechooser.model.multiple;

import datechooser.model.DateChoose;
import java.util.Calendar;

public abstract interface MultyDateChoose
  extends DateChoose
{
  public abstract void reset();
  
  public abstract void setMode(MultySelectModes paramMultySelectModes, boolean paramBoolean);
  
  public abstract Iterable<Calendar> getSelectedDates();
  
  public abstract Iterable<Period> getSelectedPeriods();
  
  public abstract void setAdd(boolean paramBoolean);
  
  public abstract void setPeriodSelectionStarted(boolean paramBoolean);
  
  public abstract MultyModelBehavior getBehavior();
  
  public abstract void setBehavior(MultyModelBehavior paramMultyModelBehavior);
  
  public abstract PeriodSet getSelectedPeriodSet();
}


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/model/multiple/MultyDateChoose.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */