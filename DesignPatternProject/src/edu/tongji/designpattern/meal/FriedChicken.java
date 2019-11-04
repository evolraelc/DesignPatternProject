package edu.tongji.designpattern.meal;


import edu.tongji.designpattern.procedure.Operation;

public class FriedChicken extends Dish{
	FriedChicken(){
		this.name="friedChicken";
		this.ID=1;
		this.Price=20;
	}
	@Override
	void initOperations() {
		// TODO Auto-generated method stub
		this.operationList.add(new Operation("chicken", 1, "fetch"));
		this.operationList.add(new Operation("chicken", 1, "cutlery"));
		this.operationList.add(new Operation("chicken", 1, "fryer"));
	}
}
