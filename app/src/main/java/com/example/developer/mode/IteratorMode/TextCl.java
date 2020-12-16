package com.example.developer.mode.IteratorMode;

import android.util.Log;

public class TextCl {
   private static final String TAG = "TextCl";
    public void testIteratorMode(){
        Aggregate<String> aggregate = new ConcreteAggregate<>();
        aggregate.add("abc");
        aggregate.add("123");
        aggregate.add("456");
        aggregate.add("789");
        Iterator iterator = aggregate.iterator();
        while(iterator.hasNext()){
            Log.d(TAG," the value is: " + iterator.next());
        }
    }
}
