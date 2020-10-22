package com.example.developer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    RecyclerView myRecyclerView;
    MyRecyclerViewAdapter myRecyclerViewAdapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        //setContentView(R.layout.motion_layout);
        setContentView(R.layout.card_view_item);
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