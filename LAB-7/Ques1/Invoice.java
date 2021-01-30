import java.util.*;
import java.io.*;


class Invoice{
    private String item_no;
    private String item_desp;
    private int quant;
    private int price;
    private int amt;
    public static int inv_cnt= 0;

    public Invoice(){
        this.item_no = "";
        this.item_desp = "";
        this.quant = 0;
        this.price = 0;
        inv_cnt++;
    }
    public Invoice(String item,String desp,int quant,int price){
        this.item_no = item;
        this.item_desp = desp;
        this.quant = quant;
        this.price = price;
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
    public int getInvoiceAmount(){
        this.amt = this.quant*this.price;
        return this.amt;
    }
    public int higherInvoice(Invoice inv1, Invoice inv2){
        return Math.max(inv1.getInvoiceAmount(), inv2.getInvoiceAmount());
    } 
  
    public void displayInvoice(){
        System.out.println("*****************************************************");
        System.out.println("Invoice Number : "+this.getItemNo());
        System.out.println("Invoice Description : "+this.getItemDesp());
        System.out.println("Invoice Quantity : "+this.getQuant());
        System.out.println("Invoice Price : "+this.getPrice());
        System.out.println("Invoice Amount: "+this.getInvoiceAmount());
        System.out.println("*****************************************************");

    }
    public static void main(String[] args){
        
        Scanner inp = new Scanner(System.in);      

        System.out.println("\n INVOICE-1 \n");
        System.out.println("Please Enter Invoice number : ");
        String inv1_no = inp.nextLine();
        System.out.println("Please Enter Invoice Name/Description : ");
        String inv1_desp = inp.nextLine();            
        System.out.println("Please Enter Invoice quantity : ");
        int inv1_q = inp.nextInt();
        System.out.println("Please Enter Invoice Price : ");
        int inv1_p = inp.nextInt();    
        
        Invoice inv1 = new Invoice();
        inv1.setItemNo(inv1_no);
        inv1.setItemDesp(inv1_desp);
        inv1.setPrice(inv1_p);
        inv1.setQuant(inv1_q);

        Invoice inv2 = new Invoice("431","INVOICE-ABX",12,560);
      
        inv1.displayInvoice();
        inv2.displayInvoice();

        System.out.println("The number of Invoices : "+Invoice.inv_cnt);
        System.out.println("The Higher Invoice Amount amongst the two invoices : "+inv1.higherInvoice(inv1,inv2));


    }
}