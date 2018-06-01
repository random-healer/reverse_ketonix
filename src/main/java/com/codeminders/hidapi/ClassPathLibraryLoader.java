/*    */ package com.codeminders.hidapi;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.InputStream;
/*    */ import java.io.OutputStream;
/*    */ 
/*    */ 
/*    */ public class ClassPathLibraryLoader
/*    */ {
/* 11 */   private static final String[] HID_LIB_NAMES = { "/native/linux/libhidapi-jni-64.so", "/native/linux/libhidapi-jni-32.so", "/native/mac/libhidapi-jni-64.jnilib", "/native/mac/libhidapi-jni-32.jnilib", "/native/win/hidapi-jni-64.dll", "/native/win/hidapi-jni-32.dll" };
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public ClassPathLibraryLoader() {}
/*    */   
/*    */ 
/*    */ 
/*    */   public static boolean loadNativeHIDLibrary()
/*    */   {
/* 22 */     boolean isHIDLibLoaded = false;
/*    */     
/* 24 */     for (String path : HID_LIB_NAMES)
/*    */     {
/*    */       try
/*    */       {
/* 28 */         InputStream in = ClassPathLibraryLoader.class.getResourceAsStream(path);
/* 29 */         if (in != null) {
/*    */           try
/*    */           {
/* 32 */             String tempName = path.substring(path.lastIndexOf('/') + 1);
/* 33 */             File fileOut = File.createTempFile(tempName.substring(0, tempName.lastIndexOf('.')), tempName.substring(tempName.lastIndexOf('.'), tempName.length()));
/* 34 */             fileOut.deleteOnExit();
/*    */             
/* 36 */             OutputStream out = new FileOutputStream(fileOut);
/* 37 */             byte[] buf = new byte['Ѐ'];
/*    */             int len;
/* 39 */             while ((len = in.read(buf)) > 0) {
/* 40 */               out.write(buf, 0, len);
/*    */             }
/*    */             
/* 43 */             out.close();
/* 44 */             Runtime.getRuntime().load(fileOut.toString());
/* 45 */             isHIDLibLoaded = true;
/*    */           } finally {
/* 47 */             in.close();
/*    */           }
/*    */         }
/*    */       }
/*    */       catch (Exception e) {}catch (UnsatisfiedLinkError e) {}
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 56 */       if (isHIDLibLoaded) {
/*    */         break;
/*    */       }
/*    */     }
/*    */     
/* 61 */     return isHIDLibLoaded;
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/com/codeminders/hidapi/ClassPathLibraryLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */