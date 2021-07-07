package com.example.goal;

public class PurchaseCar implements  IGoal{
	private PurchaseCar car;
public PurchaseCar(PurchaseCar car) {
	System.out.println("PurchaseCar.PurchaseCar()");
	this.car=car;
}

public String compleGoal() {
	
	return "PurchaseCar Goal Completd";
}
}
