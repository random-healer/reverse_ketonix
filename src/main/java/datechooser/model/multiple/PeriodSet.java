/*     */ package datechooser.model.multiple;
/*     */ 
/*     */ import datechooser.model.DateUtils;
/*     */ import java.io.Serializable;
/*     */ import java.text.DateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
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
/*     */ public class PeriodSet
/*     */   extends DateOutputStyle
/*     */   implements Serializable, Cloneable
/*     */ {
/*     */   private LinkedList<Period> data;
/*  28 */   private Period periodCash = null;
/*  29 */   private Period lastAdded = null;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public PeriodSet()
/*     */   {
/*  37 */     this.data = new LinkedList();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public PeriodSet(PeriodSet src)
/*     */   {
/*  46 */     this();
/*  47 */     this.data.addAll(src.data);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public PeriodSet(Period... periods)
/*     */   {
/*  58 */     this();
/*  59 */     for (Period elem : periods) {
/*  60 */       add((Period)elem.clone());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void add(Period newPeriod)
/*     */   {
/*  71 */     if (newPeriod == null) return;
/*  72 */     this.lastAdded = newPeriod;
/*  73 */     for (Period elem : this.data) {
/*  74 */       if ((elem.isIntersects(newPeriod)) || (elem.isNear(newPeriod))) {
/*  75 */         elem.unite(newPeriod);
/*  76 */         return;
/*     */       }
/*     */     }
/*  79 */     int insPos = -1;
/*  80 */     for (Iterator it = this.data.iterator(); it.hasNext();) {
/*  81 */       Period elem = (Period)it.next();
/*  82 */       insPos++;
/*  83 */       if (DateUtils.before(newPeriod.getEndDate(), elem.getStartDate())) {
/*  84 */         this.data.add(insPos, newPeriod);
/*  85 */         return;
/*     */       }
/*     */     }
/*  88 */     this.data.addLast(newPeriod);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void add(PeriodSet periods)
/*     */   {
/*  97 */     if (periods == null) return;
/*  98 */     this.data.addAll(periods.data);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void set(PeriodSet periods)
/*     */   {
/* 108 */     clear();
/* 109 */     add(periods);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void add(Calendar date)
/*     */   {
/* 118 */     add(new Period(date));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void add(Iterable<Period> newData)
/*     */   {
/* 127 */     for (Period elem : newData) {
/* 128 */       add(elem);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void set(Iterable<Period> newData)
/*     */   {
/* 138 */     clear();
/* 139 */     add(newData);
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
/*     */   public Iterable<Calendar> getDates()
/*     */   {
/* 152 */     ArrayList<Calendar> result = new ArrayList();
/* 153 */     for (Period period : this.data) {
/* 154 */       result.addAll(period.listDates());
/*     */     }
/* 156 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Iterable<Period> getPeriods()
/*     */   {
/* 165 */     ArrayList<Period> result = new ArrayList();
/* 166 */     result.addAll(this.data);
/* 167 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean intersects(Period period)
/*     */   {
/* 176 */     if (period == null) {
/* 177 */       return false;
/*     */     }
/* 179 */     for (Period elem : this.data) {
/* 180 */       if (elem.isIntersects(period)) {
/* 181 */         return true;
/*     */       }
/*     */     }
/* 184 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean intersects(PeriodSet periods)
/*     */   {
/* 193 */     for (Iterator i$ = this.data.iterator(); i$.hasNext();) { srcPeriod = (Period)i$.next();
/* 194 */       for (Period trgPeriod : periods.data)
/* 195 */         if (srcPeriod.isIntersects(trgPeriod)) return true;
/*     */     }
/*     */     Period srcPeriod;
/* 198 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean near(Period period)
/*     */   {
/* 207 */     for (Period srcPeriod : this.data) {
/* 208 */       if (srcPeriod.isNear(period)) return true;
/*     */     }
/* 210 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean contains(Calendar date)
/*     */   {
/* 219 */     if (date == null) {
/* 220 */       return false;
/*     */     }
/* 222 */     if (this.periodCash == null) {
/* 223 */       this.periodCash = new Period(date);
/*     */     } else {
/* 225 */       this.periodCash.set(date, date);
/*     */     }
/* 227 */     return intersects(this.periodCash);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void clear()
/*     */   {
/* 236 */     this.data.clear();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isEmpty()
/*     */   {
/* 245 */     return this.data.isEmpty();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Period getLastAddedPeriod()
/*     */   {
/* 254 */     return this.lastAdded;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Calendar getFirstDate()
/*     */   {
/* 263 */     if (this.data.isEmpty()) return null;
/* 264 */     return ((Period)this.data.get(0)).getStartDate();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Period getFirstPeriod()
/*     */   {
/* 273 */     if (this.data.isEmpty()) return null;
/* 274 */     return (Period)this.data.get(0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String toString()
/*     */   {
/* 283 */     if (isEmpty()) return "";
/* 284 */     Calendar first = getFirstDate();
/* 285 */     if (first == null) {
/* 286 */       return null;
/*     */     }
/* 288 */     StringBuffer ans = new StringBuffer();
/* 289 */     boolean firstDate = true;
/* 290 */     for (Period elem : this.data) {
/* 291 */       if (!firstDate) {
/* 292 */         ans.append("; ");
/*     */       } else {
/* 294 */         firstDate = false;
/*     */       }
/*     */       
/* 297 */       ans.append(elem.toString());
/*     */     }
/* 299 */     return ans.toString();
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
/* 312 */     return toString(DateFormat.getDateInstance(fmtStyle, locale));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String toString(DateFormat format)
/*     */   {
/* 323 */     Calendar first = getFirstDate();
/* 324 */     if (first == null) {
/* 325 */       return null;
/*     */     }
/* 327 */     StringBuffer ans = new StringBuffer();
/* 328 */     boolean firstDate = true;
/* 329 */     for (Period elem : this.data) {
/* 330 */       if (!firstDate) {
/* 331 */         ans.append("; ");
/*     */       } else {
/* 333 */         firstDate = false;
/*     */       }
/*     */       
/* 336 */       ans.append(elem.toString(format));
/*     */     }
/* 338 */     return ans.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getCount()
/*     */   {
/* 347 */     return this.data.size();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Object clone()
/*     */   {
/* 356 */     return new PeriodSet(this);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isSingleDate()
/*     */   {
/* 365 */     if (this.data.size() != 1) {
/* 366 */       return false;
/*     */     }
/* 368 */     return ((Period)this.data.get(0)).isOneDate();
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/model/multiple/PeriodSet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */