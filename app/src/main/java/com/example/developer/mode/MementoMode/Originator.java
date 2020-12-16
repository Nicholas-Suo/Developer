package com.example.developer.mode.MementoMode;

public class Originator {
    String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento createMemento(){
        Memento memento = new Memento();
        memento.setState(state);
        return memento;
    }

    public String getStateFromMemento(Memento memento){
        return memento.getState();
    }

    private void testMemento(){
        state = "begin";
        //then stop,need save the sate

        Memento memento = createMemento();
        CareTaker careTaker = new CareTaker();
        careTaker.storeMemento(memento);
        //the state = resume,need restore the state
        state = getStateFromMemento(careTaker.getMemento(0));
    }
}
