package src;
interface ATMCard {

	void deposit(double amt) 
				  throws NegativeAmountException;

	void withdraw(double amt)
					throws NegativeAmountException,
						   InsufficientFundsException;

	void currentBalance();

}