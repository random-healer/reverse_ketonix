/*     */ package com.ketonix.ketonixpro;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Container;
/*     */ import java.awt.datatransfer.DataFlavor;
/*     */ import java.awt.datatransfer.Transferable;
/*     */ import java.awt.datatransfer.UnsupportedFlavorException;
/*     */ import java.awt.dnd.DropTarget;
/*     */ import java.awt.dnd.DropTargetContext;
/*     */ import java.awt.dnd.DropTargetDragEvent;
/*     */ import java.awt.dnd.DropTargetDropEvent;
/*     */ import java.awt.dnd.DropTargetEvent;
/*     */ import java.awt.dnd.DropTargetListener;
/*     */ import java.awt.event.HierarchyEvent;
/*     */ import java.awt.event.HierarchyListener;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URI;
/*     */ import java.util.ArrayList;
/*     */ import java.util.EventObject;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.TooManyListenersException;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.JComponent;
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
/*     */ public class FileDrop
/*     */ {
/*     */   private transient Border normalBorder;
/*     */   private transient DropTargetListener dropListener;
/*     */   private static Boolean supportsDnD;
/*  61 */   private static Color defaultBorderColor = new Color(0.0F, 0.0F, 1.0F, 0.25F);
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
/*     */   public FileDrop(Component c, Listener listener)
/*     */   {
/*  76 */     this(null, c, 
/*     */     
/*  78 */       BorderFactory.createMatteBorder(2, 2, 2, 2, defaultBorderColor), true, listener);
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
/*     */   public FileDrop(Component c, boolean recursive, Listener listener)
/*     */   {
/* 100 */     this(null, c, 
/*     */     
/* 102 */       BorderFactory.createMatteBorder(2, 2, 2, 2, defaultBorderColor), recursive, listener);
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
/*     */   public FileDrop(PrintStream out, Component c, Listener listener)
/*     */   {
/* 125 */     this(out, c, 
/*     */     
/* 127 */       BorderFactory.createMatteBorder(2, 2, 2, 2, defaultBorderColor), false, listener);
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
/*     */   public FileDrop(PrintStream out, Component c, boolean recursive, Listener listener)
/*     */   {
/* 156 */     this(out, c, 
/*     */     
/* 158 */       BorderFactory.createMatteBorder(2, 2, 2, 2, defaultBorderColor), recursive, listener);
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
/*     */   public FileDrop(Component c, Border dragBorder, Listener listener)
/*     */   {
/* 178 */     this(null, c, dragBorder, false, listener);
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
/*     */   public FileDrop(Component c, Border dragBorder, boolean recursive, Listener listener)
/*     */   {
/* 205 */     this(null, c, dragBorder, recursive, listener);
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
/*     */   public FileDrop(PrintStream out, Component c, Border dragBorder, Listener listener)
/*     */   {
/* 233 */     this(out, c, dragBorder, false, listener);
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
/*     */   public FileDrop(final PrintStream out, final Component c, final Border dragBorder, boolean recursive, final Listener listener)
/*     */   {
/* 267 */     if (supportsDnD())
/*     */     {
/* 269 */       this.dropListener = new DropTargetListener() {
/*     */         public void dragEnter(DropTargetDragEvent evt) {
/* 271 */           FileDrop.log(out, "FileDrop: dragEnter event.");
/*     */           
/*     */ 
/* 274 */           if (FileDrop.this.isDragOk(out, evt))
/*     */           {
/*     */ 
/* 277 */             if ((c instanceof JComponent)) {
/* 278 */               JComponent jc = (JComponent)c;
/* 279 */               FileDrop.this.normalBorder = jc.getBorder();
/* 280 */               FileDrop.log(out, "FileDrop: normal border saved.");
/* 281 */               jc.setBorder(dragBorder);
/* 282 */               FileDrop.log(out, "FileDrop: drag border set.");
/*     */             }
/*     */             
/*     */ 
/*     */ 
/* 287 */             evt.acceptDrag(1);
/* 288 */             FileDrop.log(out, "FileDrop: event accepted.");
/*     */           }
/*     */           else
/*     */           {
/* 292 */             evt.rejectDrag();
/* 293 */             FileDrop.log(out, "FileDrop: event rejected.");
/*     */           }
/*     */         }
/*     */         
/*     */ 
/*     */         public void dragOver(DropTargetDragEvent evt) {}
/*     */         
/*     */ 
/*     */         public void drop(DropTargetDropEvent evt)
/*     */         {
/* 303 */           FileDrop.log(out, "FileDrop: drop event.");
/*     */           try
/*     */           {
/* 306 */             Transferable tr = evt.getTransferable();
/*     */             
/*     */ 
/* 309 */             if (tr.isDataFlavorSupported(DataFlavor.javaFileListFlavor))
/*     */             {
/*     */ 
/*     */ 
/* 313 */               evt.acceptDrop(1);
/* 314 */               FileDrop.log(out, "FileDrop: file list accepted.");
/*     */               
/*     */ 
/*     */ 
/* 318 */               List fileList = (List)tr.getTransferData(DataFlavor.javaFileListFlavor);
/* 319 */               Iterator iterator = fileList.iterator();
/*     */               
/*     */ 
/* 322 */               File[] filesTemp = new File[fileList.size()];
/* 323 */               fileList.toArray(filesTemp);
/* 324 */               File[] files = filesTemp;
/*     */               
/*     */ 
/* 327 */               if (listener != null) {
/* 328 */                 listener.filesDropped(files);
/*     */               }
/*     */               
/* 331 */               evt.getDropTargetContext().dropComplete(true);
/* 332 */               FileDrop.log(out, "FileDrop: drop complete.");
/*     */ 
/*     */             }
/*     */             else
/*     */             {
/*     */ 
/* 338 */               DataFlavor[] flavors = tr.getTransferDataFlavors();
/* 339 */               boolean handled = false;
/* 340 */               for (int zz = 0; zz < flavors.length; zz++) {
/* 341 */                 if (flavors[zz].isRepresentationClassReader())
/*     */                 {
/*     */ 
/* 344 */                   evt.acceptDrop(1);
/* 345 */                   FileDrop.log(out, "FileDrop: reader accepted.");
/*     */                   
/* 347 */                   Reader reader = flavors[zz].getReaderForText(tr);
/*     */                   
/* 349 */                   BufferedReader br = new BufferedReader(reader);
/*     */                   
/* 351 */                   if (listener != null) {
/* 352 */                     listener.filesDropped(FileDrop.createFileArray(br, out));
/*     */                   }
/*     */                   
/* 355 */                   evt.getDropTargetContext().dropComplete(true);
/* 356 */                   FileDrop.log(out, "FileDrop: drop complete.");
/* 357 */                   handled = true;
/* 358 */                   break;
/*     */                 }
/*     */               }
/* 361 */               if (!handled) {
/* 362 */                 FileDrop.log(out, "FileDrop: not a file list or reader - abort.");
/* 363 */                 evt.rejectDrop();
/*     */               }
/*     */             }
/*     */           }
/*     */           catch (IOException io) {
/*     */             JComponent jc;
/* 369 */             FileDrop.log(out, "FileDrop: IOException - abort:");
/* 370 */             io.printStackTrace(out);
/* 371 */             evt.rejectDrop();
/*     */           } catch (UnsupportedFlavorException ufe) {
/*     */             JComponent jc;
/* 374 */             FileDrop.log(out, "FileDrop: UnsupportedFlavorException - abort:");
/* 375 */             ufe.printStackTrace(out);
/* 376 */             evt.rejectDrop();
/*     */           }
/*     */           finally
/*     */           {
/*     */             JComponent jc;
/* 381 */             if ((c instanceof JComponent)) {
/* 382 */               JComponent jc = (JComponent)c;
/* 383 */               jc.setBorder(FileDrop.this.normalBorder);
/* 384 */               FileDrop.log(out, "FileDrop: normal border restored.");
/*     */             }
/*     */           }
/*     */         }
/*     */         
/*     */         public void dragExit(DropTargetEvent evt) {
/* 390 */           FileDrop.log(out, "FileDrop: dragExit event.");
/*     */           
/* 392 */           if ((c instanceof JComponent)) {
/* 393 */             JComponent jc = (JComponent)c;
/* 394 */             jc.setBorder(FileDrop.this.normalBorder);
/* 395 */             FileDrop.log(out, "FileDrop: normal border restored.");
/*     */           }
/*     */         }
/*     */         
/*     */         public void dropActionChanged(DropTargetDragEvent evt) {
/* 400 */           FileDrop.log(out, "FileDrop: dropActionChanged event.");
/*     */           
/* 402 */           if (FileDrop.this.isDragOk(out, evt))
/*     */           {
/* 404 */             evt.acceptDrag(1);
/* 405 */             FileDrop.log(out, "FileDrop: event accepted.");
/*     */           }
/*     */           else {
/* 408 */             evt.rejectDrag();
/* 409 */             FileDrop.log(out, "FileDrop: event rejected.");
/*     */           }
/*     */           
/*     */         }
/*     */         
/* 414 */       };
/* 415 */       makeDropTarget(out, c, recursive);
/*     */     }
/*     */     else {
/* 418 */       log(out, "FileDrop: Drag and drop is not supported with this JVM");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static boolean supportsDnD()
/*     */   {
/* 425 */     if (supportsDnD == null)
/*     */     {
/* 427 */       boolean support = false;
/*     */       try {
/* 429 */         Class arbitraryDndClass = Class.forName("java.awt.dnd.DnDConstants");
/* 430 */         support = true;
/*     */       }
/*     */       catch (Exception e) {
/* 433 */         support = false;
/*     */       }
/* 435 */       supportsDnD = new Boolean(support);
/*     */     }
/* 437 */     return supportsDnD.booleanValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/* 442 */   private static String ZERO_CHAR_STRING = "\000";
/*     */   
/*     */   private static File[] createFileArray(BufferedReader bReader, PrintStream out) {
/*     */     try {
/* 446 */       List list = new ArrayList();
/* 447 */       String line = null;
/* 448 */       while ((line = bReader.readLine()) != null) {
/*     */         try
/*     */         {
/* 451 */           if (!ZERO_CHAR_STRING.equals(line))
/*     */           {
/* 453 */             File file = new File(new URI(line));
/* 454 */             list.add(file);
/*     */           }
/* 456 */         } catch (Exception ex) { log(out, "Error with " + line + ": " + ex.getMessage());
/*     */         }
/*     */       }
/*     */       
/* 460 */       return (File[])list.toArray(new File[list.size()]);
/*     */     } catch (IOException ex) {
/* 462 */       log(out, "FileDrop: IOException");
/*     */     }
/* 464 */     return new File[0];
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void makeDropTarget(final PrintStream out, final Component c, boolean recursive)
/*     */   {
/* 472 */     DropTarget dt = new DropTarget();
/*     */     try {
/* 474 */       dt.addDropTargetListener(this.dropListener);
/*     */     }
/*     */     catch (TooManyListenersException e) {
/* 477 */       e.printStackTrace();
/* 478 */       log(out, "FileDrop: Drop will not work due to previous error. Do you have another listener attached?");
/*     */     }
/*     */     
/*     */ 
/* 482 */     c.addHierarchyListener(new HierarchyListener() {
/*     */       public void hierarchyChanged(HierarchyEvent evt) {
/* 484 */         FileDrop.log(out, "FileDrop: Hierarchy changed.");
/* 485 */         Component parent = c.getParent();
/* 486 */         if (parent == null) {
/* 487 */           c.setDropTarget(null);
/* 488 */           FileDrop.log(out, "FileDrop: Drop target cleared from component.");
/*     */         }
/*     */         else {
/* 491 */           new DropTarget(c, FileDrop.this.dropListener);
/* 492 */           FileDrop.log(out, "FileDrop: Drop target added to component.");
/*     */         }
/*     */       }
/*     */     });
/* 496 */     if (c.getParent() != null) {
/* 497 */       new DropTarget(c, this.dropListener);
/*     */     }
/* 499 */     if ((recursive) && ((c instanceof Container)))
/*     */     {
/*     */ 
/* 502 */       Container cont = (Container)c;
/*     */       
/*     */ 
/* 505 */       Component[] comps = cont.getComponents();
/*     */       
/*     */ 
/* 508 */       for (int i = 0; i < comps.length; i++) {
/* 509 */         makeDropTarget(out, comps[i], recursive);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean isDragOk(PrintStream out, DropTargetDragEvent evt)
/*     */   {
/* 517 */     boolean ok = false;
/*     */     
/*     */ 
/* 520 */     DataFlavor[] flavors = evt.getCurrentDataFlavors();
/*     */     
/*     */ 
/* 523 */     int i = 0;
/* 524 */     while ((!ok) && (i < flavors.length))
/*     */     {
/*     */ 
/*     */ 
/* 528 */       DataFlavor curFlavor = flavors[i];
/* 529 */       if ((curFlavor.equals(DataFlavor.javaFileListFlavor)) || 
/* 530 */         (curFlavor.isRepresentationClassReader())) {
/* 531 */         ok = true;
/*     */       }
/*     */       
/* 534 */       i++;
/*     */     }
/*     */     
/*     */ 
/* 538 */     if (out != null) {
/* 539 */       if (flavors.length == 0)
/* 540 */         log(out, "FileDrop: no data flavors.");
/* 541 */       for (i = 0; i < flavors.length; i++) {
/* 542 */         log(out, flavors[i].toString());
/*     */       }
/*     */     }
/* 545 */     return ok;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static void log(PrintStream out, String message)
/*     */   {
/* 552 */     if (out != null) {
/* 553 */       out.println(message);
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
/*     */ 
/*     */ 
/*     */   public static boolean remove(Component c)
/*     */   {
/* 570 */     return remove(null, c, true);
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
/*     */   public static boolean remove(PrintStream out, Component c, boolean recursive)
/*     */   {
/* 587 */     if (supportsDnD()) {
/* 588 */       log(out, "FileDrop: Removing drag-and-drop hooks.");
/* 589 */       c.setDropTarget(null);
/* 590 */       if ((recursive) && ((c instanceof Container))) {
/* 591 */         Component[] comps = ((Container)c).getComponents();
/* 592 */         for (int i = 0; i < comps.length; i++)
/* 593 */           remove(out, comps[i], recursive);
/* 594 */         return true;
/*     */       }
/* 596 */       return false;
/*     */     }
/* 598 */     return false;
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
/*     */   public static abstract interface Listener
/*     */   {
/*     */     public abstract void filesDropped(File[] paramArrayOfFile);
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
/*     */   public static class Event
/*     */     extends EventObject
/*     */   {
/*     */     private File[] files;
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
/*     */     public Event(File[] files, Object source)
/*     */     {
/* 665 */       super();
/* 666 */       this.files = files;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public File[] getFiles()
/*     */     {
/* 677 */       return this.files;
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
/*     */   public static class TransferableObject
/*     */     implements Transferable
/*     */   {
/*     */     public static final String MIME_TYPE = "application/x-net.iharder.dnd.TransferableObject";
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
/* 749 */     public static final DataFlavor DATA_FLAVOR = new DataFlavor(TransferableObject.class, "application/x-net.iharder.dnd.TransferableObject");
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     private Fetcher fetcher;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     private Object data;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     private DataFlavor customFlavor;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public TransferableObject(Object data)
/*     */     {
/* 771 */       this.data = data;
/* 772 */       this.customFlavor = new DataFlavor(data.getClass(), "application/x-net.iharder.dnd.TransferableObject");
/*     */     }
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
/*     */     public TransferableObject(Fetcher fetcher)
/*     */     {
/* 788 */       this.fetcher = fetcher;
/*     */     }
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
/*     */     public TransferableObject(Class dataClass, Fetcher fetcher)
/*     */     {
/* 807 */       this.fetcher = fetcher;
/* 808 */       this.customFlavor = new DataFlavor(dataClass, "application/x-net.iharder.dnd.TransferableObject");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public DataFlavor getCustomDataFlavor()
/*     */     {
/* 820 */       return this.customFlavor;
/*     */     }
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
/*     */     public DataFlavor[] getTransferDataFlavors()
/*     */     {
/* 839 */       if (this.customFlavor != null) {
/* 840 */         return new DataFlavor[] { this.customFlavor, DATA_FLAVOR, DataFlavor.stringFlavor };
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 846 */       return new DataFlavor[] { DATA_FLAVOR, DataFlavor.stringFlavor };
/*     */     }
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
/*     */     public Object getTransferData(DataFlavor flavor)
/*     */       throws UnsupportedFlavorException, IOException
/*     */     {
/* 869 */       if (flavor.equals(DATA_FLAVOR)) {
/* 870 */         return this.fetcher == null ? this.data : this.fetcher.getObject();
/*     */       }
/*     */       
/* 873 */       if (flavor.equals(DataFlavor.stringFlavor)) {
/* 874 */         return this.fetcher == null ? this.data.toString() : this.fetcher.getObject().toString();
/*     */       }
/*     */       
/* 877 */       throw new UnsupportedFlavorException(flavor);
/*     */     }
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
/*     */     public boolean isDataFlavorSupported(DataFlavor flavor)
/*     */     {
/* 894 */       if (flavor.equals(DATA_FLAVOR)) {
/* 895 */         return true;
/*     */       }
/*     */       
/* 898 */       if (flavor.equals(DataFlavor.stringFlavor)) {
/* 899 */         return true;
/*     */       }
/*     */       
/* 902 */       return false;
/*     */     }
/*     */     
/*     */     public static abstract interface Fetcher
/*     */     {
/*     */       public abstract Object getObject();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/com/ketonix/ketonixpro/FileDrop.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */