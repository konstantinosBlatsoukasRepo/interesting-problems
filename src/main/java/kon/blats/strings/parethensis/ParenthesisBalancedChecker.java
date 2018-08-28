package kon.blats.strings.parethensis;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by kon on 27/8/2018.
 */
public class ParenthesisBalancedChecker {

    private static final Character left = Character.valueOf('(');

    public static void main(String[] args) {
        String input = "((())))";
        ParenthesisBalancedChecker balancedChecker = new ParenthesisBalancedChecker();
        System.out.println(balancedChecker.isBalanced(input));
    }

    private boolean isBalanced(String input) {
        char[] brackets = input.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < brackets.length; i++) {
            char currentChar = brackets[i];
            if (left.equals(currentChar)) {
                stack.push(currentChar);
            } else {
                try {
                    stack.pop();
                } catch (EmptyStackException e) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
