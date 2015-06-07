include(global.pri)

QT += core

TARGET = _ilwisobjects

TEMPLATE = lib

win32{
    DLLDESTDIR = $$PWD/../output/$$PLATFORM$$CONF/bin/extensions/$$TARGET
}

DESTDIR = $$PWD/../libraries/$$PLATFORM$$CONF/extensions/$$TARGET

JAVADIR = "E:\Program Files (x86)\Java\jdk1.8.0_31"

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
    #javaapi/test.py \
    #javaapi/setup.py \
    javaapi/ilwisobjects.i \
    #javaapi/test.sh \
    #javaapi/test.bat \
    javaapi/qt.conf \
    javaapi/ilwisobjects.conf \
    javaapi/prepare_PATH.bat \
    javaapi/prepare_PATH.sh \
    #javaapi/paths.py \
    #javaapi/installerPy.nsi \
    javaapi/LICENSE-2.0.txt \
    javaapi/README \
    javaapi/UPDATE \
    javaapi/CHANGELOG

LIBS += -L$$PWD/../libraries/$$PLATFORM$$CONF/ -lilwiscore \
        -L$$PWD/../libraries/$$PLATFORM$$CONF/ -llibgeos \
        -L$$JAVADIR/lib -ljvm
        #-L../lib -ljvm

win32:CONFIG(release, debug|release): {
    QMAKE_CXXFLAGS_RELEASE += -O2
}

INCLUDEPATH += $$PWD/../ilwiscore/core \
               $$PWD/../external/geos \
               $$JAVADIR/include \
               $$JAVADIR/include/win32 \
DEPENDPATH += $$PWD/../ilwiscore/core \
              $$PWD/../external/geos

mytarget.files = $$PWD/../libraries/$$PLATFORM$$CONF/extensions/_ilwisobjects/_ilwisobjects.dll \
                    #javaapi/ilwisobjects.py \
                 javaapi/test.py \
                 javaapi/README \
                 javaapi/UPDATE \
                 javaapi/CHANGELOG

mytarget.path = $$PWD/../output/$$PLATFORM$$CONF/bin/extensions/javaapi

#java_target.files = javaapi/CHANGELOG
                    #javaapi/ilwisobjects.py \

#java_target.path = $$PYTHONDIR/Lib/site-packages

#install_target.files = javaapi/installerPy.nsi

#install_target.path = $$PWD/../output/$$PLATFORM$$CONF

#target.path = $$PYTHONDIR/Lib/site-packages

#INSTALLS += mytarget install_target java_target target
