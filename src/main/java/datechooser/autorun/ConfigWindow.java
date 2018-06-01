/*     */ package datechooser.autorun;
/*     */ 
/*     */ import datechooser.beans.DateChooserBean;
/*     */ import datechooser.beans.locale.LocaleUtils;
/*     */ import datechooser.events.SelectionChangedEvent;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.File;
/*     */ import javax.swing.ButtonGroup;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JCheckBoxMenuItem;
/*     */ import javax.swing.JFileChooser;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JMenu;
/*     */ import javax.swing.JMenuBar;
/*     */ import javax.swing.JMenuItem;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.LookAndFeel;
/*     */ import javax.swing.SwingUtilities;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.UIManager.LookAndFeelInfo;
/*     */ 
/*     */ public class ConfigWindow extends JFrame implements datechooser.events.CommitListener, datechooser.events.SelectionChangedListener
/*     */ {
/*     */   private static final int WIDTH = 630;
/*     */   private static final int HEIGHT = 380;
/*     */   private static final String MENU_PROPERTY_ID = "MenuItemID";
/*     */   private static final String MENU_LOAD = "load";
/*     */   private static final String MENU_SAVE = "save";
/*     */   private static final String MENU_SAVE_AS = "save as";
/*     */   private JPanel mainPane;
/*     */   private ConfigBean[] configurators;
/*     */   private JLabel selectedBeanNameLabel;
/*     */   private int selected;
/*     */   private JTextArea output;
/*     */   private ButtonGroup selLookFeel;
/*     */   private String about;
/*     */   private ImageIcon aboutImage;
/*     */   private JFileChooser fileChooser;
/*     */   
/*     */   public ConfigWindow() throws java.beans.IntrospectionException
/*     */   {
/*  48 */     LocaleUtils.prepareStandartDialogButtonText();
/*  49 */     setDefaultCloseOperation(0);
/*  50 */     setTitle(LocaleUtils.getConfigLocaleString("Caption"));
/*  51 */     this.mainPane = new JPanel(new java.awt.BorderLayout(5, 2));
/*  52 */     this.configurators = new ConfigBean[] { new ConfigPanel(), new ConfigCombo(), new ConfigDialog() };
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  57 */     this.selected = 0;
/*  58 */     setJMenuBar(createMenuBar());
/*  59 */     this.selectedBeanNameLabel = createBeanNameOutput();
/*  60 */     this.mainPane.add(this.selectedBeanNameLabel, "North");
/*  61 */     this.mainPane.add(getCurrentConfigBean(), "Center");
/*  62 */     this.output = createOutput();
/*  63 */     this.mainPane.add(this.output, "South");
/*     */     
/*  65 */     setContentPane(this.mainPane);
/*  66 */     updateOutput();
/*  67 */     setCentered();
/*  68 */     synchronized (getTreeLock()) {
/*  69 */       validateTree();
/*     */     }
/*  71 */     registerAsListener();
/*  72 */     setAllSaved();
/*     */     
/*  74 */     this.fileChooser = new JFileChooser();
/*  75 */     this.fileChooser.setFileFilter(new ComponentFileFilter(null));
/*     */     
/*  77 */     addWindowListener(new OnWindowClose(null));
/*     */   }
/*     */   
/*     */   private void setAllSaved() {
/*  81 */     for (ConfigBean configBean : this.configurators) {
/*  82 */       configBean.setSaved(true);
/*     */     }
/*     */   }
/*     */   
/*     */   private JLabel createBeanNameOutput() {
/*  87 */     JLabel selectedBean = new JLabel(getCurrentConfigBean().getBeanDisplayName());
/*  88 */     selectedBean.setHorizontalAlignment(0);
/*  89 */     selectedBean.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
/*  90 */     return selectedBean;
/*     */   }
/*     */   
/*     */   private JTextArea createOutput() {
/*  94 */     JTextArea output = new JTextArea("");
/*  95 */     output.setRows(2);
/*  96 */     output.setLineWrap(true);
/*  97 */     output.setWrapStyleWord(true);
/*  98 */     output.setOpaque(false);
/*  99 */     output.setEditable(false);
/* 100 */     return output;
/*     */   }
/*     */   
/*     */   private JMenuBar createMenuBar() {
/* 104 */     JMenuBar menuBar = new JMenuBar();
/*     */     
/* 106 */     menuBar.add(createMenuFile());
/* 107 */     menuBar.add(createMenuBean());
/* 108 */     menuBar.add(createMenuLF());
/* 109 */     menuBar.add(createMenuHelp());
/*     */     
/* 111 */     return menuBar;
/*     */   }
/*     */   
/*     */   private JFrame getFrame() {
/* 115 */     return this;
/*     */   }
/*     */   
/*     */   private JMenu createMenuHelp()
/*     */   {
/* 120 */     JMenu menuHelp = new JMenu(LocaleUtils.getConfigLocaleString("Help"));
/* 121 */     JMenuItem menuAbout = new JMenuItem(LocaleUtils.getConfigLocaleString("About"));
/*     */     
/* 123 */     StringBuffer aboutString = new StringBuffer("<html>");
/* 124 */     aboutString.append(LocaleUtils.getConfigLocaleString("ProjectName"));
/* 125 */     aboutString.append("<br><br>(c) ");
/* 126 */     aboutString.append(LocaleUtils.getConfigLocaleString("Author"));
/* 127 */     aboutString.append(", 2014<br>");
/* 128 */     aboutString.append("e-mail: <i>androsovvi@gmail.com</i>");
/* 129 */     this.about = aboutString.toString();
/*     */     
/* 131 */     this.aboutImage = new ImageIcon(datechooser.beans.pic.Pictures.getResource("logo_small.gif"));
/*     */     
/* 133 */     menuAbout.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 135 */         JOptionPane.showMessageDialog(ConfigWindow.this.getFrame(), ConfigWindow.this.about, LocaleUtils.getConfigLocaleString("About"), 1, ConfigWindow.this.aboutImage);
/*     */ 
/*     */       }
/*     */       
/*     */ 
/* 140 */     });
/* 141 */     menuHelp.add(menuAbout);
/* 142 */     return menuHelp;
/*     */   }
/*     */   
/*     */   private JMenu createMenuLF() {
/* 146 */     JMenu menuLF = new JMenu(LocaleUtils.getConfigLocaleString("LookFeel"));
/* 147 */     UIManager.LookAndFeelInfo[] lf = UIManager.getInstalledLookAndFeels();
/* 148 */     this.selLookFeel = new ButtonGroup();
/* 149 */     LookAndFeel current = UIManager.getLookAndFeel();
/* 150 */     OnLookAndFeelChange onChange = new OnLookAndFeelChange(null);
/* 151 */     for (UIManager.LookAndFeelInfo lookAndFeel : lf) {
/* 152 */       String lfName = lookAndFeel.getName();
/* 153 */       JCheckBoxMenuItem miLF = new JCheckBoxMenuItem(lfName);
/* 154 */       miLF.putClientProperty("MenuItemID", lookAndFeel.getClassName());
/* 155 */       miLF.addActionListener(onChange);
/* 156 */       if ((current != null) && (current.getName().equals(lfName))) {
/* 157 */         miLF.setSelected(true);
/*     */       }
/* 159 */       this.selLookFeel.add(miLF);
/* 160 */       menuLF.add(miLF);
/*     */     }
/* 162 */     return menuLF;
/*     */   }
/*     */   
/*     */   private JMenu createMenuFile() {
/* 166 */     OnStoreAction onStore = new OnStoreAction(null);
/* 167 */     JMenu menuFile = new JMenu(LocaleUtils.getConfigLocaleString("File"));
/* 168 */     JMenuItem menuLoad = new JMenuItem(LocaleUtils.getConfigLocaleString("Load"));
/* 169 */     menuLoad.putClientProperty("MenuItemID", "load");
/* 170 */     menuLoad.addActionListener(onStore);
/* 171 */     menuFile.add(menuLoad);
/* 172 */     menuFile.addSeparator();
/* 173 */     JMenuItem menuSave = new JMenuItem(LocaleUtils.getConfigLocaleString("Save"));
/* 174 */     menuSave.putClientProperty("MenuItemID", "save");
/* 175 */     menuSave.addActionListener(onStore);
/* 176 */     menuFile.add(menuSave);
/* 177 */     JMenuItem menuSaveAs = new JMenuItem(LocaleUtils.getConfigLocaleString("SaveAs"));
/* 178 */     menuSaveAs.putClientProperty("MenuItemID", "save as");
/* 179 */     menuSaveAs.addActionListener(onStore);
/* 180 */     menuFile.add(menuSaveAs);
/* 181 */     menuFile.addSeparator();
/* 182 */     JMenuItem menuExit = new JMenuItem(LocaleUtils.getConfigLocaleString("Exit"));
/* 183 */     menuExit.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 185 */         ConfigWindow.this.tryToExit();
/*     */       }
/* 187 */     });
/* 188 */     menuFile.add(menuExit);
/* 189 */     return menuFile;
/*     */   }
/*     */   
/*     */   private void tryToExit() {
/* 193 */     String unsaved = getUnsaved();
/* 194 */     if (!getUnsaved().equals("")) {
/* 195 */       int ans = JOptionPane.showConfirmDialog(getFrame(), "<html> " + LocaleUtils.getConfigLocaleString("Exit_no_save") + " <br><UL>" + unsaved + "</UL>", LocaleUtils.getConfigLocaleString("Exit"), 0);
/*     */       
/*     */ 
/*     */ 
/* 199 */       if (ans == 1) return;
/*     */     }
/* 201 */     System.exit(0);
/*     */   }
/*     */   
/*     */   private String getUnsaved() {
/* 205 */     StringBuffer unsaved = new StringBuffer("");
/* 206 */     for (ConfigBean configurator : this.configurators) {
/* 207 */       if (!configurator.isSaved()) {
/* 208 */         unsaved.append("<LI>");
/* 209 */         unsaved.append(configurator.getBeanDisplayName());
/*     */       }
/*     */     }
/* 212 */     return unsaved.toString();
/*     */   }
/*     */   
/*     */   private JMenu createMenuBean() {
/* 216 */     JMenu menuBean = new JMenu(LocaleUtils.getConfigLocaleString("Bean"));
/* 217 */     OnBeanChange onBeanChange = new OnBeanChange(null);
/* 218 */     ButtonGroup group = new ButtonGroup();
/* 219 */     for (int i = 0; i < this.configurators.length; i++) {
/* 220 */       String beanName = this.configurators[i].getBeanDisplayName();
/* 221 */       JCheckBoxMenuItem menuCurrentBean = new JCheckBoxMenuItem(beanName);
/* 222 */       menuCurrentBean.putClientProperty("MenuItemID", new Integer(i));
/* 223 */       menuCurrentBean.addActionListener(onBeanChange);
/* 224 */       menuCurrentBean.setSelected(getSelected() == i);
/* 225 */       group.add(menuCurrentBean);
/* 226 */       menuBean.add(menuCurrentBean);
/*     */     }
/* 228 */     return menuBean;
/*     */   }
/*     */   
/*     */   private void registerAsListener() {
/* 232 */     for (ConfigBean beanConfigurator : this.configurators) {
/* 233 */       beanConfigurator.getBean().addCommitListener(this);
/* 234 */       beanConfigurator.getBean().addSelectionChangedListener(this);
/*     */     }
/*     */   }
/*     */   
/*     */   private int getSelected() {
/* 239 */     return this.selected;
/*     */   }
/*     */   
/*     */   private void updateOutput() {
/* 243 */     this.output.setText(getCurrentConfigBean().getBean().getSelectedPeriodSet().toString());
/*     */   }
/*     */   
/*     */   private ConfigBean getCurrentConfigBean() {
/* 247 */     return this.configurators[getSelected()];
/*     */   }
/*     */   
/*     */   private void setSelected(int selected) {
/* 251 */     if (selected == getSelected()) return;
/* 252 */     this.mainPane.remove(getCurrentConfigBean());
/* 253 */     this.selected = selected;
/* 254 */     this.mainPane.add(getCurrentConfigBean(), "Center");
/* 255 */     this.selectedBeanNameLabel.setText(getCurrentConfigBean().getBeanDisplayName());
/* 256 */     this.mainPane.validate();
/* 257 */     updateOutput();
/*     */   }
/*     */   
/*     */   private void setCentered() {
/* 261 */     setSize(630, 380);
/* 262 */     Toolkit kit = Toolkit.getDefaultToolkit();
/* 263 */     Dimension screenSize = kit.getScreenSize();
/* 264 */     if ((getWidth() > screenSize.width) || (getHeight() > screenSize.height)) {
/* 265 */       setLocation(0, 0);
/*     */     } else {
/* 267 */       setLocation((screenSize.width - getWidth()) / 2, (screenSize.height - getHeight()) / 2);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onCommit(datechooser.events.CommitEvent evt)
/*     */   {
/* 280 */     updateOutput();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onSelectionChange(SelectionChangedEvent evt)
/*     */   {
/* 289 */     updateOutput();
/*     */   }
/*     */   
/*     */   private File getFileName(File start, String title, String approveName, boolean isOpen) {
/* 293 */     this.fileChooser.setDialogType(isOpen ? 0 : 1);
/* 294 */     if (start != null) this.fileChooser.setSelectedFile(start);
/* 295 */     if (approveName != null) this.fileChooser.setApproveButtonText(approveName);
/* 296 */     this.fileChooser.setApproveButtonText(approveName);
/* 297 */     this.fileChooser.setDialogTitle(title);
/* 298 */     int result = this.fileChooser.showDialog(this, null);
/* 299 */     if (result != 0) {
/* 300 */       return null;
/*     */     }
/* 302 */     return this.fileChooser.getSelectedFile();
/*     */   }
/*     */   
/*     */   private class OnWindowClose extends java.awt.event.WindowAdapter { private OnWindowClose() {}
/*     */     
/* 307 */     public void windowClosing(java.awt.event.WindowEvent e) { ConfigWindow.this.tryToExit(); }
/*     */   }
/*     */   
/*     */   private class OnStoreAction implements ActionListener {
/*     */     private OnStoreAction() {}
/*     */     
/*     */     public void actionPerformed(ActionEvent e) {
/* 314 */       String action = (String)((JMenuItem)e.getSource()).getClientProperty("MenuItemID");
/* 315 */       if (action.equals("load")) {
/* 316 */         loadFromFile();
/*     */       }
/* 318 */       if (action.equals("save")) {
/* 319 */         saveToFile(false);
/*     */       }
/* 321 */       if (action.equals("save as")) {
/* 322 */         saveToFile(true);
/*     */       }
/*     */     }
/*     */     
/*     */     private void sayIfNotOK(String status) {
/* 327 */       if (status.equals("ok")) return;
/* 328 */       StringBuffer mess = new StringBuffer("<html><i>");
/* 329 */       mess.append(LocaleUtils.getConfigLocaleString("OperationErrorMessage"));
/* 330 */       mess.append("</i><br><br>");
/* 331 */       mess.append(status);
/* 332 */       JOptionPane.showMessageDialog(ConfigWindow.this.getFrame(), mess.toString(), LocaleUtils.getConfigLocaleString("OperationError"), 0);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     private void loadFromFile()
/*     */     {
/* 339 */       ConfigBean configBean = ConfigWindow.this.getCurrentConfigBean();
/* 340 */       if (!configBean.isSaved()) {
/* 341 */         int result = JOptionPane.showConfirmDialog(ConfigWindow.this.getFrame(), LocaleUtils.getConfigLocaleString("ConfigLost"), LocaleUtils.getConfigLocaleString("Load"), 2);
/*     */         
/*     */ 
/*     */ 
/* 345 */         if (result == 2) return;
/*     */       }
/* 347 */       File file = ConfigWindow.this.getFileName(configBean.getFile(), configBean.getBeanDisplayName(), LocaleUtils.getConfigLocaleString("Load"), true);
/*     */       
/*     */ 
/* 350 */       if (file == null) return;
/* 351 */       sayIfNotOK(configBean.readFromFile(file));
/*     */     }
/*     */     
/*     */     private void saveToFile(boolean saveAs) {
/* 355 */       ConfigBean configBean = ConfigWindow.this.getCurrentConfigBean();
/* 356 */       if ((!saveAs) && (configBean.isSaved()) && (configBean.getFile() != null)) return;
/* 357 */       File file = configBean.getFile();
/* 358 */       if ((saveAs) || (file == null)) {
/* 359 */         if (file == null) file = new File(configBean.getBeanInfo().getBeanDescriptor().getName());
/* 360 */         file = ConfigWindow.this.getFileName(file, configBean.getBeanDisplayName(), LocaleUtils.getConfigLocaleString("Save"), false);
/*     */         
/*     */ 
/* 363 */         if (file == null) return;
/* 364 */         if (!file.getPath().endsWith(configBean.getFileExt())) {
/* 365 */           file = new File(file.getPath() + "." + configBean.getFileExt());
/*     */         }
/*     */       }
/* 368 */       sayIfNotOK(configBean.writeToFile(file));
/*     */     }
/*     */   }
/*     */   
/*     */   private class ComponentFileFilter extends javax.swing.filechooser.FileFilter {
/*     */     private ComponentFileFilter() {}
/*     */     
/* 375 */     public boolean accept(File f) { return (f.isDirectory()) || (f.getName().endsWith(ConfigWindow.this.getCurrentConfigBean().getFileExt())); }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 380 */     public String getDescription() { return ConfigWindow.this.getCurrentConfigBean().getBeanDisplayName(); }
/*     */   }
/*     */   
/*     */   private class OnLookAndFeelChange implements ActionListener {
/*     */     private OnLookAndFeelChange() {}
/*     */     
/* 386 */     public void actionPerformed(ActionEvent e) { String newLFClassName = (String)((JCheckBoxMenuItem)e.getSource()).getClientProperty("MenuItemID");
/* 387 */       if (newLFClassName.equals(UIManager.getLookAndFeel().getClass().getName())) return;
/*     */       try {
/* 389 */         UIManager.setLookAndFeel(newLFClassName);
/* 390 */         SwingUtilities.updateComponentTreeUI(ConfigWindow.this.getFrame());
/* 391 */         for (ConfigBean beanConfigurator : ConfigWindow.this.configurators) {
/* 392 */           SwingUtilities.updateComponentTreeUI(beanConfigurator);
/* 393 */           SwingUtilities.updateComponentTreeUI(ConfigWindow.this.fileChooser);
/*     */         }
/* 395 */         ConfigWindow.this.getFrame().repaint();
/*     */       } catch (Exception ex) {
/* 397 */         ex.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private class OnBeanChange implements ActionListener { private OnBeanChange() {}
/*     */     
/* 404 */     public void actionPerformed(ActionEvent e) { Integer newBeanIndex = (Integer)((JCheckBoxMenuItem)e.getSource()).getClientProperty("MenuItemID");
/* 405 */       ConfigWindow.this.setSelected(newBeanIndex.intValue());
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/autorun/ConfigWindow.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */