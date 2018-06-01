/*    */ package datechooser.beans.editor.border;
/*    */ 
/*    */ import datechooser.beans.editor.VisualEditorCashed;
/*    */ import datechooser.beans.editor.descriptor.DescriptionManager;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Rectangle;
/*    */ import javax.swing.JComponent;
/*    */ import javax.swing.border.Border;
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
/*    */ public class SimpleBorderEditor
/*    */   extends VisualEditorCashed
/*    */ {
/*    */   public SimpleBorderEditor() {}
/*    */   
/*    */   public String getAsText()
/*    */   {
/* 26 */     return null;
/*    */   }
/*    */   
/*    */   public boolean isPaintable() {
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public void paintValue(Graphics gfx, Rectangle box) {
/* 34 */     gfx.drawString(DescriptionManager.describe(getValue()), box.x, box.y + box.height - 3);
/*    */   }
/*    */   
/*    */   public String getJavaInitializationString()
/*    */   {
/* 39 */     return DescriptionManager.describeJava(getValue(), Border.class);
/*    */   }
/*    */   
/*    */   protected JComponent createEditor() {
/* 43 */     return new BorderEditorPane(this);
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/border/SimpleBorderEditor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */