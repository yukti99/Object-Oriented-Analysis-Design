import java.io.*;
import java.util.*;

public class riceBags{
      public static int minBags(int b,int s,int rice){
      		int maxlimit = b*5 + s;
      		int ans = -1;
      		if (rice > maxlimit)
      			return ans;
      		else{
      			int a = rice/5;
      			if (a > b){
      				ans = rice - b*5;
      				
      			}else{
      				ans = rice - a*5;
      				
      			}      			
      			return ans;	
      		
      		}			
      		
      		
           
      }
      public static void main(String[] args){
            Scanner in = new Scanner(System.in);
            int b=0,s=0,rice=0;
            System.out.print("Enter the number of Big rice bags = ");
            b = in.nextInt();
            System.out.print("Enter the number of Small rice bags = ");
            s = in.nextInt();
            System.out.print("Enter amount of rice in kilos = ");
            rice = in.nextInt();
            System.out.println("The minimum number of 1 Kg rice bags = "+minBags(b,s,rice));
            
            
      
      }

}

