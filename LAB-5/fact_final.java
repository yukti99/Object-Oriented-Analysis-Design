
package factorialpackage;
import java.util.*;
import java.io.*;
import fact_recursion.fact;

public class fact_final{

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		System.out.print("Enter the n =  ");
		int n = in.nextInt();
		
		// creating an object of package 
		fact f = new fact();
        long result = f.factorial(n);
        if (result<0){
			System.out.println("Sorry! no cannot be nagative !!");
			System.exit(0);
		}
        System.out.println("The Factorial of "+n+" = " + result);
    }

}