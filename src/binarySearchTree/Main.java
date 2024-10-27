package binarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        
        // Inserting values into the BST
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        // Printing in-order traversal of the BST
        System.out.print("In-order traversal: ");
        bst.inOrderTraversal();  // Output: 20 30 40 50 60 70 80
        System.out.println();

        // Searching for a value in the BST
        int key = 40;
        if (bst.search(key)) {
            System.out.println("Found " + key + " in the BST.");
        } else {
            System.out.println(key + " is not in the BST.");
        }
        
        // Level-Order Traversal
        System.out.println("\nLevel-Order Traversal: ");
        bst.levelOrderTraversal();  // Output: 50 30 70 20 40 60 80

        // Printing levels of each node
        bst.printLevels();
        // Output:
        // Level 0: 50 
        // Level 1: 30 70 
        // Level 2: 20 40 60 80 

        // Printing height of the BST
        System.out.println("Height of the BST: " + bst.height());

        // Deleting a node by copying
        bst.deleteByCopying(50);
        System.out.print("In-order traversal after deleting 50 (copying): ");
        bst.inOrderTraversal();
        System.out.println();

        // Reset the BST and delete a node by merging
        bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);
        bst.deleteByMerging(50);
        System.out.print("In-order traversal after deleting 50 (merging): ");
        bst.inOrderTraversal();
        System.out.println();

        // Testing Pre-Order Traversal Using Stack
        System.out.print("Pre-Order Traversal: ");
        bst.preOrderTraversalUsingStack(bst.root);

        // Testing Post-Order Traversal Using Stack
        System.out.print("Post-Order Traversal: ");
        bst.postOrderTraversalUsingStack(bst.root);

        // Testing In-Order Traversal Using Stack
        System.out.print("In-Order Traversal Using Stack: ");
        bst.inOrderTraversalUsingStack();
        System.out.println();
        
        
    
        int[] arr = {20, 30, 40, 50, 60, 70, 80};

        // Balanced Tree (Smallest Height)
        BinarySearchTree balancedTree = new BinarySearchTree();
        balancedTree.root = balancedTree.sortedArrayToBST(arr, 0, arr.length - 1);
        System.out.print("Balanced BST (in-order): ");
        balancedTree.inOrderTraversal();  // Should print 20 30 40 50 60 70 80
        System.out.println();

        // Skewed Tree (Largest Height)
        BinarySearchTree skewedTree = new BinarySearchTree();
        skewedTree.root = skewedTree.sortedArrayToSkewedTree(arr);
        System.out.print("Skewed BST (in-order): ");
        skewedTree.inOrderTraversal();  // Should print 20 30 40 50 60 70 80
        System.out.println();
        
    }
}
