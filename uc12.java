import java.util.*;

// Goods Bogie class
class GoodsBogie {
    String type;   // e.g., Cylindrical, Box
    String cargo;  // e.g., Petroleum, Coal

    GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String toString() {
        return type + " (" + cargo + ")";
    }
}

public class uc12 {

    public static void main(String[] args) {

        System.out.println("=== UC12: Safety Compliance Check ===");

        // Create list of goods bogies
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Box", "Coal"));
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));

        System.out.println("\nGoods Bogies:");
        System.out.println(bogies);

        // Safety rule using allMatch()
        boolean isSafe = bogies.stream()
                .allMatch(b -> 
                    !b.type.equals("Cylindrical") || 
                     b.cargo.equals("Petroleum")
                );

        // Display result
        if (isSafe) {
            System.out.println("\nTrain is SAFETY COMPLIANT ✅");
        } else {
            System.out.println("\nTrain is NOT SAFE ❌");
        }

        System.out.println("\nProgram continues...");
    }
}