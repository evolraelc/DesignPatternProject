package edu.tongji.designpattern.DevideByPattern.StrategyPattern;


import edu.tongji.designpattern.CommonClass.Items.Item;
import edu.tongji.designpattern.CommonClass.Order.Order;


public class DropDishStrategy implements OrderRecordingStrategy {
    public void dropOrderPrice(Item dish, Order order){
        order.setPrice(order.getPrice() - dish.getPrice());
    }
    @Override
    public Order execute(Item dish, Order order) {
        if (order.removeDish(dish.getName())){
            System.out.println("drop dish"+dish.getName()+" success");
            dropOrderPrice(dish, order);
        }
        else
            System.out.println("dish not found");
        return order;
    }
}
