/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.5
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package ilwisobject_test;

public class Envelope {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected Envelope(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Envelope obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ilwisobjectsJNI.delete_Envelope(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public Envelope() {
    this(ilwisobjectsJNI.new_Envelope__SWIG_0(), true);
  }

  public Envelope(String envelope) {
    this(ilwisobjectsJNI.new_Envelope__SWIG_1(envelope), true);
  }

  public Envelope(Coordinate min, Coordinate max) {
    this(ilwisobjectsJNI.new_Envelope__SWIG_2(Coordinate.getCPtr(min), min, Coordinate.getCPtr(max), max), true);
  }

  public Envelope(SizeD size) {
    this(ilwisobjectsJNI.new_Envelope__SWIG_3(SizeD.getCPtr(size), size), true);
  }

  public Coordinate minCorner() {
    return new Coordinate(ilwisobjectsJNI.Envelope_minCorner(swigCPtr, this), true);
  }

  public Coordinate maxCorner() {
    return new Coordinate(ilwisobjectsJNI.Envelope_maxCorner(swigCPtr, this), true);
  }

  public SizeD size() {
    return new SizeD(ilwisobjectsJNI.Envelope_size(swigCPtr, this), true);
  }

  public boolean is3D() {
    return ilwisobjectsJNI.Envelope_is3D(swigCPtr, this);
  }

  public boolean __contains__(Coordinate point) {
    return ilwisobjectsJNI.Envelope___contains____SWIG_0(swigCPtr, this, Coordinate.getCPtr(point), point);
  }

  public boolean __contains__(Envelope box) {
    return ilwisobjectsJNI.Envelope___contains____SWIG_1(swigCPtr, this, Envelope.getCPtr(box), box);
  }

  public boolean equal(Envelope other) {
    return ilwisobjectsJNI.Envelope_equal(swigCPtr, this, Envelope.getCPtr(other), other);
  }

  public boolean notequal(Envelope other) {
    return ilwisobjectsJNI.Envelope_notequal(swigCPtr, this, Envelope.getCPtr(other), other);
  }

  public String toString() {
    return ilwisobjectsJNI.Envelope_toString(swigCPtr, this);
  }

  public boolean isValid() {
    return ilwisobjectsJNI.Envelope_isValid(swigCPtr, this);
  }

}
