package com.example.developer.mode.IteratorMode;

import java.util.ArrayList;
import java.util.List;

public class ConcreteAggregate<T> implements Aggregate<T>{
    List<T> dataList = new ArrayList<>();

    @Override
    public void add(T obj) {
        dataList.add(obj);
    }

    @Override
    public void remove(T obj) {
        dataList.remove(obj);
    }

    @Override
    public Iterator iterator() {
        return new ConcreteIterator(dataList);
    }
}
