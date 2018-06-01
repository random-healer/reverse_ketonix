/*    */ package com.ketonix.ketonixpro;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BootKetonix
/*    */ {
/*    */   public BootKetonix() {}
/*    */   
/*    */   public static void startKSync()
/*    */     throws Exception
/*    */   {
/* 18 */     String separator = System.getProperty("file.separator");
/* 19 */     String classpath = System.getProperty("java.class.path");
/* 20 */     String path = System.getProperty("java.home") + separator + "bin" + separator + "java";
/* 21 */     String jlp = System.getProperty("java.library.path");
/* 22 */     System.out.println("java.library.path:" + jlp);
/*    */     
/* 24 */     ProcessBuilder processBuilder = new ProcessBuilder(new String[] { path, "-DLANG=sv_SE.UTF-8", "-jar", classpath, KSync.class.getName() });
/* 25 */     System.out.println(path + "-DLANG=sv_SE.UTF-8" + " -jar" + classpath + KSync.class.getName());
/* 26 */     Map<String, String> mp = processBuilder.environment();
/* 27 */     mp.put("LANG", "sv_SE.UTF-8");
/* 28 */     Process process = processBuilder.start();
/* 29 */     process.waitFor();
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/com/ketonix/ketonixpro/BootKetonix.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */