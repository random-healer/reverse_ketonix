/*     */ package datechooser.beans;
/*     */ 
/*     */ import datechooser.beans.editor.ModelBehaviorEditor;
/*     */ import datechooser.beans.editor.NavigatePaneEditor;
/*     */ import datechooser.beans.editor.SimpleColorEditor;
/*     */ import datechooser.beans.editor.WeekDaysStyleEditor;
/*     */ import datechooser.beans.editor.appear.AppearEditor;
/*     */ import datechooser.beans.editor.dates.DateEditor;
/*     */ import datechooser.beans.editor.dates.PeriodsEditor;
/*     */ import datechooser.beans.editor.dimension.SimpleDimensionEditor;
/*     */ import datechooser.beans.editor.font.SimpleFontEditor;
/*     */ import datechooser.beans.editor.locale.LocaleEditor;
/*     */ import datechooser.beans.locale.LocaleUtils;
/*     */ import datechooser.events.CommitListener;
/*     */ import datechooser.events.CursorMoveListener;
/*     */ import datechooser.events.SelectionChangedListener;
/*     */ import java.awt.Image;
/*     */ import java.beans.BeanDescriptor;
/*     */ import java.beans.EventSetDescriptor;
/*     */ import java.beans.IntrospectionException;
/*     */ import java.beans.PropertyDescriptor;
/*     */ import java.beans.SimpleBeanInfo;
/*     */ import java.util.ArrayList;
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
/*     */ public abstract class AbstractDateChooserBeanInfo
/*     */   extends SimpleBeanInfo
/*     */ {
/*     */   public AbstractDateChooserBeanInfo() {}
/*     */   
/*     */   public EventSetDescriptor[] getEventSetDescriptors()
/*     */   {
/*     */     try
/*     */     {
/*  44 */       EventSetDescriptor commit = new EventSetDescriptor(getBeanClass(), "commit", CommitListener.class, "onCommit");
/*     */       
/*  46 */       commit.setDisplayName(LocaleUtils.getCalendarLocaleString("commit"));
/*  47 */       commit.setShortDescription(LocaleUtils.getCalendarLocaleString("commit_descript"));
/*     */       
/*  49 */       EventSetDescriptor selChanged = new EventSetDescriptor(getBeanClass(), "selectionChanged", SelectionChangedListener.class, "onSelectionChange");
/*     */       
/*  51 */       selChanged.setDisplayName(LocaleUtils.getCalendarLocaleString("selChange"));
/*  52 */       selChanged.setShortDescription(LocaleUtils.getCalendarLocaleString("selChange_descript"));
/*     */       
/*  54 */       EventSetDescriptor cursorMoved = new EventSetDescriptor(getBeanClass(), "cursorMove", CursorMoveListener.class, "onCursorMove");
/*     */       
/*  56 */       cursorMoved.setDisplayName(LocaleUtils.getCalendarLocaleString("onCursorMove"));
/*  57 */       cursorMoved.setShortDescription(LocaleUtils.getCalendarLocaleString("onCursorMove_descript"));
/*     */       
/*  59 */       return new EventSetDescriptor[] { commit, selChanged, cursorMoved };
/*     */     } catch (IntrospectionException ex) {
/*  61 */       throw new RuntimeException(ex.getMessage());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public PropertyDescriptor[] getPropertyDescriptors()
/*     */   {
/*  71 */     ArrayList<PropertyDescriptor> descriptors = new ArrayList();
/*     */     try {
/*  73 */       PropertyDescriptor defDate = new PropertyDescriptor("dch_defaultDates", getBeanClass(), "getDefaultPeriods", "setDefaultPeriods");
/*     */       
/*  75 */       defDate.setPropertyEditorClass(PeriodsEditor.class);
/*  76 */       defDate.setDisplayName(LocaleUtils.getCalendarLocaleString("Default"));
/*  77 */       defDate.setShortDescription(LocaleUtils.getCalendarLocaleString("Default_descript"));
/*  78 */       descriptors.add(defDate);
/*     */       
/*  80 */       PropertyDescriptor calSize = new PropertyDescriptor("dch_calSize", getBeanClass(), "getCalendarPreferredSize", "setCalendarPreferredSize");
/*     */       
/*  82 */       calSize.setPropertyEditorClass(SimpleDimensionEditor.class);
/*  83 */       calSize.setDisplayName(LocaleUtils.getCalendarLocaleString("Calend_size"));
/*  84 */       calSize.setShortDescription(LocaleUtils.getCalendarLocaleString("Calend_size_descript"));
/*  85 */       descriptors.add(calSize);
/*     */       
/*  87 */       PropertyDescriptor forbidDate = new PropertyDescriptor("dch_forbidDates", getBeanClass(), "getForbiddenPeriods", "setForbiddenPeriods");
/*     */       
/*  89 */       forbidDate.setPropertyEditorClass(PeriodsEditor.class);
/*  90 */       forbidDate.setDisplayName(LocaleUtils.getCalendarLocaleString("Forbidden"));
/*  91 */       forbidDate.setShortDescription(LocaleUtils.getCalendarLocaleString("Forbidden_descript"));
/*  92 */       descriptors.add(forbidDate);
/*     */       
/*  94 */       PropertyDescriptor maxDate = new PropertyDescriptor("dch_maxDate", getBeanClass(), "getMaxDate", "setMaxDate");
/*     */       
/*  96 */       maxDate.setPropertyEditorClass(DateEditor.class);
/*  97 */       maxDate.setDisplayName(LocaleUtils.getCalendarLocaleString("Maximal_date"));
/*  98 */       maxDate.setShortDescription(LocaleUtils.getCalendarLocaleString("Maximal_date_descript"));
/*  99 */       descriptors.add(maxDate);
/*     */       
/* 101 */       PropertyDescriptor minDate = new PropertyDescriptor("dch_minDate", getBeanClass(), "getMinDate", "setMinDate");
/*     */       
/* 103 */       minDate.setPropertyEditorClass(DateEditor.class);
/* 104 */       minDate.setDisplayName(LocaleUtils.getCalendarLocaleString("Minimal_date"));
/* 105 */       minDate.setShortDescription(LocaleUtils.getCalendarLocaleString("Minimal_date_descript"));
/* 106 */       descriptors.add(minDate);
/*     */       
/* 108 */       PropertyDescriptor autoScroll = new PropertyDescriptor("dch_autoScroll", getBeanClass(), "isAutoScroll", "setAutoScroll");
/*     */       
/* 110 */       autoScroll.setDisplayName(LocaleUtils.getCalendarLocaleString("Auto_scroll"));
/* 111 */       autoScroll.setShortDescription(LocaleUtils.getCalendarLocaleString("Auto_scroll_descript"));
/* 112 */       descriptors.add(autoScroll);
/*     */       
/* 114 */       PropertyDescriptor oneMonth = new PropertyDescriptor("dch_oneMonth", getBeanClass(), "isShowOneMonth", "setShowOneMonth");
/*     */       
/* 116 */       oneMonth.setDisplayName(LocaleUtils.getCalendarLocaleString("Show_one_month"));
/* 117 */       oneMonth.setShortDescription(LocaleUtils.getCalendarLocaleString("Show_one_month_descript"));
/* 118 */       descriptors.add(oneMonth);
/*     */       
/* 120 */       PropertyDescriptor enabled = new PropertyDescriptor("dch_enabled", getBeanClass(), "isEnabled", "setEnabled");
/*     */       
/* 122 */       enabled.setDisplayName(LocaleUtils.getCalendarLocaleString("Enabled"));
/* 123 */       enabled.setShortDescription(LocaleUtils.getCalendarLocaleString("Enabled_descript"));
/* 124 */       descriptors.add(enabled);
/*     */       
/* 126 */       PropertyDescriptor locked = new PropertyDescriptor("dch_locked", getBeanClass(), "isLocked", "setLocked");
/*     */       
/* 128 */       locked.setDisplayName(LocaleUtils.getCalendarLocaleString("Locked"));
/* 129 */       locked.setShortDescription(LocaleUtils.getCalendarLocaleString("Locked_descript"));
/* 130 */       descriptors.add(locked);
/*     */       
/* 132 */       PropertyDescriptor nothingAllowed = new PropertyDescriptor("dch_nothingAllowed", getBeanClass(), "isNothingAllowed", "setNothingAllowed");
/*     */       
/* 134 */       nothingAllowed.setDisplayName(LocaleUtils.getCalendarLocaleString("NothingAllowed"));
/* 135 */       nothingAllowed.setShortDescription(LocaleUtils.getCalendarLocaleString("NothingAllowed_descript"));
/* 136 */       descriptors.add(nothingAllowed);
/*     */       
/* 138 */       PropertyDescriptor navFont = new PropertyDescriptor("dch_navFont", getBeanClass(), "getNavigateFont", "setNavigateFont");
/*     */       
/* 140 */       navFont.setPropertyEditorClass(SimpleFontEditor.class);
/* 141 */       navFont.setDisplayName(LocaleUtils.getCalendarLocaleString("Navig_font"));
/* 142 */       navFont.setShortDescription(LocaleUtils.getCalendarLocaleString("Navig_font_descript"));
/* 143 */       descriptors.add(navFont);
/*     */       
/* 145 */       PropertyDescriptor behavior = new PropertyDescriptor("dch_behavior", getBeanClass(), "getBehavior", "setBehavior");
/*     */       
/* 147 */       behavior.setPropertyEditorClass(ModelBehaviorEditor.class);
/* 148 */       behavior.setDisplayName(LocaleUtils.getCalendarLocaleString("Behavior"));
/* 149 */       behavior.setShortDescription(LocaleUtils.getCalendarLocaleString("Behavior_descript"));
/* 150 */       descriptors.add(behavior);
/*     */       
/* 152 */       PropertyDescriptor weekDayStyle = new PropertyDescriptor("dch_weekDayStyle", getBeanClass(), "getWeekStyle", "setWeekStyle");
/*     */       
/* 154 */       weekDayStyle.setPropertyEditorClass(WeekDaysStyleEditor.class);
/* 155 */       weekDayStyle.setDisplayName(LocaleUtils.getCalendarLocaleString("WeekDayStyle"));
/* 156 */       weekDayStyle.setShortDescription(LocaleUtils.getCalendarLocaleString("WeekDayStyle_descript"));
/* 157 */       descriptors.add(weekDayStyle);
/*     */       
/* 159 */       PropertyDescriptor view = new PropertyDescriptor("dch_view", getBeanClass(), "getCurrentView", "setCurrentView");
/*     */       
/* 161 */       view.setPropertyEditorClass(AppearEditor.class);
/* 162 */       view.setDisplayName(LocaleUtils.getCalendarLocaleString("View"));
/* 163 */       view.setShortDescription(LocaleUtils.getCalendarLocaleString("View_descript"));
/* 164 */       descriptors.add(view);
/*     */       
/* 166 */       PropertyDescriptor locale = new PropertyDescriptor("dch_locale", getBeanClass(), "getLocale", "setLocale");
/*     */       
/* 168 */       locale.setPropertyEditorClass(LocaleEditor.class);
/* 169 */       locale.setDisplayName(LocaleUtils.getCalendarLocaleString("Locale"));
/* 170 */       locale.setShortDescription(LocaleUtils.getCalendarLocaleString("Locale_descript"));
/* 171 */       descriptors.add(locale);
/*     */       
/* 173 */       PropertyDescriptor navigPane = new PropertyDescriptor("dch_navigPane", getBeanClass(), "getCurrentNavigateIndex", "setCurrentNavigateIndex");
/*     */       
/* 175 */       navigPane.setPropertyEditorClass(NavigatePaneEditor.class);
/* 176 */       navigPane.setDisplayName(LocaleUtils.getCalendarLocaleString("NavigatePane"));
/* 177 */       navigPane.setShortDescription(LocaleUtils.getCalendarLocaleString("NavigatePane_descript"));
/* 178 */       descriptors.add(navigPane);
/*     */       
/* 180 */       PropertyDescriptor backColor = new PropertyDescriptor("dch_backgroundColor", getBeanClass(), "getCalendarBackground", "setCalendarBackground");
/*     */       
/* 182 */       backColor.setPropertyEditorClass(SimpleColorEditor.class);
/* 183 */       backColor.setDisplayName(LocaleUtils.getCalendarLocaleString("BackColor"));
/* 184 */       backColor.setShortDescription(LocaleUtils.getCalendarLocaleString("BackColor_descript"));
/* 185 */       descriptors.add(backColor);
/*     */       
/* 187 */       descriptors.addAll(getAdditionalDescriptors());
/*     */       
/* 189 */       return (PropertyDescriptor[])descriptors.toArray(new PropertyDescriptor[descriptors.size()]);
/*     */ 
/*     */     }
/*     */     catch (IntrospectionException e)
/*     */     {
/*     */ 
/* 195 */       throw new RuntimeException(e.getMessage());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getDefaultPropertyIndex()
/*     */   {
/* 205 */     return 1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public BeanDescriptor getBeanDescriptor()
/*     */   {
/* 214 */     BeanDescriptor bd = new BeanDescriptor(getBeanClass(), getCustomizerClass());
/* 215 */     bd.setDisplayName(getDisplayName());
/* 216 */     return bd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Image getIcon(int iconKind)
/*     */   {
/* 227 */     String name = "";
/* 228 */     switch (iconKind) {
/*     */     case 2: 
/* 230 */       name = "col32";
/* 231 */       break;
/*     */     case 1: 
/* 233 */       name = "col16";
/* 234 */       break;
/*     */     case 4: 
/* 236 */       name = "bw32";
/* 237 */       break;
/*     */     case 3: 
/* 239 */       name = "bw16";
/*     */     }
/*     */     
/* 242 */     return loadImage("/datechooser/beans/pic/" + getPicturePrefix() + "_" + name + ".gif");
/*     */   }
/*     */   
/*     */   protected abstract String getDisplayName();
/*     */   
/*     */   protected abstract String getPicturePrefix();
/*     */   
/*     */   protected abstract Class getBeanClass();
/*     */   
/*     */   protected abstract ArrayList<PropertyDescriptor> getAdditionalDescriptors()
/*     */     throws IntrospectionException;
/*     */   
/*     */   protected abstract Class getCustomizerClass();
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/AbstractDateChooserBeanInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */