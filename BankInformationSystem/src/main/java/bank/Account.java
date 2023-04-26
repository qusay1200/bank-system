package bank;

//methods for bank operations to be implemented
interface accountOperation {
    public void deposit(double amount);
    public void withdraw(double amount);
    public void getNewLoan();
    public void payLoan();
    public void checkLoanStatus();
}

public class Account implements accountOperation{
    //class Account data members
    private final int accountNumber = accountCounter;
    private static int accountCounter = 1000; //first account will have the number 1000
    private double balance;
    
    private Loan loan;
    private boolean hasLoan = false; //will be the condition to create a new loan
    
    //class Account constructor
    public Account() {
        accountCounter++; //will increment with every new customer made so that account numbers are unique
    }
    
    //returns account number 
    public int getAccountNumber() {
        return accountNumber;
    }
    
    //returns balance
    public double getBalance() {
        return balance;
    }
    
    //returns data member of type Loan
    public Loan getLoan() {
        return loan;
    }
    
    //returns whether this account currently has a loan or not
    public boolean isHasLoan() {
        return hasLoan;
    }
    
    //overriden interface method, instantiates object of type Loan, changes hasLoan to true
    @Override
    public void getNewLoan() {
        this.loan = new Loan();
        hasLoan = true;
    }
    
    /*overriden interface method to pay for loan, will not proceed if customer does 
      not have enough balance in his account, then it subtracts the monthly 
      payment from the account's balance and calls functions from class loan
     (explained in class Loan)*/
    @Override
    public void payLoan() {
        if (balance>=this.getLoan().getMonthlyPayment()) {
            balance = balance - this.getLoan().getMonthlyPayment();
            this.getLoan().incrementNumberOfPayments();
            this.getLoan().updatePaidAmount();
            this.getLoan().updateRemainingAmount();
            System.out.println("Loan payment down.");
        } else {
            System.out.println("Operation rejected, you don't have enough balance to pay.");
        }
    }
    
    /*overriden interface method that checks if the user has completed the payments
     by checking the remaining amount after each payment, if true then it will
     reset data members in class Loan to 0 so that the customer can get a new loan*/
    @Override
    public void checkLoanStatus() {
        if (this.getLoan().getReminingAmount()==0) {
            this.hasLoan = false;
            System.out.println("Congratulations! you have completed all loan payments, you can now get a new loan.");
            this.getLoan().resetLoanData();
        }
    }
    
    //overriden interface method, will not accept values less than or equal to 0
    @Override
    public void deposit(double amount) {
        if (amount>0.0) {
            balance = balance + amount;
            System.out.println("Amount deposited successfully.");
        } else System.out.println("Operation rejected, please enter a valid amount.");
    }
    
    //overriden interface method, will not accept values less than or equal to 0
    @Override
    public void withdraw(double amount) {
        if (amount>0.0 && amount<=balance) {
            balance = balance - amount;
            System.out.println("Amount withdrawn successfully.");
        } else System.out.println("Operation rejected, please enter a valid amount.");
    }
    
    //overriden toString method
    @Override
    public String toString() {
        return "Account Number: "+getAccountNumber()+", Balance: "+getBalance()+"sar";
    }
}
