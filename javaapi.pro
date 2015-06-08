include(global.pri)

QT += core

TARGET = _ilwisobjects

TEMPLATE = lib

win32{
    DLLDESTDIR = $$PWD/../output/$$PLATFORM$$CONF/bin/extensions/$$TARGET
}

DESTDIR = $$PWD/../libraries/$$PLATFORM$$CONF/extensions/$$TARGET

JAVADIR = "E:\Program Files (x86)\Java\jdk1.8.0_31"

#QMAKE_CXXFLAGS_DEBUG += -Wl,--add-stdcall-alias
QMAKE_LFLAGS += -Wl,--add-stdcall-alias

HEADERS += \
    javaapi/javaapi_util.h \
    javaapi/javaapi_qtGNUTypedefs.h \
    javaapi/javaapi_object.h \
    javaapi/javaapi_ilwisobject.h \
    javaapi/javaapi_extension.h \
    javaapi/javaapi_error.h \
    javaapi/javaapi_qissuelogger.h


SOURCES += \
    javaapi/ilwisobjects_wrap.cxx \
    javaapi/javaapi_util.cpp \
    javaapi/javaapi_ilwisobject.cpp \
    javaapi/javaapi_extension.cpp \
    javaapi/javaapi_error.cpp \
    javaapi/javaapi_qissuelogger.cpp


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
