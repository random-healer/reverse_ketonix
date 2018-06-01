/*    */ package datechooser.beans.editor.font;
/*    */ 
/*    */ import datechooser.beans.editor.VisualEditorCashed;
/*    */ import datechooser.beans.editor.descriptor.DescriptionManager;
/*    */ import java.awt.Font;
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
/*    */ public class SimpleFontEditor
/*    */   extends VisualEditorCashed
/*    */ {
/*    */   public SimpleFontEditor() {}
/*    */   
/* 25 */   private Font outFont = new Font("Dialog", 0, 10);
/*    */   
/*    */   public String getAsText() {
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
/* 41 */     return DescriptionManager.describeJava(getValue(), Font.class);
/*    */   }
/*    */   
/*    */   protected JComponent createEditor() {
/* 45 */     return new FontEditorPane(this);
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/font/SimpleFontEditor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */