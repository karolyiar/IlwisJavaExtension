/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.5
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package ilwisobject_test;

public class Size {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected Size(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Size obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ilwisobjectsJNI.delete_Size(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public Size(long xSizeT, long ySizeT, long zSizeT) {
    this(ilwisobjectsJNI.new_Size__SWIG_0(xSizeT, ySizeT, zSizeT), true);
  }

  public Size(long xSizeT, long ySizeT) {
    this(ilwisobjectsJNI.new_Size__SWIG_1(xSizeT, ySizeT), true);
  }

  public Size(Size size) {
    this(ilwisobjectsJNI.new_Size__SWIG_2(Size.getCPtr(size), size), true);
  }

  public Size(SizeD size) {
    this(ilwisobjectsJNI.new_Size__SWIG_3(SizeD.getCPtr(size), size), true);
  }

  public long xsize() {
    return ilwisobjectsJNI.Size_xsize(swigCPtr, this);
  }

  public long ysize() {
    return ilwisobjectsJNI.Size_ysize(swigCPtr, this);
  }

  public long zsize() {
    return ilwisobjectsJNI.Size_zsize(swigCPtr, this);
  }

  public void setXsize(long x) {
    ilwisobjectsJNI.Size_setXsize(swigCPtr, this, x);
  }

  public void setYsize(long y) {
    ilwisobjectsJNI.Size_setYsize(swigCPtr, this, y);
  }

  public void setZsize(long z) {
    ilwisobjectsJNI.Size_setZsize(swigCPtr, this, z);
  }

  public java.math.BigInteger linearSize() {
    return ilwisobjectsJNI.Size_linearSize(swigCPtr, this);
  }

  public Size add(Size sz) {
    long cPtr = ilwisobjectsJNI.Size_add(swigCPtr, this, Size.getCPtr(sz), sz);
    return (cPtr == 0) ? null : new Size(cPtr, false);
  }

  public Size subtract(Size sz) {
    long cPtr = ilwisobjectsJNI.Size_subtract(swigCPtr, this, Size.getCPtr(sz), sz);
    return (cPtr == 0) ? null : new Size(cPtr, false);
  }

  public Size multiply(double f) {
    long cPtr = ilwisobjectsJNI.Size_multiply(swigCPtr, this, f);
    return (cPtr == 0) ? null : new Size(cPtr, false);
  }

  public boolean equal(Size sz) {
    return ilwisobjectsJNI.Size_equal(swigCPtr, this, Size.getCPtr(sz), sz);
  }

  public boolean notequal(Size sz) {
    return ilwisobjectsJNI.Size_notequal(swigCPtr, this, Size.getCPtr(sz), sz);
  }

  public boolean __contains__(Coordinate pix) {
    return ilwisobjectsJNI.Size___contains____SWIG_0(swigCPtr, this, Coordinate.getCPtr(pix), pix);
  }

  public boolean __contains__(Pixel pix) {
    return ilwisobjectsJNI.Size___contains____SWIG_1(swigCPtr, this, Pixel.getCPtr(pix), pix);
  }

  public boolean __contains__(PixelD pix) {
    return ilwisobjectsJNI.Size___contains____SWIG_2(swigCPtr, this, PixelD.getCPtr(pix), pix);
  }

  public String toString() {
    return ilwisobjectsJNI.Size_toString(swigCPtr, this);
  }

  public boolean isValid() {
    return ilwisobjectsJNI.Size_isValid(swigCPtr, this);
  }

}
