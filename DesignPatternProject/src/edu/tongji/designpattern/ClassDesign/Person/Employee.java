package edu.tongji.designpattern.ClassDesign.Person;

import edu.tongji.designpattern.ClassDesign.Order.Order;

enum Gender{
    MALE, FEMALE
}

public abstract class Employee {
//    private AirConditionerAPI airConditionerAPI;
    private Order order;
    private String employeeName;
    private Gender employeeGender;
    private Integer employeeAge;
    public String employeeID;
//    public InterphoneChannel myInterphoneChannel;

    public abstract void changeTmp();
    public abstract void update();
    public abstract void settleComplaint();
    public abstract void getMessage();
    public abstract void sendMessage();

}


