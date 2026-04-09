import java.util.LinkedHashSet;
import java.util.Set;

public class uc5 {

    public static void main(String[] args) {

        System.out.println("=== UC5: Preserve Insertion Order of Bogies ===");

        // Create LinkedHashSet for train formation
        Set<String> trainFormation = new LinkedHashSet<>();

        // Add bogies
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        // Attempt to add duplicate
        trainFormation.add("Sleeper"); // Duplicate (ignored)

        // Display final formation
        System.out.println("\nFinal Train Formation:");
        System.out.println(trainFormation);

        System.out.println("\nProgram continues...");
    }
}