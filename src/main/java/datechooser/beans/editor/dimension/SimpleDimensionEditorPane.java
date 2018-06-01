/*    */ package datechooser.beans.editor.dimension;
/*    */ 
/*    */ import datechooser.beans.locale.LocaleUtils;
/*    */ import java.awt.BorderLayout;
/*    */ import java.awt.Color;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.FlowLayout;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.GridLayout;
/*    */ import java.awt.Point;
/*    */ import java.awt.Rectangle;
/*    */ import java.beans.PropertyEditorSupport;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JSpinner;
/*    */ import javax.swing.SpinnerNumberModel;
/*    */ import javax.swing.event.ChangeEvent;
/*    */ import javax.swing.event.ChangeListener;
/*    */ 
/*    */ 
/*    */ 
/*    */ class SimpleDimensionEditorPane
/*    */   extends JPanel
/*    */ {
/*    */   private PropertyEditorSupport editor;
/*    */   private Preview preview;
/*    */   private JPanel controls;
/*    */   
/*    */   public SimpleDimensionEditorPane(PropertyEditorSupport editor)
/*    */   {
/* 31 */     this.editor = editor;
/*    */     
/* 33 */     final Dimension dim = getValue();
/* 34 */     final SpinnerNumberModel width = new SpinnerNumberModel(dim.width, 10, 20000, 1);
/* 35 */     final SpinnerNumberModel height = new SpinnerNumberModel(dim.height, 10, 20000, 1);
/*    */     
/* 37 */     this.controls = new JPanel(new GridLayout(1, 2));
/* 38 */     JPanel widthPane = new JPanel(new FlowLayout(1));
/* 39 */     JPanel heightPane = new JPanel(new FlowLayout(1));
/* 40 */     widthPane.add(new JLabel(LocaleUtils.getEditorLocaleString("Width")));
/* 41 */     widthPane.add(new JSpinner(width));
/* 42 */     heightPane.add(new JLabel(LocaleUtils.getEditorLocaleString("Height")));
/* 43 */     heightPane.add(new JSpinner(height));
/* 44 */     this.controls.add(widthPane);
/* 45 */     this.controls.add(heightPane);
/* 46 */     this.controls.revalidate();
/*    */     
/* 48 */     this.preview = new Preview(null);
/*    */     
/* 50 */     setLayout(new BorderLayout());
/* 51 */     add(this.preview, "Center");
/* 52 */     add(this.controls, "South");
/* 53 */     revalidate();
/* 54 */     ChangeListener onChange = new ChangeListener() {
/*    */       public void stateChanged(ChangeEvent e) {
/* 56 */         dim.setSize(width.getNumber().intValue(), height.getNumber().intValue());
/*    */         
/* 58 */         SimpleDimensionEditorPane.this.setValue(dim);
/* 59 */         SimpleDimensionEditorPane.this.repaint();
/*    */       }
/*    */       
/* 62 */     };
/* 63 */     width.addChangeListener(onChange);
/* 64 */     height.addChangeListener(onChange);
/*    */   }
/*    */   
/*    */   private Dimension getValue() {
/* 68 */     return (Dimension)this.editor.getValue();
/*    */   }
/*    */   
/*    */ 
/* 72 */   private void setValue(Dimension value) { this.editor.setValue(value); }
/*    */   
/*    */   private class Preview extends JPanel {
/*    */     private Preview() {}
/*    */     
/* 77 */     private Point startRec = new Point();
/*    */     
/*    */     protected void paintComponent(Graphics g) {
/* 80 */       Rectangle rec = getBounds();
/* 81 */       Dimension dim = SimpleDimensionEditorPane.this.getValue();
/* 82 */       if (dim.width < rec.width) {
/* 83 */         this.startRec.x = ((rec.width - dim.width) / 2);
/*    */       } else {
/* 85 */         this.startRec.x = 0;
/*    */       }
/* 87 */       if (dim.height < rec.height) {
/* 88 */         this.startRec.y = ((rec.height - dim.height) / 2);
/*    */       } else {
/* 90 */         this.startRec.y = 0;
/*    */       }
/* 92 */       g.setColor(Color.BLUE);
/* 93 */       g.fillRect(this.startRec.x, this.startRec.y, dim.width, dim.height);
/*    */     }
/*    */     
/*    */     public Dimension getPreferredSize() {
/* 97 */       return new Dimension(100, 200);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/dimension/SimpleDimensionEditorPane.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */