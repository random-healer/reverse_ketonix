/*     */ package com.ketonix.ketonixpro;
/*     */ 
/*     */ import java.awt.Dimension;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileReader;
/*     */ import java.io.IOException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import javafx.collections.FXCollections;
/*     */ import javafx.collections.ObservableList;
/*     */ import javafx.embed.swing.JFXPanel;
/*     */ import javafx.scene.Parent;
/*     */ import javafx.scene.Scene;
/*     */ import javafx.scene.chart.LineChart;
/*     */ import javafx.scene.chart.NumberAxis;
/*     */ import javafx.scene.chart.XYChart.Data;
/*     */ import javafx.scene.chart.XYChart.Series;
/*     */ import javax.swing.JApplet;
/*     */ import javax.swing.JFrame;
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
/*     */ public class ViewChart
/*     */   extends JApplet
/*     */ {
/*     */   private static final int JFXPANEL_WIDTH_INT = 500;
/*     */   private static final int JFXPANEL_HEIGHT_INT = 250;
/*     */   private JFXPanel fxContainer;
/*  44 */   private String path = "";
/*  45 */   private String filter = "";
/*     */   private Date startDate;
/*     */   private Date endDate;
/*  48 */   private String filename = "";
/*     */   
/*     */   public ViewChart() {}
/*     */   
/*     */   public static void main(String[] args)
/*     */   {
/*  54 */     SwingUtilities.invokeLater(new Runnable()
/*     */     {
/*     */       public void run()
/*     */       {
/*     */         try {
/*  59 */           UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
/*     */         }
/*     */         catch (Exception localException) {}
/*     */         
/*  63 */         JFrame frame = new JFrame("JavaFX 2 in Swing");
/*  64 */         frame.setDefaultCloseOperation(3);
/*     */         
/*  66 */         JApplet applet = new ViewChart();
/*  67 */         applet.init();
/*     */         
/*  69 */         frame.setContentPane(applet.getContentPane());
/*     */         
/*  71 */         frame.pack();
/*  72 */         frame.setLocationRelativeTo(null);
/*  73 */         frame.setVisible(true);
/*     */         
/*  75 */         applet.start();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */   public void init()
/*     */   {
/*  83 */     this.fxContainer = new JFXPanel();
/*  84 */     this.fxContainer.setPreferredSize(new Dimension(500, 250));
/*  85 */     add(this.fxContainer, "Center");
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
/*  99 */     createScene();
/*     */   }
/*     */   
/*     */ 
/*     */   public void setFilter(String f)
/*     */   {
/* 105 */     this.filter = f;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setDataFile(String p)
/*     */   {
/* 111 */     this.path = p;
/* 112 */     File aFile = new File(this.path);
/* 113 */     this.filename = aFile.getName();
/* 114 */     aFile = null;
/*     */   }
/*     */   
/*     */   public void setRange(Date s, Date e)
/*     */   {
/* 119 */     this.startDate = s;
/* 120 */     this.endDate = e;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   void createScene()
/*     */   {
/* 127 */     SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*     */     
/* 129 */     ObservableList<XYChart.Series<Date, Number>> series = FXCollections.observableArrayList();
/*     */     
/* 131 */     ObservableList<XYChart.Data<Date, Number>> series1Data = FXCollections.observableArrayList();
/*     */     
/*     */ 
/*     */ 
/* 135 */     BufferedReader br = null;
/* 136 */     String line = "";
/* 137 */     String cvsSplitBy = ";";
/* 138 */     int x = 0;
/*     */     try
/*     */     {
/* 141 */       br = new BufferedReader(new FileReader(this.path));
/* 142 */       while ((line = br.readLine()) != null)
/*     */       {
/*     */ 
/*     */ 
/* 146 */         String[] data = line.split(cvsSplitBy);
/*     */         
/* 148 */         if (data[2].equals(this.filter)) {
/* 149 */           if (data[3].indexOf(",") > 0) {
/* 150 */             String data3 = data[3].replace(',', '.');
/* 151 */             series1Data.add(new XYChart.Data(df.parse(data[0] + " " + data[1]), Double.valueOf(Double.parseDouble(data3))));
/* 152 */           } else if (data[3].indexOf(".") > 0) {
/* 153 */             series1Data.add(new XYChart.Data(df.parse(data[0] + " " + data[1]), Double.valueOf(Double.parseDouble(data[3]))));
/*     */           } else {
/* 155 */             series1Data.add(new XYChart.Data(df.parse(data[0] + " " + data[1]), Integer.valueOf(Integer.parseInt(data[3]))));
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 164 */       if (br != null) {
/*     */         try {
/* 166 */           br.close();
/*     */         } catch (IOException e) {
/* 168 */           e.printStackTrace();
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 179 */       series.add(new XYChart.Series(this.filename, series1Data));
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 162 */       e.printStackTrace();
/*     */     } finally {
/* 164 */       if (br != null) {
/*     */         try {
/* 166 */           br.close();
/*     */         } catch (IOException e) {
/* 168 */           e.printStackTrace();
/*     */         }
/*     */       }
/*     */     }
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
/* 182 */     NumberAxis numberAxis = new NumberAxis();
/* 183 */     DateAxis dateAxis = new DateAxis();
/* 184 */     dateAxis.setAutoRanging(false);
/* 185 */     dateAxis.setLowerBound(this.startDate);
/* 186 */     dateAxis.setUpperBound(this.endDate);
/*     */     
/* 188 */     Object lineChart = new LineChart(dateAxis, numberAxis, series);
/* 189 */     ((LineChart)lineChart).setTitle("Ketonix® " + this.filter);
/*     */     
/* 191 */     Scene scene = new Scene((Parent)lineChart, 800.0D, 600.0D);
/*     */     
/*     */ 
/* 194 */     this.fxContainer.setScene(scene);
/*     */     
/* 196 */     this.fxContainer.setVisible(true);
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/com/ketonix/ketonixpro/ViewChart.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */