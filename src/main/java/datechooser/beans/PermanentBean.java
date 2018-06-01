/*     */ package datechooser.beans;
/*     */ 
/*     */ import datechooser.beans.customizer.DateChooserCustomizer;
/*     */ import datechooser.beans.customizer.PropertyDescriptorsHolder;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.InputStream;
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
/*     */ public class PermanentBean
/*     */ {
/*  27 */   private static final DateChooserCustomizer[] customizers = { null, null, null };
/*     */   
/*     */ 
/*     */   private static final int PANEL = 0;
/*     */   
/*     */   private static final int DIALOG = 0;
/*     */   
/*     */   private static final int COMBO = 0;
/*     */   
/*  36 */   private static boolean saveBeanContext = false;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public PermanentBean() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void dispose()
/*     */   {
/*  48 */     for (int i = 0; i < customizers.length; i++) {
/*  49 */       customizers[i] = null;
/*     */     }
/*     */   }
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
/*     */   public static boolean isSaveBeanContext()
/*     */   {
/*  72 */     return saveBeanContext;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void setSaveBeanContext(boolean aSaveBeanContext)
/*     */   {
/*  80 */     saveBeanContext = aSaveBeanContext;
/*     */   }
/*     */   
/*     */   private static String loadBeanParameters(int beanID, Class customizerClass, Object bean, InputStream from) {
/*  84 */     DateChooserCustomizer customizer = customizers[beanID];
/*  85 */     if (customizer == null) {
/*     */       try {
/*  87 */         customizer = (DateChooserCustomizer)customizerClass.newInstance();
/*     */       } catch (Exception ex) {
/*  89 */         return ex.getClass().getName();
/*     */       }
/*     */     }
/*  92 */     customizer.setObject(bean);
/*  93 */     String result = customizer.getHolder().readFromStream(from);
/*  94 */     if (isSaveBeanContext()) {
/*  95 */       customizers[beanID] = customizer;
/*     */     } else {
/*  97 */       customizers[beanID] = null;
/*     */     }
/*  99 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String loadBeanParameters(DateChooserPanel panel, InputStream from)
/*     */   {
/* 109 */     return loadBeanParameters(0, DateChooserPanelCustomizer.class, panel, from);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String loadBeanParameters(DateChooserDialog dialog, InputStream from)
/*     */   {
/* 119 */     return loadBeanParameters(0, DateChooserDialogCustomizer.class, dialog, from);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String loadBeanParameters(DateChooserCombo combo, InputStream from)
/*     */   {
/* 129 */     return loadBeanParameters(0, DateChooserComboCustomizer.class, combo, from);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String loadBeanParameters(DateChooserPanel panel, File from)
/*     */     throws FileNotFoundException
/*     */   {
/* 141 */     return loadBeanParameters(panel, new FileInputStream(from));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String loadBeanParameters(DateChooserDialog dialog, File from)
/*     */     throws FileNotFoundException
/*     */   {
/* 153 */     return loadBeanParameters(dialog, new FileInputStream(from));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String loadBeanParameters(DateChooserCombo combo, File from)
/*     */     throws FileNotFoundException
/*     */   {
/* 165 */     return loadBeanParameters(combo, new FileInputStream(from));
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/PermanentBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */