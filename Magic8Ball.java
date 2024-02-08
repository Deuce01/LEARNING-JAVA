import java.util.Random;

public class Magic8Ball {
    public static void main(String[] args) {
        String[] responses = {
            "Yes", "No", "Maybe", "Ask again later", "Outlook not so good"
        };

        Random random = new Random();
        int index = random.nextInt(responses.length);
        System.out.println("Magic 8 Ball says: " + responses[index]);
    }
}
