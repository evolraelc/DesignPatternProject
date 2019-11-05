package edu.tongji.designpattern.meal;



import edu.tongji.designpattern.procedure.Operation;

import java.util.Hashtable;

public class Spaghetti extends Dish{
	Spaghetti(){
		this.name="spaghetti";
		this.ID=1;
		this.Price=20;
	}
	@Override
	void initOperations() {
		// TODO Auto-generated method stub
		Hashtable<String, Integer> ingredients = new Hashtable<>();
		ingredients.put("pasta", 3);
		ingredients.put("fish", 1);
		ingredients.put("shrimp", 2);
		this.operationList.add(new Operation(ingredients, "fetch"));
		this.operationList.add(new Operation("fish", 1, "cutlery"));
		this.operationList.add(new Operation("shrimp", 1, "cutlery"));
	}
}
