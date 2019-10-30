package edu.tongji.designpattern.ClassDesign.Person;

public class Manager extends Employee {
    public Manager(String employeeID) {
        super(employeeID);
    }

    @Override
    public void changeTmp() {

    }

    @Override
    public void update() {

    }

    @Override
    public void settleComplaint() {

    }

    @Override
    public void getMessage(String msg) {

    }

    @Override
    public void sendMessage() {

    }

    public boolean notifyWaitersToService(){
        if (this.myInterphoneChannel == null)
            return false;
        return this.myInterphoneChannel.notify(this,
                    "new service",
                    BroadcastType.ALL_EMPLOYEE);
    }

    @Override
    protected void notifyChannel(BroadcastType broadcastType, String operation) {

    }


}
