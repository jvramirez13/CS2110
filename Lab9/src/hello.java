
public class hello {

	public static void main(String[] args) { 
			int[] x = {1,2,3};  int key = 7;  foo(x, key);   key = 42;  foo(x, key); }
		public static void foo(int[] x, int key) {  
			try {   
				if(key == 42) {   
					throw new FooException(“life has been solved”); 
					} 
			System.out.println( x[3] ); 
			} 
			catch(FooException e) {  
				System.out.println(e.getMessage());  
				} 
			catch(Exception e) { 
				System.out.println(“still a mystery!”);  
				} 
			finally {  
				System.out.println(“really?”);
				} 
			} 

	}


