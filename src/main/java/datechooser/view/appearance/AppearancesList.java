/*     */ package datechooser.view.appearance;
/*     */ 
/*     */ import datechooser.beans.pic.Pictures;
/*     */ import datechooser.view.BackRenderer;
/*     */ import datechooser.view.appearance.custom.CustomCellAppearance;
/*     */ import datechooser.view.appearance.swing.ButtonPainter;
/*     */ import datechooser.view.appearance.swing.LabelPainter;
/*     */ import datechooser.view.appearance.swing.SwingCellAppearance;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.beans.PropertyChangeEvent;
/*     */ import java.beans.PropertyChangeListener;
/*     */ import java.beans.PropertyChangeSupport;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.HashMap;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.border.Border;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AppearancesList
/*     */   implements PropertyChangeListener, Cloneable, Serializable
/*     */ {
/*  38 */   public static String DEFAULT = "Swing";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  43 */   public static String CUSTOM = "custom";
/*     */   
/*     */   private transient PropertyChangeSupport changeSupport;
/*     */   private HashMap<String, ViewAppearance> appearances;
/*  47 */   private ViewAppearance current = null;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public AppearancesList()
/*     */   {
/*  56 */     this(true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public AppearancesList(boolean autoInit)
/*     */   {
/*  70 */     this.changeSupport = new PropertyChangeSupport(this);
/*  71 */     this.appearances = new HashMap();
/*  72 */     registerHardCoded();
/*  73 */     setCurrent(DEFAULT);
/*  74 */     if (autoInit) {
/*  75 */       ViewAppearance customView = (ViewAppearance)getDefaultAppearance().clone();
/*  76 */       customView.setName(CUSTOM);
/*  77 */       customView.setEditable(true);
/*  78 */       registerAppearance(customView);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private AppearancesList(HashMap<String, ViewAppearance> data, PropertyChangeSupport changer, ViewAppearance current)
/*     */   {
/*  90 */     this.changeSupport = new PropertyChangeSupport(this);
/*  91 */     movePropertyChangeListeners(changer, this.changeSupport);
/*     */     
/*  93 */     this.appearances = data;
/*  94 */     this.current = current;
/*     */   }
/*     */   
/*     */   private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
/*  98 */     ois.defaultReadObject();
/*  99 */     this.changeSupport = new PropertyChangeSupport(this);
/*     */   }
/*     */   
/*     */   private void registerHardCoded()
/*     */   {
/* 104 */     registerHardCodedAppearance(new ViewAppearance("Contrast", new CustomCellAppearance(new Color(0, 0, 0), new Color(255, 255, 255), BorderFactory.createLineBorder(new Color(0, 0, 0), 1), new Font("Serif", 1, 12), new Color(255, 255, 255), 1.0F), new CustomCellAppearance(new Color(0, 0, 0), new Color(255, 255, 255), BorderFactory.createLineBorder(new Color(255, 255, 255), 1), new Font("Serif", 1, 16), new Color(0, 255, 0), 1.0F), new CustomCellAppearance(new Color(0, 0, 0), new Color(255, 255, 255), BorderFactory.createLineBorder(new Color(0, 0, 0), 1), new Font("Serif", 1, 14), new Color(0, 255, 0), 1.0F), new CustomCellAppearance(new Color(0, 0, 0), new Color(250, 250, 250), BorderFactory.createLineBorder(new Color(0, 0, 0), 1), new Font("Serif", 2, 12), new Color(0, 0, 255), 1.0F), new CustomCellAppearance(new Color(0, 0, 0), new Color(255, 255, 255), BorderFactory.createLineBorder(new Color(0, 0, 0), 1), new Font("Serif", 1, 12), new Color(0, 0, 255), 1.0F), new CustomCellAppearance(new Color(0, 0, 0), new Color(180, 180, 180), BorderFactory.createLineBorder(new Color(0, 0, 0), 1), new Font("Serif", 0, 10), new Color(255, 0, 0), 1.0F), null, true));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 139 */     registerHardCodedAppearance(new ViewAppearance("Light", new CustomCellAppearance(new Color(255, 255, 255), new Color(0, 0, 0), (Border)null, new Font("Serif", 0, 12), new Color(0, 0, 153), 1.0F), new CustomCellAppearance(new Color(153, 153, 255), new Color(0, 0, 0), (Border)null, new Font("Serif", 0, 12), new Color(0, 0, 102), 1.0F), new CustomCellAppearance(new Color(204, 255, 204), new Color(51, 255, 51), (Border)null, new Font("Serif", 0, 12), new Color(0, 0, 153), 1.0F), new CustomCellAppearance(new Color(255, 255, 255), new Color(0, 0, 102), (Border)null, new Font("Serif", 2, 10), new Color(0, 0, 255), 1.0F), new CustomCellAppearance(new Color(255, 255, 255), new Color(0, 0, 0), (Border)null, new Font("Serif", 1, 12), new Color(0, 0, 255), 1.0F), new CustomCellAppearance(new Color(255, 255, 255), new Color(255, 0, 0), (Border)null, new Font("Serif", 0, 12), new Color(255, 0, 0), 1.0F), null, true));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 174 */     registerHardCodedAppearance(new ViewAppearance("Bordered", new CustomCellAppearance(new Color(204, 204, 204), new Color(0, 0, 249), BorderFactory.createEtchedBorder(1, (Color)null, (Color)null), new Font("Serif", 0, 12), new Color(0, 0, 0), 1.0F), new CustomCellAppearance(new Color(204, 204, 204), new Color(0, 0, 255), BorderFactory.createBevelBorder(1, (Color)null, (Color)null, new Color(0, 0, 0), (Color)null), new Font("Serif", 1, 12), new Color(0, 0, 102), 1.0F), new CustomCellAppearance(new Color(204, 204, 204), new Color(0, 51, 0), BorderFactory.createEtchedBorder(1, (Color)null, (Color)null), new Font("Serif", 0, 12), new Color(0, 102, 0), 1.0F), new CustomCellAppearance(new Color(204, 204, 204), new Color(102, 102, 102), BorderFactory.createEtchedBorder(1, (Color)null, (Color)null), new Font("Serif", 0, 10), new Color(0, 0, 255), 1.0F), new CustomCellAppearance(new Color(204, 204, 204), new Color(0, 0, 0), BorderFactory.createEtchedBorder(1, (Color)null, (Color)null), new Font("Serif", 1, 12), new Color(0, 0, 255), 1.0F), new CustomCellAppearance(new Color(204, 204, 204), new Color(153, 153, 153), BorderFactory.createEtchedBorder(1, (Color)null, (Color)null), new Font("Serif", 0, 12), new Color(255, 0, 0), 1.0F), null, true));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 223 */     registerHardCodedAppearance(new ViewAppearance("Grey", new CustomCellAppearance(new Color(120, 120, 120), new Color(255, 255, 255), BorderFactory.createLineBorder(new Color(0, 0, 0), 1), new Font("Serif", 0, 12), new Color(255, 255, 255), 1.0F), new CustomCellAppearance(new Color(100, 100, 100), new Color(255, 255, 255), BorderFactory.createLineBorder(new Color(0, 0, 0), 1), new Font("Serif", 0, 12), new Color(0, 255, 0), 1.0F), new CustomCellAppearance(new Color(120, 120, 120), new Color(0, 255, 0), BorderFactory.createLineBorder(new Color(0, 0, 0), 1), new Font("Serif", 0, 12), new Color(0, 255, 0), 1.0F), new CustomCellAppearance(new Color(160, 160, 160), new Color(250, 250, 250), BorderFactory.createLineBorder(new Color(0, 0, 0), 1), new Font("Serif", 0, 12), new Color(0, 0, 255), 1.0F), new CustomCellAppearance(new Color(100, 100, 100), new Color(255, 255, 255), BorderFactory.createLineBorder(new Color(0, 0, 0), 1), new Font("Serif", 0, 12), new Color(0, 0, 255), 1.0F), new CustomCellAppearance(new Color(120, 120, 120), new Color(180, 180, 180), BorderFactory.createLineBorder(new Color(0, 0, 0), 1), new Font("Serif", 0, 12), new Color(255, 0, 0), 1.0F), null, true));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 258 */     registerHardCodedAppearance(new ViewAppearance("Dali", new CustomCellAppearance(new Color(0, 0, 0), new Color(255, 255, 255), (Border)null, new Font("Serif", 0, 12), new Color(0, 0, 153), 0.4F), new CustomCellAppearance(new Color(153, 153, 255), new Color(255, 255, 0), (Border)null, new Font("Serif", 1, 14), new Color(0, 0, 102), 0.2F), new CustomCellAppearance(new Color(0, 0, 0), new Color(51, 255, 51), (Border)null, new Font("Serif", 0, 12), new Color(0, 0, 153), 0.5F), new CustomCellAppearance(new Color(204, 204, 204), new Color(0, 0, 102), (Border)null, new Font("Serif", 2, 10), new Color(0, 0, 255), 0.4F), new CustomCellAppearance(new Color(0, 0, 0), new Color(255, 255, 255), (Border)null, new Font("Serif", 1, 12), new Color(0, 0, 255), 0.4F), new CustomCellAppearance(new Color(255, 0, 0), new Color(255, 0, 0), (Border)null, new Font("Serif", 0, 12), new Color(255, 0, 0), 0.3F), new BackRenderer(1, Pictures.getResource("dali.gif")), true, true));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 299 */     registerHardCodedAppearance(new ViewAppearance(DEFAULT, new SwingCellAppearance(null, null, Color.BLUE, false, true, new ButtonPainter()), new SwingCellAppearance(null, null, Color.BLUE, true, true, new ButtonPainter()), new SwingCellAppearance(null, Color.BLUE, Color.BLUE, false, true, new ButtonPainter()), new SwingCellAppearance(null, Color.GRAY, Color.BLUE, false, true, new LabelPainter()), new SwingCellAppearance(null, null, Color.BLUE, false, true, new LabelPainter()), new SwingCellAppearance(null, null, Color.RED, false, false, new ButtonPainter()), null, false));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public AppearancesList(String current, ViewAppearance... cellViews)
/*     */   {
/* 325 */     this(false);
/* 326 */     for (ViewAppearance view : cellViews) {
/* 327 */       registerAppearance(view);
/*     */     }
/* 329 */     setCurrent(current);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getRegisteredCount()
/*     */   {
/* 338 */     return this.appearances.size();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isRegistered(String name)
/*     */   {
/* 347 */     return this.appearances.containsKey(name);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String[] getRegisteredNames()
/*     */   {
/* 356 */     String[] result = new String[this.appearances.size()];
/* 357 */     result[0] = getAppearance(CUSTOM).getName();
/* 358 */     result[1] = getAppearance(DEFAULT).getName();
/* 359 */     int index = 2;
/* 360 */     for (String key : getKeys())
/* 361 */       if ((!key.equals(DEFAULT)) && (!key.equals(CUSTOM)))
/*     */       {
/*     */ 
/* 364 */         result[index] = ((ViewAppearance)this.appearances.get(key)).getName();
/* 365 */         index++;
/*     */       }
/* 367 */     return result;
/*     */   }
/*     */   
/*     */   public void propertyChange(PropertyChangeEvent evt) {
/* 371 */     this.changeSupport.firePropertyChange(evt);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ViewAppearance getAppearance(String name)
/*     */   {
/* 385 */     return (ViewAppearance)this.appearances.get(name);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ViewAppearance getDefaultAppearance()
/*     */   {
/* 394 */     return (ViewAppearance)this.appearances.get(DEFAULT);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean setCurrent(String name)
/*     */   {
/* 405 */     if (isRegistered(name)) {
/* 406 */       this.current = ((ViewAppearance)this.appearances.get(name));
/* 407 */       return true;
/*     */     }
/* 409 */     this.current = getDefaultAppearance();
/* 410 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ViewAppearance getCurrent()
/*     */   {
/* 420 */     return this.current;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void registerAppearance(ViewAppearance anAppearance)
/*     */   {
/* 430 */     this.appearances.put(anAppearance.getName(), anAppearance);
/* 431 */     anAppearance.addPropertyChangeListener(this);
/* 432 */     this.changeSupport.firePropertyChange("Appearance list", null, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void registerHardCodedAppearance(ViewAppearance anAppearance)
/*     */   {
/* 441 */     anAppearance.setEditable(false);
/* 442 */     registerAppearance(anAppearance);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void reRegisterAppearance(ViewAppearance anAppearance)
/*     */   {
/* 449 */     unRegisterAnyAppearance(anAppearance.getName());
/* 450 */     registerAppearance(anAppearance);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean unRegisterAppearance(String aName)
/*     */   {
/* 459 */     if ((aName.equals(DEFAULT)) || (aName.equals(CUSTOM))) {
/* 460 */       return false;
/*     */     }
/* 462 */     unRegisterAnyAppearance(aName);
/* 463 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void unRegisterAnyAppearance(String aName)
/*     */   {
/* 470 */     if (this.appearances.containsKey(aName)) {
/* 471 */       getAppearance(aName).removePropertyChangeListener(this);
/* 472 */       this.appearances.remove(aName);
/* 473 */       this.changeSupport.firePropertyChange("Appearance list", null, null);
/*     */     }
/*     */   }
/*     */   
/*     */   private void movePropertyChangeListeners(PropertyChangeSupport from, PropertyChangeSupport to) {
/* 478 */     PropertyChangeListener[] listeners = from.getPropertyChangeListeners();
/* 479 */     for (PropertyChangeListener theListener : listeners) {
/* 480 */       to.addPropertyChangeListener(theListener);
/*     */     }
/*     */   }
/*     */   
/*     */   public void addPropertyChangeListener(PropertyChangeListener listener)
/*     */   {
/* 486 */     this.changeSupport.addPropertyChangeListener(listener);
/*     */   }
/*     */   
/*     */   public void removePropertyChangeListener(PropertyChangeListener listener) {
/* 490 */     this.changeSupport.removePropertyChangeListener(listener);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Object clone()
/*     */   {
/* 499 */     AppearancesList newInst = new AppearancesList(false);
/* 500 */     movePropertyChangeListeners(this.changeSupport, newInst.changeSupport);
/* 501 */     for (String key : this.appearances.keySet()) {
/* 502 */       ViewAppearance view = (ViewAppearance)this.appearances.get(key);
/* 503 */       if (view.isEditable())
/* 504 */         newInst.registerAppearance((ViewAppearance)view.clone());
/*     */     }
/* 506 */     newInst.setCurrent(getCurrent().getName());
/* 507 */     return newInst;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public AppearancesList notDeepClone()
/*     */   {
/* 516 */     return new AppearancesList(this.appearances, this.changeSupport, this.current);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Iterable<String> getKeys()
/*     */   {
/* 525 */     return this.appearances.keySet();
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/view/appearance/AppearancesList.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */