package binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    // Insert method
    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    // Search method
    public boolean search(int data) {
        return searchRec(root, data) != null;
    }

    private Node searchRec(Node root, int data) {
        if (root == null || root.data == data) {
            return root;
        }
        if (root.data > data) {
            return searchRec(root.left, data);
        }
        return searchRec(root.right, data);
    }

    // In-order traversal method
    public void inOrderTraversal() {
        inOrderRec(root);
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.data + " ");
            inOrderRec(root.right);
        }
    }
    
    // Level-Order Traversal (Breadth-First)
    public void levelOrderTraversal() {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
        System.out.println();
    }

    // Calculate the level of each node
    public void printLevels() {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.print("Level " + level + ": ");
            for (int i = 0; i < size; i++) {
                Node tempNode = queue.poll();
                System.out.print(tempNode.data + " ");

                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
            System.out.println();
            level++;
        }
    }

    // Calculate the height of the BST
    public int height() {
        if (root == null) return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int height = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node tempNode = queue.poll();
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
            height++;
        }

        return height;
    }

    // Delete a node by copying
    public void deleteByCopying(int key) {
        root = deleteRecByCopying(root, key);
    }

    private Node deleteRecByCopying(Node root, int key) {
        if (root == null) return root;

        if (key < root.data) {
            root.left = deleteRecByCopying(root.left, key);
        } else if (key > root.data) {
            root.right = deleteRecByCopying(root.right, key);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            root.data = minValue(root.right);
            root.right = deleteRecByCopying(root.right, root.data);
        }
        return root;
    }

    private int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    // Delete a node by merging
    public void deleteByMerging(int key) {
        root = deleteRecByMerging(root, key);
    }

    private Node deleteRecByMerging(Node root, int key) {
        if (root == null) return root;

        if (key < root.data) {
            root.left = deleteRecByMerging(root.left, key);
        } else if (key > root.data) {
            root.right = deleteRecByMerging(root.right, key);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            Node temp = root.left;
            while (temp.right != null) {
                temp = temp.right;
            }
            temp.right = root.right;
            root = root.left;
        }
        return root;
    }
    
 // In-order traversal using stack
    public void inOrderTraversalUsingStack() {
        Stack<Node> stack = new Stack<>();
        Node current = root;
        
        while (current != null || !stack.isEmpty()) {
            // Reach the leftmost node of the current node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            
            // Current must be null at this point
            current = stack.pop();
            System.out.print(current.data + " ");
            
            // Visit the right subtree
            current = current.right;
        }
    }

    // Pre-Order Traversal (Depth-First)
    public void preOrderTraversalUsingStack(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.print(current.data + " ");
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        System.out.println();
    }

    // Post-Order Traversal (Depth-First)
    public void postOrderTraversalUsingStack(Node root) {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        if (root == null) return;
        stack1.push(root);
        while (!stack1.isEmpty()) {
            Node current = stack1.pop();
            stack2.push(current);
            if (current.left != null) {
                stack1.push(current.left);
            }
            if (current.right != null) {
                stack1.push(current.right);
            }
        }
        while (!stack2.isEmpty()) {
            Node node = stack2.pop();
            System.out.print(node.data + " ");
        }
        System.out.println();
    }
   
    // Build A BTS tree of the smalleast/ largest height 
    
    // Smallest (Balance)
    public Node sortedArrayToBST(int[] arr, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        Node node = new Node(arr[mid]);
        node.left = sortedArrayToBST(arr, start, mid - 1);
        node.right = sortedArrayToBST(arr, mid + 1, end);
        return node;
    }
    
    // Largest 
    public Node sortedArrayToSkewedTree(int[] arr) {
        Node root = null;
        for (int value : arr) {
            root = insertRec(root, value);
        }
        return root;
    }
    
    



        
    
    
}
