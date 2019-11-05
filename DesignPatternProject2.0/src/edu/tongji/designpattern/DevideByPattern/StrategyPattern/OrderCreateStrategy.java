package edu.tongji.designpattern.DevideByPattern.StrategyPattern;


import edu.tongji.designpattern.CommonClass.Items.Item;
import edu.tongji.designpattern.CommonClass.Order.Order;

public class OrderCreateStrategy implements OrderRecordingStrategy {
    @Override
    public Order execute(Item dish, Order order) {
        return new Order();
    }
}
