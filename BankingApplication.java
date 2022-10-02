import java.util.*;

class Details{
	String name,accno;
	long balance;
	Scanner sc = new Scanner(System.in);
	
	public void createAccount() {  
		System.out.print("Enter Name: ");  
        name = sc.next();  
		System.out.print("Enter Account No: ");  
        accno = sc.next();   
        System.out.print("Enter Balance: ");  
        balance = sc.nextLong();
        System.out.println(" ");  
          
    }  
	 public void AllAccount() {  
	        System.out.println("Name of account holder: " + name);  
	        System.out.println("Account no.: " + accno);  
	        System.out.println("Balance: " + balance);  
	    } 
	 public boolean ViewBalance(String num){
		 if (accno.equals(num)) {  
			 System.out.println("Balance: " + balance);
	            return (true);  
	        }  
	        return (false);  
	    } 
	 public void Deposit(long rs) {   
	        balance = balance + rs;  
	    } 
	 public void Withdraw(long rs) {   
	        if (balance >= rs) {  
	            balance = balance - rs;    
	        } else {  
	            System.out.println("Your balance is less " );  
	        }  
	    }  
	 public boolean find(String acc_no){
		 if (accno.equals(acc_no)) {   
	            return (true);  
	        }  
	        return (false);  
	    }  		 
 }
	 

public class BankingApplication {
	public static void main(String[] args) {
		  Scanner sc = new Scanner(System.in);  
		  System.out.print("Enter number of accounts to Register: ");  
	        int n = sc.nextInt();  
	        Details arr[] = new Details[n];  
	        for (int i = 0; i < arr.length; i++) {  
	            arr[i] = new Details();  
	            arr[i].createAccount();
	        }  
	        int ch;  
	        do {  
	            System.out.println("\n *Banking App*");  
	            System.out.println(" \n 1. View Balance\n 2. Deposit\n 3. Withdraw \n 4. Transfer Amount  \n 5. Exit ");  
	            System.out.println("Enter your choice: ");  
	            ch = sc.nextInt();  
	                switch (ch) {  
	                    case 1:  
	                    	System.out.print("Enter account no. you want to view Balance: ");  
	                        String ac_no = sc.next();  
	                        boolean found = false;  
	                        for (int i = 0; i < arr.length; i++) {  
	                            found = arr[i].ViewBalance(ac_no);  
	                            if (found) {  
	                                break;  
	                            }  
	                        }  
	                        if (!found) {  
	                            System.out.println("Account not found");  
	                        }   
	                        break;
	                    case 2:  
	                    	System.out.print("Enter Account no. : ");  
	                        ac_no = sc.next();
	                        System.out.print("Enter Amount : ");  
	                        long rs = sc.nextLong();
	                        found = false;  
	                        for (int i = 0; i < arr.length; i++) {  
	                            found = arr[i].find(ac_no);  
	                            if (found) {  
	                                arr[i].Deposit(rs);  
	                                break;  
	                            }  
	                        }  
	                        if (!found) {  
	                            System.out.println("Account not found");  
	                        }  
	                        break;    
	                    case 3:  
	                    	System.out.print("Enter Account No : ");  
	                        ac_no = sc.next();
	                        System.out.print("Enter Amount : ");  
	                        rs = sc.nextLong();
	                        found = false;  
	                        for (int i = 0; i < arr.length; i++) {  
	                            found = arr[i].find(ac_no);  
	                            if (found) {  
	                                arr[i].Withdraw(rs);  
	                                break;  
	                            }  
	                        }  
	                        if (!found) {  
	                            System.out.println("Account not found");  
	                        	}  
	                        break; 
	                    case 4:  
	                        System.out.print("Enter Account No : ");  
	                        ac_no = sc.next(); 
	                        System.out.print("Enter Account no to transfer : ");  
	                        String ac_no2 = sc.next(); 
	                        System.out.print("Enter Amount : ");  
	                        rs = sc.nextLong(); 
	                        found = false;  
	                        for (int i = 0; i < arr.length; i++) {  
                            found = arr[i].find(ac_no);  
	                            if (found) {  
	                                arr[i].Withdraw(rs);     
	                            }        
	                        }
	                        found=false;
	                        for (int i = 0; i < arr.length; i++) {  
	                            found = arr[i].find(ac_no2);  
		                            if (found) {  
		                                arr[i].Deposit(rs);  
		                                break;  
		                            }  
		                        }  
	                        if (!found) {  
	                            System.out.println("Account not found");  
	                        }  
	                        break;  
	                    case 5:  
	                        System.out.println("Thank You");  
	                        break;  
	                }  
	            }  
	            while (ch != 5);  	  
	        sc.close();
	}
}