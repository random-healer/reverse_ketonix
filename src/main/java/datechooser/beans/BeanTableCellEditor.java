/*    */ package datechooser.beans;
/*    */ 
/*    */ import datechooser.events.CommitEvent;
/*    */ import datechooser.events.CommitListener;
/*    */ import datechooser.model.multiple.MultyModelBehavior;
/*    */ import java.awt.Component;
/*    */ import javax.swing.AbstractCellEditor;
/*    */ import javax.swing.JTable;
/*    */ import javax.swing.table.TableCellEditor;
/*    */ 
/*    */ 
/*    */ class BeanTableCellEditor
/*    */   extends AbstractCellEditor
/*    */   implements TableCellEditor, BeanTableCell
/*    */ {
/*    */   private DateChooserVisual bean;
/*    */   private boolean commitLocked;
/*    */   private BeanTableCellRenderer renderer;
/*    */   
/*    */   public BeanTableCellEditor(DateChooserVisual bean)
/*    */   {
/* 22 */     setCommitLocked(false);
/* 23 */     this.renderer = new BeanTableCellRenderer(bean);
/* 24 */     this.bean = bean;
/* 25 */     bean.addCommitListener(new CommitListener() {
/*    */       public void onCommit(CommitEvent evt) {
/* 27 */         if (!BeanTableCellEditor.this.isCommitLocked()) BeanTableCellEditor.this.stopCellEditing();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
/* 33 */     return this.renderer.getTableCellRendererComponent(table, value, isSelected, true, row, column);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public Object getCellEditorValue()
/*    */   {
/* 41 */     if ((this.bean.getBehavior() == MultyModelBehavior.SELECT_SINGLE) && (isUseCalendarForSingleDate())) {
/* 42 */       return this.bean.getSelectedDate();
/*    */     }
/* 44 */     return this.bean.getSelectedPeriodSet();
/*    */   }
/*    */   
/*    */   public boolean isCommitLocked() {
/* 48 */     return this.commitLocked;
/*    */   }
/*    */   
/*    */   public void setCommitLocked(boolean commitLocked) {
/* 52 */     this.commitLocked = commitLocked;
/*    */   }
/*    */   
/*    */   public boolean isUseCalendarForSingleDate() {
/* 56 */     return this.renderer.isUseCalendarForSingleDate();
/*    */   }
/*    */   
/*    */   public void setUseCalendarForSingleDate(boolean useCalendarForSingleDate) {
/* 60 */     this.renderer.setUseCalendarForSingleDate(useCalendarForSingleDate);
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/BeanTableCellEditor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */