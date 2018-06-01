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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HIDDeviceInfo
/*     */ {
/*     */   private String path;
/*     */   private int vendor_id;
/*     */   private int product_id;
/*     */   private String serial_number;
/*     */   private int release_number;
/*     */   private String manufacturer_string;
/*     */   private String product_string;
/*     */   private int usage_page;
/*     */   private int usage;
/*     */   private int interface_number;
/*     */   
/*     */   HIDDeviceInfo() {}
/*     */   
/*     */   public String getPath()
/*     */   {
/*  38 */     return this.path;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getVendor_id()
/*     */   {
/*  47 */     return this.vendor_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getProduct_id()
/*     */   {
/*  56 */     return this.product_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getSerial_number()
/*     */   {
/*  65 */     return this.serial_number;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getRelease_number()
/*     */   {
/*  75 */     return this.release_number;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getManufacturer_string()
/*     */   {
/*  84 */     return this.manufacturer_string;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getProduct_string()
/*     */   {
/*  93 */     return this.product_string;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getUsage_page()
/*     */   {
/* 102 */     return this.usage_page;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getUsage()
/*     */   {
/* 111 */     return this.usage;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getInterface_number()
/*     */   {
/* 123 */     return this.interface_number;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public native HIDDevice open()
/*     */     throws IOException;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String toString()
/*     */   {
/* 143 */     StringBuilder builder = new StringBuilder();
/* 144 */     builder.append("HIDDeviceInfo [path=");
/* 145 */     builder.append(this.path);
/* 146 */     builder.append(", vendor_id=");
/* 147 */     builder.append(this.vendor_id);
/* 148 */     builder.append(", product_id=");
/* 149 */     builder.append(this.product_id);
/* 150 */     builder.append(", serial_number=");
/* 151 */     builder.append(this.serial_number);
/* 152 */     builder.append(", release_number=");
/* 153 */     builder.append(this.release_number);
/* 154 */     builder.append(", manufacturer_string=");
/* 155 */     builder.append(this.manufacturer_string);
/* 156 */     builder.append(", product_string=");
/* 157 */     builder.append(this.product_string);
/* 158 */     builder.append(", usage_page=");
/* 159 */     builder.append(this.usage_page);
/* 160 */     builder.append(", usage=");
/* 161 */     builder.append(this.usage);
/* 162 */     builder.append(", interface_number=");
/* 163 */     builder.append(this.interface_number);
/* 164 */     builder.append("]");
/* 165 */     return builder.toString();
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/com/codeminders/hidapi/HIDDeviceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */