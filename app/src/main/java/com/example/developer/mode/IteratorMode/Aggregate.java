package com.example.developer.mode.IteratorMode;

public interface Aggregate<T> {
    void add(T obj);
    void remove(T obj);
    Iterator iterator();
}
