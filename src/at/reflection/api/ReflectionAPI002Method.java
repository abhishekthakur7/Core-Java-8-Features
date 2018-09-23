package at.reflection.api;

import java.lang.reflect.Method;

/*
 * We can invoke an method through reflection if we know its name and parameter types. We use below two
 *  methods for this purpose
 * 1. getDeclaredMethod() : To create an object of method to be invoked. The syntax for this method is:
 *    Class.getDeclaredMethod(name, parametertype)
      name- the name of method whose object is to be created
      parametertype - parameter is an array of Parameters class type e.g. String.class, Integer.class etc.
 * 
 * 
 * 2. invoke() : To invoke a method of the class at runtime:
      Method.invoke(Object, parameter)
      If the method of the class doesn’t accepts any parameter then null is passed as argument. 
 */

class A {
	
	private void message(){System.out.println("hello java");   
	}  
}

public class ReflectionAPI002Method {  
	public static void main(String[] args)throws Exception{  
		A obj = new A();
	    Method m = obj.getClass().getDeclaredMethod("message", null);  
	    m.setAccessible(true);  
	    m.invoke(obj, null);  
  }  
}

