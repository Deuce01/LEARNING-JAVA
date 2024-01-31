import java.util.Scanner;

public class BankAccountSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your initial balance: ");
        double initialBalance = scanner.nextDouble();
        BankAccount account = new BankAccount(initialBalance);

        while (true) {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Current balance: " + account.getBalance());
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            System.out.println("Invalid amount to deposit.");
        } else {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        }
    }

    public void withdraw(double amount) {
        if (amount < 0 || amount > balance) {
            System.out.println("Invalid amount to withdraw.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        }
    }

    public double getBalance() {
        return balance;
    }
}
