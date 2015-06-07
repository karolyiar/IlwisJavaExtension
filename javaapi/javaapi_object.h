#ifndef JAVAAPI_OBJECT_H
#define JAVAAPI_OBJECT_H

#include "javaapi_extension.h"

typedef quint64 IlwisTypes;

namespace javaapi{

    class Object{
    public:
        Object(){}
        virtual ~Object(){}
        virtual bool __bool__() const = 0;
        virtual std::string __str__() = 0;
        virtual IlwisTypes ilwisType() = 0;
    };

}
#endif // JAVAAPI_OBJECT_H
