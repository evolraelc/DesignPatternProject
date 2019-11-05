package edu.tongji.designpattern.DevideByPattern.PrototypeAndMemetoPattern;

import edu.tongji.designpattern.CommonClass.Employee.Cashier;
import edu.tongji.designpattern.CommonClass.Order.Order;
import edu.tongji.designpattern.DevideByPattern.DecoratorPattern.VIPCashierDecorator;

/**
 * @description:
 * @autho: zhujitao
 * @created: 2019-11-05-13-28
 **/
public class TestMain {

    public static void main(String[] args) {

        //原型和备忘录模式的测试
        Order order = new Order();
        order.setPrice(100.0);

        OrderClone orderClone = new OrderClone(order);

        OrderClone orderClone1 = (OrderClone)orderClone.clone();
        Memento memento = new Memento();
        memento.addOrderClone(orderClone1);
        //memento.getOrderClone(1);
        int length = memento.getSize();
        System.out.println(memento.getOrderClone(length-1).getPrice());
    }

}


