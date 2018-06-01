/*    */ package datechooser.beans.editor.descriptor;
/*    */ 
/*    */ import datechooser.view.BackRenderer;
/*    */ import java.net.URL;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BackRendererDescriptor
/*    */   extends ClassDescriptor
/*    */ {
/*    */   public BackRendererDescriptor() {}
/*    */   
/*    */   public Class getDescriptedClass()
/*    */   {
/* 23 */     return BackRenderer.class;
/*    */   }
/*    */   
/*    */   public String getJavaDescription(Object value) {
/* 27 */     BackRenderer renderer = (BackRenderer)value;
/* 28 */     StringBuffer descr = new StringBuffer("new ");
/* 29 */     descr.append(getClassName());
/* 30 */     descr.append("( " + renderer.getStyle());
/* 31 */     descr.append(getSeparator());
/* 32 */     descr.append('"');
/* 33 */     descr.append(renderer.getUrl().getFile());
/* 34 */     descr.append("\")");
/* 35 */     return descr.toString();
/*    */   }
/*    */   
/*    */   public String getDescription(Object value) {
/* 39 */     return ((BackRenderer)value).getUrl().getPath();
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/descriptor/BackRendererDescriptor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */