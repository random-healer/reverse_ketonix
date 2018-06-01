/*     */ package datechooser.model;
/*     */ 
/*     */ import java.util.Calendar;
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
/*     */ public class DateUtils
/*     */ {
/*  20 */   private static Calendar calendarCash = null;
/*     */   
/*     */ 
/*     */   public DateUtils() {}
/*     */   
/*     */ 
/*     */   public static int getDay(Calendar date)
/*     */   {
/*  28 */     return date.get(5);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getMonth(Calendar date)
/*     */   {
/*  36 */     return date.get(2);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getYear(Calendar date)
/*     */   {
/*  44 */     return date.get(1);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean equals(Calendar dat1, Calendar dat2)
/*     */   {
/*  52 */     return (getDay(dat1) == getDay(dat2)) && (getMonth(dat1) == getMonth(dat2)) && (getYear(dat1) == getYear(dat2));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean before(Calendar dat1, Calendar dat2)
/*     */   {
/*  62 */     if (getYear(dat1) < getYear(dat2))
/*  63 */       return true;
/*  64 */     if (getYear(dat1) > getYear(dat2))
/*  65 */       return false;
/*  66 */     if (getMonth(dat1) < getMonth(dat2))
/*  67 */       return true;
/*  68 */     if (getMonth(dat1) > getMonth(dat2))
/*  69 */       return false;
/*  70 */     if (getDay(dat1) < getDay(dat2)) {
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean after(Calendar dat1, Calendar dat2)
/*     */   {
/*  82 */     if (!before(dat1, dat2)) {
/*  83 */       return !equals(dat1, dat2);
/*     */     }
/*  85 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void assign(Calendar target, Calendar source)
/*     */   {
/*  94 */     target.setTime(source.getTime());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isNear(Calendar dat1, Calendar dat2)
/*     */   {
/* 102 */     Calendar before = null;
/* 103 */     Calendar after = null;
/*     */     
/* 105 */     if (before(dat1, dat2)) {
/* 106 */       before = dat1;
/* 107 */       after = dat2;
/*     */     } else {
/* 109 */       before = dat2;
/* 110 */       after = dat1;
/*     */     }
/*     */     
/* 113 */     initializeCash(before);
/* 114 */     calendarCash.add(5, 1);
/* 115 */     return equals(calendarCash, after);
/*     */   }
/*     */   
/*     */   private static void initializeCash(Calendar date) {
/* 119 */     if (calendarCash == null) {
/* 120 */       calendarCash = (Calendar)date.clone();
/*     */     } else {
/* 122 */       calendarCash.setTime(date.getTime());
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/model/DateUtils.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */