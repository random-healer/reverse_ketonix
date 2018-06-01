/*     */ package datechooser.beans.editor.cell;
/*     */ 
/*     */ import datechooser.beans.editor.font.SimpleFontEditor;
/*     */ import datechooser.beans.editor.utils.EditorDialog;
/*     */ import datechooser.beans.locale.LocaleUtils;
/*     */ import datechooser.view.appearance.CellAppearance;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.Frame;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JColorChooser;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class CellEditorPane
/*     */   extends JPanel
/*     */ {
/*     */   private EditorDialog fontEditorDialog;
/*     */   protected MainCellEditorPane mainEditor;
/*     */   private JButton selCursorColorCash;
/*     */   
/*     */   public CellEditorPane(MainCellEditorPane parentEditor)
/*     */   {
/*  32 */     setMainEditor(parentEditor);
/*  33 */     this.fontEditorDialog = new EditorDialog((Frame)getParent(), new SimpleFontEditor());
/*     */     
/*  35 */     generateInterface();
/*     */   }
/*     */   
/*     */   protected MainCellEditorPane getMainEditor() {
/*  39 */     return this.mainEditor;
/*     */   }
/*     */   
/*     */   protected CellAppearance getValue() {
/*  43 */     return getMainEditor().getValue();
/*     */   }
/*     */   
/*     */   protected Color selectColor(Color oldColor, String prompt) {
/*  47 */     Color newColor = JColorChooser.showDialog(this, prompt, oldColor);
/*  48 */     return newColor != null ? newColor : oldColor;
/*     */   }
/*     */   
/*     */   protected void setMainEditor(MainCellEditorPane mainEditor) {
/*  52 */     this.mainEditor = mainEditor;
/*     */   }
/*     */   
/*     */   protected JButton createFontChooseButton() {
/*  56 */     JButton bFont = new JButton(LocaleUtils.getEditorLocaleString("Font"));
/*  57 */     bFont.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/*  59 */         Font newFont = (Font)CellEditorPane.this.fontEditorDialog.showDialog(CellEditorPane.this.getValue().getFont(), LocaleUtils.getEditorLocaleString("Select_font"));
/*     */         
/*  61 */         if (!CellEditorPane.this.fontEditorDialog.isCanceled()) {
/*  62 */           CellEditorPane.this.getValue().setFont(newFont);
/*  63 */           CellEditorPane.this.getMainEditor().fireLocalPropertyChange();
/*     */         }
/*     */       }
/*  66 */     });
/*  67 */     return bFont;
/*     */   }
/*     */   
/*     */   protected JButton createCursorColorChooseButton() {
/*  71 */     JButton selCursorColor = new JButton(LocaleUtils.getEditorLocaleString("Cursor_color"));
/*     */     
/*  73 */     selCursorColor.setEnabled(getValue().isSelectable());
/*  74 */     selCursorColor.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/*  76 */         CellEditorPane.this.getValue().setCursorColor(CellEditorPane.this.selectColor(CellEditorPane.this.getValue().getCursorColor(), LocaleUtils.getEditorLocaleString("Select_cursor_color")));
/*     */         
/*     */ 
/*  79 */         CellEditorPane.this.getMainEditor().fireLocalPropertyChange();
/*     */       }
/*  81 */     });
/*  82 */     this.selCursorColorCash = selCursorColor;
/*  83 */     return selCursorColor;
/*     */   }
/*     */   
/*     */   protected JButton createTextColorChooseButton() {
/*  87 */     JButton selTextColor = new JButton(LocaleUtils.getEditorLocaleString("Text_color"));
/*  88 */     selTextColor.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/*  90 */         CellEditorPane.this.getValue().setTextColor(CellEditorPane.this.selectColor(CellEditorPane.this.getValue().getTextColor(), LocaleUtils.getEditorLocaleString("Select_text_color")));
/*     */         
/*     */ 
/*  93 */         CellEditorPane.this.getMainEditor().fireLocalPropertyChange();
/*     */       }
/*  95 */     });
/*  96 */     return selTextColor;
/*     */   }
/*     */   
/*     */   public EditorDialog getFontEditorDialog() {
/* 100 */     return this.fontEditorDialog;
/*     */   }
/*     */   
/*     */   void updateState() {
/* 104 */     this.selCursorColorCash.setEnabled(getValue().isSelectable());
/* 105 */     updateEditorState();
/*     */   }
/*     */   
/*     */   protected abstract void generateInterface();
/*     */   
/*     */   protected abstract void updateEditorState();
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/cell/CellEditorPane.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */