/*     */ package com.ketonix.ketonixpro;
/*     */ 
/*     */ import java.awt.Dimension;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileReader;
/*     */ import java.io.IOException;
/*     */ import javafx.application.Platform;
/*     */ import javafx.collections.ObservableList;
/*     */ import javafx.embed.swing.JFXPanel;
/*     */ import javafx.scene.Scene;
/*     */ import javafx.scene.chart.LineChart;
/*     */ import javafx.scene.chart.NumberAxis;
/*     */ import javafx.scene.chart.XYChart.Data;
/*     */ import javafx.scene.chart.XYChart.Series;
/*     */ import javax.swing.JApplet;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.SwingUtilities;
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
/*     */ public class TestSwing
/*     */   extends JApplet
/*     */ {
/*     */   private static final int JFXPANEL_WIDTH_INT = 300;
/*     */   private static final int JFXPANEL_HEIGHT_INT = 250;
/*     */   private static JFXPanel fxContainer;
/*  40 */   private String datafile = "";
/*     */   
/*     */ 
/*     */   public TestSwing(String datafile_in)
/*     */   {
/*  45 */     this.datafile = datafile_in;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void show()
/*     */   {
/*  52 */     SwingUtilities.invokeLater(new Runnable()
/*     */     {
/*     */ 
/*     */       public void run()
/*     */       {
/*  57 */         JFrame frame = new JFrame("Ketonix®");
/*  58 */         frame.setDefaultCloseOperation(3);
/*     */         
/*  60 */         TestSwing.this.init();
/*     */         
/*  62 */         frame.setContentPane(TestSwing.this.getContentPane());
/*     */         
/*  64 */         frame.pack();
/*  65 */         frame.setLocationRelativeTo(null);
/*  66 */         frame.setVisible(true);
/*     */         
/*  68 */         TestSwing.this.start();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public void init()
/*     */   {
/*  75 */     fxContainer = new JFXPanel();
/*  76 */     fxContainer.setPreferredSize(new Dimension(300, 250));
/*  77 */     add(fxContainer, "Center");
/*     */     
/*  79 */     Platform.runLater(new Runnable()
/*     */     {
/*     */       public void run()
/*     */       {
/*  83 */         TestSwing.this.createScene();
/*     */       }
/*     */     });
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void createScene()
/*     */   {
/* 105 */     NumberAxis xAxis = new NumberAxis();
/* 106 */     NumberAxis yAxis = new NumberAxis();
/* 107 */     xAxis.setLabel("Number of Month");
/*     */     
/* 109 */     LineChart<Number, Number> lineChart = new LineChart(xAxis, yAxis);
/*     */     
/*     */ 
/* 112 */     lineChart.setTitle("Ketosis Monitoring, 2015");
/*     */     
/* 114 */     XYChart.Series series = new XYChart.Series();
/* 115 */     series.setName("My Ketosis");
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 120 */     BufferedReader br = null;
/* 121 */     String line = "";
/* 122 */     String cvsSplitBy = ";";
/*     */     try
/*     */     {
/* 125 */       br = new BufferedReader(new FileReader(this.datafile));
/* 126 */       while ((line = br.readLine()) != null)
/*     */       {
/*     */ 
/*     */ 
/* 130 */         String[] data = line.split(cvsSplitBy);
/*     */         
/* 132 */         if (data[2].equals("Acetone")) {
/* 133 */           series.getData().add(new XYChart.Data(Integer.valueOf(1), Integer.valueOf(43)));
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 142 */       if (br != null) {
/*     */         try {
/* 144 */           br.close();
/* 145 */         } catch (IOException e) { e.printStackTrace();
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
/* 166 */       scene = new Scene(lineChart, 800.0D, 600.0D);
/*     */     }
/*     */     catch (FileNotFoundException e)
/*     */     {
/* 138 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/* 140 */       e.printStackTrace();
/*     */     } finally {
/* 142 */       if (br != null) {
/*     */         try {
/* 144 */           br.close();
/* 145 */         } catch (IOException e) { e.printStackTrace();
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
/*     */     Scene scene;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 167 */     lineChart.getData().add(series);
/*     */     
/* 169 */     fxContainer.setScene(scene);
/* 170 */     fxContainer.show();
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/com/ketonix/ketonixpro/TestSwing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */