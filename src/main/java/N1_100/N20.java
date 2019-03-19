package N1_100;

import java.util.Stack;

/**
 * @author Yasin Shaw
 * @version v1.0
 */
public class N20 {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (stack.empty() || !isPair(stack.peek(), chars[i])) {
                stack.push(chars[i]);
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    private boolean isPair(char a, char b) {
        return (a == '(' && b == ')') ||
                (a == '[' && b == ']') ||
                (a == '{' && b == '}');
    }
}
