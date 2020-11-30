import java.util.Scanner;
import java.util.*;
import java.lang.*;

interface Bank {
   	void create_account();
    void deposit(double amount);
    void withdraw(double amount) throws InsuffiecientBalanceException;
    double getBalance();
    double getAnnualInterest();
}

class SBI implements Bank{
	private int bankId;
    private String branch;
    private String location;
    private double intRate;
    private double totalAmount;

    public void create_account(){System.out.println("Account Created Sucessfully!!");};

    public SBI() {
        intRate = 4.5;
    }

    public void setBankID(int id) {
        bankId = id;
    }

    public int getBankId() {
        return bankId;
    }

    public String getBankName() {
        return "SBI";
    }

    public void deposit(double amount) {
        totalAmount += amount;
    }

    public void withdraw(double amount) throws InsuffiecientBalanceException {
        if (amount > totalAmount) {
            throw new InsuffiecientBalanceException("Insufficient Balance!! Deposit required!!");
        } else {
            totalAmount -= amount;
        }
    } 

    public double getBalance() {
        return totalAmount;
    }

    public double getAnnualInterest() {
        return intRate;
    }
}

class HDFC implements Bank {
    private int bankId;
    private String branch;
    private String location;
    private double intRate;
    private double totalAmount;

    public void create_account(){System.out.println("Account Created Sucessfully!!");};

    public HDFC() {
        intRate = 5.5;
    }

    public void setBankID(int id) {
        bankId = id;
    }

    public int getBankId() {
        return bankId;
    }

    public String getBankName() {
        return "HDFC";
    }


    public void deposit(double amount) {
        totalAmount += amount;
    }

    public void withdraw(double amount) throws InsuffiecientBalanceException {
        if (amount > totalAmount) {
            throw new InsuffiecientBalanceException("Insufficient Balance!! Deposit required!!");
        } else {
            totalAmount -= amount;
        }
    } 
    
    public double getBalance() {
        return totalAmount;
    }

    public double getAnnualInterest() {
        return intRate;
    }
}

class ICICI implements Bank {
    private int bankId;
    private String branch;
    private String location;
    private double intRate;
    private double totalAmount;

    public void create_account(){System.out.println("Account Created Sucessfully!!");};

    public ICICI() {
        intRate = 6.5;
    }

    public void setBankID(int id) {
        bankId = id;
    }

    public int getBankId() {
        return bankId;
    }

    public String getBankName() {
        return "ICICI";
    }


    public void deposit(double amount) {
        totalAmount += amount;
    }

    public void withdraw(double amount) throws InsuffiecientBalanceException {
        if (amount > totalAmount) {
            throw new InsuffiecientBalanceException("Insufficient Balance!! Deposit required");
        } else {
            totalAmount -= amount;
        }
    } 
    
    public double getBalance() {
        return totalAmount;
    }

    public double getAnnualInterest() {
        return intRate;
    }
}

class InsuffiecientBalanceException extends Exception {
    
    String message;
    
    public InsuffiecientBalanceException(String message) {
        super(message);
        this.message = message;    
    }
    public String getMessage() {
        return message;
    }
}

class Person extends HDFC {
    private int personID;
    private String name;
    private int accountNumber;
    private String typeOfAccount;
    private String email;
    private String bankName;

    Person(int pId, String pName, int accountNo, String accountType, String pEmailid, String pBankName) {
       
        personID = pId;
        name = pName;
        name = name.substring(0,1).toUpperCase()+name.substring(1).toLowerCase();
        accountNumber = accountNo;
        typeOfAccount = accountType;
        email = pEmailid;
        bankName = pBankName;
        if (bankName == "SBI") {
            setBankID(1);
        } else if(bankName == "HDFC") {
            setBankID(2);
        }else {
            setBankID(3);
        }
    }

    public int getPersonId() {
        return personID;
    }

    public String getName() {
        return name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void accountDetails() {
        System.out.println("Person id : " + getPersonId());
        System.out.println("Person name : " + getName());
        System.out.println("Bank name : " + getBankName());
        System.out.println("Balance : " + getBalance());
        System.out.println("Annual Interest : " + getAnnualInterest());
    }
}


public class BankMain { 
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of records you want to enter : ");
        int n = scn.nextInt();
        
        Person personWithMaxAmount = null;
        double maxAmount = 0;

        for (int i=1; i<=n; i++) {
            System.out.println("Enter Person id : ");
            int pId = scn.nextInt();
            System.out.println("Enter Person name : ");
            scn.nextLine();
            String pName = scn.nextLine();
            System.out.println("Enter Person email : ");
            String email = scn.nextLine();
            System.out.println("Enter your type of account : ");
            String typeOfAccount = scn.nextLine();
            System.out.println("Enter Person account number : ");
            int accountNumber = scn.nextInt();
            String bankName = scn.nextLine();    

            Person p = new Person(pId, pName, accountNumber, typeOfAccount, email, bankName);

            int ch;
            do {

                System.out.println("\nMain Menu\n1.Deposit\n2.Withdraw\n3.Check Balance\n4.Print Account Details\n5.Exit");
                System.out.println("Your choice : "); 
                ch = scn.nextInt();

                switch(ch) {
                    case 1:
                        System.out.println("Enter amount to deposit : ");
                        double amount = scn.nextDouble();
                        p.deposit(amount);
                        break;

                    case 2:
                        System.out.println("Enter amount to withdraw : ");
                        double money = scn.nextDouble();  
                        try {
                           p.withdraw(money); 
                        } catch(InsuffiecientBalanceException e) {
                            System.out.println(e.getMessage());
                        }
                        
                        break;

                    case 3:
                        System.out.println("Balance : " + p.getBalance());
                        break;

                    case 4:
                        p.accountDetails();
                        break;

                    case 5:
                        System.out.println("\nHAVE A NICE DAY!!");
                        break;

                }
                
                maxAmount = Math.max(maxAmount,p.getBalance());
                    personWithMaxAmount = p;

            } while (ch != 5);            
        }
        
        System.out.println("Person with maximum amount : " + personWithMaxAmount.getName());
    }
}