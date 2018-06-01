/*     */ package datechooser.view.appearance;
/*     */ 
/*     */ import datechooser.view.BackRenderer;
/*     */ import java.beans.PropertyChangeListener;
/*     */ import java.beans.PropertyChangeSupport;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.Serializable;
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
/*     */ public class ViewAppearance
/*     */   implements Cloneable, Serializable
/*     */ {
/*     */   private transient PropertyChangeSupport changeSupport;
/*     */   private CellAppearance usual;
/*     */   private CellAppearance selected;
/*     */   private CellAppearance now;
/*     */   private CellAppearance scroll;
/*     */   private CellAppearance caption;
/*     */   private CellAppearance disabled;
/*     */   private boolean editable;
/*     */   private boolean supportsTransparency;
/*     */   private BackRenderer renderer;
/*     */   private String name;
/*     */   
/*     */   public ViewAppearance()
/*     */   {
/*  68 */     setRenderer(null);
/*  69 */     setSupportsTransparency(false);
/*  70 */     this.changeSupport = new PropertyChangeSupport(this);
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
/*     */   public ViewAppearance(String name, CellAppearance usual, CellAppearance selected, CellAppearance now, CellAppearance scroll, CellAppearance caption, CellAppearance disabled, BackRenderer renderer, boolean canBeTransparent)
/*     */   {
/*  86 */     this(name, usual, selected, now, scroll, caption, disabled, renderer, canBeTransparent, true);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ViewAppearance(String name, CellAppearance usual, CellAppearance selected, CellAppearance now, CellAppearance scroll, CellAppearance caption, CellAppearance disabled, BackRenderer renderer, boolean canBeTransparent, boolean editable)
/*     */   {
/* 120 */     this();
/* 121 */     this.name = name;
/* 122 */     this.usual = usual;
/* 123 */     this.selected = selected;
/* 124 */     this.now = now;
/* 125 */     this.scroll = scroll;
/* 126 */     this.renderer = renderer;
/* 127 */     scroll.setSelectable(false);
/* 128 */     this.caption = caption;
/* 129 */     caption.setSelectable(false);
/* 130 */     this.disabled = disabled;
/* 131 */     setEditable(editable);
/* 132 */     setSupportsTransparency(canBeTransparent);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CellAppearance getUsual()
/*     */   {
/* 139 */     return this.usual;
/*     */   }
/*     */   
/*     */   private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
/* 143 */     ois.defaultReadObject();
/* 144 */     this.changeSupport = new PropertyChangeSupport(this);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUsual(CellAppearance usual)
/*     */   {
/* 151 */     CellAppearance oldValue = this.usual;
/* 152 */     this.usual = usual;
/* 153 */     this.changeSupport.firePropertyChange("usual", oldValue, usual);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CellAppearance getSelected()
/*     */   {
/* 160 */     return this.selected;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSelected(CellAppearance selected)
/*     */   {
/* 167 */     CellAppearance oldValue = this.selected;
/* 168 */     this.selected = selected;
/* 169 */     this.changeSupport.firePropertyChange("selected", oldValue, selected);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CellAppearance getNow()
/*     */   {
/* 176 */     return this.now;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setNow(CellAppearance now)
/*     */   {
/* 183 */     CellAppearance oldValue = this.now;
/* 184 */     this.now = now;
/* 185 */     this.changeSupport.firePropertyChange("now", oldValue, now);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CellAppearance getScroll()
/*     */   {
/* 192 */     return this.scroll;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setScroll(CellAppearance scroll)
/*     */   {
/* 199 */     CellAppearance oldValue = this.scroll;
/* 200 */     scroll.setSelectable(false);
/* 201 */     this.scroll = scroll;
/* 202 */     this.changeSupport.firePropertyChange("scroll", oldValue, scroll);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getName()
/*     */   {
/* 211 */     return this.name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/* 220 */     this.name = name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CellAppearance getCaption()
/*     */   {
/* 227 */     return this.caption;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCaption(CellAppearance caption)
/*     */   {
/* 234 */     CellAppearance oldValue = this.caption;
/* 235 */     caption.setSelectable(false);
/* 236 */     this.caption = caption;
/* 237 */     this.changeSupport.firePropertyChange("caption", oldValue, caption);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CellAppearance getDisabled()
/*     */   {
/* 244 */     return this.disabled;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDisabled(CellAppearance disabled)
/*     */   {
/* 251 */     CellAppearance oldValue = this.disabled;
/* 252 */     this.disabled = disabled;
/* 253 */     this.changeSupport.firePropertyChange("disabled", oldValue, disabled);
/*     */   }
/*     */   
/*     */   public Object clone() {
/* 257 */     ViewAppearance newInst = new ViewAppearance(getName(), (CellAppearance)getUsual().clone(), (CellAppearance)getSelected().clone(), (CellAppearance)getNow().clone(), (CellAppearance)getScroll().clone(), (CellAppearance)getCaption().clone(), (CellAppearance)getDisabled().clone(), getRenderer(), isSupportsTransparency(), isEditable());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 267 */     PropertyChangeListener[] listeners = this.changeSupport.getPropertyChangeListeners();
/* 268 */     for (PropertyChangeListener theListener : listeners) {
/* 269 */       newInst.addPropertyChangeListener(theListener);
/*     */     }
/* 271 */     return newInst;
/*     */   }
/*     */   
/*     */   public void addPropertyChangeListener(PropertyChangeListener listener) {
/* 275 */     this.changeSupport.addPropertyChangeListener(listener);
/*     */   }
/*     */   
/*     */   public void removePropertyChangeListener(PropertyChangeListener listener) {
/* 279 */     this.changeSupport.removePropertyChangeListener(listener);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isEditable()
/*     */   {
/* 288 */     return this.editable;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEditable(boolean editable)
/*     */   {
/* 297 */     this.editable = editable;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public BackRenderer getRenderer()
/*     */   {
/* 306 */     return this.renderer;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRenderer(BackRenderer renderer)
/*     */   {
/* 316 */     this.renderer = renderer;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isSupportsTransparency()
/*     */   {
/* 325 */     return this.supportsTransparency;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSupportsTransparency(boolean supportsTransparency)
/*     */   {
/* 334 */     this.supportsTransparency = supportsTransparency;
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/view/appearance/ViewAppearance.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */