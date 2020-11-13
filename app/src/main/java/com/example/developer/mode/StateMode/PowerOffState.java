package com.example.developer.mode.StateMode;

import android.util.Log;

public class PowerOffState extends TvState {
    @Override
    public void nextChannel() {
        Log.d(STATE_TAB," power off,next channel");
    }

    @Override
    public void preChannel() {
        Log.d(STATE_TAB,"power off,pre channel");
    }
}
