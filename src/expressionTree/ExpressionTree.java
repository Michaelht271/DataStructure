package expressionTree;

import java.util.Stack;



public class ExpressionTree {
	 // Using Loop
	
    public ExpressionTreeNode constructTreeFromPostfix(char[] postfix) {
        Stack<ExpressionTreeNode> stack = new Stack<>();
        for (char ch : postfix) {
            if (Character.isLetterOrDigit(ch)) {
                stack.push(new ExpressionTreeNode(ch));
            } else {
                ExpressionTreeNode node = new ExpressionTreeNode(ch);
                node.right = stack.pop();
                node.left = stack.pop();
                stack.push(node);
            }
        }
        return stack.pop();
    }

    // In-order traversal of the expression tree
    public void inOrderTraversal(ExpressionTreeNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.value + " ");
            inOrderTraversal(root.right);
        }
    }
    
    // Pre-order traversal of the expression tree
    public void preOrderTraversal(ExpressionTreeNode root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    // Post-order traversal of the expression tree
    public void postOrderTraversal(ExpressionTreeNode root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.value + " ");
        }
        
        
  
        
    }
    //------------------------------------------------------------------------
    // Method to construct a tree from infix expression Using Recursion
    
        
    

        // Method to construct a tree from infix expression
        public ExpressionTreeNode constructTreeFromInfix(char[] infix) {
            return constructInfixTree(infix, 0, infix.length - 1);
        }

        private ExpressionTreeNode constructInfixTree(char[] infix, int start, int end) {
            if (start > end) return null;

            // Simplified logic to find the main operator in the expression
            int index = findOperator(infix, start, end);
            ExpressionTreeNode node = new ExpressionTreeNode(infix[index]);

            // Constructing the left and right subtrees recursively
            node.left = constructInfixTree(infix, start, index - 1);
            node.right = constructInfixTree(infix, index + 1, end);

            return node;
        }

        // Simplified logic to find the main operator in the infix expression
        private int findOperator(char[] infix, int start, int end) {
            // For simplicity, return the middle index (adjust based on actual parsing logic)
            return (start + end) / 2;
        }

        
        
        
    
    
    public static void main(String[] args) {
    	System.out.println(" Using Loop:  ");
        String postfix = "ab+ef*g*-";
        ExpressionTree et = new ExpressionTree();
        ExpressionTreeNode root1 = et.constructTreeFromPostfix(postfix.toCharArray());

        System.out.print("In-order traversal of expression tree: ");
        et.inOrderTraversal(root1);
        System.out.println();

        System.out.print("Pre-order traversal of expression tree: ");
        et.preOrderTraversal(root1);
        System.out.println();

        System.out.print("Post-order traversal of expression tree: ");
        et.postOrderTraversal(root1);
       System.out.println();
        
       System.out.println("\n Using Recursion:  ");
        String infix = "a+b*(c^d-e)^(f+g*h)-i";
        ExpressionTree et2 = new ExpressionTree();
        ExpressionTreeNode root = et2.constructTreeFromInfix(infix.toCharArray());

        System.out.print("In-order traversal of expression tree: ");
        et2.inOrderTraversal(root);
        System.out.println();

        System.out.print("Pre-order traversal of expression tree: ");
        et2.preOrderTraversal(root);
        System.out.println();

        System.out.print("Post-order traversal of expression tree: ");
        et2.postOrderTraversal(root);
        System.out.println();
    
    }
}
