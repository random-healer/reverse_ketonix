package datechooser.events;

import java.util.EventListener;

public abstract interface SelectionChangedListener
  extends EventListener
{
  public abstract void onSelectionChange(SelectionChangedEvent paramSelectionChangedEvent);
}


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/events/SelectionChangedListener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */