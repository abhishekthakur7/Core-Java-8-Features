package at.multithreading;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFuture implements Callable<String> {

	/*Java 5 introduced java.util.concurrent.Callable interface in concurrency package that is similar 
	to Runnable interface but it can return any Object and able to throw Exception.
	
	Java Callable interface use Generic to define the return type of Object. Executors class 
	provide useful methods to execute Java Callable in a thread pool. Since callable
	tasks run in parallel, we have to wait for the returned Object.
	
	Java Callable tasks return java.util.concurrent.Future object. Using Java Future object, 
	we can find out the status of the Callable task and get the returned Object. It provides get() 
	method that can wait for the Callable to finish and then return the result.

	Java Future provides cancel() method to cancel the associated Callable task. There is an 
	overloaded version of get() method where we can specify the time to wait for the result, it�s 
	useful to avoid current thread getting blocked for longer time. There are isDone() and 
	isCancelled() methods to find out the current status of associated Callable task.
	*/
	
	@Override
	public String call() throws Exception {
		 Thread.sleep(1000);
		 //return something after executing this callable task
		 return "Abhishek";
	}
	
	public static void main(String args[]) throws Exception{
        //Get ExecutorService from Executors utility class, thread pool size is 10
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()+1);
        
        //create a list to hold the Future object associated with Callable
        List<Future<String>> list = new ArrayList<>();
        
        //Create MyCallable instance
        Callable<String> callable = new CallableFuture();
        
        for(int i=0; i< 10; i++){
            //submit Callable tasks to be executed by thread pool
            Future<String> future = executor.submit(callable);
            //add Future to the list, we can get return value using Future
            System.out.println("Future object is: "+ future.get());
            list.add(future);
        }
        for(Future<String> fut : list){
            try {
                //print the return value of Future, notice the output delay in console
                // because Future.get() waits for task to get completed
                System.out.println(new Date()+ "::"+fut.get());
            } catch (InterruptedException | ExecutionException e) {
            	e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
        //shut down the executor service now
        executor.shutdown();
    }
}