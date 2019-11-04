package edu.tongji.designpattern.meal;



import edu.tongji.designpattern.procedure.Operation;

import java.util.ArrayList;
import java.util.List;

public abstract class Dish {
	protected int ID;
	protected String name;
	protected List<Operation> operationList;
	protected int Price;

	public List<Operation> getOperationList() {
		return operationList;
	}

	public void setOperationList(List<Operation> operationList) {
		this.operationList = operationList;
	}

	Dish(){
		this.operationList = new ArrayList<>();
		initOperations();
	}

	public String getName() {
		return this.name;
	}

	abstract void initOperations();
}