package bank;

import java.util.Scanner;

public class Loan {
    //class Loan data members
    private double loanAmount, annualInterestRate, remainingAmount; //loanAmount: original loan amount to be deposited to account 
                                                                    //remainingAmount: initialized in constructor to equal the total amount
    private double totalPayableAmount; //after calculating interest
    private final double monthlyPayment; //when multiplied with number of payments, it will give us the paid amount
    private int numberOfMonths;
    private int numberOfPayments = 0; //to keep track of paid amount
    private double paidAmount = 0;
    
    Scanner scan = new Scanner(System.in); //for setters
    
    //class Loan constructor
    public Loan() {
        addInfo();
        totalPayableAmount = loanAmount + getTotalInterestRate(); //formula
        monthlyPayment = totalPayableAmount / numberOfMonths; //formula
        remainingAmount = totalPayableAmount; //total deserved amount
    }
    
    //returns monthly payment (calculated in constructor)
    public double getMonthlyPayment() {
        return monthlyPayment;
    }
    
    //returns loan amount to be deposited in account
    public double getLoanAmount() {
        return loanAmount;
    }
    
    //will not allow user to enter a loan amount less than or equal to zero
    public void setLoanAmount() {
        while (true) {
            System.out.println("Please enter the loan amount: ");
            double input = scan.nextDouble();
            if (input>0.0) {
                loanAmount = input;
                remainingAmount = loanAmount;
                break;
            } else {
                System.out.println("Operation rejected, please enter a valid amount.");
            }
        }
    }
    
    //will not allow user to enter an interst rate less than zero
    public void setAnnualInterestRate() {
        while (true) {
            System.out.println("Please enter the annual interest rate: ");
            double input = scan.nextDouble();
            if (input>=0.0) {
                annualInterestRate = input;
                break;
            } else {
                System.out.println("Operation rejected, please enter a valid interest rate.");
            }
        }
    }
    
    //returns remaining amount
    public double getReminingAmount() {
        return remainingAmount;
    }
    
    //will not allow user to enter a number of months less than or equal to zero
    public void setNumberOfMonths() {
        while (true) {
            System.out.println("Please enter the number of months: ");
            int input = scan.nextInt();
            if (input>0) {
                this.numberOfMonths = input;
                break;
            } else {
                System.out.println("Operation rejected, please enter a valid number of months.");
            }
        }
    }
    
    //calculates interest and returns it
    private double getTotalInterestRate() {
        double totalInterest = loanAmount * (annualInterestRate/100);
        return totalInterest;
    }
    
    //called from Account to update remaining deserved amount
    public void updateRemainingAmount() {
        remainingAmount = totalPayableAmount - paidAmount;
    }
    
    //will increment with each payment down
    public void incrementNumberOfPayments() {
        numberOfPayments++;
    }
    
    //will give us paid amount to keep track of how much the customer has paid for loan
    public void updatePaidAmount() {
        paidAmount = monthlyPayment * numberOfPayments;
    }
    
    //after payments are done, will reset data members so that the customer can get a new loan
    public void resetLoanData() {
        loanAmount = 0;
        annualInterestRate = 0;
        numberOfMonths = 0;
        totalPayableAmount = 0;
        numberOfPayments = 0;
        paidAmount = 0;
        remainingAmount = 0;
    }
    
    //gathers all setters to call in constructor once
    private void addInfo() {
        setLoanAmount();
        setAnnualInterestRate();
        setNumberOfMonths();
    }
    
    //overriden toString method
    @Override
    public String toString() {
        return "Total deserved amount: "+totalPayableAmount+"sar"+", Loan number of months: "+getMonthlyPayment()+"sar"+", Loan's interest rate: "+annualInterestRate+
                "%"+"\nRemaining amount: "+remainingAmount+"sar"+", Paid amount: "+paidAmount+"sar"+", Number of payments down: "+numberOfPayments;
    }
}
