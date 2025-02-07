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

    // Thi Huynh
    public static double binaryToDecimal(String binary) {
        String[] parts = binary.split("\\."); // Split by decimal point
        String integerPart = parts[0];
        String fractionalPart = parts.length > 1 ? parts[1] : "";

        double decimal = 0;

        // Convert integer part
        for (int i = 0; i < integerPart.length(); i++) {
            int integerPartPosition = integerPart.length() - i - 1;
            decimal += Character.getNumericValue(integerPart.charAt(i)) * Math.pow(2, integerPartPosition);
        }

        // Convert fractional part
        for (int i = 0; i < fractionalPart.length(); i++) {
            int fractionalPartPosition = - i - 1;
            decimal += Character.getNumericValue(fractionalPart.charAt(i)) * Math.pow(2, fractionalPartPosition);
        }

        return decimal;
    }

    // Thi Huynh
    public static String decimalToHexadecimal(double decimal) {
        int integerPart = (int) Math.floor(decimal);
        double fractionalPart = decimal - integerPart;

        String hexadecimal = "";

        // Convert the integer part
        while (integerPart > 0) {
            int digit = integerPart % 16;
            hexadecimal = (digit < 10 ? digit : (char) (55 + digit)) + hexadecimal;
            integerPart /= 16;
        }

        if (hexadecimal.isEmpty()) {
            hexadecimal = "0"; // If no integer part, assign "0"
        }

        if (fractionalPart > 0) {
            hexadecimal += ".";
            // Convert the fractional part
            while (fractionalPart > 0) {
                fractionalPart *= 16;
                int digit = (int) Math.floor(fractionalPart);
                hexadecimal += (digit < 10 ? digit : (char) (55 + digit));
                fractionalPart -= digit;
                if (hexadecimal.length() > 10) break; // Limit the precision to avoid infinite loops
            }
        }

        return hexadecimal;
    }
}
   // Huy Nguyen

   // Convert decimal to octal using division method
    public static String decimalToOctal(int n) {
        if (n == 0) return "0";
        StringBuilder octal = new StringBuilder();
        while (n > 0) {
            octal.insert(0, n % 8);
            n /= 8;
        }
        return octal.toString();
    }
