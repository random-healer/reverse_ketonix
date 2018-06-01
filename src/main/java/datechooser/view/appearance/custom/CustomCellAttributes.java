package datechooser.view.appearance.custom;

import datechooser.view.appearance.CellAttributes;
import java.awt.Color;
import javax.swing.border.Border;

public abstract interface CustomCellAttributes
  extends CellAttributes
{
  public abstract Color getBackgroundColor();
  
  public abstract Border getCellBorder();
  
  public abstract void setBackgroundColor(Color paramColor);
  
  public abstract void setCellBorder(Border paramBorder);
}


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/view/appearance/custom/CustomCellAttributes.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */