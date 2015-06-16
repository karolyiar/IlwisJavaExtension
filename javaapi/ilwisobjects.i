/* The ILWIS SWIG interface file*/

%module(docstring="The Java API for ILWIS Objects") ilwisobjects

%feature("autodoc","1");

%include "exception.i"
%include "std_string.i"
%include "std_vector.i"
%include "std_pair.i"

%include "std_map.i"

%begin %{
   //#include <cmath>
%}

%{
#include "kernel.h"
#include "ilwisdata.h"
#include "../../IlwisCore/core/util/range.h"
#include "itemrange.h"

//#include "javaapi_pyobject.h"
#include "javaapi_error.h"
#include "javaapi_extension.h"
#include "javaapi_object.h"
//#include "javaapi_engine.h"
#include "javaapi_ilwisobject.h"
#include "javaapi_coordinatesystem.h"
//#include "javaapi_table.h"
//#include "javaapi_coverage.h"
#include "javaapi_util.h"
//#include "javaapi_geometry.h"
//#include "javaapi_feature.h"
//#include "javaapi_featureiterator.h"
//#include "javaapi_featurecoverage.h"
//#include "javaapi_pixeliterator.h"
#include "javaapi_georeference.h"
//#include "javaapi_rastercoverage.h"
#include "javaapi_range.h"
//#include "javaapi_catalog.h"
//#include "javaapi_domain.h"
//#include "javaapi_datadefinition.h"
//#include "javaapi_columndefinition.h"
#include "javaapi_domainitem.h"
#include "javaapi_rangeiterator.h"
//#include "javaapi_vertexiterator.h"
%}

%include "javaapi_qtGNUTypedefs.h"

//catch std::exception's on all C API function calls
%exception{
    try {
        $action
    }catch (std::exception& e) {
        //PyErr_SetString(javaapi::translate_Exception_type(e),javaapi::get_err_message(e));
        jenv->ThrowNew(jenv->FindClass("java/lang/Exception"),javaapi::get_err_message(e));
        //SWIG_fail;
		// TODO: Exception handling
    }
}

%rename(multiply) operator*=;
%rename(equal) operator==;
%rename(notequal) operator!=;
%rename(toString) __str__;
%rename(increase) operator+=;
%rename(decrease) operator-=;
%rename(add) operator+;
%rename(subtract) operator-;
%rename(divide) operator/=;
%rename(divide) __itruediv__;
%rename(contains) __constains__;
%rename(isValid) __bool__; // always?
%rename(get) __getitem__;
%rename(next) __next__;

%include "javaapi_extension.h"

%include "javaapi_object.h"

//%include "javaapi_engine.h"

%include "javaapi_ilwisobject.h"

%include "javaapi_coordinatesystem.h"

%include "javaapi_util.h"

%template(Pixel) javaapi::PixelTemplate<qint32>;
%template(PixelD) javaapi::PixelTemplate<double>;
%template(Size) javaapi::SizeTemplate<quint32>;
%template(SizeD) javaapi::SizeTemplate<double>;
%template(Box) javaapi::BoxTemplate<Ilwis::Location<qint32, false>, javaapi::PixelTemplate<qint32>, quint32>;
%template(Envelope) javaapi::BoxTemplate<Ilwis::Coordinate, javaapi::Coordinate, double>;
//%template(NumericStatistics) javaapi::ContainerStatistics<double>;

//%include "javaapi_table.h"

//%include "javaapi_coverage.h"


%include "javaapi_object.h"

/*
%include "javaapi_geometry.h"

%include "javaapi_feature.h"

%include "javaapi_featureiterator.h"

%include "javaapi_featurecoverage.h"

%include "javaapi_pixeliterator.h"
*/
%include "javaapi_georeference.h"

//%include "javaapi_rastercoverage.h"

//%include "javaapi_catalog.h"

//%include "javaapi_domain.h"

%include "javaapi_range.h"

%include "javaapi_rangeiterator.h"

%template(NumericRangeIterator) javaapi::RangeIterator<double, javaapi::NumericRange, double, Ilwis::NumericRange>;
//%template(ItemRangeIterator) javaapi::RangeIterator<javaapi::DomainItem, javaapi::ItemRange, Ilwis::SPDomainItem, Ilwis::ItemRange>;

//%include "javaapi_datadefinition.h"

//%include "javaapi_columndefinition.h"

%include "javaapi_domainitem.h"

//%include "javaapi_vertexiterator.h"



	
%{
#include "E:/Qt/5.2.1/mingw48_32/include/QtCore/QVariant"
#include "E:/Qt/5.2.1/mingw48_32/include/QtCore/QPoint"
#include "E:/Qt/5.2.1/mingw48_32/include/QtCore/QPointF"
#include "E:/Qt/5.2.1/mingw48_32/include/QtCore/QSize"
#include "E:/Qt/5.2.1/mingw48_32/include/QtCore/QSizeF"
#include "E:/Qt/5.2.1/mingw48_32/include/QtCore/QDateTime"
#include "E:/Qt/5.2.1/mingw48_32/include/QtCore/QDate"
#include "E:/Qt/5.2.1/mingw48_32/include/QtCore/QTime"
#include "E:/Qt/5.2.1/mingw48_32/include/QtCore/QLine"
#include "E:/Qt/5.2.1/mingw48_32/include/QtCore/QLineF"
#include "E:/Qt/5.2.1/mingw48_32/include/QtCore/QRegExp"
#include "E:/Qt/5.2.1/mingw48_32/include/QtCore/QRect"
#include "E:/Qt/5.2.1/mingw48_32/include/QtCore/QRectF"
#include "E:/Qt/5.2.1/mingw48_32/include/QtCore/QStringList"
#include "E:/Qt/5.2.1/mingw48_32/include/QtCore/QLocale"
#include "E:/Qt/5.2.1/mingw48_32/include/QtCore/QChar"
#include "E:/Qt/5.2.1/mingw48_32/include/QtCore/QBitArray"
#include "E:/Qt/5.2.1/mingw48_32/include/QtCore/QByteArray"
#include "E:/Qt/5.2.1/mingw48_32/include/QtCore/QList"
%}
	
/* QVariant -> jobject */

%typemap(in) QVariant * (jint size){
	// in ilwisobjects_wrap.cxx asdf1
	//int type = qMetaTypeId<JObjectWrapper>();
    //StaticCache *sc = StaticCache::instance();
	//switch ($input.userType()) {
	//	case QVariant::Invalid: $1 = 0; break;
	//}
	
    $1 = 0;	
}
	
/* This cleans up the memory we malloc'd before the function call */
%typemap(freearg) QVariant * {
	// in ilwisobjects_wrap.cxx
}
	
/* This allows a C function to return a QVariant as a Java Object */

%typemap(out) QVariant * {
	// in ilwisobjects_wrap.cxx

    struct {
        static jobject conv(JNIEnv *jenv, jclass jcls, const QVariant* result) {
            jclass clazz = 0;
            jmethodID constructor = 0;
            int i;
            switch ($1->userType()) {
                case QVariant::Invalid: return 0; break;
                case QVariant::Int:
                case QVariant::UInt:
                    clazz = jenv->FindClass("java/lang/Integer");
                    constructor = jenv->GetMethodID(clazz, "<init>", "(I)V");
                    return jenv->NewObject(clazz, constructor, $1->toInt());
                    break;
                case QVariant::List:
                    clazz = jenv->FindClass("java/lang/Object");
					QListIterator<QVariant> iter($1->toList());
                    jobjectArray jresultArray = jenv->NewObjectArray( $1->toList().size() , clazz, NULL);
                    constructor = jenv->GetMethodID(clazz, "<init>", "(O)V");
                    
                    i = 0;
                    while(iter.hasNext()) {
                        jenv->SetObjectArrayElement(jresultArray, i, jenv->NewObject(clazz, constructor, conv(jenv, jcls, &iter.next())) );
                        ++i;
                    }
                    return jresultArray;
                    break;
			}
			return 0;
        }
    } convert;
	
	jresult = convert.conv(jenv, jcls, $1);
}
	
/* These 3 typemaps tell SWIG what JNI and Java types to use */
%typemap(jni) QVariant * "jobject"
%typemap(jtype) QVariant * "Object"
%typemap(jstype) QVariant * "Object"

	
/* These 2 typemaps handle the conversion of the jtype to jstype typemap type
   and vice versa */
%typemap(javain) QVariant * "$javainput"
%typemap(javaout) QVariant * {
	// in ilwisobjects.java
    return $jnicall;
  }
	

namespace std {
   %template(vectori) vector<int>;
   %template(vectord) vector<double>;
   %template (mapsd) map<std::string, double>;
   %template (vectorvs) vector<std::vector<std::string> >;
   %template (vectors) vector<std::string>;
};

%pragma(java) modulecode=%{
  public final static vectord array(double[] array) {
    vectord result = new vectord();
    for ( double i : array ) {
      result.add( i );
    }
    return result;
  }
  
  public final static vectori array(int[] array) {
    vectori result = new vectori();
    for ( int i : array ) {
      result.add( i );
    }
    return result;
  }
%}
	
