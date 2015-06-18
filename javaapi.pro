include(global.pri)

QT += core

TARGET = _ilwisobjects

TEMPLATE = lib

win32{
    DLLDESTDIR = $$PWD/../output/$$PLATFORM$$CONF/bin/extensions/$$TARGET
}

DESTDIR = $$PWD/../libraries/$$PLATFORM$$CONF/extensions/$$TARGET

JAVADIR = "E:\Program Files (x86)\Java\jdk1.8.0_31"

QMAKE_LFLAGS += -Wl,--add-stdcall-alias

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
    javaapi/javaapi_engine.h


SOURCES += \
    javaapi/ilwisobjects_wrap.cxx \
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
    javaapi/javaapi_engine.cpp


OTHER_FILES += \
    javaapi/ilwisobjects.i \
    javaapi/qt.conf \
    javaapi/ilwisobjects.conf \
    javaapi/LICENSE-2.0.txt \
    javaapi/README \
    javaapi/UPDATE \
    javaapi/CHANGELOG

LIBS += -L$$PWD/../libraries/$$PLATFORM$$CONF/ -lilwiscore \
        -L$$PWD/../libraries/$$PLATFORM$$CONF/ -llibgeos \
        -L$$JAVADIR/lib -ljvm

win32:CONFIG(release, debug|release): {
    QMAKE_CXXFLAGS_RELEASE += -O2
}

INCLUDEPATH += $$PWD/../ilwiscore/core \
               $$PWD/../external/geos \
               $$JAVADIR/include \
               $$JAVADIR/include/win32 \
DEPENDPATH += $$PWD/../ilwiscore/core \
              $$PWD/../external/geos \
