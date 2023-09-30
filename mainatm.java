public class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0); // Initial balance is $1000
        ATM atm = new ATM(userAccount);
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        while (choice != 4) {
            atm.displayOptions();
            choice = scanner.nextInt();
            atm.performOperation(choice, scanner);
        }

        scanner.close();
    }
}
