package com.example.developer.mode.ObserverMode;

public class ObservableInstance extends AbstractObservable<InterfaceObserver>{

    public void testObservers(){
          InterfaceObserver observerA = new ConcreteObserverA();
          InterfaceObserver observerB = new ConcreteObserverB();
          registerObserver(observerA);
          registerObserver(observerB);
    }
    @Override
    public void notifyDataSet() {

        for(int i= mObservers.size()-1; i>=0; i++){
            mObservers.get(i).onChange();
        }
    }
}
