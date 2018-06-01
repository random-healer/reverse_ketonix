/*     */ package com.codeminders.hidapi;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ByteOrder;
/*     */ 
/*     */ 
/*     */ public class HIDAPITest
/*     */ {
/*     */   private static final long READ_UPDATE_DELAY_MS = 50L;
/*     */   static final int VENDOR_ID = 1240;
/*     */   static final int PRODUCT_ID = 62547;
/*     */   private static final int BUFSIZE = 64;
/*     */   
/*     */   static
/*     */   {
/*  18 */     System.loadLibrary("hidapi-jni");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void main(String[] args)
/*     */     throws IOException
/*     */   {
/*  31 */     System.out.println("Args #" + args.length);
/*  32 */     if ((args.length == 1) && (args[0].equals("-l"))) {
/*  33 */       listDevices();
/*     */     }
/*  35 */     if (args.length == 4) {
/*  36 */       System.out.println("Setting values to (" + args[0] + "," + args[1] + "," + args[2] + "," + args[3] + ")");
/*  37 */       setValues(args[0], args[1], args[2], args[3]);
/*     */     } else {
/*  39 */       readDevice();
/*     */     }
/*  41 */     System.exit(0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void readDevice()
/*     */   {
/*     */     try
/*     */     {
/*  52 */       HIDManager hid_mgr = HIDManager.getInstance();
/*  53 */       HIDDevice dev = hid_mgr.openById(1240, 62547, null);
/*  54 */       System.err.print("Manufacturer: " + dev.getManufacturerString() + "\n");
/*  55 */       System.err.print("Product: " + dev.getProductString() + "\n");
/*  56 */       System.err.print("Serial Number: " + dev.getSerialNumberString() + "\n");
/*     */       try
/*     */       {
/*  59 */         int last_value = 0;
/*  60 */         int curr_value = 0;
/*  61 */         int raise = 0;
/*  62 */         byte[] buf = new byte[64];
/*  63 */         byte[] val = new byte[5];
/*  64 */         byte[] red = new byte[5];
/*  65 */         byte[] green = new byte[5];
/*  66 */         byte[] yellow = new byte[5];
/*  67 */         byte[] cal = new byte[5];
/*  68 */         dev.enableBlocking();
/*     */         
/*  70 */         for (int y = 0; y < 1; y++)
/*     */         {
/*  72 */           byte[] cmd = new byte[1];
/*     */           
/*  74 */           cmd[0] = 55;
/*  75 */           dev.write(cmd);
/*  76 */           int n = dev.read(buf);
/*  77 */           val[0] = buf[0];
/*  78 */           val[1] = buf[1];
/*  79 */           val[2] = 0;
/*  80 */           val[3] = 0;
/*  81 */           green[0] = buf[2];
/*  82 */           green[1] = buf[3];
/*  83 */           green[2] = 0;
/*  84 */           green[3] = 0;
/*  85 */           yellow[0] = buf[4];
/*  86 */           yellow[1] = buf[5];
/*  87 */           yellow[3] = 0;
/*  88 */           yellow[4] = 0;
/*  89 */           red[0] = buf[6];
/*  90 */           red[1] = buf[7];
/*  91 */           red[2] = 0;
/*  92 */           red[3] = 0;
/*  93 */           cal[0] = buf[8];
/*  94 */           cal[1] = buf[9];
/*  95 */           cal[2] = 0;
/*  96 */           cal[3] = 0;
/*  97 */           ByteBuffer bb = ByteBuffer.wrap(val);
/*  98 */           bb.order(ByteOrder.LITTLE_ENDIAN);
/*  99 */           curr_value = bb.getInt();
/* 100 */           System.err.print("Current Value:");
/* 101 */           System.err.print(curr_value);
/* 102 */           System.err.print("\n");
/*     */           
/* 104 */           bb = ByteBuffer.wrap(green);
/* 105 */           bb.order(ByteOrder.LITTLE_ENDIAN);
/* 106 */           int current_green = bb.getInt();
/* 107 */           System.err.print("Green Value:");
/* 108 */           System.err.print(current_green);
/* 109 */           System.err.print("\n");
/*     */           
/* 111 */           bb = ByteBuffer.wrap(yellow);
/* 112 */           bb.order(ByteOrder.LITTLE_ENDIAN);
/* 113 */           int current_yellow = bb.getInt();
/* 114 */           System.err.print("Yellow Value:");
/* 115 */           System.err.print(current_yellow);
/* 116 */           System.err.print("\n");
/*     */           
/* 118 */           bb = ByteBuffer.wrap(red);
/* 119 */           bb.order(ByteOrder.LITTLE_ENDIAN);
/* 120 */           int current_red = bb.getInt();
/* 121 */           System.err.print("Red Value:");
/* 122 */           System.err.print(current_red);
/* 123 */           System.err.print("\n");
/*     */           
/* 125 */           bb = ByteBuffer.wrap(cal);
/* 126 */           bb.order(ByteOrder.LITTLE_ENDIAN);
/* 127 */           int current_cal = bb.getInt();
/* 128 */           System.err.print("Calibration Value:");
/* 129 */           System.err.print(current_cal);
/* 130 */           System.err.print("\n");
/*     */           try
/*     */           {
/* 133 */             Thread.sleep(50L);
/*     */           }
/*     */           catch (InterruptedException e) {
/* 136 */             e.printStackTrace();
/*     */           }
/*     */         }
/*     */       } finally {
/* 140 */         dev.close();
/* 141 */         hid_mgr.release();
/* 142 */         System.gc();
/*     */       }
/*     */     }
/*     */     catch (IOException e) {
/* 146 */       e.printStackTrace();
/*     */     }
/* 148 */     System.out.println("finished");
/*     */   }
/*     */   
/*     */   private static void setValues(String green, String yellow, String red, String cal)
/*     */   {
/*     */     try
/*     */     {
/* 155 */       HIDManager hid_mgr = HIDManager.getInstance();
/* 156 */       HIDDevice dev = hid_mgr.openById(1240, 62547, null);
/* 157 */       System.err.print("Manufacturer: " + dev.getManufacturerString() + "\n");
/* 158 */       System.err.print("Product: " + dev.getProductString() + "\n");
/* 159 */       System.err.print("Serial Number: " + dev.getSerialNumberString() + "\n");
/*     */       try {
/* 161 */         int igreen = Integer.parseInt(green);
/* 162 */         int iyellow = Integer.parseInt(yellow);
/* 163 */         int ired = Integer.parseInt(red);
/* 164 */         int ical = Integer.parseInt(cal);
/* 165 */         int last_value = 0;
/* 166 */         int curr_value = 0;
/* 167 */         int raise = 0;
/* 168 */         byte[] buf = new byte[64];
/* 169 */         dev.enableBlocking();
/* 170 */         byte[] cmd = new byte[13];
/*     */         
/* 172 */         cmd[0] = 54;
/* 173 */         cmd[1] = ((byte)(igreen >> 0));
/* 174 */         cmd[2] = ((byte)(igreen >> 8));
/* 175 */         cmd[3] = ((byte)(iyellow >> 0));
/* 176 */         cmd[4] = ((byte)(iyellow >> 8));
/* 177 */         cmd[5] = ((byte)(ired >> 0));
/* 178 */         cmd[6] = ((byte)(ired >> 8));
/* 179 */         cmd[7] = ((byte)(ical >> 0));
/* 180 */         cmd[8] = ((byte)(ical >> 8));
/* 181 */         dev.write(cmd);
/* 182 */         System.out.println("wrote green " + igreen + ", yellow " + iyellow + ", red " + ired + ", cal " + ical);
/*     */         
/* 184 */         for (int i = 0; i < 9; i++)
/*     */         {
/* 186 */           int v = cmd[i];
/* 187 */           if (v < 0) v += 256;
/* 188 */           String hs = Integer.toHexString(v);
/* 189 */           if (v < 16)
/* 190 */             System.err.print("0");
/* 191 */           System.err.print(hs + " ");
/*     */         }
/* 193 */         System.err.println("");
/*     */         try
/*     */         {
/* 196 */           Thread.sleep(50L);
/*     */         }
/*     */         catch (InterruptedException e) {
/* 199 */           e.printStackTrace();
/*     */         }
/*     */       } finally {
/* 202 */         dev.close();
/* 203 */         hid_mgr.release();
/* 204 */         System.gc();
/*     */       }
/*     */     }
/*     */     catch (IOException e) {
/* 208 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void listDevices()
/*     */   {
/* 218 */     String property = System.getProperty("java.library.path");
/* 219 */     System.err.println(property);
/*     */     
/*     */     try
/*     */     {
/* 223 */       HIDManager manager = HIDManager.getInstance();
/* 224 */       HIDDeviceInfo[] devs = manager.listDevices();
/* 225 */       System.err.println("Devices:\n\n");
/* 226 */       for (int i = 0; i < devs.length; i++)
/*     */       {
/* 228 */         System.err.println("" + i + ".\t" + devs[i]);
/* 229 */         System.err.println("---------------------------------------------\n");
/*     */       }
/* 231 */       System.gc();
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 235 */       System.err.println(e.getMessage());
/* 236 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   public HIDAPITest() {}
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/com/codeminders/hidapi/HIDAPITest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */