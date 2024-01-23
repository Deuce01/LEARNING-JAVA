import java.util.Scanner;

public class NumberOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        System.out.print("Enter the third number: ");
        double num3 = scanner.nextDouble();

       
        double sum = num1 + num2 + num3;
        double product = num1 * num2 * num3;
        double average = sum / 3;

        
        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);
        System.out.println("Average: " + average);

        scanner.close();
    }
}
