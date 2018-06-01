/*     */ package datechooser.beans.customizer;
/*     */ 
/*     */ import datechooser.beans.editor.BooleanEditorFoo;
/*     */ import datechooser.beans.editor.StringEditor;
/*     */ import datechooser.beans.locale.LocaleUtils;
/*     */ import java.beans.BeanInfo;
/*     */ import java.beans.IntrospectionException;
/*     */ import java.beans.PropertyChangeEvent;
/*     */ import java.beans.PropertyChangeListener;
/*     */ import java.beans.PropertyChangeSupport;
/*     */ import java.beans.PropertyDescriptor;
/*     */ import java.beans.PropertyEditorSupport;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.InputStream;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.swing.JOptionPane;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PropertyDescriptorsHolder
/*     */   implements PropertyChangeListener
/*     */ {
/*     */   public static final String OK = "ok";
/*     */   private Map<String, PropertyEditorSupport> editorsCash;
/*     */   private Map<String, PropertyDescriptor> descriptorsCash;
/*     */   private PropertyDescriptor[] descriptorsCashArray;
/*     */   private Map<Class, Class> additionalDescriptor;
/*     */   private BeanInfo info;
/*     */   private Object bean;
/*     */   private boolean beanAttached;
/*     */   private PropertyChangeSupport changeSupport;
/*     */   
/*     */   public PropertyDescriptorsHolder(BeanInfo beanInfo)
/*     */     throws IntrospectionException
/*     */   {
/*  51 */     this(beanInfo, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public PropertyDescriptorsHolder(BeanInfo beanInfo, Object bean)
/*     */     throws IntrospectionException
/*     */   {
/*  60 */     this.editorsCash = new HashMap();
/*  61 */     this.descriptorsCash = new HashMap();
/*  62 */     this.changeSupport = new PropertyChangeSupport(this);
/*  63 */     initializeAdditionalDescriptors();
/*  64 */     setBeanInfo(beanInfo);
/*  65 */     initialize(beanInfo);
/*  66 */     prepareForBean(bean);
/*  67 */     getBeanInfo().getPropertyDescriptors();
/*     */   }
/*     */   
/*     */   private void initializeAdditionalDescriptors() {
/*  71 */     this.additionalDescriptor = new HashMap();
/*  72 */     this.additionalDescriptor.put(String.class, StringEditor.class);
/*  73 */     this.additionalDescriptor.put(Boolean.TYPE, BooleanEditorFoo.class);
/*  74 */     this.additionalDescriptor.put(Boolean.class, BooleanEditorFoo.class);
/*     */   }
/*     */   
/*     */   private Class getAdditionalDescriptorClass(Class key) {
/*  78 */     return (Class)this.additionalDescriptor.get(key);
/*     */   }
/*     */   
/*     */   private void initialize(BeanInfo beanInfo) {
/*  82 */     PropertyDescriptor[] descriptors = getBeanInfo().getPropertyDescriptors();
/*  83 */     for (PropertyDescriptor elem : descriptors) {
/*  84 */       Class editorClass = elem.getPropertyEditorClass();
/*  85 */       if (editorClass == null) {
/*  86 */         editorClass = getAdditionalDescriptorClass(elem.getReadMethod().getReturnType());
/*     */       }
/*  88 */       if (editorClass != null) {
/*  89 */         createPropertyEditor(elem.getName(), editorClass);
/*  90 */         registerDescriptor(elem);
/*     */       }
/*     */     }
/*  93 */     this.descriptorsCashArray = ((PropertyDescriptor[])this.descriptorsCash.values().toArray(new PropertyDescriptor[this.descriptorsCash.size()]));
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
/*     */   public static boolean isBooleanDescriptor(PropertyDescriptor propertyDescriptor)
/*     */   {
/* 106 */     Class type = propertyDescriptor.getReadMethod().getReturnType();
/* 107 */     return (type == Boolean.TYPE) || (type == Boolean.class);
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
/*     */   public static boolean isStringDescriptor(PropertyDescriptor propertyDescriptor)
/*     */   {
/* 120 */     Class type = propertyDescriptor.getReadMethod().getReturnType();
/* 121 */     return type == String.class;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void prepareForBean(Object bean)
/*     */   {
/* 130 */     if (bean == null) return;
/* 131 */     setBeanAttached(false);
/* 132 */     testBean(bean);
/* 133 */     this.bean = bean;
/* 134 */     PropertyDescriptor[] descriptors = getPropertyDescriptors();
/* 135 */     PropertyEditorSupport editor = null;
/* 136 */     for (PropertyDescriptor elem : descriptors) {
/*     */       try {
/* 138 */         editor = getPropertyEditor(elem.getName());
/* 139 */         editor.setValue(elem.getReadMethod().invoke(bean, new Object[0]));
/* 140 */         editor.firePropertyChange();
/*     */       } catch (Exception ex) {
/* 142 */         showExeption(ex);
/*     */       }
/*     */     }
/* 145 */     setBeanAttached(true);
/*     */   }
/*     */   
/*     */   private void testBean(Object bean) {
/* 149 */     String mustHaveInfo = bean.getClass().getName() + "BeanInfo";
/* 150 */     if (!mustHaveInfo.equals(getBeanInfo().getClass().getName())) {
/* 151 */       throw new RuntimeException("Incorrect Bean class name (" + getBeanInfo().getClass().getName() + ')');
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
/*     */ 
/*     */ 
/*     */   public PropertyEditorSupport getPropertyEditor(String property)
/*     */   {
/* 166 */     return (PropertyEditorSupport)this.editorsCash.get(property);
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
/*     */   public PropertyDescriptor getPropertydescriptor(String property)
/*     */   {
/* 179 */     return (PropertyDescriptor)this.descriptorsCash.get(property);
/*     */   }
/*     */   
/*     */   private void registerDescriptor(PropertyDescriptor descr) {
/* 183 */     this.descriptorsCash.put(descr.getName(), descr);
/*     */   }
/*     */   
/*     */   private void createPropertyEditor(String property, Class editorClass) {
/* 187 */     if (this.editorsCash.containsKey(property)) {
/* 188 */       return;
/*     */     }
/*     */     try
/*     */     {
/* 192 */       PropertyEditorSupport newEditor = (PropertyEditorSupport)Class.forName(editorClass.getName()).newInstance();
/*     */       
/* 194 */       newEditor.addPropertyChangeListener(this);
/* 195 */       this.editorsCash.put(property, newEditor);
/* 196 */       return;
/*     */     } catch (Exception ex) {
/* 198 */       showExeption(ex);
/*     */     }
/*     */   }
/*     */   
/*     */   private Object getProperty(String name)
/*     */   {
/* 204 */     PropertyDescriptor descriptor = getPropertydescriptor(name);
/*     */     try {
/* 206 */       return descriptor.getReadMethod().invoke(this.bean, new Object[0]);
/*     */     } catch (Exception ex) {
/* 208 */       showExeption(ex); }
/* 209 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void propertyChange(PropertyChangeEvent evt)
/*     */   {
/* 220 */     if (!isBeanAttached()) return;
/* 221 */     PropertyDescriptor[] descriptors = getBeanInfo().getPropertyDescriptors();
/* 222 */     PropertyEditorSupport editor = null;
/* 223 */     for (PropertyDescriptor elem : descriptors)
/* 224 */       if (elem.getWriteMethod() != null) {
/* 225 */         editor = getPropertyEditor(elem.getName());
/* 226 */         if (evt.getSource() == editor)
/*     */           try {
/* 228 */             elem.getWriteMethod().invoke(this.bean, new Object[] { editor.getValue() });
/* 229 */             firePropertyChange(elem.getName(), null, null);
/*     */           } catch (Exception ex) {
/* 231 */             setProperty(this.bean, elem.getName(), getProperty(elem.getName()));
/* 232 */             showExeption(ex);
/*     */           }
/*     */       }
/*     */   }
/*     */   
/*     */   private void showExeption(Exception ex) {
/* 238 */     Throwable cause = ex;
/* 239 */     while (cause.getCause() != null) {
/* 240 */       cause = cause.getCause();
/*     */     }
/* 242 */     JOptionPane.showMessageDialog(null, "<html>" + cause.getMessage() + "<br>(<i>" + cause.getClass().getName() + "</i>)", LocaleUtils.getErrorsLocaleString("Exception"), 0);
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
/*     */   public int getPropertyCount()
/*     */   {
/* 256 */     return this.descriptorsCash.size();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public PropertyDescriptor[] getPropertyDescriptors()
/*     */   {
/* 265 */     return this.descriptorsCashArray;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isBeanAttached()
/*     */   {
/* 275 */     return this.beanAttached;
/*     */   }
/*     */   
/*     */   private void setBeanAttached(boolean beanAttached) {
/* 279 */     this.beanAttached = beanAttached;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public BeanInfo getBeanInfo()
/*     */   {
/* 288 */     return this.info;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBeanInfo(BeanInfo info)
/*     */   {
/* 297 */     this.info = info;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String writeToFile(File file)
/*     */   {
/*     */     try
/*     */     {
/* 307 */       ObjectOutputStream dataOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
/*     */       
/*     */ 
/* 310 */       PropertyPair[] pairs = new PropertyPair[this.editorsCash.size()];
/* 311 */       int i = 0;
/* 312 */       for (String elem : this.editorsCash.keySet()) {
/* 313 */         pairs[i] = new PropertyPair(elem, ((PropertyEditorSupport)this.editorsCash.get(elem)).getValue());
/* 314 */         i++;
/*     */       }
/* 316 */       dataOut.writeObject(pairs);
/* 317 */       dataOut.flush();
/* 318 */       dataOut.close();
/* 319 */       return "ok";
/*     */     } catch (Exception ex) {
/* 321 */       return ex.getClass().getName() + " : " + ex.getMessage();
/*     */     }
/*     */   }
/*     */   
/*     */   private void setProperty(Object bean, String name, Object value) {
/* 326 */     getPropertyEditor(name).setValue(value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String readFromStream(InputStream from)
/*     */   {
/*     */     try
/*     */     {
/* 338 */       ObjectInputStream dataIn = new ObjectInputStream(new BufferedInputStream(from));
/*     */       
/* 340 */       PropertyPair[] pairs = (PropertyPair[])dataIn.readObject();
/* 341 */       for (PropertyPair pair : pairs) {
/* 342 */         setProperty(this.bean, pair.propertyName, pair.propertyValue);
/*     */       }
/* 344 */       dataIn.close();
/* 345 */       return "ok";
/*     */     } catch (Exception ex) {
/* 347 */       return ex.getClass().getName() + " : " + ex.getMessage();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String readFromFile(File file)
/*     */   {
/*     */     try
/*     */     {
/* 358 */       return readFromStream(new FileInputStream(file));
/*     */     } catch (FileNotFoundException ex) {
/* 360 */       return ex.getClass().getName() + " : " + ex.getMessage();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addPropertyChangeListener(PropertyChangeListener listener)
/*     */   {
/* 369 */     this.changeSupport.addPropertyChangeListener(listener);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void removePropertyChangeListener(PropertyChangeListener listener)
/*     */   {
/* 377 */     this.changeSupport.removePropertyChangeListener(listener);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void firePropertyChange(String name, Object oldVal, Object newVal)
/*     */   {
/* 385 */     this.changeSupport.firePropertyChange(name, oldVal, newVal);
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/customizer/PropertyDescriptorsHolder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */