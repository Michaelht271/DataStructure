package stack.linklist;

public class PostfixEvaluator {
    public int evaluate(String expression) {
        LinkedListStack stack = new LinkedListStack();
        for (char ch : expression.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.push(Character.getNumericValue(ch));
            } else {
                int val2 = stack.pop();
                int val1 = stack.pop();
                switch (ch) {
                    case '+':
                        stack.push(val1 + val2);
                        break;
                    case '-':
                        stack.push(val1 - val2);
                        break;
                    case '*':
                        stack.push(val1 * val2);
                        break;
                    case '/':
                        stack.push(val1 / val2);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        PostfixEvaluator evaluator = new PostfixEvaluator();
        String expression = "231*+9-";
        System.out.println("Postfix Expression: " + expression);
        System.out.println("Evaluation Result: " + evaluator.evaluate(expression));
    }
}
