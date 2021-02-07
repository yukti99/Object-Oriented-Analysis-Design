import java.util.*;
import java.io.*;


class Mobile{
    private int m_id;    
    private String company;
    private String front_camera;
    private String rear_camera;
    private int price;
    private int memory;

    

    // for the number of mobile phones available to be bought
    public static int contact_cnt=0;

    private Sim m_sim;
    private User m_user;   
    private Boolean isFunctional;
    private int mobile_no;

    // For storing the contacts in the mobile
    private User[] storage;

    public static Mobile[] allMobiles = new Mobile[10000];
    public static int no_mobiles=0;

    // For call log information
    private HashMap<User,ArrayList<String>> call_records;
    
   
    // constructor to initialize all variables 
    public Mobile(){
        isFunctional = false;
        Random rand = new Random(); 
        this.m_id = rand.nextInt(100000); 

        // mobile features (optional)
        this.company = "";
        this.front_camera = "";
        this.rear_camera = "";
        this.price = 0;
        this.memory = 1000;

        // regarding usage of the mobile (must have sim and a user who bought the mobile)
        this.m_sim = null;
        this.m_user = null;
        this.mobile_no = 0;
        this.contact_cnt = 0;

        // for calling purposes
        this.storage = new User[this.memory];
        this.call_records = new HashMap<>();

        allMobiles[no_mobiles++] = this;
    }
    public Mobile(String company, String fc, String rc, int price, int memory){
        isFunctional = false;
        Random rand = new Random(); 
        this.m_id = rand.nextInt(100000);
        // mobile features (optional)
        this.company = company;
        this.front_camera = fc;
        this.rear_camera = rc;
        this.price = price;
        this.memory = memory; 
        // regarding usage of the mobile (must have sim and a user who bought the mobile)
        this.m_sim = null;
        this.m_user = null;
        this.mobile_no = 0;
        this.contact_cnt = 0;
        // for calling purposes
        this.storage = new User[this.memory];
        this.call_records = new HashMap<>();
        allMobiles[no_mobiles++] = this;

    }

    // returns user given mobile_no
    public static User getUserFromNumber(int mobile_no){
        for(int i=0;i<no_mobiles;i++){
            if (allMobiles[i].getMobileNo() == mobile_no){
                return allMobiles[i].getUser();
            }
        }
        return null;

    }

    // to associate this mobile to some user who has bought it 
    public void setUser(User user){
        this.m_user = user;
    }
    public User getUser(){
        return this.m_user;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public int getPrice(){
        return this.price;
    }
    public int getMobileId(){
        return this.m_id;
    }
    public void setMobileNo(int num){
        this.mobile_no = num;
    }
    public int getMobileNo(){
        return this.mobile_no;
    }
    public void setCompany(String c){
        this.company = c;
    }
    public String getCompany(){
        return this.company;
    }
    // to check if this mobile has been bought by a user yet
    public Boolean hasUser(){
        return (this.m_user!=null);
    }
    // for storing new contacts in the sim storage  
    public Boolean storeContacts(User user){
        // store contact only if the user exists and they have a working mobile phone (with sim)
        if (User.existUser(user.getUserId())==true){
            if (user.hasWorkingMobile() == true){
                this.storage[contact_cnt] = user; 
                contact_cnt++;
                return true;
            }
        }
        return false;           
    }
     // to check if a particular user is part of the contacts storage
    public User contactExist(int mobile_no){
        if (this.storage.length == 0){
            return null;
        }
        for(int i=0;i<contact_cnt;i++){
            if (this.storage[i]!=null){
                User u = this.storage[i];
                if (u.getSim().getSimNo() == mobile_no){
                    return u;
                }
            }
        }
        return null;
    }
    // for displaying the contacts already stored in the mobile storage
    public void displayStoredContacts(){
        for(int i=0;i<contact_cnt;i++){
            User u = this.storage[i];
            if (u!=null){
                u.displayUserInfo();
            }
        }
    }
    public void storeCallLogs(String call_type, User user){ 
        for (Map.Entry<User, ArrayList<String>> entry : this.call_records.entrySet()) {       
            User u = entry.getKey();
            if (u == user){
                ArrayList<String> v = entry.getValue();
                v.add(call_type);
                this.call_records.put(u,v);
                return;
            }         
        }
        ArrayList<String> newList = new ArrayList<String>();
        newList.add(call_type);
        this.call_records.put(user,newList);
        return ;
    }
    public void displayCallLogs(){
        System.out.println("Call Logs for Mobile-"+this.getMobileId());
        this.call_records.forEach((k, v) -> System.out.println(k.getMobile().getMobileNo() + " : " + v)); 
        System.out.println();
    }
    // this function will return the user that has called the current instance user the maximum number of times
    public User getMaxIncomingUser(){ 
        User maxUser = null;
        int maxCount = 0;    
        for (Map.Entry<User, ArrayList<String>> entry : this.call_records.entrySet()) {       
            User u = entry.getKey();
            ArrayList<String> t = entry.getValue();
            // traversing the individual call list associated with a number
            int cnt=0;
            for(int i=0;i<t.size();i++){
                String s = t.get(i);
                if (s.charAt(0) == 'i'){
                    cnt++;
                }
                //System.out.println(u+" : "+s.charAt(0));  
            }
            if (cnt > maxCount){
                maxCount  = cnt;
                maxUser = u;
            }                        
        }
        return maxUser;      
    }
    public void displayMobileInfo(){
        System.out.println("\n***Mobile Info******************************");
        System.out.println("Mobile Id: "+this.m_id);
        System.out.println("Company: "+this.company) ;
        System.out.println("Front camera: "+this.front_camera) ;
        System.out.println("Rear camera: "+this.rear_camera) ;
        System.out.println("Price: Rs."+this.price) ;
        System.out.println("Memory: "+this.memory) ;
        System.out.println("********************************************\n");
    }
}

class Sim{
    private int sim_no;  // sim_id = mobile number of the sim, connected to sim_id of class Mobile
    private User[] storage;   
    private Mobile mob;
    private User s_user;
    private int price;
    private static int contact_cnt;


    // contructor to intialize all the components
    public Sim(int sim_no, int memory){
        // every sim must have a number associated with it, otherwise it cannot be created
        this.sim_no = sim_no;
        this.storage = new User[memory];    
        this.s_user = null;    
        this.mob = null; // no associated mobile yet
        this.price = 0;
        this.contact_cnt = 0;
    }
    public void setUser(User user){
        this.s_user = user;
    }
    public User getUser(){
        return this.s_user;
    }
    public int getPrice(){
        return this.price;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public void setSimNo(int num){
        this.sim_no = num;
    }
    public int getSimNo(){
        return this.sim_no;
    }
    public void setMobile(Mobile mob){
        this.mob = mob;
    }
    public Mobile getMobile(){
        return this.mob;
    }
    // for storing new contacts in the sim storage  
    public Boolean storeContacts(User user){
        // store contact only if the user exists and they have a working mobile phone (with sim)
        if (User.existUser(user.getUserId())==true){
            if (user.hasWorkingMobile() == true){
                this.storage[contact_cnt] = user; 
                contact_cnt++;
                return true;
            }
        }
        return false;           
    }
    // to check if a particular user is part of the contacts storage
    public User contactExist(int mobile_no){
        if (this.storage.length == 0){
            return null;
        }
        for(int i=0;i<contact_cnt;i++){
            if (this.storage[i]!=null){
                User u = this.storage[i];
                if (u.getSim().getSimNo() == mobile_no){
                    return u;
                }
            }
        }
        return null;
    }
    // for displaying the contacts already stored in the sim storage
    public void displayStoredContacts(){
        for(int i=0;i<contact_cnt;i++){
            User u = this.storage[i];
            if (u!=null){
                u.displayUserInfo();
            }
        }
    }
}

class User{
    // to uniquely identify a user
    private int user_id;
    private String user_name;

    // For mobile and sim of the user
    private Mobile mobile;
    private Sim sim;

    // to check is the current instance user has a working mobile phone or not
    private Boolean workingMobile;

    // For bank account of the user
    private int accounts_count=0;
    private Account[] accounts;    

    // to keep track of all users existing till now
    public static int no_users=0;
    public static User[] allUsers=new User[1000];
    

    public User(){
        this.user_id=0;
        no_users++;

        this.user_name = "";

        this.mobile = null;
        this.sim = null;
        this.workingMobile = false;

        this.accounts = new Account[5];  
        
        this.storeUser();       
        
    }
    public int storeUser(){
        // create unique user id
        this.user_id = 1000+no_users;

        // store new user information
        int index = no_users - 1;
        allUsers[index] = this;

        // return generated user id
        return user_id;
    }
    public static void displayAllUsers(){
        System.out.println("\n---All Users------------------------------------");
        for(int i=0;i<no_users;i++){
            allUsers[i].displayUserInfo();
        }
        System.out.println("--------------------------------------------------\n");
    }

    // to return the array containing all the users in existence till now
    public User[] getAllUsers(){
        return this.allUsers;
    }     
    // to return the count of total number of users in existence
    public int getUserCount(){
        return this.no_users;
    }   
    // to get a particular user's id
    public int getUserId(){
        return this.user_id;
    }   
    // get the sim owned by the user
    public Sim getSim(){
        return this.sim;
    }
    // get the mobile owned by the user
    public Mobile getMobile(){
        return this.mobile;
    }
    public Boolean hasWorkingMobile(){
        return this.workingMobile;

    }
    
    public Boolean buyMobile(Mobile m){
        // first check if this user has an account or not
        int balance = this.getAccountBalance();
        if (balance == 0){
            System.out.println("Sorry! you have insufficient account balance to buy this sim!");
            return false; 
        }
        int m_price = m.getPrice();
        if (balance >= m_price){
            for(int i=0;i<accounts_count && m_price!=0;i++){
                m_price -= this.accounts[i].withdrawAllMoney(m_price);
            }
            if (m_price == 0){
                this.mobile = m;
                m.setUser(this);
                System.out.println("Congrats on buying your new mobile!");
                return true;
            }
        }
        System.out.println("Sorry! you have insufficient account balance to buy this mobile phone!");
        return false;      

    }
    public Boolean buySim(Sim s){
        int balance = this.getAccountBalance();
        if (balance == 0){
            System.out.println("Sorry! you have insufficient account balance to buy this mobile!");
            return false; 
        }
        int s_price = s.getPrice();
        if (balance >= s_price){
            for(int i=0;i<accounts_count && s_price!=0;i++){
                s_price -= this.accounts[i].withdrawAllMoney(s_price);
            }
            if (s_price == 0){
                this.sim = s;
                s.setUser(this);
                System.out.println("Congrats on buying your new sim!");
                return true;
            }
        }
        System.out.println("Sorry! you have insufficient account balance to buy this sim!");
        return false;                

    }
    // to associate a user with a new mobile
    public Boolean buyMobile(Account a, Mobile m){
        int balance = a.getBalance();
        int m_price = m.getPrice();
        if (balance >= m_price){
            if (a.withdrawMoney(m_price) != false){
                this.mobile = m;
                m.setUser(this);
                System.out.println("Congrats on buying your new mobile!");
                return true;
            }
        }
        System.out.println("Sorry! you have insufficient balance in this account to buy this mobile phone!");
        return false;          

    }    
    //to associate a user with a new Sim 
    public Boolean buySim(Account a, Sim s){
        int balance = a.getBalance();
        int s_price = s.getPrice();
        if (balance >= s_price){
            if (a.withdrawMoney(s_price) != false){
                this.sim = s;
                s.setUser(this);
                System.out.println("Congrats on buying your new sim!");
                return true;
            } 
        }
        System.out.println("Sorry! you have insufficient balance in this account to buy this sim!");
        return false;
              
    }   
    
    // to activate the mobile phone of a user
    public void activateMobile(){
        if (this.mobile != null && this.sim != null){
            this.workingMobile = true;
            this.mobile.setMobileNo(this.sim.getSimNo());
            System.out.println("Activated number = "+this.mobile.getMobileNo());

            System.out.println("Congrats! you have a working mobile with sim now! Your mobile number - "+this.sim.getSimNo());
        }else{
            System.out.println("Sorry! you need both sim and mobile for activation and proper functioning !");

        }
    }
    // Given a user id, to check if a user associated with this id is in existence or not
    public static Boolean existUser(int id){
        for(int i=0;i<allUsers.length;i++){
            if (id == allUsers[i].getUserId()){
                return true;
            }
        }
        return false;

    }
    // the function to make a call to any user in the contact list of the user's associated mobile phone
    public Boolean makeCall(int mobile_no){
        if (this.workingMobile==false || this.sim==null || this.mobile==null){
            System.out.println("Sorry! You don't have a functioning mobile yet! so you cannot make a call");
            System.out.println("Please buy a sim and mobile and activate it to make calls..");
            return false;
        }  
        
        // check if the user is amongst the contact list of the user's mobile/sim storage
        User callee = this.sim.contactExist(mobile_no);
        if (callee == null){
            callee = this.mobile.contactExist(mobile_no);
            if (callee == null){
                System.out.println("Sorry this contact is neither in your mobile storage nor in your sim storage..");
                return false;
            }
        }
        User u = Mobile.getUserFromNumber(mobile_no); 
        if (u==null || u.workingMobile==false){
            return false;
        } 
          
        // now callee is the user that needs too be called
        System.out.println("\nNotification for user-"+u.getUserId()+": ");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@ "+this.mobile.getCompany()+" User with mobile number-"+this.mobile.getMobileNo()+" is calling @@@@@@@@@@@@@@@@@@@@@@@@@\n");
        
                 
        // Storing the call log in call records
        this.mobile.storeCallLogs("outgoing "+ java.time.LocalTime.now(),u);  
        u.getMobile().storeCallLogs("incoming "+ java.time.LocalTime.now(),this);     

        return true;      
        
    }
    public Boolean saveContactToSim(User user){
        if (this.workingMobile==false){
            System.out.println("Error! You need a functioning mobile for saving contacts...");
            return false;
        }
        if (this.sim.storeContacts(user)==true){
            System.out.println("Contact saved successfully!");
            return true;
        }
        System.out.println("Error while saving contact...");
        return false;
    }

    public Boolean saveContactToMobile(User user){
         if (this.workingMobile==false){
            System.out.println("Error! You need a functioning mobile for saving contacts...");
            return false;
        }
        if (this.mobile.storeContacts(user)==true){
            System.out.println("Contact saved successfully!");
            return true;
        }
        System.out.println("Error while saving contact...");
        return false;
    }
    public void displayMobileContacts(){
        if (workingMobile == true){
            this.mobile.displayStoredContacts();
        }else{
            System.out.println("Action not possible! You need a working mobile phone..");
        }
    }
    public void displaySimContacts(){
        if (workingMobile == true){
            this.sim.displayStoredContacts();
        }else{
            System.out.println("Action not possible! You need a working mobile phone..");
        }
        
    }

    // to create an account 
    public Account create_account(){
        if (accounts_count>=5){
            System.out.println("Sorry! Account Generation not possible as user already has 5 accounts..");
            return null;
        }
        System.out.println("\n********************Welcome to Account Generation*****************\n");
        System.out.println("Enter the starting balance in the account: ");
        Scanner in = new Scanner(System.in);
        int balance = in.nextInt();
        Account a = new Account(this,balance); 
        this.accounts[accounts_count] = a;
        accounts_count++;
        return a;
    }
    public int getAccountBalance(){
        int total=0;
        for(int i=0;i<accounts_count;i++){
            total+= this.accounts[i].getBalance();
        }
        return total;
    }
    public void displayAccounts(){
        System.out.println("\nThe user has following "+ accounts_count + " Bank Accounts : ");
        for(int i=0;i<accounts_count;i++){
            this.accounts[i].displayAccountInfo();
        }

    }
    
    public void displayUserInfo(){
        System.out.println("\n***User Info******************************");   
        System.out.println("User Id: "+this.user_id) ;
        if (this.mobile != null){
            System.out.println("Mobile Model: "+this.mobile.getMobileId()) ;
        }else{
            System.out.println("Mobile Model: None") ;
        }
        if (this.sim != null){
            System.out.println("Sim : Exists");
            System.out.println("Mobile number: "+this.sim.getSimNo()) ;
        }else{
            System.out.println("Sim : None");
            System.out.println("Mobile number: None") ;
        }        
        System.out.println("********************************************\n");

    }
    
}

class Account{
    private int account_id;
    private User a_user;
    private int balance;

    // constructor for initialization
    public Account(User user, int balance){

        Random rand = new Random(); 
        this.account_id = rand.nextInt(100000); 

        this.a_user = user;
        this.balance = balance;

        System.out.println("Account Generation Successful!!");
        System.out.println("Your Account ID = "+this.account_id);

    }
    public int getAccountId(){
        return this.account_id;
    }
    public int getBalance(){
        return this.balance;
    }
    public User getUser(){
        return this.a_user;
    }
    public void depositMoney(int amt){
        this.balance+=amt;
        System.out.println("Rs."+amt+" successfully added into Account No-"+this.account_id);
    }
    public int withdrawAllMoney(int amt){
        Scanner in = new Scanner(System.in);
        int w = 0;
        System.out.println("\n\nWithdrawing money from Account No-"+this.account_id);
        if (amt > this.balance){
            w = this.balance;
            System.out.println("\nSorry! this account has insufficient funds!");
            System.out.println("Withdrawing maximum amount possible..");      
        }else{ 
            w = amt;                
            System.out.println("\nComplete Money withdraw Successful! :) ");            
        } 
        System.out.println("\n\nAmount withdrawn = Rs."+w);
        this.balance -= w;
        System.out.println("New account balance = "+this.balance+"\n\n");
        
        return w; 
    }
    public Boolean withdrawMoney(int amt){
        Scanner in = new Scanner(System.in);
        if(this.balance < amt){
            System.out.println("Sorry! Insufficient funds for withdrawal...");
            return false;
        }else{
            int ans = 0;
            System.out.println("Do you really want to withdraw Rs."+amt+" from Account No-"+this.account_id+" ? (1-Yes/0-No)");
            ans = in.nextInt();
            if (ans==1){
                System.out.println("Withdrawal of Rs."+amt+" is Successful!");
            }else{
                System.out.println("Withdrawal was Unsuccessful..");
            }            
            this.balance -= amt;
            return true;
        }

    }
    public void displayAccountInfo(){     
        System.out.println("\n***Account Info******************************");
        System.out.println("Account Id: "+this.account_id);
        System.out.println("User Id: "+this.a_user.getUserId()) ;
        System.out.println("Balance: Rs."+this.balance) ;
        System.out.println("********************************************\n");
    }
}

class UserCalling{
    public static void main(String[] args){

        // creating a user-1
        User u1 = new User();

        // creating the bank accounts of user 
        Account a1 = u1.create_account();
        Account a2 = u1.create_account();

        // creating a mobile
        Mobile m1 = new Mobile("Redmi","64","32",11000,100);
       

        // creating a sim  
        Sim s1 = new Sim(971764,1000);
        s1.setPrice(500);

        // user bought a mobile phone 
        u1.buyMobile(m1);

        // user bought a sim
        u1.buySim(s1);

        // user activated the mobile phone by inserting sim into their mobile phone
        u1.activateMobile();    
        
        // user bank account information is being displayed
        u1.displayAccounts();  
        
        // user personal information is being displayed
        u1.displayUserInfo();        
           
        System.out.println("The total balance of all accounts of User "+u1.getUserId()+" = Rs."+ u1.getAccountBalance());   


         // creating a user-2
        User u2 = new User();

        // creating the bank accounts of user 
        Account a3 = u2.create_account();
        Account a4 = u2.create_account();

        // creating a mobile
        //Mobile m2 = new Mobile();
        //m2.setPrice(9000);
        Mobile m2 = new Mobile("Samsung","128","64",16000,200);

        m1.displayMobileInfo();
        m2.displayMobileInfo();

        // creating a sim  
        Sim s2 = new Sim(88392,2400);
        s2.setPrice(500);

        // user bought a mobile phone 
        u2.buyMobile(m2);

        // user bought a sim
        u2.buySim(s2);

        // user activated the mobile phone by inserting sim into their mobile phone
        u2.activateMobile();    
        
        // user bank account information is being displayed
        u2.displayAccounts();  
        
        // user personal information is being displayed
        u2.displayUserInfo();        
           
        System.out.println("The total balance of all accounts of User "+u2.getUserId()+" = Rs."+ u2.getAccountBalance());   

        u1.saveContactToMobile(u2);
        System.out.println("User-1's stored contacts: ");
        u1.displayMobileContacts();

        User u3 = new User();

        User.displayAllUsers();

        u2.saveContactToMobile(u1);
        System.out.println("User-2's stored contacts: ");
        u2.displayMobileContacts();

        if(u2.makeCall(u1.getMobile().getMobileNo())==false){
            System.out.println("Error! Try calling again later!\n");
        } 
        if(u1.makeCall(u2.getMobile().getMobileNo())==false){
            System.out.println("Error! Try calling again later!\n");
        }
        Mobile m4 = new Mobile("Xiaomi","128","32",19000,500); 
        Sim s3 = new Sim(989898,1200);
        Account a5 = u3.create_account();
        u3.buyMobile(m4);
        u3.buySim(s3);
        u3.activateMobile();   
        u3.saveContactToMobile(u2);

        if(u3.makeCall(u2.getMobile().getMobileNo())==false){
            System.out.println("Error! Try calling again later!\n");
        } 
        
        m1.displayCallLogs();
        m2.displayCallLogs();

        // Question Part-A : Who are the users capable enough to purchase a specific mobile phone model? 
        System.out.println("##########################################################################");
        Mobile m3 = new Mobile("Apple","256","64",45000,1000);
        m3.displayMobileInfo();
        System.out.println("\nThe following users can buy the above mobile phone: \n");
        
        for(int i=0;i<User.no_users;i++){
            User u = User.allUsers[i];
            if (u.getAccountBalance() >= m3.getPrice()){
                u.displayUserInfo();
            }
        }
        System.out.println("##########################################################################");

        // Question Part-B : Name the user who has made the maximum call to a particular user
        // let the user to be called be user-4
        User u4 = new User();
        Account a6 = u4.create_account();
        Mobile m5 = new Mobile("Redmi","64","32",11000,900); 
        Sim s4 = new Sim(123123,1000);
        u4.buyMobile(m5);
        u4.buySim(s4);
        u4.activateMobile();   
        u1.saveContactToMobile(u4);
        u2.saveContactToMobile(u4);
        u3.saveContactToMobile(u4);
        u4.saveContactToMobile(u1);
        u4.saveContactToMobile(u2);

        u4.makeCall(u1.getMobile().getMobileNo());
        u4.makeCall(u2.getMobile().getMobileNo());   
        u1.makeCall(u4.getMobile().getMobileNo());
        u1.makeCall(u4.getMobile().getMobileNo());
        u1.makeCall(u4.getMobile().getMobileNo());
        u2.makeCall(u4.getMobile().getMobileNo());
        u3.makeCall(u4.getMobile().getMobileNo());
        u2.makeCall(u4.getMobile().getMobileNo());
        u3.makeCall(u4.getMobile().getMobileNo());
        u1.makeCall(u4.getMobile().getMobileNo());      

        
        u4.getMobile().displayCallLogs();
        User maxUser =  u4.getMobile().getMaxIncomingUser();
        System.out.println("\nThe user that has called User - "+u4.getUserId()+ " the maximum number of time: ");
        maxUser.displayUserInfo();
        
        System.out.println("##########################################################################");
       

    }
}