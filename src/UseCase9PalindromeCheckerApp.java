import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class UseCase9PalindromeCheckerApp {

    public static void main(String[] args) {
        String input = "radar";

        // --- UC7: Deque Method ---
        System.out.println("===== UC7 : Deque Method =====");
        boolean isPalDeque = checkDeque(input);
        System.out.println("Input : " + input + " | Palindrome: " + isPalDeque);

        // --- UC8: LinkedList Method ---
        System.out.println("\n===== UC8 : LinkedList Method =====");
        boolean isPalLL = checkLinkedList(input);
        System.out.println("Input : " + input + " | Palindrome: " + isPalLL);

        // --- UC9: Recursive Method (NEW) ---
        System.out.println("\n===== UC9 : Recursive Method =====");
        boolean isPalRecursive = isPalindromeRecursive(input, 0, input.length() - 1);
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalRecursive);
    }

    // UC9 Logic: Recursion
    public static boolean isPalindromeRecursive(String str, int start, int end) {
        // Base Case: If there's only one character or none left
        if (start >= end) {
            return true;
        }
        // Check if characters at start and end match
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        // Recursive Call: Move inward
        return isPalindromeRecursive(str, start + 1, end - 1);
    }

    // Existing UC8 Logic
    public static boolean checkLinkedList(String input) {
        LinkedList<Character> list = new LinkedList<>();
        for (char c : input.toCharArray()) list.add(c);
        while (list.size() > 1) {
            if (list.removeFirst() != list.removeLast()) return false;
        }
        return true;
    }

    // Existing UC7 Logic
    public static boolean checkDeque(String input) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : input.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        }
        return true;
    }
}