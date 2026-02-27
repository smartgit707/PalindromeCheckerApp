import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * =================================================================
 * MAIN CLASS - UseCase7PalindromeCheckerApp
 * =================================================================
 * Use Case 7: Deque Based Optimized Palindrome Checker
 * Use Case 8: LinkedList Based Palindrome Checker
 * =================================================================
 */
public class UseCase7PalindromeCheckerApp {

    public static void main(String[] args) {

        // Define the input string
        String input = "refer";

        // ===============================
        // UC7 FEATURE - DEQUE METHOD
        // ===============================
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        boolean isPalindromeDeque = true;

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                isPalindromeDeque = false;
                break;
            }
        }

        System.out.println("===== UC7 : Deque Method =====");
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindromeDeque);


        // ===============================
        // UC8 FEATURE - LINKEDLIST METHOD
        // ===============================
        LinkedList<Character> list = new LinkedList<>();

        for (char c : input.toCharArray()) {
            list.add(c);
        }

        boolean isPalindromeLinkedList = true;

        while (list.size() > 1) {

            char first = list.removeFirst();
            char last = list.removeLast();

            if (first != last) {
                isPalindromeLinkedList = false;
                break;
            }
        }

        System.out.println("\n===== UC8 : LinkedList Method =====");
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindromeLinkedList);
    }
}