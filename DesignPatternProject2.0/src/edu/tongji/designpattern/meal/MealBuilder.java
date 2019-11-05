package edu.tongji.designpattern.meal;


import edu.tongji.designpattern.CommonClass.Items.Item;
import edu.tongji.designpattern.CommonClass.Order.Order;
import edu.tongji.designpattern.common.FactoryProducer;
import edu.tongji.designpattern.common.Iterator;
import edu.tongji.designpattern.dispatch.Chef;
import edu.tongji.designpattern.dispatch.DishRepository;

public class MealBuilder {
	private Order order;
	public MealBuilder(Order order) { this.order = order; };
	public Meal prepareMeal(){
		Meal meal = new Meal(this.order);
		DishRepository dishRepository = new DishRepository(this.order);
		for(Iterator iterator = dishRepository.getIterator(); iterator.hasNext(); ){
			Item item = (Item) iterator.next();
			Dish dish = FactoryProducer.getFactory("dish").getDish(item);
			if(dish == null) {
				iterator.remove();
                continue;
            }
			Chef chef = FactoryProducer.getFactory("chef").searchFreeChef();
			chef.setWork(dish, meal);
			chef.cook();
		}
		return meal;
	}
}
