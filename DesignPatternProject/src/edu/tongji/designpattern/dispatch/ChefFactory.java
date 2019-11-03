package edu.tongji.designpattern.dispatch;

import edu.tongji.designpattern.CommonClass.Items.Item;
import edu.tongji.designpattern.common.AbstractFactory;
import edu.tongji.designpattern.meal.Dish;

import java.util.HashMap;


public class ChefFactory extends AbstractFactory {
	private final String[] chefNames= {
			"John", "Mike", "Tina", "Maria", "Arthur"
	};

	private static ChefFactory chefFactory = new ChefFactory();

	private ChefFactory() {}

	public static ChefFactory getChefFactory() {
		return chefFactory;
	}
	
	private static final HashMap<String, Chef>chefMap = new HashMap<>();

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

	@Override
	public Chef getChef(String name) {
		Chef chef = chefMap.get(name);
		if(chef == null) {
			chef = new Chef(name);
			chefMap.put(name, chef);
		}
		return chef;
	}

	@Override
	public Dish getDish(Item item) {
		return null;
	}
}
