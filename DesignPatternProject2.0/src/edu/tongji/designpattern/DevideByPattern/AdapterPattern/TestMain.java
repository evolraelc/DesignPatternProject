package edu.tongji.designpattern.DevideByPattern.AdapterPattern;

import edu.tongji.designpattern.CommonClass.Employee.Cashier;
import edu.tongji.designpattern.CommonClass.Order.Order;

/**
 * @description:
 * @autho: Cheng
 * @created: 2019-11-05-13-28
 **/
public class TestMain {


    public static void main(String[] args) {
        //结账处理的测试
//        Order order = new Order();
//        order.setPrice(100.0);
//        Cashier cashier = new Cashier();
//        cashier.setOrder(order);
//        cashier.setCouponType("A");

        //通过优惠劵类型来结账,测试为A类型,获取打折比例
        RealDiscount realDiscount = new RealDiscount("A");
        System.out.printf("discount = "+realDiscount.getDiscount());
    }

}


