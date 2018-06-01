package datechooser.view.appearance;

import java.awt.Color;
import java.awt.Font;

public abstract interface CellAttributes
{
  public abstract Font getFont();
  
  public abstract Color getTextColor();
  
  public abstract void setFont(Font paramFont);
  
  public abstract void setTextColor(Color paramColor);
  
  public abstract void assign(CellAppearance paramCellAppearance);
}


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/view/appearance/CellAttributes.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */