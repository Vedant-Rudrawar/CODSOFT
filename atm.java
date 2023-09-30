import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance. Withdrawal failed.");
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void displayOptions() {
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    public void performOperation(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                System.out.println("Your balance is: $" + bankAccount.getBalance());
                break;

            case 2:
                System.out.print("Enter the amount to deposit: $");
                double depositAmount = scanner.nextDouble();
                bankAccount.deposit(depositAmount);
                System.out.println("Deposit successful.");
                break;

            case 3:
                System.out.print("Enter the amount to withdraw: $");
                double withdrawAmount = scanner.nextDouble();
                if (bankAccount.withdraw(withdrawAmount)) {
                    System.out.println("Withdrawal successful.");
                }
                break;

            case 4:
                System.out.println("Thank you for using the ATM.");
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
}


