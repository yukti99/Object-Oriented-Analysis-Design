/* YUKTI KHURANA  */

package departmentStore;
import invoicePackage.*;
import employeePackage.*;

import java.util.*;
import java.io.*;
import java.util.HashMap; 


class DepartmentalStore{
    private String D_Store_Name;
    private String D_Store_Address;
    private Employee[] Employee_List ;
	private Invoice[] Invoice_List ;
	public static int storeCount=0;

	public DepartmentalStore(){
		this.D_Store_Name = "";
		this.D_Store_Address = "";
		this.Employee_List = new Employee[10];
		this.Invoice_List = new Invoice[30];
		storeCount++;

	}
	
    public DepartmentalStore(String name, String addr, Employee[] emplist, Invoice[] invlist){
		this.D_Store_Name = name;
		this.D_Store_Address = addr;
		this.Employee_List = emplist;
		this.Invoice_List = invlist;
		storeCount++;

	}
	
	public void setStoreName(String name){
		this.D_Store_Name = name;
	}
	public String getStoreName(){
		return this.D_Store_Name;
	}
	public void setStoreAddress(String addr){
		this.D_Store_Address = addr;
	}
	public String getStoreAddress(){
		return this.D_Store_Address;
	}
	public void setEmployeeList(Employee[] emplist){
		this.Employee_List = emplist;
	}
	public Employee[] getEmployeeList(){
		return this.Employee_List;
	}
	public void setInvoiceList(Invoice[] invlist){
		this.Invoice_List = invlist;
	}
	public Invoice[] getInvoiceList(){
		return this.Invoice_List;
	}
    // This function returns the name of the employee who has sold the maximum number of the given item
	public Employee StarEmployee(String item_desp){
		int max_no = 0;
		String Star_emp = "";
		// Finding the emp id of Employee who sold max item
		for(int i=0;i<this.Invoice_List.length;i++){
			Invoice inv = this.Invoice_List[i];
			if (item_desp.equals(inv.getItemDesp())){
				if (max_no < inv.getQuant() ){
					max_no  = inv.getQuant();
					Star_emp = inv.getEmpId();					
				}
			}
		}
		if (Star_emp.equals("")){
			return null;
		}
		// using this emp id to get the Employee information from Employee list of Department store
		for(int i=0;i<this.Employee_List.length;i++){
			if (Star_emp == (this.Employee_List[i].getEmpId())){
				return Employee_List[i];
			}
		}	
		return null;
	}
	// function to find the total amount of the sold items in store
	public int totalSold(){
		int l = this.Invoice_List.length;
		int amt=0;	
		for(int i=0;i<l;i++){
			amt+= this.Invoice_List[i].getInvoiceAmount();
		}	
		return amt;
	}	

	public void giveRaiseByID(String id, int x){
		int l = this.Employee_List.length;
		for(int i=0;i<l;i++){
			if (Employee_List[i].getEmpId().equals(id)){
				System.out.println("\nBefore Raise : ");
				Employee_List[i].displayInfo();				
				Employee_List[i].giveRaise(x);
				System.out.println("After Raise : ");
				Employee_List[i].displayInfo();
			}
		}

	}
	public void Increment_Check(){
		int l = this.Invoice_List.length;
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		for(int i=0;i<l;i++){			
			Invoice inv = this.Invoice_List[i];
			//System.out.println(inv.getItemNo());
			String eid = inv.getEmpId();
			if(hmap.containsKey(eid)){
				//System.out.println(eid+" gets "+inv.getQuant()+" for invoice = "+inv.getItemNo());
				hmap.put(eid,hmap.get(eid) + inv.getInvoiceAmount());
			}else{
				hmap.put(eid,inv.getInvoiceAmount());
			}			
		}
		System.out.println("*************************************************************************");
		System.out.println("TOTAL SALES OF EACH EMPLOYEE OF "+this.getStoreName()+" Departmental Store : ");		
		for(Map.Entry<String, Integer> entry : hmap.entrySet()){
            System.out.println(entry.getKey()+ "\t\t" + entry.getValue());
		}		
		System.out.println("*************************************************************************");
		int maxValueInMap = (Collections.max(hmap.values()));  // This will return max value in the Hashmap
        for (Map.Entry<String, Integer> entry : hmap.entrySet()) {  
            if (entry.getValue()== maxValueInMap) {
                System.out.println("\nEMPLOYEE WITH MAXIMUM SALES = "+entry.getKey()+"\n\n");     // Print the key with max value
            }
		}
		// GIVING 10% RAISE TO THE EMPLOYEES WHOSE TOTAL SALES IS MORE THAN Rs. 30,000
		System.out.println("Following Employees got a raise of 10% because their sales were > Rs. 30,000 : ");
		for(Map.Entry<String, Integer> entry : hmap.entrySet()){
			if (entry.getValue() > 30000){
				String emp_id = entry.getKey();
				giveRaiseByID(emp_id,10);
				
			}			            
        }		
		
	}	
	public String maxSoldItem(){
		int l = this.Invoice_List.length;
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		for(int i=0;i<l;i++){			
			Invoice inv = this.Invoice_List[i];
			String id = inv.getItemNo();
			if(hmap.containsKey(id)){
				//System.out.println(eid+" gets "+inv.getQuant()+" for invoice = "+inv.getItemNo());
				hmap.put(id,hmap.get(id) + inv.getQuant());
			}else{
				hmap.put(id,inv.getQuant());
			}			
		}
		for(Map.Entry<String, Integer> entry : hmap.entrySet()){
            System.out.println(entry.getKey()+ "\t\t" + entry.getValue());
		}
		int maxValueInMap = (Collections.max(hmap.values()));  // This will return max value in the Hashmap
        for (Map.Entry<String, Integer> entry : hmap.entrySet()) {  
            if (entry.getValue()== maxValueInMap) {
                return entry.getKey();   // return the key (item) with max value
            }
		}
		return null;
	}

    public static void main(String[] args){
		Scanner in  = new Scanner(System.in);

		// creating Employee List
		Employee[] empList = new Employee[4];
		empList[0] = new Employee("E001","Yukti","Khurana",60000);
		empList[1] = new Employee("E002","Shruti","Sinha",75000);
		empList[2] = new Employee("E003","Raju","Goyal",91000);
		empList[3] = new Employee("E004","Aryan","Gupta",85000);
		

		// creating Invoice List 
		Invoice[] invList = new Invoice[15];
		invList[0] = new Invoice("I001","INVOICE-ABX",12,560,"E001");
		invList[1] = new Invoice("I002","INVOICE-XOP",15,240,"E002");
		invList[2] = new Invoice("I003","INVOICE-BAC",2,678,"E001");
		invList[3] = new Invoice("I004","INVOICE-LJA",10,5120,"E002");
		invList[4] = new Invoice("I005","INVOICE-QWR",6,900,"E001");
		invList[5] = new Invoice("I006","INVOICE-OIS",9,1000,"E003");
		invList[6] = new Invoice("I002","INVOICE-XOP",11,930,"E004");
		invList[7] = new Invoice("I008","INVOICE-BEU",4,1210,"E002");
		invList[8] = new Invoice("I009","INVOICE-PDW",10,850,"E001");
		invList[9] = new Invoice("I010","INVOICE-MQN",13,999,"E003");	
		invList[10] = new Invoice("I001","INVOICE-ABX",9,1100,"E001");
		invList[11] = new Invoice("I003","INVOICE-BAC",11,930,"E004");
		invList[12] = new Invoice("I001","INVOICE-ABX",4,1210,"E002");
		invList[13] = new Invoice("I009","INVOICE-PDW",9,780,"E003");
		invList[14] = new Invoice("I001","INVOICE-ABX",15,450,"E004");
		
		
		// Creating Department Store Object
		DepartmentalStore ds1 = new DepartmentalStore("Chikoo's","Noida, UP",empList,invList);

		System.out.println("\n\n!!! Welcome to "+ ds1.getStoreName()+" Department Store !!!\n");
		//System.out.println("Enter the Name/Description of the item : ");
		//String item = in.nextLine();
		String item = "INVOICE-BAC";
		Employee starEmployee = ds1.StarEmployee(item);
		if (starEmployee != null){
			System.out.println("The Employee who sold maximum quantity of "+item+" is : \n");
			starEmployee.displayInfo();
		}else{
			System.out.println("Sorry! No Employee found who sold maximum quantity of this item");
		}

		System.out.println("Department Store Revenue:  Rs. "+ds1.totalSold());
		
		System.out.println("Increment Checking...\n");
		ds1.Increment_Check();

		String maxSold = ds1.maxSoldItem();
		if (maxSold.isEmpty()){
			System.out.println("No Item was sold in the store yet...");
		}else{
			System.out.println("The Maximum sold item of the store : "+maxSold);
		}
    }
}

