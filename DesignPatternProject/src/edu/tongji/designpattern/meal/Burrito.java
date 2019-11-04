package edu.tongji.designpattern.meal;

import edu.tongji.designpattern.procedure.Operation;

import java.util.Hashtable;

public class Burrito extends Dish{
	Burrito(){
		this.name="burrito";
		this.ID=1;
		this.Price=20;
	}
	@Override
	void initOperations() {
		// TODO Auto-generated method stub
		Hashtable<String, Integer> ingredients = new Hashtable<>();
		ingredients.put("tortilla", 1);
		ingredients.put("rice", 3);
		ingredients.put("chicken", 3);
		this.operationList.add(new Operation(ingredients, "fetch"));
		this.operationList.add(new Operation("chicken", 3, "cutlery"));
		this.operationList.add(new Operation(ingredients, "pan"));
	}
}
