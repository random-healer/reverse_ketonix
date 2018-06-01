/*    */ package datechooser.beans.editor.cell;
/*    */ 
/*    */ import java.awt.GridLayout;
/*    */ import javax.swing.BorderFactory;
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
/*    */ class SwingCellEditorPane
/*    */   extends CellEditorPane
/*    */ {
/*    */   public SwingCellEditorPane(MainCellEditorPane parentEditor)
/*    */   {
/* 24 */     super(parentEditor);
/*    */   }
/*    */   
/*    */   protected void generateInterface() {
/* 28 */     setLayout(new GridLayout(1, 3, 5, 5));
/* 29 */     add(createFontChooseButton());
/* 30 */     add(createTextColorChooseButton());
/* 31 */     add(createCursorColorChooseButton());
/* 32 */     setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
/*    */   }
/*    */   
/*    */   protected void updateEditorState() {}
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/cell/SwingCellEditorPane.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */