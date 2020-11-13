package com.example.developer.mode.StateMode;

import android.util.Log;

public class PowerOnState extends TvState {

    @Override
    public void nextChannel() {
        Log.d(STATE_TAB," power on,next channel");
    }

    @Override
    public void preChannel() {
        Log.d(STATE_TAB,"power on,pre channel");
    }
}
