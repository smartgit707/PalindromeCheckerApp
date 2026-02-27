import java.util.*;

/**
 * =================================================================
 * CLASS - UseCase13PalindromeCheckerApp
 * =================================================================
 * UC13: Performance Comparison
 * Description: Measures and compares execution time of strategies.
 * =================================================================
 */
public class UseCase13PalindromeCheckerApp {
    public static void main(String[] args) {
        String input = "Level";
        System.out.println("Input : " + input);

        // 1. Benchmark Stack Strategy
        long startStack = System.nanoTime();
        new StackStrategy().check(input);
        long endStack = System.nanoTime();
        System.out.println("Stack Strategy Time: " + (endStack - startStack) + " ns");

        // 2. Benchmark Deque Strategy
        long startDeque = System.nanoTime();
        new DequeStrategy().check(input);
        long endDeque = System.nanoTime();
        System.out.println("Deque Strategy Time: " + (endDeque - startDeque) + " ns");
    }
}

// Re-using Strategies for Comparison
interface PalindromeStrategy {
    boolean check(String input);
}

class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String input) {
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : normalized.toCharArray()) stack.push(c);
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) reversed.append(stack.pop());
        return normalized.equals(reversed.toString());
    }
}

class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String input) {
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : normalized.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }
}