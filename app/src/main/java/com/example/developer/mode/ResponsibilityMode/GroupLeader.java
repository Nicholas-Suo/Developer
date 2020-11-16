package com.example.developer.mode.ResponsibilityMode;

import android.util.Log;

public class GroupLeader extends AbstractLeader{
    @Override
    public int getMoneyLevel() {
        return 500;
    }

    @Override
    public void processRequest() {
        Log.d(TAG," GroupLearder process 500");
    }
}
