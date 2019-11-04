package edu.tongji.designpattern.dispatch;

import edu.tongji.designpattern.CommonClass.Order.Order;
import edu.tongji.designpattern.DevideByPattern.StatePattern.OrderState;
import edu.tongji.designpattern.meal.Meal;
import edu.tongji.designpattern.meal.MealBuilder;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 感觉好想睡觉
 * @date 2019/11/2 15:54
 * @description 订单调度类
 * @project MagicRestaurant
 */
public class OrderDispatcher implements Runnable{
    private Queue<Order> orderQueue = new LinkedList<Order>();

    public void addOrder(Order order) {
        orderQueue.offer(order);
        if(orderQueue.size() == 1) {
            new Thread(this).start();
        }
    }
    @Override
    public void run() {
        do {
            Order order = orderQueue.poll();
            MealBuilder mealBuilder = new MealBuilder(order);
            Meal meal = mealBuilder.prepareMeal();
            order.setOrderState(1);
        } while(!orderQueue.isEmpty());
    }
}
