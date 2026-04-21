import java.util.Scanner;

class UC20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter number of bogie IDs: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] bogieIDs = new String[n];

        // Defensive check (Fail-Fast)
        if (n == 0) {
            throw new IllegalStateException("Cannot perform search: No bogies available in the train.");
        }

        // Input bogie IDs
        System.out.println("Enter bogie IDs:");
        for (int i = 0; i < n; i++) {
            bogieIDs[i] = sc.nextLine();
        }

        // Input search key
        System.out.print("Enter bogie ID to search: ");
        String key = sc.nextLine();

        // Simple Linear Search (can be any search logic)
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (bogieIDs[i].equals(key)) {
                System.out.println("Bogie ID found at position: " + i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Bogie ID not found.");
        }

        sc.close();
    }
}