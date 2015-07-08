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

public class Color {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected Color(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Color obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ilwisobjectsJNI.delete_Color(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public Color() {
    this(ilwisobjectsJNI.new_Color__SWIG_0(), true);
  }

  public Color(ColorModel.Value type, mapsd obj, String name) {
    this(ilwisobjectsJNI.new_Color__SWIG_1(type.swigValue(), mapsd.getCPtr(obj), obj, name), true);
  }

  public Color(ColorModel.Value type, mapsd obj) {
    this(ilwisobjectsJNI.new_Color__SWIG_2(type.swigValue(), mapsd.getCPtr(obj), obj), true);
  }

  public Color(ColorModel.Value type, vectord obj, String name) {
    this(ilwisobjectsJNI.new_Color__SWIG_3(type.swigValue(), vectord.getCPtr(obj), obj, name), true);
  }

  public Color(ColorModel.Value type, vectord obj) {
    this(ilwisobjectsJNI.new_Color__SWIG_4(type.swigValue(), vectord.getCPtr(obj), obj), true);
  }

  public Color(String typeStr, mapsd obj, String name) {
    this(ilwisobjectsJNI.new_Color__SWIG_5(typeStr, mapsd.getCPtr(obj), obj, name), true);
  }

  public Color(String typeStr, mapsd obj) {
    this(ilwisobjectsJNI.new_Color__SWIG_6(typeStr, mapsd.getCPtr(obj), obj), true);
  }

  public Color(String typeStr, vectord obj, String name) {
    this(ilwisobjectsJNI.new_Color__SWIG_7(typeStr, vectord.getCPtr(obj), obj, name), true);
  }

  public Color(String typeStr, vectord obj) {
    this(ilwisobjectsJNI.new_Color__SWIG_8(typeStr, vectord.getCPtr(obj), obj), true);
  }

  public double getItem(String key) {
    return ilwisobjectsJNI.Color_getItem(swigCPtr, this, key);
  }

  public void setName(String name) {
    ilwisobjectsJNI.Color_setName(swigCPtr, this, name);
  }

  public String getName() {
    return ilwisobjectsJNI.Color_getName(swigCPtr, this);
  }

  public ColorModel.Value getColorModel() {
    return ColorModel.Value.swigToEnum(ilwisobjectsJNI.Color_getColorModel(swigCPtr, this));
  }

  public String toString() {
    return ilwisobjectsJNI.Color_toString(swigCPtr, this);
  }

}
