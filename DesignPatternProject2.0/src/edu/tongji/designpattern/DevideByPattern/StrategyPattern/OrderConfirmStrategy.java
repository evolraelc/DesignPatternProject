package edu.tongji.designpattern.DevideByPattern.StrategyPattern;


import edu.tongji.designpattern.CommonClass.Items.Item;
import edu.tongji.designpattern.CommonClass.Order.Order;
import edu.tongji.designpattern.DevideByPattern.IteratorPattern.ItemIterator;

public class OrderConfirmStrategy implements OrderRecordingStrategy {
    @Override
    public Order execute(Item dish, Order order) {
        ItemIterator iter = (ItemIterator) order.createIterator();
        while (iter.hasNext()){
            Item item = iter.getNext();
            System.out.println("confirm dish "+item.getName());
        }
        order.setTypeToDetermined();
        return order;
    }
}
