/*     */ package datechooser.autorun;
/*     */ 
/*     */ import datechooser.beans.DateChooserBean;
/*     */ import datechooser.beans.customizer.DateChooserCustomizer;
/*     */ import datechooser.beans.customizer.PropertyDescriptorsHolder;
/*     */ import java.beans.BeanDescriptor;
/*     */ import java.beans.BeanInfo;
/*     */ import java.beans.PropertyChangeEvent;
/*     */ import java.beans.PropertyChangeListener;
/*     */ import java.io.File;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JPanel;
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
/*     */ public abstract class ConfigBean
/*     */   extends JPanel
/*     */   implements PropertyChangeListener
/*     */ {
/*     */   public static final String OK = "ok";
/*     */   private DateChooserBean bean;
/*     */   private DateChooserCustomizer customizer;
/*     */   private File file;
/*     */   private boolean saved;
/*     */   
/*     */   protected ConfigBean(DateChooserBean bean, DateChooserCustomizer customizer)
/*     */   {
/*  44 */     setFile(null);
/*  45 */     setBean(bean);
/*  46 */     setCustomizer(customizer);
/*  47 */     getCustomizer().setObject(getBean());
/*  48 */     getCustomizer().addPropertyChangeListener(this);
/*  49 */     setSaved(true);
/*     */     
/*  51 */     setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String toString()
/*     */   {
/*  60 */     return getBeanInfo().getBeanDescriptor().getDisplayName();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void propertyChange(PropertyChangeEvent evt)
/*     */   {
/*  70 */     setSaved(false);
/*  71 */     if ((getBean() instanceof JComponent)) {
/*  72 */       ((JComponent)getBean()).repaint();
/*     */     }
/*     */   }
/*     */   
/*     */   protected DateChooserBean getBean() {
/*  77 */     return this.bean;
/*     */   }
/*     */   
/*     */   private void setBean(DateChooserBean bean) {
/*  81 */     this.bean = bean;
/*     */   }
/*     */   
/*     */   protected DateChooserCustomizer getCustomizer() {
/*  85 */     return this.customizer;
/*     */   }
/*     */   
/*     */   private void setCustomizer(DateChooserCustomizer customizer) {
/*  89 */     this.customizer = customizer;
/*     */   }
/*     */   
/*     */   protected BeanInfo getBeanInfo() {
/*  93 */     return getCustomizer().getBeanInfo();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBeanDisplayName()
/*     */   {
/*     */     try
/*     */     {
/* 103 */       return getBeanInfo().getBeanDescriptor().getDisplayName();
/*     */     } catch (NullPointerException ex) {}
/* 105 */     return "?";
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String writeToFile(File file)
/*     */   {
/* 116 */     setFile(file);
/* 117 */     setSaved(true);
/* 118 */     return getCustomizer().getHolder().writeToFile(file);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String readFromFile(File file)
/*     */   {
/* 128 */     setFile(file);
/* 129 */     setSaved(true);
/* 130 */     return getCustomizer().getHolder().readFromFile(file);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public abstract String getFileExt();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public File getFile()
/*     */   {
/* 146 */     return this.file;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setFile(File file)
/*     */   {
/* 155 */     this.file = file;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isSaved()
/*     */   {
/* 164 */     return this.saved;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSaved(boolean saved)
/*     */   {
/* 173 */     this.saved = saved;
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/autorun/ConfigBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */