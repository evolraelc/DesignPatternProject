package edu.tongji.designpattern.DevideByPattern.CommandPattern;


import edu.tongji.designpattern.CommonClass.Customer.Customer;
import edu.tongji.designpattern.CommonClass.Employee.Waiter;

public class ConfirmOrderCommand extends OrderPadCommand {
    public ConfirmOrderCommand(Waiter rec, Customer send){
        super(rec, send);

    }
    @Override
    public void execute() {
        this.receiver.confirmOrderForCustomer();
    }
}
