/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.5
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package ilwisobject_test;

public class ColorDomain extends Domain {
  private long swigCPtr;

  protected ColorDomain(long cPtr, boolean cMemoryOwn) {
    super(ilwisobjectsJNI.ColorDomain_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(ColorDomain obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ilwisobjectsJNI.delete_ColorDomain(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public ColorDomain() {
    this(ilwisobjectsJNI.new_ColorDomain__SWIG_0(), true);
  }

  public ColorDomain(String resource) {
    this(ilwisobjectsJNI.new_ColorDomain__SWIG_1(resource), true);
  }

  public java.math.BigInteger ilwisType() {
    return ilwisobjectsJNI.ColorDomain_ilwisType(swigCPtr, this);
  }

  public String containsColor(Color value) {
    return ilwisobjectsJNI.ColorDomain_containsColor(swigCPtr, this, Color.getCPtr(value), value);
  }

}
