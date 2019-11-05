package edu.tongji.designpattern.DevideByPattern.StrategyPattern;

import edu.tongji.designpattern.CommonClass.Items.Item;
import edu.tongji.designpattern.CommonClass.Order.*;

public class AddDishStrategy implements OrderRecordingStrategy {
    public void addOrderPrice(Item dish, Order order){
        order.setPrice(order.getPrice() + dish.getPrice());
    }
    @Override
    public Order execute(Item dish, Order order) {
        order.addDish(dish);
        addOrderPrice(dish,order);
        return order;
    }
}
