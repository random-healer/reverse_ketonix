/*    */ package datechooser.autorun;
/*    */ 
/*    */ import datechooser.beans.locale.LocaleUtils;
/*    */ import java.beans.IntrospectionException;
/*    */ import javax.swing.JOptionPane;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Configurator
/*    */   implements Runnable
/*    */ {
/* 14 */   private ConfigWindow configWindow = null;
/*    */   
/*    */ 
/*    */   public Configurator() {}
/*    */   
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/* 22 */     Configurator instance = new Configurator();
/* 23 */     instance.start(true);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void start(boolean showLogo)
/*    */   {
/* 33 */     LocaleUtils.reset();
/* 34 */     Logo logo = null;
/* 35 */     if (showLogo) {
/* 36 */       logo = new Logo();
/* 37 */       logo.setVisible(true);
/*    */     }
/* 39 */     Thread starter = new Thread(this);
/* 40 */     starter.start();
/* 41 */     while (starter.isAlive()) {
/* 42 */       try { Thread.currentThread();Thread.sleep(1000L);
/*    */       } catch (InterruptedException ex) {
/* 44 */         JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
/* 45 */         return;
/*    */       }
/*    */     }
/* 48 */     this.configWindow.setVisible(true);
/* 49 */     if (showLogo) {
/* 50 */       logo.setVisible(false);
/* 51 */       logo.dispose();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void run()
/*    */   {
/*    */     try
/*    */     {
/* 62 */       this.configWindow = new ConfigWindow();
/*    */     } catch (IntrospectionException ex) {
/* 64 */       JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/autorun/Configurator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */