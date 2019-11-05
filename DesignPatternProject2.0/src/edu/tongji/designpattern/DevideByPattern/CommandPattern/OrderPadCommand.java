package edu.tongji.designpattern.DevideByPattern.CommandPattern;


import edu.tongji.designpattern.CommonClass.Customer.Customer;
import edu.tongji.designpattern.CommonClass.Employee.Waiter;
import edu.tongji.designpattern.CommonClass.Items.Item;
import edu.tongji.designpattern.CommonClass.Order.Order;

public abstract class OrderPadCommand {
    protected Waiter receiver = null;
    protected Order order = null;
    protected Item dish = null;
    protected Customer sender = null;

    public OrderPadCommand(Waiter rec, Customer sender){
        this.receiver = rec;
        this.sender = sender;
    }

    public abstract void execute();
}
