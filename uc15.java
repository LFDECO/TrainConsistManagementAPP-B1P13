// Custom Runtime Exception
class CargoSafetyException extends RuntimeException {
    CargoSafetyException(String message) {
        super(message);
    }
}

// Goods Bogie class
class GoodsBogie {
    String shape;   // Cylindrical / Rectangular
    String cargo;

    GoodsBogie(String shape) {
        this.shape = shape;
    }

    // Method to assign cargo safely
    void assignCargo(String cargo) {
        try {
            // Validation rule
            if (shape.equals("Rectangular") && cargo.equals("Petroleum")) {
                throw new CargoSafetyException("Unsafe: Petroleum cannot be stored in Rectangular bogie");
            }

            // Safe assignment
            this.cargo = cargo;
            System.out.println("Cargo assigned successfully: " + cargo);

        } catch (CargoSafetyException e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println("Cargo assignment attempt completed.\n");
        }
    }

    public String toString() {
        return shape + " (" + cargo + ")";
    }
}

public class uc15 {

    public static void main(String[] args) {

        System.out.println("=== UC15: Safe Cargo Assignment ===");

        // Create bogies
        GoodsBogie b1 = new GoodsBogie("Cylindrical");
        GoodsBogie b2 = new GoodsBogie("Rectangular");

        // Safe case
        b1.assignCargo("Petroleum");

        // Unsafe case
        b2.assignCargo("Petroleum");

        System.out.println("Program continues safely...");
    }
}