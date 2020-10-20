package com.example.developer;

import java.io.ObjectStreamException;
import java.util.HashMap;

public class Singleton {
    //double check locked
    private static Singleton mInstance = null;//volatile
    private Singleton(){}
    public static Singleton getInstance(){
        if(mInstance == null){
            synchronized(Singleton.class){
                if(mInstance == null){
                    mInstance = new Singleton();
                }
            }
        }
        return mInstance;
    }

    //e han mode
    private static final Singleton eHanInstance = new Singleton();
    public static Singleton getEhanInstance(){
           return eHanInstance;
    }

    //Lan Han mode
    private static Singleton lanHanInstance = null;
    public static synchronized Singleton getLanHanInstance(){
        if(lanHanInstance == null){
             lanHanInstance = new Singleton();
        }
        return lanHanInstance;
    }

    //static inner class
    private static class SingletonHolder{
        private static final Singleton instance = new Singleton();
    }

    public static Singleton getStaticInstance(){
        return SingletonHolder.instance;
    }
    //avoid deserialization
    private Object readResolve() throws ObjectStreamException {
        return mInstance;
    }


}
