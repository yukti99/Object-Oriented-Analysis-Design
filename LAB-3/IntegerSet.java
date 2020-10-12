import java.util.*;
import java.io.*;

public class IntegerSet{
      private Boolean[] boolarr = new Boolean[101];
      private int n;
      public IntegerSet(){
            this.n = 0;
            for(int i=0;i<=100;i++){
               this.boolarr[i] = false;  
               
            }           
      }
      public void insertElement(int k){
            if (k>100 || k<0)
                  return ;
            this.boolarr[k] = true;
            this.n++;
      }
      public void deleteElement(int k){
            if (k>100 || k<0)
                  return ;
            this.boolarr[k] = false;
            this.n--;
      }
      public IntegerSet Union(IntegerSet s){            
            IntegerSet result = new IntegerSet();
            for(int i=0;i<=100;i++){
                  if (s.boolarr[i] || this.boolarr[i]){
                        result.boolarr[i] = true;
                  }
            }
            return result;            
      }
      public IntegerSet Intersection(IntegerSet s){
            IntegerSet result = new IntegerSet();
            for(int i=0;i<=100;i++){
                  if (s.boolarr[i] && this.boolarr[i]){
                        result.boolarr[i] = true;
                  }
            }
            return result;            
      }
      public String toSetString(){
            String result = "";
            int f=0;
            for(int i=0;i<=100;i++){
                  if (this.boolarr[i] == true){
                        f=1;
                        result+=i+" ";                        
                  }
            }
            if (f==0)
                  return "--";
            return result;
      }
      public Boolean isEqualTo(IntegerSet s){
            if (this.n != s.n)
                  return false;
            for(int i=0;i<=100;i++){
                  if (this.boolarr[i]!=this.boolarr[i]){
                        return false;
                  }
            }
            return true;
            
      }
      
      
      public static void main(String[] args){
            Scanner in = new Scanner(System.in);
            System.out.println("SET-1 : ");
            IntegerSet set1 = new IntegerSet();
            System.out.print("Enter the no of elements in set-1 : ");
            int n1 = in.nextInt();
            int k;
            System.out.println("Enter "+n1+" elements of set-1 :");
            for(int i=0;i<n1;i++){
                  k = in.nextInt();
                  set1.insertElement(k);                  
            }
            System.out.println("Set-1 : {"+set1.toSetString()+"}");
            
            System.out.println("SET-2 : ");
            IntegerSet set2 = new IntegerSet();
            System.out.print("Enter the no of elements in set-2 : ");
            int n2 = in.nextInt();
             System.out.println("Enter "+n2+" elements of set-1 :");
            for(int i=0;i<n2;i++){
                  k = in.nextInt();
                  set2.insertElement(k);                  
            }
            System.out.println("Set-2 : {"+set2.toSetString()+"}");
            
            System.out.println("Union of set-1 and set-2 : ");
            IntegerSet unionset = set1.Union(set2);
            System.out.println("{"+unionset.toSetString()+"}");
            
            System.out.println("Intersection of set-1 and set-2 : ");
            IntegerSet interset = set1.Intersection(set2);
            System.out.println("{"+interset.toSetString()+"}");
            
            System.out.println("Are the two sets equal ? :");
            System.out.println(set1.isEqualTo(set2));
            
      }

}
