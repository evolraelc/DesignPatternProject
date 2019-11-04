package edu.tongji.designpattern.meal;



import edu.tongji.designpattern.procedure.Operation;

import java.util.Hashtable;

public class Salad extends Dish{
	Salad(){
		this.name="salad";
		this.ID=1;
		this.Price=20;

	}
	@Override
	void initOperations() {
		// TODO Auto-generated method stub
		Hashtable<String, Integer> ingredients = new Hashtable<>();
		ingredients.put("lettuce", 3);
		ingredients.put("tomato", 2);
		ingredients.put("cucumber", 2);
		this.operationList.add(new Operation(ingredients, "fetch"));
		this.operationList.add(new Operation("lettuce", 3, "cutlery"));
		this.operationList.add(new Operation("tomato", 2, "cutlery"));
		this.operationList.add(new Operation("cucumber", 2, "cutlery"));
	}
}
