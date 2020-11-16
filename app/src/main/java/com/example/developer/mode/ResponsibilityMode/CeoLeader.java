package com.example.developer.mode.ResponsibilityMode;

import android.util.Log;

public class CeoLeader extends AbstractLeader{
    @Override
    public int getMoneyLevel() {
        return 5000;
    }

    @Override
    public void processRequest() {
        Log.d(TAG," CeoLeader processed the 5000 request");
    }
}
