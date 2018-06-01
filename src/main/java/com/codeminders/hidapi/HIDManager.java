/*     */ package com.codeminders.hidapi;
/*     */ 
/*     */ import java.io.IOException;
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
/*     */ public class HIDManager
/*     */ {
/*  17 */   private static HIDManager instance = null;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected long peer;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public native HIDDeviceInfo[] listDevices()
/*     */     throws IOException;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private native void init()
/*     */     throws IOException;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public native void release();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private HIDManager()
/*     */     throws IOException
/*     */   {
/*  53 */     init();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void finalize()
/*     */     throws Throwable
/*     */   {
/*     */     try
/*     */     {
/*  68 */       release();
/*     */     }
/*     */     finally {
/*  71 */       super.finalize();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public HIDDevice openByPath(String path)
/*     */     throws IOException, HIDDeviceNotFoundException
/*     */   {
/*  85 */     HIDDeviceInfo[] devs = listDevices();
/*  86 */     for (HIDDeviceInfo d : devs)
/*     */     {
/*  88 */       if (d.getPath().equals(path))
/*  89 */         return d.open();
/*     */     }
/*  91 */     throw new HIDDeviceNotFoundException();
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
/*     */   public HIDDevice openById(int vendor_id, int product_id, String serial_number)
/*     */     throws IOException, HIDDeviceNotFoundException
/*     */   {
/* 107 */     HIDDeviceInfo[] devs = listDevices();
/* 108 */     for (HIDDeviceInfo d : devs)
/*     */     {
/* 110 */       if ((d.getVendor_id() == vendor_id) && (d.getProduct_id() == product_id) && ((serial_number == null) || (d.getSerial_number().equals(serial_number))))
/*     */       {
/* 112 */         return d.open(); }
/*     */     }
/* 114 */     throw new HIDDeviceNotFoundException();
/*     */   }
/*     */   
/*     */   public static HIDManager getInstance() throws IOException {
/* 118 */     if (instance == null) {
/* 119 */       synchronized (HIDManager.class) {
/* 120 */         if (null == instance) {
/* 121 */           instance = new HIDManager();
/*     */         }
/*     */       }
/*     */     }
/* 125 */     return instance;
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/com/codeminders/hidapi/HIDManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */