package pk.playground.basics.inheritance;

public class InhtTester {
	private Vehicle vehicle;
	private Car car;

	public InhtTester() {
		vehicle = new Car();
		car = new Car();
	}
	
	public void printSpecification() {
		car.printSpecification();
		vehicle.printSpecification();
	}
}
