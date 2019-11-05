package edu.tongji.designpattern.dispatch;

import edu.tongji.designpattern.CommonClass.Order.Order;
import edu.tongji.designpattern.meal.Meal;
import edu.tongji.designpattern.meal.MealBuilder;

import java.util.*;

/**
 * @author 感觉好想睡觉
 * @date 2019/11/2 15:54
 * @description 订单调度类
 * @project MagicRestaurant
 */
public class OrderDispatcher implements Runnable{
    //订单队列
    private Queue<Order> orderQueue = new LinkedList<Order>();
    //套餐集合
    private List<Meal> mealList = new ArrayList<>();
    //构造函数开启调度线程
    public OrderDispatcher() {
        new Thread(this).start();
    }
    //添加新订单
    public synchronized void addOrder(Order order) {
        orderQueue.offer(order);
    }
    @Override
    public void run() {
        while (true) {
            //休眠
            while(mealList.isEmpty() && orderQueue.isEmpty()) {
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //为订单成成Meal并分配厨师
            if(!orderQueue.isEmpty()) {
                Order order = orderQueue.poll();
                MealBuilder mealBuilder = new MealBuilder(order);
                Meal meal = mealBuilder.prepareMeal();
                mealList.add(meal);
            }
            //检测有无Meal做好
            detectMealState();
        }
    }

    private void detectMealState() {
        Iterator<Meal> iterator = mealList.iterator();
        while (iterator.hasNext()) {
            Meal meal = iterator.next();
            if (meal.isFinished()) {
                System.out.println("classname:" + this.getClass().getName() + " method:detectMealState action desc:" +
                        "订单" + meal.getID() + "号已完成");
                meal.getOrder().setOrderState(1);
                iterator.remove();
            }
        }
    }
}
