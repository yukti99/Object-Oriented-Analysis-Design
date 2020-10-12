import java.util.*;
import java.io.*;

interface Sports{
	final int Sports_Grace_Marks = 12;
	
}
class Student{
	public int rno;
	public String sname;

	/*public Student(int rno,String sname){
		this.rno = rno;
		this.sname = sname;
	}

	public int getRollno(){
		return this.rno;
	}
	public String getName(){
		return this.sname;
	}*/
	
}
class Exam extends Student {
	public int max_marks = 100;
	public int Exam_Marks = 76;
	/*public Exam(int exam_marks){
		//super(rno,sname);
		this.Exam_Marks = exam_marks;

	}	*/
}

// Results class implements Sports
class Results extends Exam implements Sports{
	private int Total_Marks;

	public Results(){
		if (Exam_Marks  < max_marks){
			this.Total_Marks = Exam_Marks+Sports_Grace_Marks;
		}
		else{
			this.Total_Marks = Exam_Marks;
		}		
	}
	public int getTotalMarks(){
		return this.Total_Marks;
	}
	public void displayStudentResults(){
		System.out.println("*********************************");
		//System.out.println("Name : "+this.sname);
		//System.out.println("Roll No : "+this.rno);
		System.out.println("Exam Marks :"+ Exam_Marks);
		System.out.println("Sports Grace Marks :"+Sports_Grace_Marks);
		System.out.println("Total Marks :"+this.Total_Marks);
		System.out.println("*********************************");
	}
	
}

public class ResultsDriver{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		/*System.out.println("RESULTS FOR THE YEAR - 2020:");
		System.out.print("Enter student Name = ");
		String n1 = in.nextLine();
		System.out.print("Enter student Roll No = ");
		int r1 = in.nextInt();
		System.out.print("Enter student exam marks = ");
		int exam = in.nextInt();*/
		//Exam e1 = new Exam(r1,n1,exam);
		Results results1 = new Results();
		results1.displayStudentResults();


	}

}