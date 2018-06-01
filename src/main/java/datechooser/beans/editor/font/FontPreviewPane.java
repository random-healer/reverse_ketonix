/*    */ package datechooser.beans.editor.font;
/*    */ 
/*    */ import datechooser.beans.editor.utils.TextOutput;
/*    */ import datechooser.beans.locale.LocaleUtils;
/*    */ import java.awt.Font;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Rectangle;
/*    */ import javax.swing.BorderFactory;
/*    */ import javax.swing.JPanel;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class FontPreviewPane
/*    */   extends JPanel
/*    */ {
/*    */   private String sampleText;
/*    */   private Font font;
/*    */   private Rectangle bounds;
/*    */   
/*    */   public FontPreviewPane(Font font)
/*    */   {
/* 28 */     setFont(font);
/* 29 */     setBorder(BorderFactory.createEtchedBorder());
/* 30 */     setSampleText(LocaleUtils.getEditorLocaleString("sample_text"));
/*    */   }
/*    */   
/*    */   public String getSampleText() {
/* 34 */     return this.sampleText;
/*    */   }
/*    */   
/*    */   public void setSampleText(String sampleText) {
/* 38 */     this.sampleText = sampleText;
/*    */   }
/*    */   
/*    */   public Font getFont() {
/* 42 */     return this.font;
/*    */   }
/*    */   
/*    */   public void setFont(Font font)
/*    */   {
/* 47 */     this.font = font;
/* 48 */     repaint();
/*    */   }
/*    */   
/*    */   protected void paintComponent(Graphics g) {
/* 52 */     super.paintComponent(g);
/* 53 */     this.bounds = getBounds();
/* 54 */     TextOutput.paintBoxed(g, this.bounds, getSampleText(), getFont());
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/font/FontPreviewPane.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */