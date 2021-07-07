package com.example.goal;

public class PurchaseIphone implements IGoal {
	private PurchaseIphone phone;
public PurchaseIphone(PurchaseIphone phone) {
System.out.println("PurchaseIphone.PurchaseIphone()");
this.phone=phone;
}
public String compleGoal() {
	
	return "PurchaseIphone Goal Completd";
}

}
