import java.util.HashMap;
import java.util.Map;

public class uc6 {

    public static void main(String[] args) {

        System.out.println("=== UC6: Map Bogie to Capacity ===");

        // Create HashMap (Key: Bogie Name, Value: Capacity)
        Map<String, Integer> bogieCapacityMap = new HashMap<>();

        // Insert bogie-capacity pairs
        bogieCapacityMap.put("Sleeper", 72);
        bogieCapacityMap.put("AC Chair", 60);
        bogieCapacityMap.put("First Class", 40);

        // Display all entries using entrySet()
        System.out.println("\nBogie Capacity Details:");
        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\nProgram continues...");
    }
}