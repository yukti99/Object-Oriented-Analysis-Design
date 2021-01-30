package invoicePackage;

public class Invoice{
    private String item_no;
    private String item_desp;
    private int quant;
    private int price;
	private int amt;
	private String emp_id;
    public static int inv_cnt= 0;

    public Invoice(){
        this.item_no = "";
        this.item_desp = "";
        this.quant = 0;
		this.price = 0;
		this.emp_id = "";
        inv_cnt++;
	}
	public Invoice(String item,String desp,int quant,int price){
        this.item_no = item;
        this.item_desp = desp;
        this.quant = quant;
		this.price = price;
        inv_cnt++;
    }
    public Invoice(String item,String desp,int quant,int price, String eid){
        this.item_no = item;
        this.item_desp = desp;
        this.quant = quant;
		this.price = price;
		this.emp_id = eid;
        inv_cnt++;
    }
    public void setItemNo(String item){
        this.item_no = item;
    }
    public void setItemDesp(String desp){
        this.item_desp = desp;
    }
    public void setQuant(int quant){
        this.quant = quant;
    }
    public void setPrice(int price){
        this.price = price;
	}
	public void setEmpId(String id){
		this.emp_id = id;
	}
    public String getItemNo(){
        return this.item_no;
    }
    public String getItemDesp(){
        return this.item_desp;
    }
    public int getQuant(){
        return this.quant;
    }
    public int getPrice(){
        return this.price;
	}
	public String getEmpId(){
		return this.emp_id;
	}
    public int getInvoiceAmount(){
        this.amt = this.quant*this.price;
        return this.amt;
	}
    public int higherInvoice(Invoice inv1, Invoice inv2){
        return Math.max(inv1.getInvoiceAmount(), inv2.getInvoiceAmount());
    }   
    public void displayInvoice(){
		System.out.println("***********************************************");
		System.out.println("\nINVOICE INFORMATION\n");
        System.out.println("Invoice Number: "+this.getItemNo());
        System.out.println("Invoice Description: "+this.getItemDesp());
        System.out.println("Invoice Quantity: "+this.getQuant());
        System.out.println("Invoice Price: "+this.getPrice());
		System.out.println("Invoice Amount: "+this.getInvoiceAmount());
		System.out.println("Employee ID: "+this.getEmpId());
        System.out.println("\n***********************************************\n");
    }
    public static void main(String[] args){
        System.out.println("Welcome to Invoice Class!!");

    }
}