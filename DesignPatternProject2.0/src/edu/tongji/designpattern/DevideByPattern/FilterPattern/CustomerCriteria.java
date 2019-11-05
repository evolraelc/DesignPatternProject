package edu.tongji.designpattern.DevideByPattern.FilterPattern;



import edu.tongji.designpattern.CommonClass.Customer.Customer;

import java.util.List;

public abstract class CustomerCriteria {
    protected List<Customer> customerList = null;
    public CustomerCriteria(List<Customer> customerList){
        this.customerList = customerList;
    }
    public abstract void meetCriteria();
    public abstract boolean isMetCriteria(Customer customer);
}
