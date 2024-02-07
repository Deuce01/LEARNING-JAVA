import java.security.SecureRandom;

public class RandomPasswordGenerator {
    public static void main(String[] args) {
        int length = 10; // Length of the password
        System.out.println(generatePassword(length));
    }

    public static String generatePassword(int length) {
        String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(symbols.length());
            sb.append(symbols.charAt(randomIndex));
        }
        return sb.toString();
    }
}
