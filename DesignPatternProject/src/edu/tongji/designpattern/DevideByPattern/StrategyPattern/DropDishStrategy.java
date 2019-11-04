package edu.tongji.designpattern.DevideByPattern.StrategyPattern;


import edu.tongji.designpattern.CommonClass.Items.Item;
import edu.tongji.designpattern.CommonClass.Order.Order;


public class DropDishStrategy implements OrderRecordingStrategy {
    @Override
    public Order execute(Item dish, Order order) {
        if (order.removeDish(dish.getName())){
            System.out.println("drop dish"+dish.getName()+" success");
        }
        else
            System.out.println("dish not found");
        return order;
    }
}
