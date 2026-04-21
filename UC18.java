import java.util.Scanner;

class UC18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter number of bogie IDs: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] bogieIDs = new String[n];

        // Input bogie IDs
        System.out.println("Enter bogie IDs:");
        for (int i = 0; i < n; i++) {
            bogieIDs[i] = sc.nextLine();
        }

        // Input search key
        System.out.print("Enter bogie ID to search: ");
        String key = sc.nextLine();

        // Linear Search
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (bogieIDs[i].equals(key)) {
                found = true;
                System.out.println("Bogie ID found at position: " + i);
                break; // early termination
            }
        }

        // If not found
        if (!found) {
            System.out.println("Bogie ID not found.");
        }

        sc.close();
    }
}