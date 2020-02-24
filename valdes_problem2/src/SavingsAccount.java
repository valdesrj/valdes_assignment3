
// class 
public class SavingsAccount {
    private static double annualInterestRate; // for all account holders
    private double savingsBalance; // amount the saver currently has on deposit
    private int saverID;
    
    // constructor
    public SavingsAccount(int saverID, double savingsBalance) {
    	if (savingsBalance < 0) {
    		throw new IllegalArgumentException ("Balance must be >= 0");
    	}
    	
    	this.savingsBalance = savingsBalance;
    	this.saverID = saverID;
    }
    
    // set the savings balance
    public void setSavingsBalance(double savingsBalance) {
    	if (savingsBalance < 0) {
    		throw new IllegalArgumentException ("Balance must be >= 0");
    	}
    	
    	this.savingsBalance = savingsBalance;
    }
    
    // modify the interest rate
    public static void modifyInterestRate(double interestRate) {
    	annualInterestRate = interestRate;
    }
    
    // calculate the monthly interest
    public double calculateMonthlyInterest() {
    	return getSavingsBalance() * getAnnualInterestRate() /  12.;
    }
    
    // return the ID
    public int getSaverID() {return saverID;}
    
    // return the savings balance
    public double getSavingsBalance() {
    	return savingsBalance;
    }
    
    // return the annual interest rate
    public double getAnnualInterestRate() {
    	return annualInterestRate;
    }
    
    @Override
    public String toString() {
    	return String.format("%s%d %s: $%,.2f", "Saver ", getSaverID(), "Current Balance", getSavingsBalance());
    }
    
    
    
    
}
