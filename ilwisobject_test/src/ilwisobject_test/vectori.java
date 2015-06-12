/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.5
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package ilwisobject_test;

public class vectori {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected vectori(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(vectori obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ilwisobjectsJNI.delete_vectori(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public vectori() {
    this(ilwisobjectsJNI.new_vectori__SWIG_0(), true);
  }

  public vectori(long n) {
    this(ilwisobjectsJNI.new_vectori__SWIG_1(n), true);
  }

  public long size() {
    return ilwisobjectsJNI.vectori_size(swigCPtr, this);
  }

  public long capacity() {
    return ilwisobjectsJNI.vectori_capacity(swigCPtr, this);
  }

  public void reserve(long n) {
    ilwisobjectsJNI.vectori_reserve(swigCPtr, this, n);
  }

  public boolean isEmpty() {
    return ilwisobjectsJNI.vectori_isEmpty(swigCPtr, this);
  }

  public void clear() {
    ilwisobjectsJNI.vectori_clear(swigCPtr, this);
  }

  public void add(int x) {
    ilwisobjectsJNI.vectori_add(swigCPtr, this, x);
  }

  public int get(int i) {
    return ilwisobjectsJNI.vectori_get(swigCPtr, this, i);
  }

  public void set(int i, int val) {
    ilwisobjectsJNI.vectori_set(swigCPtr, this, i, val);
  }

}
