/*    */ package datechooser.beans.editor.locale;
/*    */ 
/*    */ import java.text.DateFormatSymbols;
/*    */ import java.util.Calendar;
/*    */ import java.util.Locale;
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
/*    */ public class LocaleSet
/*    */ {
/*    */   private Locale[] locales;
/*    */   private String[] names;
/* 23 */   private Locale current = Locale.getDefault();
/*    */   
/*    */   public LocaleSet() {
/* 26 */     this.locales = Calendar.getAvailableLocales();
/* 27 */     DateFormatSymbols dfs = new DateFormatSymbols();
/* 28 */     this.names = new String[getLocales().length];
/* 29 */     initLocaleNames();
/*    */   }
/*    */   
/*    */   private void initLocaleNames() {
/* 33 */     for (int i = 0; i < getLocales().length; i++) {
/* 34 */       getNames()[i] = (getLocales()[i].getDisplayName() + " [" + getLocales()[i].getDisplayName(getLocales()[i]) + "]");
/*    */     }
/*    */   }
/*    */   
/*    */   public String[] getNames() {
/* 39 */     return this.names;
/*    */   }
/*    */   
/*    */   public void setCurrent(String name) {
/* 43 */     for (int i = 0; i < getNames().length; i++) {
/* 44 */       if (name.equals(getNames()[i])) {
/* 45 */         this.current = getLocales()[i];
/* 46 */         return;
/*    */       }
/*    */     }
/* 49 */     this.current = Locale.getDefault();
/*    */   }
/*    */   
/*    */   public int getIndex(Locale locale) {
/* 53 */     for (int i = 0; i < getLocales().length; i++) {
/* 54 */       if (locale.equals(getLocales()[i])) {
/* 55 */         return i;
/*    */       }
/*    */     }
/* 58 */     return 0;
/*    */   }
/*    */   
/*    */   public Locale getCurrent() {
/* 62 */     return this.current;
/*    */   }
/*    */   
/*    */   public Locale[] getLocales() {
/* 66 */     return this.locales;
/*    */   }
/*    */   
/*    */   public int size() {
/* 70 */     return getLocales().length;
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/locale/LocaleSet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */