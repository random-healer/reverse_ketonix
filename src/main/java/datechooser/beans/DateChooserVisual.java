/*    */ package datechooser.beans;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import javax.swing.JPanel;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class DateChooserVisual
/*    */   extends JPanel
/*    */   implements DateChooserBean, Serializable
/*    */ {
/*    */   public DateChooserVisual() {}
/*    */   
/*    */   public static BeanTableCellEditor createTableCellEditor(DateChooserVisual bean)
/*    */   {
/* 31 */     return new BeanTableCellEditor(bean.clone());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static BeanTableCellRenderer createTableCellRenderer(DateChooserVisual bean)
/*    */   {
/* 42 */     return new BeanTableCellRenderer(bean.clone());
/*    */   }
/*    */   
/*    */   public DateChooserVisual clone() {
/* 46 */     return (DateChooserVisual)BeanUtils.cloneBean(this);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public BeanTableCellRenderer createTableCellRenderer()
/*    */   {
/* 58 */     return createTableCellRenderer(this);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public BeanTableCellEditor createTableCellEditor()
/*    */   {
/* 70 */     return createTableCellEditor(this);
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/DateChooserVisual.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */