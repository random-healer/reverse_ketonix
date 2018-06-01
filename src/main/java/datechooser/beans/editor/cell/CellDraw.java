/*     */ package datechooser.beans.editor.cell;
/*     */ 
/*     */ import datechooser.beans.locale.LocaleUtils;
/*     */ import datechooser.beans.pic.Pictures;
/*     */ import datechooser.view.appearance.CellAppearance;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Image;
/*     */ import java.awt.Rectangle;
/*     */ import java.io.IOException;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.swing.JPanel;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CellDraw
/*     */   extends JPanel
/*     */ {
/*     */   private static final int PART = 2;
/*     */   private static final int BORDER = 5;
/*     */   private CellAppearance look;
/*     */   private Rectangle cellBounds;
/*     */   private boolean manualEdited;
/*     */   private transient Image backImage;
/*     */   
/*     */   public CellDraw(CellAppearance look)
/*     */   {
/*     */     try
/*     */     {
/* 132 */       this.backImage = ImageIO.read(Pictures.getDefaultPicture());
/*     */     } catch (IOException ex) {
/* 134 */       ex.printStackTrace();
/*     */     }
/* 136 */     this.cellBounds = new Rectangle();
/* 137 */     setLook(look);
/* 138 */     refreshSize();
/*     */   }
/*     */   
/*     */   private void refreshSize()
/*     */   {
/* 143 */     setManualEdited(false);
/* 144 */     initSize();
/*     */   }
/*     */   
/*     */   private void initSize() {
/* 148 */     Rectangle panelBounds = getBounds();
/* 149 */     if (!isManualEdited()) {
/* 150 */       this.cellBounds.width = (panelBounds.width / 2);
/* 151 */       this.cellBounds.height = (panelBounds.height / 2);
/*     */     }
/* 153 */     this.cellBounds.x = ((panelBounds.width - this.cellBounds.width) / 2);
/* 154 */     this.cellBounds.y = ((panelBounds.height - this.cellBounds.height) / 2);
/*     */   }
/*     */   
/*     */   public void processCurrentSize() {
/* 158 */     if (!isManualEdited()) {
/* 159 */       refreshSize();
/*     */     } else {
/* 161 */       Rectangle panelBounds = getBounds();
/* 162 */       if ((getCellWidth() + 5 >= panelBounds.width) || (getCellHeight() + 5 >= panelBounds.height))
/*     */       {
/* 164 */         refreshSize();
/*     */       } else {
/* 166 */         initSize();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void drawCenteredImage(Graphics2D g) {
/* 172 */     Rectangle rec = getBounds();
/* 173 */     g.drawImage(this.backImage, (rec.width - this.backImage.getWidth(null)) / 2, (rec.height - this.backImage.getHeight(null)) / 2, this.backImage.getWidth(null), this.backImage.getHeight(null), null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void paintComponent(Graphics g)
/*     */   {
/* 180 */     super.paintComponent(g);
/* 181 */     processCurrentSize();
/* 182 */     Graphics2D g2d = (Graphics2D)g;
/* 183 */     if (this.look.getComposite() != null) {
/* 184 */       drawCenteredImage(g2d);
/*     */     }
/* 186 */     g2d.translate(this.cellBounds.x, this.cellBounds.y);
/* 187 */     this.look.render(g2d, this, LocaleUtils.getEditorLocaleString("26"), this.cellBounds.width, this.cellBounds.height, true);
/*     */   }
/*     */   
/*     */   public CellAppearance getLook() {
/* 191 */     return this.look;
/*     */   }
/*     */   
/*     */   public void setLook(CellAppearance look) {
/* 195 */     this.look = look;
/*     */   }
/*     */   
/*     */   public boolean isManualEdited() {
/* 199 */     return this.manualEdited;
/*     */   }
/*     */   
/*     */   public void setManualEdited(boolean manualEdited) {
/* 203 */     this.manualEdited = manualEdited;
/*     */   }
/*     */   
/*     */   public Dimension getPreferredSize() {
/* 207 */     return new Dimension(100, 100);
/*     */   }
/*     */   
/*     */   private void changeWidth(int width, int panelWidth) {
/* 211 */     this.cellBounds.x = ((panelWidth - width) / 2);
/* 212 */     this.cellBounds.width = width;
/*     */   }
/*     */   
/*     */   private void changeHeight(int height, int panelHeight) {
/* 216 */     this.cellBounds.y = ((panelHeight - height) / 2);
/* 217 */     this.cellBounds.height = height;
/*     */   }
/*     */   
/*     */   public int setCellWidth(int width) {
/* 221 */     Rectangle panelBounds = getBounds();
/* 222 */     if (width + 5 < panelBounds.getWidth()) {
/* 223 */       changeWidth(width, panelBounds.width);
/* 224 */       setManualEdited(true);
/*     */     }
/* 226 */     return getCellWidth();
/*     */   }
/*     */   
/*     */   public int setCellHeight(int height) {
/* 230 */     Rectangle panelBounds = getBounds();
/* 231 */     if (height + 5 < panelBounds.getHeight()) {
/* 232 */       changeHeight(height, panelBounds.height);
/* 233 */       setManualEdited(true);
/*     */     }
/* 235 */     return getCellHeight();
/*     */   }
/*     */   
/*     */   public int getCellWidth() {
/* 239 */     return this.cellBounds.width;
/*     */   }
/*     */   
/*     */   public int getCellHeight() {
/* 243 */     return this.cellBounds.height;
/*     */   }
/*     */   
/*     */   public int getMaxWidth() {
/* 247 */     Rectangle panelBounds = getBounds();
/* 248 */     return panelBounds.width - 5;
/*     */   }
/*     */   
/*     */   public int getMaxHeight() {
/* 252 */     Rectangle panelBounds = getBounds();
/* 253 */     return panelBounds.height - 5;
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/cell/CellDraw.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */