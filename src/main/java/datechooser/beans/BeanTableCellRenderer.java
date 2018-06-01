/*    */ package datechooser.beans;
/*    */ 
/*    */ import datechooser.model.multiple.PeriodSet;
/*    */ import java.awt.Color;
/*    */ import java.awt.Component;
/*    */ import java.util.Calendar;
/*    */ import javax.swing.BorderFactory;
/*    */ import javax.swing.JTable;
/*    */ import javax.swing.border.Border;
/*    */ import javax.swing.table.TableCellRenderer;
/*    */ 
/*    */ 
/*    */ class BeanTableCellRenderer
/*    */   implements TableCellRenderer, BeanTableCell
/*    */ {
/*    */   private boolean useCalendarForSingleDate;
/*    */   private DateChooserVisual bean;
/*    */   private boolean commitLocked;
/*    */   private Border selectBorder;
/*    */   private Border focusBorder;
/*    */   private Border emptyBorder;
/*    */   
/*    */   public BeanTableCellRenderer(DateChooserVisual bean)
/*    */   {
/* 25 */     setUseCalendarForSingleDate(true);
/* 26 */     this.bean = bean;
/* 27 */     this.selectBorder = BorderFactory.createLineBorder(Color.BLUE, 1);
/* 28 */     this.focusBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
/* 29 */     this.emptyBorder = BorderFactory.createEmptyBorder(1, 1, 1, 1);
/*    */   }
/*    */   
/*    */   public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
/* 33 */     this.bean.setBorder(this.emptyBorder);
/* 34 */     if (isSelected) {
/* 35 */       this.bean.setBorder(this.selectBorder);
/*    */     }
/* 37 */     if (hasFocus) {
/* 38 */       this.bean.setBorder(this.focusBorder);
/*    */     }
/* 40 */     if ((value instanceof Calendar)) {
/* 41 */       Calendar cval = (Calendar)value;
/* 42 */       this.bean.setSelectedDate(cval);
/* 43 */     } else if ((value instanceof PeriodSet)) {
/* 44 */       PeriodSet pval = (PeriodSet)value;
/* 45 */       this.bean.setSelection(pval);
/*    */     }
/* 47 */     return this.bean;
/*    */   }
/*    */   
/*    */   public boolean isUseCalendarForSingleDate() {
/* 51 */     return this.useCalendarForSingleDate;
/*    */   }
/*    */   
/*    */   public void setUseCalendarForSingleDate(boolean useCalendarForSingleDate) {
/* 55 */     this.useCalendarForSingleDate = useCalendarForSingleDate;
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/BeanTableCellRenderer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */