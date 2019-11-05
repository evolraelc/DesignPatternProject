package edu.tongji.designpattern.meal;


import edu.tongji.designpattern.procedure.Operation;

public class Chips extends Dish{
	Chips(){
		this.name="chips";
		this.ID=1;
		this.Price=20;
	}
	@Override
	void initOperations() {

		this.operationList.add(new Operation("potato", 1, "fetch"));
		this.operationList.add(new Operation("potato", 1, "cutlery"));
		this.operationList.add(new Operation("potato", 1, "fryer"));
	}
}

