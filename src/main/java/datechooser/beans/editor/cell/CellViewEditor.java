/*    */ package datechooser.beans.editor.cell;
/*    */ 
/*    */ import datechooser.beans.editor.VisualEditorCashed;
/*    */ import datechooser.beans.editor.descriptor.DescriptionManager;
/*    */ import datechooser.beans.locale.LocaleUtils;
/*    */ import datechooser.view.appearance.CellAppearance;
/*    */ import datechooser.view.appearance.custom.CustomCellAppearance;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.Rectangle;
/*    */ import javax.swing.JComponent;
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
/*    */ public class CellViewEditor
/*    */   extends VisualEditorCashed
/*    */ {
/*    */   public CellViewEditor() {}
/*    */   
/*    */   public String getAsText()
/*    */   {
/* 37 */     return null;
/*    */   }
/*    */   
/*    */   public boolean isPaintable() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public void paintValue(Graphics gfx, Rectangle box) {
/* 45 */     CellAppearance look = (CellAppearance)getValue();
/* 46 */     look.render((Graphics2D)gfx, new JPanel(), LocaleUtils.getEditorLocaleString("Cell_preview_text"), box.height * 2, box.height, true);
/*    */   }
/*    */   
/*    */ 
/*    */   public String getJavaInitializationString()
/*    */   {
/* 52 */     return DescriptionManager.describeJava(getValue(), CustomCellAppearance.class);
/*    */   }
/*    */   
/*    */   protected JComponent createEditor() {
/* 56 */     return new MainCellEditorPane(this);
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/cell/CellViewEditor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */