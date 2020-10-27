package com.example.developer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.RemoteInput;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
//import android.app.RemoteInput;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG="Developer";
    private static final String MY_CHANNEL_ID="MY_CHANNEL_ID";

    RecyclerView myRecyclerView;
    MyRecyclerViewAdapter myRecyclerViewAdapter;
    RecyclerView.LayoutManager layoutManager;
    NotificationCompat.Builder notificationBuilder =null;
    NotificationManager notificationManager = null;
    NotificationManagerCompat notificationManagerCompat = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showFullScreenNotification();
        //showProgressNotification();
     //   showReplyNotification();
      //  notificationStartReceiver();
       // IntentFilter filter = new IntentFilter();
       // filter.addAction("ACTION_FROM_NOTIFICATION");
     //   registerReceiver(receiver,filter);

        //setContentView(R.layout.motion_layout);
       // setContentView(R.layout.card_view_item);
        //RecyclerView codes begin
/*          setContentView(R.layout.recycler_view_layout);
        myRecyclerView = findViewById(R.id.my_recycler_view);
        layoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(layoutManager);
        myRecyclerViewAdapter = new MyRecyclerViewAdapter();

        List<String> dataList = new ArrayList<>();
        for(int i=0;i<20;i++){
            String name = "RecyclerView_" + i;
            dataList.add(name);
        }
        myRecyclerViewAdapter.setDataList(dataList);
        myRecyclerView.setAdapter(myRecyclerViewAdapter);*/
        //RecyclerView codes end
    }

/*
    public BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
           Log.d(TAG," the broadcast is from notificaion");
        }
    };
*/
    private void showFullScreenNotification(){
        Intent intent = new Intent(this,FullScreenNotificationActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,1,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        notificationBuilder = new NotificationCompat.Builder(this,MY_CHANNEL_ID).setContentTitle("fullScreenNotificaion")
                .setContentText("it's full screen Notification")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setFullScreenIntent(pendingIntent,true);
        Notification notification = notificationBuilder.build();
        notificationManagerCompat = NotificationManagerCompat.from(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManagerCompat.createNotificationChannel(new NotificationChannel(MY_CHANNEL_ID,"FULL_SCREEN",NotificationManagerCompat.IMPORTANCE_DEFAULT));
        }
        notificationManagerCompat.notify(1,notification);
    }

    private void showProgressNotification(){
        notificationBuilder = new NotificationCompat.Builder(this,MY_CHANNEL_ID).setSmallIcon(R.drawable.ic_launcher_foreground)
                 .setContentTitle("NotificationProgress")
                .setContentText("Donwloading")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setProgress(100,0,false);
        Notification notification  = notificationBuilder.build();
         notificationManagerCompat = NotificationManagerCompat.from(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManagerCompat.createNotificationChannel(new NotificationChannel(MY_CHANNEL_ID,"ProgressBar",NotificationManager.IMPORTANCE_DEFAULT));
        }
        notificationManagerCompat.notify(1,notification);
    }
    private void showReplyNotification(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            RemoteInput remoteInput =  new RemoteInput.Builder("remote_input_key").setLabel("Reply").build();
            Intent receiveReplyReceiverIntent = new Intent(this,MyBroadcastReceiver.class);
            receiveReplyReceiverIntent.setAction("action.need.reply.msg");
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this,1,receiveReplyReceiverIntent,0);
            NotificationCompat.Action action = new NotificationCompat.Action.Builder(R.drawable.ic_launcher_foreground,"ReplyMsg",pendingIntent).addRemoteInput(remoteInput).build();
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this,MY_CHANNEL_ID).setContentTitle("testRemotInput")
                    .setContentText("this is content text")
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .addAction(action);
            notificationManagerCompat = NotificationManagerCompat.from(this);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    notificationManagerCompat.createNotificationChannel(new NotificationChannel(MY_CHANNEL_ID,"remoteInputReply",NotificationManager.IMPORTANCE_DEFAULT));
                }
            notificationManagerCompat.notify(1,builder.build());

        }
    }

    private void notificationStartReceiver(){
        Intent broadCastIntent = new Intent(this,MyBroadcastReceiver.class);
        broadCastIntent.setAction("action.from.notification");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,0,broadCastIntent,0);
        notificationBuilder = new NotificationCompat.Builder(this,MY_CHANNEL_ID).setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("start Broadcaset").setContentText("click button,start broadcastreceiver")
                 .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                 .addAction(R.drawable.ic_launcher_foreground,"startBroadcast",pendingIntent)
                 .setAutoCancel(true);
        notificationManagerCompat = NotificationManagerCompat.from(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManagerCompat.createNotificationChannel(new NotificationChannel(MY_CHANNEL_ID,"testBroadcast",NotificationManager.IMPORTANCE_DEFAULT));
        }
        notificationManagerCompat.notify(1,notificationBuilder.build());
    }
    public void NotificationStartActivity(){
        Intent notificationIntent = new Intent(this,NotificationActivity.class);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,notificationIntent,0);
        notificationBuilder = new NotificationCompat.Builder(this,"myChannelId");
        notificationBuilder.setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("test notification")
                .setContentText("this is my contexttext")
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true);
        notificationManagerCompat = NotificationManagerCompat.from(this);
        //notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // notificationManager.createNotificationChannel(new NotificationChannel("myChannelId","Developer", NotificationManager.IMPORTANCE_DEFAULT));
            notificationManagerCompat.createNotificationChannel(new NotificationChannel("myChannelId","Developer", NotificationManager.IMPORTANCE_DEFAULT));
        }
        // notificationManager.notify(1,notificationBuilder.build());
        notificationManagerCompat.notify(1,notificationBuilder.build());
    }
    public class MyRecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView myTextView;
        public MyRecyclerViewHolder(View view){
            super(view);
            //myTextView = view.findViewById(R.id.my_recycler_view_text);
            myTextView = view.findViewById(R.id.card_text_view_id);
        }
    }
    private class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewHolder>{
        List<String> dataList;

        public void setDataList(List<String> dataList) {
            this.dataList = dataList;
           // notifyDataSetChanged();
        }

        @NonNull
        @Override
        public MyRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
           // View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.recycler_view_item,parent,false);
            View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.card_view_item,parent,false);
            //TextView textView = (TextView)view.findViewById(R.id.my_recycler_view_text);
            MyRecyclerViewHolder viewHolder = new MyRecyclerViewHolder(view);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyRecyclerViewHolder holder, int position) {
                    String name = dataList.get(position);
                    Log.d(TAG," bindView position = " + position);
                    holder.myTextView.setText(name);
        }

        @Override
        public int getItemCount() {
            return dataList.size() > 0 ? dataList.size() : 0;
        }


    }

}