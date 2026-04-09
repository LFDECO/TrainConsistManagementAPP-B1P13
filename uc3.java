import java.util.HashSet;
import java.util.Set;

public class uc3 {

    public static void main(String[] args) {

        System.out.println("=== UC3: Track Unique Bogie IDs ===");

        // Create a HashSet to store unique bogie IDs
        Set<String> bogieIDs = new HashSet<>();

        // Adding bogie IDs
        bogieIDs.add("B101");
        bogieIDs.add("B102");
        bogieIDs.add("B103");
        bogieIDs.add("B101"); // Duplicate
        bogieIDs.add("B102"); // Duplicate

        System.out.println("\nAfter adding bogie IDs (duplicates attempted):");
        System.out.println(bogieIDs);

        // Display unique bogie IDs
        System.out.println("\nFinal Unique Bogie IDs:");
        for (String id : bogieIDs) {
            System.out.println(id);
        }

        System.out.println("\nProgram continues...");
    }
}