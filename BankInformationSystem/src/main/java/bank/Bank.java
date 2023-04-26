package bank;

import java.util.Scanner;
import java.util.Vector;

public class Bank {
    
    private static Scanner scan = new Scanner(System.in); //to get input from user
    private static Vector <Customer> customersList = new Vector<>(); //collection of customers
    
    public static void main(String[] args) {
        int selection; //for scanner input
        
        printNames(); //student's names
        
        while (true) {
            printMenu();
            
            System.out.println("selection: ");
            selection = scan.nextInt();
            
            switch (selection) {
                ///////////////create a new customer///////////////
                case 1:
                    Customer customer = new Customer(); //instantiates a customer
                    customersList.add(customer); //adds newly created customer to vector
                    break;
                    
                /////////////////////deposit///////////////////////
                case 2:
                    Customer c1 = checkAccount(customersList);
                    if (c1==null) {
                        break;
                    } else {
                        System.out.println("Please enter the amount you want to deposit: ");
                        c1.getAccount().deposit(scan.nextDouble());
                    }
                    break;
                
                ////////////////////withdraw///////////////////////
                case 3:
                    Customer c2 = checkAccount(customersList);
                    if (c2==null) {
                        break;
                    } else {
                        System.out.println("Please enter the amount you want to withdraw: ");
                        c2.getAccount().withdraw(scan.nextDouble());
                    }
                    break;
                
                //////////////////check account////////////////////
                case 4:
                    Customer c3 = checkAccount(customersList);
                    if (c3==null) {
                        break;
                    } else {
                        System.out.println(c3);
                    }
                    break;
                
                ////////////////////add loan///////////////////////
                case 5:
                    Customer c4 = checkAccount(customersList);
                    if (c4==null) {
                        break;
                    } else {
                        if (c4.getAccount().isHasLoan()==true) {
                            System.out.println("This account has an existing loan, the first loan's payments must be completed.");
                            break;
                        }
                        c4.getAccount().getNewLoan();
                        System.out.println("Loan added successfully.");
                        c4.getAccount().deposit(c4.getAccount().getLoan().getLoanAmount());
                        break;
                    }
                    
                ///////////////////check loan//////////////////////
                case 6:
                    Customer c5 = checkAccount(customersList);
                    if (c5==null) {
                        System.out.println("This account does not have a loan.");
                        break;
                    } else {
                        if (c5.getAccount().getLoan()==null) {
                            System.out.println("This account does not have a loan.");
                            break;
                        }
                        System.out.println(c5.getAccount().getLoan());
                        break;
                    }
                    
                //////////////////pay for loan/////////////////////
                case 7:
                    Customer c6 = checkAccount(customersList);
                    if (c6==null) {
                        break;
                    } else {
                        if (c6.getAccount().getLoan().getReminingAmount()==0) {
                            System.out.println("This account does not have a loan.");
                            break;
                        }
                        c6.getAccount().payLoan();
                        c6.getAccount().checkLoanStatus();
                        break;
                    }
                
                //////////////////exit program/////////////////////
                case 8:
                    System.out.println("We hope to see you again.\nProgram closed successfully.");
                    System.exit(0);
                
                ////////////////invalid program////////////////////
                default:
                    System.out.println("Invalid input.");
                    break;
            }
        }
    }
    
    /*method that takes a vector of customers and asks for account number,
   then it will loop through the vector using a for each loop to find the matching
   account. it will return the same Customer object with the matching account number*/
    private static Customer checkAccount(Vector <Customer> customersList) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the account number: ");
        int accountNumber = scan.nextInt();
        for (Customer customer:customersList) {
            if (accountNumber==customer.getAccount().getAccountNumber()) {
                System.out.println("Account found.");
                return customer;
            }
        }
        System.out.println("Account not found.");
        return null;
    }
    
    private static void printNames() {
        System.out.println("""
                           ******************************************************
                           *                Welcome to Our Bank                 * 
                           *    Student #1: Bashar Khalid Hamo, 442016709       * 
                           *    Student #2: Qusay Khalid Al-Sharif, 442002260   * 
                           ******************************************************
                           """);
    }
    
    //menu to be printed after each operation
    private static void printMenu() {
        System.out.println("""
                           Please select your choice or enter 8 to exit
                           ---------------------------------------------
                           1. Create a new customer account
                           2. Deposit an amount to an existing account
                           3. Withdraw an amount to an existing account
                           4. Check an existing account
                           5. Get a new loan for an existing account
                           6. Check a loan for an existing account
                           7. Pay for a loan for an existing account
                           8. Exit
                           ---------------------------------------------
                           """);
    }
}