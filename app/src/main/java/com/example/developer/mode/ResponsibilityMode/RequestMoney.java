package com.example.developer.mode.ResponsibilityMode;

public class RequestMoney {

    public void requestMoney(int money){
        GroupLeader groupLeader = new GroupLeader();
        ManagerLeader managerLeader = new ManagerLeader();
        CeoLeader ceoLeader = new CeoLeader();
        groupLeader.nextLeader = managerLeader;
        managerLeader.nextLeader = ceoLeader;
        groupLeader.dispatchRequest(money);
    }


}
