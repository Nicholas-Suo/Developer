package com.example.developer.mode.ResponsibilityMode;

import android.util.Log;

public class ManagerLeader extends AbstractLeader{

    @Override
    public int getMoneyLevel() {
        return 1000;
    }

    @Override
    public void processRequest() {
        Log.d(TAG,"ManagerLeader process request 1000");
    }
}
