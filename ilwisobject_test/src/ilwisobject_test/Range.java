/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.5
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package ilwisobject_test;

public class Range extends IObject {
  private long swigCPtr;

  protected Range(long cPtr, boolean cMemoryOwn) {
    super(ilwisobjectsJNI.Range_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Range obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        throw new UnsupportedOperationException("C++ destructor does not have public access");
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public boolean isValid() {
    return ilwisobjectsJNI.Range_isValid(swigCPtr, this);
  }

  public String toString() {
    return ilwisobjectsJNI.Range_toString(swigCPtr, this);
  }

  public java.math.BigInteger ilwisType() {
    return ilwisobjectsJNI.Range_ilwisType(swigCPtr, this);
  }

  public java.math.BigInteger valueType() {
    return ilwisobjectsJNI.Range_valueType(swigCPtr, this);
  }

  public SWIGTYPE_p_QVariant ensure(SWIGTYPE_p_QVariant v, boolean inclusive) {
    long cPtr = ilwisobjectsJNI.Range_ensure__SWIG_0(swigCPtr, this, SWIGTYPE_p_QVariant.getCPtr(v), inclusive);
    return (cPtr == 0) ? null : new SWIGTYPE_p_QVariant(cPtr, false);
  }

  public SWIGTYPE_p_QVariant ensure(SWIGTYPE_p_QVariant v) {
    long cPtr = ilwisobjectsJNI.Range_ensure__SWIG_1(swigCPtr, this, SWIGTYPE_p_QVariant.getCPtr(v));
    return (cPtr == 0) ? null : new SWIGTYPE_p_QVariant(cPtr, false);
  }

  public boolean contains(SWIGTYPE_p_QVariant value, boolean inclusive) {
    return ilwisobjectsJNI.Range_contains__SWIG_0(swigCPtr, this, SWIGTYPE_p_QVariant.getCPtr(value), inclusive);
  }

  public boolean contains(SWIGTYPE_p_QVariant value) {
    return ilwisobjectsJNI.Range_contains__SWIG_1(swigCPtr, this, SWIGTYPE_p_QVariant.getCPtr(value));
  }

  public boolean isContinuous() {
    return ilwisobjectsJNI.Range_isContinuous(swigCPtr, this);
  }

  public SWIGTYPE_p_QVariant impliedValue(SWIGTYPE_p_QVariant value) {
    long cPtr = ilwisobjectsJNI.Range_impliedValue(swigCPtr, this, SWIGTYPE_p_QVariant.getCPtr(value));
    return (cPtr == 0) ? null : new SWIGTYPE_p_QVariant(cPtr, false);
  }

}