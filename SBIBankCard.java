package src;
public class SBIBankCard implements ATMCard{

	private double balance;

	public void deposit(double amt)
					throws NegativeAmountException{
		
		if(amt <= 0)
			throw new NegativeAmountException(
								"Donot pass -ve num or zero ");
		
		balance = balance + amt;
	}

	public void withdraw(double amt)
							throws NegativeAmountException,
										InsufficientFundsException{
		
		if(amt <= 0)
			throw new NegativeAmountException(
								"Do not pass -ve num or zero");	
		
		if(amt > balance)
			throw new InsufficientFundsException(
												"Insufficient Funds");
				
		balance = balance - amt;
	}

	public void currentBalance(){
		System.out.println(balance);
	}

}