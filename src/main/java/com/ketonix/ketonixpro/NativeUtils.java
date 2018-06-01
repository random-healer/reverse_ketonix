/*    */ package com.ketonix.ketonixpro;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileNotFoundException;
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.io.OutputStream;
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
/*    */ public class NativeUtils
/*    */ {
/*    */   private NativeUtils() {}
/*    */   
/*    */   public static void loadLibraryFromJar(String path)
/*    */     throws IOException
/*    */   {
/* 44 */     if (!path.startsWith("/")) {
/* 45 */       throw new IllegalArgumentException("The path has to be absolute (start with '/').");
/*    */     }
/*    */     
/*    */ 
/* 49 */     String[] parts = path.split("/");
/* 50 */     String filename = parts.length > 1 ? parts[(parts.length - 1)] : null;
/*    */     
/*    */ 
/* 53 */     String prefix = "";
/* 54 */     String suffix = null;
/* 55 */     if (filename != null) {
/* 56 */       parts = filename.split("\\.", 2);
/* 57 */       prefix = parts[0];
/* 58 */       suffix = parts.length > 1 ? "." + parts[(parts.length - 1)] : null;
/*    */     }
/*    */     
/*    */ 
/* 62 */     if ((filename == null) || (prefix.length() < 3)) {
/* 63 */       throw new IllegalArgumentException("The filename has to be at least 3 characters long.");
/*    */     }
/*    */     
/*    */ 
/* 67 */     File temp = File.createTempFile(prefix, suffix);
/* 68 */     temp.deleteOnExit();
/*    */     
/* 70 */     if (!temp.exists()) {
/* 71 */       throw new FileNotFoundException("File " + temp.getAbsolutePath() + " does not exist.");
/*    */     }
/*    */     
/*    */ 
/* 75 */     byte[] buffer = new byte['Ѐ'];
/*    */     
/*    */ 
/*    */ 
/* 79 */     InputStream is = NativeUtils.class.getResourceAsStream(path);
/* 80 */     if (is == null) {
/* 81 */       throw new FileNotFoundException("File " + path + " was not found inside JAR.");
/*    */     }
/*    */     
/*    */ 
/* 85 */     OutputStream os = new FileOutputStream(temp);
/*    */     try { int readBytes;
/* 87 */       while ((readBytes = is.read(buffer)) != -1) {
/* 88 */         os.write(buffer, 0, readBytes);
/*    */       }
/*    */     }
/*    */     finally {
/* 92 */       os.close();
/* 93 */       is.close();
/*    */     }
/*    */     
/*    */     int readBytes;
/* 97 */     System.load(temp.getAbsolutePath());
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/com/ketonix/ketonixpro/NativeUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */