/*    */ package datechooser.beans.customizer.render;
/*    */ 
/*    */ import datechooser.beans.customizer.PropertyDescriptorsHolder;
/*    */ import java.awt.Component;
/*    */ import java.beans.PropertyDescriptor;
/*    */ import java.beans.PropertyEditorSupport;
/*    */ import javax.swing.JTable;
/*    */ import javax.swing.table.TableCellRenderer;
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
/*    */ public abstract class CellRenderer
/*    */   implements TableCellRenderer
/*    */ {
/*    */   private PropertyDescriptorsHolder holder;
/*    */   
/*    */   public CellRenderer(PropertyDescriptorsHolder holder)
/*    */   {
/* 29 */     this.holder = holder;
/*    */   }
/*    */   
/*    */   public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
/*    */   {
/* 34 */     String property = (String)value;
/* 35 */     return getRenderer(this.holder.getPropertydescriptor(property), this.holder.getPropertyEditor(property), table, isSelected, hasFocus);
/*    */   }
/*    */   
/*    */   protected abstract Component getRenderer(PropertyDescriptor paramPropertyDescriptor, PropertyEditorSupport paramPropertyEditorSupport, JTable paramJTable, boolean paramBoolean1, boolean paramBoolean2);
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/customizer/render/CellRenderer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */