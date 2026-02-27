import java.util.*;

/**
 * =================================================================
 * CLASS - UseCase10PalindromeCheckerApp
 * =================================================================
 * Consolidates all palindrome validation methods (UC1-UC10)
 * into a single executable class.
 * =================================================================
 */
public class UseCase10PalindromeCheckerApp {

    public static void main(String[] args) {
        // UC1: Welcome Message
        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version : 10.0");
        System.out.println("System initialized successfully.\n");

        String input = "A man a plan a canal Panama";

        // Execute different validation methods
        checkUC2("madam");
        checkUC3("madam");
        checkUC4("radar");
        checkUC5("noon");
        checkUC6("civic");
        checkUC7("refer");
        checkUC8("level");
        checkUC9("radar", 0, 4);
        checkUC10(input);
    }

    // UC2: Hardcoded Loop Method
    public static void checkUC2(String input) {
        boolean isPalindrome = true;
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println("[UC2] Input: " + input + " | Palindrome: " + isPalindrome);
    }

    // UC3: String Reverse Method
    public static void checkUC3(String input) {
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) reversed += input.charAt(i);
        System.out.println("[UC3] Original: " + input + " | Palindrome: " + input.equals(reversed));
    }

    // UC4: Character Array Two-Pointer Method
    public static void checkUC4(String input) {
        char[] chars = input.toCharArray();
        int start = 0, end = chars.length - 1;
        boolean isPalindrome = true;
        while (start < end) {
            if (chars[start++] != chars[end--]) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println("[UC4] Input: " + input + " | Palindrome: " + isPalindrome);
    }

    // UC5: Stack Based Method
    public static void checkUC5(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) stack.push(c);
        boolean isPalindrome = true;
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println("[UC5] Input: " + input + " | Palindrome: " + isPalindrome);
    }

    // UC6: Queue + Stack Method
    public static void checkUC6(String input) {
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            queue.add(c);
            stack.push(c);
        }
        boolean isPalindrome = true;
        while (!queue.isEmpty()) {
            if (!queue.remove().equals(stack.pop())) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println("[UC6] Input: " + input + " | Palindrome: " + isPalindrome);
    }

    // UC7: Deque Method
    public static void checkUC7(String input) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : input.toCharArray()) deque.addLast(c);
        boolean isPalindrome = true;
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println("[UC7] Input: " + input + " | Palindrome: " + isPalindrome);
    }

    // UC8: LinkedList Method
    public static boolean checkUC8(String input) {
        LinkedList<Character> list = new LinkedList<>();
        for (char c : input.toCharArray()) list.add(c);
        while (list.size() > 1) {
            if (list.removeFirst() != list.removeLast()) return false;
        }
        return true;
    }

    // UC9: Recursive Method
    public static boolean checkUC9(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return checkUC9(str, start + 1, end - 1);
    }

    // UC10: Normalized Method (Regex)
    public static void checkUC10(String input) {
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        boolean isPalindrome = true;
        for (int i = 0; i < normalized.length() / 2; i++) {
            if (normalized.charAt(i) != normalized.charAt(normalized.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println("[UC10] Input: " + input + " | Palindrome: " + isPalindrome);
    }
}