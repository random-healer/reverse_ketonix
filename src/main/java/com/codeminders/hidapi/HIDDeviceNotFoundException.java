/*    */ package com.codeminders.hidapi;
/*    */ 
/*    */ import java.io.IOException;
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
/*    */ public class HIDDeviceNotFoundException
/*    */   extends IOException
/*    */ {
/*    */   public HIDDeviceNotFoundException() {}
/*    */   
/*    */   public HIDDeviceNotFoundException(String message)
/*    */   {
/* 24 */     super(message);
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/com/codeminders/hidapi/HIDDeviceNotFoundException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */