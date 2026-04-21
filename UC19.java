import java.util.Scanner;
import java.util.Arrays;

class UC19 {
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

        // Ensure array is sorted (important precondition)
        Arrays.sort(bogieIDs);

        // Input search key
        System.out.print("Enter bogie ID to search: ");
        String key = sc.nextLine();

        // Binary Search
        int low = 0;
        int high = n - 1;
        boolean found = false;

        while (low <= high) {
            int mid = (low + high) / 2;

            int result = key.compareTo(bogieIDs[mid]);

            if (result == 0) {
                System.out.println("Bogie ID found at position: " + mid);
                found = true;
                break;
            } 
            else if (result > 0) {
                low = mid + 1; // search right half
            } 
            else {
                high = mid - 1; // search left half
            }
        }

        if (!found) {
            System.out.println("Bogie ID not found.");
        }

        sc.close();
    }
}