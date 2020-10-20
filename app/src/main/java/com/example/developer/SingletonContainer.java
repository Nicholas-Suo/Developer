package com.example.developer;

import java.util.HashMap;

public class SingletonContainer {
    //Singleton Containner
        private static  HashMap<String,Object> container = new HashMap<String,Object>();
        public static void registerContainer(String key,Object instance){
            if(!container.containsKey(key)){
                container.put(key,instance);
            }
        }

        public static Object getSingleton(String key){
            return container.get(key);
        }

}
