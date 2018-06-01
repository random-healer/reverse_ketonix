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
/*    */ public class HIDDevice
/*    */ {
/*    */   protected long peer;
/*    */   
/*    */   protected HIDDevice(long peer)
/*    */   {
/* 21 */     this.peer = peer;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void finalize()
/*    */     throws Throwable
/*    */   {
/*    */     try
/*    */     {
/* 35 */       close();
/*    */     }
/*    */     finally {
/* 38 */       super.finalize();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean equals(Object obj)
/*    */   {
/* 50 */     if (!(obj instanceof HIDDevice))
/* 51 */       return false;
/* 52 */     return ((HIDDevice)obj).peer == this.peer;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int hashCode()
/*    */   {
/* 62 */     return (int)(this.peer ^ this.peer >>> 32);
/*    */   }
/*    */   
/*    */   public native void close()
/*    */     throws IOException;
/*    */   
/*    */   public native int write(byte[] paramArrayOfByte)
/*    */     throws IOException;
/*    */   
/*    */   public native int read(byte[] paramArrayOfByte)
/*    */     throws IOException;
/*    */   
/*    */   public native int readTimeout(byte[] paramArrayOfByte, int paramInt);
/*    */   
/*    */   public native void enableBlocking()
/*    */     throws IOException;
/*    */   
/*    */   public native void disableBlocking()
/*    */     throws IOException;
/*    */   
/*    */   public native int sendFeatureReport(byte[] paramArrayOfByte)
/*    */     throws IOException;
/*    */   
/*    */   public native int getFeatureReport(byte[] paramArrayOfByte)
/*    */     throws IOException;
/*    */   
/*    */   public native String getManufacturerString()
/*    */     throws IOException;
/*    */   
/*    */   public native String getProductString()
/*    */     throws IOException;
/*    */   
/*    */   public native String getSerialNumberString()
/*    */     throws IOException;
/*    */   
/*    */   public native String getIndexedString(int paramInt)
/*    */     throws IOException;
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/com/codeminders/hidapi/HIDDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */