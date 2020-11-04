package com.example.developer.mode.OriginMode;

public class LoginSession {
       private User user = null;
       //private static LoginSession mInstance = null;
       private LoginSession(){}

       public static LoginSession getInstance(){
           return  LoginSessionHolder.instance;
       }

       private static class LoginSessionHolder{
           private static final LoginSession instance = new LoginSession();
       }

    public User getUser() {
        return user.clone();
    }

    protected void setUser(User user){
           this.user = user;
    }
}
