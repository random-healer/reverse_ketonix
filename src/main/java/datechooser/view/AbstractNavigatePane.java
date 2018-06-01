/*     */ package datechooser.view;
/*     */ 
/*     */ import datechooser.model.DateChoose;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.beans.PropertyChangeEvent;
/*     */ import java.beans.PropertyChangeListener;
/*     */ import java.text.DateFormatSymbols;
/*     */ import java.util.Calendar;
/*     */ import java.util.Locale;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.event.ChangeEvent;
/*     */ import javax.swing.event.ChangeListener;
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
/*     */ public abstract class AbstractNavigatePane
/*     */   extends JPanel
/*     */   implements PropertyChangeListener
/*     */ {
/*     */   protected boolean editedManually;
/*     */   private DateChoose model;
/*     */   private Calendar curDate;
/*     */   protected String[] monthsList;
/*     */   private boolean localeChanged;
/*     */   private boolean nothingSelectEnabled;
/*     */   
/*     */   public AbstractNavigatePane()
/*     */   {
/*  39 */     setFont(new Font("Serif", 0, 12));
/*  40 */     this.editedManually = false;
/*  41 */     this.nothingSelectEnabled = true;
/*  42 */     OnShowChange listener = new OnShowChange();
/*  43 */     setLocaleChanged(true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public abstract void applyNothingSelectEnabled(boolean paramBoolean);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public abstract void updateMonthControl();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public abstract int getMonth();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public abstract int getYear();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public abstract void setMonth(int paramInt);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public abstract void setYear(int paramInt);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void initMonthList()
/*     */   {
/*  85 */     if (!isLocaleChanged()) return;
/*  86 */     this.editedManually = false;
/*  87 */     DateFormatSymbols dateSymbols = new DateFormatSymbols(getLocale());
/*  88 */     this.monthsList = dateSymbols.getMonths();
/*  89 */     updateMonthControl();
/*  90 */     setLocaleChanged(false);
/*  91 */     this.editedManually = true;
/*     */   }
/*     */   
/*     */   protected void fireMonthYearChanged() {
/*     */     try {
/*  96 */       this.editedManually = false;
/*  97 */       getModel().showMonthYear(getMonth(), getYear());
/*     */     }
/*     */     finally
/*     */     {
/* 101 */       refresh();
/* 102 */       this.editedManually = true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void refresh()
/*     */   {
/* 111 */     this.curDate = getModel().getVisibleDate();
/* 112 */     setMonth(this.curDate.get(2));
/* 113 */     setYear(this.curDate.get(1));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void autoRefresh()
/*     */   {
/* 122 */     this.editedManually = false;
/* 123 */     refresh();
/* 124 */     this.editedManually = true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void manualRefresh()
/*     */   {
/* 133 */     this.editedManually = true;
/* 134 */     refresh();
/*     */   }
/*     */   
/*     */   protected void someChanged() {
/* 138 */     if (!this.editedManually) return;
/* 139 */     fireMonthYearChanged();
/*     */   }
/*     */   
/*     */   protected class OnShowChange implements ChangeListener, ActionListener {
/*     */     protected OnShowChange() {}
/*     */     
/*     */     public void actionPerformed(ActionEvent e) {
/* 146 */       AbstractNavigatePane.this.someChanged();
/*     */     }
/*     */     
/*     */     public void stateChanged(ChangeEvent e) {
/* 150 */       AbstractNavigatePane.this.someChanged();
/*     */     }
/*     */   }
/*     */   
/*     */   protected DateChoose getModel() {
/* 155 */     return this.model;
/*     */   }
/*     */   
/*     */   public void propertyChange(PropertyChangeEvent evt) {
/* 159 */     autoRefresh();
/*     */   }
/*     */   
/*     */   public void setModel(DateChoose model) {
/* 163 */     if (getModel() == model) {
/* 164 */       return;
/*     */     }
/* 166 */     if (getModel() != null) {
/* 167 */       getModel().removePropertyChangeListener(this);
/*     */     }
/* 169 */     this.model = model;
/* 170 */     model.addPropertyChangeListener(this);
/* 171 */     setEnabled(getModel().isEnabled());
/* 172 */     autoRefresh();
/*     */   }
/*     */   
/*     */   public void setEnabled(boolean enabled) {
/* 176 */     super.setEnabled(enabled);
/*     */   }
/*     */   
/*     */   public void setLocale(Locale l) {
/* 180 */     if (getLocale().equals(l)) return;
/* 181 */     super.setLocale(l);
/* 182 */     setLocaleChanged(true);
/* 183 */     initMonthList();
/*     */   }
/*     */   
/*     */   private boolean isLocaleChanged() {
/* 187 */     return this.localeChanged;
/*     */   }
/*     */   
/*     */   private void setLocaleChanged(boolean localeChanged) {
/* 191 */     this.localeChanged = localeChanged;
/*     */   }
/*     */   
/*     */   public boolean isNothingSelectEnabled() {
/* 195 */     return this.nothingSelectEnabled;
/*     */   }
/*     */   
/*     */   public void setNothingSelectEnabled(boolean nothingSelectEnabled) {
/* 199 */     this.nothingSelectEnabled = nothingSelectEnabled;
/* 200 */     applyNothingSelectEnabled(nothingSelectEnabled);
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/view/AbstractNavigatePane.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */