package edu.tongji.designpattern.ClassDesign.Person;

import edu.tongji.designpattern.ClassDesign.Order.OrderAggregate;
import edu.tongji.designpattern.ClassDesign.Tools.InterPhoneChannel;

enum Gender{
    MALE, FEMALE
}



public abstract class Employee {
//    private AirConditionerAPI airConditionerAPI;
    protected OrderAggregate order;
    protected String employeeName;
    protected Gender employeeGender;
    protected Integer employeeAge;
    protected String employeeID;
    protected EmployeeTitle employeeTitle;
    public InterPhoneChannel myInterphoneChannel;


    public Employee(){

    }

    public abstract void changeTmp();
    public abstract void update();
    public abstract void settleComplaint();

    //// process the massage received
    public abstract void getMessage(String msg);

    public abstract void sendMessage();

    public Boolean setChannel(InterPhoneChannel channel){this.myInterphoneChannel = channel; return true;}
    protected abstract void notifyChannel(BroadcastType broadcastType, String operation);
    public EmployeeTitle getTitle(){return this.employeeTitle;}
    public String getEmployeeID(){return this.employeeID;}
}


