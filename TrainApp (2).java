import java.util.ArrayList;
import java.util.List;

public class TrainApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Create ArrayList for passenger bogies
        List<String> passengerBogies = new ArrayList<>();

        // ADD bogies (Create)
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        // DISPLAY bogies (Read)
        System.out.println("\nAfter adding bogies:");
        System.out.println(passengerBogies);

        // REMOVE a bogie (Delete)
        passengerBogies.remove("AC Chair");
        System.out.println("\nAfter removing AC Chair:");
        System.out.println(passengerBogies);

        // CHECK existence (Search)
        System.out.println("\nChecking if Sleeper exists:");
        if (passengerBogies.contains("Sleeper")) {
            System.out.println("Sleeper bogie is present.");
        } else {
            System.out.println("Sleeper bogie is NOT present.");
        }

        // FINAL STATE
        System.out.println("\nFinal train consist:");
        System.out.println(passengerBogies);

        System.out.println("\nProgram continues...");
    }
}