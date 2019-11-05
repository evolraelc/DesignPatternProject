package edu.tongji.designpattern.dispatch;


import edu.tongji.designpattern.meal.Dish;
import edu.tongji.designpattern.meal.Meal;
import edu.tongji.designpattern.procedure.Operation;

import java.util.List;

public class Chef implements Runnable{
	private String name;
	private boolean isBusy;
	private Dish dish;
	private Meal meal;
	
	public Chef(String name) {
		this.name = name;
		this.dish = null;
		this.isBusy = false;
		this.meal = null;
	}

	public String getName() {
		return name;
	}

	//设置厨师状态
	public synchronized void setIsBusy(boolean isBusy) {
		this.isBusy = isBusy;
	}

	//获得厨师是否忙碌
	public boolean getIsBusy() {
		return isBusy;
	}

	//厨师设置所要做的菜品
	public void setWork(Dish dish, Meal meal) {
		this.dish = dish;
		this.meal = meal;
	}

	//厨师开启线程进行做菜
	public void cook(){
		new Thread(this).start();
	}

	//厨师做菜函数
	@Override
	public void run() {
		System.out.println("classname:" + this.getClass().getName() + " method name:run action desc:"
                + this.name + "开始制作订单" + meal.getID() + "号的" + dish.getName());
		List<Operation> operationList = dish.getOperationList();
		for(Operation operation : operationList){
			operation.execute();
		}
		System.out.println("classname:" + this.getClass().getName() + " method name:run action desc:"
				+ this.name + "做好了订单" + meal.getID() + "号的" + dish.getName());
		meal.addDish(dish);
		this.isBusy = false;
	}
}
