/*    */ package datechooser.beans.editor.utils;
/*    */ 
/*    */ import java.awt.FlowLayout;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JSpinner;
/*    */ import javax.swing.SpinnerModel;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SpinPane
/*    */   extends JPanel
/*    */ {
/*    */   public SpinPane(SpinnerModel model, String caption)
/*    */   {
/* 21 */     setLayout(new FlowLayout(1));
/* 22 */     add(new JLabel(caption));
/* 23 */     add(new JSpinner(model));
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/utils/SpinPane.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */