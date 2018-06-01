/*     */ package datechooser.model.multiple;
/*     */ 
/*     */ import datechooser.model.DateUtils;
/*     */ import java.io.Serializable;
/*     */ import java.text.DateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Collection;
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
/*     */ public class Period
/*     */   extends DateOutputStyle
/*     */   implements Comparable, Serializable, Cloneable
/*     */ {
/*     */   private Calendar startDate;
/*     */   private Calendar endDate;
/*     */   
/*     */   public Period(Calendar start, Calendar end)
/*     */   {
/*  44 */     set(start, end);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Period(Calendar aDate)
/*     */   {
/*  55 */     this(aDate, aDate);
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
/*     */   public void set(Calendar start, Calendar end)
/*     */   {
/*  68 */     if ((start == null) || (end == null)) {
/*  69 */       setStartDate(start);
/*  70 */       setEndDate(end);
/*     */     }
/*  72 */     if (DateUtils.before(start, end)) {
/*  73 */       setStartDate(start);
/*  74 */       setEndDate(end);
/*     */     } else {
/*  76 */       setStartDate(end);
/*  77 */       setEndDate(start);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isIn(Calendar aDate)
/*     */   {
/*  87 */     return ((DateUtils.after(aDate, getStartDate())) && (DateUtils.before(aDate, getEndDate()))) || (DateUtils.equals(aDate, getStartDate())) || (DateUtils.equals(aDate, getEndDate()));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Calendar getStartDate()
/*     */   {
/*  97 */     return this.startDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setStartDate(Calendar startDate)
/*     */   {
/* 109 */     if (this.startDate == null) {
/* 110 */       if (startDate == null) return;
/* 111 */       this.startDate = ((Calendar)startDate.clone());
/*     */     }
/* 113 */     else if (startDate == null) {
/* 114 */       this.startDate = null;
/*     */     } else {
/* 116 */       this.startDate.setTime(startDate.getTime());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Calendar getEndDate()
/*     */   {
/* 127 */     return this.endDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEndDate(Calendar endDate)
/*     */   {
/* 139 */     if (this.endDate == null) {
/* 140 */       if (endDate == null) return;
/* 141 */       this.endDate = ((Calendar)endDate.clone());
/*     */     }
/* 143 */     else if (endDate == null) {
/* 144 */       this.endDate = null;
/*     */     } else {
/* 146 */       this.endDate.setTime(endDate.getTime());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isOneDate()
/*     */   {
/* 157 */     return (getStartDate() != null) && (getEndDate() != null) && (DateUtils.equals(getStartDate(), getEndDate()));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isValid()
/*     */   {
/* 168 */     return (getStartDate() != null) && (getEndDate() != null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int compareTo(Object o)
/*     */   {
/* 177 */     Period trg = (Period)o;
/* 178 */     if (isIntersects(trg)) return 0;
/* 179 */     return getStartDate().compareTo(trg.getStartDate());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Collection<Calendar> listDates()
/*     */   {
/* 189 */     if (!isValid()) return null;
/* 190 */     ArrayList<Calendar> result = new ArrayList();
/* 191 */     Calendar buffer = (Calendar)getStartDate().clone();
/* 192 */     while ((buffer.before(getEndDate())) || (buffer.equals(getEndDate()))) {
/* 193 */       result.add(buffer);
/* 194 */       buffer = (Calendar)buffer.clone();
/* 195 */       buffer.add(5, 1);
/*     */     }
/* 197 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isIntersects(Period anotherPeriod)
/*     */   {
/* 206 */     return (isIn(anotherPeriod.getStartDate())) || (isIn(anotherPeriod.getEndDate())) || (anotherPeriod.isIn(getStartDate())) || (anotherPeriod.isIn(getEndDate()));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isNear(Period anotherPeriod)
/*     */   {
/* 218 */     return (DateUtils.isNear(anotherPeriod.getEndDate(), getStartDate())) || (DateUtils.isNear(getEndDate(), anotherPeriod.getStartDate()));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isNear(Calendar date)
/*     */   {
/* 228 */     return (DateUtils.isNear(date, getStartDate())) || (DateUtils.isNear(getEndDate(), date));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void unite(Period anotherPeriod)
/*     */   {
/* 240 */     if (getStartDate().after(anotherPeriod.getStartDate())) {
/* 241 */       setStartDate(anotherPeriod.getStartDate());
/*     */     }
/* 243 */     if (getEndDate().before(anotherPeriod.getEndDate())) {
/* 244 */       setEndDate(anotherPeriod.getEndDate());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean equals(Object obj)
/*     */   {
/* 255 */     if (obj == null) return false;
/* 256 */     if (getClass() != obj.getClass()) return false;
/* 257 */     return compareTo(obj) == 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Object clone()
/*     */   {
/* 266 */     return new Period((Calendar)getStartDate().clone(), (Calendar)getEndDate().clone());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String toString()
/*     */   {
/* 277 */     return toString(getDateFormat());
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
/*     */   public String toString(int fmtStyle, Locale locale)
/*     */   {
/* 290 */     return toString(DateFormat.getDateInstance(fmtStyle, locale));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String toString(DateFormat dateFormat)
/*     */   {
/* 301 */     if (!isValid()) return "invalid";
/* 302 */     StringBuffer ans = new StringBuffer();
/* 303 */     ans.append(dateFormat.format(getStartDate().getTime()));
/* 304 */     if (!isOneDate()) {
/* 305 */       ans.append(" - ");
/* 306 */       ans.append(dateFormat.format(getEndDate().getTime()));
/*     */     }
/* 308 */     return ans.toString();
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/model/multiple/Period.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */