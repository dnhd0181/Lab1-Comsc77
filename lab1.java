import java.util.Scanner;

public class lab1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter a number: ");
        String input = scanner.nextLine().trim();
        
        System.out.print("Is this a binary or decimal number? (Enter 'binary' or 'decimal'): ");
        String type = scanner.nextLine().trim().toLowerCase();

        // Validate input
        if (type.equals("binary")) {
            if (!isBinary(input)) {
                System.out.println("Invalid binary number!");
            } else {
                System.out.println("Valid binary number.");
            }
        } else if (type.equals("decimal")) {
            if (!isDecimal(input)) {
                System.out.println("Invalid decimal number!");
            } else {
                System.out.println("Valid decimal number.");
            }
        } else {
            System.out.println("Invalid input type! Please enter 'binary' or 'decimal'.");
        }
        
        scanner.close();
    }

    //Dang Doan
    private static boolean isBinary(String input) {
        for (char c : input.toCharArray()) {
            if (c != '0' && c != '1') {
                return false;
            }
        }
        return true;
    }

    //Dang Doan
    private static boolean isDecimal(String input) {
        for (char c : input.toCharArray()) {
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
