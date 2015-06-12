/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.5
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package ilwisobject_test;

public class CoordinateSystem extends IlwisObject {
  private long swigCPtr;

  protected CoordinateSystem(long cPtr, boolean cMemoryOwn) {
    super(ilwisobjectsJNI.CoordinateSystem_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CoordinateSystem obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ilwisobjectsJNI.delete_CoordinateSystem(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public CoordinateSystem(String resource) {
    this(ilwisobjectsJNI.new_CoordinateSystem(resource), true);
  }

  public Envelope envelope() {
    return new Envelope(ilwisobjectsJNI.CoordinateSystem_envelope(swigCPtr, this), true);
  }

  public void setEnvelope(Envelope env) {
    ilwisobjectsJNI.CoordinateSystem_setEnvelope(swigCPtr, this, Envelope.getCPtr(env), env);
  }

  public boolean equal(CoordinateSystem csy) {
    return ilwisobjectsJNI.CoordinateSystem_equal(swigCPtr, this, CoordinateSystem.getCPtr(csy), csy);
  }

  public boolean notequal(CoordinateSystem csy) {
    return ilwisobjectsJNI.CoordinateSystem_notequal(swigCPtr, this, CoordinateSystem.getCPtr(csy), csy);
  }

  public String toWKT(long spaces) {
    return ilwisobjectsJNI.CoordinateSystem_toWKT__SWIG_0(swigCPtr, this, spaces);
  }

  public String toWKT() {
    return ilwisobjectsJNI.CoordinateSystem_toWKT__SWIG_1(swigCPtr, this);
  }

  public String toProj4() {
    return ilwisobjectsJNI.CoordinateSystem_toProj4(swigCPtr, this);
  }

  public Envelope convertEnvelope(CoordinateSystem pyCsy, Envelope pyEnv) {
    return new Envelope(ilwisobjectsJNI.CoordinateSystem_convertEnvelope(swigCPtr, this, CoordinateSystem.getCPtr(pyCsy), pyCsy, Envelope.getCPtr(pyEnv), pyEnv), true);
  }

  public Coordinate coord2coord(CoordinateSystem pyCsy, Coordinate pyCoord) {
    return new Coordinate(ilwisobjectsJNI.CoordinateSystem_coord2coord(swigCPtr, this, CoordinateSystem.getCPtr(pyCsy), pyCsy, Coordinate.getCPtr(pyCoord), pyCoord), true);
  }

  public static CoordinateSystem toCoordinateSystem(IObject obj) {
    long cPtr = ilwisobjectsJNI.CoordinateSystem_toCoordinateSystem(IObject.getCPtr(obj), obj);
    return (cPtr == 0) ? null : new CoordinateSystem(cPtr, false);
  }

}
