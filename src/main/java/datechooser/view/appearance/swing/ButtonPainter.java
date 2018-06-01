/*    */ package datechooser.view.appearance.swing;
/*    */ 
/*    */ import datechooser.view.appearance.CellAppearance;
/*    */ import java.awt.Color;
/*    */ import java.awt.Component;
/*    */ import java.awt.Font;
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.Insets;
/*    */ import javax.swing.ButtonModel;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.border.Border;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ButtonPainter
/*    */   implements Painter, SwingCellAttributes
/*    */ {
/*    */   private JButton button;
/*    */   private ButtonModel model;
/*    */   
/*    */   public ButtonPainter()
/*    */   {
/* 28 */     setButton(new JButton("?"));
/* 29 */     this.model = this.button.getModel();
/* 30 */     this.button.setMargin(new Insets(2, 2, 2, 2));
/* 31 */     this.button.setOpaque(true);
/*    */   }
/*    */   
/*    */   public JButton getButton() {
/* 35 */     return this.button;
/*    */   }
/*    */   
/*    */   public void setButton(JButton button) {
/* 39 */     this.button = button;
/*    */   }
/*    */   
/*    */   public void setText(String text) {
/* 43 */     this.button.setText(text);
/*    */   }
/*    */   
/*    */   public void setFont(Font font) {
/* 47 */     this.button.setFont(font);
/*    */   }
/*    */   
/*    */   public Font getFont() {
/* 51 */     return this.button.getFont();
/*    */   }
/*    */   
/*    */   public void setTextColor(Color color) {
/* 55 */     this.button.setForeground(color);
/*    */   }
/*    */   
/*    */   public void updateUI() {
/* 59 */     this.button.updateUI();
/*    */   }
/*    */   
/*    */   public void setSize(int width, int height) {
/* 63 */     this.button.setSize(width, height);
/*    */   }
/*    */   
/*    */   public void paint(Graphics2D g) {
/* 67 */     this.button.paint(g);
/*    */   }
/*    */   
/*    */   public Border getBorder() {
/* 71 */     return this.button.getBorder();
/*    */   }
/*    */   
/*    */   public void setPressed(boolean pressed) {
/* 75 */     this.model.setPressed(pressed);
/* 76 */     this.model.setArmed(pressed);
/*    */   }
/*    */   
/*    */   public void setEnabled(boolean enabled) {
/* 80 */     this.model.setEnabled(enabled);
/*    */   }
/*    */   
/*    */   public Color getTextColor() {
/* 84 */     return this.button.getForeground();
/*    */   }
/*    */   
/*    */   public Object clone() {
/* 88 */     return new ButtonPainter();
/*    */   }
/*    */   
/*    */   public void assign(CellAppearance newAppearance) {}
/*    */   
/*    */   public Component getComponent(Component c)
/*    */   {
/* 95 */     return this.button;
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/view/appearance/swing/ButtonPainter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */