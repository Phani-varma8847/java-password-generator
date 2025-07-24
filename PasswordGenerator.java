import java.util.*;

public class PasswordGenerator {

    public static String generatePassword(int length, boolean useUpper, boolean useNumbers, boolean useSymbols) {
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*()-_=+[]{};:,.<>?";

        StringBuilder charPool = new StringBuilder(lower);
        if (useUpper) charPool.append(upper);
        if (useNumbers) charPool.append(numbers);
        if (useSymbols) charPool.append(symbols);

        if (charPool.length() == 0) {
            return "Please select at least one character set!";
        }

        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(charPool.length());
            password.append(charPool.charAt(index));
        }

        return password.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🔐 Random Password Generator");
        System.out.print("Enter desired password length: ");
        int length = scanner.nextInt();

        System.out.print("Include uppercase letters? (true/false): ");
        boolean useUpper = scanner.nextBoolean();

        System.out.print("Include numbers? (true/false): ");
        boolean useNumbers = scanner.nextBoolean();

        System.out.print("Include symbols? (true/false): ");
        boolean useSymbols = scanner.nextBoolean();

        String password = generatePassword(length, useUpper, useNumbers, useSymbols);
        System.out.println("\n✅ Generated Password: " + password);
    }
}
