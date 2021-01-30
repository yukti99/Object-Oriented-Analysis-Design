package employeePackage;

public class Employee{
	public static int ecount = 0;
	private String fname;
	private String lname;
	private int monthly_sal;
	private String emp_id; 
	

	public Employee(){
		this.fname = "";
		this.lname = "";
		this.monthly_sal = 0;
		this.emp_id = "";
		ecount++;
	}

	public Employee(String id, String fn, String ln, int ms){
		this.fname = fn;
		this.lname = ln;
		this.monthly_sal = ms;
		this.emp_id = id;
		ecount++;
	}

	public void setEmpId(String id){
		this.emp_id = id;
	}
	public void setFname(String fn){
		this.fname = fn;
	}
	public void setLname(String ln){
		this.lname = ln;
	}
	public void setSalary(int s){
		this.monthly_sal = s;
	}
	public String getEmpId(){
		return this.emp_id;
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
		System.out.println("\nEMPLOYEE RECORDS\n");
		System.out.println("Employee ID: "+this.getEmpId());
		System.out.println("First Name: "+this.getFname());	
		System.out.println("Last Name: "+this.getLname());	
		System.out.println("Monthly Salary: "+this.getSalary());	
		System.out.println("Yearly Salary: "+this.yearlySalary());	
		System.out.println("\n***********************************************\n");
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
        System.out.println("Welcome to Employee Class!!");

    }

}