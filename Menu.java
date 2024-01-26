import java.util.Scanner;

public class BeerMenuIfElse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Beer Menu:");
        System.out.println("1. Brand A - $5.00");
        System.out.println("2. Brand B - $4.50");
        System.out.println("3. Brand C - $6.00");
        System.out.println("4. Brand D - $3.75");

        System.out.print("Enter your choice (1-4): ");
        int choice = scanner.nextInt();

        if (choice >= 1 && choice <= 4) {
            System.out.print("Enter the number of bottles: ");
            int quantity = scanner.nextInt();

            double cost = 0;

            if (choice == 1) {
                cost = quantity * 5.00;
            } else if (choice == 2) {
                cost = quantity * 4.50;
            } else if (choice == 3) {
                cost = quantity * 6.00;
            } else if (choice == 4) {
                cost = quantity * 3.75;
            }

            System.out.println("Total cost: $" + cost);
        } else {
            System.out.println("Error: Invalid choice. Please enter a number between 1 and 4.");
        }

        scanner.close();
    }
              }
