/*    */ package datechooser.beans;
/*    */ 
/*    */ import datechooser.beans.editor.DateFormatEditor;
/*    */ import datechooser.beans.editor.border.SimpleBorderEditor;
/*    */ import datechooser.beans.editor.font.SimpleFontEditor;
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
/*    */ public class DateChooserComboBeanInfo
/*    */   extends AbstractDateChooserBeanInfo
/*    */ {
/*    */   public DateChooserComboBeanInfo() {}
/*    */   
/*    */   protected String getDisplayName()
/*    */   {
/* 29 */     return LocaleUtils.getCalendarLocaleString("Date_chooser_combo");
/*    */   }
/*    */   
/*    */   protected String getPicturePrefix() {
/* 33 */     return "combo";
/*    */   }
/*    */   
/*    */   protected Class getBeanClass() {
/* 37 */     return DateChooserCombo.class;
/*    */   }
/*    */   
/*    */   protected Class getCustomizerClass() {
/* 41 */     return DateChooserComboCustomizer.class;
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
/* 53 */     ArrayList<PropertyDescriptor> descriptors = new ArrayList();
/*    */     
/* 55 */     PropertyDescriptor border = new PropertyDescriptor("dch_combo_border", getBeanClass(), "getBorder", "setBorder");
/*    */     
/* 57 */     border.setPropertyEditorClass(SimpleBorderEditor.class);
/* 58 */     border.setDisplayName(LocaleUtils.getCalendarLocaleString("Border"));
/* 59 */     border.setShortDescription(LocaleUtils.getCalendarLocaleString("Border_descript"));
/* 60 */     descriptors.add(border);
/*    */     
/* 62 */     PropertyDescriptor fieldFont = new PropertyDescriptor("dch_combo_fieldFont", getBeanClass(), "getFieldFont", "setFieldFont");
/*    */     
/* 64 */     fieldFont.setPropertyEditorClass(SimpleFontEditor.class);
/* 65 */     fieldFont.setDisplayName(LocaleUtils.getCalendarLocaleString("Field_font"));
/* 66 */     fieldFont.setShortDescription(LocaleUtils.getCalendarLocaleString("Field_font_descript"));
/* 67 */     descriptors.add(fieldFont);
/*    */     
/* 69 */     PropertyDescriptor dateFormat = new PropertyDescriptor("dch_combo_dateFormat", getBeanClass(), "getFormat", "setFormat");
/*    */     
/* 71 */     dateFormat.setPropertyEditorClass(DateFormatEditor.class);
/* 72 */     dateFormat.setDisplayName(LocaleUtils.getCalendarLocaleString("DateFormat"));
/* 73 */     dateFormat.setShortDescription(LocaleUtils.getCalendarLocaleString("DateFormat_descript"));
/* 74 */     descriptors.add(dateFormat);
/*    */     
/* 76 */     return descriptors;
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/DateChooserComboBeanInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */