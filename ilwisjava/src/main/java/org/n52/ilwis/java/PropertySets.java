/* 
Copyright (C) 2007 - 2015 52°North Initiative for Geospatial Open Source
Software GmbH

This program is free software; you can redistribute it and/or modify it
under the terms of the GNU General Public License version 2 as published
by the Free Software Foundation.

If the program is linked with libraries which are licensed under one of
the following licenses, the combination of the program with the linked
library is not considered a "derivative work" of the program:

      • Apache License, version 2.0
      • Apache Software License, version 1.0
      • GNU Lesser General Public License, version 3
      • Mozilla Public License, versions 1.0, 1.1 and 2.0
      • Common Development and Distribution License (CDDL), version 1.0

Therefore the distribution of the program linked with libraries licensed
under the aforementioned licenses, is permitted by the copyright holders
if the distribution is compliant with both the GNU General Public
License version 2 and the aforementioned licenses.

This program is distributed in the hope that it will be useful, but
WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
Public License for more details. 
*/ 
/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.6
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.n52.ilwis.java;

public class PropertySets {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected PropertySets(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(PropertySets obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ilwisobjectsJNI.delete_PropertySets(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public PropertySets() {
    this(ilwisobjectsJNI.new_PropertySets(), true);
  }

  public final static class Values {
    public final static PropertySets.Values pNONE = new PropertySets.Values("pNONE", ilwisobjectsJNI.PropertySets_pNONE_get());
    public final static PropertySets.Values pBASIC = new PropertySets.Values("pBASIC", ilwisobjectsJNI.PropertySets_pBASIC_get());
    public final static PropertySets.Values pMIN = new PropertySets.Values("pMIN", ilwisobjectsJNI.PropertySets_pMIN_get());
    public final static PropertySets.Values pMAX = new PropertySets.Values("pMAX", ilwisobjectsJNI.PropertySets_pMAX_get());
    public final static PropertySets.Values pDISTANCE = new PropertySets.Values("pDISTANCE", ilwisobjectsJNI.PropertySets_pDISTANCE_get());
    public final static PropertySets.Values pDELTA = new PropertySets.Values("pDELTA", ilwisobjectsJNI.PropertySets_pDELTA_get());
    public final static PropertySets.Values pNETTOCOUNT = new PropertySets.Values("pNETTOCOUNT", ilwisobjectsJNI.PropertySets_pNETTOCOUNT_get());
    public final static PropertySets.Values pCOUNT = new PropertySets.Values("pCOUNT", ilwisobjectsJNI.PropertySets_pCOUNT_get());
    public final static PropertySets.Values pSUM = new PropertySets.Values("pSUM", ilwisobjectsJNI.PropertySets_pSUM_get());
    public final static PropertySets.Values pMEAN = new PropertySets.Values("pMEAN", ilwisobjectsJNI.PropertySets_pMEAN_get());
    public final static PropertySets.Values pMEDIAN = new PropertySets.Values("pMEDIAN", ilwisobjectsJNI.PropertySets_pMEDIAN_get());
    public final static PropertySets.Values pPREDOMINANT = new PropertySets.Values("pPREDOMINANT", ilwisobjectsJNI.PropertySets_pPREDOMINANT_get());
    public final static PropertySets.Values pSTDEV = new PropertySets.Values("pSTDEV", ilwisobjectsJNI.PropertySets_pSTDEV_get());
    public final static PropertySets.Values pHISTOGRAM = new PropertySets.Values("pHISTOGRAM", ilwisobjectsJNI.PropertySets_pHISTOGRAM_get());
    public final static PropertySets.Values pLAST = new PropertySets.Values("pLAST", ilwisobjectsJNI.PropertySets_pLAST_get());
    public final static PropertySets.Values pALL = new PropertySets.Values("pALL", ilwisobjectsJNI.PropertySets_pALL_get());

    public final int swigValue() {
      return swigValue;
    }

    public String toString() {
      return swigName;
    }

    public static Values swigToEnum(int swigValue) {
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (int i = 0; i < swigValues.length; i++)
        if (swigValues[i].swigValue == swigValue)
          return swigValues[i];
      throw new IllegalArgumentException("No enum " + Values.class + " with value " + swigValue);
    }

    private Values(String swigName) {
      this.swigName = swigName;
      this.swigValue = swigNext++;
    }

    private Values(String swigName, int swigValue) {
      this.swigName = swigName;
      this.swigValue = swigValue;
      swigNext = swigValue+1;
    }

    private Values(String swigName, Values swigEnum) {
      this.swigName = swigName;
      this.swigValue = swigEnum.swigValue;
      swigNext = this.swigValue+1;
    }

    private static Values[] swigValues = { pNONE, pBASIC, pMIN, pMAX, pDISTANCE, pDELTA, pNETTOCOUNT, pCOUNT, pSUM, pMEAN, pMEDIAN, pPREDOMINANT, pSTDEV, pHISTOGRAM, pLAST, pALL };
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
  }

}