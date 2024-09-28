import java.util.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets; // Import this for StandardCharsets
import java.io.*; // For input/output handling

class Itinerary {
    private List<String> destinations;
    private List<String> dates;
    private List<String> preferences;
    private double budget;

    public Itinerary() {
        this.destinations = new ArrayList<>();
        this.dates = new ArrayList<>();
        this.preferences = new ArrayList<>();
        this.budget = 0.0;
    }

    public void addDestination(String destination, String date) {
        destinations.add(destination);
        dates.add(date);
    }

    public void setPreferences(String preference) {
        preferences.add(preference);
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void displayItinerary() {
        System.out.println("\n--- Travel Itinerary ---");
        for (int i = 0; i < destinations.size(); i++) {
            System.out.println("Destination: " + destinations.get(i) + " on " + dates.get(i));
            // Call weather API here
            String weather = getWeather(destinations.get(i));
            System.out.println("Weather: " + weather);
            // Call map API here
            String mapLink = getMapLink(destinations.get(i));
            System.out.println("Map: " + mapLink);
        }
        System.out.println("Preferences: " + String.join(", ", preferences));
        System.out.println("Total Budget: $" + budget);
    }

    // Simulated weather API call
    private String getWeather(String destination) {
        // Placeholder: Implement API call to OpenWeatherMap
        return "Sunny, 25°C"; // Example output
    }

    // Simulated map API link generation
    private String getMapLink(String destination) {
        // Create Google Maps URL
        return "https://www.google.com/maps/search/?api=1&query=" + URLEncoder.encode(destination, StandardCharsets.UTF_8);
    }
}

public class TravelItineraryPlanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Itinerary itinerary = new Itinerary();
        String moreDestinations;

        do {
            System.out.print("Enter destination: ");
            String destination = scanner.nextLine();
            System.out.print("Enter date (e.g., YYYY-MM-DD): ");
            String date = scanner.nextLine();
            itinerary.addDestination(destination, date);

            System.out.print("Would you like to add another destination? (yes/no): ");
            moreDestinations = scanner.nextLine();
        } while (moreDestinations.equalsIgnoreCase("yes"));

        System.out.print("Enter any travel preferences (e.g., adventure, relaxation): ");
        String preference = scanner.nextLine();
        itinerary.setPreferences(preference);

        System.out.print("Enter total budget for the trip: ");
        double budget = scanner.nextDouble();
        itinerary.setBudget(budget);

        itinerary.displayItinerary();
        scanner.close();
    }
}