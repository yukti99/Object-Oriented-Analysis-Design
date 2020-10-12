import java.util.*;
import java.io.*;

public class Complex{
      private double real;
      private double imag;
      // no-argument constructor
      public Complex(){
            this.real = 0.0;
            this.imag = 0.0;
      }
      public Complex(double realpart,double imagpart){
            this.real = realpart;
            this.imag = imagpart;
      }
      public Complex addComplexNo(Complex c){
            Complex result = new Complex();
            result.real = this.real+c.real;
            result.imag = this.imag+c.imag;
            return result;     
      }
      public Complex subtractComplexNo(Complex c){
             Complex result = new Complex();
            result.real = this.real-c.real;
            result.imag = this.imag-c.imag;
            return result;     
      }
      public String printComplexNo(){
            String s = "("+this.real+","+this.imag+")" ;
            return s;      
      }
      
      public static void main(String[] args){
            Scanner in = new Scanner(System.in);
            System.out.println("COMPLEX NO-1 : ");
            System.out.println("Enter the real part : ");
            double r1  = in.nextDouble();
            System.out.println("Enter the imaginary part  : ");
            double im1  = in.nextDouble();
            Complex cno1 = new Complex(r1,im1);
            System.out.println("Complex no 1 = "+cno1.printComplexNo());
            
            System.out.println("\nCOMPLEX NO-2 : ");
            System.out.println("Enter the real part : ");
            double r2  = in.nextDouble();
            System.out.println("Enter the imaginary part  : ");
            double im2  = in.nextDouble();
            Complex cno2 = new Complex(r2,im2);
             System.out.println("Complex no 2 = "+cno2.printComplexNo());
            
            System.out.println("\nADDING THE TWO COMPLEX NUMBERS : ");
            Complex addno = cno1.addComplexNo(cno2);
            System.out.println(cno1.printComplexNo()+"+"+cno2.printComplexNo()+"="+addno.printComplexNo());
            System.out.println("\nSUBTRACTING THE TWO COMPLEX NUMBERS : ");
            Complex subno = cno1.subtractComplexNo(cno2);
            System.out.println(cno1.printComplexNo()+"-"+cno2.printComplexNo()+"="+subno.printComplexNo());
            
            
      }

}
