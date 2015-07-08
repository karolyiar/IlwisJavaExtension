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
import java.util.Iterator;
public class NumericRangeIterator implements Iterator<Double> {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected NumericRangeIterator(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(NumericRangeIterator obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ilwisobjectsJNI.delete_NumericRangeIterator(swigCPtr);
      }
      swigCPtr = 0;
    }
  }
  public Double next() { return current(); }
  public NumericRangeIterator(Range rng) {
    this(ilwisobjectsJNI.new_NumericRangeIterator__SWIG_0(Range.getCPtr(rng), rng), true);
  }

  public NumericRangeIterator(NumericRangeIterator iter) {
    this(ilwisobjectsJNI.new_NumericRangeIterator__SWIG_1(NumericRangeIterator.getCPtr(iter), iter), true);
  }

  public NumericRangeIterator(SWIGTYPE_p_Ilwis__RangeIteratorT_double_Ilwis__NumericRange_t iter) {
    this(ilwisobjectsJNI.new_NumericRangeIterator__SWIG_2(SWIGTYPE_p_Ilwis__RangeIteratorT_double_Ilwis__NumericRange_t.getCPtr(iter)), true);
  }

  public boolean isValid() {
    return ilwisobjectsJNI.NumericRangeIterator_isValid(swigCPtr, this);
  }

  public String toString() {
    return ilwisobjectsJNI.NumericRangeIterator_toString(swigCPtr, this);
  }

  public NumericRangeIterator iterator() {
    long cPtr = ilwisobjectsJNI.NumericRangeIterator_iterator(swigCPtr, this);
    return (cPtr == 0) ? null : new NumericRangeIterator(cPtr, false);
  }

  public double _next() {
    return ilwisobjectsJNI.NumericRangeIterator__next(swigCPtr, this);
  }

  public boolean hasNext() {
    return ilwisobjectsJNI.NumericRangeIterator_hasNext(swigCPtr, this);
  }

  public double current() {
    return ilwisobjectsJNI.NumericRangeIterator_current(swigCPtr, this);
  }

  public double get(long pos) {
    return ilwisobjectsJNI.NumericRangeIterator_get(swigCPtr, this, pos);
  }

  public NumericRangeIterator __radd__(int n) {
    return new NumericRangeIterator(ilwisobjectsJNI.NumericRangeIterator___radd__(swigCPtr, this, n), true);
  }

  public NumericRangeIterator add(int n) {
    return new NumericRangeIterator(ilwisobjectsJNI.NumericRangeIterator_add(swigCPtr, this, n), true);
  }

  public NumericRangeIterator increase(int n) {
    return new NumericRangeIterator(ilwisobjectsJNI.NumericRangeIterator_increase(swigCPtr, this, n), true);
  }

  public NumericRangeIterator subtract(int n) {
    return new NumericRangeIterator(ilwisobjectsJNI.NumericRangeIterator_subtract(swigCPtr, this, n), true);
  }

  public NumericRangeIterator decrease(int n) {
    return new NumericRangeIterator(ilwisobjectsJNI.NumericRangeIterator_decrease(swigCPtr, this, n), true);
  }

  public int compareTo(NumericRangeIterator other) {
    return ilwisobjectsJNI.NumericRangeIterator_compareTo(swigCPtr, this, NumericRangeIterator.getCPtr(other), other);
  }

  public void setRange(Range rng) {
    ilwisobjectsJNI.NumericRangeIterator_setRange(swigCPtr, this, Range.getCPtr(rng), rng);
  }

}
