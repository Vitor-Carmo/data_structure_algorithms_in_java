package Unidade_02;

import java.util.Stack;

public class Ex4 {
    public static void main(String[] args) {
        System.out.println(isParenthesesBalanced("(()())")); // true
        System.out.println(isParenthesesBalanced("(()()")); // false
        System.out.println(isParenthesesBalanced("())(")); // false
        System.out.println(isParenthesesBalanced("()((((((")); // false
        System.out.println(isParenthesesBalanced("()")); // true
    }

    public static boolean isParenthesesBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (Character character : expression.toCharArray()) {
            if (character == '(') {
                stack.push(character);
            } else if (character == ')') {
                if (stack.isEmpty()) {
                    return false;
                }

                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}