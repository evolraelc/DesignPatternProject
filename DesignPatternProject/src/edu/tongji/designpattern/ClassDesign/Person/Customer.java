package edu.tongji.designpattern.ClassDesign.Person;

import edu.tongji.designpattern.ClassDesign.Business.Command.*;
import edu.tongji.designpattern.ClassDesign.Order.Order;
import edu.tongji.designpattern.ClassDesign.Tools.Dish;

enum VIPType{
    VIP,NONVIP
}

public class Customer {
    private String customerName;
    private Gender customerGender;
    private int customerAge = 0;
    private VIPType viptype = VIPType.NONVIP;

    private OrderPadCommand myCommand;
    private Waiter servedWaiter;

    public Customer(String name){
        this.customerName = name;
    }

    public void served(Waiter wt){
        this.servedWaiter = wt;
    }

    public void serviceEnd(){
        this.servedWaiter.clearOrder();
        this.servedWaiter = null;
    }

    private void setMyCommand(OrderPadCommand cmd){
        if (this.servedWaiter != null)
            myCommand = cmd;
        else
            System.out.println("ERROR: no serving waiter!");
    }


    public void setVIPType(){this.viptype = VIPType.VIP;}
    public boolean isVIP(){return this.viptype == VIPType.VIP;}

    private void executeCommand(){
        this.myCommand.execute();
    }

    public void addDishDemand(Dish dish){
        AddDishCommand cmd = new AddDishCommand(this.servedWaiter,dish);
        this.setMyCommand(cmd);
        this.myCommand.execute();
    }

    public void dropDishDemand(Dish dish){
        DropDishCommand cmd = new DropDishCommand(this.servedWaiter,dish);
        this.setMyCommand(cmd);
        this.myCommand.execute();
    }

    public void createOrderDemand(Dish dish){
        CreateOrderCommand cmd = new CreateOrderCommand(this.servedWaiter);
        this.setMyCommand(cmd);
        this.myCommand.execute();
    }

    public void confirmOrderDemand(Dish dish){
        ConfirmOrderCommand cmd = new ConfirmOrderCommand(this.servedWaiter);
        this.setMyCommand(cmd);
        this.myCommand.execute();
    }

}
