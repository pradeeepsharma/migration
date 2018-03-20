package pk.playground.basics.reflect;

import java.lang.reflect.Method;

import pk.playground.model.User;

public class MethodsInAClass {
	public static void main(String[] args) {
		MethodsInAClass methodsInAClass = new MethodsInAClass();
		methodsInAClass.getMethodsInAClass(User.class);
				

	}

	public void getMethodsInAClass(Class classAsParameter) {
		Method[] methodsInDomainClass = ((Class)classAsParameter).getDeclaredMethods();
		System.out.println("Total methods in User class :"+methodsInDomainClass.length);
		for(Method method:methodsInDomainClass) {
			System.out.println("Name :"+method.getName()+" ReturnType :"+method.getReturnType()+" Modifiers :"+method.getModifiers());
		}
	}
}
