package edu.tongji.designpattern.CommonClass.Employee;


import edu.tongji.designpattern.CommonClass.BroadcastType;
import edu.tongji.designpattern.CommonClass.InterPhoneChannel;


public abstract class Employee {

//    protected Order order;
    protected Gender employeeGender;
    protected String employeeID;
    protected EmployeeTitle employeeTitle;
    public InterPhoneChannel myInterphoneChannel;

//    protected AirConditionerAPI airConditionerAPI;

    public Employee(String employeeID, EmployeeTitle employeeTitle){
        this.employeeID=employeeID;
        this.employeeTitle=employeeTitle;
    }
    //ruan
    public Employee() {

    }



    public abstract void changeTmp();
    public abstract void update();
    public abstract void settleComplaint();

    //// process the massage received
    public void getMessage(String msg){
        System.out.println(this.employeeID+" receive message "+msg);
    }



//    public Order getOrder() {
//        return order;
//    }
//
//    public void setOrder(Order order) {
//        this.order = order;
//    }

    public Boolean setChannel(InterPhoneChannel channel){this.myInterphoneChannel = channel; return true;}
    protected abstract void notifyChannel(BroadcastType broadcastType, String operation);
    public EmployeeTitle getTitle(){return this.employeeTitle;}
    public String getEmployeeID(){return this.employeeID;}
}


