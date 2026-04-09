// Custom Exception Class
class InvalidCapacityException extends Exception {
    InvalidCapacityException(String message) {
        super(message);
    }
}

// Bogie class with validation
class Bogie {
    String name;
    int capacity;

    // Constructor with validation
    Bogie(String name, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Invalid capacity for " + name);
        }
        this.name = name;
        this.capacity = capacity;
    }

    public String toString() {
        return name + " (" + capacity + ")";
    }
}

public class uc14 {

    public static void main(String[] args) {

        System.out.println("=== UC14: Handle Invalid Bogie Capacity ===");

        try {
            // Valid bogie
            Bogie b1 = new Bogie("Sleeper", 72);
            System.out.println("Created: " + b1);

            // Invalid bogie (will throw exception)
            Bogie b2 = new Bogie("AC Chair", 0);
            System.out.println("Created: " + b2);

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nProgram continues safely...");
    }
}