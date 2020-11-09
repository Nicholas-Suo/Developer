package com.example.developer.mode.FactoryMode;

import android.util.Log;

public class ProductB extends Product {
    private static final String TAG = "ProductA";
    @Override
    public void method() {
        Log.d(TAG,"this is product B");
    }
}
