package edu.tongji.designpattern.meal;



import edu.tongji.designpattern.CommonClass.Order.Order;

import java.util.ArrayList;
import java.util.List;

public class Meal {
	private Order order;
	private List<Dish> orderedDishes = new ArrayList<>();

	Meal(Order order) {
		this.order = order;
	}

	public int getID() {
		return this.order.getID();
	}

	public synchronized void addDish(Dish dish) {
		this.orderedDishes.add(dish);
	}

	public boolean isFinished() {
		return order.getDishList().size() == orderedDishes.size();
	}
}
