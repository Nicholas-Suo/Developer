package com.example.developer.mode.OriginMode;

import androidx.annotation.NonNull;

public class User implements Cloneable {
     private String name;
     private String password;
     private Address address;

     public static class Address {
         String address;
         public Address(String address){
             this.address = address;
         }
     }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", address=" + address.address +
                '}';
    }

    @NonNull
    @Override
    protected User clone()  {
        User user = null;
        try {
            user = (User)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return user;
    }
}

