package convert_InfixExpressionToPrefix;

import java.util.Stack;

public class InfixToPrefix {

    // Function to check if a given character is an operator
    private static boolean isOperator(char c) {
        return (!Character.isLetterOrDigit(c));
    }

    // Function to check the precedence of operators
    private static int getPrecedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // Function to reverse a string
    private static String reverse(String exp) {
        char[] chars = exp.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l < r) {
            // Swap the characters
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
        return new String(chars);
    }

    // Function to convert infix to prefix expression
    public static String infixToPrefix(String exp) {
        // Step 1: Reverse the infix expression
        exp = reverse(exp);

        // Step 2: Replace '(' with ')' and vice versa
        char[] chars = exp.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                chars[i] = ')';
                i++;
            } else if (chars[i] == ')') {
                chars[i] = '(';
                i++;
            }
        }

        // Step 3: Get postfix expression of the modified expression
        String postfix = infixToPostfix(new String(chars));

        // Step 4: Reverse the postfix expression
        return reverse(postfix);
    }

    // Function to convert infix to postfix expression
    private static String infixToPostfix(String exp) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : exp.toCharArray()) {
            // If character is an operand, add it to output
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            }
            // If character is '(', push it to stack
            else if (c == '(') {
                stack.push(c);
            }
            // If character is ')', pop and output from the stack
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            }
            // An operator is encountered
            else {
                while (!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Pop all the operators from the stack
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String infix = "A+B*(C^D-E)^(F+G*H)-I";
        System.out.println("Infix Expression: " + infix);
        System.out.println("Prefix Expression: " + infixToPrefix(infix));
    }
}
