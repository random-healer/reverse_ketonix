/*    */ package datechooser.beans;
/*    */ 
/*    */ import datechooser.beans.editor.border.SimpleBorderEditor;
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
/*    */ 
/*    */ 
/*    */ public class DateChooserPanelBeanInfo
/*    */   extends AbstractDateChooserBeanInfo
/*    */ {
/*    */   public DateChooserPanelBeanInfo() {}
/*    */   
/*    */   protected String getDisplayName()
/*    */   {
/* 28 */     return LocaleUtils.getCalendarLocaleString("Date_chooser_panel");
/*    */   }
/*    */   
/*    */   protected String getPicturePrefix() {
/* 32 */     return "panel";
/*    */   }
/*    */   
/*    */   protected Class getBeanClass() {
/* 36 */     return DateChooserPanel.class;
/*    */   }
/*    */   
/*    */   protected Class getCustomizerClass() {
/* 40 */     return DateChooserPanelCustomizer.class;
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
/* 52 */     ArrayList<PropertyDescriptor> descriptors = new ArrayList();
/*    */     
/* 54 */     PropertyDescriptor border = new PropertyDescriptor("dch_panel_border", getBeanClass(), "getBorder", "setBorder");
/*    */     
/* 56 */     border.setPropertyEditorClass(SimpleBorderEditor.class);
/* 57 */     border.setDisplayName(LocaleUtils.getCalendarLocaleString("Border"));
/* 58 */     border.setShortDescription(LocaleUtils.getCalendarLocaleString("Border_descript"));
/* 59 */     descriptors.add(border);
/*    */     
/* 61 */     return descriptors;
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/DateChooserPanelBeanInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */