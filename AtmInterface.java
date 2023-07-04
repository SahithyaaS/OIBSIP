import java.util.*;

class Account{
	String accountNo = "01234ABCD";
	int pin = 2468;
	float accountBalance = 57234.2f;
	int transactions = 0;
	String transacHistory = "";
	
	Scanner sc = new Scanner(System.in);
	
	public boolean login() {
		boolean isLogin = false;
		System.out.println("Enter Account Number");
		String UserAccNo = sc.nextLine();
		
		if(accountNo.equals(UserAccNo)) {
			System.out.println("Enter PIN");
			int userPin = sc.nextInt();
			if(pin == userPin) {
				isLogin = true;
			}
			else {
			    System.out.println("Incorrect PIN");
			    isLogin = false;
	    	}
		}
		else {
			System.out.println("Incorrect Account Number...");
			 isLogin = false;
		}
		return isLogin;
	}
	
	public void transacHistory(){
		if(transactions == 0) {
			System.out.println("No transactions.\n");
		}
		else {
			System.out.println(transacHistory);
		}
		
	}
	
	public void withdraw() {
		System.out.println("Enter amount to withdraw:");
		float amount = sc.nextFloat();
		
		if(accountBalance >= amount) {
			if(amount <= 10000) {
				accountBalance -= amount;
				transactions++;
				String str = amount + " Rs. Withdrawed.\n";
				transacHistory = transacHistory.concat(str);	
				System.out.println("Withdraw Successful.\n");
			}
			else {
				System.out.println("Limit is 10000.00.\n");
			}
		}
		else {
			System.out.println("Insufficient Balance.\n");
		}	
	}
	
	public void deposit() {
		System.out.println("Enter amount to deposit:");
		float amount = sc.nextFloat();
		
		if(amount <= 10000f) {
			accountBalance += amount;
			transactions++;
			String str = amount + " Rs. Deposited.\n";
			transacHistory = transacHistory.concat(str);
			System.out.println("Successfully Deposited.\n");
		}
		else {
			System.out.println("Limit is 10000.00.\n");
		}
	}
	
	public void transfer() {
		System.out.println("Enter Account Number of Receipent:");
		String AccNumberR = sc.next();
		
		System.out.println("Enter amount:");
		sc.nextLine();
		float amount = sc.nextFloat();
		
		if(accountBalance >= amount) {
			if(amount <= 15000f) {
				System.out.println("\nAmount transfered Successfully.\n");
				accountBalance -= amount;
				transactions++;
				String str = amount + " Rs. transfered to " + AccNumberR + "\n";
				transacHistory = transacHistory.concat(str);		
		    }
			else {
				System.out.println("Limit is 15000.00.\n");
			}
		}
		else {
			System.out.println("Insufficient Balance.\n");
		}
	}

	public void checkBalance() {
		System.out.println("Rs." + accountBalance + "\n");
	}

}

public class AtmInterface {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Account a = new Account();
		System.out.println("------------- WELCOME to ATM -------------");
		System.out.println("\nPlease Enter your card\n");
		
		boolean isValid = a.login();
		if(isValid) {
			boolean flag = false;
		    while(!flag) {
		    	System.out.println("Enter your choice");
				System.out.println("1.Transactions History\n2.Withdraw money \n3.Deposit money \n4.Transfer money\n5.Check Balance amount\n6.Exit\n");
				int choice = sc.nextInt();
				
				switch(choice){
					case 1:
						a.transacHistory();
						break;
					case 2:
						a.withdraw();
						break;
					case 3:
						a.deposit();
						break;
					case 4:
						a.transfer();
						break;
					case 5:
						a.checkBalance();
						break;
					case 6:
						flag = true;
						System.out.println("\nThankyou for visiting!!");
						break;
					default:
						System.out.println("Enter correct choice...");				
				}
			}
		}
		
	}
}
