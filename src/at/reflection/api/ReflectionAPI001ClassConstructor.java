package at.reflection.api;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Reflection is an API which is used to examine or modify the behavior of methods,
 * classes, interfaces at runtime:
 * 1. The required classes for reflection are provided under java.lang.reflect package.
 * 2. Reflection gives us information about the class to which an object belongs and also 
 *    the methods of that class which can be executed by using the object.
 * 3. Through reflection we can invoke methods at runtime irrespective of the access 
 *    specifier used with them.
 *
 *Reflection can be used to get information about :–
 *   1. Class: The getClass() method is used to get the name of the class to which an object belongs.
 *   2. Constructors: The getConstructors() method is used to get the public constructors of the class 
 *      to which an object belongs.
 *   3. Methods: The getMethods() method is used to get the public methods of the class to which an 
 *      objects belongs.
 * 
 * @author Abhishek Thakur
 */
public class ReflectionAPI001ClassConstructor {

    // creating a private field 
    private String s; 
  
    // creating a public constructor 
    public ReflectionAPI001ClassConstructor()  {  s = "GeeksforGeeks"; } 
  
    // Creating a public method with no arguments 
    public void method1()  { 
        System.out.println("The string is " + s); 
    } 
  
    // Creating a public method with int as argument 
    public void method2(int n)  { 
        System.out.println("The number is " + n); 
    } 
  
    // creating a private method 
    private void method3() { 
        System.out.println("Private method invoked"); 
    } 
}

class Test 
{ 
    public static void main(String args[]) throws Exception 
    { 
        // Creating object whose property is to be checked 
    	ReflectionAPI001ClassConstructor obj = new ReflectionAPI001ClassConstructor(); 
  
        // Creating class object from the object using 
        // getclass method 
        Class<? extends ReflectionAPI001ClassConstructor> cls = obj.getClass(); 
        System.out.println("The name of class is " + 
                            cls.getName()); 
  
        // Getting the constructor of the class through the 
        // object of the class 
        Constructor<? extends ReflectionAPI001ClassConstructor> constructor = cls.getConstructor(); 
        System.out.println("The name of constructor is " + 
                            constructor.getName()); 
  
        System.out.println("The public methods of class are : "); 
  
        // Getting methods of the class through the object 
        // of the class by using getMethods 
        Method[] methods = cls.getMethods(); 
  
        // Printing method names 
        for (Method method:methods) 
            System.out.println(method.getName()); 
  
        // creates object of desired method by providing the 
        // method name and parameter class as arguments to 
        // the getDeclaredMethod 
        Method methodcall1 = cls.getDeclaredMethod("method2", 
                                                 int.class); 
  
        // invokes the method at runtime 
        methodcall1.invoke(obj, 19); 
  
        // creates object of the desired field by providing 
        // the name of field as argument to the  
        // getDeclaredField method 
        Field field = cls.getDeclaredField("s"); 
  
        // allows the object to access the field irrespective 
        // of the access specifier used with the field 
        field.setAccessible(true); 
  
        // takes object and the new value to be assigned 
        // to the field as arguments 
        field.set(obj, "JAVA"); 
  
        // Creates object of desired method by providing the 
        // method name as argument to the getDeclaredMethod 
        Method methodcall2 = cls.getDeclaredMethod("method1"); 
  
        // invokes the method at runtime 
        methodcall2.invoke(obj); 
  
        // Creates object of the desired method by providing 
        // the name of method as argument to the  
        // getDeclaredMethod method 
        Method methodcall3 = cls.getDeclaredMethod("method3"); 
  
        // allows the object to access the method irrespective  
        // of the access specifier used with the method 
        methodcall3.setAccessible(true); 
  
        // invokes the method at runtime 
        methodcall3.invoke(obj); 
    } 
} 
