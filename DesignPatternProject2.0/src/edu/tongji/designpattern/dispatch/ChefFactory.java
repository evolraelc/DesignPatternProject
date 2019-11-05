package edu.tongji.designpattern.dispatch;

import edu.tongji.designpattern.CommonClass.Items.Item;
import edu.tongji.designpattern.common.AbstractFactory;
import edu.tongji.designpattern.meal.Dish;

import java.util.HashMap;

//厨师工厂
public class ChefFactory extends AbstractFactory {
	private final String[] chefNames= {
			"John", "Mike", "Tina", "Maria", "Arthur"
	};

	//厨师工厂使用单例模式来创建对象
	private static ChefFactory chefFactory = new ChefFactory();

	private ChefFactory() {}

	public static ChefFactory getChefFactory() {
		return chefFactory;
	}

	//存放厨师，<厨师姓名，厨师对象>
	private static final HashMap<String, Chef>chefMap = new HashMap<>();

	//搜索空闲的厨师，如果有则返回厨师对象，没有则为空
	@Override
	public Chef searchFreeChef() {
		while (true) {
			for (String name : chefNames) {
				if (!getChef(name).getIsBusy()) {
					getChef(name).setIsBusy(true);
					return getChef(name);
				}
			}
		}
	}

	//享元模式创建厨师对象
	@Override
	public Chef getChef(String name) {
		Chef chef = chefMap.get(name);
		if(chef == null) {
			chef = new Chef(name);
			chefMap.put(name, chef);
		}
		return chef;
	}

	//厨师获得菜品
	@Override
	public Dish getDish(Item item) {
		return null;
	}
}
