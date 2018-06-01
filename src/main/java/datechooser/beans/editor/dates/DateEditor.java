/*    */ package datechooser.beans.editor.dates;
/*    */ 
/*    */ import datechooser.beans.editor.VisualEditorCashed;
/*    */ import datechooser.beans.editor.descriptor.DescriptionManager;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Rectangle;
/*    */ import java.util.GregorianCalendar;
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
/*    */ public class DateEditor
/*    */   extends VisualEditorCashed
/*    */ {
/*    */   public DateEditor() {}
/*    */   
/*    */   public String getAsText()
/*    */   {
/* 28 */     return null;
/*    */   }
/*    */   
/*    */   public boolean isPaintable() {
/* 32 */     return true;
/*    */   }
/*    */   
/*    */   public void paintValue(Graphics gfx, Rectangle box) {
/* 36 */     gfx.drawString(DescriptionManager.describe(getValue()), box.x, box.y + box.height - 3);
/*    */   }
/*    */   
/*    */   public String getJavaInitializationString()
/*    */   {
/* 41 */     return DescriptionManager.describeJava(getValue(), GregorianCalendar.class);
/*    */   }
/*    */   
/*    */   protected JComponent createEditor() {
/* 45 */     return new DateEditorPane(this);
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/dates/DateEditor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */