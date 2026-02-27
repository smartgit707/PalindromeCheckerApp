import java.util.LinkedList;

/**
 * =================================================================
 * MAIN CLASS - UseCase9PalindromeCheckerApp
 * =================================================================
 * Use Case 8: LinkedList Based Palindrome Checker
 * Use Case 9: Recursive Palindrome Checker
 * Use Case 10: Normalized Palindrome Validation
 * =================================================================
 */
public class UseCase9PalindromeCheckerApp {

    public static void main(String[] args) {
        String input = "A man a plan a canal Panama";

        // Normalization needed for UC8, UC9, and UC10 to be logically correct
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        System.out.println("Input : " + input);

        // ===============================
        // UC8 FEATURE - LINKEDLIST METHOD
        // ===============================
        System.out.println("\n===== UC8 : LinkedList Method =====");
        boolean isPalLL = checkLinkedList(normalized);
        System.out.println("Is Palindrome (LinkedList)? : " + isPalLL);

        // ===============================
        // UC9 FEATURE - RECURSIVE METHOD
        // ===============================
        System.out.println("\n===== UC9 : Recursive Method =====");
        boolean isPalRecursive = isPalindromeRecursive(normalized, 0, normalized.length() - 1);
        System.out.println("Is Palindrome (Recursive)? : " + isPalRecursive);

        // ===============================
        // UC10 FEATURE - NORMALIZED METHOD
        // ===============================
        System.out.println("\n===== UC10 : Normalized Method =====");
        boolean isPalNormalized = true;
        for (int i = 0; i < normalized.length() / 2; i++) {
            if (normalized.charAt(i) != normalized.charAt(normalized.length() - 1 - i)) {
                isPalNormalized = false;
                break;
            }
        }
        System.out.println("Is Palindrome (Normalized)? : " + isPalNormalized);
    }

    // --- UC8 Logic: LinkedList ---
    public static boolean checkLinkedList(String str) {
        LinkedList<Character> list = new LinkedList<>();
        for (char c : str.toCharArray()) list.add(c);
        while (list.size() > 1) {
            if (list.removeFirst() != list.removeLast()) return false;
        }
        return true;
    }

    // --- UC9 Logic: Recursive ---
    public static boolean isPalindromeRecursive(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return isPalindromeRecursive(str, start + 1, end - 1);
    }
}