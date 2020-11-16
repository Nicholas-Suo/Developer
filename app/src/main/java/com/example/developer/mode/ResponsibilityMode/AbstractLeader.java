package com.example.developer.mode.ResponsibilityMode;

import android.util.Log;

public abstract class AbstractLeader {
    protected static final String TAG = "AbstractLeader";
    protected AbstractLeader nextLeader;
    public abstract int getMoneyLevel();
    public abstract void processRequest();
    public final void dispatchRequest(int money){
            if(money  <= getMoneyLevel()){
                processRequest();
            }else if(nextLeader!= null){
                nextLeader.dispatchRequest(money);
            }else {
                Log.d(TAG," nobody can process it");
            }
    }
}
