package at.lambda.expressions;

    import java.util.ArrayList;  
    import java.util.List;  
    import java.util.stream.Stream;   
    
    class DemoProduct{  
        int id;  
        String name;  
        float price;  
        public DemoProduct(int id, String name, float price) {  
            super();  
            this.id = id;  
            this.name = name;  
            this.price = price;  
        }  
    }  
    public class LambdaExpressions005Filter{  
        public static void main(String[] args) {  
            List<DemoProduct> list=new ArrayList<>();  
            list.add(new DemoProduct(1,"Samsung A5",17000f));  
            list.add(new DemoProduct(3,"Iphone 6S",65000f));  
            list.add(new DemoProduct(2,"Sony Xperia",25000f));  
            list.add(new DemoProduct(4,"Nokia Lumia",15000f));  
            list.add(new DemoProduct(5,"Redmi4 ",26000f));  
            list.add(new DemoProduct(6,"Lenevo Vibe",19000f));  
              
            // using lambda to filter data  
            Stream<DemoProduct> filtered_data = list.stream().filter(p -> p.price > 20000);  
              
            // using lambda to iterate through collection  
            filtered_data.forEach(  
                    DemoProduct -> System.out.println(DemoProduct.name+": "+DemoProduct.price)  
            );  
        }  
    }  
