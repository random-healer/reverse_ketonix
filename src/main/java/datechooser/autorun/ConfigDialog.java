/*    */ package datechooser.autorun;
/*    */ 
/*    */ import datechooser.beans.DateChooserDialog;
/*    */ import datechooser.beans.DateChooserDialogCustomizer;
/*    */ import java.awt.FlowLayout;
/*    */ import java.awt.GridLayout;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import java.beans.IntrospectionException;
/*    */ import javax.swing.BorderFactory;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JPanel;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ConfigDialog
/*    */   extends ConfigBean
/*    */ {
/*    */   public ConfigDialog()
/*    */     throws IntrospectionException
/*    */   {
/* 26 */     super(new DateChooserDialog(), new DateChooserDialogCustomizer());
/* 27 */     initializeInterface();
/*    */   }
/*    */   
/*    */   private void initializeInterface() {
/* 31 */     setLayout(new GridLayout(1, 2, 2, 2));
/* 32 */     JPanel beanCell = new JPanel(new FlowLayout(1));
/* 33 */     beanCell.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(), BorderFactory.createEmptyBorder(20, 2, 2, 2)));
/*    */     
/*    */ 
/* 36 */     JButton showDialog = new JButton(getBeanDisplayName());
/* 37 */     showDialog.addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/* 39 */         ((DateChooserDialog)ConfigDialog.this.getBean()).showDialog(null);
/*    */       }
/* 41 */     });
/* 42 */     beanCell.add(showDialog);
/* 43 */     add(beanCell);
/* 44 */     add(getCustomizer());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public String getFileExt()
/*    */   {
/* 53 */     return "dchd";
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/autorun/ConfigDialog.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */