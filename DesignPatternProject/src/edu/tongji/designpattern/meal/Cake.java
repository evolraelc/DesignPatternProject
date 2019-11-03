package edu.tongji.designpattern.meal;



import edu.tongji.designpattern.procedure.Operation;

import java.util.Hashtable;

public class Cake extends Dish{
	Cake(){
		this.name="cake";
		this.ID=1;
		this.Price=20;
	}
	@Override
	void initOperations() {
		// TODO Auto-generated method stub
		Hashtable<String, Integer> ingredients = new Hashtable<>();
		ingredients.put("flour", 1);
		ingredients.put("egg", 5);
		ingredients.put("honey", 4);
		ingredients.put("chocolate", 3);
		this.operationList.add(new Operation(ingredients, "fetch"));
		this.operationList.add(new Operation("chocolate", 3, "cutlery"));
		this.operationList.add(new Operation(ingredients, "blender"));
		this.operationList.add(new Operation(ingredients, "oven"));
	}
}
