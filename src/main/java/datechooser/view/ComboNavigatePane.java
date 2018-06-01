/*     */ package datechooser.view;
/*     */ 
/*     */ import datechooser.model.DateChoose;
/*     */ import datechooser.view.pic.ViewPictures;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Font;
/*     */ import java.awt.GridLayout;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.util.Calendar;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JFormattedTextField;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JSpinner;
/*     */ import javax.swing.JSpinner.DefaultEditor;
/*     */ import javax.swing.SpinnerNumberModel;
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
/*     */ public class ComboNavigatePane
/*     */   extends AbstractNavigatePane
/*     */ {
/*  32 */   private static int YEAR_SHIFT = 10000;
/*     */   
/*     */   private JComboBox months;
/*     */   private JSpinner year;
/*     */   private Calendar curDate;
/*     */   private SpinnerNumberModel yearModel;
/*     */   private JButton nullButton;
/*     */   
/*     */   public ComboNavigatePane()
/*     */   {
/*  42 */     this.months = new JComboBox();
/*  43 */     this.yearModel = new SpinnerNumberModel();
/*  44 */     this.year = new JSpinner(this.yearModel);
/*  45 */     this.nullButton = createNullButton();
/*     */     
/*  47 */     this.yearModel.setStepSize(Integer.valueOf(1));
/*  48 */     setLayout(new BorderLayout());
/*     */     
/*  50 */     JPanel mainPane = new JPanel(new GridLayout(1, 2));
/*  51 */     mainPane.add(this.months);
/*  52 */     mainPane.add(this.year);
/*     */     
/*  54 */     add(mainPane, "Center");
/*  55 */     add(this.nullButton, "West");
/*  56 */     this.editedManually = false;
/*  57 */     initMonthList();
/*  58 */     AbstractNavigatePane.OnShowChange listener = new AbstractNavigatePane.OnShowChange(this);
/*  59 */     this.months.addActionListener(listener);
/*  60 */     this.year.addChangeListener(listener);
/*  61 */     this.months.setEditable(false);
/*     */   }
/*     */   
/*     */   private JButton createNullButton() {
/*  65 */     JButton newNullButton = new JButton(new ImageIcon(ViewPictures.class.getResource("nothing.gif")));
/*     */     
/*  67 */     newNullButton.setFocusable(false);
/*  68 */     newNullButton.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/*  70 */         ComboNavigatePane.this.getModel().selectNothing();
/*     */       }
/*  72 */     });
/*  73 */     return newNullButton;
/*     */   }
/*     */   
/*     */   public int getMonth() {
/*  77 */     return this.months.getSelectedIndex();
/*     */   }
/*     */   
/*     */   public int getYear() {
/*  81 */     return ((Integer)this.yearModel.getValue()).intValue();
/*     */   }
/*     */   
/*     */   public void setMonth(int aMonth) {
/*  85 */     this.months.setSelectedIndex(aMonth);
/*     */   }
/*     */   
/*     */   public void setYear(int aYear) {
/*  89 */     this.yearModel.setValue(Integer.valueOf(aYear));
/*     */   }
/*     */   
/*     */   public void setEnabled(boolean enabled) {
/*  93 */     super.setEnabled(enabled);
/*  94 */     this.months.setEnabled(enabled);
/*  95 */     this.year.setEnabled(enabled);
/*  96 */     this.nullButton.setEnabled(isNothingSelectEnabled() ? enabled : false);
/*     */   }
/*     */   
/*     */   public Font getFont() {
/* 100 */     if ((this.year == null) || (this.months == null) || (this.nullButton == null)) return null;
/* 101 */     return this.months.getFont();
/*     */   }
/*     */   
/*     */   public void setFont(Font font) {
/* 105 */     if ((this.year == null) || (this.months == null)) return;
/*     */     try {
/* 107 */       ((JSpinner.DefaultEditor)this.year.getEditor()).getTextField().setFont(font);
/*     */     } catch (ClassCastException ex) {
/* 109 */       this.year.setFont(font);
/*     */     }
/* 111 */     this.months.setFont(font);
/* 112 */     this.nullButton.setFont(font);
/*     */   }
/*     */   
/*     */   public void updateMonthControl() {
/* 116 */     if (this.months == null) return;
/* 117 */     int selected = this.months.getSelectedIndex();
/* 118 */     this.months.removeAllItems();
/* 119 */     for (int i = 0; i < 12; i++) {
/* 120 */       this.months.addItem(this.monthsList[i]);
/*     */     }
/* 122 */     this.months.validate();
/* 123 */     this.months.setSelectedIndex(selected);
/*     */   }
/*     */   
/*     */   public void applyNothingSelectEnabled(boolean enabled)
/*     */   {
/* 128 */     this.nullButton.setEnabled(enabled);
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/view/ComboNavigatePane.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */