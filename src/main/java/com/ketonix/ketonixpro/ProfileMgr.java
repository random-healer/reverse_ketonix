/*     */ package com.ketonix.ketonixpro;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.util.prefs.Preferences;
/*     */ import javax.crypto.Cipher;
/*     */ import javax.crypto.SecretKey;
/*     */ import javax.crypto.SecretKeyFactory;
/*     */ import javax.crypto.spec.DESKeySpec;
/*     */ import javax.xml.bind.DatatypeConverter;
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
/*     */ public class ProfileMgr
/*     */ {
/*     */   Preferences root;
/*  25 */   byte[] rawKey = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23 };
/*     */   
/*     */ 
/*     */ 
/*     */   public ProfileMgr()
/*     */   {
/*  31 */     this.root = Preferences.userRoot().node("/com/ketonix/app1");
/*     */     
/*     */ 
/*     */ 
/*  35 */     debugTree();
/*  36 */     int currcount = this.root.getInt("count", 0);
/*     */     
/*  38 */     for (int i = currcount; i < 100; i++) {
/*  39 */       String x = this.root.get("userName-" + i, "");
/*  40 */       this.root.remove("userDisplayName-" + i);
/*  41 */       this.root.remove("userName-" + i);
/*  42 */       this.root.remove("password-" + i);
/*  43 */       this.root.remove("userAnonymousDataAgreement-" + i);
/*  44 */       this.root.remove("userGender-" + i);
/*  45 */       this.root.remove("userAge-" + i);
/*  46 */       this.root.remove("userUsage-" + i);
/*  47 */       this.root.remove("userSmokes-" + i);
/*  48 */       this.root.remove("userDataFile-" + i);
/*  49 */       this.root.remove(x);
/*  50 */       x = this.root.get("userName--" + i, "");
/*  51 */       this.root.remove("userDisplayName--" + i);
/*  52 */       this.root.remove("userName--" + i);
/*  53 */       this.root.remove("password--" + i);
/*  54 */       this.root.remove("userAnonymousDataAgreement--" + i);
/*  55 */       this.root.remove("userGender--" + i);
/*  56 */       this.root.remove("userAge--" + i);
/*  57 */       this.root.remove("userUsage--" + i);
/*  58 */       this.root.remove("userSmokes--" + i);
/*  59 */       this.root.remove("userDataFile--" + i);
/*     */     }
/*     */     
/*  62 */     debugTree();
/*     */   }
/*     */   
/*     */   public static byte[] hexStringToBytes(String str)
/*     */   {
/*  67 */     return DatatypeConverter.parseHexBinary(str);
/*     */   }
/*     */   
/*     */   public static String bytesToHexString(byte[] bytes) {
/*  71 */     return DatatypeConverter.printHexBinary(bytes);
/*     */   }
/*     */   
/*     */   public int numProfiles()
/*     */   {
/*  76 */     return this.root.getInt("count", 0);
/*     */   }
/*     */   
/*     */   public String getUserDisplayName(int ix)
/*     */   {
/*  81 */     return this.root.get("userDisplayName-" + ix, "");
/*     */   }
/*     */   
/*     */   public String getUserName(int ix)
/*     */   {
/*  86 */     return this.root.get("userName-" + ix, "");
/*     */   }
/*     */   
/*     */   public boolean allowAnonymousData(int ix)
/*     */   {
/*  91 */     String choice = getAnonymousDataAgreement(ix);
/*  92 */     if (choice == null) return false;
/*  93 */     return choice.equalsIgnoreCase("yes");
/*     */   }
/*     */   
/*     */   public String getAnonymousDataAgreement(int ix)
/*     */   {
/*  98 */     return this.root.get("userAnonymousDataAgreement-" + ix, "");
/*     */   }
/*     */   
/*     */   public String gender(int ix)
/*     */   {
/* 103 */     return this.root.get("userGender-" + ix, "");
/*     */   }
/*     */   
/*     */   public String smoking(int ix)
/*     */   {
/* 108 */     return this.root.get("userSmokes-" + ix, "");
/*     */   }
/*     */   
/*     */   public String age(int ix)
/*     */   {
/* 113 */     return this.root.get("userAge-" + ix, "");
/*     */   }
/*     */   
/*     */   public String usage(int ix)
/*     */   {
/* 118 */     return this.root.get("userUsage-" + ix, "");
/*     */   }
/*     */   
/*     */   public String dataFile(int ix)
/*     */   {
/* 123 */     return this.root.get("userDataFile-" + ix, "");
/*     */   }
/*     */   
/*     */   public void setCount(int num)
/*     */   {
/* 128 */     this.root.putInt("count", num);
/*     */   }
/*     */   
/*     */   public String getUserPassword(int ix)
/*     */   {
/*     */     try {
/* 134 */       DESKeySpec dks = new DESKeySpec(this.rawKey);
/* 135 */       SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
/* 136 */       SecretKey myDesKey = keyFactory.generateSecret(dks);
/*     */       
/* 138 */       Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
/* 139 */       String textEncrypted = this.root.get("password-" + ix, "");
/* 140 */       desCipher.init(2, myDesKey);
/* 141 */       byte[] textDecrypted = desCipher.doFinal(hexStringToBytes(textEncrypted));
/* 142 */       return new String(textDecrypted);
/*     */     }
/*     */     catch (Exception ex) {
/* 145 */       System.out.println(ex.toString());
/*     */     }
/* 147 */     return "";
/*     */   }
/*     */   
/*     */   public boolean addUser(String userDisplayName, String username, String password, String agree, String gender, String age, String usage, String smoking, String dataFile)
/*     */   {
/* 152 */     int themax = this.root.getInt("count", 0);
/*     */     try {
/* 154 */       for (int i = 0; i < themax; i++) {
/* 155 */         String aname = this.root.get("userDisplayName-" + i, "");
/* 156 */         if (aname.equalsIgnoreCase(userDisplayName))
/*     */         {
/* 158 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 162 */       DESKeySpec dks = new DESKeySpec(this.rawKey);
/* 163 */       SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
/* 164 */       SecretKey myDesKey = keyFactory.generateSecret(dks);
/*     */       
/* 166 */       Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
/* 167 */       desCipher.init(1, myDesKey);
/* 168 */       byte[] text = password.getBytes();
/* 169 */       byte[] passwordEncrypted = desCipher.doFinal(text);
/* 170 */       int numUsers = this.root.getInt("count", 0);
/* 171 */       this.root.put("userDisplayName-" + numUsers, userDisplayName);
/* 172 */       this.root.put("userName-" + numUsers, username);
/* 173 */       this.root.put("password-" + numUsers, bytesToHexString(passwordEncrypted));
/* 174 */       this.root.put("userAnonymousDataAgreement-" + numUsers, agree);
/* 175 */       this.root.put("userGender-" + numUsers, gender);
/* 176 */       this.root.put("userAge-" + numUsers, age);
/* 177 */       this.root.put("userUsage-" + numUsers, usage);
/* 178 */       this.root.put("userSmokes-" + numUsers, smoking);
/* 179 */       this.root.put("userDataFile-" + numUsers, dataFile);
/*     */       
/* 181 */       this.root.putInt(username, numUsers);
/* 182 */       this.root.putInt("count", numUsers + 1);
/* 183 */       return true;
/*     */     } catch (Exception ex) {
/* 185 */       System.err.println(ex.toString());
/* 186 */       ex.printStackTrace(); }
/* 187 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean updateUser(int ix, String userDisplayName, String username, String password, String agree, String gender, String age, String usage, String smoking, String dataFile)
/*     */   {
/*     */     try
/*     */     {
/* 195 */       DESKeySpec dks = new DESKeySpec(this.rawKey);
/* 196 */       SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
/* 197 */       SecretKey myDesKey = keyFactory.generateSecret(dks);
/*     */       
/* 199 */       Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
/* 200 */       desCipher.init(1, myDesKey);
/* 201 */       byte[] text = password.getBytes();
/* 202 */       byte[] passwordEncrypted = desCipher.doFinal(text);
/* 203 */       this.root.put("userDisplayName-" + ix, userDisplayName);
/* 204 */       this.root.put("userName-" + ix, username);
/* 205 */       this.root.put("password-" + ix, bytesToHexString(passwordEncrypted));
/* 206 */       this.root.put("userAnonymousDataAgreement-" + ix, agree);
/* 207 */       this.root.put("userGender-" + ix, gender);
/* 208 */       this.root.put("userAge-" + ix, age);
/* 209 */       this.root.put("userUsage-" + ix, usage);
/* 210 */       this.root.put("userSmokes-" + ix, smoking);
/* 211 */       this.root.put("userDataFile-" + ix, dataFile);
/* 212 */       this.root.putInt(username, ix);
/* 213 */       return true;
/*     */     } catch (Exception ex) {}
/* 215 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean delUserIx(int ix)
/*     */   {
/* 222 */     if (ix < 0) return false;
/* 223 */     int mAx = this.root.getInt("count", 0);
/* 224 */     debugTree();
/* 225 */     String x = this.root.get("userName-" + ix, "");
/*     */     
/*     */ 
/* 228 */     for (int i = ix + 1; i < mAx; i++)
/*     */     {
/* 230 */       String udn = this.root.get("userDisplayName-" + i, "");
/* 231 */       String un = this.root.get("userName-" + i, "");
/* 232 */       String up = this.root.get("password-" + i, "");
/* 233 */       String anon = this.root.get("userAnonymousDataAgreement-" + i, "");
/* 234 */       String gender = this.root.get("userGender-" + i, "");
/* 235 */       String age = this.root.get("userAge-" + i, "");
/* 236 */       String usage = this.root.get("userUsage-" + i, "");
/* 237 */       String smokes = this.root.get("userSmokes-" + i, "");
/* 238 */       String datafile = this.root.get("userDataFile-" + i, "");
/*     */       
/*     */ 
/*     */ 
/* 242 */       this.root.put("userDisplayName-" + (i - 1), udn);
/* 243 */       this.root.put("userName-" + (i - 1), un);
/* 244 */       this.root.put("password-" + (i - 1), up);
/* 245 */       this.root.put("userAnonymousDataAgreement-" + (i - 1), anon);
/* 246 */       this.root.put("userGender-" + (i - 1), gender);
/* 247 */       this.root.put("userAge-" + (i - 1), age);
/* 248 */       this.root.put("userUsage-" + (i - 1), usage);
/* 249 */       this.root.put("userSmokes-" + (i - 1), smokes);
/* 250 */       this.root.put("userDataFile-" + (i - 1), datafile);
/*     */     }
/* 252 */     this.root.putInt("count", mAx - 1);
/* 253 */     x = this.root.get("userName-" + (mAx - 1), "");
/* 254 */     this.root.remove("userDisplayName-" + (mAx - 1));
/* 255 */     this.root.remove("userName-" + (mAx - 1));
/* 256 */     this.root.remove("password-" + (mAx - 1));
/* 257 */     this.root.remove("userAnonymousDataAgreement-" + (mAx - 1));
/* 258 */     this.root.remove("userGender-" + (mAx - 1));
/* 259 */     this.root.remove("userAge-" + (mAx - 1));
/* 260 */     this.root.remove("userUsage-" + (mAx - 1));
/* 261 */     this.root.remove("userSmokes-" + (mAx - 1));
/* 262 */     this.root.remove("userDataFile-" + (mAx - 1));
/* 263 */     this.root.remove(x);
/*     */     
/*     */ 
/*     */ 
/* 267 */     debugTree();
/* 268 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void debugTree() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean delUser(String username)
/*     */   {
/*     */     try
/*     */     {
/* 286 */       this.root.remove(username);
/* 287 */       int max = this.root.getInt("count", -1);
/* 288 */       if (max < 0) return false;
/* 289 */       for (int ix = 0; ix < max; ix++)
/*     */       {
/* 291 */         String s = this.root.get("userName-" + ix, "");
/* 292 */         if (s.equals(username))
/*     */         {
/* 294 */           String x = this.root.get("userName-" + ix, "");
/* 295 */           this.root.remove("userDisplayName-" + ix);
/* 296 */           this.root.remove("userName-" + ix);
/* 297 */           this.root.remove("password-" + ix);
/* 298 */           this.root.remove("userAnonymousDataAgreement-" + ix);
/* 299 */           this.root.remove("userGender-" + ix);
/* 300 */           this.root.remove("userAge-" + ix);
/* 301 */           this.root.remove("userUsage-" + ix);
/* 302 */           this.root.remove("userSmokes-" + ix);
/* 303 */           this.root.remove("userDataFile-" + ix);
/* 304 */           this.root.remove(x);
/* 305 */           int cnt = this.root.getInt("count", -1);
/* 306 */           if (cnt > 0) this.root.putInt("count", cnt - 1);
/* 307 */           return true;
/*     */         }
/*     */       }
/*     */     } catch (Exception ex) {
/* 311 */       return false;
/*     */     }
/* 313 */     return false;
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/com/ketonix/ketonixpro/ProfileMgr.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */