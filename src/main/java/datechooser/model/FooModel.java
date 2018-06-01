/*    */ package datechooser.model;
/*    */ 
/*    */ import java.util.Calendar;
/*    */ import java.util.GregorianCalendar;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FooModel
/*    */   extends AbstractDateChooseModel
/*    */ {
/*    */   private static final int CAPTION = 5;
/* 24 */   private int selRow = -1;
/* 25 */   private int selColumn = -1;
/*    */   
/*    */   public FooModel() {
/* 28 */     super(new GregorianCalendar(1982, 7, 26), DaysGrid.getRowsCount(), DaysGrid.getColsCount());
/*    */     
/* 30 */     setConstraints(new GregorianCalendar(1982, 7, 10), null);
/*    */   }
/*    */   
/*    */   public boolean isSelected(Calendar aDate) {
/* 34 */     int day = aDate.get(5);
/* 35 */     if ((day >= 15) && (day <= 18)) {
/* 36 */       return true;
/*    */     }
/* 38 */     return false;
/*    */   }
/*    */   
/*    */   public Calendar getSelectedDate()
/*    */   {
/* 43 */     return null;
/*    */   }
/*    */   
/*    */   protected void applySelection() {}
/*    */   
/*    */   public boolean isCursor(int row, int column)
/*    */   {
/* 50 */     if (isSomeSelected()) {
/* 51 */       return (row == this.selRow) && (column == this.selColumn);
/*    */     }
/* 53 */     return row - column == 1;
/*    */   }
/*    */   
/*    */   public boolean select(int row, int column)
/*    */   {
/* 58 */     this.selRow = row;
/* 59 */     this.selColumn = column;
/* 60 */     firePropertyChange("selected", null, null);
/* 61 */     fireCursorMove();
/* 62 */     return true;
/*    */   }
/*    */   
/*    */   public boolean isSomeSelected() {
/* 66 */     return (this.selRow >= 0) && (this.selColumn >= 0);
/*    */   }
/*    */   
/*    */   public CellState getSelectedCellState() {
/* 70 */     if (!isSomeSelected()) {
/* 71 */       return CellState.NORMAL;
/*    */     }
/* 73 */     return getCellState(this.selRow, this.selColumn);
/*    */   }
/*    */   
/*    */   public void setTypeSelected(int typeIndex) {
/* 77 */     if (typeIndex >= 5) {
/* 78 */       select(-1, -1);
/*    */     } else {
/* 80 */       select(1 + typeIndex, typeIndex);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   protected void selectColumn(int column) {}
/*    */   
/*    */ 
/*    */   public void applySelectNothing() {}
/*    */   
/*    */ 
/*    */   protected void refreshIncompatibility() {}
/*    */   
/*    */ 
/*    */   public boolean isNothingSelected()
/*    */   {
/* 96 */     return false;
/*    */   }
/*    */   
/*    */   public void setNothingSelected(boolean nothingSelected) {}
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/model/FooModel.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */