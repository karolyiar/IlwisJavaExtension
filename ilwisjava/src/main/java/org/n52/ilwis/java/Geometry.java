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

public class Geometry extends IObject implements Iterable<Coordinate> {
  private long swigCPtr;

  protected Geometry(long cPtr, boolean cMemoryOwn) {
    super(ilwisobjectsJNI.Geometry_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Geometry obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ilwisobjectsJNI.delete_Geometry(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public Geometry(String wkt, CoordinateSystem csy) {
    this(ilwisobjectsJNI.new_Geometry__SWIG_0(wkt, CoordinateSystem.getCPtr(csy), csy), true);
  }

  public Geometry(Feature feature) {
    this(ilwisobjectsJNI.new_Geometry__SWIG_1(Feature.getCPtr(feature), feature), true);
  }

  public boolean isValid() {
    return ilwisobjectsJNI.Geometry_isValid(swigCPtr, this);
  }

  public String toString() {
    return ilwisobjectsJNI.Geometry_toString(swigCPtr, this);
  }

  public java.math.BigInteger ilwisType() {
    return ilwisobjectsJNI.Geometry_ilwisType(swigCPtr, this);
  }

  public void fromWKT(String wkt) {
    ilwisobjectsJNI.Geometry_fromWKT(swigCPtr, this, wkt);
  }

  public SWIGTYPE_p_geos__geom__Geometry fromWKTReader(String wkt) {
    long cPtr = ilwisobjectsJNI.Geometry_fromWKTReader(swigCPtr, this, wkt);
    return (cPtr == 0) ? null : new SWIGTYPE_p_geos__geom__Geometry(cPtr, false);
  }

  public String toWKT() {
    return ilwisobjectsJNI.Geometry_toWKT(swigCPtr, this);
  }

  public CoordinateSystem coordinateSystem() {
    return new CoordinateSystem(ilwisobjectsJNI.Geometry_coordinateSystem(swigCPtr, this), true);
  }

  public void setCoordinateSystem(CoordinateSystem cs) {
    ilwisobjectsJNI.Geometry_setCoordinateSystem(swigCPtr, this, CoordinateSystem.getCPtr(cs), cs);
  }

  public Geometry transform(CoordinateSystem cs) {
    long cPtr = ilwisobjectsJNI.Geometry_transform(swigCPtr, this, CoordinateSystem.getCPtr(cs), cs);
    return (cPtr == 0) ? null : new Geometry(cPtr, false);
  }

  public Envelope envelope() {
    return new Envelope(ilwisobjectsJNI.Geometry_envelope(swigCPtr, this), true);
  }

  public VertexIterator iterator() {
    return new VertexIterator(ilwisobjectsJNI.Geometry_iterator(swigCPtr, this), true);
  }

  public boolean isSimple() {
    return ilwisobjectsJNI.Geometry_isSimple(swigCPtr, this);
  }

  public boolean within(Geometry geometry) {
    return ilwisobjectsJNI.Geometry_within(swigCPtr, this, Geometry.getCPtr(geometry), geometry);
  }

  public boolean contains(Geometry geometry) {
    return ilwisobjectsJNI.Geometry_contains(swigCPtr, this, Geometry.getCPtr(geometry), geometry);
  }

  public boolean disjoint(Geometry geometry) {
    return ilwisobjectsJNI.Geometry_disjoint(swigCPtr, this, Geometry.getCPtr(geometry), geometry);
  }

  public boolean touches(Geometry geometry) {
    return ilwisobjectsJNI.Geometry_touches(swigCPtr, this, Geometry.getCPtr(geometry), geometry);
  }

  public boolean intersects(Geometry geometry) {
    return ilwisobjectsJNI.Geometry_intersects(swigCPtr, this, Geometry.getCPtr(geometry), geometry);
  }

  public boolean crosses(Geometry geometry) {
    return ilwisobjectsJNI.Geometry_crosses(swigCPtr, this, Geometry.getCPtr(geometry), geometry);
  }

  public boolean overlaps(Geometry geometry) {
    return ilwisobjectsJNI.Geometry_overlaps(swigCPtr, this, Geometry.getCPtr(geometry), geometry);
  }

  public boolean equals(Geometry geometry) {
    return ilwisobjectsJNI.Geometry_equals(swigCPtr, this, Geometry.getCPtr(geometry), geometry);
  }

  public boolean equalsExact(Geometry geometry, double tolerance) {
    return ilwisobjectsJNI.Geometry_equalsExact__SWIG_0(swigCPtr, this, Geometry.getCPtr(geometry), geometry, tolerance);
  }

  public boolean equalsExact(Geometry geometry) {
    return ilwisobjectsJNI.Geometry_equalsExact__SWIG_1(swigCPtr, this, Geometry.getCPtr(geometry), geometry);
  }

  public boolean covers(Geometry geometry) {
    return ilwisobjectsJNI.Geometry_covers(swigCPtr, this, Geometry.getCPtr(geometry), geometry);
  }

  public boolean coveredBy(Geometry geometry) {
    return ilwisobjectsJNI.Geometry_coveredBy(swigCPtr, this, Geometry.getCPtr(geometry), geometry);
  }

  public boolean relate(Geometry geometry, String DE9IM_pattern) {
    return ilwisobjectsJNI.Geometry_relate(swigCPtr, this, Geometry.getCPtr(geometry), geometry, DE9IM_pattern);
  }

  public double distance(Geometry geometry) {
    return ilwisobjectsJNI.Geometry_distance(swigCPtr, this, Geometry.getCPtr(geometry), geometry);
  }

  public double getArea() {
    return ilwisobjectsJNI.Geometry_getArea(swigCPtr, this);
  }

  public double getLength() {
    return ilwisobjectsJNI.Geometry_getLength(swigCPtr, this);
  }

  public boolean isWithinDistance(Geometry geometry, double cDistance) {
    return ilwisobjectsJNI.Geometry_isWithinDistance(swigCPtr, this, Geometry.getCPtr(geometry), geometry, cDistance);
  }

  public Geometry buffer(double distance) {
    long cPtr = ilwisobjectsJNI.Geometry_buffer(swigCPtr, this, distance);
    return (cPtr == 0) ? null : new Geometry(cPtr, false);
  }

  public Geometry convexHull() {
    long cPtr = ilwisobjectsJNI.Geometry_convexHull(swigCPtr, this);
    return (cPtr == 0) ? null : new Geometry(cPtr, false);
  }

  public Geometry intersection(Geometry geometry) {
    long cPtr = ilwisobjectsJNI.Geometry_intersection(swigCPtr, this, Geometry.getCPtr(geometry), geometry);
    return (cPtr == 0) ? null : new Geometry(cPtr, false);
  }

  public Geometry Union(Geometry geometry) {
    long cPtr = ilwisobjectsJNI.Geometry_Union(swigCPtr, this, Geometry.getCPtr(geometry), geometry);
    return (cPtr == 0) ? null : new Geometry(cPtr, false);
  }

  public Geometry difference(Geometry geometry) {
    long cPtr = ilwisobjectsJNI.Geometry_difference(swigCPtr, this, Geometry.getCPtr(geometry), geometry);
    return (cPtr == 0) ? null : new Geometry(cPtr, false);
  }

  public Geometry symDifference(Geometry geometry) {
    long cPtr = ilwisobjectsJNI.Geometry_symDifference(swigCPtr, this, Geometry.getCPtr(geometry), geometry);
    return (cPtr == 0) ? null : new Geometry(cPtr, false);
  }

}