/*     */ package datechooser.beans;
/*     */ 
/*     */ import java.beans.BeanDescriptor;
/*     */ import java.beans.BeanInfo;
/*     */ import java.beans.PropertyDescriptor;
/*     */ import java.lang.reflect.Method;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BeanUtils
/*     */ {
/*  13 */   private static AbstractDateChooserBeanInfo[] info = { null, null, null };
/*     */   private static final byte PANEL = 0;
/*     */   private static final byte COMBO = 1;
/*     */   private static final byte DIALOG = 2;
/*     */   
/*     */   public BeanUtils() {}
/*     */   
/*  20 */   private static AbstractDateChooserBeanInfo getDateChooserBeanInfo(DateChooserBean bean) { if (bean == null) return null;
/*  21 */     if ((bean instanceof DateChooserPanel)) {
/*  22 */       if (info[0] == null) info[0] = new DateChooserPanelBeanInfo();
/*  23 */       return info[0];
/*     */     }
/*  25 */     if ((bean instanceof DateChooserCombo)) {
/*  26 */       if (info[1] == null) info[1] = new DateChooserComboBeanInfo();
/*  27 */       return info[1];
/*     */     }
/*  29 */     if ((bean instanceof DateChooserDialog)) {
/*  30 */       if (info[2] == null) info[2] = new DateChooserDialogBeanInfo();
/*  31 */       return info[2];
/*     */     }
/*  33 */     throw new IllegalArgumentException("BeanInfo not found for " + bean.getClass().getName());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void assignBean(DateChooserBean srcBean, DateChooserBean trgBean)
/*     */   {
/*  43 */     assignBean(srcBean, trgBean, getDateChooserBeanInfo(srcBean));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static DateChooserBean cloneBean(DateChooserBean bean)
/*     */   {
/*  53 */     return (DateChooserBean)cloneBean(bean, getDateChooserBeanInfo(bean));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Object cloneBean(Object bean, BeanInfo beanInfo)
/*     */   {
/*  64 */     if (!beanInfo.getBeanDescriptor().getBeanClass().equals(bean.getClass())) {
/*  65 */       throw new IllegalArgumentException("Bad beaninfo for bean");
/*     */     }
/*  67 */     Object newBean = null;
/*     */     try {
/*  69 */       newBean = bean.getClass().newInstance();
/*     */     } catch (Exception ex) {
/*  71 */       throw new IllegalArgumentException("Cant create bean", ex);
/*     */     }
/*  73 */     assignBean(bean, newBean, beanInfo);
/*  74 */     return newBean;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void assignBean(Object srcBean, Object trgBean, BeanInfo beanInfo)
/*     */   {
/*  85 */     if (!srcBean.getClass().equals(trgBean.getClass())) {
/*  86 */       throw new IllegalArgumentException("Cant assign beans of different classes");
/*     */     }
/*  88 */     if (!beanInfo.getBeanDescriptor().getBeanClass().equals(srcBean.getClass())) {
/*  89 */       throw new IllegalArgumentException("Bad beaninfo for bean");
/*     */     }
/*  91 */     PropertyDescriptor[] descr = beanInfo.getPropertyDescriptors();
/*  92 */     PropertyDescriptor currDescr = null;
/*  93 */     for (int i = 0; i < descr.length; i++) {
/*  94 */       currDescr = descr[i];
/*  95 */       Method writeM = currDescr.getWriteMethod();
/*  96 */       Method readM = currDescr.getReadMethod();
/*  97 */       if (writeM != null) {
/*     */         try {
/*  99 */           writeM.invoke(trgBean, new Object[] { readM.invoke(srcBean, new Object[0]) });
/*     */         } catch (Exception ex) {
/* 101 */           throw new IllegalArgumentException("Cant set property", ex);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/BeanUtils.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */