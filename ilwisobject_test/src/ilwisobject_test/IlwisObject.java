/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.5
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package ilwisobject_test;

public class IlwisObject extends IObject {
  private long swigCPtr;

  protected IlwisObject(long cPtr, boolean cMemoryOwn) {
    super(ilwisobjectsJNI.IlwisObject_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(IlwisObject obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ilwisobjectsJNI.delete_IlwisObject(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public void open(String url, String format, String fnamespace, IOOptions options) {
    ilwisobjectsJNI.IlwisObject_open__SWIG_0(swigCPtr, this, url, format, fnamespace, IOOptions.getCPtr(options), options);
  }

  public void open(String url, String format, String fnamespace) {
    ilwisobjectsJNI.IlwisObject_open__SWIG_1(swigCPtr, this, url, format, fnamespace);
  }

  public void open(String url, String format) {
    ilwisobjectsJNI.IlwisObject_open__SWIG_2(swigCPtr, this, url, format);
  }

  public void open(String url) {
    ilwisobjectsJNI.IlwisObject_open__SWIG_3(swigCPtr, this, url);
  }

  public void store(String url, String format, String fnamespace, IOOptions options) {
    ilwisobjectsJNI.IlwisObject_store__SWIG_0(swigCPtr, this, url, format, fnamespace, IOOptions.getCPtr(options), options);
  }

  public void store(String url, String format, String fnamespace) {
    ilwisobjectsJNI.IlwisObject_store__SWIG_1(swigCPtr, this, url, format, fnamespace);
  }

  public void store(String url, String format) {
    ilwisobjectsJNI.IlwisObject_store__SWIG_2(swigCPtr, this, url, format);
  }

  public void store(String url) {
    ilwisobjectsJNI.IlwisObject_store__SWIG_3(swigCPtr, this, url);
  }

  public boolean isValid() {
    return ilwisobjectsJNI.IlwisObject_isValid(swigCPtr, this);
  }

  public String toString() {
    return ilwisobjectsJNI.IlwisObject_toString(swigCPtr, this);
  }

  public String __add__(String value) {
    return ilwisobjectsJNI.IlwisObject___add__(swigCPtr, this, value);
  }

  public String __radd__(String value) {
    return ilwisobjectsJNI.IlwisObject___radd__(swigCPtr, this, value);
  }

  public String name() {
    return ilwisobjectsJNI.IlwisObject_name__SWIG_0(swigCPtr, this);
  }

  public void name(String name) {
    ilwisobjectsJNI.IlwisObject_name__SWIG_1(swigCPtr, this, name);
  }

  public boolean isInternal() {
    return ilwisobjectsJNI.IlwisObject_isInternal(swigCPtr, this);
  }

  public String type() {
    return ilwisobjectsJNI.IlwisObject_type(swigCPtr, this);
  }

  public String type2Name(java.math.BigInteger ilwType) {
    return ilwisobjectsJNI.IlwisObject_type2Name(swigCPtr, this, ilwType);
  }

  public java.math.BigInteger ilwisID() {
    return ilwisobjectsJNI.IlwisObject_ilwisID(swigCPtr, this);
  }

  public java.math.BigInteger ilwisType() {
    return ilwisobjectsJNI.IlwisObject_ilwisType(swigCPtr, this);
  }

  public final static class ConnectorMode {
    public final static IlwisObject.ConnectorMode cmINPUT = new IlwisObject.ConnectorMode("cmINPUT", ilwisobjectsJNI.IlwisObject_cmINPUT_get());
    public final static IlwisObject.ConnectorMode cmOUTPUT = new IlwisObject.ConnectorMode("cmOUTPUT", ilwisobjectsJNI.IlwisObject_cmOUTPUT_get());
    public final static IlwisObject.ConnectorMode cmEXTENDED = new IlwisObject.ConnectorMode("cmEXTENDED", ilwisobjectsJNI.IlwisObject_cmEXTENDED_get());

    public final int swigValue() {
      return swigValue;
    }

    public String toString() {
      return swigName;
    }

    public static ConnectorMode swigToEnum(int swigValue) {
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (int i = 0; i < swigValues.length; i++)
        if (swigValues[i].swigValue == swigValue)
          return swigValues[i];
      throw new IllegalArgumentException("No enum " + ConnectorMode.class + " with value " + swigValue);
    }

    private ConnectorMode(String swigName) {
      this.swigName = swigName;
      this.swigValue = swigNext++;
    }

    private ConnectorMode(String swigName, int swigValue) {
      this.swigName = swigName;
      this.swigValue = swigValue;
      swigNext = swigValue+1;
    }

    private ConnectorMode(String swigName, ConnectorMode swigEnum) {
      this.swigName = swigName;
      this.swigValue = swigEnum.swigValue;
      swigNext = this.swigValue+1;
    }

    private static ConnectorMode[] swigValues = { cmINPUT, cmOUTPUT, cmEXTENDED };
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
  }

  public final static class StoreMode {
    public final static IlwisObject.StoreMode smMETADATA = new IlwisObject.StoreMode("smMETADATA", ilwisobjectsJNI.IlwisObject_smMETADATA_get());
    public final static IlwisObject.StoreMode smBINARYDATA = new IlwisObject.StoreMode("smBINARYDATA", ilwisobjectsJNI.IlwisObject_smBINARYDATA_get());

    public final int swigValue() {
      return swigValue;
    }

    public String toString() {
      return swigName;
    }

    public static StoreMode swigToEnum(int swigValue) {
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (int i = 0; i < swigValues.length; i++)
        if (swigValues[i].swigValue == swigValue)
          return swigValues[i];
      throw new IllegalArgumentException("No enum " + StoreMode.class + " with value " + swigValue);
    }

    private StoreMode(String swigName) {
      this.swigName = swigName;
      this.swigValue = swigNext++;
    }

    private StoreMode(String swigName, int swigValue) {
      this.swigName = swigName;
      this.swigValue = swigValue;
      swigNext = swigValue+1;
    }

    private StoreMode(String swigName, StoreMode swigEnum) {
      this.swigName = swigName;
      this.swigValue = swigEnum.swigValue;
      swigNext = this.swigValue+1;
    }

    private static StoreMode[] swigValues = { smMETADATA, smBINARYDATA };
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
  }

}
