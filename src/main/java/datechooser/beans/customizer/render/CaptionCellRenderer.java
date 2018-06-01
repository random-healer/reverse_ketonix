/*    */ package datechooser.beans.customizer.render;
/*    */ 
/*    */ import datechooser.beans.customizer.PropertyDescriptorsHolder;
/*    */ import java.awt.Component;
/*    */ import java.beans.PropertyDescriptor;
/*    */ import java.beans.PropertyEditorSupport;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JTable;
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
/*    */ public class CaptionCellRenderer
/*    */   extends CellRenderer
/*    */ {
/*    */   private JLabel renderer;
/*    */   
/*    */   public CaptionCellRenderer(PropertyDescriptorsHolder holder)
/*    */   {
/* 26 */     super(holder);
/* 27 */     this.renderer = new JLabel();
/* 28 */     this.renderer.setOpaque(true);
/*    */   }
/*    */   
/*    */ 
/*    */   protected Component getRenderer(PropertyDescriptor propertyDescriptor, PropertyEditorSupport propertyEditorSupport, JTable table, boolean isSelected, boolean hasFocus)
/*    */   {
/* 34 */     String name = propertyDescriptor.getDisplayName();
/* 35 */     if (name == null) name = propertyDescriptor.getName();
/* 36 */     this.renderer.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
/* 37 */     this.renderer.setForeground(isSelected ? table.getSelectionForeground() : table.getForeground());
/* 38 */     this.renderer.setFont(table.getFont());
/* 39 */     this.renderer.setText(name);
/* 40 */     return this.renderer;
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/customizer/render/CaptionCellRenderer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */