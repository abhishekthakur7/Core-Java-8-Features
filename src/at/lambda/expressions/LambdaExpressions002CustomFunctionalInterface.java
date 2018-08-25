package at.lambda.expressions;

/**
 * @author Abhishek
 *
 * 1. A lambda expression can have zero or any number of arguments separated by comma
 * 2. You can omit function parentheses 
 * 3. Lambda expression without return keyword: (a,b)->("Hello"+name); 
 */

	@FunctionalInterface
    interface Sayable{  
        public String say(String name);  
    }  
      
    public class LambdaExpressions002CustomFunctionalInterface
    {  
	        public static void main(String[] args) 
	        {  
	        	customFunctionalInterface();
	        }
		        
		    private static void customFunctionalInterface()
		    {
		    	System.out.println("*** Lambda expression with single parameter ***");
		        Sayable s1= (name)->{  
		            return "Hello "+name;  
		        };  
		        System.out.println(s1.say("Abhishek"));  
		        
		        System.out.println("*** Lambda expression with no return keyword ***");
		        Sayable s2= (name) -> ("Hello "+ name);
		        System.out.println(s2.say("Akku"));
		        
		        System.out.println("*** You can omit function parentheses ***");
		        Sayable s3= name -> {  
		            return "Hello "+name;  
		        };  
		        System.out.println(s3.say("Thakur")); 
		    }
}
