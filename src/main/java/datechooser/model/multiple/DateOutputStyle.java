/*    */ package datechooser.model.multiple;
/*    */ 
/*    */ import java.text.DateFormat;
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
/*    */ public class DateOutputStyle
/*    */ {
/*    */   public DateOutputStyle() {}
/*    */   
/* 22 */   private static Locale locale = ;
/* 23 */   private static int format = 3;
/*    */   
/*    */   public static int getFormat() {
/* 26 */     return format;
/*    */   }
/*    */   
/*    */   public static Locale getLocale()
/*    */   {
/* 31 */     return locale;
/*    */   }
/*    */   
/*    */   public static void setFormat(int aFormat)
/*    */   {
/* 36 */     format = aFormat;
/*    */   }
/*    */   
/*    */   public static void setLocale(Locale aLocale)
/*    */   {
/* 41 */     locale = aLocale;
/*    */   }
/*    */   
/*    */   public static DateFormat getDateFormat() {
/* 45 */     return DateFormat.getDateInstance(getFormat(), getLocale());
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/model/multiple/DateOutputStyle.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */