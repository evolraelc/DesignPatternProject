package edu.tongji.designpattern.meal;



import edu.tongji.designpattern.procedure.Operation;

import java.util.Hashtable;

public class Sushi extends Dish{
	Sushi(){
		this.name="salad";
		this.ID=1;
		this.Price=20;
	}
	@Override
	void initOperations() {
		Hashtable<String, Integer> ingredients = new Hashtable<>();
		ingredients.put("nori", 1);
		ingredients.put("rice", 2);
		ingredients.put("fish", 1);
		ingredients.put("cucumber", 2);
		this.operationList.add(new Operation(ingredients, "fetch"));
		this.operationList.add(new Operation("fish", 1, "cutlery"));
		this.operationList.add(new Operation("cucumber", 2, "cutlery"));
	}
}
