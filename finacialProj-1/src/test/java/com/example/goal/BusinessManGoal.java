package com.example.goal;

public class BusinessManGoal implements IGoal{
	
private BusinessManGoal goal;

public BusinessManGoal(BusinessManGoal goal) {
	System.out.println("BusinessManGoal.BusinessManGoal()");
	this.goal=goal;
}


public String compleGoal() {
	return "BusinessGoal are Completd";
}
}
