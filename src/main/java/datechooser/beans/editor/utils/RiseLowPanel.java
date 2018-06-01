/*    */ package datechooser.beans.editor.utils;
/*    */ 
/*    */ import datechooser.beans.locale.LocaleUtils;
/*    */ import java.awt.FlowLayout;
/*    */ import java.awt.event.ActionListener;
/*    */ import javax.swing.ButtonGroup;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JRadioButton;
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
/*    */ public class RiseLowPanel
/*    */   extends JPanel
/*    */ {
/*    */   private int raisedValue;
/*    */   private int loweredValue;
/*    */   JRadioButton bRaised;
/*    */   JRadioButton bLowered;
/*    */   
/*    */   public RiseLowPanel(int value, int raisedValue, int loweredValue)
/*    */   {
/* 31 */     setRaisedValue(raisedValue);
/* 32 */     setLoweredValue(loweredValue);
/*    */     
/* 34 */     ButtonGroup bType = new ButtonGroup();
/* 35 */     this.bRaised = new JRadioButton(LocaleUtils.getEditorLocaleString("Raised"));
/* 36 */     this.bLowered = new JRadioButton(LocaleUtils.getEditorLocaleString("Lowered"));
/* 37 */     bType.add(this.bRaised);
/* 38 */     bType.add(this.bLowered);
/* 39 */     setLayout(new FlowLayout(1));
/* 40 */     add(this.bRaised);
/* 41 */     add(this.bLowered);
/* 42 */     setType(value);
/*    */   }
/*    */   
/*    */   public void addActionListener(ActionListener listener) {
/* 46 */     this.bRaised.addActionListener(listener);
/* 47 */     this.bLowered.addActionListener(listener);
/*    */   }
/*    */   
/*    */   public void removeActionListener(ActionListener listener) {
/* 51 */     this.bRaised.removeActionListener(listener);
/* 52 */     this.bLowered.removeActionListener(listener);
/*    */   }
/*    */   
/*    */   public int getType() {
/* 56 */     if (this.bRaised.isSelected()) {
/* 57 */       return getRaisedValue();
/*    */     }
/* 59 */     return getLoweredValue();
/*    */   }
/*    */   
/*    */   public void setType(int type)
/*    */   {
/* 64 */     this.bRaised.setSelected(type == getRaisedValue());
/* 65 */     this.bLowered.setSelected(type == getLoweredValue());
/*    */   }
/*    */   
/*    */   public int getRaisedValue() {
/* 69 */     return this.raisedValue;
/*    */   }
/*    */   
/*    */   public void setRaisedValue(int raisedValue) {
/* 73 */     this.raisedValue = raisedValue;
/*    */   }
/*    */   
/*    */   public int getLoweredValue() {
/* 77 */     return this.loweredValue;
/*    */   }
/*    */   
/*    */   public void setLoweredValue(int loweredValue) {
/* 81 */     this.loweredValue = loweredValue;
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/utils/RiseLowPanel.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */