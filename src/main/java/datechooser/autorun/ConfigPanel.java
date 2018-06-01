/*    */ package datechooser.autorun;
/*    */ 
/*    */ import datechooser.beans.DateChooserPanel;
/*    */ import datechooser.beans.DateChooserPanelCustomizer;
/*    */ import java.awt.GridLayout;
/*    */ import java.beans.IntrospectionException;
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
/*    */ public class ConfigPanel
/*    */   extends ConfigBean
/*    */ {
/*    */   public ConfigPanel()
/*    */     throws IntrospectionException
/*    */   {
/* 25 */     super(new DateChooserPanel(), new DateChooserPanelCustomizer());
/* 26 */     initializeInterface();
/*    */   }
/*    */   
/*    */   private void initializeInterface() {
/* 30 */     setLayout(new GridLayout(1, 2, 2, 2));
/* 31 */     add((JComponent)getBean());
/* 32 */     add(getCustomizer());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public String getFileExt()
/*    */   {
/* 41 */     return "dchp";
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/autorun/ConfigPanel.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */