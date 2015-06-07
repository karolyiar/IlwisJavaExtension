#include "javaapi_qissuelogger.h"

//#include "javaapi_pyobject.h"

namespace javaapi{

    QIssueLogger::QIssueLogger(){
    }
    //QT SLOT
    void QIssueLogger::ilwiserrormessage(const Ilwis::IssueObject &issueObject){
        //log(issueObject.message().toStdString());
        // TODO error handling
    }
}
