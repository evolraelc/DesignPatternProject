package edu.tongji.designpattern.DevideByPattern.StrategyPattern;

import edu.tongji.designpattern.CommonClass.Items.Item;
import edu.tongji.designpattern.CommonClass.Order.*;

public class AddDishStrategy implements OrderRecordingStrategy {
    @Override
    public Order execute(Item dish, Order order) {
        order.addDish(dish);
        return order;
    }
}
