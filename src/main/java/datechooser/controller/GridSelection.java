/*    */ package datechooser.controller;
/*    */ 
/*    */ import java.io.Serializable;
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
/*    */ public class GridSelection
/*    */   implements Serializable
/*    */ {
/*    */   private int row;
/*    */   private int column;
/*    */   
/*    */   public GridSelection()
/*    */   {
/* 24 */     this(0, 0);
/*    */   }
/*    */   
/*    */   public GridSelection(int row, int column) {
/* 28 */     set(row, column);
/*    */   }
/*    */   
/*    */   public void set(int row, int column) {
/* 32 */     setRow(row);
/* 33 */     setColumn(column);
/*    */   }
/*    */   
/*    */   public int getRow() {
/* 37 */     return this.row;
/*    */   }
/*    */   
/*    */   public void setRow(int row) {
/* 41 */     this.row = row;
/*    */   }
/*    */   
/*    */   public int getColumn() {
/* 45 */     return this.column;
/*    */   }
/*    */   
/*    */   public void setColumn(int column) {
/* 49 */     this.column = column;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 53 */     return "Position [row = " + getRow() + ", column = " + getColumn() + "]";
/*    */   }
/*    */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/controller/GridSelection.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */