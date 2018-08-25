package at.lambda.expressions;

/**
 * @author Abhishek
 *
 *The most dominant feature of Java 8 is the new support for Lambda expressions. This addition to the 
 *language brings Java to the forefront of functional programming, right there with other functional 
 *JVM-based languages such as Scala and Clojure.
 *
 *
 *1. One of the major benefits of functional interface is we can use lambda expressions to instantiate them.
 *2. Since functional interfaces have only one method, lambda expressions can easily provide the method 
 *   implementation. We just need to provide method arguments and business logic.
 *3. There are no runtime benefits of using lambda expressions, but it makes code lines less.
 *4. A new package java.util.function has been added with bunch of functional interfaces to provide 
 *	 target types for lambda expressions and method references.
 *5. Example with Runnable interface which is a functional interface with single abstract method
 */
public class LambdaExpressions001PredefinedFunctionalInterface {

	public static void main(String[] args) {
				oldApproachWithPredefinedFunctionalInterface();
				newApproachWithPredefinedFunctionalInterface();
	}
	
	private static void oldApproachWithPredefinedFunctionalInterface()
	{
		Runnable r = new Runnable(){
			 @Override
			 public void run() {

			 System.out.println("My Runnable");

			 }};
			 System.out.println(r.getClass());
	}
	
	
	
	/**
	 * Syntax: (argument-list) -> {body}  
	 */
	private static void newApproachWithPredefinedFunctionalInterface()
	{
		Runnable r = () -> {
			System.out.println("My runnable with new approach");
		};
		System.out.println(r.getClass());
	}
}
