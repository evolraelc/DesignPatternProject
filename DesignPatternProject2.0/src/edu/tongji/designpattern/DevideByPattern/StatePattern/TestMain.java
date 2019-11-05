package edu.tongji.designpattern.DevideByPattern.StatePattern;


import edu.tongji.designpattern.CommonClass.Customer.Customer;
import edu.tongji.designpattern.CommonClass.Order.Order;
import edu.tongji.designpattern.DevideByPattern.PrototypeAndMemetoPattern.Memento;
import edu.tongji.designpattern.DevideByPattern.PrototypeAndMemetoPattern.OrderClone;

/**
 * @description:
 * @autho: Cheng
 * @created: 2019-11-05-13-28
 **/
public class TestMain {

    public static void main(String[] args) {
        //test for StatePattern
        Customer customer = new Customer();
        customer.setTime(8);
        customer.getState();
        customer.setTime(9);
        customer.getState();
        customer.setTime(11);
        customer.getState();
        customer.setTime(21);
        customer.getState();
        customer.setTime(31);
        customer.getState();
        customer.setTime(41);
        customer.getState();
    }
}


