package edu.tongji.designpattern.ClassDesign.Business.OrderRecording;

import edu.tongji.designpattern.ClassDesign.Order.Order;
import edu.tongji.designpattern.ClassDesign.Tools.Dish;

public class OrderConfirmStrategy implements OrderRecordingStrategy{
    @Override
    public Order execute(Dish dish, Order order) {
        var iter = order.createIterator();
        while (iter.hasNext()){
            var item = iter.getNext();
            System.out.println("confirm dish "+item.getDishID());
        }
        order.setTypeToDetermined();
        return order;
    }
}
