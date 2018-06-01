/*     */ package com.ketonix.ketonixpro;
/*     */ 
/*     */ import com.codeminders.hidapi.HIDDevice;
/*     */ import com.codeminders.hidapi.HIDDeviceInfo;
/*     */ import com.codeminders.hidapi.HIDManager;
/*     */ import java.io.PrintStream;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ByteOrder;
/*     */ import java.time.LocalTime;
/*     */ import java.time.temporal.ChronoUnit;
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
/*     */ class MeasureLoop
/*     */   implements Runnable
/*     */ {
/*     */   private static final long READ_UPDATE_DELAY_MS = 50L;
/*     */   static final int VENDOR_ID = 1240;
/*     */   static final int PRODUCT_ID = 62547;
/*     */   private static final int BUFSIZE = 64;
/*     */   KSync gui;
/*     */   HIDDevice dev;
/*  44 */   static HIDManager hid_mgr = null;
/*  45 */   boolean doingOk = true;
/*     */   
/*     */   LocalTime measureTimeNow;
/*     */   
/*     */   public MeasureLoop(KSync gui)
/*     */   {
/*  51 */     this.gui = gui;
/*     */     try {
/*  53 */       hid_mgr = HIDManager.getInstance();
/*  54 */       if (hid_mgr != null) {
/*  55 */         System.out.println("got a HIDManager instance\n");
/*     */       } else {
/*  57 */         System.out.println("failed getting a HIDManager instance\n");
/*     */       }
/*  59 */       this.gui.measureStartTime = LocalTime.now();
/*  60 */       this.measureTimeNow = LocalTime.now();
/*     */     } catch (Exception ioex) {
/*  62 */       ioex.printStackTrace();
/*     */     }
/*  64 */     this.dev = null;
/*     */   }
/*     */   
/*     */   public boolean openDevice()
/*     */   {
/*  69 */     if (this.dev != null)
/*     */     {
/*  71 */       return true;
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
/*     */ 
/*     */     try
/*     */     {
/*     */       try
/*     */       {
/*  88 */         Thread.sleep(1000L);
/*     */       }
/*     */       catch (Exception localException1) {}
/*     */       
/*  92 */       if (hid_mgr == null) System.err.println("hid_mgr is null");
/*  93 */       HIDDeviceInfo[] devs = hid_mgr.listDevices();
/*  94 */       System.out.println("Number of devices are " + devs.length);
/*  95 */       for (int i = 0; i < devs.length; i++)
/*     */       {
/*  97 */         if (devs[i] == null) System.err.println("devs[" + i + "] is null");
/*  98 */         System.out.println("devs[" + i + "].path = " + devs[i].getPath() + "," + devs[i].getProduct_id() + "," + devs[i].getVendor_id());
/*     */       }
/*     */       
/* 101 */       for (int i = 0; i < devs.length; i++)
/*     */       {
/*     */ 
/*     */ 
/* 105 */         if ((devs[i].getProduct_id() == 62547) && (devs[i].getVendor_id() == 1240)) {
/* 106 */           System.out.println("Found a Ketonix device");
/* 107 */           this.dev = hid_mgr.openByPath(devs[i].getPath());
/* 108 */           if (this.dev != null) break;
/* 109 */           System.err.println("hmm could not open the device by path"); break;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 115 */       if (this.dev == null) {
/*     */         try {
/* 117 */           System.err.println("trying to open device by ID");
/* 118 */           this.dev = hid_mgr.openById(1240, 62547, null);
/* 119 */           if (this.dev == null) {
/* 120 */             System.err.println("hmm could not open the device by Id");
/*     */           }
/*     */         } catch (Exception ex) {
/* 123 */           System.err.println(ex.toString());
/*     */         }
/*     */       }
/*     */       
/* 127 */       if (this.dev == null) {
/* 128 */         System.err.println("hmm could not open the device at all");
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 154 */       if (this.dev == null)
/*     */       {
/* 156 */         this.gui.noDevice();
/* 157 */         return false;
/*     */       }
/*     */       
/* 160 */       return true;
/*     */     } catch (Exception ioex) {
/* 162 */       System.out.println("OpenDevice() Exception:" + ioex.toString());
/* 163 */       ioex.printStackTrace();
/* 164 */       this.gui.noDevice(); }
/* 165 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   void setClassicMode()
/*     */   {
/*     */     try
/*     */     {
/* 173 */       byte[] rbuf = new byte[64];
/*     */       
/* 175 */       if ((this.dev == null) && 
/* 176 */         (!openDevice())) { return;
/*     */       }
/* 178 */       byte[] cmd = new byte[2];
/* 179 */       cmd[0] = 0;
/* 180 */       cmd[1] = 66;
/* 181 */       this.dev.enableBlocking();
/* 182 */       this.dev.write(cmd);
/* 183 */       this.dev.disableBlocking();
/* 184 */       this.dev.close();
/* 185 */       this.dev = null;
/*     */     }
/*     */     catch (Exception ex) {
/* 188 */       this.dev = null;
/* 189 */       this.doingOk = false;
/*     */     }
/*     */   }
/*     */   
/*     */   int realValue(byte l, byte h)
/*     */   {
/* 195 */     byte[] val = new byte[4];
/* 196 */     val[0] = l;val[1] = h;val[2] = 0;val[3] = 0;
/* 197 */     ByteBuffer bb = ByteBuffer.wrap(val);
/* 198 */     bb.order(ByteOrder.LITTLE_ENDIAN);
/* 199 */     return bb.getInt();
/*     */   }
/*     */   
/*     */ 
/*     */   void debugBytes(String where, byte[] arr)
/*     */   {
/* 205 */     int pot = realValue(arr[1], arr[2]);
/* 206 */     int raw = realValue(arr[3], arr[4]);
/* 207 */     int warming = realValue(arr[5], arr[6]);
/* 208 */     int green = realValue(arr[7], arr[8]);
/* 209 */     int yellow = realValue(arr[9], arr[10]);
/* 210 */     int red = realValue(arr[11], arr[12]);
/* 211 */     int cal = realValue(arr[13], arr[14]);
/* 212 */     int type = realValue(arr[15], arr[16]);
/* 213 */     int id = realValue(arr[17], arr[18]);
/* 214 */     int corr = realValue(arr[19], arr[20]);
/*     */   }
/*     */   
/*     */ 
/*     */   synchronized void setKetonixValues(int ig, int iy, int ir)
/*     */   {
/*     */     try
/*     */     {
/* 222 */       int last_value = 0;
/* 223 */       int curr_value = 0;
/* 224 */       int raise = 0;
/* 225 */       byte[] rbuf = new byte[64];
/* 226 */       byte[] sbuf = new byte[65];
/*     */       
/* 228 */       byte[] cmd = new byte[2];
/*     */       
/* 230 */       rbuf = this.gui.getCurrentValues();
/*     */       
/* 232 */       debugBytes("setKetonixValues(read)", rbuf);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 237 */       rbuf[7] = ((byte)(ig >> 0));
/* 238 */       rbuf[8] = ((byte)(ig >> 8));
/* 239 */       rbuf[9] = ((byte)(iy >> 0));
/* 240 */       rbuf[10] = ((byte)(iy >> 8));
/* 241 */       rbuf[11] = ((byte)(ir >> 0));
/* 242 */       rbuf[12] = ((byte)(ir >> 8));
/*     */       
/* 244 */       System.out.println("green:" + ig + ",yellow:" + iy + ",red:" + ir);
/*     */       
/* 246 */       debugBytes("setKetonixValues(write)", rbuf);
/*     */       
/* 248 */       for (int x = 0; x < 63; x++) { sbuf[(x + 1)] = rbuf[x];
/*     */       }
/*     */       
/*     */ 
/* 252 */       sbuf[0] = 0;
/* 253 */       sbuf[1] = 54;
/*     */       
/* 255 */       this.dev.enableBlocking();
/* 256 */       this.dev.write(sbuf);
/* 257 */       this.dev.disableBlocking();
/*     */       try
/*     */       {
/* 260 */         Thread.sleep(50L);
/*     */       }
/*     */       catch (InterruptedException e) {
/* 263 */         e.printStackTrace();
/*     */ 
/*     */       }
/*     */       
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */ 
/* 272 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   public synchronized void setCalibration(int cal, int corr)
/*     */   {
/*     */     try
/*     */     {
/*     */       try
/*     */       {
/* 282 */         int crr_type = 0;
/* 283 */         int crr_green = 0;
/* 284 */         int crr_yellow = 0;
/* 285 */         int crr_red = 0;
/*     */         
/* 287 */         byte[] rbuf = new byte[64];
/* 288 */         byte[] sbuf = new byte[64];
/* 289 */         byte[] cmd = new byte[2];
/* 290 */         byte[] ba = new byte[4];
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
/* 302 */         rbuf = this.gui.getCurrentValues();
/*     */         
/* 304 */         debugBytes("setCalibration(read)", rbuf);
/* 305 */         rbuf[13] = ((byte)(cal >> 0));
/* 306 */         rbuf[14] = ((byte)(cal >> 8));
/* 307 */         rbuf[19] = ((byte)(corr >> 0));
/* 308 */         rbuf[20] = ((byte)(corr >> 8));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 318 */         ba[0] = rbuf[15];
/* 319 */         ba[1] = rbuf[16];
/* 320 */         ba[2] = (ba[3] = 0);
/* 321 */         ByteBuffer bb = ByteBuffer.wrap(ba);
/* 322 */         bb.order(ByteOrder.LITTLE_ENDIAN);
/* 323 */         crr_type = bb.getInt();
/*     */         
/* 325 */         ba[0] = rbuf[7];
/* 326 */         ba[1] = rbuf[8];
/* 327 */         ba[2] = (ba[3] = 0);
/* 328 */         bb = ByteBuffer.wrap(ba);
/* 329 */         bb.order(ByteOrder.LITTLE_ENDIAN);
/* 330 */         crr_green = bb.getInt();
/*     */         
/* 332 */         ba[0] = rbuf[9];
/* 333 */         ba[1] = rbuf[10];
/* 334 */         ba[2] = (ba[3] = 0);
/* 335 */         bb = ByteBuffer.wrap(ba);
/* 336 */         bb.order(ByteOrder.LITTLE_ENDIAN);
/* 337 */         crr_yellow = bb.getInt();
/*     */         
/* 339 */         ba[0] = rbuf[11];
/* 340 */         ba[1] = rbuf[12];
/* 341 */         ba[2] = (ba[3] = 0);
/* 342 */         bb = ByteBuffer.wrap(ba);
/* 343 */         bb.order(ByteOrder.LITTLE_ENDIAN);
/* 344 */         crr_red = bb.getInt();
/*     */         
/*     */ 
/*     */ 
/* 348 */         System.out.println("crr_type=" + crr_type);
/* 349 */         System.out.println("2) got colors (green " + crr_green + ", yellow " + crr_yellow + ", red " + crr_red + ")");
/*     */         
/* 351 */         debugBytes("setCalibration(write)", rbuf);
/*     */         
/* 353 */         for (int x = 0; x < 63; x++) { sbuf[(x + 1)] = rbuf[x];
/*     */         }
/* 355 */         sbuf[0] = 0;
/* 356 */         sbuf[1] = 54;
/*     */         
/*     */ 
/* 359 */         System.out.println("setting cal (type=" + crr_type + ")");
/* 360 */         sbuf[16] = ((byte)(crr_type >> 0));
/* 361 */         sbuf[17] = ((byte)(crr_type >> 8));
/*     */         
/*     */ 
/* 364 */         sbuf[8] = ((byte)(crr_green >> 0));
/* 365 */         sbuf[9] = ((byte)(crr_green >> 8));
/*     */         
/* 367 */         sbuf[10] = ((byte)(crr_yellow >> 0));
/* 368 */         sbuf[11] = ((byte)(crr_yellow >> 8));
/*     */         
/* 370 */         sbuf[12] = ((byte)(crr_red >> 0));
/* 371 */         sbuf[13] = ((byte)(crr_red >> 8));
/* 372 */         System.out.println("setting colors (green " + crr_green + ",yellow " + crr_yellow + ",red " + crr_red + ")");
/*     */         
/*     */ 
/* 375 */         this.dev.enableBlocking();
/* 376 */         int n = this.dev.write(sbuf);
/* 377 */         this.dev.disableBlocking();
/*     */         try
/*     */         {
/* 380 */           Thread.sleep(50L);
/*     */         }
/*     */         catch (InterruptedException e)
/*     */         {
/* 384 */           e.printStackTrace();
/*     */         }
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/* 389 */         e.printStackTrace();
/*     */       }
/*     */       finally
/*     */       {
/* 393 */         System.gc();
/*     */       }
/*     */     } catch (Exception x) {
/* 396 */       x.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   void setContinousMode()
/*     */   {
/*     */     try
/*     */     {
/* 406 */       if (!openDevice()) return;
/* 407 */       byte[] cmd = new byte[2];
/* 408 */       cmd[0] = 0;
/* 409 */       cmd[1] = 67;
/* 410 */       this.dev.enableBlocking();
/* 411 */       this.dev.write(cmd);
/* 412 */       this.dev.disableBlocking();
/*     */     }
/*     */     catch (Exception ex) {
/* 415 */       this.dev = null;
/* 416 */       this.doingOk = false;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   int readDevice()
/*     */   {
/*     */     try
/*     */     {
/* 426 */       if (!openDevice()) { return 0;
/*     */       }
/* 428 */       int last_value = 0;
/* 429 */       int raise = 0;
/* 430 */       byte[] buf = new byte[64];
/* 431 */       byte[] val = new byte[5];
/* 432 */       byte[] red = new byte[5];
/* 433 */       byte[] green = new byte[5];
/* 434 */       byte[] yellow = new byte[5];
/* 435 */       byte[] cal = new byte[5];
/* 436 */       byte[] type = new byte[5];
/* 437 */       byte[] id = new byte[5];
/* 438 */       byte[] raw = new byte[5];
/* 439 */       byte[] corr = new byte[5];
/* 440 */       byte[] warmup = new byte[5];
/*     */       
/*     */ 
/* 443 */       byte[] cmd = new byte[2];
/*     */       
/* 445 */       cmd[0] = 0;
/* 446 */       cmd[1] = 55;
/* 447 */       this.dev.enableBlocking();
/* 448 */       this.dev.write(cmd);
/* 449 */       int n = this.dev.read(buf);
/* 450 */       this.dev.disableBlocking();
/*     */       
/* 452 */       val[0] = buf[1];
/* 453 */       val[1] = buf[2];
/* 454 */       val[2] = 0;
/* 455 */       val[3] = 0;
/*     */       
/* 457 */       raw[0] = buf[3];
/* 458 */       raw[1] = buf[4];
/* 459 */       raw[2] = 0;
/* 460 */       raw[3] = 0;
/*     */       
/* 462 */       warmup[0] = buf[5];
/* 463 */       warmup[1] = buf[6];
/* 464 */       warmup[2] = 0;
/* 465 */       warmup[3] = 0;
/*     */       
/* 467 */       green[0] = buf[7];
/* 468 */       green[1] = buf[8];
/* 469 */       green[2] = 0;
/* 470 */       green[3] = 0;
/* 471 */       yellow[0] = buf[9];
/* 472 */       yellow[1] = buf[10];
/* 473 */       yellow[3] = 0;
/* 474 */       yellow[4] = 0;
/* 475 */       red[0] = buf[11];
/* 476 */       red[1] = buf[12];
/* 477 */       red[2] = 0;
/* 478 */       red[3] = 0;
/* 479 */       cal[0] = buf[13];
/* 480 */       cal[1] = buf[14];
/* 481 */       cal[2] = 0;
/* 482 */       cal[3] = 0;
/* 483 */       type[0] = buf[15];
/* 484 */       type[1] = buf[16];
/* 485 */       type[2] = 0;
/* 486 */       type[3] = 0;
/* 487 */       id[0] = buf[17];
/* 488 */       id[1] = buf[18];
/* 489 */       id[2] = 0;
/* 490 */       id[3] = 0;
/* 491 */       corr[0] = buf[19];
/* 492 */       corr[1] = buf[20];
/* 493 */       corr[2] = ((byte)(buf[20] < 0 ? -1 : 0));
/* 494 */       corr[3] = ((byte)(buf[20] < 0 ? -1 : 0));
/*     */       
/*     */ 
/* 497 */       ByteBuffer bb = ByteBuffer.wrap(val);
/* 498 */       bb.order(ByteOrder.LITTLE_ENDIAN);
/* 499 */       this.gui.current_value = bb.getInt();
/*     */       
/*     */ 
/*     */ 
/* 503 */       bb = ByteBuffer.wrap(green);
/* 504 */       bb.order(ByteOrder.LITTLE_ENDIAN);
/* 505 */       this.gui.current_green = bb.getInt();
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 510 */       bb = ByteBuffer.wrap(yellow);
/* 511 */       bb.order(ByteOrder.LITTLE_ENDIAN);
/* 512 */       this.gui.current_yellow = bb.getInt();
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 517 */       bb = ByteBuffer.wrap(red);
/* 518 */       bb.order(ByteOrder.LITTLE_ENDIAN);
/* 519 */       this.gui.current_red = bb.getInt();
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 524 */       bb = ByteBuffer.wrap(cal);
/* 525 */       bb.order(ByteOrder.LITTLE_ENDIAN);
/* 526 */       this.gui.current_cal = bb.getInt();
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 532 */       bb = ByteBuffer.wrap(type);
/* 533 */       bb.order(ByteOrder.LITTLE_ENDIAN);
/* 534 */       this.gui.current_type = bb.getInt();
/*     */       
/* 536 */       bb = ByteBuffer.wrap(id);
/* 537 */       bb.order(ByteOrder.LITTLE_ENDIAN);
/* 538 */       this.gui.current_id = bb.getInt();
/*     */       
/* 540 */       bb = ByteBuffer.wrap(raw);
/* 541 */       bb.order(ByteOrder.LITTLE_ENDIAN);
/* 542 */       this.gui.current_raw = bb.getInt();
/*     */       
/* 544 */       bb = ByteBuffer.wrap(corr);
/* 545 */       bb.order(ByteOrder.LITTLE_ENDIAN);
/* 546 */       this.gui.current_corr = bb.getInt();
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 552 */       bb = ByteBuffer.wrap(warmup);
/* 553 */       bb.order(ByteOrder.LITTLE_ENDIAN);
/* 554 */       this.gui.current_warmup = bb.getInt();
/*     */       try
/*     */       {
/* 557 */         Thread.sleep(50L);
/*     */       } catch (InterruptedException e) {
/* 559 */         e.printStackTrace();
/* 560 */         System.err.println("1 readDevice() caught interrupted exception");
/*     */       }
/*     */     } catch (Exception ex) {
/* 563 */       System.err.println("2 readDevice() caught exception:" + ex.toString());
/* 564 */       ex.printStackTrace();
/* 565 */       this.dev = null;
/*     */     }
/* 567 */     return this.gui.current_value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void run()
/*     */   {
/* 574 */     setContinousMode();
/* 575 */     this.doingOk = true;
/* 576 */     while (this.doingOk) {
/*     */       try {
/* 578 */         readDevice();
/* 579 */         this.gui.setCurrentValues();
/* 580 */         if (this.gui.isMeasuring)
/*     */         {
/* 582 */           this.gui.setFeedback("Breathe into KETONIX® as long as possible");
/*     */         }
/*     */         
/* 585 */         this.measureTimeNow = LocalTime.now();
/* 586 */         long secondsBetween = ChronoUnit.SECONDS.between(this.gui.measureStartTime, this.measureTimeNow);
/* 587 */         if ((secondsBetween > 60L) && (this.gui.gui_max_val >= this.gui.current_corr + 50) && (this.gui.current_value < this.gui.gui_max_val - 50)) {
/* 588 */           this.gui.setFeedback("Time to click on Stop & Save?");
/*     */         }
/*     */       } catch (Exception ex) {
/* 591 */         System.out.println("run() caught exception:" + ex.toString());
/* 592 */         this.doingOk = false;
/*     */       }
/*     */       try {
/* 595 */         Thread.sleep(500L);
/*     */       }
/*     */       catch (Exception localException1) {}
/*     */     }
/*     */     
/*     */ 
/* 601 */     System.exit(0);
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/com/ketonix/ketonixpro/MeasureLoop.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */