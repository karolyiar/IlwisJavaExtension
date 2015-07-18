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

public class mapsd {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected mapsd(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(mapsd obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ilwisobjectsJNI.delete_mapsd(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public mapsd() {
    this(ilwisobjectsJNI.new_mapsd__SWIG_0(), true);
  }

  public mapsd(mapsd arg0) {
    this(ilwisobjectsJNI.new_mapsd__SWIG_1(mapsd.getCPtr(arg0), arg0), true);
  }

  public long size() {
    return ilwisobjectsJNI.mapsd_size(swigCPtr, this);
  }

  public boolean empty() {
    return ilwisobjectsJNI.mapsd_empty(swigCPtr, this);
  }

  public void clear() {
    ilwisobjectsJNI.mapsd_clear(swigCPtr, this);
  }

  public double get(String key) {
    return ilwisobjectsJNI.mapsd_get(swigCPtr, this, key);
  }

  public void set(String key, double x) {
    ilwisobjectsJNI.mapsd_set(swigCPtr, this, key, x);
  }

  public void del(String key) {
    ilwisobjectsJNI.mapsd_del(swigCPtr, this, key);
  }

  public boolean has_key(String key) {
    return ilwisobjectsJNI.mapsd_has_key(swigCPtr, this, key);
  }

}