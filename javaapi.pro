QT += core sql network

TARGET = _ilwisobjects

TEMPLATE = lib

VERSION = 0.0.0.1

OUTDIR = $$PWD/output/$$PLATFORM$$CONF
PLATFORM = generic
CONFIG(debug, debug|release) {
CONF=debug
}

CONFIG(release, debug|release) {
CONF=release
}
linux{
    BOOST=/usr/include
    GEOSINCL=/usr/include
    GEOSLIB=/usr/lib
    SHAREDEXT=so
    PREFIXSHARED=lib
    INCLUDEPATH += $$GEOSINCL
    DEPENDPATH += $$GEOSINCL
    JAVADIR = /usr/lib/jvm/java-8-oracle

    LIBS += -L$$GEOSLIB/ -lgeos-3.4.2 \
            -L$$JAVADIR/jre/lib/amd64/server/ -ljvm
}
win32{
    PLATFORM = win32
    BOOST=../external
    SHAREDEXT=dll
    PREFIXSHARED=
    INCLUDEPATH += $$PWD/../external/geos
    DEPENDPATH += $$PWD/../external/geos

    DLLDESTDIR = $$PWD/../output/$$PLATFORM$$CONF/bin/extensions/$$TARGET
    JAVADIR = "E:\Program Files (x86)\Java\jdk1.8.0_31"
    QMAKE_LFLAGS += -Wl,--add-stdcall-alias

    LIBS += -L$$PWD/../libraries/$$PLATFORM$$CONF/ -llibgeos \
            -L$$JAVADIR/lib/ -ljvm
}

INCLUDEPATH += $$PWD/../IlwisCore/core \
               $$PWD/../external/geos \
               $$JAVADIR/include \
               $$JAVADIR/include/win32 \
               $$JAVADIR/include/linux
DEPENDPATH += $$PWD/../IlwisCore/core \
               $$PWD/../external/geos \

DESTDIR = $$PWD/../libraries/$$PLATFORM$$CONF/extensions/$$TARGET

LIBS += -L$$PWD/../libraries/$$PLATFORM$$CONF/ -lilwiscore

HEADERS += \
    javaapi/javaapi_util.h \
    javaapi/javaapi_qtGNUTypedefs.h \
    javaapi/javaapi_object.h \
    javaapi/javaapi_ilwisobject.h \
    javaapi/javaapi_extension.h \
    javaapi/javaapi_error.h \
    javaapi/javaapi_qissuelogger.h \
    javaapi/javaapi_coordinatesystem.h \
    javaapi/javaapi_georeference.h \
    javaapi/javaapi_domainitem.h \
    javaapi/javaapi_range.h \
    javaapi/javaapi_rangeiterator.h \
    javaapi/javaapi_domain.h \
    javaapi/javaapi_featurecoverage.h \
    javaapi/javaapi_geometry.h \
    javaapi/javaapi_vertexiterator.h \
    javaapi/javaapi_feature.h \
    javaapi/javaapi_datadefinition.h \
    javaapi/javaapi_columndefinition.h \
    javaapi/javaapi_coverage.h \
    javaapi/javaapi_featureiterator.h \
    javaapi/javaapi_table.h \
    javaapi/javaapi_catalog.h \
    javaapi/javaapi_rastercoverage.h \
    javaapi/javaapi_pixeliterator.h \
    javaapi/javaapi_engine.h \
    javaapi/javaapi_ilwisoperation.h


SOURCES += \
    javaapi/javaapi_util.cpp \
    javaapi/javaapi_ilwisobject.cpp \
    javaapi/javaapi_extension.cpp \
    javaapi/javaapi_error.cpp \
    javaapi/javaapi_qissuelogger.cpp \
    javaapi/javaapi_coordinatesystem.cpp \
    javaapi/javaapi_georeference.cpp \
    javaapi/javaapi_domainitem.cpp \
    javaapi/javaapi_range.cpp \
    javaapi/javaapi_rangeiterator.cpp \
    javaapi/javaapi_domain.cpp \
    javaapi/javaapi_featurecoverage.cpp \
    javaapi/javaapi_geometry.cpp \
    javaapi/javaapi_vertexiterator.cpp \
    javaapi/javaapi_feature.cpp \
    javaapi/javaapi_datadefinition.cpp \
    javaapi/javaapi_columndefinition.cpp \
    javaapi/javaapi_coverage.cpp \
    javaapi/javaapi_featureiterator.cpp \
    javaapi/javaapi_table.cpp \
    javaapi/javaapi_catalog.cpp \
    javaapi/javaapi_rastercoverage.cpp \
    javaapi/javaapi_pixeliterator.cpp \
    javaapi/javaapi_engine.cpp \
    javaapi/javaapi_ilwisoperation.cpp \
    javaapi/ilwisobjects_wrap.cxx

OTHER_FILES += \
    javaapi/ilwisobjects.i \
    javaapi/qt.conf \
    javaapi/ilwisobjects.conf \
    javaapi/LICENSE-2.0.txt \
    javaapi/README \
    javaapi/UPDATE \
    javaapi/CHANGELOG

QMAKE_CXXFLAGS += -std=c++11
QMAKE_CXXFLAGS += -Wno-unused-parameter
QMAKE_CXXFLAGS += -Wno-sign-compare
QMAKE_CXXFLAGS += -Wno-unused-local-typedefs
QMAKE_CXXFLAGS += -Wno-deprecated-declarations

## Hides warning generated by SWIG
#QMAKE_CXXFLAGS += -fno-strict-aliasing
#QMAKE_CXXFLAGS += -Wno-maybe-uninitialized

win32:CONFIG(release, debug|release): {
    QMAKE_CXXFLAGS_RELEASE += -O2
}

INCLUDEPATH += ../IlwisCore/core \
                ../IlwisCore/core/ilwisobjects \
                ../IlwisCore/core/ilwisobjects/geometry \
                ../IlwisCore/core/util \
                ../IlwisCore/core/ilwisobjects/geometry/geodeticdatum \
                ../IlwisCore/core/ilwisobjects/geometry/projection \
                ../IlwisCore/core/ilwisobjects/geometry/coordinatesystem \
                ../IlwisCore/core/ilwisobjects/geometry/georeference \
                ../IlwisCore/core/ilwisobjects/coverage \
                ../IlwisCore/core/ilwisobjects/table \
                ../IlwisCore/core/ilwisobjects/operation \
                ../IlwisCore/core/ilwisobjects/representation \
                ../IlwisCore/core/catalog \
                ../IlwisCore/core/ilwisobjects/domain \
                $$BOOST
