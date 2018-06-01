/*    */ package com.ketonix.ketonixpro;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class CalibrationThread
/*    */   implements Runnable
/*    */ {
/*    */   KSync ksync;
/*    */   CalibrateDialog gui;
/*    */   
/*    */   public CalibrationThread(CalibrateDialog cd, KSync ks)
/*    */   {
/* 21 */     this.ksync = ks;
/* 22 */     this.gui = cd;
/*    */   }
/*    */   
/*    */   public void run()
/*    */   {
/* 27 */     int value = 0;int old_value = -1;int diff = 0;int hits = 0;int progress = 0;int precision = 3;int calibrationHits = 60;
/* 28 */     precision = this.ksync.precision();
/* 29 */     calibrationHits = this.ksync.calibrationHits();
/* 30 */     while (!this.gui.stopCalibrating)
/*    */     {
/*    */       try {
/* 33 */         Thread.sleep(700L);
/*    */       } catch (Exception ex) {
/* 35 */         System.err.println(ex.toString());
/*    */       }
/* 37 */       value = this.ksync.current_raw;
/* 38 */       if (old_value == -1) {
/* 39 */         old_value = value;
/* 40 */         System.out.println(old_value);
/*    */       }
/*    */       else
/*    */       {
/* 44 */         diff = value - old_value;
/* 45 */         if (diff < 0) { diff *= -1;
/*    */         }
/* 47 */         if (diff <= precision) {
/* 48 */           System.out.println("hits++ = " + hits);
/*    */           
/* 50 */           hits++;
/*    */         } else {
/* 52 */           hits = 0;
/* 53 */           old_value = value;
/* 54 */           System.out.println("diff = " + diff + " => hits = " + hits);
/*    */         }
/* 56 */         if (hits == 100) {
/* 57 */           System.out.println("hits = " + hits + " => calibration finished, set to " + value);
/* 58 */           this.gui.setProgress(100, 100);
/*    */           
/* 60 */           this.gui.setCalibration(value);
/* 61 */           this.gui.finishedCalibrating();
/* 62 */           this.gui.stopCalibrating = true;
/* 63 */           return;
/*    */         }
/*    */         
/* 66 */         progress = progress < hits ? hits : progress;
/* 67 */         if (!this.gui.stopCalibrating)
/* 68 */           this.gui.setProgress(progress, 100);
/*    */       }
/*    */     }
/* 71 */     System.out.println("calibrateThread exit");
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/com/ketonix/ketonixpro/CalibrationThread.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */