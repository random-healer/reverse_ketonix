/*      */ package com.ketonix.ketonixpro;
/*      */ 
/*      */ import com.codeminders.hidapi.ClassPathLibraryLoader;
/*      */ import com.codeminders.hidapi.HIDDeviceInfo;
/*      */ import com.codeminders.hidapi.HIDManager;
/*      */ import java.awt.Canvas;
/*      */ import java.awt.Color;
/*      */ import java.awt.Container;
/*      */ import java.awt.Desktop;
/*      */ import java.awt.Dimension;
/*      */ import java.awt.EventQueue;
/*      */ import java.awt.Font;
/*      */ import java.awt.FontMetrics;
/*      */ import java.awt.Graphics2D;
/*      */ import java.awt.Label;
/*      */ import java.awt.Rectangle;
/*      */ import java.awt.RenderingHints;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.geom.Rectangle2D;
/*      */ import java.awt.geom.Rectangle2D.Double;
/*      */ import java.io.BufferedReader;
/*      */ import java.io.BufferedWriter;
/*      */ import java.io.FileWriter;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.InputStreamReader;
/*      */ import java.io.PrintStream;
/*      */ import java.io.PrintWriter;
/*      */ import java.net.URI;
/*      */ import java.net.URL;
/*      */ import java.net.URLEncoder;
/*      */ import java.text.DateFormat;
/*      */ import java.text.DecimalFormat;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.time.LocalTime;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import java.util.Locale;
/*      */ import java.util.logging.Level;
/*      */ import java.util.logging.Logger;
/*      */ import java.util.prefs.Preferences;
/*      */ import javax.net.ssl.HttpsURLConnection;
/*      */ import javax.swing.Box.Filler;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.GroupLayout.Alignment;
/*      */ import javax.swing.GroupLayout.ParallelGroup;
/*      */ import javax.swing.GroupLayout.SequentialGroup;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JFrame;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JMenu;
/*      */ import javax.swing.JMenuBar;
/*      */ import javax.swing.JMenuItem;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JPopupMenu;
/*      */ import javax.swing.LayoutStyle.ComponentPlacement;
/*      */ import javax.swing.UIManager;
/*      */ import javax.swing.UIManager.LookAndFeelInfo;
/*      */ import javax.swing.UnsupportedLookAndFeelException;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class KSync
/*      */   extends JFrame
/*      */ {
/*      */   ProfileMgr pm;
/*      */   Thread measureLoopThread;
/*      */   MeasureLoop measureLoop;
/*  614 */   boolean isMeasuring = false;
/*  615 */   int gui_val = 0;
/*  616 */   int gui_raw = 0;
/*  617 */   public int gui_max_raw = 0;
/*  618 */   public int gui_max_val = 0;
/*  619 */   int gui_cal = 0;
/*  620 */   int iconType = -1;
/*  621 */   public int current_id = 0;
/*  622 */   public int current_type = 0;
/*  623 */   public int current_value = 0;
/*  624 */   public int current_corr = 0;
/*  625 */   public int current_raw = 0;
/*  626 */   public int current_green = 0;
/*  627 */   public int current_yellow = 0;
/*  628 */   public int current_red = 0;
/*  629 */   public int current_cal = 0;
/*  630 */   public int current_warmup = 0;
/*  631 */   public int current_warmup_speed = 0;
/*  632 */   boolean dontBother = true;
/*  633 */   boolean is_warming_up = true;
/*  634 */   boolean authenticated = false;
/*      */   private static final long READ_UPDATE_DELAY_MS = 50L;
/*      */   static final int VENDOR_ID = 1240;
/*      */   static final int PRODUCT_ID = 62547;
/*      */   private static final int BUFSIZE = 64;
/*      */   Preferences preferences;
/*      */   LocalTime measureStartTime;
/*      */   private JMenuItem AddCommentMenuItem;
/*      */   private JButton CancelButton;
/*      */   private JComboBox ProfileSelectorComboBox;
/*      */   private JButton StartButton;
/*      */   
/*  646 */   static { if (ClassPathLibraryLoader.loadNativeHIDLibrary()) {
/*  647 */       System.err.println("Success loading native library");
/*      */     } else {
/*  649 */       System.err.println("No success loading native library");
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public void setFeedback(String s)
/*      */   {
/*  656 */     this.feedbackLabel.setText(s);
/*      */   }
/*      */   
/*      */   public byte[] getCurrentValues()
/*      */   {
/*  661 */     byte[] buf = new byte[64];
/*  662 */     for (int i = 0; i < 64; i++) buf[i] = 0;
/*  663 */     buf[0] = 0;
/*  664 */     buf[1] = ((byte)(this.current_value >> 0));
/*  665 */     buf[2] = ((byte)(this.current_value >> 8));
/*  666 */     buf[3] = ((byte)(this.current_raw >> 0));
/*  667 */     buf[4] = ((byte)(this.current_raw >> 8));
/*  668 */     buf[5] = ((byte)(this.current_warmup >> 0));
/*  669 */     buf[6] = ((byte)(this.current_warmup >> 8));
/*  670 */     buf[7] = ((byte)(this.current_green >> 0));
/*  671 */     buf[8] = ((byte)(this.current_green >> 8));
/*  672 */     buf[9] = ((byte)(this.current_yellow >> 0));
/*  673 */     buf[10] = ((byte)(this.current_yellow >> 8));
/*  674 */     buf[11] = ((byte)(this.current_red >> 0));
/*  675 */     buf[12] = ((byte)(this.current_red >> 8));
/*  676 */     buf[13] = ((byte)(this.current_cal >> 0));
/*  677 */     buf[14] = ((byte)(this.current_cal >> 8));
/*  678 */     buf[15] = ((byte)(this.current_type >> 0));
/*  679 */     buf[16] = ((byte)(this.current_type >> 8));
/*  680 */     buf[17] = ((byte)(this.current_id >> 0));
/*  681 */     buf[18] = ((byte)(this.current_id >> 8));
/*  682 */     buf[19] = ((byte)(this.current_corr >> 0));
/*  683 */     buf[20] = ((byte)(this.current_corr >> 8));
/*  684 */     return buf;
/*      */   }
/*      */   
/*      */   public void noDevice()
/*      */   {
/*  689 */     this.current_type = -1;
/*  690 */     this.current_warmup = 100;
/*  691 */     this.current_value = 0;
/*  692 */     setCurrentValues();
/*      */   }
/*      */   
/*      */   void setCalibration(int value, int corr)
/*      */   {
/*  697 */     this.measureLoop.setCalibration(value, corr);
/*      */   }
/*      */   
/*      */   void setKetonixValues(int ig, int iy, int ir)
/*      */   {
/*  702 */     this.measureLoop.setKetonixValues(ig, iy, ir);
/*      */   }
/*      */   
/*      */   public int calibrationHits()
/*      */   {
/*  707 */     String hstr = this.preferences.get("hits", "0");
/*  708 */     int hint = 100;
/*      */     try {
/*  710 */       if (hstr.equalsIgnoreCase("0")) {
/*  711 */         hint = 100;
/*  712 */         this.preferences.put("hits", "" + hint);
/*      */       } else {
/*  714 */         hint = Integer.parseInt(hstr);
/*      */       }
/*      */     } catch (Exception ex) {
/*  717 */       System.err.println(ex.toString());
/*      */     }
/*      */     
/*  720 */     return hint;
/*      */   }
/*      */   
/*      */   public int precision()
/*      */   {
/*  725 */     String pstr = this.preferences.get("precision", "0");
/*  726 */     int pint = 2;
/*      */     try {
/*  728 */       pint = pstr.equalsIgnoreCase("0") ? 3 : Integer.parseInt(pstr);
/*      */     } catch (Exception ex) {
/*  730 */       System.err.println(ex.toString());
/*      */     }
/*      */     
/*  733 */     return pint;
/*      */   }
/*      */   
/*      */ 
/*      */   public void initProfileList()
/*      */   {
/*  739 */     this.dontBother = true;
/*  740 */     this.ProfileSelectorComboBox.enableInputMethods(false);
/*  741 */     this.ProfileSelectorComboBox.removeAllItems();
/*  742 */     this.ProfileSelectorComboBox.addItem("Select Profile");
/*      */     
/*  744 */     for (int i = 0; i < this.pm.numProfiles(); i++) {
/*  745 */       this.ProfileSelectorComboBox.addItem(this.pm.getUserDisplayName(i));
/*      */     }
/*  747 */     this.ProfileSelectorComboBox.enableInputMethods(true);
/*  748 */     this.dontBother = false;
/*      */     
/*  750 */     this.feedbackLabel.setText("To start a measure you need to select a profile");
/*      */   }
/*      */   
/*      */   public boolean testAuthenticate(String username, String password)
/*      */   {
/*  755 */     this.authenticated = false;
/*  756 */     String answer = "";
/*  757 */     if ((username.isEmpty()) || (password.isEmpty())) return false;
/*      */     try {
/*  759 */       String enc_username = URLEncoder.encode(username, "UTF-8");
/*  760 */       String enc_password0 = URLEncoder.encode(password, "UTF-8");
/*  761 */       String enc_password = URLEncoder.encode(enc_password0, "UTF-8");
/*  762 */       System.setProperty("jsse.enableSNIExtension", "false");
/*  763 */       String httpsURL = "https://www.ketonix.com/index.php?option=com_api&app=ketonix&resource=auth&username=" + enc_username + "&password=" + enc_password + "&key=84b5c80b96f2674f1de14e2ed5fcdc99&format=raw";
/*  764 */       URL myurl = new URL(httpsURL);
/*  765 */       HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
/*  766 */       InputStream ins = con.getInputStream();
/*  767 */       InputStreamReader isr = new InputStreamReader(ins);
/*  768 */       BufferedReader in = new BufferedReader(isr);
/*      */       String inputLine;
/*  770 */       while ((inputLine = in.readLine()) != null)
/*      */       {
/*      */ 
/*  773 */         answer = inputLine;
/*      */       }
/*      */       
/*  776 */       in.close();
/*      */       
/*      */ 
/*  779 */       this.authenticated = answer.equals("\"success\"");
/*  780 */       if (this.authenticated) {
/*  781 */         this.mealMenuItem.setEnabled(true);
/*  782 */         this.exerciseMenuItem.setEnabled(true);
/*  783 */         this.bloodTestMenuItem.setEnabled(true);
/*  784 */         this.bodyMeasureMenuItem.setEnabled(true);
/*      */       }
/*      */       else {
/*  787 */         this.mealMenuItem.setEnabled(false);
/*  788 */         this.exerciseMenuItem.setEnabled(false);
/*  789 */         this.bloodTestMenuItem.setEnabled(false);
/*  790 */         this.bodyMeasureMenuItem.setEnabled(false);
/*  791 */         this.feedbackLabel.setText("Authentication failed, check internet connection");
/*      */       }
/*  793 */       return answer.equals("\"success\"");
/*      */     }
/*      */     catch (Exception ex) {
/*  796 */       System.err.println(ex.toString());
/*  797 */       this.authenticated = false;
/*  798 */       this.mealMenuItem.setEnabled(false);
/*  799 */       this.exerciseMenuItem.setEnabled(false);
/*  800 */       this.bloodTestMenuItem.setEnabled(false);
/*  801 */       this.bodyMeasureMenuItem.setEnabled(false); }
/*  802 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public void KSync3()
/*      */   {
/*  810 */     int ix = 100000;
/*  811 */     HIDManager hid_mgr = null;
/*      */     try {
/*  813 */       if (ClassPathLibraryLoader.loadNativeHIDLibrary()) {
/*  814 */         System.err.println("Success loading native library");
/*      */       } else {
/*  816 */         System.err.println("No success loading native library");
/*      */       }
/*  818 */       hid_mgr = HIDManager.getInstance();
/*      */       for (;;) {
/*  820 */         HIDDeviceInfo[] devs = hid_mgr.listDevices();
/*  821 */         for (int i = 0; i < devs.length; i++)
/*      */         {
/*  823 */           System.err.println("" + ix + ".\t" + devs[i].getProduct_string());
/*      */         }
/*  825 */         Thread.sleep(10L);
/*  826 */         System.out.println("----------------------------");
/*  827 */         ix++;
/*  828 */         Thread.sleep(1000L);
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  832 */       System.err.println(e.toString());
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public KSync()
/*      */   {
/*      */     try
/*      */     {
/*  842 */       System.out.println("Hello");
/*      */       
/*  844 */       URL url = getClass().getResource("resources/images/KetonixRed.png");
/*      */       
/*  846 */       this.pm = new ProfileMgr();
/*      */       
/*  848 */       initComponents();
/*      */       
/*  850 */       initProfileList();
/*      */       
/*  852 */       String jlp = System.getProperty("java.library.path");
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*  857 */       this.StartButton.setEnabled(false);
/*  858 */       this.mealMenuItem.setEnabled(false);
/*  859 */       this.exerciseMenuItem.setEnabled(false);
/*  860 */       this.bloodTestMenuItem.setEnabled(false);
/*  861 */       this.bodyMeasureMenuItem.setEnabled(false);
/*  862 */       System.out.println("Creating new measureLoop");
/*  863 */       this.measureLoop = new MeasureLoop(this);
/*  864 */       System.out.println("Starting measureLoop thread");
/*  865 */       this.measureLoopThread = new Thread(this.measureLoop);
/*  866 */       this.measureLoopThread.start();
/*      */       
/*  868 */       this.preferences = Preferences.userRoot().node("/com/ketonix/app");
/*  869 */       this.preferences.put("hits", "100");
/*  870 */       this.preferences.put("precision", "3");
/*      */       
/*      */ 
/*  873 */       this.ProfileSelectorComboBox.addActionListener(new ActionListener()
/*      */       {
/*      */         public void actionPerformed(ActionEvent ae)
/*      */         {
/*  877 */           if (KSync.this.dontBother) return;
/*  878 */           int ix = KSync.this.ProfileSelectorComboBox.getSelectedIndex();
/*  879 */           String username = KSync.this.pm.getUserName(ix - 1);
/*  880 */           String password = KSync.this.pm.getUserPassword(ix - 1);
/*  881 */           if ((!username.isEmpty()) && (!KSync.this.testAuthenticate(username, password))) {
/*  882 */             KSync.this.ProfileSelectorComboBox.setSelectedIndex(0);
/*  883 */             System.out.println("failure to authenticate");
/*  884 */             KSync.this.StartButton.setEnabled(false);
/*  885 */             KSync.this.mealMenuItem.setEnabled(false);
/*  886 */             KSync.this.exerciseMenuItem.setEnabled(false);
/*  887 */             KSync.this.bloodTestMenuItem.setEnabled(false);
/*  888 */             KSync.this.bodyMeasureMenuItem.setEnabled(false);
/*      */             
/*  890 */             JOptionPane.showMessageDialog(null, "Username and password does not match\nor Internet connection is down");
/*  891 */             return;
/*      */           }
/*      */           
/*  894 */           if (KSync.this.current_warmup >= 100) KSync.this.StartButton.setEnabled(true);
/*  895 */           KSync.this.mealMenuItem.setEnabled(true);
/*  896 */           KSync.this.exerciseMenuItem.setEnabled(true);
/*  897 */           KSync.this.bloodTestMenuItem.setEnabled(true);
/*  898 */           KSync.this.bodyMeasureMenuItem.setEnabled(true);
/*      */           
/*  900 */           if (KSync.this.is_warming_up) {
/*  901 */             KSync.this.feedbackLabel.setText("When device is ready, click on Start");
/*      */           } else {
/*  903 */             KSync.this.feedbackLabel.setText("Click on Start");
/*      */           }
/*      */         }
/*      */       });
/*      */     }
/*      */     catch (Exception ex) {
/*  909 */       System.err.println(ex.toString());
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private JButton StopAndSaveButton;
/*      */   
/*      */   private JMenuBar TheMenuBar;
/*      */   
/*      */   private JMenuItem bloodTestMenuItem;
/*      */   
/*      */   private JMenuItem bodyMeasureMenuItem;
/*      */   
/*      */   private JMenuItem calibrateMenuItem;
/*      */   
/*      */   private Canvas canvas1;
/*      */   
/*      */   private JMenuItem exerciseMenuItem;
/*      */   
/*      */   private JMenuItem exitMenuItem;
/*      */   
/*      */   private Label feedbackLabel;
/*      */   
/*      */   private Box.Filler filler1;
/*      */   
/*      */   private Box.Filler filler2;
/*      */   
/*      */   private Box.Filler filler3;
/*      */   private Box.Filler filler4;
/*      */   private JLabel jLabel1;
/*      */   private JLabel jLabel2;
/*      */   private JMenu jMenu1;
/*      */   private JMenu jMenu2;
/*      */   private JMenu jMenu3;
/*      */   private JMenu jMenu4;
/*      */   private JMenu jMenu5;
/*      */   private JMenuItem jMenuItem1;
/*      */   private JMenuItem jMenuItem2;
/*      */   private JMenuItem jMenuItem3;
/*      */   private JPanel jPanel1;
/*      */   private JPopupMenu jPopupMenu1;
/*      */   private JMenuItem localChartMenuItemButton;
/*      */   private JMenuItem mealMenuItem;
/*      */   private JMenuItem profilesMenuItem;
/*      */   private JMenuItem settingsMenuItem;
/*      */   private JLabel unitLabel;
/*      */   private JMenuItem viewDataMenuItem;
/*      */   private void initComponents()
/*      */   {
/*  958 */     this.jPopupMenu1 = new JPopupMenu();
/*  959 */     this.jMenu1 = new JMenu();
/*  960 */     this.jPanel1 = new JPanel();
/*  961 */     this.canvas1 = new Canvas();
/*  962 */     this.StopAndSaveButton = new JButton();
/*  963 */     this.StartButton = new JButton();
/*  964 */     this.CancelButton = new JButton();
/*  965 */     this.jLabel1 = new JLabel();
/*  966 */     this.ProfileSelectorComboBox = new JComboBox();
/*  967 */     this.filler3 = new Box.Filler(new Dimension(50, 0), new Dimension(50, 0), new Dimension(50, 32767));
/*  968 */     this.jLabel2 = new JLabel();
/*  969 */     this.filler1 = new Box.Filler(new Dimension(0, 20), new Dimension(0, 20), new Dimension(32767, 20));
/*  970 */     this.feedbackLabel = new Label();
/*  971 */     this.unitLabel = new JLabel();
/*  972 */     this.filler2 = new Box.Filler(new Dimension(40, 0), new Dimension(40, 0), new Dimension(40, 32767));
/*  973 */     this.filler4 = new Box.Filler(new Dimension(0, 40), new Dimension(0, 40), new Dimension(32767, 40));
/*  974 */     this.TheMenuBar = new JMenuBar();
/*  975 */     this.jMenu2 = new JMenu();
/*  976 */     this.calibrateMenuItem = new JMenuItem();
/*  977 */     this.settingsMenuItem = new JMenuItem();
/*  978 */     this.profilesMenuItem = new JMenuItem();
/*  979 */     this.exitMenuItem = new JMenuItem();
/*  980 */     this.jMenu4 = new JMenu();
/*  981 */     this.mealMenuItem = new JMenuItem();
/*  982 */     this.exerciseMenuItem = new JMenuItem();
/*  983 */     this.bloodTestMenuItem = new JMenuItem();
/*  984 */     this.bodyMeasureMenuItem = new JMenuItem();
/*  985 */     this.AddCommentMenuItem = new JMenuItem();
/*  986 */     this.jMenu3 = new JMenu();
/*  987 */     this.localChartMenuItemButton = new JMenuItem();
/*  988 */     this.viewDataMenuItem = new JMenuItem();
/*  989 */     this.jMenuItem1 = new JMenuItem();
/*  990 */     this.jMenu5 = new JMenu();
/*  991 */     this.jMenuItem2 = new JMenuItem();
/*  992 */     this.jMenuItem3 = new JMenuItem();
/*      */     
/*  994 */     this.jMenu1.setText("jMenu1");
/*      */     
/*  996 */     setDefaultCloseOperation(3);
/*  997 */     setTitle("Ketonix®");
/*  998 */     setBackground(new Color(255, 255, 255));
/*  999 */     setBounds(new Rectangle(300, 220, 0, 0));
/* 1000 */     setPreferredSize(new Dimension(500, 340));
/*      */     
/* 1002 */     this.jPanel1.setBackground(new Color(255, 255, 255));
/* 1003 */     this.jPanel1.setMinimumSize(new Dimension(500, 300));
/* 1004 */     this.jPanel1.setPreferredSize(new Dimension(550, 400));
/*      */     
/* 1006 */     this.canvas1.setBackground(new Color(204, 204, 204));
/* 1007 */     this.canvas1.setPreferredSize(new Dimension(350, 35));
/*      */     
/* 1009 */     this.StopAndSaveButton.setFont(new Font("Lucida Sans", 1, 14));
/* 1010 */     this.StopAndSaveButton.setText("Stop & Save");
/* 1011 */     this.StopAndSaveButton.setToolTipText("Click here after breathing into the KETONIX®, wait minimum 45 seconds and value is steady ");
/* 1012 */     this.StopAndSaveButton.setEnabled(false);
/* 1013 */     this.StopAndSaveButton.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1015 */         KSync.this.StopAndSaveButtonActionPerformed(evt);
/*      */       }
/*      */       
/* 1018 */     });
/* 1019 */     this.StartButton.setFont(new Font("Lucida Sans", 1, 14));
/* 1020 */     this.StartButton.setText("Start");
/* 1021 */     this.StartButton.setToolTipText("Click here before breathing into the KETONIX®");
/* 1022 */     this.StartButton.setActionCommand("StartMeasure");
/* 1023 */     this.StartButton.addMouseListener(new MouseAdapter() {
/*      */       public void mouseReleased(MouseEvent evt) {
/* 1025 */         KSync.this.StartButtonMouseReleased(evt);
/*      */       }
/* 1027 */     });
/* 1028 */     this.StartButton.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1030 */         KSync.this.StartButtonActionPerformed(evt);
/*      */       }
/*      */       
/* 1033 */     });
/* 1034 */     this.CancelButton.setFont(new Font("Lucida Sans", 1, 14));
/* 1035 */     this.CancelButton.setText("Cancel");
/* 1036 */     this.CancelButton.setEnabled(false);
/* 1037 */     this.CancelButton.addMouseListener(new MouseAdapter() {
/*      */       public void mouseReleased(MouseEvent evt) {
/* 1039 */         KSync.this.CancelButtonMouseReleased(evt);
/*      */       }
/*      */       
/* 1042 */     });
/* 1043 */     this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/resources/images/KetonixGrey.png")));
/*      */     
/* 1045 */     this.ProfileSelectorComboBox.setFont(new Font("Lucida Grande", 1, 14));
/* 1046 */     this.ProfileSelectorComboBox.setToolTipText("Select a profile with your account details on www.ketonix.com");
/* 1047 */     this.ProfileSelectorComboBox.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1049 */         KSync.this.ProfileSelectorComboBoxActionPerformed(evt);
/*      */       }
/*      */       
/* 1052 */     });
/* 1053 */     this.jLabel2.setIcon(new ImageIcon(getClass().getResource("/resources/images/KetonixLogo.png")));
/*      */     
/* 1055 */     this.feedbackLabel.setFont(new Font("Lucida Sans", 0, 13));
/* 1056 */     this.feedbackLabel.setText("To start a measure you need to select a profile");
/*      */     
/* 1058 */     this.unitLabel.setText("units");
/* 1059 */     this.unitLabel.setToolTipText("units is a sensor percentage, PPM is parts per million acetone");
/*      */     
/* 1061 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 1062 */     this.jPanel1.setLayout(jPanel1Layout);
/* 1063 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 1064 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1065 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 1066 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1067 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 1068 */       .addGap(20, 20, 20)
/* 1069 */       .addComponent(this.jLabel2)
/* 1070 */       .addGap(100, 100, 100)
/* 1071 */       .addComponent(this.ProfileSelectorComboBox, -2, 151, -2)
/* 1072 */       .addGap(20, 20, 20)
/* 1073 */       .addComponent(this.filler3, -2, -1, -2))
/* 1074 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 1075 */       .addGap(65, 65, 65)
/* 1076 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1077 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 1078 */       .addComponent(this.canvas1, -2, -1, -2)
/* 1079 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1080 */       .addComponent(this.unitLabel)
/* 1081 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1082 */       .addComponent(this.filler2, -2, -1, -2))
/* 1083 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 1084 */       .addGap(64, 64, 64)
/* 1085 */       .addComponent(this.jLabel1, -2, 243, -2))
/* 1086 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1087 */       .addComponent(this.filler4, -2, 404, -2)
/* 1088 */       .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1089 */       .addComponent(this.feedbackLabel, -2, 338, -2)
/* 1090 */       .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
/* 1091 */       .addComponent(this.StartButton, -2, 100, -2)
/* 1092 */       .addGap(18, 18, 18)
/* 1093 */       .addComponent(this.StopAndSaveButton, -2, 112, -2)
/* 1094 */       .addGap(18, 18, 18)
/* 1095 */       .addComponent(this.CancelButton, -2, 100, -2))))))
/* 1096 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 1097 */       .addGap(229, 229, 229)
/* 1098 */       .addComponent(this.filler1, -2, 21, -2)))
/* 1099 */       .addContainerGap(17, 32767)));
/*      */     
/* 1101 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 1102 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1103 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 1104 */       .addGap(20, 20, 20)
/* 1105 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1106 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1107 */       .addComponent(this.jLabel2, GroupLayout.Alignment.TRAILING)
/* 1108 */       .addComponent(this.ProfileSelectorComboBox, GroupLayout.Alignment.TRAILING, -2, -1, -2))
/* 1109 */       .addComponent(this.filler3, -2, 12, -2))
/* 1110 */       .addGap(29, 29, 29)
/* 1111 */       .addComponent(this.jLabel1, -2, 41, -2)
/* 1112 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1113 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 1114 */       .addGap(19, 19, 19)
/* 1115 */       .addComponent(this.unitLabel))
/* 1116 */       .addGroup(jPanel1Layout.createSequentialGroup()
/* 1117 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1118 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1119 */       .addComponent(this.filler2, -1, -1, 32767)
/* 1120 */       .addComponent(this.canvas1, -1, -1, 32767))))
/* 1121 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1122 */       .addComponent(this.feedbackLabel, -2, -1, -2)
/* 1123 */       .addGap(7, 7, 7)
/* 1124 */       .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1125 */       .addComponent(this.StopAndSaveButton)
/* 1126 */       .addComponent(this.CancelButton)
/* 1127 */       .addComponent(this.StartButton))
/* 1128 */       .addGap(18, 18, 18)
/* 1129 */       .addComponent(this.filler4, -2, 27, -2)
/* 1130 */       .addGap(39, 39, 39)
/* 1131 */       .addComponent(this.filler1, -2, -1, -2)
/* 1132 */       .addGap(20, 20, 20)));
/*      */     
/*      */ 
/* 1135 */     this.jMenu2.setText("File");
/* 1136 */     this.jMenu2.setFont(new Font("Lucida Grande", 1, 14));
/*      */     
/* 1138 */     this.calibrateMenuItem.setFont(new Font("Lucida Grande", 1, 14));
/* 1139 */     this.calibrateMenuItem.setText("Calibration ...");
/* 1140 */     this.calibrateMenuItem.setActionCommand("Calibrate");
/* 1141 */     this.calibrateMenuItem.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1143 */         KSync.this.calibrateMenuItemActionPerformed(evt);
/*      */       }
/* 1145 */     });
/* 1146 */     this.jMenu2.add(this.calibrateMenuItem);
/*      */     
/* 1148 */     this.settingsMenuItem.setFont(new Font("Lucida Grande", 1, 14));
/* 1149 */     this.settingsMenuItem.setText("Settings ...");
/* 1150 */     this.settingsMenuItem.setActionCommand("Settings");
/* 1151 */     this.settingsMenuItem.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1153 */         KSync.this.settingsMenuItemActionPerformed(evt);
/*      */       }
/* 1155 */     });
/* 1156 */     this.jMenu2.add(this.settingsMenuItem);
/*      */     
/* 1158 */     this.profilesMenuItem.setFont(new Font("Lucida Grande", 1, 14));
/* 1159 */     this.profilesMenuItem.setText("Profiles ...");
/* 1160 */     this.profilesMenuItem.setActionCommand("Profiles");
/* 1161 */     this.profilesMenuItem.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1163 */         KSync.this.profilesMenuItemActionPerformed(evt);
/*      */       }
/* 1165 */     });
/* 1166 */     this.jMenu2.add(this.profilesMenuItem);
/*      */     
/* 1168 */     this.exitMenuItem.setFont(new Font("Lucida Grande", 1, 14));
/* 1169 */     this.exitMenuItem.setText("Exit");
/* 1170 */     this.exitMenuItem.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1172 */         KSync.this.exitMenuItemActionPerformed(evt);
/*      */       }
/* 1174 */     });
/* 1175 */     this.jMenu2.add(this.exitMenuItem);
/*      */     
/* 1177 */     this.TheMenuBar.add(this.jMenu2);
/*      */     
/* 1179 */     this.jMenu4.setText("Data");
/* 1180 */     this.jMenu4.setFont(new Font("Lucida Grande", 1, 14));
/*      */     
/* 1182 */     this.mealMenuItem.setFont(new Font("Lucida Grande", 1, 14));
/* 1183 */     this.mealMenuItem.setText("Add Meal ...");
/* 1184 */     this.mealMenuItem.setActionCommand("Meal");
/* 1185 */     this.mealMenuItem.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1187 */         KSync.this.mealMenuItemActionPerformed(evt);
/*      */       }
/* 1189 */     });
/* 1190 */     this.jMenu4.add(this.mealMenuItem);
/*      */     
/* 1192 */     this.exerciseMenuItem.setFont(new Font("Lucida Grande", 1, 14));
/* 1193 */     this.exerciseMenuItem.setText("Add Exercise ...");
/* 1194 */     this.exerciseMenuItem.setActionCommand("Exercise");
/* 1195 */     this.exerciseMenuItem.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1197 */         KSync.this.exerciseMenuItemActionPerformed(evt);
/*      */       }
/* 1199 */     });
/* 1200 */     this.jMenu4.add(this.exerciseMenuItem);
/*      */     
/* 1202 */     this.bloodTestMenuItem.setFont(new Font("Lucida Sans", 1, 14));
/* 1203 */     this.bloodTestMenuItem.setText("Add Body Measure ...");
/* 1204 */     this.bloodTestMenuItem.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1206 */         KSync.this.bloodTestMenuItemActionPerformed(evt);
/*      */       }
/* 1208 */     });
/* 1209 */     this.jMenu4.add(this.bloodTestMenuItem);
/*      */     
/* 1211 */     this.bodyMeasureMenuItem.setFont(new Font("Lucida Sans", 1, 14));
/* 1212 */     this.bodyMeasureMenuItem.setText("Add Blood Test ...");
/* 1213 */     this.bodyMeasureMenuItem.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1215 */         KSync.this.bodyMeasureMenuItemActionPerformed(evt);
/*      */       }
/* 1217 */     });
/* 1218 */     this.jMenu4.add(this.bodyMeasureMenuItem);
/*      */     
/* 1220 */     this.AddCommentMenuItem.setFont(new Font("Lucida Grande", 1, 14));
/* 1221 */     this.AddCommentMenuItem.setText("Add Comment ...");
/* 1222 */     this.AddCommentMenuItem.setEnabled(false);
/* 1223 */     this.AddCommentMenuItem.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1225 */         KSync.this.AddCommentMenuItemActionPerformed(evt);
/*      */       }
/* 1227 */     });
/* 1228 */     this.jMenu4.add(this.AddCommentMenuItem);
/*      */     
/* 1230 */     this.TheMenuBar.add(this.jMenu4);
/*      */     
/* 1232 */     this.jMenu3.setText("View");
/* 1233 */     this.jMenu3.setFont(new Font("Lucida Grande", 1, 14));
/*      */     
/* 1235 */     this.localChartMenuItemButton.setFont(new Font("Lucida Grande", 1, 14));
/* 1236 */     this.localChartMenuItemButton.setText("Visualize Data ...");
/* 1237 */     this.localChartMenuItemButton.setToolTipText("Chart from you locally saved measures");
/* 1238 */     this.localChartMenuItemButton.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1240 */         KSync.this.localChartMenuItemButtonActionPerformed(evt);
/*      */       }
/* 1242 */     });
/* 1243 */     this.jMenu3.add(this.localChartMenuItemButton);
/*      */     
/* 1245 */     this.viewDataMenuItem.setFont(new Font("Lucida Grande", 1, 14));
/* 1246 */     this.viewDataMenuItem.setText("Visit www.ketonix.com");
/* 1247 */     this.viewDataMenuItem.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1249 */         KSync.this.viewDataMenuItemActionPerformed(evt);
/*      */       }
/* 1251 */     });
/* 1252 */     this.jMenu3.add(this.viewDataMenuItem);
/*      */     
/* 1254 */     this.jMenuItem1.setFont(new Font("Lucida Sans", 1, 14));
/* 1255 */     this.jMenuItem1.setText("About ...");
/* 1256 */     this.jMenuItem1.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1258 */         KSync.this.jMenuItem1ActionPerformed(evt);
/*      */       }
/* 1260 */     });
/* 1261 */     this.jMenu3.add(this.jMenuItem1);
/*      */     
/* 1263 */     this.TheMenuBar.add(this.jMenu3);
/*      */     
/* 1265 */     this.jMenu5.setText("Help");
/* 1266 */     this.jMenu5.setToolTipText("");
/* 1267 */     this.jMenu5.setFont(new Font("Lucida Grande", 1, 14));
/*      */     
/* 1269 */     this.jMenuItem2.setFont(new Font("Lucida Grande", 1, 14));
/* 1270 */     this.jMenuItem2.setText("Manual ...");
/* 1271 */     this.jMenuItem2.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1273 */         KSync.this.jMenuItem2ActionPerformed(evt);
/*      */       }
/* 1275 */     });
/* 1276 */     this.jMenu5.add(this.jMenuItem2);
/*      */     
/* 1278 */     this.jMenuItem3.setFont(new Font("Lucida Grande", 1, 14));
/* 1279 */     this.jMenuItem3.setText("Troubleshooting ...");
/* 1280 */     this.jMenuItem3.setToolTipText("");
/* 1281 */     this.jMenuItem3.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1283 */         KSync.this.jMenuItem3ActionPerformed(evt);
/*      */       }
/* 1285 */     });
/* 1286 */     this.jMenu5.add(this.jMenuItem3);
/*      */     
/* 1288 */     this.TheMenuBar.add(this.jMenu5);
/*      */     
/* 1290 */     setJMenuBar(this.TheMenuBar);
/*      */     
/* 1292 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 1293 */     getContentPane().setLayout(layout);
/* 1294 */     layout.setHorizontalGroup(layout
/* 1295 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1296 */       .addGroup(layout.createSequentialGroup()
/* 1297 */       .addComponent(this.jPanel1, -1, 520, 32767)
/* 1298 */       .addGap(0, 0, 0)));
/*      */     
/* 1300 */     layout.setVerticalGroup(layout
/* 1301 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1302 */       .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
/* 1303 */       .addGap(0, 0, 0)
/* 1304 */       .addComponent(this.jPanel1, -2, 288, -2)));
/*      */     
/*      */ 
/* 1307 */     pack();
/*      */   }
/*      */   
/*      */   private void settingsMenuItemActionPerformed(ActionEvent evt) {
/* 1311 */     this.isMeasuring = false;
/* 1312 */     Settings ns = new Settings(this);
/* 1313 */     ns.setVisible(true);
/*      */   }
/*      */   
/*      */   private void exitMenuItemActionPerformed(ActionEvent evt) {
/* 1317 */     System.exit(0);
/*      */   }
/*      */   
/*      */   private void profilesMenuItemActionPerformed(ActionEvent evt)
/*      */   {
/* 1322 */     setAlwaysOnTop(false);
/* 1323 */     ProfileDialog dialog = new ProfileDialog(new JFrame(), false);
/* 1324 */     dialog.addParent(this);
/* 1325 */     dialog.setVisible(true);
/* 1326 */     dialog.toFront();
/* 1327 */     dialog.setAlwaysOnTop(true);
/*      */   }
/*      */   
/*      */   public void logData(String theDate, String theTimeIn, String label, String value)
/*      */   {
/* 1332 */     int ix = this.ProfileSelectorComboBox.getSelectedIndex();
/*      */     
/* 1334 */     String theTime = theTimeIn.replace('-', ':');
/* 1335 */     String fileName = this.pm.dataFile(ix - 1);
/* 1336 */     if (fileName.isEmpty()) return;
/*      */     try {
/* 1338 */       PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));
/* 1339 */       out.println(theDate + ";" + theTime + ";" + label + ";" + value);
/* 1340 */       out.close();
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/* 1344 */       System.err.println(e.toString());
/* 1345 */       return;
/*      */     }
/*      */   }
/*      */   
/*      */   public void saveBodyMeasures(Date theTimestamp, double length, double neck, double upperArm, double chest, double waist, double hip, double thigh, double calf, double weight)
/*      */   {
/*      */     try
/*      */     {
/* 1353 */       System.setProperty("jsse.enableSNIExtension", "false");
/* 1354 */       DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
/* 1355 */       DateFormat tf = new SimpleDateFormat("HH-mm-ss");
/*      */       
/* 1357 */       String theDate = df.format(theTimestamp);
/* 1358 */       String theTime = tf.format(theTimestamp);
/* 1359 */       DecimalFormat decf = new DecimalFormat("#.##");
/*      */       
/* 1361 */       String lengthStr = decf.format(length).replace(',', '.');
/* 1362 */       String neckStr = decf.format(neck).replace(',', '.');
/* 1363 */       String upperArmStr = decf.format(upperArm).replace(',', '.');
/* 1364 */       String chestStr = decf.format(chest).replace(',', '.');
/* 1365 */       String waistStr = decf.format(waist).replace(',', '.');
/* 1366 */       String hipStr = decf.format(hip).replace(',', '.');
/* 1367 */       String thighStr = decf.format(thigh).replace(',', '.');
/* 1368 */       String calfStr = decf.format(calf).replace(',', '.');
/* 1369 */       String weightStr = decf.format(weight).replace(',', '.');
/*      */       
/*      */ 
/* 1372 */       if (length > 0.0D) logData(theDate, theTime, "Height", lengthStr);
/* 1373 */       if (neck > 0.0D) logData(theDate, theTime, "Neck", neckStr);
/* 1374 */       if (upperArm > 0.0D) logData(theDate, theTime, "UpperArm", upperArmStr);
/* 1375 */       if (chest > 0.0D) logData(theDate, theTime, "Chest", chestStr);
/* 1376 */       if (waist > 0.0D) logData(theDate, theTime, "Waist", waistStr);
/* 1377 */       if (hip > 0.0D) logData(theDate, theTime, "Hip", hipStr);
/* 1378 */       if (thigh > 0.0D) logData(theDate, theTime, "Thigh", thighStr);
/* 1379 */       if (calf > 0.0D) logData(theDate, theTime, "Calf", calfStr);
/* 1380 */       if (weight > 0.0D) { logData(theDate, theTime, "Weight", weightStr);
/*      */       }
/*      */       
/* 1383 */       int ix = this.ProfileSelectorComboBox.getSelectedIndex();
/* 1384 */       String username = this.pm.getUserName(ix - 1);
/*      */       
/* 1386 */       if (username.isEmpty()) { return;
/*      */       }
/*      */       
/*      */ 
/* 1390 */       String password = this.pm.getUserPassword(ix - 1);
/*      */       
/* 1392 */       String enc_username = URLEncoder.encode(username, "UTF-8");
/* 1393 */       String enc_password0 = URLEncoder.encode(password, "UTF-8");
/* 1394 */       String enc_password = URLEncoder.encode(enc_password0, "UTF-8");
/*      */       
/*      */ 
/* 1397 */       int publicUse = this.pm.allowAnonymousData(ix - 1) ? 1 : 0;
/*      */       
/* 1399 */       String isSmoker = this.pm.smoking(ix - 1);
/* 1400 */       String gender = this.pm.gender(ix - 1);
/* 1401 */       String age = this.pm.age(ix - 1);
/* 1402 */       String usage = this.pm.usage(ix - 1);
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1412 */       int num_saved = 0;
/* 1413 */       int num_values = 0;
/*      */       
/* 1415 */       if (length > 0.0D) {
/* 1416 */         num_values++;
/* 1417 */         String httpsURL = "https://www.ketonix.com/index.php?option=com_api&app=ketonix&resource=store&username=" + enc_username + "&password=" + enc_password + "&smoking=" + isSmoker + "&gender=" + gender + "&age=" + age + "&usage=" + usage + "&date=" + theDate + "&time=" + theTime + "&calibration=0&value=" + lengthStr + "&integration=Ketonix&label=Height&key=84b5c80b96f2674f1de14e2ed5fcdc99&format=raw&public=" + publicUse;
/* 1418 */         System.out.println("Saving Length " + httpsURL);
/* 1419 */         URL myurl = new URL(httpsURL);
/* 1420 */         HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
/* 1421 */         InputStream ins = con.getInputStream();
/* 1422 */         InputStreamReader isr = new InputStreamReader(ins);
/* 1423 */         BufferedReader in = new BufferedReader(isr);
/* 1424 */         String inputLine; while ((inputLine = in.readLine()) != null)
/*      */         {
/* 1426 */           System.out.println(inputLine);
/* 1427 */           num_saved += (inputLine.contains("success") ? 1 : 0);
/*      */         }
/* 1429 */         in.close();
/*      */       }
/*      */       
/*      */ 
/*      */ 
/* 1434 */       if (neck > 0.0D) {
/* 1435 */         num_values++;
/* 1436 */         String httpsURL = "https://www.ketonix.com/index.php?option=com_api&app=ketonix&resource=store&username=" + enc_username + "&password=" + enc_password + "&smoking=" + isSmoker + "&gender=" + gender + "&age=" + age + "&usage=" + usage + "&date=" + theDate + "&time=" + theTime + "&calibration=0&value=" + neckStr + "&integration=Ketonix&label=Neck&key=84b5c80b96f2674f1de14e2ed5fcdc99&format=raw&public=" + publicUse;
/* 1437 */         System.out.println("Saving Neck " + httpsURL);System.out.flush();
/* 1438 */         URL myurl = new URL(httpsURL);
/* 1439 */         HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
/* 1440 */         InputStream ins = con.getInputStream();
/* 1441 */         InputStreamReader isr = new InputStreamReader(ins);
/* 1442 */         BufferedReader in = new BufferedReader(isr);
/* 1443 */         String inputLine; while ((inputLine = in.readLine()) != null)
/*      */         {
/* 1445 */           System.out.println(inputLine);
/* 1446 */           num_saved += (inputLine.contains("success") ? 1 : 0);
/*      */         }
/* 1448 */         in.close();
/*      */       }
/*      */       
/*      */ 
/* 1452 */       if (upperArm > 0.0D) {
/* 1453 */         num_values++;
/* 1454 */         String httpsURL = "https://www.ketonix.com/index.php?option=com_api&app=ketonix&resource=store&username=" + enc_username + "&password=" + enc_password + "&smoking=" + isSmoker + "&gender=" + gender + "&age=" + age + "&usage=" + usage + "&date=" + theDate + "&time=" + theTime + "&calibration=0&value=" + upperArmStr + "&integration=Ketonix&label=UpperArm&key=84b5c80b96f2674f1de14e2ed5fcdc99&format=raw&public=" + publicUse;
/*      */         
/* 1456 */         URL myurl = new URL(httpsURL);
/* 1457 */         HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
/* 1458 */         InputStream ins = con.getInputStream();
/* 1459 */         InputStreamReader isr = new InputStreamReader(ins);
/* 1460 */         BufferedReader in = new BufferedReader(isr);
/* 1461 */         String inputLine; while ((inputLine = in.readLine()) != null)
/*      */         {
/* 1463 */           System.out.println(inputLine);
/* 1464 */           num_saved += (inputLine.contains("success") ? 1 : 0);
/*      */         }
/* 1466 */         in.close();
/*      */       }
/*      */       
/*      */ 
/* 1470 */       if (chest > 0.0D) {
/* 1471 */         num_values++;
/* 1472 */         String httpsURL = "https://www.ketonix.com/index.php?option=com_api&app=ketonix&resource=store&username=" + enc_username + "&password=" + enc_password + "&smoking=" + isSmoker + "&gender=" + gender + "&age=" + age + "&usage=" + usage + "&date=" + theDate + "&time=" + theTime + "&calibration=0&value=" + chestStr + "&integration=Ketonix&label=Chest&key=84b5c80b96f2674f1de14e2ed5fcdc99&format=raw&public=" + publicUse;
/*      */         
/* 1474 */         URL myurl = new URL(httpsURL);
/* 1475 */         HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
/* 1476 */         InputStream ins = con.getInputStream();
/* 1477 */         InputStreamReader isr = new InputStreamReader(ins);
/* 1478 */         BufferedReader in = new BufferedReader(isr);
/* 1479 */         String inputLine; while ((inputLine = in.readLine()) != null)
/*      */         {
/* 1481 */           System.out.println(inputLine);
/* 1482 */           num_saved += (inputLine.contains("success") ? 1 : 0);
/*      */         }
/* 1484 */         in.close();
/*      */       }
/*      */       
/*      */ 
/* 1488 */       if (waist > 0.0D) {
/* 1489 */         num_values++;
/* 1490 */         String httpsURL = "https://www.ketonix.com/index.php?option=com_api&app=ketonix&resource=store&username=" + enc_username + "&password=" + enc_password + "&smoking=" + isSmoker + "&gender=" + gender + "&age=" + age + "&usage=" + usage + "&date=" + theDate + "&time=" + theTime + "&calibration=0&value=" + waistStr + "&integration=Ketonix&label=Waist&key=84b5c80b96f2674f1de14e2ed5fcdc99&format=raw&public=" + publicUse;
/*      */         
/* 1492 */         URL myurl = new URL(httpsURL);
/* 1493 */         HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
/* 1494 */         InputStream ins = con.getInputStream();
/* 1495 */         InputStreamReader isr = new InputStreamReader(ins);
/* 1496 */         BufferedReader in = new BufferedReader(isr);
/* 1497 */         String inputLine; while ((inputLine = in.readLine()) != null)
/*      */         {
/* 1499 */           System.out.println(inputLine);
/* 1500 */           num_saved += (inputLine.contains("success") ? 1 : 0);
/*      */         }
/* 1502 */         in.close();
/*      */       }
/*      */       
/*      */ 
/* 1506 */       if (hip > 0.0D) {
/* 1507 */         num_values++;
/* 1508 */         String httpsURL = "https://www.ketonix.com/index.php?option=com_api&app=ketonix&resource=store&username=" + enc_username + "&password=" + enc_password + "&smoking=" + isSmoker + "&gender=" + gender + "&age=" + age + "&usage=" + usage + "&date=" + theDate + "&time=" + theTime + "&calibration=0&value=" + hipStr + "&integration=Ketonix&label=Hip&key=84b5c80b96f2674f1de14e2ed5fcdc99&format=raw&public=" + publicUse;
/*      */         
/* 1510 */         URL myurl = new URL(httpsURL);
/* 1511 */         HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
/* 1512 */         InputStream ins = con.getInputStream();
/* 1513 */         InputStreamReader isr = new InputStreamReader(ins);
/* 1514 */         BufferedReader in = new BufferedReader(isr);
/* 1515 */         String inputLine; while ((inputLine = in.readLine()) != null)
/*      */         {
/* 1517 */           System.out.println(inputLine);
/* 1518 */           num_saved += (inputLine.contains("success") ? 1 : 0);
/*      */         }
/* 1520 */         in.close();
/*      */       }
/*      */       
/*      */ 
/* 1524 */       if (thigh > 0.0D) {
/* 1525 */         num_values++;
/* 1526 */         String httpsURL = "https://www.ketonix.com/index.php?option=com_api&app=ketonix&resource=store&username=" + enc_username + "&password=" + enc_password + "&smoking=" + isSmoker + "&gender=" + gender + "&age=" + age + "&usage=" + usage + "&date=" + theDate + "&time=" + theTime + "&calibration=0&value=" + thighStr + "&integration=Ketonix&label=Thigh&key=84b5c80b96f2674f1de14e2ed5fcdc99&format=raw&public=" + publicUse;
/*      */         
/* 1528 */         URL myurl = new URL(httpsURL);
/* 1529 */         HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
/* 1530 */         InputStream ins = con.getInputStream();
/* 1531 */         InputStreamReader isr = new InputStreamReader(ins);
/* 1532 */         BufferedReader in = new BufferedReader(isr);
/* 1533 */         String inputLine; while ((inputLine = in.readLine()) != null)
/*      */         {
/* 1535 */           System.out.println(inputLine);
/* 1536 */           num_saved += (inputLine.contains("success") ? 1 : 0);
/*      */         }
/* 1538 */         in.close();
/*      */       }
/*      */       
/*      */ 
/* 1542 */       if (calf > 0.0D) {
/* 1543 */         num_values++;
/* 1544 */         String httpsURL = "https://www.ketonix.com/index.php?option=com_api&app=ketonix&resource=store&username=" + enc_username + "&password=" + enc_password + "&smoking=" + isSmoker + "&gender=" + gender + "&age=" + age + "&usage=" + usage + "&date=" + theDate + "&time=" + theTime + "&calibration=0&value=" + calfStr + "&integration=Ketonix&label=Calf&key=84b5c80b96f2674f1de14e2ed5fcdc99&format=raw&public=" + publicUse;
/*      */         
/* 1546 */         URL myurl = new URL(httpsURL);
/* 1547 */         HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
/* 1548 */         InputStream ins = con.getInputStream();
/* 1549 */         InputStreamReader isr = new InputStreamReader(ins);
/* 1550 */         BufferedReader in = new BufferedReader(isr);
/* 1551 */         String inputLine; while ((inputLine = in.readLine()) != null)
/*      */         {
/* 1553 */           System.out.println(inputLine);
/* 1554 */           num_saved += (inputLine.contains("success") ? 1 : 0);
/*      */         }
/* 1556 */         in.close();
/*      */       }
/*      */       
/*      */ 
/* 1560 */       if (weight > 0.0D) {
/* 1561 */         num_values++;
/* 1562 */         String httpsURL = "https://www.ketonix.com/index.php?option=com_api&app=ketonix&resource=store&username=" + enc_username + "&password=" + enc_password + "&smoking=" + isSmoker + "&gender=" + gender + "&age=" + age + "&usage=" + usage + "&date=" + theDate + "&time=" + theTime + "&calibration=0&value=" + weightStr + "&integration=Ketonix&label=Weight&key=84b5c80b96f2674f1de14e2ed5fcdc99&format=raw&public=" + publicUse;
/*      */         
/* 1564 */         URL myurl = new URL(httpsURL);
/* 1565 */         HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
/* 1566 */         InputStream ins = con.getInputStream();
/* 1567 */         InputStreamReader isr = new InputStreamReader(ins);
/* 1568 */         BufferedReader in = new BufferedReader(isr);
/* 1569 */         String inputLine; while ((inputLine = in.readLine()) != null)
/*      */         {
/* 1571 */           System.out.println(inputLine);
/* 1572 */           num_saved += (inputLine.contains("success") ? 1 : 0);
/*      */         }
/* 1574 */         in.close();
/*      */       }
/*      */       
/* 1577 */       if (num_saved != num_values) {
/* 1578 */         this.feedbackLabel.setText("Error: " + num_saved + " (of " + num_values + ") values saved");
/*      */       } else {
/* 1580 */         this.feedbackLabel.setText(num_saved + "  (of " + num_values + ") values saved");
/*      */       }
/*      */     }
/*      */     catch (Exception ex) {
/* 1584 */       System.err.println(ex.toString());
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public void saveMeal(Date theTimestamp, int fatAmount, int proteinAmount, int carbsAmount, int waterAmount, int caloriesAmount, double alcoholAmount, double ketoRatio)
/*      */   {
/*      */     try
/*      */     {
/* 1593 */       int num_values = 0;
/* 1594 */       int num_saved = 0;
/* 1595 */       System.setProperty("jsse.enableSNIExtension", "false");
/* 1596 */       DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
/* 1597 */       DateFormat tf = new SimpleDateFormat("HH-mm-ss");
/*      */       
/* 1599 */       String theDate = df.format(theTimestamp);
/* 1600 */       String theTime = tf.format(theTimestamp);
/* 1601 */       DecimalFormat decf = new DecimalFormat("#.#");
/*      */       
/*      */ 
/* 1604 */       String ketoRatioStr = decf.format(ketoRatio).replace(',', '.');
/*      */       
/*      */ 
/* 1607 */       String alcoholUnitStr = decf.format(alcoholAmount).replace(',', '.');
/*      */       
/* 1609 */       if (fatAmount > 0.0D) logData(theDate, theTime, "Fat", "" + fatAmount);
/* 1610 */       if (proteinAmount > 0.0D) logData(theDate, theTime, "Protein", "" + proteinAmount);
/* 1611 */       if (carbsAmount > 0.0D) logData(theDate, theTime, "Carbohydrates", "" + carbsAmount);
/* 1612 */       if (waterAmount > 0.0D) logData(theDate, theTime, "Water", "" + waterAmount);
/* 1613 */       if (caloriesAmount > 0.0D) logData(theDate, theTime, "CaloriesIn", "" + caloriesAmount);
/* 1614 */       if (alcoholAmount > 0.0D) logData(theDate, theTime, "Alcohol", alcoholUnitStr);
/* 1615 */       if (ketoRatio > 0.0D) { logData(theDate, theTime, "KetoRatio", ketoRatioStr);
/*      */       }
/* 1617 */       int ix = this.ProfileSelectorComboBox.getSelectedIndex();
/* 1618 */       String username = this.pm.getUserName(ix - 1);
/* 1619 */       if (username.isEmpty()) return;
/* 1620 */       String password = this.pm.getUserPassword(ix - 1);
/*      */       
/* 1622 */       String enc_username = URLEncoder.encode(username, "UTF-8");
/* 1623 */       String enc_password0 = URLEncoder.encode(password, "UTF-8");
/* 1624 */       String enc_password = URLEncoder.encode(enc_password0, "UTF-8");
/*      */       
/*      */ 
/* 1627 */       int publicUse = this.pm.allowAnonymousData(ix - 1) ? 1 : 0;
/*      */       
/* 1629 */       String isSmoker = this.pm.smoking(ix - 1);
/* 1630 */       String gender = this.pm.gender(ix - 1);
/* 1631 */       String age = this.pm.age(ix - 1);
/* 1632 */       String usage = this.pm.usage(ix - 1);
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1642 */       if (fatAmount > 0) {
/* 1643 */         num_values++;
/* 1644 */         String httpsURL = "https://www.ketonix.com/index.php?option=com_api&app=ketonix&resource=store&username=" + enc_username + "&password=" + enc_password + "&smoking=" + isSmoker + "&gender=" + gender + "&age=" + age + "&usage=" + usage + "&date=" + theDate + "&time=" + theTime + "&calibration=0&value=" + fatAmount + "&integration=Ketonix&label=Fat&key=84b5c80b96f2674f1de14e2ed5fcdc99&format=raw&public=" + publicUse;
/*      */         
/* 1646 */         URL myurl = new URL(httpsURL);
/* 1647 */         HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
/* 1648 */         InputStream ins = con.getInputStream();
/* 1649 */         InputStreamReader isr = new InputStreamReader(ins);
/* 1650 */         BufferedReader in = new BufferedReader(isr);
/* 1651 */         String inputLine; while ((inputLine = in.readLine()) != null)
/*      */         {
/* 1653 */           System.out.println(inputLine);
/* 1654 */           num_saved += (inputLine.contains("success") ? 1 : 0);
/*      */         }
/* 1656 */         in.close();
/*      */       }
/*      */       
/*      */ 
/* 1660 */       if (proteinAmount > 0) {
/* 1661 */         num_values++;
/* 1662 */         String httpsURL = "https://www.ketonix.com/index.php?option=com_api&app=ketonix&resource=store&username=" + enc_username + "&password=" + enc_password + "&smoking=" + isSmoker + "&gender=" + gender + "&age=" + age + "&usage=" + usage + "&date=" + theDate + "&time=" + theTime + "&calibration=0&value=" + proteinAmount + "&integration=Ketonix&label=Protein&key=84b5c80b96f2674f1de14e2ed5fcdc99&format=raw&public=" + publicUse;
/*      */         
/* 1664 */         URL myurl = new URL(httpsURL);
/* 1665 */         HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
/* 1666 */         InputStream ins = con.getInputStream();
/* 1667 */         InputStreamReader isr = new InputStreamReader(ins);
/* 1668 */         BufferedReader in = new BufferedReader(isr);
/* 1669 */         String inputLine; while ((inputLine = in.readLine()) != null)
/*      */         {
/* 1671 */           System.out.println(inputLine);
/* 1672 */           num_saved += (inputLine.contains("success") ? 1 : 0);
/*      */         }
/* 1674 */         in.close();
/*      */       }
/*      */       
/*      */ 
/* 1678 */       if (carbsAmount > 0) {
/* 1679 */         num_values++;
/* 1680 */         String httpsURL = "https://www.ketonix.com/index.php?option=com_api&app=ketonix&resource=store&username=" + enc_username + "&password=" + enc_password + "&smoking=" + isSmoker + "&gender=" + gender + "&age=" + age + "&usage=" + usage + "&date=" + theDate + "&time=" + theTime + "&calibration=0&value=" + carbsAmount + "&integration=Ketonix&label=Carbohydrates&key=84b5c80b96f2674f1de14e2ed5fcdc99&format=raw&public=" + publicUse;
/*      */         
/* 1682 */         URL myurl = new URL(httpsURL);
/* 1683 */         HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
/* 1684 */         InputStream ins = con.getInputStream();
/* 1685 */         InputStreamReader isr = new InputStreamReader(ins);
/* 1686 */         BufferedReader in = new BufferedReader(isr);
/* 1687 */         String inputLine; while ((inputLine = in.readLine()) != null)
/*      */         {
/* 1689 */           System.out.println(inputLine);
/* 1690 */           num_saved += (inputLine.contains("success") ? 1 : 0);
/*      */         }
/* 1692 */         in.close();
/*      */       }
/*      */       
/*      */ 
/* 1696 */       if (waterAmount > 0) {
/* 1697 */         num_values++;
/* 1698 */         String httpsURL = "https://www.ketonix.com/index.php?option=com_api&app=ketonix&resource=store&username=" + enc_username + "&password=" + enc_password + "&smoking=" + isSmoker + "&gender=" + gender + "&age=" + age + "&usage=" + usage + "&date=" + theDate + "&time=" + theTime + "&calibration=0&value=" + waterAmount + "&integration=Ketonix&label=Water&key=84b5c80b96f2674f1de14e2ed5fcdc99&format=raw&public=" + publicUse;
/*      */         
/* 1700 */         URL myurl = new URL(httpsURL);
/* 1701 */         HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
/* 1702 */         InputStream ins = con.getInputStream();
/* 1703 */         InputStreamReader isr = new InputStreamReader(ins);
/* 1704 */         BufferedReader in = new BufferedReader(isr);
/* 1705 */         String inputLine; while ((inputLine = in.readLine()) != null)
/*      */         {
/* 1707 */           System.out.println(inputLine);
/* 1708 */           num_saved += (inputLine.contains("success") ? 1 : 0);
/*      */         }
/* 1710 */         in.close();
/*      */       }
/*      */       
/*      */ 
/* 1714 */       if (caloriesAmount > 0) {
/* 1715 */         num_values++;
/* 1716 */         String httpsURL = "https://www.ketonix.com/index.php?option=com_api&app=ketonix&resource=store&username=" + enc_username + "&password=" + enc_password + "&smoking=" + isSmoker + "&gender=" + gender + "&age=" + age + "&usage=" + usage + "&date=" + theDate + "&time=" + theTime + "&calibration=0&value=" + caloriesAmount + "&integration=Ketonix&label=CaloriesIn&key=84b5c80b96f2674f1de14e2ed5fcdc99&format=raw&public=" + publicUse;
/*      */         
/*      */ 
/* 1719 */         URL myurl = new URL(httpsURL);
/* 1720 */         HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
/* 1721 */         InputStream ins = con.getInputStream();
/* 1722 */         InputStreamReader isr = new InputStreamReader(ins);
/* 1723 */         BufferedReader in = new BufferedReader(isr);
/* 1724 */         String inputLine; while ((inputLine = in.readLine()) != null)
/*      */         {
/* 1726 */           System.out.println(inputLine);
/* 1727 */           num_saved += (inputLine.contains("success") ? 1 : 0);
/*      */         }
/* 1729 */         in.close();
/*      */       }
/*      */       
/*      */ 
/*      */ 
/* 1734 */       if ((ketoRatioStr != null) && (!ketoRatioStr.equalsIgnoreCase(""))) {
/* 1735 */         num_values++;
/* 1736 */         String httpsURL = "https://www.ketonix.com/index.php?option=com_api&app=ketonix&resource=store&username=" + enc_username + "&password=" + enc_password + "&smoking=" + isSmoker + "&gender=" + gender + "&age=" + age + "&usage=" + usage + "&date=" + theDate + "&time=" + theTime + "&calibration=0&value=" + ketoRatioStr.replace(',', '.') + "&integration=Ketonix&label=KetogenicRatio&key=84b5c80b96f2674f1de14e2ed5fcdc99&format=raw&public=" + publicUse;
/*      */         
/*      */ 
/* 1739 */         URL myurl = new URL(httpsURL);
/* 1740 */         HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
/* 1741 */         InputStream ins = con.getInputStream();
/* 1742 */         InputStreamReader isr = new InputStreamReader(ins);
/* 1743 */         BufferedReader in = new BufferedReader(isr);
/* 1744 */         String inputLine; while ((inputLine = in.readLine()) != null)
/*      */         {
/* 1746 */           System.out.println(inputLine);
/* 1747 */           num_saved += (inputLine.contains("success") ? 1 : 0);
/*      */         }
/* 1749 */         in.close();
/*      */       }
/*      */       
/*      */ 
/* 1753 */       if (alcoholAmount > 0.0D) {
/* 1754 */         num_values++;
/* 1755 */         String httpsURL = "https://www.ketonix.com/index.php?option=com_api&app=ketonix&resource=store&username=" + enc_username + "&password=" + enc_password + "&smoking=" + isSmoker + "&gender=" + gender + "&age=" + age + "&usage=" + usage + "&date=" + theDate + "&time=" + theTime + "&calibration=0&value=" + alcoholUnitStr.replace(',', '.') + "&integration=Ketonix&label=AlcoholUnits&key=84b5c80b96f2674f1de14e2ed5fcdc99&format=raw&public=" + publicUse;
/*      */         
/*      */ 
/* 1758 */         URL myurl = new URL(httpsURL);
/* 1759 */         HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
/* 1760 */         InputStream ins = con.getInputStream();
/* 1761 */         InputStreamReader isr = new InputStreamReader(ins);
/* 1762 */         BufferedReader in = new BufferedReader(isr);
/* 1763 */         String inputLine; while ((inputLine = in.readLine()) != null)
/*      */         {
/* 1765 */           System.out.println(inputLine);
/* 1766 */           num_saved += (inputLine.contains("success") ? 1 : 0);
/*      */         }
/* 1768 */         in.close();
/*      */       }
/*      */       
/* 1771 */       if (num_saved != num_values) {
/* 1772 */         this.feedbackLabel.setText("Error: " + num_saved + " values is saved of " + num_values);
/*      */       }
/*      */       else {
/* 1775 */         this.feedbackLabel.setText(num_saved + "  (of " + num_values + ") values saved");
/*      */       }
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1780 */       System.err.println(ex.toString());
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public void saveBloodTest(Date theTimestamp, double bhob, double glucose, int cholesterol, int hdlc, int ldlc, int ldlp, int pulse, int smallldl, int triglycerides, int vldl, int diastolic, int systolic)
/*      */   {
/*      */     try
/*      */     {
/* 1789 */       int num_values = 0;
/* 1790 */       int num_saved = 0;
/*      */       
/* 1792 */       System.setProperty("jsse.enableSNIExtension", "false");
/* 1793 */       DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
/* 1794 */       DateFormat tf = new SimpleDateFormat("HH-mm-ss");
/*      */       
/* 1796 */       String theDate = df.format(theTimestamp);
/* 1797 */       String theTime = tf.format(theTimestamp);
/* 1798 */       DecimalFormat decf = new DecimalFormat("#.#");
/*      */       
/* 1800 */       String bhobStr = decf.format(bhob).replace(',', '.');
/*      */       
/* 1802 */       String glucoseStr = decf.format(glucose).replace(',', '.');
/*      */       
/* 1804 */       if (bhob > 0.0D) logData(theDate, theTime, "Beta-HydroxyButyrate", "" + bhobStr);
/* 1805 */       if (glucose > 0.0D) logData(theDate, theTime, "Glucose", "" + glucoseStr);
/* 1806 */       if (cholesterol > 0.0D) logData(theDate, theTime, "Cholesterol", "" + cholesterol);
/* 1807 */       if (hdlc > 0.0D) logData(theDate, theTime, "HDLC", "" + hdlc);
/* 1808 */       if (ldlc > 0.0D) logData(theDate, theTime, "LDLC", "" + ldlc);
/* 1809 */       if (ldlp > 0.0D) logData(theDate, theTime, "LDLC", "" + ldlp);
/* 1810 */       if (pulse > 0.0D) logData(theDate, theTime, "Pulse", "" + pulse);
/* 1811 */       if (smallldl > 0.0D) logData(theDate, theTime, "SmallLDL", "" + smallldl);
/* 1812 */       if (triglycerides > 0.0D) logData(theDate, theTime, "Triglycerides", "" + triglycerides);
/* 1813 */       if (vldl > 0.0D) logData(theDate, theTime, "VLDL", "" + vldl);
/* 1814 */       if (diastolic > 0.0D) logData(theDate, theTime, "Diastolic", "" + diastolic);
/* 1815 */       if (systolic > 0.0D) { logData(theDate, theTime, "Systolic", "" + systolic);
/*      */       }
/*      */       
/* 1818 */       int ix = this.ProfileSelectorComboBox.getSelectedIndex();
/* 1819 */       String username = this.pm.getUserName(ix - 1);
/* 1820 */       if (username.isEmpty()) return;
/* 1821 */       String password = this.pm.getUserPassword(ix - 1);
/*      */       
/* 1823 */       String enc_username = URLEncoder.encode(username, "UTF-8");
/* 1824 */       String enc_password0 = URLEncoder.encode(password, "UTF-8");
/* 1825 */       String enc_password = URLEncoder.encode(enc_password0, "UTF-8");
/*      */       
/*      */ 
/* 1828 */       int publicUse = this.pm.allowAnonymousData(ix - 1) ? 1 : 0;
/*      */       
/* 1830 */       String isSmoker = this.pm.smoking(ix - 1);
/* 1831 */       String gender = this.pm.gender(ix - 1);
/* 1832 */       String age = this.pm.age(ix - 1);
/* 1833 */       String usage = this.pm.usage(ix - 1);
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1843 */       if (bhob > 0.0D) {
/* 1844 */         num_values++;
/* 1845 */         String httpsURL = "https://www.ketonix.com/index.php?option=com_api&app=ketonix&resource=store&username=" + enc_username + "&password=" + enc_password + "&smoking=" + isSmoker + "&gender=" + gender + "&age=" + age + "&usage=" + usage + "&date=" + theDate + "&time=" + theTime + "&calibration=0&value=" + bhobStr + "&integration=Ketonix&label=BHOB&key=84b5c80b96f2674f1de14e2ed5fcdc99&format=raw&public=" + publicUse;
/*      */         
/* 1847 */         URL myurl = new URL(httpsURL);
/* 1848 */         HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
/* 1849 */         InputStream ins = con.getInputStream();
/* 1850 */         InputStreamReader isr = new InputStreamReader(ins);
/* 1851 */         BufferedReader in = new BufferedReader(isr);
/* 1852 */         String inputLine; while ((inputLine = in.readLine()) != null)
/*      */         {
/* 1854 */           System.out.println(inputLine);
/* 1855 */           num_saved += (inputLine.contains("success") ? 1 : 0);
/*      */         }
/* 1857 */         in.close();
/*      */       }
/*      */       
/*      */ 
/* 1861 */       if (glucose > 0.0D) {
/* 1862 */         num_values++;
/* 1863 */         String httpsURL = "https://www.ketonix.com/index.php?option=com_api&app=ketonix&resource=store&username=" + enc_username + "&password=" + enc_password + "&smoking=" + isSmoker + "&gender=" + gender + "&age=" + age + "&usage=" + usage + "&date=" + theDate + "&time=" + theTime + "&calibration=0&value=" + glucoseStr + "&integration=Ketonix&label=Glucose&key=84b5c80b96f2674f1de14e2ed5fcdc99&format=raw&public=" + publicUse;
/*      */         
/* 1865 */         URL myurl = new URL(httpsURL);
/* 1866 */         HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
/* 1867 */         InputStream ins = con.getInputStream();
/* 1868 */         InputStreamReader isr = new InputStreamReader(ins);
/* 1869 */         BufferedReader in = new BufferedReader(isr);
/* 1870 */         String inputLine; while ((inputLine = in.readLine()) != null)
/*      */         {
/* 1872 */           System.out.println(inputLine);
/* 1873 */           num_saved += (inputLine.contains("success") ? 1 : 0);
/*      */         }
/* 1875 */         in.close();
/*      */       }
/*      */       
/*      */ 
/* 1879 */       if (cholesterol > 0) {
/* 1880 */         num_values++;
/* 1881 */         String httpsURL = "https://www.ketonix.com/index.php?option=com_api&app=ketonix&resource=store&username=" + enc_username + "&password=" + enc_password + "&smoking=" + isSmoker + "&gender=" + gender + "&age=" + age + "&usage=" + usage + "&date=" + theDate + "&time=" + theTime + "&calibration=0&value=" + cholesterol + "&integration=Ketonix&label=Cholesterol&key=84b5c80b96f2674f1de14e2ed5fcdc99&format=raw&public=" + publicUse;
/*      */         
/* 1883 */         URL myurl = new URL(httpsURL);
/* 1884 */         HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
/* 1885 */         InputStream ins = con.getInputStream();
/* 1886 */         InputStreamReader isr = new InputStreamReader(ins);
/* 1887 */         BufferedReader in = new BufferedReader(isr);
/* 1888 */         String inputLine; while ((inputLine = in.readLine()) != null)
/*      */         {
/* 1890 */           System.out.println(inputLine);
/* 1891 */           num_saved += (inputLine.contains("success") ? 1 : 0);
/*      */         }
/* 1893 */         in.close();
/*      */       }
/*      */       
/*      */ 
/* 1897 */       if (hdlc > 0) {
/* 1898 */         num_values++;
/* 1899 */         String httpsURL = "https://www.ketonix.com/index.php?option=com_api&app=ketonix&resource=store&username=" + enc_username + "&password=" + enc_password + "&smoking=" + isSmoker + "&gender=" + gender + "&age=" + age + "&usage=" + usage + "&date=" + theDate + "&time=" + theTime + "&calibration=0&value=" + hdlc + "&integration=Ketonix&label=HDLC&key=84b5c80b96f2674f1de14e2ed5fcdc99&format=raw&public=" + publicUse;
/*      */         
/* 1901 */         URL myurl = new URL(httpsURL);
/* 1902 */         HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
/* 1903 */         InputStream ins = con.getInputStream();
/* 1904 */         InputStreamReader isr = new InputStreamReader(ins);
/* 1905 */         BufferedReader in = new BufferedReader(isr);
/* 1906 */         String inputLine; while ((inputLine = in.readLine()) != null)
/*      */         {
/* 1908 */           System.out.println(inputLine);
/* 1909 */           num_saved += (inputLine.contains("success") ? 1 : 0);
/*      */         }
/* 1911 */         in.close();
/*      */       }
/*      */       
/*      */ 
/* 1915 */       if (ldlc > 0) {
/* 1916 */         num_values++;
/* 1917 */         String httpsURL = "https://www.ketonix.com/index.php?option=com_api&app=ketonix&resource=store&username=" + enc_username + "&password=" + enc_password + "&smoking=" + isSmoker + "&gender=" + gender + "&age=" + age + "&usage=" + usage + "&date=" + theDate + "&time=" + theTime + "&calibration=0&value=" + ldlc + "&integration=Ketonix&label=LDLC&key=84b5c80b96f2674f1de14e2ed5fcdc99&format=raw&public=" + publicUse;
/*      */         
/* 1919 */         URL myurl = new URL(httpsURL);
/* 1920 */         HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
/* 1921 */         InputStream ins = con.getInputStream();
/* 1922 */         InputStreamReader isr = new InputStreamReader(ins);
/* 1923 */         BufferedReader in = new BufferedReader(isr);
/* 1924 */         String inputLine; while ((inputLine = in.readLine()) != null)
/*      */         {
/* 1926 */           System.out.println(inputLine);
/* 1927 */           num_saved += (inputLine.contains("success") ? 1 : 0);
/*      */         }
/* 1929 */         in.close();
/*      */       }
/*      */       
/*      */ 
/* 1933 */       if (ldlp > 0) {
/* 1934 */         num_values++;
/* 1935 */         String httpsURL = "https://www.ketonix.com/index.php?option=com_api&app=ketonix&resource=store&username=" + enc_username + "&password=" + enc_password + "&smoking=" + isSmoker + "&gender=" + gender + "&age=" + age + "&usage=" + usage + "&date=" + theDate + "&time=" + theTime + "&calibration=0&value=" + ldlp + "&integration=Ketonix&label=LDLP&key=84b5c80b96f2674f1de14e2ed5fcdc99&format=raw&public=" + publicUse;
/*      */         
/* 1937 */         URL myurl = new URL(httpsURL);
/* 1938 */         HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
/* 1939 */         InputStream ins = con.getInputStream();
/* 1940 */         InputStreamReader isr = new InputStreamReader(ins);
/* 1941 */         BufferedReader in = new BufferedReader(isr);
/* 1942 */         String inputLine; while ((inputLine = in.readLine()) != null)
/*      */         {
/* 1944 */           System.out.println(inputLine);
/* 1945 */           num_saved += (inputLine.contains("success") ? 1 : 0);
/*      */         }
/* 1947 */         in.close();
/*      */       }
/*      */       
/*      */ 
/* 1951 */       if (pulse > 0) {
/* 1952 */         num_values++;
/* 1953 */         String httpsURL = "https://www.ketonix.com/index.php?option=com_api&app=ketonix&resource=store&username=" + enc_username + "&password=" + enc_password + "&smoking=" + isSmoker + "&gender=" + gender + "&age=" + age + "&usage=" + usage + "&date=" + theDate + "&time=" + theTime + "&calibration=0&value=" + pulse + "&integration=Ketonix&label=Pulse&key=84b5c80b96f2674f1de14e2ed5fcdc99&format=raw&public=" + publicUse;
/*      */         
/* 1955 */         URL myurl = new URL(httpsURL);
/* 1956 */         HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
/* 1957 */         InputStream ins = con.getInputStream();
/* 1958 */         InputStreamReader isr = new InputStreamReader(ins);
/* 1959 */         BufferedReader in = new BufferedReader(isr);
/* 1960 */         String inputLine; while ((inputLine = in.readLine()) != null)
/*      */         {
/* 1962 */           System.out.println(inputLine);
/* 1963 */           num_saved += (inputLine.contains("success") ? 1 : 0);
/*      */         }
/* 1965 */         in.close();
/*      */       }
/*      */       
/*      */ 
/* 1969 */       if (smallldl > 0) {
/* 1970 */         num_values++;
/* 1971 */         String httpsURL = "https://www.ketonix.com/index.php?option=com_api&app=ketonix&resource=store&username=" + enc_username + "&password=" + enc_password + "&smoking=" + isSmoker + "&gender=" + gender + "&age=" + age + "&usage=" + usage + "&date=" + theDate + "&time=" + theTime + "&calibration=0&value=" + smallldl + "&integration=Ketonix&label=SmallLDL&key=84b5c80b96f2674f1de14e2ed5fcdc99&format=raw&public=" + publicUse;
/*      */         
/* 1973 */         URL myurl = new URL(httpsURL);
/* 1974 */         HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
/* 1975 */         InputStream ins = con.getInputStream();
/* 1976 */         InputStreamReader isr = new InputStreamReader(ins);
/* 1977 */         BufferedReader in = new BufferedReader(isr);
/* 1978 */         String inputLine; while ((inputLine = in.readLine()) != null)
/*      */         {
/* 1980 */           System.out.println(inputLine);
/* 1981 */           num_saved += (inputLine.contains("success") ? 1 : 0);
/*      */         }
/* 1983 */         in.close();
/*      */       }
/*      */       
/*      */ 
/* 1987 */       if (triglycerides > 0) {
/* 1988 */         num_values++;
/* 1989 */         String httpsURL = "https://www.ketonix.com/index.php?option=com_api&app=ketonix&resource=store&username=" + enc_username + "&password=" + enc_password + "&smoking=" + isSmoker + "&gender=" + gender + "&age=" + age + "&usage=" + usage + "&date=" + theDate + "&time=" + theTime + "&calibration=0&value=" + triglycerides + "&integration=Ketonix&label=Triglycerides&key=84b5c80b96f2674f1de14e2ed5fcdc99&format=raw&public=" + publicUse;
/*      */         
/* 1991 */         URL myurl = new URL(httpsURL);
/* 1992 */         HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
/* 1993 */         InputStream ins = con.getInputStream();
/* 1994 */         InputStreamReader isr = new InputStreamReader(ins);
/* 1995 */         BufferedReader in = new BufferedReader(isr);
/* 1996 */         String inputLine; while ((inputLine = in.readLine()) != null)
/*      */         {
/* 1998 */           System.out.println(inputLine);
/* 1999 */           num_saved += (inputLine.contains("success") ? 1 : 0);
/*      */         }
/* 2001 */         in.close();
/*      */       }
/*      */       
/*      */ 
/* 2005 */       if (vldl > 0) {
/* 2006 */         num_values++;
/* 2007 */         String httpsURL = "https://www.ketonix.com/index.php?option=com_api&app=ketonix&resource=store&username=" + enc_username + "&password=" + enc_password + "&smoking=" + isSmoker + "&gender=" + gender + "&age=" + age + "&usage=" + usage + "&date=" + theDate + "&time=" + theTime + "&calibration=0&value=" + vldl + "&integration=Ketonix&label=VLDL&key=84b5c80b96f2674f1de14e2ed5fcdc99&format=raw&public=" + publicUse;
/*      */         
/* 2009 */         URL myurl = new URL(httpsURL);
/* 2010 */         HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
/* 2011 */         InputStream ins = con.getInputStream();
/* 2012 */         InputStreamReader isr = new InputStreamReader(ins);
/* 2013 */         BufferedReader in = new BufferedReader(isr);
/* 2014 */         String inputLine; while ((inputLine = in.readLine()) != null)
/*      */         {
/* 2016 */           System.out.println(inputLine);
/* 2017 */           num_saved += (inputLine.contains("success") ? 1 : 0);
/*      */         }
/* 2019 */         in.close();
/*      */       }
/*      */       
/*      */ 
/* 2023 */       if (diastolic > 0) {
/* 2024 */         num_values++;
/* 2025 */         String httpsURL = "https://www.ketonix.com/index.php?option=com_api&app=ketonix&resource=store&username=" + enc_username + "&password=" + enc_password + "&smoking=" + isSmoker + "&gender=" + gender + "&age=" + age + "&usage=" + usage + "&date=" + theDate + "&time=" + theTime + "&calibration=0&value=" + diastolic + "&integration=Ketonix&label=Diastolic&key=84b5c80b96f2674f1de14e2ed5fcdc99&format=raw&public=" + publicUse;
/*      */         
/* 2027 */         URL myurl = new URL(httpsURL);
/* 2028 */         HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
/* 2029 */         InputStream ins = con.getInputStream();
/* 2030 */         InputStreamReader isr = new InputStreamReader(ins);
/* 2031 */         BufferedReader in = new BufferedReader(isr);
/* 2032 */         String inputLine; while ((inputLine = in.readLine()) != null)
/*      */         {
/* 2034 */           System.out.println(inputLine);
/* 2035 */           num_saved += (inputLine.contains("success") ? 1 : 0);
/*      */         }
/* 2037 */         in.close();
/*      */       }
/*      */       
/*      */ 
/* 2041 */       if (systolic > 0) {
/* 2042 */         num_values++;
/* 2043 */         String httpsURL = "https://www.ketonix.com/index.php?option=com_api&app=ketonix&resource=store&username=" + enc_username + "&password=" + enc_password + "&smoking=" + isSmoker + "&gender=" + gender + "&age=" + age + "&usage=" + usage + "&date=" + theDate + "&time=" + theTime + "&calibration=0&value=" + systolic + "&integration=Ketonix&label=Systolic&key=84b5c80b96f2674f1de14e2ed5fcdc99&format=raw&public=" + publicUse;
/*      */         
/* 2045 */         URL myurl = new URL(httpsURL);
/* 2046 */         HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
/* 2047 */         InputStream ins = con.getInputStream();
/* 2048 */         InputStreamReader isr = new InputStreamReader(ins);
/* 2049 */         BufferedReader in = new BufferedReader(isr);
/* 2050 */         String inputLine; while ((inputLine = in.readLine()) != null)
/*      */         {
/* 2052 */           System.out.println(inputLine);
/* 2053 */           num_saved += (inputLine.contains("success") ? 1 : 0);
/*      */         }
/* 2055 */         in.close();
/*      */       }
/*      */       
/* 2058 */       if (num_saved != num_values) {
/* 2059 */         this.feedbackLabel.setText("Error: " + num_saved + " (of " + num_values + ") values saved");
/*      */       } else {
/* 2061 */         this.feedbackLabel.setText(num_saved + "  (of " + num_values + ") values saved");
/*      */       }
/*      */     }
/*      */     catch (Exception ex) {
/* 2065 */       System.out.println(ex.toString());
/*      */     }
/*      */   }
/*      */   
/*      */   public void saveComment(Date theDateIn, String comment)
/*      */   {
/*      */     try {
/* 2072 */       DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
/* 2073 */       DateFormat tf = new SimpleDateFormat("HH-mm-ss");
/* 2074 */       String theDate = df.format(theDateIn);
/* 2075 */       String theTime = tf.format(theDateIn);
/*      */       
/*      */ 
/* 2078 */       System.setProperty("jsse.enableSNIExtension", "false");
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2085 */       if (comment != null) { logData(theDate, theTime, "Comment", "" + comment);
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2130 */       System.out.println(ex.toString());
/*      */     }
/*      */   }
/*      */   
/*      */   public void saveExercise(int timeAmount, int caloriesAmount, int intensityAmount, Date theDateIn, int funAmount, int exerciseType)
/*      */   {
/* 2136 */     int num_values = 0;
/* 2137 */     int num_saved = 0;
/*      */     try {
/* 2139 */       num_values++;
/* 2140 */       DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
/* 2141 */       DateFormat tf = new SimpleDateFormat("HH-mm-ss");
/* 2142 */       String theDate = df.format(theDateIn);
/* 2143 */       String theTime = tf.format(theDateIn);
/*      */       
/*      */ 
/* 2146 */       System.setProperty("jsse.enableSNIExtension", "false");
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2153 */       if (timeAmount > 0.0D) logData(theDate, theTime, "ExerciseTime", "" + timeAmount);
/* 2154 */       if (caloriesAmount > 0.0D) logData(theDate, theTime, "CaloriesOut", "" + caloriesAmount);
/* 2155 */       logData(theDate, theTime, "ExerciseIntensity", "" + intensityAmount);
/* 2156 */       logData(theDate, theTime, "ExerciseFun", "" + funAmount);
/* 2157 */       logData(theDate, theTime, "ExerciseType", "" + exerciseType);
/*      */       
/*      */ 
/* 2160 */       int ix = this.ProfileSelectorComboBox.getSelectedIndex();
/* 2161 */       String username = this.pm.getUserName(ix - 1);
/* 2162 */       if (username.isEmpty()) return;
/* 2163 */       String password = this.pm.getUserPassword(ix - 1);
/*      */       
/* 2165 */       String enc_username = URLEncoder.encode(username, "UTF-8");
/* 2166 */       String enc_password0 = URLEncoder.encode(password, "UTF-8");
/* 2167 */       String enc_password = URLEncoder.encode(enc_password0, "UTF-8");
/*      */       
/* 2169 */       int publicUse = this.pm.allowAnonymousData(ix - 1) ? 1 : 0;
/*      */       
/* 2171 */       String isSmoker = this.pm.smoking(ix - 1);
/* 2172 */       String gender = this.pm.gender(ix - 1);
/* 2173 */       String age = this.pm.age(ix - 1);
/* 2174 */       String usage = this.pm.usage(ix - 1);
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2184 */       if (timeAmount > 0) {
/* 2185 */         String httpsURL = "https://www.ketonix.com/index.php?option=com_api&app=ketonix&resource=store&username=" + enc_username + "&password=" + enc_password + "&smoking=" + isSmoker + "&gender=" + gender + "&age=" + age + "&usage=" + usage + "&date=" + theDate + "&time=" + theTime + "&calibration=0&value=" + timeAmount + "&integration=Ketonix&label=ExerciseLength&key=84b5c80b96f2674f1de14e2ed5fcdc99&format=raw&public=" + publicUse;
/*      */         
/* 2187 */         URL myurl = new URL(httpsURL);
/* 2188 */         HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
/* 2189 */         InputStream ins = con.getInputStream();
/* 2190 */         InputStreamReader isr = new InputStreamReader(ins);
/* 2191 */         BufferedReader in = new BufferedReader(isr);
/* 2192 */         String inputLine; while ((inputLine = in.readLine()) != null)
/*      */         {
/* 2194 */           System.out.println(inputLine);
/* 2195 */           num_saved += (inputLine.contains("success") ? 1 : 0);
/*      */         }
/* 2197 */         in.close();
/*      */       }
/*      */       
/*      */ 
/* 2201 */       if (caloriesAmount > 0) {
/* 2202 */         num_values++;
/* 2203 */         String httpsURL = "https://www.ketonix.com/index.php?option=com_api&app=ketonix&resource=store&username=" + enc_username + "&password=" + enc_password + "&smoking=" + isSmoker + "&gender=" + gender + "&age=" + age + "&usage=" + usage + "&date=" + theDate + "&time=" + theTime + "&calibration=0&value=" + caloriesAmount + "&integration=Ketonix&label=CaloriesOut&key=84b5c80b96f2674f1de14e2ed5fcdc99&format=raw&public=" + publicUse;
/*      */         
/* 2205 */         URL myurl = new URL(httpsURL);
/* 2206 */         HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
/* 2207 */         InputStream ins = con.getInputStream();
/* 2208 */         InputStreamReader isr = new InputStreamReader(ins);
/* 2209 */         BufferedReader in = new BufferedReader(isr);
/* 2210 */         String inputLine; while ((inputLine = in.readLine()) != null)
/*      */         {
/* 2212 */           System.out.println(inputLine);
/* 2213 */           num_saved += (inputLine.contains("success") ? 1 : 0);
/*      */         }
/* 2215 */         in.close();
/*      */       }
/*      */       
/*      */ 
/* 2219 */       if (intensityAmount > 0) {
/* 2220 */         num_values++;
/* 2221 */         String httpsURL = "https://www.ketonix.com/index.php?option=com_api&app=ketonix&resource=store&username=" + enc_username + "&password=" + enc_password + "&smoking=" + isSmoker + "&gender=" + gender + "&age=" + age + "&usage=" + usage + "&date=" + theDate + "&time=" + theTime + "&calibration=0&value=" + intensityAmount + "&integration=Ketonix&label=ExerciseIntensity&key=84b5c80b96f2674f1de14e2ed5fcdc99&format=raw&public=" + publicUse;
/*      */         
/* 2223 */         URL myurl = new URL(httpsURL);
/* 2224 */         HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
/* 2225 */         InputStream ins = con.getInputStream();
/* 2226 */         InputStreamReader isr = new InputStreamReader(ins);
/* 2227 */         BufferedReader in = new BufferedReader(isr);
/* 2228 */         String inputLine; while ((inputLine = in.readLine()) != null)
/*      */         {
/* 2230 */           System.out.println(inputLine);
/* 2231 */           num_saved += (inputLine.contains("success") ? 1 : 0);
/*      */         }
/* 2233 */         in.close();
/*      */       }
/*      */       
/*      */ 
/*      */ 
/* 2238 */       if (funAmount > 0) {
/* 2239 */         num_values++;
/* 2240 */         String httpsURL = "https://www.ketonix.com/index.php?option=com_api&app=ketonix&resource=store&username=" + enc_username + "&password=" + enc_password + "&smoking=" + isSmoker + "&gender=" + gender + "&age=" + age + "&usage=" + usage + "&date=" + theDate + "&time=" + theTime + "&calibration=0&value=" + funAmount + "&integration=Ketonix&label=ExerciseFun&key=84b5c80b96f2674f1de14e2ed5fcdc99&format=raw&public=" + publicUse;
/*      */         
/* 2242 */         URL myurl = new URL(httpsURL);
/* 2243 */         HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
/* 2244 */         InputStream ins = con.getInputStream();
/* 2245 */         InputStreamReader isr = new InputStreamReader(ins);
/* 2246 */         BufferedReader in = new BufferedReader(isr);
/* 2247 */         String inputLine; while ((inputLine = in.readLine()) != null)
/*      */         {
/* 2249 */           System.out.println(inputLine);
/* 2250 */           num_saved += (inputLine.contains("success") ? 1 : 0);
/*      */         }
/* 2252 */         in.close();
/*      */       }
/*      */       
/*      */ 
/* 2256 */       num_values++;
/* 2257 */       String httpsURL = "https://www.ketonix.com/index.php?option=com_api&app=ketonix&resource=store&username=" + enc_username + "&password=" + enc_password + "&smoking=" + isSmoker + "&gender=" + gender + "&age=" + age + "&usage=" + usage + "&date=" + theDate + "&time=" + theTime + "&calibration=0&value=" + exerciseType + "&integration=Ketonix&label=ExerciseType&key=84b5c80b96f2674f1de14e2ed5fcdc99&format=raw&public=" + publicUse;
/*      */       
/* 2259 */       URL myurl = new URL(httpsURL);
/* 2260 */       HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
/* 2261 */       InputStream ins = con.getInputStream();
/* 2262 */       InputStreamReader isr = new InputStreamReader(ins);
/* 2263 */       BufferedReader in = new BufferedReader(isr);
/* 2264 */       String inputLine; while ((inputLine = in.readLine()) != null)
/*      */       {
/* 2266 */         System.out.println(inputLine);
/* 2267 */         num_saved += (inputLine.contains("success") ? 1 : 0);
/*      */       }
/* 2269 */       in.close();
/*      */       
/*      */ 
/* 2272 */       if (num_saved != num_values) {
/* 2273 */         this.feedbackLabel.setText("Error: " + num_saved + " (of " + num_values + ") values saved");
/*      */       } else {
/* 2275 */         this.feedbackLabel.setText(num_saved + "  (of " + num_values + ") values saved");
/*      */       }
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 2280 */       System.err.println(ex.toString());
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private void viewDataMenuItemActionPerformed(ActionEvent evt)
/*      */   {
/*      */     try
/*      */     {
/* 2289 */       String url = "https://www.ketonix.com/index.php?option=com_ketonixchart&view=all&Itemid=427&lang=en";
/* 2290 */       Desktop.getDesktop().browse(URI.create(url));
/*      */     }
/*      */     catch (IOException e) {
/* 2293 */       System.out.println(e.getMessage());
/*      */     }
/*      */   }
/*      */   
/*      */   private void calibrateMenuItemActionPerformed(ActionEvent evt)
/*      */   {
/* 2299 */     setAlwaysOnTop(false);
/* 2300 */     CalibrateDialog dialog = new CalibrateDialog(new JFrame(), true, this);
/* 2301 */     dialog.setVisible(true);
/* 2302 */     dialog.toFront();
/* 2303 */     dialog.setAlwaysOnTop(true);
/*      */   }
/*      */   
/*      */ 
/*      */   private void mealMenuItemActionPerformed(ActionEvent evt)
/*      */   {
/* 2309 */     setAlwaysOnTop(false);
/* 2310 */     MealDialog dialog = new MealDialog(new JFrame(), true, this);
/* 2311 */     dialog.setVisible(true);
/* 2312 */     dialog.toFront();
/* 2313 */     dialog.setAlwaysOnTop(true);
/*      */   }
/*      */   
/*      */ 
/*      */   private void exerciseMenuItemActionPerformed(ActionEvent evt)
/*      */   {
/* 2319 */     setAlwaysOnTop(false);
/* 2320 */     ExerciseDialog dialog = new ExerciseDialog(new JFrame(), true, this);
/* 2321 */     dialog.setVisible(true);
/* 2322 */     dialog.toFront();
/* 2323 */     dialog.setAlwaysOnTop(true);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private void bloodTestMenuItemActionPerformed(ActionEvent evt)
/*      */   {
/* 2330 */     setAlwaysOnTop(false);
/* 2331 */     BodyMeasureDialog dialog = new BodyMeasureDialog(new JFrame(), true, this);
/* 2332 */     dialog.setVisible(true);
/* 2333 */     dialog.toFront();
/* 2334 */     dialog.setAlwaysOnTop(true);
/*      */   }
/*      */   
/*      */   private void bodyMeasureMenuItemActionPerformed(ActionEvent evt)
/*      */   {
/* 2339 */     setAlwaysOnTop(false);
/* 2340 */     BloodTestDialog dialog = new BloodTestDialog(new JFrame(), true, this);
/* 2341 */     dialog.setVisible(true);
/* 2342 */     dialog.toFront();
/* 2343 */     dialog.setAlwaysOnTop(true);
/*      */   }
/*      */   
/*      */   private void jMenuItem1ActionPerformed(ActionEvent evt) {
/* 2347 */     setAlwaysOnTop(false);
/* 2348 */     AboutDialog dialog = new AboutDialog(new JFrame(), true);
/* 2349 */     dialog.setVisible(true);
/* 2350 */     dialog.toFront();
/* 2351 */     dialog.setAlwaysOnTop(true);
/*      */   }
/*      */   
/*      */   private void CancelButtonMouseReleased(MouseEvent evt)
/*      */   {
/* 2356 */     this.StopAndSaveButton.setEnabled(false);
/* 2357 */     this.CancelButton.setEnabled(false);
/* 2358 */     this.StartButton.setEnabled(true);
/* 2359 */     this.isMeasuring = false;
/* 2360 */     this.gui_max_val = 0;
/* 2361 */     this.gui_max_raw = 0;
/* 2362 */     this.measureLoop.setContinousMode();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void StopAndSaveButtonActionPerformed(ActionEvent evt)
/*      */   {
/* 2372 */     this.isMeasuring = false;
/*      */     try {
/* 2374 */       System.setProperty("jsse.enableSNIExtension", "false");
/* 2375 */       DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
/* 2376 */       DateFormat tf = new SimpleDateFormat("HH-mm-ss");
/* 2377 */       Date today = Calendar.getInstance().getTime();
/* 2378 */       String theDate = df.format(today);
/* 2379 */       String theTime = tf.format(today);
/*      */       
/*      */ 
/* 2382 */       if (this.current_type == 2) {
/* 2383 */         double daValue = getMaxPPM();
/* 2384 */         logData(theDate, theTime, "AcetonePPM", String.format(Locale.ROOT, "%.1f", new Object[] { Double.valueOf(daValue) }));
/*      */       } else {
/* 2386 */         logData(theDate, theTime, "Acetone", "" + Math.round(100.0D * this.gui_max_val / 1024.0D));
/*      */       }
/*      */       
/* 2389 */       int ix = this.ProfileSelectorComboBox.getSelectedIndex();
/* 2390 */       String username = this.pm.getUserName(ix - 1);
/* 2391 */       if (username.isEmpty()) {
/* 2392 */         if (this.current_type == 2) {
/* 2393 */           this.feedbackLabel.setText("Measure " + String.format(Locale.ROOT, "%.1f", new Object[] { Double.valueOf(getMaxPPM()) }) + " PPM saved locally");
/*      */         } else {
/* 2395 */           this.feedbackLabel.setText("Measure " + Math.round(100.0D * this.gui_max_val / 1024.0D) + " saved locally");
/*      */         }
/* 2397 */         this.gui_max_val = 0;
/* 2398 */         this.gui_max_raw = 0;
/* 2399 */         this.StopAndSaveButton.setEnabled(false);
/* 2400 */         this.CancelButton.setEnabled(false);
/*      */         
/* 2402 */         this.measureLoop.setContinousMode();
/* 2403 */         return;
/*      */       }
/* 2405 */       String password = this.pm.getUserPassword(ix - 1);
/*      */       
/* 2407 */       String enc_username = URLEncoder.encode(username, "UTF-8");
/* 2408 */       String enc_password0 = URLEncoder.encode(password, "UTF-8");
/* 2409 */       String enc_password = URLEncoder.encode(enc_password0, "UTF-8");
/*      */       
/*      */ 
/* 2412 */       int publicUse = this.pm.allowAnonymousData(ix - 1) ? 1 : 0;
/*      */       
/* 2414 */       String isSmoker = this.pm.smoking(ix - 1);
/* 2415 */       String gender = this.pm.gender(ix - 1);
/* 2416 */       String age = this.pm.age(ix - 1);
/* 2417 */       String usage = this.pm.usage(ix - 1);
/*      */       
/* 2419 */       String httpsURL = "";
/* 2420 */       if (this.current_type == 2) {
/* 2421 */         String ketonixPPM = String.format(Locale.ROOT, "%.1f", new Object[] { Double.valueOf(getMaxPPM()) });
/* 2422 */         httpsURL = "https://www.ketonix.com/index.php?option=com_api&app=ketonix&resource=store&username=" + enc_username + "&password=" + enc_password + "&smoking=" + isSmoker + "&gender=" + gender + "&age=" + age + "&usage=" + usage + "&date=" + theDate + "&time=" + theTime + "&calibration=" + this.gui_cal + "&value=" + ketonixPPM + "&integration=Ketonix&label=KetonixPPM&key=84b5c80b96f2674f1de14e2ed5fcdc99&format=raw&public=" + publicUse;
/*      */       } else {
/* 2424 */         httpsURL = "https://www.ketonix.com/index.php?option=com_api&app=ketonix&resource=store&username=" + enc_username + "&password=" + enc_password + "&smoking=" + isSmoker + "&gender=" + gender + "&age=" + age + "&usage=" + usage + "&date=" + theDate + "&time=" + theTime + "&calibration=" + this.gui_cal + "&value=" + Math.round(100.0D * this.gui_max_val / 1024.0D) + "&integration=Ketonix&label=Ketonix&key=84b5c80b96f2674f1de14e2ed5fcdc99&format=raw&public=" + publicUse;
/*      */       }
/* 2426 */       URL myurl = new URL(httpsURL);
/* 2427 */       HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
/* 2428 */       InputStream ins = con.getInputStream();
/* 2429 */       InputStreamReader isr = new InputStreamReader(ins);
/* 2430 */       BufferedReader in = new BufferedReader(isr);
/*      */       
/*      */ 
/* 2433 */       String status = "";
/* 2434 */       String inputLine; while ((inputLine = in.readLine()) != null)
/*      */       {
/*      */ 
/* 2437 */         status = inputLine;
/*      */       }
/* 2439 */       in.close();
/* 2440 */       if (this.current_type == 2) {
/* 2441 */         this.feedbackLabel.setText("Saving value " + String.format(Locale.ROOT, "%.1f", new Object[] { Double.valueOf(getMaxPPM()) }) + " PPM: " + status);
/*      */       } else {
/* 2443 */         this.feedbackLabel.setText("Saving value " + Math.round(100.0D * this.gui_max_val / 1024.0D) + ": " + status);
/*      */       }
/*      */     }
/*      */     catch (Exception ex) {
/* 2447 */       System.err.println(ex.toString());
/* 2448 */       this.feedbackLabel.setText(ex.toString());
/*      */     }
/* 2450 */     this.gui_max_val = 0;
/* 2451 */     this.gui_max_raw = 0;
/* 2452 */     this.StopAndSaveButton.setEnabled(false);
/* 2453 */     this.CancelButton.setEnabled(false);
/* 2454 */     if (this.current_warmup >= 100) this.StartButton.setEnabled(true);
/* 2455 */     this.measureLoop.setContinousMode();
/*      */   }
/*      */   
/*      */   private void ProfileSelectorComboBoxActionPerformed(ActionEvent evt)
/*      */   {
/* 2460 */     int ix = this.ProfileSelectorComboBox.getSelectedIndex();
/* 2461 */     if ((ix > 0) && (this.current_warmup >= 100)) { this.StartButton.setEnabled(true);
/*      */     } else {
/* 2463 */       this.StartButton.setEnabled(false);
/*      */     }
/* 2465 */     if (ix == 0) this.feedbackLabel.setText("Select profile");
/* 2466 */     this.canvas1.revalidate();
/*      */   }
/*      */   
/*      */   private void localChartMenuItemButtonActionPerformed(ActionEvent evt)
/*      */   {
/* 2471 */     int ix = this.ProfileSelectorComboBox.getSelectedIndex();
/* 2472 */     String username = this.pm.getUserName(ix - 1);
/*      */     
/*      */ 
/* 2475 */     KetonixViewer kv = new KetonixViewer();
/* 2476 */     kv.setDataFile(this.pm.dataFile(ix - 1));
/* 2477 */     kv.setVisible(true);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private void StartButtonActionPerformed(ActionEvent evt)
/*      */   {
/* 2484 */     if (this.current_warmup < 100) {
/* 2485 */       this.feedbackLabel.setText("Wait until device is initialized");
/* 2486 */       return;
/*      */     }
/* 2488 */     this.StopAndSaveButton.setEnabled(true);
/* 2489 */     this.CancelButton.setEnabled(true);
/* 2490 */     this.StartButton.setEnabled(false);
/* 2491 */     this.isMeasuring = true;
/* 2492 */     this.measureStartTime = LocalTime.now();
/*      */     
/* 2494 */     this.measureLoop.setClassicMode();
/*      */   }
/*      */   
/*      */   private void AddCommentMenuItemActionPerformed(ActionEvent evt) {
/* 2498 */     CommentDialog cd = new CommentDialog(this, true);
/* 2499 */     cd.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jMenuItem2ActionPerformed(ActionEvent evt) {
/*      */     try {
/* 2504 */       String OS = System.getProperty("os.name").toLowerCase();
/* 2505 */       Process localProcess; if (OS.indexOf("win") >= 0) {
/* 2506 */         localProcess = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler http://www.ketonix.com/images/PDF/Ketonix-Manual-Current.pdf");
/*      */       } else {
/* 2508 */         localProcess = Runtime.getRuntime().exec("open http://www.ketonix.com/images/PDF/Ketonix-Manual-Current.pdf");
/*      */       }
/*      */     } catch (Exception ex) {
/* 2511 */       System.out.println(ex);
/*      */     }
/*      */   }
/*      */   
/*      */   private void jMenuItem3ActionPerformed(ActionEvent evt)
/*      */   {
/*      */     try {
/* 2518 */       String OS = System.getProperty("os.name").toLowerCase();
/* 2519 */       Process localProcess; if (OS.indexOf("win") >= 0) {
/* 2520 */         localProcess = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler https://www.ketonix.com/index.php?option=com_wrapper&view=wrapper&Itemid=642&lang=en");
/*      */       } else {
/* 2522 */         localProcess = Runtime.getRuntime().exec("open https://www.ketonix.com/index.php?option=com_wrapper&view=wrapper&Itemid=642&lang=en");
/*      */       }
/*      */     } catch (Exception ex) {
/* 2525 */       System.out.println(ex);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void main(String[] args)
/*      */   {
/*      */     try
/*      */     {
/* 2539 */       for (UIManager.LookAndFeelInfo info : ) {
/* 2540 */         if ("Nimbus".equals(info.getName())) {
/* 2541 */           UIManager.setLookAndFeel(info.getClassName());
/* 2542 */           break;
/*      */         }
/*      */       }
/*      */     } catch (ClassNotFoundException ex) {
/* 2546 */       Logger.getLogger(KSync.class.getName()).log(Level.SEVERE, null, ex);
/*      */     } catch (InstantiationException ex) {
/* 2548 */       Logger.getLogger(KSync.class.getName()).log(Level.SEVERE, null, ex);
/*      */     } catch (IllegalAccessException ex) {
/* 2550 */       Logger.getLogger(KSync.class.getName()).log(Level.SEVERE, null, ex);
/*      */     } catch (UnsupportedLookAndFeelException ex) {
/* 2552 */       Logger.getLogger(KSync.class.getName()).log(Level.SEVERE, null, ex);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 2557 */     EventQueue.invokeLater(new Runnable() {
/*      */       public void run() {
/* 2559 */         new KSync().setVisible(true);
/*      */       }
/*      */     });
/*      */   }
/*      */   
/*      */   public int getCurrentType()
/*      */   {
/* 2566 */     return this.current_type;
/*      */   }
/*      */   
/*      */   public int getCurrentId()
/*      */   {
/* 2571 */     return this.current_id;
/*      */   }
/*      */   
/*      */   public double raw2value(double raw)
/*      */   {
/* 2576 */     double value = raw * 1.10822510822511D - 110.82210822511D;
/* 2577 */     if (value < 0.0D) value = 0.0D;
/* 2578 */     return value;
/*      */   }
/*      */   
/*      */   public double value2raw(double value)
/*      */   {
/* 2583 */     double raw = (value + 110.82210822511D) / 1.10822510822511D;
/* 2584 */     return raw;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public double getCurrentPPM()
/*      */   {
/* 2592 */     double raw = 1.0D * this.current_value;
/* 2593 */     double daValue = 0.1385D * Math.exp(0.0077D * raw);
/* 2594 */     daValue -= 0.3385D;
/* 2595 */     return daValue > 0.0D ? daValue : 0.0D;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public double getMaxPPM()
/*      */   {
/* 2603 */     double raw = 1.0D * this.gui_max_val;
/* 2604 */     double daValue = 0.1385D * Math.exp(0.0077D * raw);
/* 2605 */     daValue -= 0.3385D;
/* 2606 */     return daValue > 0.0D ? daValue : 0.0D;
/*      */   }
/*      */   
/*      */ 
/*      */   public void setCurrentValues()
/*      */   {
/* 2612 */     this.gui_raw = this.current_raw;
/*      */     
/* 2614 */     this.gui_val = this.current_value;
/*      */     
/* 2616 */     this.gui_cal = this.current_cal;
/*      */     
/* 2618 */     Graphics2D g = (Graphics2D)this.canvas1.getGraphics();
/*      */     
/* 2620 */     g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
/*      */     
/*      */ 
/* 2623 */     Rectangle2D rect = new Rectangle2D.Double(0.0D, 0.0D, this.canvas1.getWidth(), this.canvas1.getHeight());
/* 2624 */     g.setClip(rect);
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 2629 */     if (this.iconType != this.current_type) {
/* 2630 */       if (this.current_type == 0) {
/* 2631 */         this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/resources/images/KetonixBlue.png")));
/* 2632 */         this.unitLabel.setText("units");
/* 2633 */       } else if (this.current_type == 1) {
/* 2634 */         this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/resources/images/KetonixRed.png")));
/* 2635 */         this.unitLabel.setText("units");
/* 2636 */       } else if (this.current_type == 2) {
/* 2637 */         this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/resources/images/KetonixUSB.png")));
/* 2638 */         this.unitLabel.setText("PPM");
/* 2639 */       } else if (this.current_type == -1) {
/* 2640 */         this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/resources/images/KetonixGrey.png")));
/* 2641 */         this.unitLabel.setText("units");
/*      */       }
/* 2643 */       this.iconType = this.current_type;
/*      */     }
/*      */     
/* 2646 */     if (this.isMeasuring) {
/* 2647 */       this.gui_max_val = (this.gui_val > this.gui_max_val ? this.gui_val : this.gui_max_val);
/* 2648 */       this.gui_val = this.gui_max_val;
/*      */       
/* 2650 */       this.gui_max_raw = (this.gui_raw > this.gui_max_raw ? this.gui_raw : this.gui_max_raw);
/* 2651 */       this.gui_raw = this.gui_max_raw;
/*      */     }
/*      */     
/* 2654 */     int w = this.canvas1.getWidth();
/* 2655 */     int h = this.canvas1.getHeight();
/* 2656 */     g.setColor(new Color(0, 0, 0));
/* 2657 */     g.fillRect(0, 0, w, h);
/* 2658 */     g.setColor(new Color(255, 255, 255));
/* 2659 */     g.fillRect(1, 1, w - 2, h - 2);
/*      */     
/* 2661 */     if (this.current_warmup < 100) {
/* 2662 */       this.is_warming_up = true;
/* 2663 */       this.feedbackLabel.setText("KETONIX® initializing, wait ...");
/* 2664 */       if (this.StartButton.isEnabled()) this.StartButton.setEnabled(false);
/* 2665 */       g.setColor(new Color(25, 25, 255));
/* 2666 */       g.fillRect(1, 1, w * this.current_warmup / 100 - 1, h - 1);
/*      */       
/* 2668 */       Font stringFont = new Font("Sans", 1, 18);
/* 2669 */       g.setFont(stringFont);
/* 2670 */       FontMetrics fm = g.getFontMetrics();
/*      */       
/*      */ 
/*      */ 
/* 2674 */       String sval = " Initializing, wait ... " + this.current_warmup + "%";
/* 2675 */       int vw = fm.stringWidth(sval);
/* 2676 */       int vh = 18;
/*      */       
/*      */ 
/* 2679 */       g.setColor(new Color(255, 255, 255));
/* 2680 */       g.fillRect(w / 2 - vw / 2, h / 2 - vh / 2, vw + 1, vh + 1);
/* 2681 */       g.setColor(new Color(0, 0, 0));
/* 2682 */       g.drawString(sval, w / 2 - vw / 2, h / 2 + vh / 2 - 2);
/*      */       
/* 2684 */       return;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 2689 */     int profile_selected = this.ProfileSelectorComboBox.getSelectedIndex() > 0 ? 1 : 0;
/*      */     
/*      */ 
/* 2692 */     if (this.is_warming_up) {
/* 2693 */       if (profile_selected == 1) {
/* 2694 */         this.feedbackLabel.setText("Ready to take a measurement, click Start");
/*      */       } else {
/* 2696 */         this.feedbackLabel.setText("Select a profile, then click Start");
/*      */       }
/* 2698 */       this.is_warming_up = false;
/*      */     }
/*      */     
/* 2701 */     int daVal = this.gui_val;
/*      */     
/* 2703 */     if (this.isMeasuring) { daVal = this.gui_max_val;
/*      */     }
/* 2705 */     if ((!this.StartButton.isEnabled()) && (this.current_warmup >= 100) && (profile_selected == 1) && (!this.isMeasuring)) { this.StartButton.setEnabled(true);
/*      */     }
/* 2707 */     if (this.gui_val > this.current_green)
/*      */     {
/* 2709 */       g.setColor(new Color(0, 0, 255));
/* 2710 */       g.fillRect(1, 1, this.current_green * w / 1024, h - 2);
/*      */     }
/*      */     else
/*      */     {
/* 2714 */       g.setColor(new Color(0, 0, 255));
/* 2715 */       g.fillRect(1, 1, daVal * w / 1024, h - 2);
/*      */     }
/*      */     
/*      */ 
/* 2719 */     if (daVal > this.current_yellow)
/*      */     {
/* 2721 */       g.setColor(new Color(0, 255, 0));
/* 2722 */       g.fillRect(this.current_green * w / 1024, 1, (this.current_yellow - this.current_green) * w / 1024, h - 2);
/*      */     }
/* 2724 */     else if ((daVal > this.current_green) && (daVal < this.current_yellow))
/*      */     {
/* 2726 */       g.setColor(new Color(0, 255, 0));
/* 2727 */       g.fillRect(this.current_green * w / 1024, 1, (daVal - this.current_green) * w / 1024, h - 2);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 2732 */     if (daVal > this.current_red)
/*      */     {
/* 2734 */       g.setColor(new Color(255, 255, 0));
/* 2735 */       g.fillRect(this.current_yellow * w / 1024, 1, (this.current_red - this.current_yellow) * w / 1024, h - 2);
/*      */     }
/* 2737 */     else if ((daVal > this.current_yellow) && (daVal < this.current_red))
/*      */     {
/* 2739 */       g.setColor(new Color(255, 255, 0));
/* 2740 */       g.fillRect(this.current_yellow * w / 1024, 1, (daVal - this.current_yellow) * w / 1024, h - 2);
/*      */     }
/*      */     
/*      */ 
/* 2744 */     if (daVal > this.current_red)
/*      */     {
/* 2746 */       g.setColor(new Color(255, 0, 0));
/* 2747 */       g.fillRect(this.current_red * w / 1024, 1, (daVal - this.current_red) * w / 1024, h - 2);
/*      */     }
/*      */     
/*      */ 
/* 2751 */     Font stringFont = new Font("Sans", 1, 18);
/* 2752 */     g.setFont(stringFont);
/* 2753 */     FontMetrics fm = g.getFontMetrics();
/*      */     
/* 2755 */     String sval = " " + Math.round(100.0D * this.gui_val / 1024.0D) + " ";
/* 2756 */     if (this.current_type == -1)
/*      */     {
/* 2758 */       sval = " device unplugged ";
/* 2759 */       this.is_warming_up = true;
/* 2760 */       this.StartButton.setEnabled(false);
/* 2761 */       this.feedbackLabel.setText("Connect your KETONIX®");
/*      */     }
/*      */     
/* 2764 */     if (this.current_type == 2)
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2772 */       if (this.isMeasuring) {
/* 2773 */         double daValue = getMaxPPM();
/*      */         
/* 2775 */         sval = String.format(Locale.ROOT, "%.1f", new Object[] { Double.valueOf(daValue) });
/*      */       } else {
/* 2777 */         double daValue = getCurrentPPM();
/*      */         
/* 2779 */         sval = String.format(Locale.ROOT, "%.1f", new Object[] { Double.valueOf(daValue) });
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 2784 */     int vw = fm.stringWidth(sval);
/* 2785 */     int vh = 18;
/*      */     
/*      */ 
/* 2788 */     g.setColor(new Color(255, 255, 255));
/* 2789 */     g.fillRect(w / 2 - vw / 2, h / 2 - vh / 2, vw, vh);
/* 2790 */     g.setColor(new Color(0, 0, 0));
/* 2791 */     g.drawString(sval, w / 2 - vw / 2, h / 2 + vh / 2 - 1);
/*      */   }
/*      */   
/*      */   public void resumeMeasure() {}
/*      */   
/*      */   private void listDevices() {}
/*      */   
/*      */   private void StartButtonMouseReleased(MouseEvent evt) {}
/*      */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/com/ketonix/ketonixpro/KSync.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */