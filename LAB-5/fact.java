package fact_recursion;

public class fact{

    public static int factorial( int n ) {
    	if (n < 0){
    		return -1;
    	}
        if (n != 0)
            return n * factorial(n-1); // recursive call
        else
            return 1;
    }
    
}