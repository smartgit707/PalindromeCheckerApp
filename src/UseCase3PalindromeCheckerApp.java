/**
 * =================================================================
 * MAIN CLASS - UseCase3PalindromeCheckerApp
 * =================================================================
 * Use Case 3: Reverse String Based Palindrome Check
 * * Description:
 * This class checks whether a string is a palindrome
 * by reversing the string and comparing it with
 * the original value.
 * * At this stage, the application:
 * - Iterates the string in reverse order
 * - Builds a reversed version
 * - Compares original and reversed strings
 * - Displays the validation result
 * * This introduces transformation-based validation.
 * * @author Developer
 * @version 3.0
 */
public class UseCase3PalindromeCheckerApp {

    /**
     * Application entry point for UC3.
     * * @param args Command-line arguments
     */
    public static void main(String[] args) {
        String input = "madam";
        String reversed = "";

        // Hint: Iterate from the last character to the first
        for (int i = input.length() - 1; i >= 0; i--) {
            // Building reversed string using concatenation
            reversed += input.charAt(i);
        }

        // Compare content using equals() method
        boolean isPalindrome = input.equals(reversed);

        // Output matching the required terminal format
        System.out.println("Original String: " + input);
        System.out.println("Reversed String: " + reversed);
        System.out.println("Is it a Palindrome? : " + isPalindrome);
    }
}