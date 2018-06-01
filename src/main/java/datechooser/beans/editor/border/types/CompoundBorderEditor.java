/*    */ package datechooser.beans.editor.border.types;
/*    */ 
/*    */ import datechooser.beans.editor.border.SimpleBorderEditor;
/*    */ import datechooser.beans.editor.utils.EditorDialog;
/*    */ import datechooser.beans.locale.LocaleUtils;
/*    */ import java.awt.BorderLayout;
/*    */ import java.awt.Frame;
/*    */ import java.awt.GridLayout;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import javax.swing.BorderFactory;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.border.Border;
/*    */ import javax.swing.border.CompoundBorder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CompoundBorderEditor
/*    */   extends AbstractBorderEditor
/*    */ {
/*    */   private Border inside;
/*    */   private Border outside;
/*    */   private EditorDialog editorDialog;
/*    */   
/*    */   public CompoundBorderEditor()
/*    */   {
/* 32 */     initialize();
/* 33 */     setCaption(LocaleUtils.getEditorLocaleString("Compound"));
/* 34 */     this.editorDialog = new EditorDialog((Frame)getParent(), new SimpleBorderEditor());
/* 35 */     JPanel buttons = new JPanel(new GridLayout(2, 1, 5, 2));
/* 36 */     buttons.add(createOutsideChooseButton());
/* 37 */     buttons.add(createInsideChooseButton());
/* 38 */     setLayout(new BorderLayout());
/* 39 */     add(buttons, "North");
/* 40 */     refreshInterface();
/*    */   }
/*    */   
/*    */   private JPanel createInsideChooseButton() {
/* 44 */     JButton bBorder = new JButton(LocaleUtils.getEditorLocaleString("Inside_border"));
/* 45 */     bBorder.addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/* 47 */         Border newBorder = (Border)CompoundBorderEditor.this.editorDialog.showDialog(CompoundBorderEditor.this.inside, LocaleUtils.getEditorLocaleString("Select_border"));
/*    */         
/* 49 */         if (!CompoundBorderEditor.this.editorDialog.isCanceled()) {
/* 50 */           CompoundBorderEditor.this.inside = newBorder;
/* 51 */           CompoundBorderEditor.this.fireChange();
/*    */         }
/*    */       }
/* 54 */     });
/* 55 */     return getCenteredPane(bBorder);
/*    */   }
/*    */   
/*    */   private JPanel createOutsideChooseButton() {
/* 59 */     JButton bBorder = new JButton(LocaleUtils.getEditorLocaleString("Outside_border"));
/* 60 */     bBorder.addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/* 62 */         Border newBorder = (Border)CompoundBorderEditor.this.editorDialog.showDialog(CompoundBorderEditor.this.outside, LocaleUtils.getEditorLocaleString("Select_border"));
/*    */         
/* 64 */         if (!CompoundBorderEditor.this.editorDialog.isCanceled()) {
/* 65 */           CompoundBorderEditor.this.outside = newBorder;
/* 66 */           CompoundBorderEditor.this.fireChange();
/*    */         }
/*    */       }
/* 69 */     });
/* 70 */     return getCenteredPane(bBorder);
/*    */   }
/*    */   
/*    */   public void prepareSelection() {
/* 74 */     this.value = new CompoundBorder(this.outside, this.inside);
/*    */   }
/*    */   
/*    */   public void refreshInterface() {
/* 78 */     CompoundBorder compoundBorder = (CompoundBorder)getCurrentBorder();
/* 79 */     if (compoundBorder != null) {
/* 80 */       this.inside = compoundBorder.getInsideBorder();
/* 81 */       this.outside = compoundBorder.getOutsideBorder();
/*    */     }
/*    */   }
/*    */   
/*    */   protected Border getDefaultValue() {
/* 86 */     return BorderFactory.createCompoundBorder();
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/border/types/CompoundBorderEditor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */