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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class UpdateValues
/*    */   implements Runnable
/*    */ {
/*    */   Settings gui;
/*    */   
/*    */   public UpdateValues(Settings gui)
/*    */   {
/* 25 */     this.gui = gui;
/*    */   }
/*    */   
/*    */   public void run()
/*    */   {
/* 30 */     while (!this.gui.stopThread)
/*    */     {
/*    */       try {
/* 33 */         Thread.sleep(1000L);
/*    */       } catch (Exception ex) {
/* 35 */         System.err.println(ex.toString());
/*    */       }
/* 37 */       this.gui.updateGui();
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/com/ketonix/ketonixpro/UpdateValues.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */