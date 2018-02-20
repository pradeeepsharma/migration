package pk.playground.basics.inheritance;

import pk.playground.model.Body;

public class Vehicle {
	private Body body;

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	public void printSpecification() {
		System.out.println("Vehicle specification");
	}
	
	public static void  staticMethod() {
		System.out.println("inside parent class");
	}

}
