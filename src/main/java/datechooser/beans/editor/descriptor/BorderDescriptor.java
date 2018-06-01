/*     */ package datechooser.beans.editor.descriptor;
/*     */ 
/*     */ import datechooser.beans.locale.LocaleUtils;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.Insets;
/*     */ import javax.swing.border.BevelBorder;
/*     */ import javax.swing.border.Border;
/*     */ import javax.swing.border.CompoundBorder;
/*     */ import javax.swing.border.EmptyBorder;
/*     */ import javax.swing.border.EtchedBorder;
/*     */ import javax.swing.border.LineBorder;
/*     */ import javax.swing.border.MatteBorder;
/*     */ import javax.swing.border.SoftBevelBorder;
/*     */ import javax.swing.border.TitledBorder;
/*     */ 
/*     */ public class BorderDescriptor extends ClassDescriptor
/*     */ {
/*     */   private Border value;
/*     */   
/*     */   public BorderDescriptor() {}
/*     */   
/*     */   public Class getDescriptedClass()
/*     */   {
/*  25 */     return Border.class;
/*     */   }
/*     */   
/*     */   public String getJavaDescription(Object value) {
/*  29 */     this.value = ((Border)value);
/*  30 */     StringBuffer buf = new StringBuffer();
/*  31 */     buf.append(javax.swing.BorderFactory.class.getName() + ".create" + getJavaName(value) + "Border(");
/*     */     
/*  33 */     if ((value instanceof SoftBevelBorder)) {
/*  34 */       buf.append(getBevelJava());
/*     */     }
/*  36 */     else if ((value instanceof BevelBorder)) {
/*  37 */       buf.append(getBevelJava());
/*     */     }
/*  39 */     else if ((value instanceof CompoundBorder)) {
/*  40 */       buf.append(getCompoundJava());
/*     */     }
/*  42 */     else if ((value instanceof MatteBorder)) {
/*  43 */       buf.append(getMatteJava());
/*     */     }
/*  45 */     else if ((value instanceof EmptyBorder)) {
/*  46 */       buf.append(getEmptyJava());
/*     */     }
/*  48 */     else if ((value instanceof EtchedBorder)) {
/*  49 */       buf.append(getEtchedJava());
/*     */     }
/*  51 */     else if ((value instanceof LineBorder)) {
/*  52 */       buf.append(getLineJava());
/*     */     }
/*  54 */     else if ((value instanceof TitledBorder)) {
/*  55 */       buf.append(getTitledJava());
/*     */     }
/*  57 */     buf.append(")");
/*  58 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public String getDescription(Object value) {
/*  62 */     if ((value instanceof SoftBevelBorder)) {
/*  63 */       return LocaleUtils.getEditorLocaleString("SoftBevel");
/*     */     }
/*  65 */     if ((value instanceof BevelBorder)) {
/*  66 */       return LocaleUtils.getEditorLocaleString("Bevel");
/*     */     }
/*  68 */     if ((value instanceof CompoundBorder)) {
/*  69 */       return LocaleUtils.getEditorLocaleString("Compound");
/*     */     }
/*  71 */     if ((value instanceof MatteBorder)) {
/*  72 */       return LocaleUtils.getEditorLocaleString("Matte");
/*     */     }
/*  74 */     if ((value instanceof EmptyBorder)) {
/*  75 */       return LocaleUtils.getEditorLocaleString("Empty");
/*     */     }
/*  77 */     if ((value instanceof EtchedBorder)) {
/*  78 */       return LocaleUtils.getEditorLocaleString("Etched");
/*     */     }
/*  80 */     if ((value instanceof LineBorder)) {
/*  81 */       return LocaleUtils.getEditorLocaleString("Line");
/*     */     }
/*  83 */     if ((value instanceof TitledBorder)) {
/*  84 */       return LocaleUtils.getEditorLocaleString("Titled");
/*     */     }
/*  86 */     return "?";
/*     */   }
/*     */   
/*     */   public String getJavaName(Object value) {
/*  90 */     if ((value instanceof SoftBevelBorder)) {
/*  91 */       return "SoftBevel";
/*     */     }
/*  93 */     if ((value instanceof BevelBorder)) {
/*  94 */       return "Bevel";
/*     */     }
/*  96 */     if ((value instanceof CompoundBorder)) {
/*  97 */       return "Compound";
/*     */     }
/*  99 */     if ((value instanceof MatteBorder)) {
/* 100 */       return "Matte";
/*     */     }
/* 102 */     if ((value instanceof EmptyBorder)) {
/* 103 */       return "Empty";
/*     */     }
/* 105 */     if ((value instanceof EtchedBorder)) {
/* 106 */       return "Etched";
/*     */     }
/* 108 */     if ((value instanceof LineBorder)) {
/* 109 */       return "Line";
/*     */     }
/* 111 */     if ((value instanceof TitledBorder)) {
/* 112 */       return "Titled";
/*     */     }
/* 114 */     return getClassName();
/*     */   }
/*     */   
/*     */   private String getBevelJava() {
/* 118 */     BevelBorder bevelValue = (BevelBorder)this.value;
/* 119 */     StringBuffer buf = new StringBuffer();
/* 120 */     buf.append(BevelBorder.class.getName() + (bevelValue.getBevelType() == 1 ? ".LOWERED" : ".RAISED"));
/*     */     
/*     */ 
/* 123 */     buf.append(getSeparator());
/* 124 */     buf.append(DescriptionManager.describeJava(bevelValue.getHighlightOuterColor(), Color.class));
/* 125 */     buf.append(getSeparator());
/* 126 */     buf.append(DescriptionManager.describeJava(bevelValue.getHighlightInnerColor(), Color.class));
/* 127 */     buf.append(getSeparator());
/* 128 */     buf.append(DescriptionManager.describeJava(bevelValue.getShadowOuterColor(), Color.class));
/* 129 */     buf.append(getSeparator());
/* 130 */     buf.append(DescriptionManager.describeJava(bevelValue.getShadowInnerColor(), Color.class));
/* 131 */     return buf.toString();
/*     */   }
/*     */   
/*     */   private String getCompoundJava() {
/* 135 */     CompoundBorder compoundValue = (CompoundBorder)this.value;
/* 136 */     StringBuffer buf = new StringBuffer();
/* 137 */     Border out = compoundValue.getOutsideBorder();
/* 138 */     if (out != null) {
/* 139 */       buf.append(DescriptionManager.describeJava(out, out.getClass()));
/*     */     } else {
/* 141 */       buf.append("null");
/*     */     }
/* 143 */     buf.append(getSeparator());
/* 144 */     Border inside = compoundValue.getInsideBorder();
/* 145 */     if (inside != null) {
/* 146 */       buf.append(DescriptionManager.describeJava(inside, inside.getClass()));
/*     */     } else {
/* 148 */       buf.append("null");
/*     */     }
/* 150 */     return buf.toString();
/*     */   }
/*     */   
/*     */   private String getInsetsJava(Insets insets) {
/* 154 */     return "new " + Insets.class.getName() + "(" + insets.top + ", " + insets.left + ", " + insets.bottom + ", " + insets.right + ")";
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private String getEmptyJava()
/*     */   {
/* 161 */     EmptyBorder emptyValue = (EmptyBorder)this.value;
/* 162 */     Insets insets = emptyValue.getBorderInsets();
/* 163 */     return insets.top + ", " + insets.left + ", " + insets.bottom + ", " + insets.right;
/*     */   }
/*     */   
/*     */   private String getEtchedJava()
/*     */   {
/* 168 */     EtchedBorder etchedValue = (EtchedBorder)this.value;
/* 169 */     StringBuffer buf = new StringBuffer();
/* 170 */     buf.append(EtchedBorder.class.getName() + (etchedValue.getEtchType() == 1 ? ".LOWERED" : ".RAISED"));
/*     */     
/*     */ 
/* 173 */     buf.append(getSeparator());
/* 174 */     buf.append(DescriptionManager.describeJava(etchedValue.getHighlightColor(), Color.class));
/* 175 */     buf.append(getSeparator());
/* 176 */     buf.append(DescriptionManager.describeJava(etchedValue.getShadowColor(), Color.class));
/* 177 */     return buf.toString();
/*     */   }
/*     */   
/*     */   private String getLineJava() {
/* 181 */     LineBorder lineValue = (LineBorder)this.value;
/* 182 */     StringBuffer buf = new StringBuffer();
/* 183 */     buf.append(DescriptionManager.describeJava(lineValue.getLineColor(), Color.class));
/* 184 */     buf.append(", ");
/* 185 */     buf.append(lineValue.getThickness());
/* 186 */     return buf.toString();
/*     */   }
/*     */   
/*     */   private String getMatteJava() {
/* 190 */     MatteBorder matteValue = (MatteBorder)this.value;
/* 191 */     StringBuffer buf = new StringBuffer();
/* 192 */     buf.append(getInsetsJava(matteValue.getBorderInsets()));
/* 193 */     buf.append(getSeparator());
/* 194 */     buf.append(DescriptionManager.describeJava(matteValue.getMatteColor(), Color.class));
/* 195 */     return buf.toString();
/*     */   }
/*     */   
/*     */   private String getTitledJava() {
/* 199 */     TitledBorder titledValue = (TitledBorder)this.value;
/* 200 */     String className = TitledBorder.class.getName();
/* 201 */     StringBuffer buf = new StringBuffer();
/* 202 */     buf.append(DescriptionManager.describeJava(titledValue.getBorder(), Border.class));
/* 203 */     buf.append(getSeparator());
/* 204 */     buf.append('"' + titledValue.getTitle() + '"');
/* 205 */     buf.append(getSeparator());
/* 206 */     switch (titledValue.getTitleJustification()) {
/*     */     case 1: 
/* 208 */       buf.append(className + ".LEFT");
/* 209 */       break;
/*     */     case 2: 
/* 211 */       buf.append(className + ".CENTER");
/* 212 */       break;
/*     */     case 3: 
/* 214 */       buf.append(className + ".RIGHT");
/* 215 */       break;
/*     */     case 4: 
/* 217 */       buf.append(className + ".LEADING");
/* 218 */       break;
/*     */     case 5: 
/* 220 */       buf.append(className + ".TRAILING");
/* 221 */       break;
/*     */     default: 
/* 223 */       buf.append(className + ".DEFAULT_JUSTIFICATION");
/*     */     }
/* 225 */     buf.append(getSeparator());
/* 226 */     switch (titledValue.getTitlePosition()) {
/*     */     case 1: 
/* 228 */       buf.append(className + ".ABOVE_TOP");
/* 229 */       break;
/*     */     case 2: 
/* 231 */       buf.append(className + ".TOP");
/* 232 */       break;
/*     */     case 3: 
/* 234 */       buf.append(className + ".BELOW_TOP");
/* 235 */       break;
/*     */     case 4: 
/* 237 */       buf.append(className + ".ABOVE_BOTTOM");
/* 238 */       break;
/*     */     case 5: 
/* 240 */       buf.append(className + ".BOTTOM");
/* 241 */       break;
/*     */     case 6: 
/* 243 */       buf.append(className + ".BELOW_BOTTOM");
/* 244 */       break;
/*     */     default: 
/* 246 */       buf.append(className + ".DEFAULT_POSITION ");
/*     */     }
/*     */     
/* 249 */     buf.append(getSeparator());
/* 250 */     buf.append(DescriptionManager.describeJava(titledValue.getTitleFont(), Font.class));
/* 251 */     buf.append(getSeparator());
/* 252 */     buf.append(DescriptionManager.describeJava(titledValue.getTitleColor(), Color.class));
/* 253 */     return buf.toString();
/*     */   }
/*     */ }


/* Location:              /home/work/vm/shared-folder/reverse/ketonix/KetonixUSB-20170310.jar!/datechooser/beans/editor/descriptor/BorderDescriptor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */