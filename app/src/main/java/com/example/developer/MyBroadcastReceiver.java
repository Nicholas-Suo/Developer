package com.example.developer;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.RemoteInput;

public class MyBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "MyBroadcastReceiver";
    private static final String ACTION_FROM_NOTIFICATION = "action.from.notification";
    private static  final String ACTION_NEED_REPLY_MSG = "action.need.reply.msg";
    private static final String MY_CHANNEL_ID="MY_CHANNEL_ID";
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.d(TAG," the action is:  " + action);
        if (ACTION_FROM_NOTIFICATION.equals(action)) {
            Log.d(TAG," the broadcast is from notificaion");
        } else if (ACTION_NEED_REPLY_MSG.equals(action)){//From notification,then we reply.
            Log.d(TAG," reply the msg");
           Bundle bundle = RemoteInput.getResultsFromIntent(intent);
           String msg = (String)bundle.get("remote_input_key");

            Log.d(TAG," the msg is: " + msg);
            Notification notification = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                notification = new Notification.Builder(context,MY_CHANNEL_ID).setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setContentText("we received msg")
                        .setRemoteInputHistory(new CharSequence[]{msg})
                        .build();
                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
                notificationManagerCompat.notify(1,notification);
            }

        }

    }
}
