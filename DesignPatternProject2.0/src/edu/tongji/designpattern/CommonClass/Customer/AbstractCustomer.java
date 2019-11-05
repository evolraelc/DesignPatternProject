package edu.tongji.designpattern.CommonClass.Customer;

import edu.tongji.designpattern.CommonClass.Employee.Gender;

public abstract class AbstractCustomer {
    protected String customerName;
    protected Gender customerGender = Gender.MALE;
    protected VIPType viptype = VIPType.NONVIP;
    public abstract boolean isNull();
}
