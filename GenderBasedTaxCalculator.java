import java.util.Scanner;

public class GenderBasedTaxCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter gender (M/F): ");
        char gender = scanner.next().charAt(0);

        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();

        double taxRate;

        if (gender == 'M') {
            taxRate = (salary < 14000) ? 0.13 : 0.15;
        } else {
            taxRate = (salary < 15000) ? 0.12 : 0.14;
        }

        double taxAmount = salary * taxRate;
        double netSalary = salary - taxAmount;

        System.out.println("Tax Amount: " + taxAmount);
        System.out.println("Net Salary: " + netSalary);

        scanner.close();
    }
    }
