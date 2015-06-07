/* The ILWIS SWIG interface file*/

%module(docstring="The Java API for ILWIS Objects") ilwisobjects

%feature("autodoc","1");

%include "exception.i"
%include "std_string.i"

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
//#include "javaapi_coordinatesystem.h"
//#include "javaapi_table.h"
//#include "javaapi_coverage.h"
#include "javaapi_util.h"
//#include "javaapi_geometry.h"
//#include "javaapi_feature.h"
//#include "javaapi_featureiterator.h"
//#include "javaapi_featurecoverage.h"
//#include "javaapi_pixeliterator.h"
//#include "javaapi_georeference.h"
//#include "javaapi_rastercoverage.h"
//#include "javaapi_range.h"
//#include "javaapi_catalog.h"
//#include "javaapi_domain.h"
//#include "javaapi_datadefinition.h"
//#include "javaapi_columndefinition.h"
//#include "javaapi_domainitem.h"
//#include "javaapi_rangeiterator.h"
//#include "javaapi_vertexiterator.h"
%}

%include "javaapi_qtGNUTypedefs.h"

//catch std::exception's on all C API function calls
%exception{
    try {
        $action
    }catch (std::exception& e) {
        //PyErr_SetString(javaapi::translate_Exception_type(e),javaapi::get_err_message(e));
        //SWIG_fail;
		// TODO: Exception handling
    }
}

%include "javaapi_extension.h"

%include "javaapi_object.h"

//%include "javaapi_engine.h"

%include "javaapi_ilwisobject.h"

//%include "javaapi_coordinatesystem.h"

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

%include "javaapi_georeference.h"

%include "javaapi_rastercoverage.h"

%include "javaapi_catalog.h"

%include "javaapi_domain.h"

%include "javaapi_range.h"

%include "javaapi_rangeiterator.h"

%template(NumericRangeIterator) javaapi::RangeIterator<double, javaapi::NumericRange, double, Ilwis::NumericRange>;
%template(ItemRangeIterator) javaapi::RangeIterator<javaapi::DomainItem, javaapi::ItemRange, Ilwis::SPDomainItem, Ilwis::ItemRange>;

%include "javaapi_datadefinition.h"

%include "javaapi_columndefinition.h"

%include "javaapi_domainitem.h"

%include "javaapi_vertexiterator.h"
*/










/* This tells SWIG to treat char ** as a special case when used as a parameter
   in a function call */
/*
%typemap(in) char ** (jint size) {
	// in ilwisobjects_wrap.cxx
    int i = 0;
    size = jenv->GetArrayLength($input);
    $1 = (char **) malloc((size+1)*sizeof(char *));
    for (i = 0; i<size; i++) {
        jstring j_string = (jstring)jenv->GetObjectArrayElement($input, i);
        const char * c_string = jenv->GetStringUTFChars(j_string, 0);
        $1[i] = (char*)malloc((strlen(c_string)+1)*sizeof(char));
        strcpy($1[i], c_string);
        jenv->ReleaseStringUTFChars(j_string, c_string);
        jenv->DeleteLocalRef(j_string);
    }
    $1[i] = 0;
}*/

/* This cleans up the memory we malloc'd before the function call */
/*%typemap(freearg) char ** {
	// in ilwisobjects_wrap.cxx
    int i;
    for (i=0; i<size$argnum-1; i++)
      free($1[i]);
    free($1);
}*/

/* This allows a C function to return a char ** as a Java String array */
/*%typemap(out) char ** {
	// in ilwisobjects_wrap.cxx
    int i;
    int len=0;
    jstring temp_string;
    const jclass clazz = jenv->FindClass("java/lang/String");

    while ($1[len]) len++;    
    jresult = jenv->NewObjectArray(len, clazz, NULL);
    for (i=0; i<len; i++) {
      temp_string = jenv->NewStringUTF(*result++);
      jenv->SetObjectArrayElement(jresult, i, temp_string);
      jenv->DeleteLocalRef(temp_string);
    }
}*/

/* These 3 typemaps tell SWIG what JNI and Java types to use */
/*%typemap(jni) char ** "jobjectArray"
%typemap(jtype) char ** "String[]"
%typemap(jstype) char ** "String[]"*/

/* These 2 typemaps handle the conversion of the jtype to jstype typemap type
   and vice versa */
/*%typemap(javain) char ** "$javainput"
%typemap(javaout) char ** {
	// in ilwisobjects.java
	//asdf64
    return $jnicall;
  }*/

/* Now a few test functions */
/*%inline %{

int print_args(char **argv) {
	// in ilwisobjects_wrap.cxx
    int i = 0;
    while (argv[i]) {
         printf("argv[%d] = %s\n", i, argv[i]);
         i++;
    }
    return i;
}

char **get_args() {
  static char *values[] = { "Dave", "Mike", "Susan", "John", "Michelle", 0};
  return &values[0];
}
%}*/
	
	/*
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
	*/
	
/* QVariant -> jobject */
/*
%typemap(in) QVariant * (jint size){
	// in ilwisobjects_wrap.cxx asdf1
	//int type = qMetaTypeId<JObjectWrapper>();
    //StaticCache *sc = StaticCache::instance();
	//switch ($input.userType()) {
	//	case QVariant::Invalid: $1 = 0; break;
	//}
	
    $1 = 0;	
}*/
	
/* This cleans up the memory we malloc'd before the function call */
/*%typemap(freearg) QVariant * {
	// asdf54
	// in ilwisobjects_wrap.cxx
}*/
	
/* This allows a C function to return a QVariant as a Java Object */
/*
%typemap(out) QVariant * {
	//asdf43
	// in ilwisobjects_wrap.cxx
	$1 = 0;
}*/
	
/* These 3 typemaps tell SWIG what JNI and Java types to use */
/*%typemap(jni) QVariant * "jobject"
%typemap(jtype) QVariant * "Object"
%typemap(jstype) QVariant * "Object"
*/
	
/* These 2 typemaps handle the conversion of the jtype to jstype typemap type
   and vice versa */
/*%typemap(javain) QVariant * "$javainput"
%typemap(javaout) QVariant * {
	// in ilwisobjects.java
	//asdf23
    return $jnicall;
  }*/
	
	
/*%inline %{
	QVariant* getQVariant() {
	// asdf6
	return new QVariant(12);
	}
%}*/
