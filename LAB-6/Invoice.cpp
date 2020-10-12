
/*
SAMPLE QUESTION WITH ANSWER

Ques:
You are required to create a class ― “Invoice”. 
This class might be used by a departmental store to represent an invoice for an item sold at the store. 
An Invoice should include four data members— item number (type string),
item description or name (type string), quantity of the item being purchased 
(type int) and price per item (type int). Your class should have a constructor
that initializes the four data members. Provide a set and a get function for each data member. 
In addition, provide a member function named getInvoiceAmount that calculates the invoice amount 
(i.e., multiplies the quantity by the price per item), then returns the amount as an int value.
dsds Write a function that accepts two invoices for different departmental stores 
and return the maximum quantity out of two invoices.

*/
#include<iostream>
#include<string.h>
#include <cstdlib>
#include<vector>
using namespace std;
class invoice
{
    int item_no;
    string name[100];
    int quantity[10];
    int price[10];
public:
    invoice()
    {
         for(int i=0;i<10;i++)
     {
        quantity[i]=0;
        price[i]=0;
        }
    }
    void get_item_no()
    {
        cout<<"enter number"<<endl;
        cin>>item_no;
    }
    void get_name()
    {
        cout<<"enter name"<<endl;
        for(int i=0;i<item_no;i++)
        {
            cin>>name[i];
        }
    }
    void get_quantity()
    {
        cout<<"enter quantity"<<endl;
        for(int i=0;i<item_no;i++)
        {
            cin>>quantity[i];
        }
    }
    void get_price()
    {
        cout<<"enter price"<<endl;
        for(int i=0;i<item_no;i++)
        {
            cin>>price[i];
        }
    }
    void show()
    {
        int sum=0;
        cout<<"item_no     ";
            cout<<"name     ";
            cout<<"quantity     ";
            cout<<"price "<<endl;
        for(int i=0;i<item_no;i++)
        {
            sum=sum+(quantity[i]*price[i]);
            cout<<i+1<<"         ";
            cout<<name[i]<<"        ";
            cout<<quantity[i]<<"         ";
            cout<<price[i];
            cout<<endl<<endl;
        }
        cout<<"total ammount to be paid=   "<<sum<<endl;
        cout<<"_________________________________________________"<<endl;
    }
    int get_invoice_quantity()
    {
        int sum=0;
        for(int i=0;i<item_no;i++)
        {
            sum=sum+quantity[i];
        }
        return sum;
    }
};
int main()
{
    invoice a,b;
    cout<<"enter for store a"<<endl;
    a.get_item_no();
    a.get_name();
    a.get_quantity();
    a.get_price();
    a.show();
    cout<<endl<<"enter for store b"<<endl;
    b.get_item_no();
    b.get_name();
    b.get_quantity();
    b.get_price();
    b.show();
    int am=a.get_invoice_quantity();
    int bm=b.get_invoice_quantity();
    if(am>bm){
        cout<<endl<<"max quantity is of store a =  "<<am;
    }
    Else{
        cout<<endl<<"max quantity is of store b =  "<<bm;
    }
    return 0;
}