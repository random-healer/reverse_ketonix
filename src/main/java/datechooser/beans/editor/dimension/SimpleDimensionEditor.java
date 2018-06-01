/*    */ package datechooser.beans.editor.dimension;
/*    */ 
/*    */ import datechooser.beans.editor.VisualEditorCashed;
/*    */ import java.awt.Dimension;
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
/*    */ public class SimpleDimensionEditor
/*    */   extends VisualEditorCashed
/*    */ {
/*    */   public SimpleDimensionEditor() {}
/*    */   
/*    */   public String getAsText()
/*    */   {
/* 24 */     return getDimension().width + " x " + getDimension().height;
/*    */   }
/*    */   
/*    */   public String getJavaInitializationString() {
/* 28 */     return "new " + Dimension.class.getName() + "(" + getDimension().width + ", " + getDimension().height + ")";
/*    */   }
/*    */   
/*    */   public Dimension getDimension()
/*    */   {
/* 33 */     return (Dimension)getValue();
/*    */   }
/*    */   
/*    */   protected JComponent createEditor() {
/* 37 */     return new SimpleDimensionEditorPane(this);
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/dimension/SimpleDimensionEditor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */