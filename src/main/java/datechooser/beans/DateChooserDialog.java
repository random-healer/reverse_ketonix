/*     */ package datechooser.beans;
/*     */ 
/*     */ import datechooser.beans.locale.LocaleUtils;
/*     */ import datechooser.events.CommitEvent;
/*     */ import datechooser.events.CommitListener;
/*     */ import datechooser.events.CursorMoveListener;
/*     */ import datechooser.events.SelectionChangedListener;
/*     */ import datechooser.model.exeptions.IncompatibleDataExeption;
/*     */ import datechooser.model.multiple.MultyModelBehavior;
/*     */ import datechooser.model.multiple.Period;
/*     */ import datechooser.model.multiple.PeriodSet;
/*     */ import datechooser.view.WeekDaysStyle;
/*     */ import datechooser.view.appearance.AppearancesList;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.Frame;
/*     */ import java.awt.GridLayout;
/*     */ import java.awt.Point;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.awt.event.WindowListener;
/*     */ import java.beans.PropertyChangeEvent;
/*     */ import java.beans.PropertyChangeListener;
/*     */ import java.beans.PropertyChangeSupport;
/*     */ import java.io.Serializable;
/*     */ import java.util.Calendar;
/*     */ import java.util.Locale;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.SwingUtilities;
/*     */ import javax.swing.UIManager;
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
/*     */ public class DateChooserDialog
/*     */   implements DateChooserBean, Serializable, PropertyChangeListener
/*     */ {
/*     */   public static final long serialVersionUID = 8940585643117164408L;
/*     */   public static final String DIALOG_PREFIX = "dch_dialog_";
/*     */   public static final String PROPERTY_MODAL = "dch_dialog_modal";
/*     */   public static final String PROPERTY_CAPTION = "dch_dialog_caption";
/*     */   private DateChooserPanel chooser;
/*     */   private JPanel dialogPanel;
/*  65 */   private JDialog dialog = null;
/*     */   
/*     */   private Iterable<Period> state;
/*     */   private String caption;
/*     */   private boolean modal;
/*     */   private PropertyChangeSupport changeSupport;
/*     */   
/*     */   public DateChooserDialog()
/*     */   {
/*  74 */     this.changeSupport = new PropertyChangeSupport(this);
/*  75 */     setModal(true);
/*  76 */     this.chooser = new DateChooserPanel();
/*  77 */     this.chooser.addPropertyChangeListener(this);
/*  78 */     this.dialogPanel = getDialogPane();
/*  79 */     setCaption("");
/*     */     
/*  81 */     addCommitListener(new CommitListener() {
/*     */       public void onCommit(CommitEvent evt) {
/*  83 */         DateChooserDialog.this.disposeDialog();
/*     */       }
/*     */       
/*  86 */     });
/*  87 */     UIManager.addPropertyChangeListener(new PropertyChangeListener() {
/*     */       public void propertyChange(PropertyChangeEvent evt) {
/*  89 */         SwingUtilities.updateComponentTreeUI(DateChooserDialog.this.dialogPanel);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isModal()
/*     */   {
/* 100 */     return this.modal;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setModal(boolean modal)
/*     */   {
/* 107 */     boolean old = isModal();
/* 108 */     this.modal = modal;
/* 109 */     this.changeSupport.firePropertyChange("dch_dialog_modal", old, isModal());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCaption()
/*     */   {
/* 117 */     return this.caption;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCaption(String caption)
/*     */   {
/* 124 */     String old = getCaption();
/* 125 */     this.caption = caption;
/* 126 */     this.changeSupport.firePropertyChange("dch_dialog_caption", old, getCaption());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void showDialog(Frame owner)
/*     */   {
/* 137 */     showDialog(owner, isModal());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void showDialog(Frame owner, boolean isModal)
/*     */   {
/* 149 */     Dimension ownerSize = null;
/* 150 */     if (owner != null) {
/* 151 */       ownerSize = owner.getSize();
/*     */     } else {
/* 153 */       ownerSize = Toolkit.getDefaultToolkit().getScreenSize();
/*     */     }
/* 155 */     Dimension dim = this.dialogPanel.getPreferredSize();
/* 156 */     Point location = new Point((ownerSize.width - dim.width) / 2, (ownerSize.height - dim.height) / 2);
/*     */     
/*     */ 
/* 159 */     showDialog(owner, isModal, location);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void showDialog(Frame owner, boolean isModal, Point location)
/*     */   {
/* 171 */     this.dialog = new JDialog(owner, isModal);
/* 172 */     this.dialog.setDefaultCloseOperation(0);
/* 173 */     this.dialog.addWindowListener(new OnClose(null));
/* 174 */     this.dialog.setContentPane(this.dialogPanel);
/* 175 */     this.dialog.setTitle(getCaption());
/* 176 */     saveState();
/* 177 */     Dimension dim = this.dialogPanel.getPreferredSize();
/* 178 */     this.dialog.setSize(dim.width, dim.height + 80);
/* 179 */     this.dialog.setLocation(location);
/* 180 */     this.dialog.pack();
/* 181 */     this.dialog.setVisible(true);
/*     */   }
/*     */   
/*     */   public MultyModelBehavior getBehavior() {
/* 185 */     return this.chooser.getBehavior();
/*     */   }
/*     */   
/*     */   public AppearancesList getCurrentView() {
/* 189 */     return this.chooser.getCurrentView();
/*     */   }
/*     */   
/*     */   public PeriodSet getDefaultPeriods() {
/* 193 */     return this.chooser.getDefaultPeriods();
/*     */   }
/*     */   
/*     */   public PeriodSet getForbiddenPeriods() {
/* 197 */     return this.chooser.getForbiddenPeriods();
/*     */   }
/*     */   
/*     */   public Calendar getMaxDate() {
/* 201 */     return this.chooser.getMaxDate();
/*     */   }
/*     */   
/*     */   public Calendar getMinDate() {
/* 205 */     return this.chooser.getMinDate();
/*     */   }
/*     */   
/*     */   public Calendar getSelectedDate() {
/* 209 */     return this.chooser.getSelectedDate();
/*     */   }
/*     */   
/*     */   public PeriodSet getSelectedPeriodSet() {
/* 213 */     return this.chooser.getSelectedPeriodSet();
/*     */   }
/*     */   
/*     */   public Iterable<Period> getSelection() {
/* 217 */     return this.chooser.getSelection();
/*     */   }
/*     */   
/*     */   public boolean isAutoScroll() {
/* 221 */     return this.chooser.isAutoScroll();
/*     */   }
/*     */   
/*     */   public boolean isEnabled() {
/* 225 */     return this.chooser.isEnabled();
/*     */   }
/*     */   
/*     */   public boolean isShowOneMonth() {
/* 229 */     return this.chooser.isShowOneMonth();
/*     */   }
/*     */   
/*     */   public void setAutoScroll(boolean autoScroll) {
/* 233 */     this.chooser.setAutoScroll(autoScroll);
/*     */   }
/*     */   
/*     */   public void setBehavior(MultyModelBehavior behavior) {
/* 237 */     this.chooser.setBehavior(behavior);
/*     */   }
/*     */   
/*     */   public void setCurrentView(AppearancesList aList) {
/* 241 */     this.chooser.setCurrentView(aList);
/*     */   }
/*     */   
/*     */   public void setDefaultPeriods(PeriodSet periods) throws IncompatibleDataExeption {
/* 245 */     this.chooser.setDefaultPeriods(periods);
/*     */   }
/*     */   
/*     */   public void setEnabled(boolean enabled) {
/* 249 */     this.chooser.setEnabled(enabled);
/*     */   }
/*     */   
/*     */   public void setForbidden(Iterable<Period> forbiddenPeriods) {
/* 253 */     this.chooser.setForbidden(forbiddenPeriods);
/*     */   }
/*     */   
/*     */   public void setForbiddenPeriods(PeriodSet periods) throws IncompatibleDataExeption {
/* 257 */     this.chooser.setForbiddenPeriods(periods);
/*     */   }
/*     */   
/*     */   public void setMaxDate(Calendar aDate) {
/* 261 */     this.chooser.setMaxDate(aDate);
/*     */   }
/*     */   
/*     */   public void setMinDate(Calendar aDate) {
/* 265 */     this.chooser.setMinDate(aDate);
/*     */   }
/*     */   
/*     */   public void setSelectedDate(Calendar aDate) {
/* 269 */     this.chooser.setSelectedDate(aDate);
/*     */   }
/*     */   
/*     */   public void setSelection(Iterable<Period> periods) {
/* 273 */     this.chooser.setSelection(periods);
/*     */   }
/*     */   
/*     */   public void setSelection(PeriodSet periods) {
/* 277 */     this.chooser.setSelection(periods);
/*     */   }
/*     */   
/*     */   public void setShowOneMonth(boolean showOneMonth) {
/* 281 */     this.chooser.setShowOneMonth(showOneMonth);
/*     */   }
/*     */   
/*     */   public Dimension getPreferredSize() {
/* 285 */     return this.chooser.getPreferredSize();
/*     */   }
/*     */   
/*     */   public Font getNavigateFont() {
/* 289 */     return this.chooser.getNavigateFont();
/*     */   }
/*     */   
/*     */   public void setNavigateFont(Font font) {
/* 293 */     this.chooser.setNavigateFont(font);
/*     */   }
/*     */   
/*     */   public Locale getLocale() {
/* 297 */     return this.chooser.getLocale();
/*     */   }
/*     */   
/*     */   public void setLocale(Locale locale) {
/* 301 */     this.chooser.setLocale(locale);
/*     */   }
/*     */   
/*     */   public int getCurrentNavigateIndex() {
/* 305 */     return this.chooser.getCurrentNavigateIndex();
/*     */   }
/*     */   
/*     */   public void setCurrentNavigateIndex(int currentNavigateIndex) {
/* 309 */     this.chooser.setCurrentNavigateIndex(currentNavigateIndex);
/*     */   }
/*     */   
/*     */   public boolean isLocked() {
/* 313 */     return this.chooser.isLocked();
/*     */   }
/*     */   
/*     */   public void setLocked(boolean lock) {
/* 317 */     this.chooser.setLocked(lock);
/*     */   }
/*     */   
/*     */   public WeekDaysStyle getWeekStyle() {
/* 321 */     return this.chooser.getWeekStyle();
/*     */   }
/*     */   
/*     */   public void setWeekStyle(WeekDaysStyle weekStyle) {
/* 325 */     this.chooser.setWeekStyle(weekStyle);
/*     */   }
/*     */   
/*     */   public Calendar getCurrent() {
/* 329 */     return this.chooser.getCurrent();
/*     */   }
/*     */   
/*     */   public boolean setCurrent(Calendar aDate) {
/* 333 */     return this.chooser.setCurrent(aDate);
/*     */   }
/*     */   
/*     */   public void setNothingAllowed(boolean allow) {
/* 337 */     this.chooser.setNothingAllowed(allow);
/*     */   }
/*     */   
/*     */   public boolean isNothingAllowed() {
/* 341 */     return this.chooser.isNothingAllowed();
/*     */   }
/*     */   
/*     */   public Dimension getCalendarPreferredSize() {
/* 345 */     return this.chooser.getCalendarPreferredSize();
/*     */   }
/*     */   
/*     */   public void setCalendarPreferredSize(Dimension dim) {
/* 349 */     this.chooser.setCalendarPreferredSize(dim);
/*     */   }
/*     */   
/*     */   public void commit() {
/* 353 */     this.chooser.commit();
/*     */   }
/*     */   
/*     */ 
/*     */   private JPanel getDialogPane()
/*     */   {
/* 359 */     JButton bOK = new JButton(LocaleUtils.getEditorLocaleString("OK"));
/* 360 */     JButton bCancel = new JButton(LocaleUtils.getEditorLocaleString("Cancel"));
/* 361 */     bOK.addActionListener(new OnOK(null));
/* 362 */     bCancel.addActionListener(new OnCancel(null));
/*     */     
/* 364 */     JPanel buttonPane = new JPanel(new GridLayout(1, 2));
/* 365 */     buttonPane.add(bOK);
/* 366 */     buttonPane.add(bCancel);
/* 367 */     JPanel dialogPane = new JPanel(new BorderLayout());
/* 368 */     dialogPane.add(this.chooser, "Center");
/* 369 */     dialogPane.add(buttonPane, "South");
/*     */     
/* 371 */     return dialogPane;
/*     */   }
/*     */   
/*     */   private void saveState() {
/* 375 */     this.state = this.chooser.getSelection();
/*     */   }
/*     */   
/*     */   private void restoreState() {
/* 379 */     this.chooser.setSelection(this.state);
/*     */   }
/*     */   
/*     */   private void disposeDialog() {
/* 383 */     if (this.dialog == null) return;
/* 384 */     this.dialog.setVisible(false);
/* 385 */     this.dialog.dispose();
/* 386 */     this.dialog = null;
/*     */   }
/*     */   
/*     */   private void commitAction() {
/* 390 */     commit();
/* 391 */     disposeDialog();
/*     */   }
/*     */   
/*     */   private void cancelAction()
/*     */   {
/* 396 */     restoreState();
/* 397 */     commit();
/* 398 */     disposeDialog();
/*     */   }
/*     */   
/*     */   public void propertyChange(PropertyChangeEvent evt) {
/* 402 */     if (this.chooser.isDateChooserPanelProperty(evt.getPropertyName())) {
/* 403 */       this.changeSupport.firePropertyChange(evt);
/*     */     }
/*     */   }
/*     */   
/*     */   public void addCommitListener(CommitListener listener) {
/* 408 */     this.chooser.addCommitListener(listener);
/*     */   }
/*     */   
/*     */   public void removeCommitListener(CommitListener listener) {
/* 412 */     this.chooser.removeCommitListener(listener);
/*     */   }
/*     */   
/*     */   public void addSelectionChangedListener(SelectionChangedListener listener) {
/* 416 */     this.chooser.addSelectionChangedListener(listener);
/*     */   }
/*     */   
/*     */   public void removeSelectionChangedListener(SelectionChangedListener listener) {
/* 420 */     this.chooser.removeSelectionChangedListener(listener);
/*     */   }
/*     */   
/*     */   public void addCursorMoveListener(CursorMoveListener listener) {
/* 424 */     this.chooser.addCursorMoveListener(listener);
/*     */   }
/*     */   
/*     */   public void removeCursorMoveListener(CursorMoveListener listener) {
/* 428 */     this.chooser.removeCursorMoveListener(listener);
/*     */   }
/*     */   
/*     */   public Color getCalendarBackground() {
/* 432 */     return this.chooser.getCalendarBackground();
/*     */   }
/*     */   
/*     */   public void setCalendarBackground(Color backColor) {
/* 436 */     this.chooser.setCalendarBackground(backColor);
/*     */   }
/*     */   
/*     */   public AppearancesList getAppearancesList() {
/* 440 */     return this.chooser.getAppearancesList();
/*     */   }
/*     */   
/*     */   public DateChooserDialog clone() {
/* 444 */     return (DateChooserDialog)BeanUtils.cloneBean(this);
/*     */   }
/*     */   
/*     */   private class OnClose implements WindowListener {
/*     */     private OnClose() {}
/*     */     
/*     */     public void windowOpened(WindowEvent e) {}
/*     */     
/* 452 */     public void windowClosing(WindowEvent e) { DateChooserDialog.this.disposeDialog(); }
/*     */     
/*     */ 
/*     */ 
/*     */     public void windowClosed(WindowEvent e) {}
/*     */     
/*     */ 
/*     */ 
/*     */     public void windowIconified(WindowEvent e) {}
/*     */     
/*     */ 
/*     */     public void windowDeiconified(WindowEvent e) {}
/*     */     
/*     */     public void windowActivated(WindowEvent e) {}
/*     */     
/*     */     public void windowDeactivated(WindowEvent e) {}
/*     */   }
/*     */   
/*     */   private class OnOK
/*     */     implements ActionListener
/*     */   {
/*     */     private OnOK() {}
/*     */     
/* 475 */     public void actionPerformed(ActionEvent e) { DateChooserDialog.this.commitAction(); }
/*     */   }
/*     */   
/*     */   private class OnCancel implements ActionListener {
/*     */     private OnCancel() {}
/*     */     
/* 481 */     public void actionPerformed(ActionEvent e) { DateChooserDialog.this.cancelAction(); }
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/DateChooserDialog.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */