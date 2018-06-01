/*     */ package datechooser.beans.locale;
/*     */ 
/*     */ import java.util.ResourceBundle;
/*     */ import javax.swing.UIManager;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LocaleUtils
/*     */ {
/*     */   private static final int EDITOR_BUNDLE = 0;
/*     */   private static final int CALENDAR_BUNDLE = 1;
/*     */   private static final int ERROR_BUNDLE = 2;
/*     */   private static final int CONFIG_BUNDLE = 3;
/*     */   private static final int GLOBAL_BUNDLE = 4;
/*     */   private static final int BUNDLES_COUNT = 5;
/*  32 */   private static ResourceBundle[] bundles = null;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void prepareStandartDialogButtonText()
/*     */   {
/*  39 */     UIManager.put("OptionPane.cancelButtonText", getConfigLocaleString("Cancel"));
/*  40 */     UIManager.put("OptionPane.yesButtonText", getConfigLocaleString("Yes"));
/*  41 */     UIManager.put("OptionPane.noButtonText", getConfigLocaleString("No"));
/*  42 */     UIManager.put("FileChooser.cancelButtonText", getConfigLocaleString("Cancel"));
/*  43 */     UIManager.put("FileChooser.directoryOpenButtonText", getConfigLocaleString("Open"));
/*  44 */     UIManager.put("FileChooser.updateButtonText", getConfigLocaleString("Update"));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void reset()
/*     */   {
/*  51 */     bundles = null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static String getEditorLocaleString(String key)
/*     */   {
/*  58 */     return getLocaleString(0, key);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static String getCalendarLocaleString(String key)
/*     */   {
/*  65 */     return getLocaleString(1, key);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static String getErrorsLocaleString(String key)
/*     */   {
/*  72 */     return getLocaleString(2, key);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static String getConfigLocaleString(String key)
/*     */   {
/*  79 */     return getLocaleString(3, key);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private LocaleUtils() {}
/*     */   
/*     */ 
/*     */ 
/*     */   private static String tryGetGlobal(String key)
/*     */   {
/*  90 */     String result = null;
/*     */     try {
/*  92 */       result = bundles[4].getString(key);
/*     */       
/*  94 */       return result; } finally {} return result;
/*     */   }
/*     */   
/*     */   private static String getLocaleString(int bundle, String key)
/*     */   {
/*  99 */     if (bundles == null) {
/* 100 */       initBundles();
/*     */     }
/* 102 */     String result = tryGetGlobal(key);
/* 103 */     if (result == null) {
/* 104 */       result = bundles[bundle].getString(key);
/*     */     }
/* 106 */     return result;
/*     */   }
/*     */   
/*     */   private static void initBundles() {
/* 110 */     bundles = new ResourceBundle[5];
/* 111 */     bundles[0] = ResourceBundle.getBundle("datechooser/beans/locale/editors");
/* 112 */     bundles[1] = ResourceBundle.getBundle("datechooser/beans/locale/calendar");
/* 113 */     bundles[2] = ResourceBundle.getBundle("datechooser/beans/locale/errors");
/* 114 */     bundles[3] = ResourceBundle.getBundle("datechooser/beans/locale/config");
/* 115 */     bundles[4] = ResourceBundle.getBundle("datechooser/beans/locale/global");
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/locale/LocaleUtils.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */