import java.util.*;

public class matrix{
      public static Boolean isCartan(int[][] a, int n){
      		for(int i=0;i<n;i++){
      			for(int j=0;j<n;j++){
      				if (a[i][j]!=-3 && a[i][j]!=-2 &&a[i][j]!=-1 &&a[i][j]!=0  &&a[i][j]!=1 &a[i][j]!=2)
      					return false;
      				if (i==j){
      					if (a[i][j]!=2)
      						return false;
      				}
      				if ((a[i][j] == 0 && a[j][i] != 0 )|| (a[i][j]!= 0 && a[j][i]==0)){
      					return false;
      				}
      			}
      		}
      		return true;
      
      }
      public static int[][] multiply(int[][] a, int[][] b,int n){
            Scanner in = new Scanner(System.in);
            int[][] c = new int[n][n];
            for(int i=0;i<n;i++){
                  for(int j=0;j<n;j++){
                        for(int k=0;k<n;k++){
                              c[i][j] += a[i][k]*b[k][j];
                        }
                  }
            }
            return c;           
      }
      public static int[][] takeInput(int[][] x,int n){
            Scanner in = new Scanner(System.in);
            for(int i=0;i<n;i++){
                  for(int j=0;j<n;j++){
                        x[i][j] = in.nextInt();
                  }
            }       
            return x;     
      }
      public static void printMatrix(int[][] x,int n){
            Scanner in = new Scanner(System.in);
             for(int i=0;i<n;i++){
                  for(int j=0;j<n;j++){
                        System.out.print(x[i][j]+" ");
                  }
                  System.out.println();
            }
            System.out.println();      
      }
      public static void main(String[] args){
            System.out.println("Welcome!");
            Scanner in = new Scanner(System.in);
            int n;
            System.out.println("Enter n for matrices : ");            
            n = in.nextInt();
            int[][] a = new int[n][n];
            int[][] b = new int[n][n];           
            System.out.println("Enter matrix A : ");
            takeInput(a,n);
            System.out.println("Enter matrix B : ");
            takeInput(b,n);
            
            if (!isCartan(a,n) || !isCartan(b,n)){
            	System.out.println("Both matrices must be Cartan!!");
            	return ;
            }else{
            	System.out.println("The matrices are Cartan!");
            }
            
            System.out.println("\nMatrix A : ");
            printMatrix(a,n);
            System.out.println("Matrix B : ");
            printMatrix(b,n);
            
            int[][] c = multiply(a,b,n);
            System.out.println("Result of multiplication of A and B : ");
            printMatrix(c,n);
      }
}
