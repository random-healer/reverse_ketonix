/*    */ package datechooser.autorun;
/*    */ 
/*    */ import datechooser.beans.locale.LocaleUtils;
/*    */ import datechooser.beans.pic.Pictures;
/*    */ import java.awt.BorderLayout;
/*    */ import java.awt.Container;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Toolkit;
/*    */ import javax.swing.BorderFactory;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JProgressBar;
/*    */ import javax.swing.JWindow;
/*    */ 
/*    */ public class Logo
/*    */   extends JWindow
/*    */ {
/*    */   private static final int WIDTH = 300;
/*    */   private static final int HEIGHT = 150;
/*    */   private static final int FONT_SIZE = 16;
/*    */   
/*    */   public Logo()
/*    */   {
/* 25 */     generateInterface();
/* 26 */     setCentered();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static JLabel createInfoLabel()
/*    */   {
/* 34 */     return createInfoLabel(true);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static JLabel createInfoLabel(boolean text)
/*    */   {
/* 45 */     JLabel info = new JLabel();
/* 46 */     info.setIcon(new ImageIcon(Pictures.getResource("logo_small.gif")));
/* 47 */     if (text) {
/* 48 */       info.setText("<html>" + LocaleUtils.getConfigLocaleString("ProjectName") + "<br> (c)" + LocaleUtils.getConfigLocaleString("Author"));
/*    */     }
/*    */     else
/*    */     {
/* 52 */       info.setHorizontalAlignment(0);
/*    */     }
/* 54 */     info.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(), BorderFactory.createEmptyBorder(2, 2, 2, 2)));
/*    */     
/*    */ 
/* 57 */     return info;
/*    */   }
/*    */   
/*    */   private void generateInterface() {
/* 61 */     JPanel mainPane = new JPanel(new BorderLayout(5, 5));
/* 62 */     mainPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
/*    */     
/* 64 */     JLabel info = createInfoLabel();
/*    */     
/* 66 */     JProgressBar progres = new JProgressBar();
/* 67 */     progres.setIndeterminate(true);
/* 68 */     progres.setStringPainted(false);
/*    */     
/* 70 */     mainPane.add(info, "Center");
/* 71 */     mainPane.add(progres, "South");
/*    */     
/* 73 */     getContentPane().add(mainPane);
/*    */   }
/*    */   
/*    */   private void setCentered() {
/* 77 */     setSize(300, 150);
/* 78 */     Toolkit kit = Toolkit.getDefaultToolkit();
/* 79 */     Dimension screenSize = kit.getScreenSize();
/* 80 */     if ((300 > screenSize.width) || (150 > screenSize.height)) {
/* 81 */       setLocation(0, 0);
/*    */     } else {
/* 83 */       setLocation((screenSize.width - 300) / 2, (screenSize.height - 150) / 2);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/autorun/Logo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */