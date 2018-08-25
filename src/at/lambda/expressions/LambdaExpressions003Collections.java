package at.lambda.expressions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Abhishek
 *1. Java provides a new method forEach() to iterate the elements. It is defined in 
 *   Iterable and Stream interfaces.forEach()
 */
public class LambdaExpressions003Collections {
	
	public static void main(String[] args) {  
        List<String> list=new ArrayList<>();  
        list.add("ankit");  
        list.add("mayank");  
        list.add("irfan");  
        list.add("jai");  
          
        list.forEach(  
            n -> System.out.println(n)  
        );  
    }  
}
