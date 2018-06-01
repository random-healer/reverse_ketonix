/*     */ package datechooser.beans.editor.descriptor;
/*     */ 
/*     */ import datechooser.beans.locale.LocaleUtils;
/*     */ import java.text.MessageFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Locale;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DescriptionManager
/*     */ {
/*  35 */   private static DescriptionManager instance = new DescriptionManager();
/*  36 */   private ArrayList<ClassDescriptor> descriptors = new ArrayList();
/*     */   
/*     */   private DescriptionManager() {
/*  39 */     registerDescriptor(new FontDescriptor());
/*  40 */     registerDescriptor(new ColorDescriptor());
/*  41 */     registerDescriptor(new BorderDescriptor());
/*  42 */     registerDescriptor(new CustomCellAppearanceDescriptor());
/*  43 */     registerDescriptor(new SwingCellAppearanceDescriptor());
/*  44 */     registerDescriptor(new ModelBehaviorDescriptor());
/*  45 */     registerDescriptor(new ViewDescriptor());
/*  46 */     registerDescriptor(new AppearancesListDescriptor());
/*  47 */     registerDescriptor(new GregorianCalendarDescriptor());
/*  48 */     registerDescriptor(new PeriodDescriptor());
/*  49 */     registerDescriptor(new PeriodSetDescriptor());
/*  50 */     registerDescriptor(new LocaleDescriptor());
/*  51 */     registerDescriptor(new IntegerDescriptor());
/*  52 */     registerDescriptor(new StringDescriptor());
/*  53 */     registerDescriptor(new WeekDaysStyleDescriptor());
/*  54 */     registerDescriptor(new BackRendererDescriptor());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void registerDescriptor(ClassDescriptor descriptor)
/*     */   {
/*  64 */     this.descriptors.add(descriptor);
/*     */   }
/*     */   
/*     */   private ClassDescriptor getDescriptor(Class aClass) {
/*  68 */     for (ClassDescriptor elem : this.descriptors) {
/*  69 */       if (elem.getDescriptedClass().isAssignableFrom(aClass)) {
/*  70 */         return elem;
/*     */       }
/*     */     }
/*  73 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String describe(Object value)
/*     */   {
/*  84 */     return describe(value, null);
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
/*     */   public static String describe(Object value, Locale locale)
/*     */   {
/*  97 */     if (value == null) {
/*  98 */       return LocaleUtils.getEditorLocaleString("null");
/*     */     }
/* 100 */     ClassDescriptor descriptor = instance.getDescriptor(value.getClass());
/* 101 */     if (descriptor == null) { return MessageFormat.format(LocaleUtils.getEditorLocaleString("cant_describe_message"), new Object[] { value.getClass().getName() });
/*     */     }
/*     */     
/* 104 */     return locale == null ? descriptor.getDescription(value) : descriptor.getDescription(value, locale);
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
/*     */   public static String describeJava(Object value, Class aClass)
/*     */   {
/* 121 */     ClassDescriptor descriptor = instance.getDescriptor(aClass);
/* 122 */     if (descriptor == null) { return "new " + value.getClass().getName() + "() /*" + LocaleUtils.getEditorLocaleString("no_java_init_default_used") + "*/";
/*     */     }
/* 124 */     if ((value == null) && (!descriptor.canProcessNull())) {
/* 125 */       return "(" + aClass.getName() + ")null";
/*     */     }
/* 127 */     return descriptor.getJavaDescription(value);
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/descriptor/DescriptionManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */