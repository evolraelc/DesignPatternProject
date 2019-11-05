package edu.tongji.designpattern.meal;


import edu.tongji.designpattern.procedure.Operation;

public class Sashimi extends Dish{
	Sashimi(){
		this.name="sashimi";
		this.ID=1;
		this.Price=20;
	}
	@Override
	void initOperations() {
		// TODO Auto-generated method stub
		this.operationList.add(new Operation("fish", 1, "fetch"));
		this.operationList.add(new Operation("fish", 1, "cutlery"));
	}
}
