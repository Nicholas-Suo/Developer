package com.example.developer.mode.ObserverMode;

import android.util.Log;

public class ConcreteObserverB implements InterfaceObserver {
    @Override
    public void onChange() {
        Log.d("ConcreteObserverB","observerMode B show information");
    }
}
