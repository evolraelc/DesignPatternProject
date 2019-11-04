package edu.tongji.designpattern.meal;



import edu.tongji.designpattern.procedure.Operation;

import java.util.Hashtable;

public class Burger extends Dish{
	public Burger(){
		this.name = "burger";
		this.ID = 1;
		this.Price = 20;
	}
	@Override
	void initOperations() {
		// TODO Auto-generated method stub
		Hashtable<String, Integer> ingredients = new Hashtable<>();
		ingredients.put("bread", 2);
		ingredients.put("meat", 3);
		ingredients.put("vegetable", 4);
		ingredients.put("cheese", 3);
		this.operationList.add(new Operation(ingredients, "fetch"));
		this.operationList.add(new Operation("meat", 3, "cutlery"));
		this.operationList.add(new Operation("meat", 3, "pan"));
		this.operationList.add(new Operation("vegetable", 4, "cutlery"));
		this.operationList.add(new Operation("cheese", 3, "cutlery"));
	}
}
