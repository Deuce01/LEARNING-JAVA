import java.util.HashMap;
import java.util.Scanner;

public class WeatherForecast {
    public static void main(String[] args) {
        // Predefined list of cities and their weather conditions
        HashMap<String, String> weatherMap = new HashMap<>();
        weatherMap.put("New York", "Sunny");
        weatherMap.put("Los Angeles", "Cloudy");
        weatherMap.put("London", "Rainy");
        weatherMap.put("Paris", "Partly Cloudy");
        weatherMap.put("Tokyo", "Windy");

        // Getting user input for the city
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the city name: ");
        String city = scanner.nextLine();

        // Checking if the city exists in the weather map
        if (weatherMap.containsKey(city)) {
            String weather = weatherMap.get(city);
            System.out.println("The weather in " + city + " is " + weather + ".");
        } else {
            System.out.println("Sorry, the weather for " + city + " is not available.");
        }
    }
}
