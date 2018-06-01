/*    */ package datechooser.autorun;
/*    */ 
/*    */ import datechooser.beans.DateChooserCombo;
/*    */ import datechooser.beans.DateChooserComboCustomizer;
/*    */ import java.awt.FlowLayout;
/*    */ import java.awt.GridLayout;
/*    */ import java.beans.IntrospectionException;
/*    */ import javax.swing.BorderFactory;
/*    */ import javax.swing.JComponent;
/*    */ import javax.swing.JPanel;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ConfigCombo
/*    */   extends ConfigBean
/*    */ {
/*    */   public ConfigCombo()
/*    */     throws IntrospectionException
/*    */   {
/* 25 */     super(new DateChooserCombo(), new DateChooserComboCustomizer());
/* 26 */     initializeInterface();
/*    */   }
/*    */   
/*    */   private void initializeInterface() {
/* 30 */     setLayout(new GridLayout(1, 2, 2, 2));
/* 31 */     JPanel beanCell = new JPanel(new FlowLayout(1));
/* 32 */     beanCell.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(), BorderFactory.createEmptyBorder(20, 2, 2, 2)));
/*    */     
/*    */ 
/* 35 */     beanCell.add((JComponent)getBean());
/* 36 */     add(beanCell);
/* 37 */     add(getCustomizer());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public String getFileExt()
/*    */   {
/* 46 */     return "dchc";
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/autorun/ConfigCombo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */