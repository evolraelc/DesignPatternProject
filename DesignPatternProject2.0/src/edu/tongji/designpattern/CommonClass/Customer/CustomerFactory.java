package edu.tongji.designpattern.CommonClass.Customer;

import edu.tongji.designpattern.CommonClass.Employee.Gender;

public class CustomerFactory {

    public static AbstractCustomer getCustomer(String name, Gender customerGender,VIPType viptype){
        if (name.equals("")){
            return new NullCustomer();
        }
        return new Customer(name,customerGender,viptype);
    }
}
