package pk.playground.basics.inheritance;

import pk.playground.model.Body;

public class Car extends Vehicle{

	public Car() {
		super();
	}
	public Car(Body body) {
		
	}
	@Override
	public void printSpecification() {
		System.out.println("Car specification");
	}
	
	//@Override cannot override static method
	public static void  staticMethod() {
		System.out.println("Inside child class");
	}
}
