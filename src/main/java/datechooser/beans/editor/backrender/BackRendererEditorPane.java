/*     */ package datechooser.beans.editor.backrender;
/*     */ 
/*     */ import datechooser.beans.locale.LocaleUtils;
/*     */ import datechooser.view.BackRenderer;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.FlowLayout;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.GridLayout;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.beans.PropertyChangeEvent;
/*     */ import java.beans.PropertyChangeListener;
/*     */ import java.beans.PropertyEditorSupport;
/*     */ import java.io.File;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JFileChooser;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ 
/*     */ public class BackRendererEditorPane
/*     */   extends JPanel
/*     */   implements PropertyChangeListener
/*     */ {
/*  30 */   private PropertyEditorSupport editor = null;
/*     */   private JComboBox selStyle;
/*     */   private Preview previewPane;
/*     */   private JFileChooser fileChoose;
/*     */   
/*     */   public BackRendererEditorPane(PropertyEditorSupport editor) {
/*  36 */     this.fileChoose = new JFileChooser();
/*  37 */     setEditor(editor);
/*  38 */     generateInterface();
/*  39 */     updateInterface();
/*     */   }
/*     */   
/*     */   public void setEditor(PropertyEditorSupport editor) {
/*  43 */     if (this.editor != null) {
/*  44 */       this.editor.removePropertyChangeListener(this);
/*     */     }
/*  46 */     this.editor = editor;
/*  47 */     editor.addPropertyChangeListener(this);
/*     */   }
/*     */   
/*     */   private void updateInterface() {
/*  51 */     BackRenderer renderer = getEditorValue();
/*  52 */     if (renderer == null) return;
/*  53 */     this.selStyle.setSelectedIndex(renderer.getStyle());
/*  54 */     this.previewPane.repaint();
/*     */   }
/*     */   
/*     */   private void generateInterface() {
/*  58 */     this.selStyle = createStyleChooser();
/*  59 */     this.previewPane = new Preview(null);
/*  60 */     JButton bFile = createFileButton();
/*     */     
/*  62 */     this.previewPane.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5), BorderFactory.createEtchedBorder()));
/*     */     
/*     */ 
/*  65 */     setLayout(new BorderLayout());
/*  66 */     JPanel controlPane = new JPanel(new GridLayout(1, 2, 2, 2));
/*  67 */     JPanel selStylePane = new JPanel(new FlowLayout(1));
/*  68 */     JPanel buttonPane = new JPanel(new FlowLayout(1));
/*  69 */     buttonPane.add(bFile);
/*  70 */     selStylePane.add(this.selStyle);
/*  71 */     controlPane.add(selStylePane);
/*  72 */     controlPane.add(buttonPane);
/*  73 */     add(controlPane, "North");
/*  74 */     add(this.previewPane, "Center");
/*  75 */     revalidate();
/*     */   }
/*     */   
/*     */   private JComboBox createStyleChooser() {
/*  79 */     JComboBox combo = new JComboBox(new String[] { LocaleUtils.getEditorLocaleString("BackImageCenter"), LocaleUtils.getEditorLocaleString("BackImageFill"), LocaleUtils.getEditorLocaleString("BackImageTile") });
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  85 */     combo.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/*  87 */         BackRendererEditorPane.this.setStyle(BackRendererEditorPane.this.selStyle.getSelectedIndex());
/*     */       }
/*     */       
/*  90 */     });
/*  91 */     return combo;
/*     */   }
/*     */   
/*     */   private JButton createFileButton() {
/*  95 */     JButton button = new JButton(LocaleUtils.getEditorLocaleString("Load"));
/*  96 */     button.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/*  98 */         int result = BackRendererEditorPane.this.fileChoose.showOpenDialog(null);
/*  99 */         if (result != 0) return;
/*     */         try {
/* 101 */           BackRendererEditorPane.this.setURL(BackRendererEditorPane.this.fileChoose.getSelectedFile().toURL());
/*     */         } catch (MalformedURLException ex) {
/* 103 */           ex.printStackTrace();
/*     */         }
/*     */       }
/* 106 */     });
/* 107 */     return button;
/*     */   }
/*     */   
/*     */   private void setStyle(int style) {
/* 111 */     BackRenderer value = getEditorValue();
/* 112 */     if ((value == null) || (style == value.getStyle())) return;
/* 113 */     this.editor.setValue(new BackRenderer(style, value != null ? value.getUrl() : null, getEditorValue().getImage()));
/*     */   }
/*     */   
/*     */ 
/*     */   private void setURL(URL url)
/*     */   {
/* 119 */     BackRenderer value = getEditorValue();
/* 120 */     if ((value != null) && (url.equals(value.getUrl()))) return;
/* 121 */     this.editor.setValue(new BackRenderer(this.selStyle.getSelectedIndex(), url));
/*     */   }
/*     */   
/*     */   public void propertyChange(PropertyChangeEvent evt) {
/* 125 */     updateInterface();
/*     */   }
/*     */   
/*     */ 
/* 129 */   private BackRenderer getEditorValue() { return (BackRenderer)this.editor.getValue(); }
/*     */   
/*     */   private class Preview extends JPanel {
/*     */     private Preview() {}
/*     */     
/* 134 */     protected void paintComponent(Graphics g) { super.paintComponent(g);
/* 135 */       BackRenderer renderer = BackRendererEditorPane.this.getEditorValue();
/* 136 */       if (renderer == null) return;
/* 137 */       renderer.render((Graphics2D)g, getBounds());
/*     */     }
/*     */     
/*     */     public Dimension getPreferredSize() {
/* 141 */       return new Dimension(200, 200);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/backrender/BackRendererEditorPane.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */