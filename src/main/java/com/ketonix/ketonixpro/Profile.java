/*    */ package com.ketonix.ketonixpro;
/*    */ 
/*    */ import java.io.Serializable;
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
/*    */ public class Profile
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = -6407020944414208496L;
/*    */   private String name;
/*    */   private String username;
/*    */   private String password;
/*    */   private int id;
/*    */   
/*    */   public Profile() {}
/*    */   
/*    */   public String toString()
/*    */   {
/* 27 */     return "Profile{name=" + this.name + ",id=" + this.id + ",username=" + this.username + "}";
/*    */   }
/*    */   
/*    */   public String getName()
/*    */   {
/* 32 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 36 */     this.name = name;
/*    */   }
/*    */   
/*    */   public int getId() {
/* 40 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(int id) {
/* 44 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getUsername() {
/* 48 */     return this.username;
/*    */   }
/*    */   
/*    */   public void setUsername(String username) {
/* 52 */     this.username = username;
/*    */   }
/*    */   
/*    */   public String getPassword() {
/* 56 */     return this.password;
/*    */   }
/*    */   
/*    */   public void setPassword(String password) {
/* 60 */     this.password = password;
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/com/ketonix/ketonixpro/Profile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */