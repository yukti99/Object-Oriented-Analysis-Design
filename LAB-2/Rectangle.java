import java.util.*;


public class Rectangle{
	double length;
	double width;
	public Rectangle(){
		this.length = 1;
		this.width = 1;
	}
	public static Boolean checkFloat(double n){
		String s = String.valueOf(n);
		int f=0;
		for(int i=0;i<s.length();i++){
			if (s.charAt(i)=='.'){
				f=1;
				break;
			}
		}
		if (f==0)return false;
		return (n == +n && n<20.0 && n>0.0)	;	
		
	}
	public void setLength(double length){
		if (checkFloat(length))
			this.length = length;	
		else{
			System.out.println("The length must be a float between 0.0 and 20.0");	
			System.out.println("Default value of length remains = 1");
		}
	}
	public void setWidth(double width){
		if (checkFloat(width))
			this.width = width;
				
		else{
			System.out.println("The width must be a float between 0.0 and 20.0");
			System.out.println("Default value of width remains = 1");
		}	
	}
	public double getLength(){
		return this.length;		
	
	}
	public double getWidth(){
		return this.width;	
	
	}
	public double getPerimeter(){
		return 2*(this.length+this.width);
	}
	public double getArea(){
		return (this.length*this.width);
	}
	public static void main(String[] args){
	
		Rectangle r = new Rectangle();
		r.setLength(21.2);
		r.setWidth(4.3);
		System.out.println("The Rectangle with length = "+r.getLength()+" and width = "+r.getWidth());
		System.out.println("Perimeter = "+r.getPerimeter());
		System.out.println("Area = "+r.getArea());
		System.out.println();
		
		Rectangle r1 = new Rectangle();
		r1.setLength(14.6);
		r1.setWidth(5.3);
		System.out.println("The Rectangle with length = "+r1.getLength()+" and width = "+r1.getWidth());
		System.out.println("Perimeter = "+r1.getPerimeter());
		System.out.println("Area = "+r1.getArea());
		System.out.println();
		
		Scanner in = new Scanner(System.in);		
		double l,w;
		
		System.out.println("Enter the value of length: ");
		l = in.nextDouble();		
		System.out.println("Enter the value of width: ");
		w = in.nextDouble();
		Rectangle r2 = new Rectangle();		
		r2.setLength(l);
		r2.setWidth(w);
		System.out.println("The Rectangle with length = "+r2.getLength()+" and width = "+r2.getWidth());
		System.out.println("Perimeter = "+r2.getPerimeter());
		System.out.println("Area = "+r2.getArea());
		System.out.println();
		
				
	
	
	}
}

