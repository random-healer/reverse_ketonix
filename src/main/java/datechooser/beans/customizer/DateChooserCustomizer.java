/*     */ package datechooser.beans.customizer;
/*     */ 
/*     */ import datechooser.beans.customizer.edit.PropertyCellEditor;
/*     */ import datechooser.beans.customizer.render.CaptionCellRenderer;
/*     */ import datechooser.beans.customizer.render.ValueCellRenderer;
/*     */ import java.awt.BorderLayout;
/*     */ import java.beans.BeanInfo;
/*     */ import java.beans.Customizer;
/*     */ import java.beans.IntrospectionException;
/*     */ import java.beans.PropertyChangeEvent;
/*     */ import java.beans.PropertyChangeListener;
/*     */ import java.beans.PropertyChangeSupport;
/*     */ import java.beans.PropertyDescriptor;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.ListSelectionModel;
/*     */ import javax.swing.event.ListSelectionEvent;
/*     */ import javax.swing.event.ListSelectionListener;
/*     */ import javax.swing.table.TableColumn;
/*     */ import javax.swing.table.TableColumnModel;
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
/*     */ public class DateChooserCustomizer
/*     */   extends JPanel
/*     */   implements Customizer, PropertyChangeListener
/*     */ {
/*     */   private PropertyDescriptorsHolder holder;
/*     */   private JTextArea description;
/*     */   private PropertyChangeSupport changeSupport;
/*     */   private JTable table;
/*     */   
/*     */   public DateChooserCustomizer(BeanInfo beanInfo)
/*     */     throws IntrospectionException
/*     */   {
/*  55 */     this.changeSupport = new PropertyChangeSupport(this);
/*     */     
/*  57 */     this.holder = new PropertyDescriptorsHolder(beanInfo);
/*  58 */     getHolder().addPropertyChangeListener(this);
/*  59 */     setLayout(new BorderLayout(2, 2));
/*     */     
/*  61 */     this.description = new JTextArea("");
/*  62 */     this.description.setRows(2);
/*  63 */     this.description.setEditable(false);
/*  64 */     this.description.setWrapStyleWord(true);
/*  65 */     this.description.setLineWrap(true);
/*  66 */     this.description.setOpaque(false);
/*     */     
/*  68 */     this.table = new JTable(new PropertyTableModel(getHolder()));
/*  69 */     this.table.setRowHeight(20);
/*  70 */     this.table.setSelectionMode(0);
/*  71 */     this.table.getColumnModel().getColumn(1).setCellEditor(new PropertyCellEditor(getHolder()));
/*  72 */     this.table.setDefaultRenderer(CaptionCellRenderer.class, new CaptionCellRenderer(getHolder()));
/*  73 */     this.table.setDefaultRenderer(ValueCellRenderer.class, new ValueCellRenderer(getHolder()));
/*  74 */     this.table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
/*     */       public void valueChanged(ListSelectionEvent e) {
/*  76 */         DateChooserCustomizer.this.updateDescriptor();
/*     */       }
/*  78 */     });
/*  79 */     add(new JScrollPane(this.table), "Center");
/*  80 */     add(new JScrollPane(this.description), "South");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public BeanInfo getBeanInfo()
/*     */   {
/*  91 */     return getHolder().getBeanInfo();
/*     */   }
/*     */   
/*     */   private void updateDescriptor() {
/*  95 */     PropertyDescriptor propDescr = getHolder().getPropertydescriptor(getSelectedProperty());
/*  96 */     String text = propDescr.getShortDescription();
/*  97 */     if (text == null) text = propDescr.getDisplayName();
/*  98 */     if (text == null) text = propDescr.getName();
/*  99 */     this.description.setText(text);
/*     */   }
/*     */   
/*     */   private String getSelectedProperty() {
/* 103 */     return (String)this.table.getValueAt(this.table.getSelectedRow(), 0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setObject(Object bean)
/*     */   {
/* 114 */     getHolder().prepareForBean(bean);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public PropertyDescriptorsHolder getHolder()
/*     */   {
/* 123 */     return this.holder;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void propertyChange(PropertyChangeEvent evt)
/*     */   {
/* 131 */     this.changeSupport.firePropertyChange(evt.getPropertyName(), evt.getOldValue(), evt.getNewValue());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addPropertyChangeListener(PropertyChangeListener listener)
/*     */   {
/* 139 */     this.changeSupport.addPropertyChangeListener(listener);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void removePropertyChangeListener(PropertyChangeListener listener)
/*     */   {
/* 147 */     this.changeSupport.removePropertyChangeListener(listener);
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/customizer/DateChooserCustomizer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */