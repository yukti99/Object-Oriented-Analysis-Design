import java.util.*;

class submatrix{

	public static void main (String[] args){ 
        int mat[][] = {{1,3,7,8},{6,5,3,2},{9,7,8,1},{0,7,0,6}};  
        int N = 4;
        int subs = 2;
        find(mat,subs,N);      
        
      }
      static void find(int mat[][],int x,int N){
		int i,j,kv,kh,a;
	        a=N/x;
		for(i=0;i<a;i++){
			for(j=0;j<a;j++){				
				for(kv=0;kv<x;kv++){
					for(kh=0;kh<x;kh++){					
						System.out.print(mat[i*x+kv][j*x+kh]+" ");
					}
					System.out.println();			
					
				}
				System.out.println("\n");
			}
		}		
		 
	}	
}
