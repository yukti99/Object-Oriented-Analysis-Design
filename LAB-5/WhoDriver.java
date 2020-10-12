import java.util.*;
import java.io.*;

class Person{
	public  static String HOBBY = "Reading"; 
	private static String name;
	public Person(String name){
		this.name = name;
	}
	public static String getName(){
		return name;
	}
	public void introduce(){
		System.out.println("Hello, my name is "+this.name+" and my HOBBY is "+CSEStudent.HOBBY);

	}


}

class Student extends Person{
	public static String HOBBY = "Facebook";
	public Student(String name){
		super(name);
	}
	public void introduce(){
		System.out.println("Hello, my name is "+Person.getName()+" and my HOBBY is "+HOBBY);

	}

}

class CSEStudent extends Student{
	public static String HOBBY = "Hacking";
	public CSEStudent(String name){
		super(name);
	}
	public void introduce(){
		System.out.println("Hello, my name is "+Person.getName()+" and my HOBBY is "+Person.HOBBY);

	}

}



public class WhoDriver{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Hello Varun !");
		System.out.println("What is your identity today?");
		int c,a=1;
		while(a==1){
			System.out.println("\nWhere are you today?");
			System.out.println("****************************************************************************************");
			System.out.println("(1) at a get-together for student leaders of various colleges in Jaipur");
			System.out.println("(2) at a closed-door Hacker Society meeting");
			System.out.println("(3) at his cousin's birthday party where he meets a beautiful girl who is a Tagore fan.");
			System.out.println("(4) say Goodbye! (Exit)");
			System.out.println("****************************************************************************************\n");
			c = in.nextInt();
			switch(c){
				case 1:
					CSEStudent v1 = new CSEStudent("Varun");
					v1.introduce();
					break;
				case 2:
					Person v2 = new Person("Varun");
					v2.introduce();
					break;
				case 3:
					Student v3 = new Student("Varun");
					v3.introduce();
					break;
				case 4:
					System.exit(0);
				default:
					System.out.println("Please enter the correct choice!\n");

			}



		}

}
}