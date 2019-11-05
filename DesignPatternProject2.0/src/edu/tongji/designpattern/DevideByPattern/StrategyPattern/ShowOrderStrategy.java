package edu.tongji.designpattern.DevideByPattern.StrategyPattern;

import edu.tongji.designpattern.CommonClass.Items.Item;
import edu.tongji.designpattern.CommonClass.Order.Order;
import edu.tongji.designpattern.DevideByPattern.IteratorPattern.ItemIterator;

public class ShowOrderStrategy implements OrderRecordingStrategy {
    @Override
    public Order execute(Item dish, Order order) {
        if (order == null){
            System.out.println("no order now!");
            return null;
        }
        ItemIterator iter = (ItemIterator) order.createIterator();
        while (iter.hasNext()){
            Item item = iter.getNext();
            System.out.println("show dish "+item.getName());
        }
        return order;
    }
}
