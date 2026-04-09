import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Bogie class (Custom Object)
class Bogie {
    String name;
    int capacity;

    // Constructor
    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    // toString() for easy printing
    public String toString() {
        return name + " (Capacity: " + capacity + ")";
    }
}

public class uc7 {

    public static void main(String[] args) {

        System.out.println("=== UC7: Sort Bogies by Capacity ===");

        // Create List of Bogie objects
        List<Bogie> bogies = new ArrayList<>();

        // Add bogies
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 40));

        System.out.println("\nBefore Sorting:");
        System.out.println(bogies);

        // Sort using Comparator (Lambda)
        bogies.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("\nAfter Sorting (by Capacity):");
        System.out.println(bogies);

        System.out.println("\nProgram continues...");
    }
}