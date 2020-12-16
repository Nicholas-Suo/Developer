package com.example.developer.mode.IteratorMode;

import java.util.List;

public class ConcreteIterator<T> implements Iterator<T>{
    List<T> dataList = null;
    int cursor = -1;
    public ConcreteIterator(List<T> dataList) {
        this.dataList = dataList;
    }

    @Override
    public boolean hasNext() {
        return dataList != null && cursor < dataList.size() - 1 ;
    }

    @Override
    public T next() {
        T obj = null;
        if(hasNext()){
            obj = this.dataList.get(cursor++);
        }

        return obj;
    }
}
