package com.example.developer.mode.ObserverMode;

import android.util.Log;

public class ConcreteObserverA implements InterfaceObserver {
    @Override
    public void onChange() {
        Log.d("ConcreteObserverA","observerMode A show information");
    }
}
