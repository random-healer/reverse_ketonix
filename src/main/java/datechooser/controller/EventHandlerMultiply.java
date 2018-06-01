/*    */ package datechooser.controller;
/*    */ 
/*    */ import datechooser.model.multiple.MultyDateChooseModel;
/*    */ import datechooser.model.multiple.MultySelectModes;
/*    */ import datechooser.view.GridPane;
/*    */ import java.awt.event.KeyEvent;
/*    */ import java.awt.event.MouseEvent;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EventHandlerMultiply
/*    */   extends EventHandler
/*    */ {
/*    */   public EventHandlerMultiply() {}
/*    */   
/*    */   private void setSelectionModes(int modifiers)
/*    */   {
/* 30 */     if (isDragging()) {
/* 31 */       if (!isMask(modifiers, 64)) {
/* 32 */         if (!isDragStarted()) {
/* 33 */           setDragStarted(true);
/* 34 */           getModel().setMode(MultySelectModes.SINGLE, isMask(modifiers, 128));
/*    */           
/* 36 */           getModel().setPeriodSelectionStarted(false);
/*    */         } else {
/* 38 */           getModel().setMode(MultySelectModes.PERIOD, true);
/*    */         }
/*    */         
/*    */       }
/*    */     }
/* 43 */     else if ((isMask(modifiers, 64)) && (isMask(modifiers, 128)))
/*    */     {
/* 45 */       getModel().setMode(MultySelectModes.PERIOD, true);
/* 46 */       getModel().setPeriodSelectionStarted(true);
/*    */     }
/* 48 */     else if (isMask(modifiers, 64)) {
/* 49 */       getModel().setMode(MultySelectModes.PERIOD, false);
/* 50 */       getModel().setPeriodSelectionStarted(true);
/*    */     }
/* 52 */     else if (isMask(modifiers, 128)) {
/* 53 */       getModel().setMode(MultySelectModes.SINGLE, true);
/* 54 */       getModel().setPeriodSelectionStarted(false);
/*    */     } else {
/* 56 */       getModel().setMode(MultySelectModes.SINGLE, false);
/* 57 */       getModel().setPeriodSelectionStarted(false);
/*    */     }
/*    */   }
/*    */   
/*    */   protected void doSelect(MouseEvent e) {
/* 62 */     setSelectionModes(e.getModifiersEx());
/* 63 */     super.doSelect(e);
/*    */   }
/*    */   
/*    */   protected void doShift(KeyEvent e) {
/* 67 */     setSelectionModes(e.getModifiersEx());
/* 68 */     super.doShift(e);
/*    */   }
/*    */   
/*    */   public MultyDateChooseModel getModel() {
/* 72 */     return (MultyDateChooseModel)getView().getModel();
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/controller/EventHandlerMultiply.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */