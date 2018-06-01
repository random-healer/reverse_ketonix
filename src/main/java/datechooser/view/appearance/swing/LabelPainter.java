/*    */ package datechooser.view.appearance.swing;
/*    */ 
/*    */ import datechooser.view.appearance.CellAppearance;
/*    */ import java.awt.Color;
/*    */ import java.awt.Component;
/*    */ import java.awt.Font;
/*    */ import java.awt.Graphics2D;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.border.Border;
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
/*    */ public class LabelPainter
/*    */   implements Painter, SwingCellAttributes
/*    */ {
/*    */   private JLabel label;
/*    */   
/*    */   public LabelPainter()
/*    */   {
/* 28 */     setLabel(new JLabel("?"));
/* 29 */     getLabel().setHorizontalAlignment(0);
/* 30 */     getLabel().setOpaque(true);
/*    */   }
/*    */   
/*    */   public void setText(String text) {
/* 34 */     this.label.setText(text);
/*    */   }
/*    */   
/*    */   public void setFont(Font font) {
/* 38 */     this.label.setFont(font);
/*    */   }
/*    */   
/*    */   public Font getFont() {
/* 42 */     return this.label.getFont();
/*    */   }
/*    */   
/*    */   public void setTextColor(Color color) {
/* 46 */     this.label.setForeground(color);
/*    */   }
/*    */   
/*    */   public void updateUI() {
/* 50 */     this.label.updateUI();
/*    */   }
/*    */   
/*    */   public void setSize(int width, int height) {
/* 54 */     this.label.setSize(width, height);
/*    */   }
/*    */   
/*    */   public void paint(Graphics2D g) {
/* 58 */     this.label.paint(g);
/*    */   }
/*    */   
/*    */   public Border getBorder() {
/* 62 */     return this.label.getBorder();
/*    */   }
/*    */   
/*    */ 
/*    */   public void setPressed(boolean pressed) {}
/*    */   
/*    */   public void setEnabled(boolean enabled) {}
/*    */   
/*    */   public JLabel getLabel()
/*    */   {
/* 72 */     return this.label;
/*    */   }
/*    */   
/*    */   public void setLabel(JLabel label) {
/* 76 */     this.label = label;
/*    */   }
/*    */   
/*    */   public Color getTextColor() {
/* 80 */     return this.label.getForeground();
/*    */   }
/*    */   
/*    */   public Object clone() {
/* 84 */     return new LabelPainter();
/*    */   }
/*    */   
/*    */ 
/*    */   public void assign(CellAppearance newAppearance) {}
/*    */   
/*    */   public Component getComponent(Component c)
/*    */   {
/* 92 */     return this.label;
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/view/appearance/swing/LabelPainter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */