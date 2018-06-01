/*    */ package datechooser.beans.customizer;
/*    */ 
/*    */ import datechooser.beans.customizer.render.CaptionCellRenderer;
/*    */ import datechooser.beans.customizer.render.ValueCellRenderer;
/*    */ import datechooser.beans.locale.LocaleUtils;
/*    */ import java.beans.PropertyDescriptor;
/*    */ import javax.swing.table.DefaultTableModel;
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
/*    */ public class PropertyTableModel
/*    */   extends DefaultTableModel
/*    */ {
/*    */   private PropertyDescriptorsHolder holder;
/*    */   
/*    */   public PropertyTableModel(PropertyDescriptorsHolder holder)
/*    */   {
/* 28 */     super(holder.getPropertyCount(), 2);
/* 29 */     this.holder = holder;
/*    */   }
/*    */   
/*    */   public Object getValueAt(int row, int column) {
/* 33 */     return this.holder.getPropertyDescriptors()[row].getName();
/*    */   }
/*    */   
/*    */   public boolean isCellEditable(int row, int column) {
/* 37 */     return column == 1;
/*    */   }
/*    */   
/*    */   public Class<?> getColumnClass(int columnIndex) {
/* 41 */     switch (columnIndex) {
/* 42 */     case 0:  return CaptionCellRenderer.class;
/* 43 */     case 1:  return ValueCellRenderer.class; }
/* 44 */     return CaptionCellRenderer.class;
/*    */   }
/*    */   
/*    */   public String getColumnName(int column)
/*    */   {
/* 49 */     switch (column) {
/* 50 */     case 0:  return LocaleUtils.getEditorLocaleString("property");
/* 51 */     case 1:  return LocaleUtils.getEditorLocaleString("value"); }
/* 52 */     return "?? (" + column + ')';
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/customizer/PropertyTableModel.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */