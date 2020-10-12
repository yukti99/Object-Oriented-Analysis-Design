public class SavingsAccount{

	private static double annualInterestRate=0.0;
	private double savingsBalance;
	
	public SavingsAccount(double savingsBalance){
		this.savingsBalance = savingsBalance;
	}
	public double getSavingsBalance(){
		return savingsBalance;
	}
	public void setSavingsBalance(double sb){
		this.savingsBalance = sb;
	}
	
	public double calculateMonthlyInterest(){
		double mi = (this.savingsBalance * annualInterestRate)/12;
		this.savingsBalance += mi ;
		return mi;
	
	}
	public static void modifyInterestRate(double air){
		annualInterestRate = air;
	
	}
	public static void main(String[] args){
		SavingsAccount saver1 = new SavingsAccount(2000.0);
		SavingsAccount saver2 = new SavingsAccount(3000.0);
		SavingsAccount.modifyInterestRate(4);
				
		System.out.println("1st Month Interest for saver1 = "+saver1.calculateMonthlyInterest());
		System.out.println("1st Month Savings for saver1 = "+saver1.getSavingsBalance());
		
		System.out.println("1st Month Interest for saver2 = "+saver2.calculateMonthlyInterest());
		System.out.println("1st Month Savings for saver2 = "+saver2.getSavingsBalance());
		
		SavingsAccount.modifyInterestRate(5);
		System.out.println();
		
		System.out.println("2nd Month Interest for saver1 = "+saver1.calculateMonthlyInterest());
		System.out.println("2nd Month Savings for saver1 = "+saver1.getSavingsBalance());
		
		System.out.println("2nd Month Interest for saver2 = "+saver2.calculateMonthlyInterest());
		System.out.println("2nd Month Savings for saver2 = "+saver2.getSavingsBalance());
		
	
	}

}
