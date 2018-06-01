/*     */ package datechooser.beans.editor.appear;
/*     */ 
/*     */ import datechooser.beans.editor.backrender.BackRendererEditor;
/*     */ import datechooser.beans.editor.cell.CellViewEditor;
/*     */ import datechooser.beans.editor.utils.EditorDialog;
/*     */ import datechooser.beans.locale.LocaleUtils;
/*     */ import datechooser.controller.EventHandler;
/*     */ import datechooser.events.CursorMoveEvent;
/*     */ import datechooser.events.CursorMoveListener;
/*     */ import datechooser.model.FooModel;
/*     */ import datechooser.view.BackRenderer;
/*     */ import datechooser.view.GridPane;
/*     */ import datechooser.view.appearance.AppearancesList;
/*     */ import datechooser.view.appearance.CellAppearance;
/*     */ import datechooser.view.appearance.ViewAppearance;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Frame;
/*     */ import java.awt.GridLayout;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.beans.PropertyChangeEvent;
/*     */ import java.beans.PropertyChangeListener;
/*     */ import java.text.MessageFormat;
/*     */ import javax.swing.AbstractListModel;
/*     */ import javax.swing.ComboBoxModel;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AppearEditorPane
/*     */   extends JPanel
/*     */   implements PropertyChangeListener, CursorMoveListener
/*     */ {
/*  41 */   private String[] cellTypes = { LocaleUtils.getEditorLocaleString("disabled"), LocaleUtils.getEditorLocaleString("usual"), LocaleUtils.getEditorLocaleString("selected"), LocaleUtils.getEditorLocaleString("now"), LocaleUtils.getEditorLocaleString("scroll"), LocaleUtils.getEditorLocaleString("caption") };
/*     */   
/*     */   private AppearEditor editor;
/*     */   
/*     */   private FooModel model;
/*     */   
/*     */   private JComboBox cellViews;
/*     */   
/*     */   private boolean autoEdit;
/*     */   private EditorDialog eDialog;
/*     */   private EditorDialog bDialog;
/*     */   private GridPane gp;
/*     */   private boolean tempEdit;
/*     */   private JComboBox views;
/*     */   private JButton bEditCellView;
/*     */   private JButton bDeleteCellView;
/*     */   private JButton bSetBackPicture;
/*     */   
/*     */   public AppearEditorPane(AppearEditor editor)
/*     */   {
/*  61 */     LocaleUtils.prepareStandartDialogButtonText();
/*  62 */     setEditor(editor);
/*  63 */     setAutoEdit(false);
/*     */     
/*  65 */     this.model = new FooModel();
/*  66 */     this.model.addCursorMoveListener(this);
/*     */     
/*  68 */     this.cellViews = createCellTypeCombo();
/*  69 */     this.gp = createGridPane();
/*     */     
/*  71 */     this.eDialog = new EditorDialog((Frame)getParent(), new CellViewEditor());
/*  72 */     this.bDialog = new EditorDialog((Frame)getParent(), new BackRendererEditor());
/*     */     
/*  74 */     JPanel control = new JPanel(new GridLayout(2, 4, 5, 5));
/*     */     
/*  76 */     this.bSetBackPicture = createBackRendererButton();
/*     */     
/*  78 */     createCellEditorButton();
/*  79 */     createDeleteViewButton();
/*     */     
/*  81 */     control.add(new JLabel(LocaleUtils.getEditorLocaleString("View"), 4));
/*  82 */     control.add(createViewManagerCombo());
/*  83 */     control.add(createNewViewButton());
/*  84 */     control.add(this.bDeleteCellView);
/*     */     
/*     */ 
/*  87 */     control.add(new JLabel(LocaleUtils.getEditorLocaleString("Cell"), 4));
/*  88 */     control.add(this.cellViews);
/*  89 */     control.add(this.bEditCellView);
/*  90 */     control.add(this.bSetBackPicture);
/*     */     
/*  92 */     setLayout(new BorderLayout());
/*  93 */     add(control, "North");
/*  94 */     add(this.gp, "Center");
/*     */   }
/*     */   
/*     */   private JPanel getEditorPane()
/*     */   {
/*  99 */     return this;
/*     */   }
/*     */   
/*     */   private JButton createDeleteViewButton() {
/* 103 */     this.bDeleteCellView = new JButton(LocaleUtils.getEditorLocaleString("Delete"));
/* 104 */     this.bDeleteCellView.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 106 */         String selViewName = AppearEditorPane.this.getAppList().getCurrent().getName();
/* 107 */         int ans = JOptionPane.showConfirmDialog(AppearEditorPane.this.getEditorPane().getParent(), MessageFormat.format(LocaleUtils.getEditorLocaleString("Delete_view_prompt"), new Object[] { selViewName }), LocaleUtils.getEditorLocaleString("Confirm_delete"), 0);
/*     */         
/*     */ 
/*     */ 
/* 111 */         if (ans == 0) {
/* 112 */           if (AppearEditorPane.this.getAppList().unRegisterAppearance(selViewName)) {
/* 113 */             AppearEditorPane.this.getAppList().setCurrent(AppearancesList.DEFAULT);
/* 114 */             AppearEditorPane.this.updateEditable();
/* 115 */             AppearEditorPane.this.refreshViews();
/* 116 */             AppearEditorPane.this.fireLocalPropertyChange();
/*     */           } else {
/* 118 */             JOptionPane.showMessageDialog(AppearEditorPane.this.getEditorPane().getParent(), MessageFormat.format(LocaleUtils.getEditorLocaleString("Cant_delete_view"), new Object[] { selViewName }), LocaleUtils.getEditorLocaleString("Undelitable_view"), 0);
/*     */           }
/*     */           
/*     */         }
/*     */         
/*     */       }
/*     */       
/* 125 */     });
/* 126 */     return this.bDeleteCellView;
/*     */   }
/*     */   
/*     */   private JComboBox createViewManagerCombo()
/*     */   {
/* 131 */     ViewListModel mm = null;
/* 132 */     this.views = new JComboBox(new ViewListModel());
/* 133 */     updateEditable();
/* 134 */     this.views.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 136 */         AppearEditorPane.this.getAppList().setCurrent((String)AppearEditorPane.this.views.getSelectedItem());
/* 137 */         AppearEditorPane.this.updateEditable();
/* 138 */         AppearEditorPane.this.gp.repaint();
/*     */       }
/* 140 */     });
/* 141 */     return this.views;
/*     */   }
/*     */   
/*     */   private JButton createBackRendererButton() {
/* 145 */     JButton button = new JButton(LocaleUtils.getEditorLocaleString("BackRenderer"));
/* 146 */     button.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 148 */         ViewAppearance currentAppearance = AppearEditorPane.this.getAppList().getCurrent();
/* 149 */         BackRenderer newValue = (BackRenderer)AppearEditorPane.this.bDialog.showDialog(currentAppearance.getRenderer(), LocaleUtils.getEditorLocaleString("BackRenderer"));
/*     */         
/*     */ 
/* 152 */         if (!AppearEditorPane.this.bDialog.isCanceled()) {
/* 153 */           currentAppearance.setRenderer(newValue);
/* 154 */           AppearEditorPane.this.fireLocalPropertyChange();
/*     */         }
/* 156 */         AppearEditorPane.this.gp.repaint();
/*     */       }
/* 158 */     });
/* 159 */     return button;
/*     */   }
/*     */   
/*     */   private void updateEditable() {
/* 163 */     ViewAppearance currentAppearance = getAppList().getCurrent();
/* 164 */     this.bEditCellView.setEnabled(currentAppearance.isEditable());
/* 165 */     this.bDeleteCellView.setEnabled(currentAppearance.isEditable());
/* 166 */     this.bSetBackPicture.setEnabled((currentAppearance.isSupportsTransparency()) && (currentAppearance.isEditable()));
/*     */   }
/*     */   
/*     */   private void refreshViews()
/*     */   {
/* 171 */     this.views.revalidate();
/* 172 */     this.views.repaint();
/*     */   }
/*     */   
/*     */   private void registerViewAppearance(String newViewName) {
/* 176 */     ViewAppearance newApp = (ViewAppearance)getAppList().getCurrent().clone();
/* 177 */     newApp.setName(newViewName);
/* 178 */     newApp.setEditable(true);
/* 179 */     getAppList().registerAppearance(newApp);
/* 180 */     getAppList().setCurrent(newViewName);
/* 181 */     this.views.setSelectedItem(newViewName);
/* 182 */     fireLocalPropertyChange();
/* 183 */     refreshViews();
/*     */   }
/*     */   
/*     */   private JButton createNewViewButton() {
/* 187 */     JButton bSave = new JButton(LocaleUtils.getEditorLocaleString("Create_view_clone"));
/* 188 */     bSave.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 190 */         String newViewName = JOptionPane.showInputDialog(LocaleUtils.getEditorLocaleString("View_name_prompt"));
/*     */         
/* 192 */         if (newViewName == null) return;
/* 193 */         if (AppearEditorPane.this.getAppList().isRegistered(newViewName)) {
/* 194 */           int ans = JOptionPane.showConfirmDialog(AppearEditorPane.this.getEditorPane().getParent(), MessageFormat.format(LocaleUtils.getEditorLocaleString("View_exist_prompt"), new Object[] { newViewName }), LocaleUtils.getEditorLocaleString("Existing_view"), 0);
/*     */           
/*     */ 
/*     */ 
/* 198 */           if (ans == 0) {
/* 199 */             if (AppearEditorPane.this.getAppList().getAppearance(newViewName).isEditable()) {
/* 200 */               AppearEditorPane.this.getAppList().unRegisterAppearance(newViewName);
/*     */             } else {
/* 202 */               JOptionPane.showMessageDialog(AppearEditorPane.this.getEditorPane().getParent(), MessageFormat.format(LocaleUtils.getEditorLocaleString("Cant_replace_view"), new Object[] { newViewName }), LocaleUtils.getEditorLocaleString("Uneditable_view"), 0);
/*     */             }
/*     */             
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/* 209 */             return;
/*     */           }
/*     */         }
/* 212 */         AppearEditorPane.this.registerViewAppearance(newViewName);
/*     */       }
/* 214 */     });
/* 215 */     return bSave;
/*     */   }
/*     */   
/*     */   private void generateClonedValue() {
/* 219 */     if (isTempEdit()) return;
/* 220 */     setTempEdit(true);
/* 221 */     getEditor().setInnerValue(getAppList().notDeepClone());
/* 222 */     this.gp.setAppearanceList(getAppList());
/* 223 */     setTempEdit(false);
/*     */   }
/*     */   
/*     */   private void fireLocalPropertyChange() {
/* 227 */     getEditor().firePropertyChange();
/*     */   }
/*     */   
/*     */   private CellAppearance getEditing() {
/* 231 */     ViewAppearance curApp = getAppList().getCurrent();
/* 232 */     switch (this.cellViews.getSelectedIndex()) {
/*     */     case 0: 
/* 234 */       return curApp.getDisabled();
/*     */     case 1: 
/* 236 */       return curApp.getUsual();
/*     */     case 2: 
/* 238 */       return curApp.getSelected();
/*     */     case 3: 
/* 240 */       return curApp.getNow();
/*     */     case 4: 
/* 242 */       return curApp.getScroll();
/*     */     case 5: 
/* 244 */       return curApp.getCaption();
/*     */     }
/* 246 */     return null;
/*     */   }
/*     */   
/*     */   private JButton createCellEditorButton() {
/* 250 */     this.bEditCellView = new JButton(LocaleUtils.getEditorLocaleString("Edit"));
/* 251 */     this.bEditCellView.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e) {
/* 254 */         CellAppearance newValue = (CellAppearance)AppearEditorPane.this.eDialog.showDialog(AppearEditorPane.this.getEditing(), MessageFormat.format(LocaleUtils.getEditorLocaleString("Edit_cell"), new Object[] { AppearEditorPane.this.cellViews.getSelectedItem() }));
/*     */         
/* 256 */         if (!AppearEditorPane.this.eDialog.isCanceled()) {
/* 257 */           AppearEditorPane.this.getEditing().assign(newValue);
/* 258 */           AppearEditorPane.this.fireLocalPropertyChange();
/*     */         }
/* 260 */         AppearEditorPane.this.gp.repaint();
/*     */       }
/* 262 */     });
/* 263 */     return this.bEditCellView;
/*     */   }
/*     */   
/*     */   private JComboBox createCellTypeCombo() {
/* 267 */     this.cellViews = new JComboBox(this.cellTypes);
/* 268 */     this.cellViews.setSelectedIndex(5);
/* 269 */     this.cellViews.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 271 */         if (AppearEditorPane.this.isAutoEdit()) return;
/* 272 */         AppearEditorPane.this.setAutoEdit(true);
/* 273 */         AppearEditorPane.this.model.setTypeSelected(AppearEditorPane.this.cellViews.getSelectedIndex());
/* 274 */         AppearEditorPane.this.setAutoEdit(false);
/*     */       }
/* 276 */     });
/* 277 */     return this.cellViews;
/*     */   }
/*     */   
/*     */   private GridPane createGridPane() {
/* 281 */     GridPane gp = new GridPane(getAppList());
/* 282 */     gp.setFocusable(false);
/* 283 */     gp.setFocused(true);
/* 284 */     gp.setPreferredSize(new Dimension(200, 200));
/* 285 */     gp.setModel(this.model);
/* 286 */     gp.setController(new EventHandler());
/* 287 */     return gp;
/*     */   }
/*     */   
/*     */   public AppearEditor getEditor() {
/* 291 */     return this.editor;
/*     */   }
/*     */   
/*     */   public void setEditor(AppearEditor editor) {
/* 295 */     if (getEditor() != null) {
/* 296 */       getEditor().removePropertyChangeListener(this);
/*     */     }
/* 298 */     this.editor = editor;
/* 299 */     setTempEdit(false);
/* 300 */     if (getEditor() != null) {
/* 301 */       getEditor().addPropertyChangeListener(this);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isAutoEdit() {
/* 306 */     return this.autoEdit;
/*     */   }
/*     */   
/*     */   public void setAutoEdit(boolean autoEdit) {
/* 310 */     this.autoEdit = autoEdit;
/*     */   }
/*     */   
/*     */   public boolean isTempEdit() {
/* 314 */     return this.tempEdit;
/*     */   }
/*     */   
/*     */   public void setTempEdit(boolean tempEdit) {
/* 318 */     this.tempEdit = tempEdit;
/*     */   }
/*     */   
/*     */   private AppearancesList getAppList() {
/* 322 */     return getEditor().getAppearancesList();
/*     */   }
/*     */   
/*     */   public void propertyChange(PropertyChangeEvent evt) {
/* 326 */     generateClonedValue();
/* 327 */     this.gp.repaint();
/*     */   }
/*     */   
/*     */   public void onCursorMove(CursorMoveEvent evt) {
/* 331 */     if (isAutoEdit()) return;
/* 332 */     setAutoEdit(true);
/* 333 */     if (!this.model.isSomeSelected()) return;
/* 334 */     int index = 0;
/* 335 */     switch (this.model.getSelectedCellState()) {
/*     */     case NORMAL: 
/* 337 */       index = 1;
/* 338 */       break;
/*     */     case SELECTED: 
/* 340 */       index = 2;
/* 341 */       break;
/*     */     case NOW: 
/* 343 */       index = 3;
/* 344 */       break;
/*     */     case NORMAL_SCROLL: 
/* 346 */       index = 4;
/* 347 */       break;
/*     */     case UNACCESSIBLE: 
/* 349 */       index = 0;
/*     */     }
/*     */     
/* 352 */     this.cellViews.setSelectedIndex(index);
/* 353 */     setAutoEdit(false);
/*     */   }
/*     */   
/*     */   class ViewListModel extends AbstractListModel implements ComboBoxModel, PropertyChangeListener
/*     */   {
/*     */     public ViewListModel() {
/* 359 */       AppearEditorPane.this.getEditor().addPropertyChangeListener(this);
/*     */     }
/*     */     
/*     */     public void setSelectedItem(Object anItem) {
/* 363 */       String itemName = (String)anItem;
/* 364 */       AppearEditorPane.this.getAppList().setCurrent(itemName);
/*     */     }
/*     */     
/*     */     public Object getSelectedItem() {
/* 368 */       return AppearEditorPane.this.getAppList().getCurrent().getName();
/*     */     }
/*     */     
/*     */     public int getSize() {
/* 372 */       return AppearEditorPane.this.getAppList().getRegisteredCount();
/*     */     }
/*     */     
/*     */     public Object getElementAt(int index) {
/* 376 */       return AppearEditorPane.this.getAppList().getRegisteredNames()[index];
/*     */     }
/*     */     
/*     */     public void propertyChange(PropertyChangeEvent evt) {
/* 380 */       fireContentsChanged(this, 0, getSize() - 1);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/appear/AppearEditorPane.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */