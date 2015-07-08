/* The ILWIS SWIG interface file*/

%module(docstring="The Java API for ILWIS Objects") ilwisobjects
%feature("autodoc","1");

%typemap(javacode) std::vector<double> "  public vectord(double[] array) {
	this();
    for ( double i : array )
      add( i );
  }";

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
#include "javaapi_error.h"
#include "javaapi_extension.h"
#include "javaapi_object.h"
#include "javaapi_ilwisoperation.h"
#include "javaapi_engine.h"
#include "javaapi_ilwisobject.h"
#include "javaapi_coordinatesystem.h"
#include "javaapi_table.h"
#include "javaapi_coverage.h"
#include "javaapi_util.h"
#include "javaapi_geometry.h"
#include "javaapi_feature.h"
#include "javaapi_featureiterator.h"
#include "javaapi_featurecoverage.h"
#include "javaapi_pixeliterator.h"
#include "javaapi_georeference.h"
#include "javaapi_rastercoverage.h"
#include "javaapi_range.h"
#include "javaapi_catalog.h"
#include "javaapi_domain.h"
#include "javaapi_datadefinition.h"
#include "javaapi_columndefinition.h"
#include "javaapi_domainitem.h"
#include "javaapi_rangeiterator.h"
#include "javaapi_vertexiterator.h"
%}

%include "javaapi_qtGNUTypedefs.h"

//catch std::exception's on all C API function calls
%exception{
    try {
        $action
    } catch (std::exception& e) {
        jenv->ThrowNew(jenv->FindClass("java/lang/Exception"),javaapi::get_err_message(e));
        //SWIG_fail;
    }
}

%rename(multiply) operator*=;
%rename(multiply) operator*;
%rename(equals) operator==;
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
%rename(add) __add__;
%rename(contains) __contains__;
%rename(iterator) __iter__;
%rename(toDouble) __float__;
%rename(toBigInteger) __int__;
%rename(set) __set__;
%rename(set) __setitem__;


%typemap(javainterfaces) javaapi::FeatureCoverage "Iterable<Feature>";
%typemap(javainterfaces) javaapi::FeatureIterator "Iterator<Feature>";
%typemap(javaimports) javaapi::FeatureIterator "import java.util.Iterator;";

%typemap(javainterfaces) javaapi::Geometry "Iterable<Coordinate>";
%typemap(javainterfaces) javaapi::VertexIterator "Iterator<Coordinate>";
%typemap(javaimports) javaapi::VertexIterator "import java.util.Iterator;";

%typemap(javainterfaces) javaapi::RasterCoverage "Iterable<Double>";
%typemap(javainterfaces) javaapi::PixelIterator "Iterator<Double>";
%typemap(javaimports) javaapi::PixelIterator "import java.util.Iterator;";
%typemap(javacode) javaapi::PixelIterator "  public Double next() { return _next(); }";

%include "javaapi_extension.h"

%include "javaapi_object.h"

%ignore operator=;

%include "javaapi_ilwisoperation.h"

%include "javaapi_engine.h"

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

%include "javaapi_table.h"

%include "javaapi_coverage.h"


%include "javaapi_object.h"


%include "javaapi_geometry.h"

%include "javaapi_feature.h"

%include "javaapi_featureiterator.h"

%include "javaapi_featurecoverage.h"

%include "javaapi_pixeliterator.h"

%include "javaapi_georeference.h"

%include "javaapi_rastercoverage.h"

%include "javaapi_catalog.h"

%include "javaapi_domain.h"
%typemap(javainterfaces) javaapi::NumericRange "Iterable<Double>";
%include "javaapi_range.h"


%include "javaapi_rangeiterator.h"

%typemap(javainterfaces) javaapi::RangeIterator<double, javaapi::NumericRange, double, Ilwis::NumericRange> "Iterator<Double>";
%typemap(javaimports) javaapi::RangeIterator<double, javaapi::NumericRange, double, Ilwis::NumericRange> "import java.util.Iterator;";
%typemap(javacode) javaapi::RangeIterator<double, javaapi::NumericRange, double, Ilwis::NumericRange> "  public Double next() { return current(); }";
%template(NumericRangeIterator) javaapi::RangeIterator<double, javaapi::NumericRange, double, Ilwis::NumericRange>;
//%template(ItemRangeIterator) javaapi::RangeIterator<javaapi::DomainItem, javaapi::ItemRange, Ilwis::SPDomainItem, Ilwis::ItemRange>;

%include "javaapi_datadefinition.h"

%include "javaapi_columndefinition.h"

%include "javaapi_domainitem.h"

%include "javaapi_vertexiterator.h"

//%include "javaapi_error.h"

	/*
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
	*/
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
   %template(vectorl) vector<quint32>;
   %template (mapsd) map<std::string, double>;
   %template (vectorvs) vector<std::vector<std::string> >;
   %template (vectors) vector<std::string>;
   %template (vectorOperation) vector<javaapi::IlwisOperation>;
};

%pragma(java) moduleimports=%{
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
%} 
%pragma(java) modulecode=%{
  public static String getsUNDEF() { return "?"; }
  public static int getshUNDEF() { return 32767; }
  public static float getFlUNDEF() { return (float)1e38; }
  private static boolean libLoaded = false;
  public final static String ilwisLocation = getIlwisLocation();
  
  public static void initIlwisObjects(String ilwisLocation) throws UnsatisfiedLinkError, SecurityException, IllegalArgumentException {
		if (!libLoaded) {
			try {
				System.loadLibrary("lib/_ilwisobjects0");
				ilwisobjects._initIlwisObjects(ilwisLocation);

				Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
					public void run() {
						ilwisobjects._exitIlwisObjects();
					}
				}));
			} finally {
				libLoaded = true;
			}
		}
	}
	
	private static String getIlwisLocation() {
		BufferedReader br = null;
		URL input = ClassLoader.getSystemResource("ilwislocation.config");
		try {
			String line;
			 
			br = new BufferedReader(new InputStreamReader( input.openStream() ));
 
			while ((line = br.readLine()) != null) {
				if (line.indexOf("=") == -1) {
					continue;
				}
				String[] lineSplit = line.split("=");
				if (lineSplit[0].equals("ilwisDir")) {
					return ( lineSplit[1] );
				}
				throw new FileNotFoundException("ilwislocation.config not well-formed");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}
  
  
%}



	
