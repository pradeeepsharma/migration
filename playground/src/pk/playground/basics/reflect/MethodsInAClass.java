package pk.playground.basics.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.lang.model.element.Modifier;

import pk.playground.model.User;

public class MethodsInAClass {
	public static void main(String[] args) {
		MethodsInAClass methodsInAClass = new MethodsInAClass();
		//methodsInAClass.getMethodsInAClass(User.class);
		//methodsInAClass.getDeclaredMethodsInAClass(User.class);
		methodsInAClass.accessPrivteMethodOfClass(User.class);
				

	}

	public void getMethodsInAClass(Class classAsParameter) {
		System.out.println("Printng list of all the public methods in Class :"+classAsParameter.getName());
		Method[] methodsInDomainClass = ((Class)classAsParameter).getMethods();
		System.out.println("Total methods in User class :"+methodsInDomainClass.length);
		for(Method method:methodsInDomainClass) {
			System.out.println("Name :"+method.getName()+" ReturnType :"+method.getReturnType()+" Modifiers :"+method.getModifiers());
		}
	}
	
	public void getDeclaredMethodsInAClass(Class classAsParameter) {
		System.out.println("Printng list of all the Declared methods in Class :"+classAsParameter.getName());
		Method[] methodsInDomainClass = ((Class)classAsParameter).getDeclaredMethods();
		System.out.println("Total methods in User class :"+methodsInDomainClass.length);
		for(Method method:methodsInDomainClass) {
			System.out.println("Name :"+method.getName()+" ReturnType :"+method.getReturnType()+" Modifiers :"+method.getModifiers());
		}
	}
	
	public void accessPrivteMethodOfClass(Class classAsParameter) {
		Method[] methodsInDomainClass = ((Class)classAsParameter).getDeclaredMethods();
		System.out.println("Total methods in User class :"+methodsInDomainClass.length);
		try {
			for(Method method:methodsInDomainClass) {
				//System.out.println("Name :"+method.getName()+" ReturnType :"+method.getReturnType()+" Modifiers :"+method.getModifiers());
				if(!method.isAccessible()){
					method.setAccessible(true);
					System.out.println("Changed Modifier of method :"+method.getName()+" is "+method.getModifiers());
				}
			}
			Method privateMethod = ((Class)classAsParameter).getMethod("doPrint");
			privateMethod.invoke(null);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
