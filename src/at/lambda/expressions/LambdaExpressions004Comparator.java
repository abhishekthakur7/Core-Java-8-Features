package at.lambda.expressions;

    import java.util.ArrayList;  
    import java.util.Collections;  
    import java.util.List;  
    
    class Product{  
        int id;  
        String name;  
        float price;  
        public Product(int id, String name, float price) {  
            super();  
            this.id = id;  
            this.name = name;  
            this.price = price;  
        }
		@Override
		public String toString() {
			return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
		} 
        
    }  
    public class LambdaExpressions004Comparator{  
        public static void main(String[] args) {  
            List<Product> list=new ArrayList<>();  
              
            //Adding Products  
            list.add(new Product(1,"11",25000f));  
            list.add(new Product(3,"2",300f));  
            list.add(new Product(2,"1",150f));  
              
            System.out.println("Sorting on the basis of name...");  
      
            // Implementing lambda expression, sort based on the name (won't work on numbers)
            Collections.sort(list, (p1,p2)->(p1.name.compareTo(p2.name)));
            
            for(Product p:list){  
                System.out.println(p);  
            }  
      
            System.out.println("\n*** Original list ***\n");
            list.forEach(System.out::println);
        }  
    }  
