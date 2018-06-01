/*     */ package com.ketonix.ketonixpro;
/*     */ 
/*     */ import com.sun.javafx.charts.ChartLayoutAnimator;
/*     */ import java.text.DateFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Collections;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javafx.animation.KeyFrame;
/*     */ import javafx.animation.KeyValue;
/*     */ import javafx.beans.property.LongProperty;
/*     */ import javafx.beans.property.ObjectProperty;
/*     */ import javafx.beans.property.ObjectPropertyBase;
/*     */ import javafx.beans.property.SimpleLongProperty;
/*     */ import javafx.geometry.Side;
/*     */ import javafx.scene.chart.Axis;
/*     */ import javafx.util.Duration;
/*     */ import javafx.util.StringConverter;
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
/*     */ public final class DateAxis
/*     */   extends Axis<Date>
/*     */ {
/*  90 */   private final LongProperty currentLowerBound = new SimpleLongProperty(this, "currentLowerBound");
/*     */   
/*  92 */   private final LongProperty currentUpperBound = new SimpleLongProperty(this, "currentUpperBound");
/*     */   
/*  94 */   private final ObjectProperty<StringConverter<Date>> tickLabelFormatter = new ObjectPropertyBase()
/*     */   {
/*     */     protected void invalidated() {
/*  97 */       if (!DateAxis.this.isAutoRanging()) {
/*  98 */         DateAxis.this.invalidateRange();
/*  99 */         DateAxis.this.requestAxisLayout();
/*     */       }
/*     */     }
/*     */     
/*     */     public Object getBean()
/*     */     {
/* 105 */       return DateAxis.this;
/*     */     }
/*     */     
/*     */     public String getName()
/*     */     {
/* 110 */       return "tickLabelFormatter";
/*     */     }
/*     */   };
/*     */   
/*     */ 
/*     */   private Date minDate;
/*     */   
/*     */ 
/*     */   private Date maxDate;
/*     */   
/* 120 */   private ObjectProperty<Date> lowerBound = new ObjectPropertyBase()
/*     */   {
/*     */     protected void invalidated() {
/* 123 */       if (!DateAxis.this.isAutoRanging()) {
/* 124 */         DateAxis.this.invalidateRange();
/* 125 */         DateAxis.this.requestAxisLayout();
/*     */       }
/*     */     }
/*     */     
/*     */     public Object getBean()
/*     */     {
/* 131 */       return DateAxis.this;
/*     */     }
/*     */     
/*     */     public String getName()
/*     */     {
/* 136 */       return "lowerBound";
/*     */     }
/*     */   };
/*     */   
/* 140 */   private ObjectProperty<Date> upperBound = new ObjectPropertyBase()
/*     */   {
/*     */     protected void invalidated() {
/* 143 */       if (!DateAxis.this.isAutoRanging()) {
/* 144 */         DateAxis.this.invalidateRange();
/* 145 */         DateAxis.this.requestAxisLayout();
/*     */       }
/*     */     }
/*     */     
/*     */     public Object getBean()
/*     */     {
/* 151 */       return DateAxis.this;
/*     */     }
/*     */     
/*     */     public String getName()
/*     */     {
/* 156 */       return "upperBound";
/*     */     }
/*     */   };
/*     */   
/* 160 */   private ChartLayoutAnimator animator = new ChartLayoutAnimator(this);
/*     */   
/*     */   private Object currentAnimationID;
/*     */   
/* 164 */   private Interval actualInterval = Interval.DECADE;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public DateAxis() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public DateAxis(Date lowerBound, Date upperBound)
/*     */   {
/* 179 */     this();
/* 180 */     setAutoRanging(false);
/* 181 */     setLowerBound(lowerBound);
/* 182 */     setUpperBound(upperBound);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public DateAxis(String axisLabel, Date lowerBound, Date upperBound)
/*     */   {
/* 193 */     this(lowerBound, upperBound);
/* 194 */     setLabel(axisLabel);
/*     */   }
/*     */   
/*     */   public void invalidateRange(List<Date> list)
/*     */   {
/* 199 */     super.invalidateRange(list);
/*     */     
/* 201 */     Collections.sort(list);
/* 202 */     if (list.isEmpty()) {
/* 203 */       this.minDate = (this.maxDate = new Date());
/* 204 */     } else if (list.size() == 1) {
/* 205 */       this.minDate = (this.maxDate = (Date)list.get(0));
/* 206 */     } else if (list.size() > 1) {
/* 207 */       this.minDate = ((Date)list.get(0));
/* 208 */       this.maxDate = ((Date)list.get(list.size() - 1));
/*     */     }
/*     */   }
/*     */   
/*     */   protected Object autoRange(double length)
/*     */   {
/* 214 */     if (isAutoRanging()) {
/* 215 */       return new Object[] { this.minDate, this.maxDate };
/*     */     }
/* 217 */     if ((getLowerBound() == null) || (getUpperBound() == null)) {
/* 218 */       throw new IllegalArgumentException("If autoRanging is false, a lower and upper bound must be set.");
/*     */     }
/* 220 */     return getRange();
/*     */   }
/*     */   
/*     */ 
/*     */   protected void setRange(Object range, boolean animating)
/*     */   {
/* 226 */     Object[] r = (Object[])range;
/* 227 */     Date oldLowerBound = getLowerBound();
/* 228 */     Date oldUpperBound = getUpperBound();
/* 229 */     Date lower = (Date)r[0];
/* 230 */     Date upper = (Date)r[1];
/* 231 */     setLowerBound(lower);
/* 232 */     setUpperBound(upper);
/*     */     
/* 234 */     if (animating)
/*     */     {
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
/*     */ 
/* 263 */       this.animator.stop(this.currentAnimationID);
/* 264 */       this.currentAnimationID = this.animator.animate(new KeyFrame[] { new KeyFrame(Duration.ZERO, new KeyValue[] { new KeyValue(this.currentLowerBound, 
/*     */       
/* 266 */         Long.valueOf(oldLowerBound.getTime())), new KeyValue(this.currentUpperBound, 
/* 267 */         Long.valueOf(oldUpperBound.getTime())) }), new KeyFrame(
/*     */         
/* 269 */         Duration.millis(700.0D), new KeyValue[] { new KeyValue(this.currentLowerBound, 
/* 270 */         Long.valueOf(lower.getTime())), new KeyValue(this.currentUpperBound, 
/* 271 */         Long.valueOf(upper.getTime())) }) });
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 276 */       this.currentLowerBound.set(getLowerBound().getTime());
/* 277 */       this.currentUpperBound.set(getUpperBound().getTime());
/*     */     }
/*     */   }
/*     */   
/*     */   protected Object getRange()
/*     */   {
/* 283 */     return new Object[] { getLowerBound(), getUpperBound() };
/*     */   }
/*     */   
/*     */   public double getZeroPosition()
/*     */   {
/* 288 */     return 0.0D;
/*     */   }
/*     */   
/*     */   public double getDisplayPosition(Date date)
/*     */   {
/* 293 */     double length = getSide().isHorizontal() ? getWidth() : getHeight();
/*     */     
/*     */ 
/* 296 */     double diff = this.currentUpperBound.get() - this.currentLowerBound.get();
/*     */     
/*     */ 
/*     */ 
/* 300 */     double range = length - getZeroPosition();
/*     */     
/*     */ 
/*     */ 
/* 304 */     double d = (date.getTime() - this.currentLowerBound.get()) / diff;
/*     */     
/*     */ 
/* 307 */     if (getSide().isVertical()) {
/* 308 */       return getHeight() - d * range + getZeroPosition();
/*     */     }
/* 310 */     return d * range + getZeroPosition();
/*     */   }
/*     */   
/*     */ 
/*     */   public Date getValueForDisplay(double displayPosition)
/*     */   {
/* 316 */     double length = getSide().isHorizontal() ? getWidth() : getHeight();
/*     */     
/*     */ 
/* 319 */     double diff = this.currentUpperBound.get() - this.currentLowerBound.get();
/*     */     
/*     */ 
/*     */ 
/* 323 */     double range = length - getZeroPosition();
/*     */     
/* 325 */     if (getSide().isVertical())
/*     */     {
/*     */ 
/* 328 */       return new Date(((displayPosition - getZeroPosition() - getHeight()) / -range * diff + this.currentLowerBound.get()));
/*     */     }
/*     */     
/*     */ 
/* 332 */     return new Date(((displayPosition - getZeroPosition()) / range * diff + this.currentLowerBound.get()));
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isValueOnAxis(Date date)
/*     */   {
/* 338 */     return (date.getTime() > this.currentLowerBound.get()) && (date.getTime() < this.currentUpperBound.get());
/*     */   }
/*     */   
/*     */   public double toNumericValue(Date date)
/*     */   {
/* 343 */     return date.getTime();
/*     */   }
/*     */   
/*     */   public Date toRealValue(double v)
/*     */   {
/* 348 */     return new Date(v);
/*     */   }
/*     */   
/*     */   protected List<Date> calculateTickValues(double v, Object range)
/*     */   {
/* 353 */     Object[] r = (Object[])range;
/* 354 */     Date lower = (Date)r[0];
/* 355 */     Date upper = (Date)r[1];
/*     */     
/* 357 */     List<Date> dateList = new ArrayList();
/* 358 */     Calendar calendar = Calendar.getInstance();
/*     */     
/*     */ 
/* 361 */     double averageTickGap = 100.0D;
/* 362 */     double averageTicks = v / averageTickGap;
/*     */     
/* 364 */     List<Date> previousDateList = new ArrayList();
/*     */     
/* 366 */     Interval previousInterval = Interval.values()[0];
/*     */     
/*     */ 
/* 369 */     for (Interval interval : Interval.values())
/*     */     {
/* 371 */       calendar.setTime(lower);
/*     */       
/* 373 */       dateList.clear();
/* 374 */       previousDateList.clear();
/* 375 */       this.actualInterval = interval;
/*     */       
/*     */ 
/* 378 */       while (calendar.getTime().getTime() <= upper.getTime()) {
/* 379 */         dateList.add(calendar.getTime());
/* 380 */         calendar.add(interval.interval, interval.amount);
/*     */       }
/*     */       
/* 383 */       if (dateList.size() > averageTicks) {
/* 384 */         calendar.setTime(lower);
/*     */         
/* 386 */         while (calendar.getTime().getTime() <= upper.getTime()) {
/* 387 */           previousDateList.add(calendar.getTime());
/* 388 */           calendar.add(previousInterval.interval, previousInterval.amount);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 393 */       previousInterval = interval;
/*     */     }
/* 395 */     if (previousDateList.size() - averageTicks > averageTicks - dateList.size()) {
/* 396 */       dateList = previousDateList;
/* 397 */       this.actualInterval = previousInterval;
/*     */     }
/*     */     
/*     */ 
/* 401 */     dateList.add(upper);
/*     */     
/* 403 */     Object evenDateList = makeDatesEven(dateList, calendar);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 408 */     if (((List)evenDateList).size() > 2)
/*     */     {
/* 410 */       Date secondDate = (Date)((List)evenDateList).get(1);
/* 411 */       Date thirdDate = (Date)((List)evenDateList).get(2);
/* 412 */       Date lastDate = (Date)((List)evenDateList).get(dateList.size() - 2);
/* 413 */       Date previousLastDate = (Date)((List)evenDateList).get(dateList.size() - 3);
/*     */       
/*     */ 
/* 416 */       if (secondDate.getTime() - lower.getTime() < (thirdDate.getTime() - secondDate.getTime()) / 2L) {
/* 417 */         ((List)evenDateList).remove(secondDate);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 422 */       if (upper.getTime() - lastDate.getTime() < (lastDate.getTime() - previousLastDate.getTime()) / 2L) {
/* 423 */         ((List)evenDateList).remove(lastDate);
/*     */       }
/*     */     }
/*     */     
/* 427 */     return (List<Date>)evenDateList;
/*     */   }
/*     */   
/*     */   protected void layoutChildren()
/*     */   {
/* 432 */     if (!isAutoRanging()) {
/* 433 */       this.currentLowerBound.set(getLowerBound().getTime());
/* 434 */       this.currentUpperBound.set(getUpperBound().getTime());
/*     */     }
/* 436 */     super.layoutChildren();
/*     */   }
/*     */   
/*     */ 
/*     */   protected String getTickMarkLabel(Date date)
/*     */   {
/* 442 */     StringConverter<Date> converter = getTickLabelFormatter();
/* 443 */     if (converter != null) {
/* 444 */       return converter.toString(date);
/*     */     }
/*     */     
/*     */ 
/* 448 */     Calendar calendar = Calendar.getInstance();
/* 449 */     calendar.setTime(date);
/*     */     DateFormat dateFormat;
/* 451 */     DateFormat dateFormat; if ((this.actualInterval.interval == 1) && (calendar.get(2) == 0) && (calendar.get(5) == 1)) {
/* 452 */       dateFormat = new SimpleDateFormat("yyyy"); } else { DateFormat dateFormat;
/* 453 */       if ((this.actualInterval.interval == 2) && (calendar.get(5) == 1)) {
/* 454 */         dateFormat = new SimpleDateFormat("MMM yy"); } else { DateFormat dateFormat;
/*     */         DateFormat dateFormat;
/* 456 */         DateFormat dateFormat; switch (this.actualInterval.interval) {
/*     */         case 3: case 4: case 5: 
/*     */         case 6: case 7: case 8: 
/*     */         case 9: case 11: default: 
/* 460 */           dateFormat = DateFormat.getDateInstance(2);
/* 461 */           break;
/*     */         case 10: 
/*     */         case 12: 
/* 464 */           dateFormat = DateFormat.getTimeInstance(3);
/* 465 */           break;
/*     */         case 13: 
/* 467 */           dateFormat = DateFormat.getTimeInstance(2);
/* 468 */           break;
/*     */         case 14: 
/* 470 */           dateFormat = DateFormat.getTimeInstance(0);
/*     */         }
/*     */       }
/*     */     }
/* 474 */     return dateFormat.format(date);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private List<Date> makeDatesEven(List<Date> dates, Calendar calendar)
/*     */   {
/* 485 */     if (dates.size() > 2) {
/* 486 */       List<Date> evenDates = new ArrayList();
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 491 */       for (int i = 0; i < dates.size(); i++) {
/* 492 */         calendar.setTime((Date)dates.get(i));
/* 493 */         switch (this.actualInterval.interval)
/*     */         {
/*     */         case 1: 
/* 496 */           if ((i != 0) && (i != dates.size() - 1)) {
/* 497 */             calendar.set(2, 0);
/* 498 */             calendar.set(5, 1);
/*     */           }
/* 500 */           calendar.set(11, 0);
/* 501 */           calendar.set(12, 0);
/* 502 */           calendar.set(13, 0);
/* 503 */           calendar.set(14, 6);
/* 504 */           break;
/*     */         
/*     */         case 2: 
/* 507 */           if ((i != 0) && (i != dates.size() - 1)) {
/* 508 */             calendar.set(5, 1);
/*     */           }
/* 510 */           calendar.set(11, 0);
/* 511 */           calendar.set(12, 0);
/* 512 */           calendar.set(13, 0);
/* 513 */           calendar.set(14, 5);
/* 514 */           break;
/*     */         
/*     */         case 3: 
/* 517 */           calendar.set(11, 0);
/* 518 */           calendar.set(12, 0);
/* 519 */           calendar.set(13, 0);
/* 520 */           calendar.set(14, 4);
/* 521 */           break;
/*     */         case 5: 
/* 523 */           calendar.set(11, 0);
/* 524 */           calendar.set(12, 0);
/* 525 */           calendar.set(13, 0);
/* 526 */           calendar.set(14, 3);
/* 527 */           break;
/*     */         case 10: 
/* 529 */           if ((i != 0) && (i != dates.size() - 1)) {
/* 530 */             calendar.set(12, 0);
/* 531 */             calendar.set(13, 0);
/*     */           }
/* 533 */           calendar.set(14, 2);
/* 534 */           break;
/*     */         case 12: 
/* 536 */           if ((i != 0) && (i != dates.size() - 1)) {
/* 537 */             calendar.set(13, 0);
/*     */           }
/* 539 */           calendar.set(14, 1);
/* 540 */           break;
/*     */         case 13: 
/* 542 */           calendar.set(14, 0);
/*     */         }
/*     */         
/*     */         
/* 546 */         evenDates.add(calendar.getTime());
/*     */       }
/*     */       
/* 549 */       return evenDates;
/*     */     }
/* 551 */     return dates;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final ObjectProperty<Date> lowerBoundProperty()
/*     */   {
/* 563 */     return this.lowerBound;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final Date getLowerBound()
/*     */   {
/* 573 */     return (Date)this.lowerBound.get();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final void setLowerBound(Date date)
/*     */   {
/* 583 */     this.lowerBound.set(date);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final ObjectProperty<Date> upperBoundProperty()
/*     */   {
/* 594 */     return this.upperBound;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final Date getUpperBound()
/*     */   {
/* 604 */     return (Date)this.upperBound.get();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final void setUpperBound(Date date)
/*     */   {
/* 614 */     this.upperBound.set(date);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final StringConverter<Date> getTickLabelFormatter()
/*     */   {
/* 623 */     return (StringConverter)this.tickLabelFormatter.getValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final void setTickLabelFormatter(StringConverter<Date> value)
/*     */   {
/* 632 */     this.tickLabelFormatter.setValue(value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final ObjectProperty<StringConverter<Date>> tickLabelFormatterProperty()
/*     */   {
/* 641 */     return this.tickLabelFormatter;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static enum Interval
/*     */   {
/* 649 */     DECADE(1, 10), 
/* 650 */     YEAR(1, 1), 
/* 651 */     MONTH_6(2, 6), 
/* 652 */     MONTH_3(2, 3), 
/* 653 */     MONTH_1(2, 1), 
/* 654 */     WEEK(3, 1), 
/* 655 */     DAY(5, 1), 
/* 656 */     HOUR_12(10, 12), 
/* 657 */     HOUR_6(10, 6), 
/* 658 */     HOUR_3(10, 3), 
/* 659 */     HOUR_1(10, 1), 
/* 660 */     MINUTE_15(12, 15), 
/* 661 */     MINUTE_5(12, 5), 
/* 662 */     MINUTE_1(12, 1), 
/* 663 */     SECOND_15(13, 15), 
/* 664 */     SECOND_5(13, 5), 
/* 665 */     SECOND_1(13, 1), 
/* 666 */     MILLISECOND(14, 1);
/*     */     
/*     */     private final int amount;
/*     */     private final int interval;
/*     */     
/*     */     private Interval(int interval, int amount)
/*     */     {
/* 673 */       this.interval = interval;
/* 674 */       this.amount = amount;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/com/ketonix/ketonixpro/DateAxis.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */