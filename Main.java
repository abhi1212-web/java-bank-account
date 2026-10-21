import java.util.Scanner;

class BankAccount {
    private final String accountHolderName;
    private final long accountNumber;
    private final String accountType;
    private double accountBalance;

    BankAccount(String accountHolderName, long accountNumber,
                String accountType, double accountBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            accountBalance += amount;
            System.out.println("Amount Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > accountBalance) {
            System.out.println("Insufficient Balance");
        } else {
            accountBalance -= amount;
            System.out.println("Amount Withdrawn: " + amount);
        }
    }

    void balanceEnquiry() {
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Account Balance: " + accountBalance);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount("Ravi", 1001, "Savings", 10000);

        System.out.println("Initial Account Details:");
        account.balanceEnquiry();

        System.out.print("\nEnter deposit amount: ");
        double depositAmount = sc.nextDouble();
        account.deposit(depositAmount);

        System.out.print("\nEnter withdrawal amount: ");
        double withdrawAmount = sc.nextDouble();
        account.withdraw(withdrawAmount);

        System.out.println("\nFinal Account Details:");
        account.balanceEnquiry();
        sc.close();
    }
}
