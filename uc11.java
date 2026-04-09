import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class uc11 {

    public static void main(String[] args) {

        System.out.println("=== UC11: Validate Train ID & Cargo Code ===");

        Scanner sc = new Scanner(System.in);

        // Input from user
        System.out.print("Enter Train ID: ");
        String trainId = sc.nextLine();

        System.out.print("Enter Cargo Code: ");
        String cargoCode = sc.nextLine();

        // Define regex patterns
        String trainPatternStr = "TRN-\\d{4}";
        String cargoPatternStr = "PET-[A-Z]{2}";

        // Compile patterns
        Pattern trainPattern = Pattern.compile(trainPatternStr);
        Pattern cargoPattern = Pattern.compile(cargoPatternStr);

        // Create matchers
        Matcher trainMatcher = trainPattern.matcher(trainId);
        Matcher cargoMatcher = cargoPattern.matcher(cargoCode);

        // Validate inputs
        if (trainMatcher.matches()) {
            System.out.println("Train ID is VALID");
        } else {
            System.out.println("Train ID is INVALID");
        }

        if (cargoMatcher.matches()) {
            System.out.println("Cargo Code is VALID");
        } else {
            System.out.println("Cargo Code is INVALID");
        }

        System.out.println("\nProgram continues...");
        sc.close();
    }
}