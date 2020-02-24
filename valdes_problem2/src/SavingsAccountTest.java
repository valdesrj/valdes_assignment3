
// Test class to test class SavingsAccount. Instantiate two SavingsAccount
// objects, saver1 and saver2, with balances of $2000.00 and $3000.00,
// respectively. Set annualInterestRate to 4%, then calculate the monthly
// interest for each of 12 months and print the monthly balances for both
// savers. Next, set the annualInterestRate to 5%, calculate the next month’s
// interest and print the new balances for both savers.

public class SavingsAccountTest {
	public static void main(String[] args) {
		// create savings accounts
		SavingsAccount saver1 = new SavingsAccount(1, 2000.00);
		SavingsAccount saver2 = new SavingsAccount(2, 3000.00);
		
		// set the interest rate to 4%
		SavingsAccount.modifyInterestRate(0.04);
	
		// output the monthly balances for each saver
		System.out.printf("%s%n", "Opening Balances");
		System.out.printf("%s, %s%n", saver1, saver2);
		System.out.println("======================================================================================");
		System.out.printf("Interest rate set to %.2f%n", saver1.getAnnualInterestRate());
		for (int i = 0; i < 12; i++) {
			// calculate the monthly interest		
			// add the monthly interest to the savings balance
			saver1.setSavingsBalance(saver1.getSavingsBalance() + saver1.calculateMonthlyInterest());
			saver2.setSavingsBalance(saver2.getSavingsBalance() + saver2.calculateMonthlyInterest());
			System.out.printf("Month #%d: %s, %s%n", i+1, saver1, saver2);
		}
		
		SavingsAccount.modifyInterestRate(0.05);
		System.out.printf("%nIncrease the interest rate to %.2f%n", saver1.getAnnualInterestRate());
		System.out.println("======================================================================================");
		// set the interest rate to 5%
		saver1.setSavingsBalance(saver1.getSavingsBalance() + saver1.calculateMonthlyInterest());
		saver2.setSavingsBalance(saver2.getSavingsBalance() + saver2.calculateMonthlyInterest());
		System.out.printf("%s, %s%n", saver1, saver2);
	}

}
