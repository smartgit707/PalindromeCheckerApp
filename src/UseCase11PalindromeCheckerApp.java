import java.util.*;

/**
 * =================================================================
 * CLASS - UseCase11PalindromeCheckerApp
 * =================================================================
 * Contains:
 * - UC11: PalindromeService (Encapsulation)
 * - UC12: Strategy Pattern (Polymorphism)
 * =================================================================
 */
public class UseCase11PalindromeCheckerApp {
    public static void main(String[] args) {

        // --- UC11: Encapsulated Service Call ---
        String input1 = "A man a plan a canal Panama";
        PalindromeService service = new PalindromeService();
        System.out.println("--- UC11: Encapsulated Service ---");
        System.out.println("Result: " + service.checkPalindrome(input1));

        // --- UC12: Strategy Pattern Implementation ---
        String input2 = "Level";
        PalindromeContext context = new PalindromeContext();

        System.out.println("\n--- UC12: Strategy Pattern ---");

        // Dynamic selection: Stack Strategy
        context.setStrategy(new StackStrategy());
        System.out.println("Stack Strategy Result: " + context.executeStrategy(input2));

        // Dynamic selection: Deque Strategy
        context.setStrategy(new DequeStrategy());
        System.out.println("Deque Strategy Result: " + context.executeStrategy(input2));
    }
}

// =================================================================
// UC11: ENCAPSULATION SERVICE
// =================================================================
class PalindromeService {
    public boolean checkPalindrome(String input) {
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int start = 0;
        int end = normalized.length() - 1;
        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}

// =================================================================
// UC12: STRATEGY PATTERN CLASSES
// =================================================================

// 1. Interface
interface PalindromeStrategy {
    boolean check(String input);
}

// 2. Concrete Strategy: Stack
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

// 3. Concrete Strategy: Deque
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

// 4. Context Class
class PalindromeContext {
    private PalindromeStrategy strategy;
    public void setStrategy(PalindromeStrategy strategy) { this.strategy = strategy; }
    public boolean executeStrategy(String input) { return strategy.check(input); }
}