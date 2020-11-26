package com.example.developer.mode.CommandMode;

public class Invoker {
    public void executeCommand(){
        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
        command.execute();
    }
    }

