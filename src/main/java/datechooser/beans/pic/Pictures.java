/*    */ package datechooser.beans.pic;
/*    */ 
/*    */ import java.net.URL;
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
/*    */ public class Pictures
/*    */ {
/*    */   public Pictures() {}
/*    */   
/*    */   public static URL getResource(String name)
/*    */   {
/* 23 */     return Pictures.class.getResource(name);
/*    */   }
/*    */   
/*    */   public static URL getDefaultPicture() {
/* 27 */     return getResource("java_logo.png");
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/pic/Pictures.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */