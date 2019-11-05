package edu.tongji.designpattern.DevideByPattern.DecoratorPattern;

import edu.tongji.designpattern.CommonClass.Employee.Cashier;
import edu.tongji.designpattern.CommonClass.Employee.Manager;
import edu.tongji.designpattern.CommonClass.Employee.Waiter;
import edu.tongji.designpattern.CommonClass.Order.Order;
import edu.tongji.designpattern.DevideByPattern.ChainofResponsibilityPattern.Complaint;

/**
 * @description:
 * @autho: Cheng
 * @created: 2019-11-05-13-28
 **/
public class TestMain {


    public static void main(String[] args) {

        //结账处理的测试
        Order order = new Order();
        order.setPrice(100.0);
        Cashier cashier = new Cashier();
        cashier.setOrder(order);
        cashier.setCouponType("N");

        VIPCashierDecorator vipCashierDecorator = new VIPCashierDecorator(cashier);
        vipCashierDecorator.settleAccount();
    }

}


