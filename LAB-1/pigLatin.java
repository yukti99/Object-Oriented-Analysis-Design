import java.util.*;
import java.io.*;


public class pigLatin{
      public static Boolean isVowel(char c){
            if (c=='a'|| c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U'){
                  return true;
            }
            return false;
      }
     /* public static int[] setCapitalPos(String w){
            int[] a;
            int k=0;
            for(int i=0;i<w.length();i++){
                  if (Character.isUpperCase(w.charAt(i))){
                        a[k++]=i;
                        System.out.println("Hi");
                  }
            }
            for(int i=0;i<a.length;i++){
                  System.out.println(a[i]);
            }
            return a;
      } */
      public static String convert(String w){
            // int[] a = setCapitalPos(w);            
            w = w.toLowerCase();
            String ans = w,t="";
            int l = w.length();
            int f=0;
            int i=0;
            if (isVowel(w.charAt(i))){
                  ans+= "way";
            }else{ 
                  if (w.charAt(i) == 'y'){
                  	ans = ans.replace("y","")+"yay";
                  	return ans;
                  }            
                  while(i<l && !isVowel(w.charAt(i))&& (w.charAt(i)!='y')){
                        f=1;
                        t+=w.charAt(i);
                        i++;                         
                  }                  
                  if (f==1){
                        ans = ans.replace(t,"");
                        ans+=t;
                  }
                  ans+="ay";
            }
            /*for(int j=0;j<a.length;j++){
                 Character.toUpperCase(ans.charAt(a[j]));
            }*/
            
            return ans;           
      
      }
      public static void main(String[] args){
            Scanner in = new Scanner(System.in);            
            System.out.println("Enter any sentence : ");
            String word = in.nextLine();
            System.out.println("The sentence entered: "+word);
            String[] ans = word.split(" ");
            System.out.println("The PigLatin equivalent:");
            for(int i=0;i<ans.length;i++){
                  String s = convert(ans[i]);
                  System.out.print(s+" ");
            }          
            
            
      }
      
}
