package bank;

import java.util.Scanner; //for setters

public class Customer {
    //class Customer data members
    private int id;
    private String name, address, email, mobileNumber;
    private Account account;
    
    //class Customer constructor
    public Customer() {
        addInfo();
        account = new Account(); //instantiate a new account for each customer created
    }
    
    Scanner scan = new Scanner(System.in); //to get input
    
    //returns id
    public int getId() {
        return id;
    }
    
    //asks for customer's id and sets it
    public void setId() {
        System.out.println("Please enter Customer's ID: ");
        this.id = scan.nextInt();
    }
    
    //returns name
    public String getName() {
        return name;
    }
    
    //asks for customer's name and sets it
    public void setName() {
        System.out.println("Please enter Customer's Name: ");
        this.name = scan.next();
    }
    
    //returns address
    public String getAddress() {
        return address;
    }
    
    //asks for customer's address and sets it
    public void setAddress() {
        System.out.println("Please enter Customer's Address: ");
        this.address = scan.next();
    }
    
    //returns email
    public String getEmail() {
        return email;
    }
    
    //asks for customer's email and sets it
    public void setEmail() {
        System.out.println("Please enter Customer's Email: ");
        this.email = scan.next();
    }
    
    //returns mobile number
    public String getMobileNumber() {
        return mobileNumber;
    }
    
    //asks for customer's mobile number and sets it
    public void setMobileNumber() {
        System.out.println("Please enter Customer's Mobile Number: ");
        this.mobileNumber = scan.next();
    }
    
    //returns data member of type Account
    public Account getAccount() {
        return this.account;
    }
    
    //gathers all setters to call in constructor once
    private void addInfo() {
        setName();
        setId();
        setMobileNumber();
        setAddress();
        setEmail();
        System.out.println("Customer added successfully.");
    }
    
    //overriden toString method
    @Override
    public String toString() {
        return "Name: "+getName()+", ID: "+getId()+"\nMobile Number: "+getMobileNumber()+
                ", Email: "+getEmail()+", Address: "+getAddress()+"\n"+getAccount();
    }
}
