/*    */ package datechooser.beans.editor.locale;
/*    */ 
/*    */ import datechooser.beans.editor.VisualEditorCashed;
/*    */ import datechooser.beans.editor.descriptor.DescriptionManager;
/*    */ import java.awt.Font;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Rectangle;
/*    */ import java.util.Locale;
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
/*    */ public class LocaleEditor
/*    */   extends VisualEditorCashed
/*    */ {
/*    */   public LocaleEditor() {}
/*    */   
/*    */   public String getAsText()
/*    */   {
/* 26 */     return null;
/*    */   }
/*    */   
/*    */   public void paintValue(Graphics gfx, Rectangle box) {
/* 30 */     int wasSize = gfx.getFont().getSize();
/* 31 */     gfx.setFont(new Font("Serif", 0, wasSize));
/* 32 */     gfx.drawString(DescriptionManager.describe(getValue()), box.x, box.y + box.height - 3);
/*    */   }
/*    */   
/*    */   public boolean isPaintable()
/*    */   {
/* 37 */     return true;
/*    */   }
/*    */   
/*    */   public String getJavaInitializationString() {
/* 41 */     return DescriptionManager.describeJava(getValue(), Locale.class);
/*    */   }
/*    */   
/*    */   protected JComponent createEditor() {
/* 45 */     return new LocaleEditorPane(this);
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/locale/LocaleEditor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */