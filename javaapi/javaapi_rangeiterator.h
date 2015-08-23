#ifndef JAVAAPI_RANGEITERATOR_H
#define JAVAAPI_RANGEITERATOR_H

#include "javaapi_qtGNUTypedefs.h"
#include <memory>

namespace Ilwis{
    template<typename OutputType, typename RangeType> class RangeIterator;
    class NumericRange;
    class ItemRange;
}

namespace javaapi{
    class Range;
    class NumericRange;
    class DomainItem;
    class ItemRange;

    template< class T >
    struct TypeIsDouble
    {
        static const bool value = false;
    };

    template<>
    struct TypeIsDouble< double >
    {
        static const bool value = true;
    };

template<typename OutputType, typename RangeType, typename IlwOutput, typename IlwRange> class RangeIterator{
public:
    RangeIterator(Range* rng);
    RangeIterator(const RangeIterator& iter);
    RangeIterator(Ilwis::RangeIterator<IlwOutput, IlwRange>* iter);

    ~RangeIterator();

    bool __bool__() const;
    std::string __str__();
    RangeIterator<OutputType, RangeType, IlwOutput, IlwRange>* __iter__();
    OutputType _next();
    bool hasNext();
    OutputType current();
    OutputType __getitem__(quint32 pos);

    RangeIterator<OutputType, RangeType, IlwOutput, IlwRange> __radd__(int n);
    RangeIterator<OutputType, RangeType, IlwOutput, IlwRange> operator+(int n);
    RangeIterator<OutputType, RangeType, IlwOutput,  IlwRange> operator+=(int n);
    RangeIterator<OutputType, RangeType, IlwOutput, IlwRange> operator-(int n);
    RangeIterator<OutputType, RangeType, IlwOutput, IlwRange> operator-=(int n);

    int compareTo(const RangeIterator<OutputType, RangeType, IlwOutput, IlwRange>& other);

    void setRange(Range* rng);

    void remove() { } // Filler function

protected:
    Ilwis::RangeIterator<IlwOutput, IlwRange>& ptr() const;
    std::shared_ptr<Ilwis::RangeIterator<IlwOutput, IlwRange>> _ilwisRangeIterator;
    std::shared_ptr<Ilwis::RangeIterator<IlwOutput, IlwRange>> _end;
    Range* _rng;

};

typedef RangeIterator<double, NumericRange, double, Ilwis::NumericRange> NumericRangeIterator;
//typedef RangeIterator<DomainItem, ItemRange, Ilwis::SPDomainItem, Ilwis::ItemRange> ItemRangeIterator;
}

#endif // JAVAAPI_RANGEITERATOR_H
