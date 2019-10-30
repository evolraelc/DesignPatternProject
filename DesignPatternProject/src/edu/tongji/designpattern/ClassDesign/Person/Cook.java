package edu.tongji.designpattern.ClassDesign.Person;

public class Cook extends Employee {

    public Cook(String employeeID) {
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

    @Override
    protected void notifyChannel(BroadcastType broadcastType, String operation) {
        try{
            if (broadcastType == BroadcastType.ALL_EMPLOYEE){

            }
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }


}
