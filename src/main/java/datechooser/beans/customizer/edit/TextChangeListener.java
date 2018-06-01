/*    */ package datechooser.beans.customizer.edit;
/*    */ 
/*    */ import javax.swing.event.DocumentEvent;
/*    */ import javax.swing.event.DocumentListener;
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
/*    */ public abstract class TextChangeListener
/*    */   implements DocumentListener
/*    */ {
/*    */   public TextChangeListener() {}
/*    */   
/*    */   public void insertUpdate(DocumentEvent e)
/*    */   {
/* 22 */     textChanged(e);
/*    */   }
/*    */   
/*    */   public void removeUpdate(DocumentEvent e) {
/* 26 */     textChanged(e);
/*    */   }
/*    */   
/*    */   public void changedUpdate(DocumentEvent e) {}
/*    */   
/*    */   public abstract void textChanged(DocumentEvent paramDocumentEvent);
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/customizer/edit/TextChangeListener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */