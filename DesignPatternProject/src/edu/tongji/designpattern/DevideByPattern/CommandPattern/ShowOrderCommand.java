package edu.tongji.designpattern.DevideByPattern.CommandPattern;

import edu.tongji.designpattern.CommonClass.Customer.Customer;
import edu.tongji.designpattern.CommonClass.Employee.Waiter;

public class ShowOrderCommand extends OrderPadCommand {
    @Override
    public void execute() {
        this.receiver.showOrderForCustomer();
    }

    public ShowOrderCommand(Waiter rec, Customer send){
        super(rec, send);
    }
}
