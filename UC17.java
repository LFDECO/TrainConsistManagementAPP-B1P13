import java.util.Scanner;
import java.util.Arrays;

class UC17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter number of bogie types: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume leftover newline

        String[] bogies = new String[n];

        // Input bogie names
        System.out.println("Enter bogie type names:");
        for (int i = 0; i < n; i++) {
            bogies[i] = sc.nextLine();
        }

        // Sorting using built-in method
        Arrays.sort(bogies);

        // Display sorted result
        System.out.println("Sorted bogie type names:");
        System.out.println(Arrays.toString(bogies));

        sc.close();
    }
}