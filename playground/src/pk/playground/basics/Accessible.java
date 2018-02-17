package pk.playground.basics;

public class Accessible {
	public String accessPublicMethod() {
		System.out.println("Being printed from public method");
		return "public string";
	}

	private String accessPrivateMethod() {
		return "privet string";
	}

	protected String accessProtectedMethod() {
		return "protected name";
	}

	String accessDefaultMethod() {
		return "default string";
	}
	

}

