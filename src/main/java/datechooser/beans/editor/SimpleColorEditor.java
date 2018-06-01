/*    */ package datechooser.beans.editor;
/*    */ 
/*    */ import datechooser.beans.editor.descriptor.DescriptionManager;
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Rectangle;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ import javax.swing.JColorChooser;
/*    */ import javax.swing.JComponent;
/*    */ import javax.swing.colorchooser.ColorSelectionModel;
/*    */ import javax.swing.event.ChangeEvent;
/*    */ import javax.swing.event.ChangeListener;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SimpleColorEditor
/*    */   extends VisualEditorCashed
/*    */   implements ColorSelectionModel
/*    */ {
/*    */   private Set<ChangeListener> changeListeners;
/*    */   
/*    */   public SimpleColorEditor() {}
/*    */   
/*    */   protected JComponent createEditor()
/*    */   {
/* 31 */     this.changeListeners = new HashSet();
/* 32 */     JColorChooser editorPane = new JColorChooser(this);
/* 33 */     return editorPane;
/*    */   }
/*    */   
/*    */   public Color getSelectedColor() {
/* 37 */     return (Color)getValue();
/*    */   }
/*    */   
/*    */   public void setSelectedColor(Color color) {
/* 41 */     setValue(color);
/* 42 */     fireStateChange();
/*    */   }
/*    */   
/*    */   public void addChangeListener(ChangeListener listener) {
/* 46 */     this.changeListeners.add(listener);
/*    */   }
/*    */   
/*    */   public void removeChangeListener(ChangeListener listener) {
/* 50 */     this.changeListeners.remove(listener);
/*    */   }
/*    */   
/*    */   public void fireStateChange() {
/* 54 */     ChangeEvent e = new ChangeEvent(this);
/* 55 */     for (ChangeListener listener : this.changeListeners) {
/* 56 */       listener.stateChanged(e);
/*    */     }
/*    */   }
/*    */   
/*    */   public String getJavaInitializationString() {
/* 61 */     return DescriptionManager.describeJava(getValue(), Color.class);
/*    */   }
/*    */   
/*    */   public boolean isPaintable() {
/* 65 */     return true;
/*    */   }
/*    */   
/*    */   public void paintValue(Graphics gfx, Rectangle box) {
/* 69 */     Color color = (Color)getValue();
/* 70 */     gfx.setColor(color);
/* 71 */     gfx.fillRect(2, 2, box.height - 4, box.height - 4);
/* 72 */     gfx.setColor(Color.BLACK);
/* 73 */     gfx.drawRect(2, 2, box.height - 4, box.height - 4);
/* 74 */     gfx.drawString("[" + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() + "]", box.height + 2, box.height - 4);
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/SimpleColorEditor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */