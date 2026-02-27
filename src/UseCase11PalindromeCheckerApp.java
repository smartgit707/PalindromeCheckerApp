import java.util.*;

/**
 * =================================================================
 * SERVICE CLASS - PalindromeService
 * =================================================================
 * UC11: Object-Oriented Palindrome Service
 * Description: Encapsulates palindrome logic (Encapsulation).
 * =================================================================
 */
class PalindromeService {

    /**
     * Checks if a string is a palindrome.
     * @param input The string to check
     * @return true if palindrome, false otherwise
     */
    public boolean checkPalindrome(String input) {
        // Normalization logic from UC10 (included to maintain functionality)
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Hint Logic: Two-pointer approach
        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

/**
 * =================================================================
 * MAIN CLASS - UseCase11PalindromeCheckerApp
 * =================================================================
 */
public class UseCase11PalindromeCheckerApp {
    public static void main(String[] args) {
        String input = "A man a plan a canal Panama";

        // Creating an instance of the service class
        PalindromeService service = new PalindromeService();

        // Using the service to check the palindrome
        boolean isPalindrome = service.checkPalindrome(input);

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}