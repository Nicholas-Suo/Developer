package com.example.developer.mode.OriginMode;

import android.util.Log;

public class Login implements LoginInterface{

     private static final String TAG = "Origin_mode";
    @Override
    public void login() {
        //test the origin mode code
        User loginUser = new User();
        loginUser.setName("liuershu");
        loginUser.setPassword("123456");
        User.Address address = new User.Address("beijing");
        loginUser.setAddress(address);
        LoginSession mInstance = LoginSession.getInstance();
        mInstance.setUser(loginUser);
        Log.d(TAG,"wangsm,login information: " + loginUser.toString());
        //end the origin mode code
    }

    @Override
    public void updateUser() {

    }
}
