
public class binarySearchTree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // 1. Insert the value in BST
    public static Node insert(Node root, int value) {
        if (root == null) {
            root = new Node(value);  // root ke jagah me value put kr denge
            return root;
        }

        if (root.data > value) {   // root ka data value se bara hoga to usko left side me rkhenge
            root.left = insert(root.left, value);
        }

        // root ka data value se chota hoga to usko right side me rkhenge
        else {
            root.right = insert(root.right, value);
        }

        return root;
    }
    
    // 2. PreOrder in binary search tree
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    
    // 3. InOrder in Binary search Tree 
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    
    // 4. postOrder in binary Search tree
    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
    
    
    public static void main(String[] args) {
        /*
                5
              /   \
             1     7
              \
                3
               / \
              2   4
        */
        int value[] = {5, 1, 3, 4, 2, 7};  
        Node root = null;

        for (int i = 0; i < value.length; i++) {
            root = insert(root, value[i]);    //5 -> 1 -> 3 -> 2 -> 4 -> 7
        }
        
        // preOrder(root); // 5 1 3 2 4 7 
        // inOrder(root); // 1 2 3 4 5 7 
        postOrder(root);  // 2 4 3 1 7 5 

    }
}
