package com.example.developer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "MyBroadcastReceiver";
    private static final String ACTION_FROM_NOTIFICATION = "action.from.notification";
    @Override
    public void onReceive(Context context, Intent intent) {
        if (ACTION_FROM_NOTIFICATION.equals(intent.getAction())) {
            Log.d(TAG," the broadcast is from notificaion");
        }

    }
}
