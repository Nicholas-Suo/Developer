package com.example.developer.mode.ObserverMode;

import java.util.ArrayList;

public abstract class AbstractObservable<T> {
    public abstract void notifyDataSet();
    protected final ArrayList<T> mObservers = new ArrayList<T>();

    public void registerObserver(T observer){
          if(observer == null){
              throw new IllegalArgumentException("the observer obj is null");
          }
          synchronized(mObservers){
            if(mObservers.contains(observer)){
                throw new IllegalStateException(" the observer has exist");
            }
            mObservers.add(observer);
        }

    }

    public void unregisterObserver(T observer){
        if(observer == null){
            throw new IllegalArgumentException(" the observer is null");
        }
        synchronized(mObservers){
            int index = mObservers.indexOf(observer);
            if(index == -1){
                throw new IllegalStateException(" the observer does not exit");
            }

            mObservers.remove(index);
        }
    }

    public void unregisterAll(){
          synchronized(mObservers){
              mObservers.clear();
        }
    }

}
