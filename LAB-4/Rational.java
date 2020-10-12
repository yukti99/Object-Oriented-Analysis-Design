import java.util.*;

public class Rational{
      // sign = 0 means positive , sign = 1 means negative
      private int n,d,sign=0;
      public static int gcd(int a,int b){
            while(b!=0){
                  int r = a%b;
                  a = b;
                  b = r;
            }
            return a;
      }
      public Rational(){
            this.n = 0;
            this.d = 1;     
      }
      public Rational(int n, int d){
            if (d == 0){
                  System.out.println("DENOMINATOR CANNOT BE ZERO!! ABORTING...");
                  System.exit(0);
            }
            if (n<0 && d>0){
                  n *= -1;
                  this.sign = 1;
            }
            else if (n>0 && d<0){
                  d*=-1;
                  this.sign = 1;
            }
            int g = n>d?gcd(n,d):gcd(d,n);
            this.n = n/g;
            this.d = d/g;     
      }
      public int getNumerator(){
            return this.n;
      }
      public int getDenominator(){
            return this.d;
      }
      public static Rational add(Rational r1,Rational r2){
            int r1n = r1.getNumerator();
            int r1d = r1.getDenominator();
            int r2n = r2.getNumerator();
            int r2d = r2.getDenominator();
            int num = r1n*r2d + r2n*r1d;
            int den = r1d * r2d;
            Rational r = new Rational(num,den);
            return r;     
      }
      public static Rational subtract(Rational r1,Rational r2){
            int r1n = r1.getNumerator();
            int r1d = r1.getDenominator();
            int r2n = r2.getNumerator();
            int r2d = r2.getDenominator();
            int num = r1n*r2d - r2n*r1d;
            int den = r1d * r2d;
            Rational r = new Rational(num,den);
            return r;     
      }
      public static Rational multiply(Rational r1,Rational r2){
            int r1n = r1.getNumerator();
            int r1d = r1.getDenominator();
            int r2n = r2.getNumerator();
            int r2d = r2.getDenominator();
            int num = r1n * r2n;
            int den = r1d * r2d;
            Rational r = new Rational(num,den);
            return r;     
      }
      public static Rational divide(Rational r1,Rational r2){
            int r1n = r1.getNumerator();
            int r1d = r1.getDenominator();
            int r2n = r2.getNumerator();
            int r2d = r2.getDenominator();
            int num = r2n*r1d;
            int den = r1n*r2d ;
            Rational r = new Rational(num,den);
            return r;     
      }
      public String getFraction(){
            String s="";
            if (this.sign == 1 ){
                  s ="-"; 
            }
            s += String.valueOf(this.n)+"/"+String.valueOf(this.d);
            return s;
      }
      public double getFloatFormat(int digits){
            if (this.sign==1){
                  this.n*=-1;
            }
            double d = Double.valueOf(this.n)/Double.valueOf(this.d);
            String s = String.format("%."+digits+"f", d);
            d = Double.parseDouble(s);
            return d;            
      }
      
      public static void main(String[] args){
            Scanner in = new Scanner(System.in);
            System.out.println("Enter Rational No 1");
            System.out.print("numerator = ");
            int n1 = in.nextInt();
            System.out.print("denominator = ");
            int d1 = in.nextInt();
            Rational r1 = new Rational(n1,d1);
            
            System.out.println("Enter Rational No 2");
            System.out.print("numerator = ");
            int n2 = in.nextInt();
            System.out.print("denominator = ");
            int d2 = in.nextInt();
            Rational r2 = new Rational(n2,d2);
            
            System.out.print("Enter the precision/ no of digits after decimal = ");
            int digits = in.nextInt();
            
            System.out.println("Rational No 1 = "+r1.getFraction()+" OR "+r1.getFloatFormat(digits));
            System.out.println("Rational No 2 = "+r2.getFraction()+" OR "+r2.getFloatFormat(digits));
            
            System.out.println("Result of addition : ");
            Rational a = Rational.add(r1,r2);
            System.out.println(a.getFraction()+" OR "+a.getFloatFormat(digits));
            System.out.println("Result of subtraction : ");
            Rational s = Rational.subtract(r1,r2);
            System.out.println(s.getFraction()+" OR "+s.getFloatFormat(digits));
            
            
            System.out.println("Result of multiplication: ");
            Rational m = Rational.multiply(r1,r2);
            System.out.println(m.getFraction()+" OR "+m.getFloatFormat(digits));
            
            System.out.println("Result of division : ");
            Rational d = Rational.divide(r1,r2);
            System.out.println(d.getFraction()+" OR "+d.getFloatFormat(digits));
            
            
            
      }

}
