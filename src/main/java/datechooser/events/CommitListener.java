package datechooser.events;

import java.util.EventListener;

public abstract interface CommitListener
  extends EventListener
{
  public abstract void onCommit(CommitEvent paramCommitEvent);
}


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/events/CommitListener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */