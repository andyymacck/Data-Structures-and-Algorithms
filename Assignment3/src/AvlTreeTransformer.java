import java.util.ArrayList;
import java.util.List;

public class AvlTreeTransformer {
    private Node rotateRight(Node y){
        Node x = y.left;
        Node t2 = x.right;

        x.right = y;
        y.left = t2;

        return x;
    }

    private Node rotateLeft(Node x){
        Node y = x.right;
        Node t2 = y.left;

        y.left = x;
        x.right = t2;

        return y;
    }

    private int height(Node node){
        if (node == null){
            return 0;
        }else{
            return Math.max(height(node.left), height(node.right)) +1;

        }
        
    }
    // Insert an item into the AVL tree while maintaining balance.
    private Node insert(Node root, int val) {
        // Perform standard BST insertion
        if (root == null) {
            return new Node(val);
        }

        if (val < root.value) {
            root.left = insert(root.left, val);
        } else if (val > root.value) {
            root.right = insert(root.right, val);
        } else {
            // Duplicate values are not allowed in this transformation
            return root;
        }

        // Update height of the current node
        int balance = height(root.left) - height(root.right);

        // Perform rotations to maintain balance
        if (balance > 1 && val < root.left.value) {
            return rotateRight(root);
        }
        if (balance < -1 && val > root.right.value) {
            return rotateLeft(root);
        }
        if (balance > 1 && val > root.left.value) {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }
        if (balance < -1 && val < root.right.value) {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }

        return root;
    }

    public void printTreeStructure(Node root, int level) {
        if (root == null) {
            return;
        }

        printTreeStructure(root.right, level + 1);

        for (int i = 0; i < level; i++) {
            System.out.print("   "); // Adjust spacing for better visualization
        }

        System.out.println(root.value);

        printTreeStructure(root.left, level + 1);
    }

    // Transform T1 into T2 using AVL single rotations
    public Node transformToAVL(Node root, int[] sortedItems) {
        for (int item : sortedItems) {
            root = insert(root, item);
        }
        return root;
    }

    // In-order traversal to validate the transformation
    public void inOrderTraversal(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }

        inOrderTraversal(root.left, result);
        result.add(root.value);
        inOrderTraversal(root.right, result);
    }

    public static void main(String[] args){
        AvlTreeTransformer transformer = new AvlTreeTransformer();

// Example: Create a sample binary search tree T1
        Node rootT1 = new Node(2);
        rootT1.left = new Node(1);
        rootT1.right = new Node(3);
        rootT1.right.right = new Node(4);
        rootT1.right.right.right = new Node(5);
        rootT1.right.right.right.right = new Node(6);

// Perform in-order traversal to get the items in sorted order
        List<Integer> sortedItems = new ArrayList<>();
        transformer.inOrderTraversal(rootT1, sortedItems);

// Transform T1 into a balanced AVL tree T2
        Node rootT2 = transformer.transformToAVL(null, sortedItems.stream().mapToInt(Integer::intValue).toArray());

// Verify that T2 is a balanced AVL tree with the same items as T1
        List<Integer> sortedItemsT2 = new ArrayList<>();
        transformer.inOrderTraversal(rootT2, sortedItemsT2);

        System.out.println("Original tree T1 structure:");
        transformer.printTreeStructure(rootT1, 0);

// Print the structure of T2 (the transformed AVL tree)
        System.out.println("Transformed tree T2 structure:");
        transformer.printTreeStructure(rootT2, 0);
    }
}
