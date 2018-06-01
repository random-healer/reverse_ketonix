/*    */ package datechooser.beans;
/*    */ 
/*    */ import datechooser.beans.locale.LocaleUtils;
/*    */ import java.beans.IntrospectionException;
/*    */ import java.beans.PropertyDescriptor;
/*    */ import java.util.ArrayList;
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
/*    */ public class DateChooserDialogBeanInfo
/*    */   extends AbstractDateChooserBeanInfo
/*    */ {
/*    */   public DateChooserDialogBeanInfo() {}
/*    */   
/*    */   protected String getDisplayName()
/*    */   {
/* 25 */     return LocaleUtils.getCalendarLocaleString("Date_chooser_dialog");
/*    */   }
/*    */   
/*    */   protected String getPicturePrefix() {
/* 29 */     return "dialog";
/*    */   }
/*    */   
/*    */   protected Class getBeanClass() {
/* 33 */     return DateChooserDialog.class;
/*    */   }
/*    */   
/*    */   protected Class getCustomizerClass() {
/* 37 */     return DateChooserDialogCustomizer.class;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public ArrayList<PropertyDescriptor> getAdditionalDescriptors()
/*    */     throws IntrospectionException
/*    */   {
/* 49 */     ArrayList<PropertyDescriptor> descriptors = new ArrayList();
/*    */     
/* 51 */     PropertyDescriptor modal = new PropertyDescriptor("dch_dialog_modal", getBeanClass(), "isModal", "setModal");
/*    */     
/* 53 */     modal.setDisplayName(LocaleUtils.getCalendarLocaleString("Modal"));
/* 54 */     modal.setShortDescription(LocaleUtils.getCalendarLocaleString("Modal_descript"));
/* 55 */     descriptors.add(modal);
/*    */     
/* 57 */     PropertyDescriptor caption = new PropertyDescriptor("dch_dialog_caption", getBeanClass(), "getCaption", "setCaption");
/*    */     
/* 59 */     caption.setDisplayName(LocaleUtils.getCalendarLocaleString("Caption"));
/* 60 */     caption.setShortDescription(LocaleUtils.getCalendarLocaleString("Caption_descript"));
/* 61 */     descriptors.add(caption);
/*    */     
/* 63 */     return descriptors;
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/DateChooserDialogBeanInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */