package com.example.developer.mode.MementoMode;

import java.util.ArrayList;

public class CareTaker {
    ArrayList<Memento> mementos = new ArrayList<>();

    public void storeMemento(Memento memento){
        mementos.add(memento);
    }

    public Memento getMemento(int index){
       return  mementos.get(index);
    }

}
