package src;
import java.util.Scanner;
import java.util.InputMismatchException;

class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		while(true){
			System.out.print("\nInsert Card: ");
			String cardName = scn.nextLine();
			
			try{
				//load and instantiate given class
				Class<?> cls = Class.forName(cardName);			
				Object obj = cls.newInstance();
			//	System.out.println(cardName + " class is loaded and instantiated");	

				ATMCard card = (ATMCard)obj;
				System.out.println("Card reading completed successfully");
				System.out.println("Start transactions");

					loop: while(true){
						System.out.println("\nChoose option: ");
						System.out.println(" 1. Deposit");
						System.out.println(" 2. Withdraw");
						System.out.println(" 3. Balance Enquiry");
						System.out.println(" 4. Exit");

						System.out.print("Enter option number: ");
						int option = scn.nextInt(); scn.nextLine();

						switch(option){
							case 1: {
									while(true){
										try{
											System.out.print("\nEnter amount to deposit: ");
											double amt = scn.nextDouble(); 	scn.nextLine();

											card.deposit(amt);
											System.out.println(amt + " deposited successfully");
											break;
										}catch(InputMismatchException e){
											System.out.println("Error: Enter only number");
											scn.nextLine();
										}catch(NegativeAmountException e){
											System.out.println("Error: "+e.getMessage());
										}
									}//while close
									break  ;
							}//case 1 close

							case 2:{
									while(true){
										try{
											System.out.print("\nEnter amout to withdraw: ");	
											double amt = scn.nextDouble(); scn.nextLine();
											
											card.withdraw(amt);
											System.out.println("Collect Your Cash");
											break;
										}catch(InputMismatchException e){
											System.out.println("Error: Enter only number");
											scn.nextLine();
										}catch(NegativeAmountException e){
											System.out.println("Error: "+e.getMessage());
										}catch(InsufficientFundsException e){
											System.out.println("Error: "+e.getMessage());
										}
									}//while close

								break  ;
							}//case 2 close

							case 3:{
								System.out.print("Current Balance: ");
								card.currentBalance();
								break  ;
							}
							case 4:{
								System.out.println(" \n******** Thank you :-), Visit Again ********");
								break  loop;
							}
							default:{
								System.out.println("Invalid option, choose correct option");
							}

						}//switch close
					
					}//while(true) close

				}//outer try close
				catch (ClassNotFoundException e){
					System.out.println(cardName + ".class file is not available");
				}catch (InstantiationException e){
					System.out.println(cardName + " class does not contain no-param constructor");
				}catch (IllegalAccessException e){
					System.out.println(cardName + " class does not contain visible no-param constructor");
				}catch (ClassCastException e){
					System.out.println("Invalid card");
				}
		
		}//while outer loop close
		
	}//main close
}//class close