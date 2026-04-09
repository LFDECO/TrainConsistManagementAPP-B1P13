import java.util.*;
import java.util.stream.Collectors;

class Bogie {
    String name;
    int capacity;
    String type;

    Bogie(String name, int capacity, String type) {
        this.name = name;
        this.capacity = capacity;
        this.type = type;
    }

    public String toString() {
        return name + " (" + capacity + ")";
    }
}

public class uc9 {

    public static void main(String[] args) {

        System.out.println("=== UC9: Group Bogies by Type ===");

        // Create list of bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72, "Passenger"));
        bogies.add(new Bogie("AC Chair", 60, "Passenger"));
        bogies.add(new Bogie("First Class", 40, "Passenger"));
        bogies.add(new Bogie("Cargo", 0, "Freight"));
        bogies.add(new Bogie("Parcel", 0, "Freight"));

        // Group bogies by type
        Map<String, List<Bogie>> grouped =
                bogies.stream()
                      .collect(Collectors.groupingBy(b -> b.type));

        // Display grouped result
        System.out.println("\nGrouped Bogies:");
        for (Map.Entry<String, List<Bogie>> entry : grouped.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\nProgram continues...");
    }
}