/*     */ package datechooser.view;
/*     */ 
/*     */ import datechooser.model.DateChoose;
/*     */ import datechooser.view.pic.ViewPictures;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Font;
/*     */ import java.awt.GridLayout;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ButtonNavigatePane
/*     */   extends AbstractNavigatePane
/*     */ {
/*     */   private static final int BORDER = 3;
/*     */   private JLabel showYearMonth;
/*     */   private int currentMonth;
/*     */   private int currentYear;
/*     */   private JButton bPrevYear;
/*     */   private JButton bPrevMonth;
/*     */   private JButton bNothing;
/*     */   private JButton bNextMonth;
/*     */   private JButton bNextYear;
/*     */   
/*     */   public ButtonNavigatePane()
/*     */   {
/*  39 */     this.showYearMonth = new JLabel("", 0);
/*  40 */     initMonthList();
/*  41 */     this.showYearMonth.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
/*  42 */     JPanel pRight = new JPanel(new GridLayout(1, 5));
/*     */     
/*  44 */     OnClick onClick = new OnClick(null);
/*  45 */     this.bPrevYear = new JButton(new ImageIcon(ViewPictures.class.getResource("prev_year.gif")));
/*     */     
/*  47 */     this.bPrevYear.addActionListener(onClick);
/*     */     
/*  49 */     this.bPrevMonth = new JButton(new ImageIcon(ViewPictures.class.getResource("prev_month.gif")));
/*     */     
/*  51 */     this.bPrevMonth.addActionListener(onClick);
/*     */     
/*  53 */     this.bNothing = new JButton(new ImageIcon(ViewPictures.class.getResource("nothing.gif")));
/*     */     
/*  55 */     this.bNothing.addActionListener(onClick);
/*     */     
/*  57 */     this.bNextMonth = new JButton(new ImageIcon(ViewPictures.class.getResource("next_month.gif")));
/*     */     
/*  59 */     this.bNextMonth.addActionListener(onClick);
/*     */     
/*  61 */     this.bNextYear = new JButton(new ImageIcon(ViewPictures.class.getResource("next_year.gif")));
/*     */     
/*  63 */     this.bNextYear.addActionListener(onClick);
/*     */     
/*  65 */     pRight.add(this.bPrevYear);
/*  66 */     pRight.add(this.bPrevMonth);
/*  67 */     pRight.add(this.bNothing);
/*  68 */     pRight.add(this.bNextMonth);
/*  69 */     pRight.add(this.bNextYear);
/*     */     
/*  71 */     setLayout(new BorderLayout(5, 0));
/*  72 */     add(this.showYearMonth, "West");
/*  73 */     add(pRight, "Center");
/*     */   }
/*     */   
/*     */   private String getDateText() {
/*  77 */     return this.monthsList[this.currentMonth] + " " + this.currentYear;
/*     */   }
/*     */   
/*     */   public void updateMonthControl() {
/*  81 */     this.showYearMonth.setText(getDateText());
/*     */   }
/*     */   
/*     */   public int getMonth() {
/*  85 */     return this.currentMonth;
/*     */   }
/*     */   
/*     */   public int getYear() {
/*  89 */     return this.currentYear;
/*     */   }
/*     */   
/*     */   public void setMonth(int aMonth) {
/*  93 */     this.currentMonth = aMonth;
/*  94 */     updateMonthControl();
/*     */   }
/*     */   
/*     */   public void setYear(int aYear) {
/*  98 */     this.currentYear = aYear;
/*  99 */     updateMonthControl();
/*     */   }
/*     */   
/*     */   public void setFont(Font font) {
/* 103 */     super.setFont(font);
/* 104 */     if (this.showYearMonth != null)
/* 105 */       this.showYearMonth.setFont(font);
/*     */   }
/*     */   
/*     */   private class OnClick implements ActionListener {
/*     */     private OnClick() {}
/*     */     
/* 111 */     public void actionPerformed(ActionEvent e) { JButton src = (JButton)e.getSource();
/* 112 */       if (src == ButtonNavigatePane.this.bNothing) {
/* 113 */         ButtonNavigatePane.this.getModel().selectNothing();
/* 114 */         return;
/*     */       }
/* 116 */       if (src == ButtonNavigatePane.this.bPrevYear) {
/* 117 */         ButtonNavigatePane.access$310(ButtonNavigatePane.this);
/*     */       }
/* 119 */       if (src == ButtonNavigatePane.this.bNextYear) {
/* 120 */         ButtonNavigatePane.access$308(ButtonNavigatePane.this);
/*     */       }
/* 122 */       if (src == ButtonNavigatePane.this.bPrevMonth) {
/* 123 */         if (ButtonNavigatePane.this.currentMonth > 0) {
/* 124 */           ButtonNavigatePane.access$610(ButtonNavigatePane.this);
/*     */         } else {
/* 126 */           ButtonNavigatePane.this.currentMonth = 11;
/*     */         }
/*     */       }
/* 129 */       if (src == ButtonNavigatePane.this.bNextMonth) {
/* 130 */         if (ButtonNavigatePane.this.currentMonth < 11) {
/* 131 */           ButtonNavigatePane.access$608(ButtonNavigatePane.this);
/*     */         } else {
/* 133 */           ButtonNavigatePane.this.currentMonth = 0;
/*     */         }
/*     */       }
/* 136 */       ButtonNavigatePane.this.someChanged();
/*     */     }
/*     */   }
/*     */   
/*     */   public void setEnabled(boolean enabled) {
/* 141 */     super.setEnabled(enabled);
/* 142 */     this.bPrevYear.setEnabled(enabled);
/* 143 */     this.bPrevMonth.setEnabled(enabled);
/* 144 */     this.bNextMonth.setEnabled(enabled);
/* 145 */     this.bNextYear.setEnabled(enabled);
/* 146 */     this.bNothing.setEnabled(isNothingSelectEnabled() ? enabled : false);
/*     */   }
/*     */   
/*     */   public void applyNothingSelectEnabled(boolean enabled)
/*     */   {
/* 151 */     this.bNothing.setEnabled(enabled);
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/view/ButtonNavigatePane.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */