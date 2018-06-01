/*     */ package com.ketonix.ketonixpro;
/*     */ 
/*     */ import datechooser.beans.DateChooserCombo;
/*     */ import datechooser.events.SelectionChangedEvent;
/*     */ import datechooser.events.SelectionChangedListener;
/*     */ import datechooser.model.multiple.MultyModelBehavior;
/*     */ import datechooser.view.BackRenderer;
/*     */ import datechooser.view.WeekDaysStyle;
/*     */ import datechooser.view.appearance.AppearancesList;
/*     */ import datechooser.view.appearance.ViewAppearance;
/*     */ import datechooser.view.appearance.swing.ButtonPainter;
/*     */ import datechooser.view.appearance.swing.LabelPainter;
/*     */ import datechooser.view.appearance.swing.SwingCellAppearance;
/*     */ import java.awt.Color;
/*     */ import java.awt.Container;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.File;
/*     */ import java.util.Calendar;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFileChooser;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JList;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.UIManager.LookAndFeelInfo;
/*     */ import javax.swing.UnsupportedLookAndFeelException;
/*     */ import javax.swing.filechooser.FileNameExtensionFilter;
/*     */ 
/*     */ public class KetonixViewer extends javax.swing.JFrame
/*     */ {
/*     */   private ViewChart applet;
/*     */   private File selectedFile;
/*  44 */   List windows = new java.util.ArrayList();
/*     */   private JButton BrowseButton;
/*     */   private JLabel SelectedPathLabel;
/*     */   private JButton ShowButton;
/*     */   private JList ThingsList;
/*     */   private DateChooserCombo endDate;
/*     */   
/*  51 */   public KetonixViewer() { initComponents();
/*  52 */     getContentPane().setBackground(Color.WHITE);
/*  53 */     Calendar cal = Calendar.getInstance();
/*  54 */     cal.add(5, 1);
/*  55 */     this.endDate.setSelectedDate(cal);
/*  56 */     cal.add(5, -8);
/*  57 */     this.startDate.setSelectedDate(cal);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  62 */     new FileDrop(this, new FileDrop.Listener()
/*     */     {
/*     */ 
/*     */       public void filesDropped(File[] files)
/*     */       {
/*  67 */         for (Object wo : KetonixViewer.this.windows) {
/*  68 */           ViewChartWindow win = (ViewChartWindow)wo;
/*     */           
/*  70 */           win.setDataFile(files[0].getAbsolutePath());
/*  71 */           win.refresh();
/*     */         }
/*     */         
/*  74 */         KetonixViewer.this.SelectedPathLabel.setText(files[0].getName());
/*  75 */         KetonixViewer.this.selectedFile = files[0];
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  84 */     this.ShowButton = new JButton();
/*  85 */     this.jLabel1 = new JLabel();
/*  86 */     this.jLabel2 = new JLabel();
/*  87 */     this.jScrollPane1 = new JScrollPane();
/*  88 */     this.ThingsList = new JList();
/*  89 */     this.jLabel3 = new JLabel();
/*  90 */     this.SelectedPathLabel = new JLabel();
/*  91 */     this.BrowseButton = new JButton();
/*  92 */     this.jLabel4 = new JLabel();
/*  93 */     this.startDate = new DateChooserCombo();
/*  94 */     this.endDate = new DateChooserCombo();
/*     */     
/*  96 */     setDefaultCloseOperation(2);
/*  97 */     setTitle("Ketonix® Viewer");
/*  98 */     setBackground(new Color(255, 255, 255));
/*  99 */     setForeground(Color.white);
/*     */     
/* 101 */     this.ShowButton.setText("Show");
/* 102 */     this.ShowButton.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 104 */         KetonixViewer.this.ShowButtonActionPerformed(evt);
/*     */       }
/*     */       
/* 107 */     });
/* 108 */     this.jLabel1.setText("Date Range");
/*     */     
/* 110 */     this.jLabel2.setText("to");
/*     */     
/* 112 */     this.ThingsList.setModel(new javax.swing.AbstractListModel() {
/* 113 */       String[] strings = { "Acetone", "AcetonePPM", "Beta-HydroxyButyrate", "Calf", "CaloriesIn", "CaloriesOut", "Carbohydrates", "Chest", "Cholesterol", "Diastolic", "ExerciseFun", "ExerciseIntensity", "ExerciseTime", "ExerciseType", "Fat", "Glucose", "HDLC", "Height", "Hip", "KetoRatio", "LDLC", "Length", "Neck", "Protein", "Pulse", "SmallLDL", "Systolic", "Thigh", "Triglycerides", "UpperArm", "VLDL", "Waist", "Water", "Weight" };
/* 114 */       public int getSize() { return this.strings.length; }
/* 115 */       public Object getElementAt(int i) { return this.strings[i]; }
/* 116 */     });
/* 117 */     this.jScrollPane1.setViewportView(this.ThingsList);
/*     */     
/* 119 */     this.jLabel3.setText("Data File");
/*     */     
/* 121 */     this.BrowseButton.setText("Browse or Drop ...");
/* 122 */     this.BrowseButton.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 124 */         KetonixViewer.this.BrowseButtonActionPerformed(evt);
/*     */       }
/*     */       
/* 127 */     });
/* 128 */     this.jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/KetonixLogoR.png")));
/*     */     
/* 130 */     this.startDate.setCurrentView(new AppearancesList("Light", new ViewAppearance[] { new ViewAppearance("custom", new SwingCellAppearance(new Font("Lucida Grande", 0, 13), new Color(0, 0, 0), new Color(0, 0, 255), false, true, new ButtonPainter()), new SwingCellAppearance(new Font("Lucida Grande", 0, 13), new Color(0, 0, 0), new Color(0, 0, 255), true, true, new ButtonPainter()), new SwingCellAppearance(new Font("Lucida Grande", 0, 13), new Color(0, 0, 255), new Color(0, 0, 255), false, true, new ButtonPainter()), new SwingCellAppearance(new Font("Lucida Grande", 0, 13), new Color(128, 128, 128), new Color(0, 0, 255), false, true, new LabelPainter()), new SwingCellAppearance(new Font("Lucida Grande", 0, 13), new Color(0, 0, 0), new Color(0, 0, 255), false, true, new LabelPainter()), new SwingCellAppearance(new Font("Lucida Grande", 0, 13), new Color(0, 0, 0), new Color(255, 0, 0), false, false, new ButtonPainter()), (BackRenderer)null, false, true) }));
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
/* 171 */     this.startDate.setWeekStyle(WeekDaysStyle.SHORT);
/* 172 */     this.startDate.setLocale(new Locale("sv", "SE", ""));
/* 173 */     this.startDate.setBehavior(MultyModelBehavior.SELECT_SINGLE);
/* 174 */     this.startDate.addSelectionChangedListener(new SelectionChangedListener() {
/*     */       public void onSelectionChange(SelectionChangedEvent evt) {
/* 176 */         KetonixViewer.this.startDateOnSelectionChange(evt);
/*     */       }
/*     */       
/* 179 */     });
/* 180 */     this.endDate.setCurrentView(new AppearancesList("Light", new ViewAppearance[] { new ViewAppearance("custom", new SwingCellAppearance(new Font("Lucida Grande", 0, 13), new Color(0, 0, 0), new Color(0, 0, 255), false, true, new ButtonPainter()), new SwingCellAppearance(new Font("Lucida Grande", 0, 13), new Color(0, 0, 0), new Color(0, 0, 255), true, true, new ButtonPainter()), new SwingCellAppearance(new Font("Lucida Grande", 0, 13), new Color(0, 0, 255), new Color(0, 0, 255), false, true, new ButtonPainter()), new SwingCellAppearance(new Font("Lucida Grande", 0, 13), new Color(128, 128, 128), new Color(0, 0, 255), false, true, new LabelPainter()), new SwingCellAppearance(new Font("Lucida Grande", 0, 13), new Color(0, 0, 0), new Color(0, 0, 255), false, true, new LabelPainter()), new SwingCellAppearance(new Font("Lucida Grande", 0, 13), new Color(0, 0, 0), new Color(255, 0, 0), false, false, new ButtonPainter()), (BackRenderer)null, false, true) }));
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
/* 221 */     this.endDate.setWeekStyle(WeekDaysStyle.SHORT);
/* 222 */     this.endDate.setLocale(new Locale("sv", "SE", ""));
/* 223 */     this.endDate.setBehavior(MultyModelBehavior.SELECT_SINGLE);
/* 224 */     this.endDate.addSelectionChangedListener(new SelectionChangedListener() {
/*     */       public void onSelectionChange(SelectionChangedEvent evt) {
/* 226 */         KetonixViewer.this.endDateOnSelectionChange(evt);
/*     */       }
/*     */       
/* 229 */     });
/* 230 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 231 */     getContentPane().setLayout(layout);
/* 232 */     layout.setHorizontalGroup(layout
/* 233 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 234 */       .addGroup(layout.createSequentialGroup()
/* 235 */       .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 236 */       .addGroup(layout.createSequentialGroup()
/* 237 */       .addGap(174, 174, 174)
/* 238 */       .addComponent(this.ShowButton))
/* 239 */       .addGroup(layout.createSequentialGroup()
/* 240 */       .addContainerGap()
/* 241 */       .addComponent(this.jLabel4))
/* 242 */       .addGroup(layout.createSequentialGroup()
/* 243 */       .addContainerGap()
/* 244 */       .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 245 */       .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
/* 246 */       .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 247 */       .addComponent(this.jLabel1)
/* 248 */       .addComponent(this.jLabel3))
/* 249 */       .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 250 */       .addGroup(layout.createSequentialGroup()
/* 251 */       .addGap(8, 8, 8)
/* 252 */       .addComponent(this.SelectedPathLabel, -2, 198, -2)
/* 253 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 254 */       .addComponent(this.BrowseButton))
/* 255 */       .addGroup(layout.createSequentialGroup()
/* 256 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 257 */       .addComponent(this.startDate, -2, -1, -2)
/* 258 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 259 */       .addComponent(this.jLabel2)
/* 260 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 261 */       .addComponent(this.endDate, -2, -1, -2))))
/* 262 */       .addComponent(this.jScrollPane1, GroupLayout.Alignment.LEADING, -2, 425, -2))))
/* 263 */       .addGap(5, 5, 5)));
/*     */     
/* 265 */     layout.setVerticalGroup(layout
/* 266 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 267 */       .addGroup(layout.createSequentialGroup()
/* 268 */       .addGap(10, 10, 10)
/* 269 */       .addComponent(this.jLabel4)
/* 270 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 271 */       .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
/* 272 */       .addComponent(this.jLabel3)
/* 273 */       .addComponent(this.SelectedPathLabel, -1, -1, 32767)
/* 274 */       .addComponent(this.BrowseButton, -1, -1, 32767))
/* 275 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 276 */       .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
/* 277 */       .addComponent(this.jLabel1)
/* 278 */       .addComponent(this.jLabel2)
/* 279 */       .addComponent(this.startDate, -2, -1, -2)
/* 280 */       .addComponent(this.endDate, -2, -1, -2))
/* 281 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 282 */       .addComponent(this.jScrollPane1, -2, 189, -2)
/* 283 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 284 */       .addComponent(this.ShowButton)
/* 285 */       .addGap(15, 15, 15)));
/*     */     
/*     */ 
/* 288 */     pack();
/*     */   }
/*     */   
/*     */   public void setDataFile(String path)
/*     */   {
/* 293 */     this.SelectedPathLabel.setText(path);
/* 294 */     this.selectedFile = new File(path);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void ViewDataFile(String path)
/*     */   {
/* 302 */     String filtertxt = (String)this.ThingsList.getSelectedValue();
/*     */     
/* 304 */     int ix = this.windows.size();
/* 305 */     ViewChartWindow vcw = new ViewChartWindow(this, ix, filtertxt, path, this.startDate.getSelectedDate().getTime(), this.endDate.getSelectedDate().getTime());
/*     */     
/* 307 */     this.windows.add(ix, vcw);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private JLabel jLabel1;
/*     */   
/*     */ 
/*     */   private JLabel jLabel2;
/*     */   
/*     */   private JLabel jLabel3;
/*     */   
/*     */   private JLabel jLabel4;
/*     */   
/*     */   private JScrollPane jScrollPane1;
/*     */   
/*     */   private DateChooserCombo startDate;
/*     */   
/*     */   private void BrowseButtonActionPerformed(ActionEvent evt)
/*     */   {
/* 327 */     JFileChooser fileChooser = new JFileChooser();
/* 328 */     FileNameExtensionFilter filter = new FileNameExtensionFilter("Comma separated files", new String[] { "csv", "CSV" });
/* 329 */     fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
/* 330 */     fileChooser.setFileFilter(filter);
/* 331 */     int result = fileChooser.showOpenDialog(this);
/* 332 */     if (result == 0) {
/* 333 */       this.selectedFile = fileChooser.getSelectedFile();
/*     */       
/* 335 */       this.SelectedPathLabel.setText(this.selectedFile.getName());
/*     */     }
/*     */   }
/*     */   
/*     */   private void ShowButtonActionPerformed(ActionEvent evt)
/*     */   {
/* 341 */     if (this.selectedFile != null) ViewDataFile(this.selectedFile.getAbsolutePath());
/*     */   }
/*     */   
/*     */   private void updateRanges()
/*     */   {
/* 346 */     for (Object wo : this.windows) {
/* 347 */       ViewChartWindow win = (ViewChartWindow)wo;
/* 348 */       win.setRange(this.startDate.getSelectedDate().getTime(), this.endDate.getSelectedDate().getTime());
/* 349 */       win.refresh();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void removeMe(ViewChartWindow w)
/*     */   {
/* 357 */     this.windows.remove(w);
/*     */   }
/*     */   
/*     */   public void removeMe(int ix)
/*     */   {
/* 362 */     this.windows.remove(ix);
/*     */   }
/*     */   
/*     */   private void startDateOnSelectionChange(SelectionChangedEvent evt)
/*     */   {
/* 367 */     updateRanges();
/*     */   }
/*     */   
/*     */   private void endDateOnSelectionChange(SelectionChangedEvent evt)
/*     */   {
/* 372 */     updateRanges();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 385 */       for (UIManager.LookAndFeelInfo info : ) {
/* 386 */         if ("Nimbus".equals(info.getName())) {
/* 387 */           UIManager.setLookAndFeel(info.getClassName());
/* 388 */           break;
/*     */         }
/*     */       }
/*     */     } catch (ClassNotFoundException ex) {
/* 392 */       Logger.getLogger(KetonixViewer.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 394 */       Logger.getLogger(KetonixViewer.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 396 */       Logger.getLogger(KetonixViewer.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (UnsupportedLookAndFeelException ex) {
/* 398 */       Logger.getLogger(KetonixViewer.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 404 */     java.awt.EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 406 */         new KetonixViewer().setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/com/ketonix/ketonixpro/KetonixViewer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */