/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.5
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package ilwisobject_test;

public class SizeD {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected SizeD(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(SizeD obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ilwisobjectsJNI.delete_SizeD(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public SizeD(double xSizeT, double ySizeT, double zSizeT) {
    this(ilwisobjectsJNI.new_SizeD__SWIG_0(xSizeT, ySizeT, zSizeT), true);
  }

  public SizeD(double xSizeT, double ySizeT) {
    this(ilwisobjectsJNI.new_SizeD__SWIG_1(xSizeT, ySizeT), true);
  }

  public SizeD(Size size) {
    this(ilwisobjectsJNI.new_SizeD__SWIG_2(Size.getCPtr(size), size), true);
  }

  public SizeD(SizeD size) {
    this(ilwisobjectsJNI.new_SizeD__SWIG_3(SizeD.getCPtr(size), size), true);
  }

  public double xsize() {
    return ilwisobjectsJNI.SizeD_xsize(swigCPtr, this);
  }

  public double ysize() {
    return ilwisobjectsJNI.SizeD_ysize(swigCPtr, this);
  }

  public double zsize() {
    return ilwisobjectsJNI.SizeD_zsize(swigCPtr, this);
  }

  public void setXsize(double x) {
    ilwisobjectsJNI.SizeD_setXsize(swigCPtr, this, x);
  }

  public void setYsize(double y) {
    ilwisobjectsJNI.SizeD_setYsize(swigCPtr, this, y);
  }

  public void setZsize(double z) {
    ilwisobjectsJNI.SizeD_setZsize(swigCPtr, this, z);
  }

  public java.math.BigInteger linearSize() {
    return ilwisobjectsJNI.SizeD_linearSize(swigCPtr, this);
  }

  public SizeD add(SizeD sz) {
    long cPtr = ilwisobjectsJNI.SizeD_add(swigCPtr, this, SizeD.getCPtr(sz), sz);
    return (cPtr == 0) ? null : new SizeD(cPtr, false);
  }

  public SizeD subtract(SizeD sz) {
    long cPtr = ilwisobjectsJNI.SizeD_subtract(swigCPtr, this, SizeD.getCPtr(sz), sz);
    return (cPtr == 0) ? null : new SizeD(cPtr, false);
  }

  public SizeD multiply(double f) {
    long cPtr = ilwisobjectsJNI.SizeD_multiply(swigCPtr, this, f);
    return (cPtr == 0) ? null : new SizeD(cPtr, false);
  }

  public boolean equal(SizeD sz) {
    return ilwisobjectsJNI.SizeD_equal(swigCPtr, this, SizeD.getCPtr(sz), sz);
  }

  public boolean notequal(SizeD sz) {
    return ilwisobjectsJNI.SizeD_notequal(swigCPtr, this, SizeD.getCPtr(sz), sz);
  }

  public boolean __contains__(Coordinate pix) {
    return ilwisobjectsJNI.SizeD___contains____SWIG_0(swigCPtr, this, Coordinate.getCPtr(pix), pix);
  }

  public boolean __contains__(Pixel pix) {
    return ilwisobjectsJNI.SizeD___contains____SWIG_1(swigCPtr, this, Pixel.getCPtr(pix), pix);
  }

  public boolean __contains__(PixelD pix) {
    return ilwisobjectsJNI.SizeD___contains____SWIG_2(swigCPtr, this, PixelD.getCPtr(pix), pix);
  }

  public String toString() {
    return ilwisobjectsJNI.SizeD_toString(swigCPtr, this);
  }

  public boolean isValid() {
    return ilwisobjectsJNI.SizeD_isValid(swigCPtr, this);
  }

}
