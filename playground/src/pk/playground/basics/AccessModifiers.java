package pk.playground.basics;

public class AccessModifiers {
	public static void main(String[] args) {
		Accessible accessible = new Accessible();
		accessible.accessProtectedMethod();
	}

}
