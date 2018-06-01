/*    */ package datechooser.beans.editor.border.types;
/*    */ 
/*    */ import datechooser.beans.editor.utils.InsetsPanel;
/*    */ import datechooser.beans.locale.LocaleUtils;
/*    */ import java.awt.Insets;
/*    */ import java.beans.PropertyChangeEvent;
/*    */ import java.beans.PropertyChangeListener;
/*    */ import javax.swing.border.Border;
/*    */ import javax.swing.border.EmptyBorder;
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
/*    */ public class EmptyBorderEditor
/*    */   extends AbstractBorderEditor
/*    */   implements PropertyChangeListener
/*    */ {
/*    */   private Insets insets;
/*    */   private InsetsPanel insetsPane;
/*    */   
/*    */   public EmptyBorderEditor()
/*    */   {
/* 32 */     initialize();
/* 33 */     setCaption(LocaleUtils.getEditorLocaleString("Empty"));
/* 34 */     this.insetsPane = new InsetsPanel(this.insets);
/* 35 */     this.insetsPane.addPropertyChangeListener(this);
/* 36 */     add(this.insetsPane);
/* 37 */     refreshInterface();
/*    */   }
/*    */   
/*    */   public void prepareSelection() {
/* 41 */     setValue(new EmptyBorder(this.insets));
/*    */   }
/*    */   
/*    */   protected EmptyBorder getValue() {
/* 45 */     return (EmptyBorder)this.value;
/*    */   }
/*    */   
/*    */   public void refreshInterface() {
/* 49 */     Insets currIns = getValue().getBorderInsets();
/* 50 */     this.insets.set(currIns.top, currIns.left, currIns.bottom, currIns.right);
/* 51 */     this.insetsPane.refresh();
/*    */   }
/*    */   
/*    */   protected Border getDefaultValue() {
/* 55 */     this.insets = new Insets(1, 1, 1, 1);
/* 56 */     return new EmptyBorder(this.insets);
/*    */   }
/*    */   
/*    */   public void propertyChange(PropertyChangeEvent evt) {
/* 60 */     if (!"insets".equals(evt.getPropertyName())) return;
/* 61 */     fireChange();
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/border/types/EmptyBorderEditor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */