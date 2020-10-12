import java.util.*;
import java.io.*;

class Employee{
	public static int ecount = 0;
	private String fname;
	private String lname;
	private int monthly_sal;
	public Employee(){
		this.fname = "";
		this.lname = "";
		this.monthly_sal = 0;
		ecount++;
	}
	public void setFname(){
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the First Name = ");
		String fn = in.nextLine();
		this.fname = fn;
	}
	public void setLname(){
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the Last Name = ");
		String ln = in.nextLine();
		this.lname = ln;
	}
	public void setSalary(){
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the Salary = ");
		int s = in.nextInt();
		if (s<0){
			System.out.println("Negative Salary not Allowed!");
			return ;
		}
		this.monthly_sal = s;
	}
	public String getFname(){
		return this.fname;
	}
	public String getLname(){
		return this.lname;
	}
	public int getSalary(){
		return this.monthly_sal;
	}
	public int yearlySalary(){
		return this.monthly_sal*12;
	}
	public void giveRaise(int x){
		this.monthly_sal = this.monthly_sal*(x+100)/100;


	}
	public void displayInfo(){
		System.out.println("***********************************************");
		System.out.println("EMPLOYEE RECORDS:");
		System.out.println("FIRST NAME: "+this.getFname());	
		System.out.println("LAST NAME: "+this.getLname());	
		System.out.println("MONTHLY SALARY: "+this.getSalary());	
		System.out.println("YEARLY SALARY: "+this.yearlySalary());	
		System.out.println("***********************************************");
	}
	public static int getNumOfEmployees(){
		return ecount;
	}

	public static String higherSalary(Employee e1,Employee e2){
		if (e1.monthly_sal == e2.monthly_sal){
			System.out.println("Both "+e1.getFname()+" and "+e2.getLname()+" have same salary!");
			return "";
		}
		if (e1.monthly_sal >  e2.monthly_sal){
			return (e1.getFname()+" "+e1.getLname());
		}else{
			return (e2.getFname()+" "+e2.getLname());
		}
	}

	public static void main(String[] args){
		Scanner in  = new Scanner(System.in);
		Employee e1 = new Employee();
		e1.setFname();
		e1.setLname();
		e1.setSalary();
		e1.displayInfo();

		Employee e2 = new Employee();
		e2.setFname();
		e2.setLname();
		e2.setSalary();
		e2.displayInfo();

		// give raise by 10%
		e1.giveRaise(10);
		e2.giveRaise(10);

		System.out.println("AFTER RAISE BY 10% : ");
		e1.displayInfo();
		e2.displayInfo();

		System.out.println("Whose salary is greater ? : ");
		System.out.println(Employee.higherSalary(e1,e2));


		int no = Employee.getNumOfEmployees();
		System.out.println("The total number of Employees = "+no);	


	}


}