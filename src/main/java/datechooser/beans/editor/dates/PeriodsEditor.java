/*    */ package datechooser.beans.editor.dates;
/*    */ 
/*    */ import datechooser.beans.editor.VisualEditorCashed;
/*    */ import datechooser.beans.editor.descriptor.DescriptionManager;
/*    */ import datechooser.model.multiple.PeriodSet;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Rectangle;
/*    */ import javax.swing.JComponent;
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
/*    */ public class PeriodsEditor
/*    */   extends VisualEditorCashed
/*    */ {
/*    */   public PeriodsEditor() {}
/*    */   
/*    */   public String getAsText()
/*    */   {
/* 30 */     return null;
/*    */   }
/*    */   
/*    */   public boolean isPaintable() {
/* 34 */     return true;
/*    */   }
/*    */   
/*    */   public void paintValue(Graphics gfx, Rectangle box) {
/* 38 */     gfx.drawString(DescriptionManager.describe(getValue()), box.x, box.y + box.height - 3);
/*    */   }
/*    */   
/*    */   public String getJavaInitializationString()
/*    */   {
/* 43 */     return DescriptionManager.describeJava(getValue(), PeriodSet.class);
/*    */   }
/*    */   
/*    */   protected JComponent createEditor() {
/* 47 */     return new PeriodsEditorPane(this);
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/dates/PeriodsEditor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */