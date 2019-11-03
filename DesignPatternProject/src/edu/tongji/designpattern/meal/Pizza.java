package edu.tongji.designpattern.meal;



import edu.tongji.designpattern.procedure.Operation;

import java.util.Hashtable;

public class Pizza extends Dish{
	Pizza(){
		this.name="pizza";
		this.ID=1;
		this.Price=20;
	}
	@Override
	void initOperations() {
		// TODO Auto-generated method stub
		Hashtable<String, Integer> ingredients = new Hashtable<>();
		ingredients.put("paste", 1);
		ingredients.put("tomato", 2);
		ingredients.put("cheese", 5);
		ingredients.put("sausage", 2);
		this.operationList.add(new Operation(ingredients, "fetch"));
		this.operationList.add(new Operation("tomato", 2, "cutlery"));
		this.operationList.add(new Operation("cheese", 5, "cutlery"));
		this.operationList.add(new Operation("sausage", 2, "cutlery"));
		this.operationList.add(new Operation(ingredients, "oven"));
	}
}
