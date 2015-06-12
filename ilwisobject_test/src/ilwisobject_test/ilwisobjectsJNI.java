/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.5
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package ilwisobject_test;

public class ilwisobjectsJNI {
  public final static native boolean _initIlwisObjects(String jarg1);
  public final static native void _exitIlwisObjects();
  public final static native void disconnectIssueLogger();
  public final static native void connectIssueLogger();
  public final static native int it_FEATURE_get();
  public final static native int it_RASTER_get();
  public final static native int it_COVERAGE_get();
  public final static native int it_TABLE_get();
  public final static native int it_GEOREF_get();
  public final static native int it_COORDSYSTEM_get();
  public final static native int it_DOMAIN_get();
  public final static native int it_NUMERICDOMAIN_get();
  public final static native int it_ITEMDOMAIN_get();
  public final static native int it_OPERATIONMETADATA_get();
  public final static native int it_PROJECTION_get();
  public final static native int it_ELLIPSOID_get();
  public final static native int it_CATALOG_get();
  public final static native int it_CONTINUOUSCOLOR_get();
  public final static native int it_PALETTECOLOR_get();
  public final static native int it_VALUERANGE_get();
  public final static native long new_it();
  public final static native void delete_it(long jarg1);
  public final static native void delete_IObject(long jarg1);
  public final static native boolean IObject___bool__(long jarg1, IObject jarg1_);
  public final static native String IObject___str__(long jarg1, IObject jarg1_);
  public final static native java.math.BigInteger IObject_ilwisType(long jarg1, IObject jarg1_);
  public final static native int IlwisObject_cmINPUT_get();
  public final static native int IlwisObject_cmOUTPUT_get();
  public final static native int IlwisObject_cmEXTENDED_get();
  public final static native int IlwisObject_smMETADATA_get();
  public final static native int IlwisObject_smBINARYDATA_get();
  public final static native void delete_IlwisObject(long jarg1);
  public final static native void IlwisObject_open__SWIG_0(long jarg1, IlwisObject jarg1_, String jarg2, String jarg3, String jarg4, long jarg5, IOOptions jarg5_);
  public final static native void IlwisObject_open__SWIG_1(long jarg1, IlwisObject jarg1_, String jarg2, String jarg3, String jarg4);
  public final static native void IlwisObject_open__SWIG_2(long jarg1, IlwisObject jarg1_, String jarg2, String jarg3);
  public final static native void IlwisObject_open__SWIG_3(long jarg1, IlwisObject jarg1_, String jarg2);
  public final static native void IlwisObject_store__SWIG_0(long jarg1, IlwisObject jarg1_, String jarg2, String jarg3, String jarg4, long jarg5, IOOptions jarg5_);
  public final static native void IlwisObject_store__SWIG_1(long jarg1, IlwisObject jarg1_, String jarg2, String jarg3, String jarg4);
  public final static native void IlwisObject_store__SWIG_2(long jarg1, IlwisObject jarg1_, String jarg2, String jarg3);
  public final static native void IlwisObject_store__SWIG_3(long jarg1, IlwisObject jarg1_, String jarg2);
  public final static native boolean IlwisObject___bool__(long jarg1, IlwisObject jarg1_);
  public final static native String IlwisObject___str__(long jarg1, IlwisObject jarg1_);
  public final static native String IlwisObject___add__(long jarg1, IlwisObject jarg1_, String jarg2);
  public final static native String IlwisObject___radd__(long jarg1, IlwisObject jarg1_, String jarg2);
  public final static native String IlwisObject_name__SWIG_0(long jarg1, IlwisObject jarg1_);
  public final static native void IlwisObject_name__SWIG_1(long jarg1, IlwisObject jarg1_, String jarg2);
  public final static native boolean IlwisObject_isInternal(long jarg1, IlwisObject jarg1_);
  public final static native String IlwisObject_type(long jarg1, IlwisObject jarg1_);
  public final static native String IlwisObject_type2Name(long jarg1, IlwisObject jarg1_, java.math.BigInteger jarg2);
  public final static native java.math.BigInteger IlwisObject_ilwisID(long jarg1, IlwisObject jarg1_);
  public final static native java.math.BigInteger IlwisObject_ilwisType(long jarg1, IlwisObject jarg1_);
  public final static native long new_CoordinateSystem(String jarg1);
  public final static native long CoordinateSystem_envelope(long jarg1, CoordinateSystem jarg1_);
  public final static native void CoordinateSystem_setEnvelope(long jarg1, CoordinateSystem jarg1_, long jarg2, Envelope jarg2_);
  public final static native boolean CoordinateSystem_equal(long jarg1, CoordinateSystem jarg1_, long jarg2, CoordinateSystem jarg2_);
  public final static native boolean CoordinateSystem_notequal(long jarg1, CoordinateSystem jarg1_, long jarg2, CoordinateSystem jarg2_);
  public final static native String CoordinateSystem_toWKT__SWIG_0(long jarg1, CoordinateSystem jarg1_, long jarg2);
  public final static native String CoordinateSystem_toWKT__SWIG_1(long jarg1, CoordinateSystem jarg1_);
  public final static native String CoordinateSystem_toProj4(long jarg1, CoordinateSystem jarg1_);
  public final static native long CoordinateSystem_convertEnvelope(long jarg1, CoordinateSystem jarg1_, long jarg2, CoordinateSystem jarg2_, long jarg3, Envelope jarg3_);
  public final static native long CoordinateSystem_coord2coord(long jarg1, CoordinateSystem jarg1_, long jarg2, CoordinateSystem jarg2_, long jarg3, Coordinate jarg3_);
  public final static native long CoordinateSystem_toCoordinateSystem(long jarg1, IObject jarg1_);
  public final static native void delete_CoordinateSystem(long jarg1);
  public final static native long new_Coordinate__SWIG_0(double jarg1, double jarg2);
  public final static native long new_Coordinate__SWIG_1(double jarg1, double jarg2, double jarg3);
  public final static native long new_Coordinate__SWIG_2(long jarg1, Coordinate jarg1_);
  public final static native double Coordinate_x(long jarg1, Coordinate jarg1_);
  public final static native double Coordinate_y(long jarg1, Coordinate jarg1_);
  public final static native double Coordinate_z(long jarg1, Coordinate jarg1_);
  public final static native void Coordinate_setX(long jarg1, Coordinate jarg1_, double jarg2);
  public final static native void Coordinate_setY(long jarg1, Coordinate jarg1_, double jarg2);
  public final static native void Coordinate_setZ(long jarg1, Coordinate jarg1_, double jarg2);
  public final static native boolean Coordinate_is3D(long jarg1, Coordinate jarg1_);
  public final static native long Coordinate_multiply(long jarg1, Coordinate jarg1_, double jarg2);
  public final static native long Coordinate_divide(long jarg1, Coordinate jarg1_, double jarg2);
  public final static native boolean Coordinate_equal(long jarg1, Coordinate jarg1_, long jarg2, Coordinate jarg2_);
  public final static native boolean Coordinate_notequal(long jarg1, Coordinate jarg1_, long jarg2, Coordinate jarg2_);
  public final static native String Coordinate_toString(long jarg1, Coordinate jarg1_);
  public final static native boolean Coordinate_isValid(long jarg1, Coordinate jarg1_);
  public final static native void delete_Coordinate(long jarg1);
  public final static native int PropertySets_pNONE_get();
  public final static native int PropertySets_pBASIC_get();
  public final static native int PropertySets_pMIN_get();
  public final static native int PropertySets_pMAX_get();
  public final static native int PropertySets_pDISTANCE_get();
  public final static native int PropertySets_pDELTA_get();
  public final static native int PropertySets_pNETTOCOUNT_get();
  public final static native int PropertySets_pCOUNT_get();
  public final static native int PropertySets_pSUM_get();
  public final static native int PropertySets_pMEAN_get();
  public final static native int PropertySets_pMEDIAN_get();
  public final static native int PropertySets_pPREDOMINANT_get();
  public final static native int PropertySets_pSTDEV_get();
  public final static native int PropertySets_pHISTOGRAM_get();
  public final static native int PropertySets_pLAST_get();
  public final static native int PropertySets_pALL_get();
  public final static native long new_PropertySets();
  public final static native void delete_PropertySets(long jarg1);
  public final static native long new_IOOptions__SWIG_0();
  public final static native long new_IOOptions__SWIG_1(String jarg1, long jarg2);
  public final static native boolean IOOptions_contains(long jarg1, IOOptions jarg1_, String jarg2);
  public final static native long IOOptions_size(long jarg1, IOOptions jarg1_);
  public final static native long IOOptions_get(long jarg1, IOOptions jarg1_, String jarg2);
  public final static native long IOOptions_addOption(long jarg1, IOOptions jarg1_, String jarg2, long jarg3);
  public final static native void delete_IOOptions(long jarg1);
  public final static native long new_ColorModel();
  public final static native void delete_ColorModel(long jarg1);
  public final static native long new_Color__SWIG_0();
  public final static native long new_Color__SWIG_1(int jarg1, long jarg2, mapsd jarg2_, String jarg3);
  public final static native long new_Color__SWIG_2(int jarg1, long jarg2, mapsd jarg2_);
  public final static native long new_Color__SWIG_3(int jarg1, long jarg2, vectord jarg2_, String jarg3);
  public final static native long new_Color__SWIG_4(int jarg1, long jarg2, vectord jarg2_);
  public final static native long new_Color__SWIG_5(String jarg1, long jarg2, mapsd jarg2_, String jarg3);
  public final static native long new_Color__SWIG_6(String jarg1, long jarg2, mapsd jarg2_);
  public final static native long new_Color__SWIG_7(String jarg1, long jarg2, vectord jarg2_, String jarg3);
  public final static native long new_Color__SWIG_8(String jarg1, long jarg2, vectord jarg2_);
  public final static native void delete_Color(long jarg1);
  public final static native double Color_getItem(long jarg1, Color jarg1_, String jarg2);
  public final static native void Color_setName(long jarg1, Color jarg1_, String jarg2);
  public final static native String Color_getName(long jarg1, Color jarg1_);
  public final static native int Color_getColorModel(long jarg1, Color jarg1_);
  public final static native String Color_toString(long jarg1, Color jarg1_);
  public final static native long new_Pixel__SWIG_0(long jarg1, Pixel jarg1_);
  public final static native long new_Pixel__SWIG_1(long jarg1, PixelD jarg1_);
  public final static native long new_Pixel__SWIG_2(int jarg1, int jarg2);
  public final static native long new_Pixel__SWIG_3(int jarg1, int jarg2, int jarg3);
  public final static native int Pixel_x(long jarg1, Pixel jarg1_);
  public final static native int Pixel_y(long jarg1, Pixel jarg1_);
  public final static native int Pixel_z(long jarg1, Pixel jarg1_);
  public final static native void Pixel_setX(long jarg1, Pixel jarg1_, int jarg2);
  public final static native void Pixel_setY(long jarg1, Pixel jarg1_, int jarg2);
  public final static native void Pixel_setZ(long jarg1, Pixel jarg1_, int jarg2);
  public final static native boolean Pixel_is3D(long jarg1, Pixel jarg1_);
  public final static native long Pixel_multiply(long jarg1, Pixel jarg1_, int jarg2);
  public final static native long Pixel_divide(long jarg1, Pixel jarg1_, int jarg2);
  public final static native boolean Pixel_equal(long jarg1, Pixel jarg1_, long jarg2, Pixel jarg2_);
  public final static native boolean Pixel_notequal(long jarg1, Pixel jarg1_, long jarg2, Pixel jarg2_);
  public final static native String Pixel_toString(long jarg1, Pixel jarg1_);
  public final static native boolean Pixel_isValid(long jarg1, Pixel jarg1_);
  public final static native void delete_Pixel(long jarg1);
  public final static native long new_PixelD__SWIG_0(long jarg1, Pixel jarg1_);
  public final static native long new_PixelD__SWIG_1(long jarg1, PixelD jarg1_);
  public final static native long new_PixelD__SWIG_2(double jarg1, double jarg2);
  public final static native long new_PixelD__SWIG_3(double jarg1, double jarg2, double jarg3);
  public final static native double PixelD_x(long jarg1, PixelD jarg1_);
  public final static native double PixelD_y(long jarg1, PixelD jarg1_);
  public final static native double PixelD_z(long jarg1, PixelD jarg1_);
  public final static native void PixelD_setX(long jarg1, PixelD jarg1_, double jarg2);
  public final static native void PixelD_setY(long jarg1, PixelD jarg1_, double jarg2);
  public final static native void PixelD_setZ(long jarg1, PixelD jarg1_, double jarg2);
  public final static native boolean PixelD_is3D(long jarg1, PixelD jarg1_);
  public final static native long PixelD_multiply(long jarg1, PixelD jarg1_, double jarg2);
  public final static native long PixelD_divide(long jarg1, PixelD jarg1_, double jarg2);
  public final static native boolean PixelD_equal(long jarg1, PixelD jarg1_, long jarg2, PixelD jarg2_);
  public final static native boolean PixelD_notequal(long jarg1, PixelD jarg1_, long jarg2, PixelD jarg2_);
  public final static native String PixelD_toString(long jarg1, PixelD jarg1_);
  public final static native boolean PixelD_isValid(long jarg1, PixelD jarg1_);
  public final static native void delete_PixelD(long jarg1);
  public final static native long new_Size__SWIG_0(long jarg1, long jarg2, long jarg3);
  public final static native long new_Size__SWIG_1(long jarg1, long jarg2);
  public final static native long new_Size__SWIG_2(long jarg1, Size jarg1_);
  public final static native long new_Size__SWIG_3(long jarg1, SizeD jarg1_);
  public final static native long Size_xsize(long jarg1, Size jarg1_);
  public final static native long Size_ysize(long jarg1, Size jarg1_);
  public final static native long Size_zsize(long jarg1, Size jarg1_);
  public final static native void Size_setXsize(long jarg1, Size jarg1_, long jarg2);
  public final static native void Size_setYsize(long jarg1, Size jarg1_, long jarg2);
  public final static native void Size_setZsize(long jarg1, Size jarg1_, long jarg2);
  public final static native java.math.BigInteger Size_linearSize(long jarg1, Size jarg1_);
  public final static native long Size_add(long jarg1, Size jarg1_, long jarg2, Size jarg2_);
  public final static native long Size_subtract(long jarg1, Size jarg1_, long jarg2, Size jarg2_);
  public final static native long Size_multiply(long jarg1, Size jarg1_, double jarg2);
  public final static native boolean Size_equal(long jarg1, Size jarg1_, long jarg2, Size jarg2_);
  public final static native boolean Size_notequal(long jarg1, Size jarg1_, long jarg2, Size jarg2_);
  public final static native boolean Size___contains____SWIG_0(long jarg1, Size jarg1_, long jarg2, Coordinate jarg2_);
  public final static native boolean Size___contains____SWIG_1(long jarg1, Size jarg1_, long jarg2, Pixel jarg2_);
  public final static native boolean Size___contains____SWIG_2(long jarg1, Size jarg1_, long jarg2, PixelD jarg2_);
  public final static native String Size_toString(long jarg1, Size jarg1_);
  public final static native boolean Size_isValid(long jarg1, Size jarg1_);
  public final static native void delete_Size(long jarg1);
  public final static native long new_SizeD__SWIG_0(double jarg1, double jarg2, double jarg3);
  public final static native long new_SizeD__SWIG_1(double jarg1, double jarg2);
  public final static native long new_SizeD__SWIG_2(long jarg1, Size jarg1_);
  public final static native long new_SizeD__SWIG_3(long jarg1, SizeD jarg1_);
  public final static native double SizeD_xsize(long jarg1, SizeD jarg1_);
  public final static native double SizeD_ysize(long jarg1, SizeD jarg1_);
  public final static native double SizeD_zsize(long jarg1, SizeD jarg1_);
  public final static native void SizeD_setXsize(long jarg1, SizeD jarg1_, double jarg2);
  public final static native void SizeD_setYsize(long jarg1, SizeD jarg1_, double jarg2);
  public final static native void SizeD_setZsize(long jarg1, SizeD jarg1_, double jarg2);
  public final static native java.math.BigInteger SizeD_linearSize(long jarg1, SizeD jarg1_);
  public final static native long SizeD_add(long jarg1, SizeD jarg1_, long jarg2, SizeD jarg2_);
  public final static native long SizeD_subtract(long jarg1, SizeD jarg1_, long jarg2, SizeD jarg2_);
  public final static native long SizeD_multiply(long jarg1, SizeD jarg1_, double jarg2);
  public final static native boolean SizeD_equal(long jarg1, SizeD jarg1_, long jarg2, SizeD jarg2_);
  public final static native boolean SizeD_notequal(long jarg1, SizeD jarg1_, long jarg2, SizeD jarg2_);
  public final static native boolean SizeD___contains____SWIG_0(long jarg1, SizeD jarg1_, long jarg2, Coordinate jarg2_);
  public final static native boolean SizeD___contains____SWIG_1(long jarg1, SizeD jarg1_, long jarg2, Pixel jarg2_);
  public final static native boolean SizeD___contains____SWIG_2(long jarg1, SizeD jarg1_, long jarg2, PixelD jarg2_);
  public final static native String SizeD_toString(long jarg1, SizeD jarg1_);
  public final static native boolean SizeD_isValid(long jarg1, SizeD jarg1_);
  public final static native void delete_SizeD(long jarg1);
  public final static native long new_Box__SWIG_0();
  public final static native long new_Box__SWIG_1(String jarg1);
  public final static native long new_Box__SWIG_2(long jarg1, Pixel jarg1_, long jarg2, Pixel jarg2_);
  public final static native long new_Box__SWIG_3(long jarg1, Size jarg1_);
  public final static native long Box_minCorner(long jarg1, Box jarg1_);
  public final static native long Box_maxCorner(long jarg1, Box jarg1_);
  public final static native long Box_size(long jarg1, Box jarg1_);
  public final static native boolean Box_is3D(long jarg1, Box jarg1_);
  public final static native boolean Box___contains____SWIG_0(long jarg1, Box jarg1_, long jarg2, Pixel jarg2_);
  public final static native boolean Box___contains____SWIG_1(long jarg1, Box jarg1_, long jarg2, Box jarg2_);
  public final static native boolean Box_equal(long jarg1, Box jarg1_, long jarg2, Box jarg2_);
  public final static native boolean Box_notequal(long jarg1, Box jarg1_, long jarg2, Box jarg2_);
  public final static native String Box_toString(long jarg1, Box jarg1_);
  public final static native boolean Box_isValid(long jarg1, Box jarg1_);
  public final static native void delete_Box(long jarg1);
  public final static native long new_Envelope__SWIG_0();
  public final static native long new_Envelope__SWIG_1(String jarg1);
  public final static native long new_Envelope__SWIG_2(long jarg1, Coordinate jarg1_, long jarg2, Coordinate jarg2_);
  public final static native long new_Envelope__SWIG_3(long jarg1, SizeD jarg1_);
  public final static native long Envelope_minCorner(long jarg1, Envelope jarg1_);
  public final static native long Envelope_maxCorner(long jarg1, Envelope jarg1_);
  public final static native long Envelope_size(long jarg1, Envelope jarg1_);
  public final static native boolean Envelope_is3D(long jarg1, Envelope jarg1_);
  public final static native boolean Envelope___contains____SWIG_0(long jarg1, Envelope jarg1_, long jarg2, Coordinate jarg2_);
  public final static native boolean Envelope___contains____SWIG_1(long jarg1, Envelope jarg1_, long jarg2, Envelope jarg2_);
  public final static native boolean Envelope_equal(long jarg1, Envelope jarg1_, long jarg2, Envelope jarg2_);
  public final static native boolean Envelope_notequal(long jarg1, Envelope jarg1_, long jarg2, Envelope jarg2_);
  public final static native String Envelope_toString(long jarg1, Envelope jarg1_);
  public final static native boolean Envelope_isValid(long jarg1, Envelope jarg1_);
  public final static native void delete_Envelope(long jarg1);
  public final static native long new_GeoReference(String jarg1);
  public final static native long GeoReference_toGeoReference(long jarg1, IObject jarg1_);
  public final static native long GeoReference_coordinateSystem(long jarg1, GeoReference jarg1_);
  public final static native void GeoReference_setCoordinateSystem(long jarg1, GeoReference jarg1_, long jarg2, CoordinateSystem jarg2_);
  public final static native long GeoReference_pixel2Coord__SWIG_0(long jarg1, GeoReference jarg1_, long jarg2, PixelD jarg2_);
  public final static native long GeoReference_pixel2Coord__SWIG_1(long jarg1, GeoReference jarg1_, long jarg2, Pixel jarg2_);
  public final static native long GeoReference_coord2Pixel(long jarg1, GeoReference jarg1_, long jarg2, Coordinate jarg2_);
  public final static native long GeoReference_box2Envelope(long jarg1, GeoReference jarg1_, long jarg2, Box jarg2_);
  public final static native long GeoReference_envelope2Box(long jarg1, GeoReference jarg1_, long jarg2, Envelope jarg2_);
  public final static native double GeoReference_pixelSize(long jarg1, GeoReference jarg1_);
  public final static native long GeoReference_size(long jarg1, GeoReference jarg1_);
  public final static native void GeoReference_setSize(long jarg1, GeoReference jarg1_, long jarg2, Size jarg2_);
  public final static native boolean GeoReference_centerOfPixel(long jarg1, GeoReference jarg1_);
  public final static native void GeoReference_setCenterOfPixel(long jarg1, GeoReference jarg1_, boolean jarg2);
  public final static native boolean GeoReference_isCompatible(long jarg1, GeoReference jarg1_, long jarg2, GeoReference jarg2_);
  public final static native boolean GeoReference_compute(long jarg1, GeoReference jarg1_);
  public final static native java.math.BigInteger GeoReference_ilwisType(long jarg1, GeoReference jarg1_);
  public final static native void delete_GeoReference(long jarg1);
  public final static native long new_vectori__SWIG_0();
  public final static native long new_vectori__SWIG_1(long jarg1);
  public final static native long vectori_size(long jarg1, vectori jarg1_);
  public final static native long vectori_capacity(long jarg1, vectori jarg1_);
  public final static native void vectori_reserve(long jarg1, vectori jarg1_, long jarg2);
  public final static native boolean vectori_isEmpty(long jarg1, vectori jarg1_);
  public final static native void vectori_clear(long jarg1, vectori jarg1_);
  public final static native void vectori_add(long jarg1, vectori jarg1_, int jarg2);
  public final static native int vectori_get(long jarg1, vectori jarg1_, int jarg2);
  public final static native void vectori_set(long jarg1, vectori jarg1_, int jarg2, int jarg3);
  public final static native void delete_vectori(long jarg1);
  public final static native long new_vectord__SWIG_0();
  public final static native long new_vectord__SWIG_1(long jarg1);
  public final static native long vectord_size(long jarg1, vectord jarg1_);
  public final static native long vectord_capacity(long jarg1, vectord jarg1_);
  public final static native void vectord_reserve(long jarg1, vectord jarg1_, long jarg2);
  public final static native boolean vectord_isEmpty(long jarg1, vectord jarg1_);
  public final static native void vectord_clear(long jarg1, vectord jarg1_);
  public final static native void vectord_add(long jarg1, vectord jarg1_, double jarg2);
  public final static native double vectord_get(long jarg1, vectord jarg1_, int jarg2);
  public final static native void vectord_set(long jarg1, vectord jarg1_, int jarg2, double jarg3);
  public final static native void delete_vectord(long jarg1);
  public final static native long new_mapsd__SWIG_0();
  public final static native long new_mapsd__SWIG_1(long jarg1, mapsd jarg1_);
  public final static native long mapsd_size(long jarg1, mapsd jarg1_);
  public final static native boolean mapsd_empty(long jarg1, mapsd jarg1_);
  public final static native void mapsd_clear(long jarg1, mapsd jarg1_);
  public final static native double mapsd_get(long jarg1, mapsd jarg1_, String jarg2);
  public final static native void mapsd_set(long jarg1, mapsd jarg1_, String jarg2, double jarg3);
  public final static native void mapsd_del(long jarg1, mapsd jarg1_, String jarg2);
  public final static native boolean mapsd_has_key(long jarg1, mapsd jarg1_, String jarg2);
  public final static native void delete_mapsd(long jarg1);
  public final static native long IlwisObject_SWIGUpcast(long jarg1);
  public final static native long CoordinateSystem_SWIGUpcast(long jarg1);
  public final static native long GeoReference_SWIGUpcast(long jarg1);
}
