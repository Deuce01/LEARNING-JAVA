import java.util.Scanner;

public class OrderOfMeritCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter marks scored in five subjects:");

        double totalMarks = 0;
        for (int i = 1; i <= 5; i++) {
            System.out.print("Subject " + i + " : ");
            double marks = scanner.nextDouble();
            totalMarks += marks;
        }

        double average = totalMarks / 5;

        if (average >= 75) {
            System.out.println("Distinction");
        } else if (average >= 65) {
            System.out.println("Credit");
        } else if (average >= 50) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

        scanner.close();
    }
}
