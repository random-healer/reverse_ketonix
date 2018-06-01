/*     */ package datechooser.controller;
/*     */ 
/*     */ import datechooser.model.DateChoose;
/*     */ import datechooser.view.GridPane;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.KeyListener;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseListener;
/*     */ import java.awt.event.MouseMotionListener;
/*     */ import java.awt.event.MouseWheelEvent;
/*     */ import java.awt.event.MouseWheelListener;
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
/*     */ public class EventHandler
/*     */   implements MouseListener, MouseMotionListener, KeyListener, DateChooseController, MouseWheelListener, Serializable
/*     */ {
/*     */   private Rectangle gridBounds;
/*     */   private GridSelection tempSel;
/*     */   private GridPane view;
/*     */   private boolean mouseDown;
/*     */   private boolean dragging;
/*     */   private boolean dragStarted;
/*     */   private boolean autoScroll;
/*     */   private int previousLocation;
/*     */   private int previousKey;
/*     */   private long previousTime;
/*     */   
/*     */   public EventHandler()
/*     */   {
/*  52 */     this.tempSel = new GridSelection();
/*  53 */     this.mouseDown = false;
/*  54 */     setDragging(false);
/*  55 */     setDragStarted(false);
/*  56 */     this.previousLocation = 0;
/*  57 */     this.previousKey = 0;
/*  58 */     this.previousTime = 0L;
/*     */   }
/*     */   
/*     */   public void reBound() {
/*  62 */     this.gridBounds = getView().getBounds();
/*     */   }
/*     */   
/*     */   private GridSelection getCell(int x, int y) {
/*  66 */     this.tempSel.setColumn(x / (this.gridBounds.width / getView().getModel().getColsCount()));
/*     */     
/*  68 */     this.tempSel.setRow(y / (this.gridBounds.height / (getView().getModel().getRowsCount() + 1)));
/*     */     
/*  70 */     return this.tempSel;
/*     */   }
/*     */   
/*     */   protected void doSelect(MouseEvent e) {
/*  74 */     GridSelection sel = getCell(e.getX(), e.getY());
/*  75 */     if (sel.getRow() == 0) return;
/*  76 */     if ((getModel().select(sel.getRow() - 1, sel.getColumn())) && 
/*  77 */       (!isMask(e.getModifiersEx(), 512))) {
/*  78 */       getModel().tryApplySelection();
/*     */     }
/*     */     
/*  81 */     getView().requestFocus();
/*     */   }
/*     */   
/*     */   public void mouseClicked(MouseEvent e) {
/*  85 */     if (e.getClickCount() > 1) {
/*  86 */       getModel().commit();
/*  87 */       return;
/*     */     }
/*  89 */     doSelect(e);
/*     */   }
/*     */   
/*     */   public void mousePressed(MouseEvent e) {}
/*     */   
/*     */   public void mouseReleased(MouseEvent e)
/*     */   {
/*  96 */     setDragging(false);
/*  97 */     setDragStarted(false);
/*     */   }
/*     */   
/*     */   public void mouseEntered(MouseEvent e) {}
/*     */   
/*     */   public void mouseExited(MouseEvent e)
/*     */   {
/* 104 */     setDragging(false);
/* 105 */     setDragStarted(false);
/*     */   }
/*     */   
/*     */   public void mouseDragged(MouseEvent e) {
/* 109 */     setDragging(true);
/* 110 */     doSelect(e);
/*     */   }
/*     */   
/*     */   public void mouseMoved(MouseEvent e) {}
/*     */   
/*     */   public void setView(GridPane palette)
/*     */   {
/* 117 */     this.view = palette;
/* 118 */     palette.addMouseListener(this);
/* 119 */     palette.addMouseMotionListener(this);
/* 120 */     palette.addKeyListener(this);
/* 121 */     palette.addMouseWheelListener(this);
/*     */   }
/*     */   
/*     */   public GridPane getView() {
/* 125 */     return this.view;
/*     */   }
/*     */   
/*     */   public DateChoose getModel() {
/* 129 */     return getView().getModel();
/*     */   }
/*     */   
/*     */   private boolean isDuplet(int key, int keyLocation)
/*     */   {
/* 134 */     if (this.previousTime == 0L) {
/* 135 */       this.previousTime = System.currentTimeMillis();
/* 136 */     } else if (System.currentTimeMillis() - this.previousTime > 130L) {
/* 137 */       this.previousTime = System.currentTimeMillis();
/* 138 */       this.previousKey = key;
/* 139 */       this.previousLocation = keyLocation;
/* 140 */       return false;
/*     */     }
/* 142 */     boolean result = (key == this.previousKey) && (keyLocation != this.previousLocation);
/* 143 */     if (!result) {
/* 144 */       this.previousKey = key;
/* 145 */       this.previousLocation = keyLocation;
/*     */     }
/* 147 */     return result;
/*     */   }
/*     */   
/*     */   protected void doShift(KeyEvent e) {
/* 151 */     int code = e.getKeyCode();
/*     */     
/*     */ 
/* 154 */     if (isDuplet(code, e.getKeyLocation())) { return;
/*     */     }
/* 156 */     switch (code) {
/*     */     case 38: 
/* 158 */       getModel().shift(-1, 0);
/* 159 */       break;
/*     */     case 40: 
/* 161 */       getModel().shift(1, 0);
/* 162 */       break;
/*     */     case 37: 
/* 164 */       getModel().shift(0, -1);
/* 165 */       break;
/*     */     case 39: 
/* 167 */       getModel().shift(0, 1);
/* 168 */       break;
/*     */     case 34: 
/* 170 */       getModel().monthShift(-1);
/* 171 */       break;
/*     */     case 33: 
/* 173 */       getModel().monthShift(1);
/* 174 */       break;
/*     */     case 35: 
/* 176 */       getModel().yearShift(-1);
/* 177 */       break;
/*     */     case 36: 
/* 179 */       getModel().yearShift(1);
/*     */     }
/*     */     
/*     */   }
/*     */   
/*     */   public void keyTyped(KeyEvent e) {}
/*     */   
/*     */   public void keyPressed(KeyEvent e)
/*     */   {
/* 188 */     doShift(e);
/*     */   }
/*     */   
/*     */   public void keyReleased(KeyEvent e) {
/* 192 */     if (e.getKeyCode() == 32) {
/* 193 */       getModel().tryApplySelection();
/*     */     }
/* 195 */     if (e.getKeyCode() == 10) {
/* 196 */       getModel().commit();
/*     */     }
/*     */   }
/*     */   
/*     */   protected boolean isDragging() {
/* 201 */     return this.dragging;
/*     */   }
/*     */   
/*     */   protected void setDragging(boolean dragging) {
/* 205 */     this.dragging = dragging;
/*     */   }
/*     */   
/*     */   protected boolean isDragStarted() {
/* 209 */     return this.dragStarted;
/*     */   }
/*     */   
/*     */   protected void setDragStarted(boolean dragStarted) {
/* 213 */     if ((!dragStarted) && (isDragStarted())) {
/* 214 */       onDragEnd();
/*     */     }
/* 216 */     this.dragStarted = dragStarted;
/* 217 */     if (dragStarted) {
/* 218 */       onDragStart();
/*     */     }
/*     */   }
/*     */   
/*     */   protected void onDragStart() {
/* 223 */     setAutoScroll(getModel().isAutoScroll());
/* 224 */     getModel().setAutoScroll(false);
/*     */   }
/*     */   
/*     */   protected void onDragEnd() {
/* 228 */     getModel().setAutoScroll(isAutoScroll());
/*     */   }
/*     */   
/*     */   public boolean isAutoScroll() {
/* 232 */     return this.autoScroll;
/*     */   }
/*     */   
/*     */   public void setAutoScroll(boolean autoScroll) {
/* 236 */     this.autoScroll = autoScroll;
/*     */   }
/*     */   
/*     */   public void mouseWheelMoved(MouseWheelEvent e) {
/* 240 */     getModel().shift(0, e.getWheelRotation() < 0 ? -1 : 1);
/*     */   }
/*     */   
/*     */   public static boolean isMask(int modifier, int mask)
/*     */   {
/* 245 */     return (modifier & mask) == mask;
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/controller/EventHandler.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */