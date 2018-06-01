/*    */ package datechooser.beans.editor.border.types;
/*    */ 
/*    */ import datechooser.beans.editor.utils.ColorChooseAction;
/*    */ import datechooser.beans.editor.utils.ColorHolder;
/*    */ import datechooser.beans.editor.utils.InsetsPanel;
/*    */ import datechooser.beans.locale.LocaleUtils;
/*    */ import java.awt.Color;
/*    */ import java.awt.GridLayout;
/*    */ import java.awt.Insets;
/*    */ import java.beans.PropertyChangeEvent;
/*    */ import java.beans.PropertyChangeListener;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.border.Border;
/*    */ import javax.swing.border.MatteBorder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MatteBorderEditor
/*    */   extends AbstractBorderEditor
/*    */ {
/*    */   private Insets insets;
/*    */   private ColorHolder color;
/*    */   private InsetsPanel insetsPane;
/*    */   
/*    */   public MatteBorderEditor()
/*    */   {
/* 32 */     this.color = new ColorHolder();
/* 33 */     setCaption(LocaleUtils.getEditorLocaleString("Matte"));
/*    */     
/* 35 */     initialize();
/*    */     
/* 37 */     this.insetsPane = new InsetsPanel(this.insets);
/* 38 */     this.insetsPane.addPropertyChangeListener(new InsetsListener(null));
/*    */     
/* 40 */     JButton bColor = new JButton(LocaleUtils.getEditorLocaleString("Matte_color"));
/* 41 */     ColorChooseAction colorChooseAction = new ColorChooseAction(this.color, LocaleUtils.getEditorLocaleString("Matte_color"), this);
/*    */     
/* 43 */     colorChooseAction.addPropertyChangeListener(new ColorListener(null));
/* 44 */     bColor.addActionListener(colorChooseAction);
/*    */     
/* 46 */     setLayout(new GridLayout(2, 1));
/* 47 */     add(getCenteredPane(this.insetsPane));
/* 48 */     add(getCenteredPane(bColor));
/*    */     
/* 50 */     refreshInterface();
/*    */   }
/*    */   
/*    */   protected void prepareSelection() {
/* 54 */     setValue(new MatteBorder(this.insets, this.color.getColor()));
/*    */   }
/*    */   
/*    */   private void assignValueToParameters() {
/* 58 */     Insets currIns = getValue().getBorderInsets();
/* 59 */     this.insets.set(currIns.top, currIns.left, currIns.bottom, currIns.right);
/* 60 */     this.color.setColor(getValue().getMatteColor());
/*    */   }
/*    */   
/*    */   protected MatteBorder getValue() {
/* 64 */     return (MatteBorder)this.value;
/*    */   }
/*    */   
/*    */   public void refreshInterface() {
/* 68 */     assignValueToParameters();
/* 69 */     this.insetsPane.refresh();
/*    */   }
/*    */   
/*    */   protected Border getDefaultValue() {
/* 73 */     this.insets = new Insets(1, 1, 1, 1);
/* 74 */     return new MatteBorder(this.insets, Color.GRAY);
/*    */   }
/*    */   
/*    */   private class InsetsListener implements PropertyChangeListener { private InsetsListener() {}
/*    */     
/* 79 */     public void propertyChange(PropertyChangeEvent evt) { if (!"insets".equals(evt.getPropertyName())) return;
/* 80 */       MatteBorderEditor.this.fireChange();
/*    */     }
/*    */   }
/*    */   
/*    */   private class ColorListener implements PropertyChangeListener { private ColorListener() {}
/*    */     
/* 86 */     public void propertyChange(PropertyChangeEvent evt) { if (!"color".equals(evt.getPropertyName())) return;
/* 87 */       MatteBorderEditor.this.fireChange();
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/border/types/MatteBorderEditor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */