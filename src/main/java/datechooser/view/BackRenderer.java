/*     */ package datechooser.view;
/*     */ 
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Image;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import javax.imageio.ImageIO;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BackRenderer
/*     */   implements Serializable
/*     */ {
/*     */   public static final int ALIGN_CENTER = 0;
/*     */   public static final int ALIGN_FILL = 1;
/*     */   public static final int ALIGN_TILE = 2;
/*     */   private int style;
/*     */   private URL url;
/*     */   private transient Image image;
/*     */   private transient int imageWidth;
/*     */   private transient int imageHeight;
/*     */   private transient int timesX;
/*     */   private transient int timesY;
/*     */   private transient int i;
/*     */   private transient int j;
/*     */   
/*     */   public BackRenderer(int style, String imageURLPath)
/*     */   {
/*  39 */     this.style = style;
/*  40 */     initializeByString(imageURLPath);
/*     */   }
/*     */   
/*     */   public BackRenderer(int style, URL imageURL) {
/*  44 */     this(style, imageURL, null);
/*     */   }
/*     */   
/*     */   private void initializeByString(String URLPath) {
/*  48 */     File file = new File(URLPath);
/*  49 */     if (!file.exists()) {
/*  50 */       setNoImage();
/*  51 */       return;
/*     */     }
/*     */     try {
/*  54 */       this.url = file.toURL();
/*     */     } catch (MalformedURLException ex) {
/*  56 */       setNoImage();
/*  57 */       return;
/*     */     }
/*  59 */     try { setImage(ImageIO.read(this.url));
/*     */     } catch (IOException ex) {
/*  61 */       setNoImage();
/*     */     }
/*     */   }
/*     */   
/*     */   private void setNoImage()
/*     */   {
/*  67 */     this.url = null;
/*  68 */     setImage(null);
/*     */   }
/*     */   
/*     */   public BackRenderer(int style, URL imageURL, Image image) {
/*  72 */     if (image == null) {
/*     */       try {
/*  74 */         setImage(ImageIO.read(imageURL));
/*  75 */         this.url = imageURL;
/*     */       } catch (IOException ex) {
/*  77 */         ex.printStackTrace();
/*     */       }
/*     */     } else {
/*  80 */       setImage(image);
/*  81 */       this.url = imageURL;
/*     */     }
/*  83 */     this.style = style;
/*     */   }
/*     */   
/*     */   private void setImage(Image image) {
/*  87 */     this.image = image;
/*  88 */     if (image != null) {
/*  89 */       this.imageWidth = image.getWidth(null);
/*  90 */       this.imageHeight = image.getHeight(null);
/*     */     }
/*     */   }
/*     */   
/*     */   public void render(Graphics2D g, Rectangle bounds) {
/*  95 */     if (this.image == null) return;
/*  96 */     switch (this.style) {
/*     */     case 0: 
/*  98 */       renderCentered(g, bounds);
/*  99 */       break;
/*     */     case 1: 
/* 101 */       renderFilled(g, bounds);
/* 102 */       break;
/*     */     case 2: 
/* 104 */       renderTiled(g, bounds);
/*     */     }
/*     */   }
/*     */   
/*     */   private void renderCentered(Graphics2D g, Rectangle bounds)
/*     */   {
/* 110 */     g.drawImage(getImage(), (bounds.width - this.imageWidth) / 2, (bounds.height - this.imageHeight) / 2, this.imageWidth, this.imageHeight, null);
/*     */   }
/*     */   
/*     */ 
/*     */   private void renderFilled(Graphics2D g, Rectangle bounds)
/*     */   {
/* 116 */     g.drawImage(getImage(), 0, 0, bounds.width, bounds.height, null);
/*     */   }
/*     */   
/*     */   private void renderTiled(Graphics2D g, Rectangle bounds) {
/* 120 */     this.timesX = (bounds.width / this.imageWidth + 1);
/* 121 */     this.timesY = (bounds.height / this.imageHeight + 1);
/* 122 */     for (int i = 0; i < this.timesX; i++) {
/* 123 */       for (int j = 0; j < this.timesY; j++) {
/* 124 */         g.drawImage(getImage(), i * this.imageWidth, j * this.imageHeight, this.imageWidth, this.imageHeight, null);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public int getStyle()
/*     */   {
/* 131 */     return this.style;
/*     */   }
/*     */   
/*     */   public Image getImage() {
/* 135 */     return this.image;
/*     */   }
/*     */   
/*     */   private void writeObject(ObjectOutputStream out) throws IOException {
/* 139 */     out.defaultWriteObject();
/* 140 */     if (this.image != null) {
/* 141 */       out.writeBoolean(true);
/* 142 */       ImageIO.write((BufferedImage)this.image, "jpg", out);
/*     */     } else {
/* 144 */       out.writeBoolean(false);
/*     */     }
/*     */   }
/*     */   
/*     */   private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
/*     */   {
/* 150 */     in.defaultReadObject();
/* 151 */     if (in.readBoolean()) {
/* 152 */       setImage(ImageIO.read(in));
/*     */     }
/*     */   }
/*     */   
/*     */   public URL getUrl() {
/* 157 */     return this.url;
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/view/BackRenderer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */