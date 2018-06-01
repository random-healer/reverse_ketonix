/*    */ package datechooser.model.single;
/*    */ 
/*    */ import datechooser.model.AbstractDateChooseModel;
/*    */ import datechooser.model.DateUtils;
/*    */ import datechooser.model.DaysGrid;
/*    */ import java.util.Calendar;
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
/*    */ public class SingleDateChooseModel
/*    */   extends AbstractDateChooseModel
/*    */   implements SingleDateChoose
/*    */ {
/*    */   private Calendar selected;
/*    */   private boolean nothingSelected;
/*    */   
/*    */   public SingleDateChooseModel(Calendar current)
/*    */   {
/* 29 */     super(current, DaysGrid.getRowsCount(), DaysGrid.getColsCount());
/* 30 */     this.selected = ((Calendar)getCurrent().clone());
/* 31 */     setNothingSelected(false);
/*    */   }
/*    */   
/*    */   public boolean isSelected(Calendar date) {
/* 35 */     if (isNothingSelected()) return false;
/* 36 */     if (DateUtils.equals(date, this.selected)) {
/* 37 */       return true;
/*    */     }
/* 39 */     return false;
/*    */   }
/*    */   
/*    */   public Calendar getSelectedDate() {
/* 43 */     if (isNothingSelected()) return null;
/* 44 */     return getCurrent();
/*    */   }
/*    */   
/*    */   protected void applySelection() {
/* 48 */     if (isDateForbidden(getCurrent())) {
/* 49 */       return;
/*    */     }
/* 51 */     this.selected.setTime(getCurrent().getTime());
/* 52 */     setNothingSelected(false);
/* 53 */     firePropertyChange("selected", null, this.selected);
/* 54 */     fireSelectionChange();
/* 55 */     commit();
/*    */   }
/*    */   
/*    */   protected void selectColumn(int column) {}
/*    */   
/*    */   public void applySelectNothing()
/*    */   {
/* 62 */     boolean wasNothing = isNothingSelected();
/* 63 */     setNothingSelected(true);
/* 64 */     firePropertyChange("nothing", Boolean.valueOf(wasNothing), Boolean.valueOf(true));
/* 65 */     fireSelectionChange();
/* 66 */     commit();
/*    */   }
/*    */   
/*    */   public boolean isNothingSelected() {
/* 70 */     return this.nothingSelected;
/*    */   }
/*    */   
/*    */   public void setNothingSelected(boolean nothingSelected) {
/* 74 */     if ((!isNothingAllowed()) && (nothingSelected)) return;
/* 75 */     this.nothingSelected = nothingSelected;
/*    */   }
/*    */   
/*    */   protected void refreshIncompatibility() {}
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/model/single/SingleDateChooseModel.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */