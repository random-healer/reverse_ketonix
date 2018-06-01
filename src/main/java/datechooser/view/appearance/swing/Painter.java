package datechooser.view.appearance.swing;

import datechooser.view.appearance.CellAttributes;
import java.awt.Component;
import java.awt.Graphics2D;
import java.io.Serializable;
import javax.swing.border.Border;

public abstract interface Painter
  extends Serializable, CellAttributes, Cloneable
{
  public abstract Object clone();
  
  public abstract void updateUI();
  
  public abstract void setSize(int paramInt1, int paramInt2);
  
  public abstract void paint(Graphics2D paramGraphics2D);
  
  public abstract void setPressed(boolean paramBoolean);
  
  public abstract void setEnabled(boolean paramBoolean);
  
  public abstract void setText(String paramString);
  
  public abstract Border getBorder();
  
  public abstract Component getComponent(Component paramComponent);
}


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/view/appearance/swing/Painter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */