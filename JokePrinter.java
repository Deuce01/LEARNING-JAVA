import java.util.Random;

public class JokePrinter {
    public static void main(String[] args) {
        String[] jokes = {
            "Why don't scientists trust atoms? Because they make up everything!",
            "Parallel lines have so much in common. It’s a shame they’ll never meet.",
            "I'm reading a book on anti-gravity. It's impossible to put down!",
            "Why did the scarecrow win an award? Because he was outstanding in his field!",
            "I told my wife she was drawing her eyebrows too high. She looked surprised.",
        };
        
        Random random = new Random();
        int index = random.nextInt(jokes.length);
        System.out.println(jokes[index]);
    }
}
