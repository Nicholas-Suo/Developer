package com.example.developer.mode.CommandMode;

public class ConcreteCommand extends Command{
    Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }


    @Override
    public void execute() {
        receiver.action();
    }
}
