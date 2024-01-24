import java.util.Scanner;

public class SpeedFineCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter vehicle speed: ");
        int vehicleSpeed = scanner.nextInt();

        System.out.print("Enter speed limit: ");
        int speedLimit = scanner.nextInt();

        int excessSpeed = vehicleSpeed - speedLimit;

        if (excessSpeed < 30) {
            System.out.println("Fine: Kshs. 2500");
        } else {
            System.out.println("Fine: Kshs. 4000");
        }

        System.out.println("Vehicle Speed: " + vehicleSpeed);
        System.out.println("Speed Limit: " + speedLimit);
        System.out.println("Excess Speed: " + excessSpeed);

        scanner.close();
    }
          }
