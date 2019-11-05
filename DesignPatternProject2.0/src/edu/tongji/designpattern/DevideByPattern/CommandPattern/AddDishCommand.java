package edu.tongji.designpattern.DevideByPattern.CommandPattern;


import edu.tongji.designpattern.CommonClass.Customer.Customer;
import edu.tongji.designpattern.CommonClass.Employee.Waiter;
import edu.tongji.designpattern.CommonClass.Items.Item;


public class AddDishCommand extends OrderPadCommand {

    public AddDishCommand(Waiter rec, Customer send, Item dish){
        super(rec, send);
        this.dish = dish;
    }

    @Override
    public void execute() {
        this.receiver.addDishForCustomer(this.dish);
    }
}
