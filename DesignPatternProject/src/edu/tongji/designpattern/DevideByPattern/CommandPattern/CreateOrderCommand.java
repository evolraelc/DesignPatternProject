package edu.tongji.designpattern.DevideByPattern.CommandPattern;



import edu.tongji.designpattern.CommonClass.Customer.Customer;
import edu.tongji.designpattern.CommonClass.Employee.Waiter;

public class CreateOrderCommand extends OrderPadCommand {
    public CreateOrderCommand(Waiter rec, Customer send){
        super(rec, send);
    }
    @Override
    public void execute() {
        this.receiver.createOrderForCustomer();
    }
}
