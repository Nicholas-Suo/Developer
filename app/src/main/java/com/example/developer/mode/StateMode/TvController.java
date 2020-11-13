package com.example.developer.mode.StateMode;

public class TvController {
    TvState tvState = new PowerOffState();

    public void setTvState(TvState tvState) {
        this.tvState = tvState;
    }

    public void nextChannel(){
        tvState.nextChannel();
    }

    public void preChannel(){
        tvState.preChannel();
    }

    public void powerOn(){
        setTvState(new PowerOnState());
    }

    public void powerOff(){
        setTvState(new PowerOffState());
    }
}
