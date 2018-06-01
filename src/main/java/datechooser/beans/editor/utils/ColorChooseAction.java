/*    */ package datechooser.beans.editor.utils;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Component;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import java.beans.PropertyChangeListener;
/*    */ import java.beans.PropertyChangeSupport;
/*    */ import javax.swing.JColorChooser;
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
/*    */ 
/*    */ 
/*    */ public class ColorChooseAction
/*    */   implements ActionListener
/*    */ {
/* 27 */   private static JColorChooser chooseColor = new JColorChooser();
/*    */   
/*    */   public static final String COLOR_CHOOSE_EVENT_NAME = "color";
/*    */   
/*    */   private ColorHolder colorHolder;
/*    */   private String prompt;
/*    */   private Component component;
/*    */   private PropertyChangeSupport changeSupport;
/*    */   
/*    */   public ColorChooseAction(ColorHolder colorHolder, String prompt, Component c)
/*    */   {
/* 38 */     this.changeSupport = new PropertyChangeSupport(this);
/* 39 */     setColorHolder(colorHolder);
/* 40 */     setPrompt(prompt);
/* 41 */     setComponent(c);
/*    */   }
/*    */   
/*    */   public void actionPerformed(ActionEvent e) {
/* 45 */     Color newColor = JColorChooser.showDialog(getComponent(), getPrompt(), getColor());
/*    */     
/* 47 */     if (newColor != null) {
/* 48 */       setColor(newColor);
/* 49 */       this.changeSupport.firePropertyChange("color", null, null);
/*    */     }
/*    */   }
/*    */   
/*    */   public void addPropertyChangeListener(PropertyChangeListener listener) {
/* 54 */     this.changeSupport.addPropertyChangeListener(listener);
/*    */   }
/*    */   
/*    */   public void removePropertyChangeListener(PropertyChangeListener listener) {
/* 58 */     this.changeSupport.removePropertyChangeListener(listener);
/*    */   }
/*    */   
/*    */   public Color getColor() {
/* 62 */     return this.colorHolder.getColor();
/*    */   }
/*    */   
/*    */   public ColorHolder getColorHolder() {
/* 66 */     return this.colorHolder;
/*    */   }
/*    */   
/*    */   public void setColorHolder(ColorHolder colorHolder) {
/* 70 */     this.colorHolder = colorHolder;
/*    */   }
/*    */   
/*    */   public void setColor(Color color) {
/* 74 */     this.colorHolder.setColor(color);
/*    */   }
/*    */   
/*    */   public String getPrompt() {
/* 78 */     return this.prompt;
/*    */   }
/*    */   
/*    */   public void setPrompt(String prompt) {
/* 82 */     this.prompt = prompt;
/*    */   }
/*    */   
/*    */   public Component getComponent() {
/* 86 */     return this.component;
/*    */   }
/*    */   
/*    */   public void setComponent(Component component) {
/* 90 */     this.component = component;
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/utils/ColorChooseAction.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */