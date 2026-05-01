
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
    
    // 5. Search in the binary tree
    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }

        if (root.data > key) {
            return search(root.left, key);
        }
        else {
            return search(root.right, key);
        }
    }
    
    // 6 Mirror a bst 
    public static Node mirror(Node root) {
        if (root == null) {
            return null;
        }

        Node rightNode = mirror(root.right);
        Node leftNode = mirror(root.left);

        root.left = rightNode;
        root.right = leftNode;

        return root;
    }
    
    // 7. Delete node in the tree
    public static Node delete(Node root, int value) {
        if (root.data < value) {  // value root se bara ho tb
            root.right = delete(root.right, value);
        }
        else if (root.data > value) { // value root se chota ho
            root.left = delete(root.left, value);
        }
        else {
            // delete leaf node 
            if (root.left == null && root.right == null) {
                return null;
            }
            // delete one child element
            else if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }

            // delete 2 child element
            Node successor = findSuccessorNode(root.right);  // right value se swap krenge 
            root.data = successor.data;
            root.right = delete(root.right, successor.data);
        }
        return root;
    }
    public static Node findSuccessorNode(Node root) {
        if (root.left != null) {
            root = root.left;
        }
        return root;
    }
    
    // 8. Find kth Smallest number
    static int result = -1;
    static int count = 0;
    public static int kthSmallest(Node root, int k) {
        count = 0;
        result = -1;
        inOrder(root, k);
        return result;
    }
    public static void inOrder(Node root, int k) {
        if (root == null) {
            return;
        }

        inOrder(root.left, k); // pahle left me jaenge

        count++;

        if (count == k) {
            result = root.data;
            return;
        }

        inOrder(root.right, k);
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
        // postOrder(root);  // 2 4 3 1 7 5 
        
        // System.out.println(search(root, 7));  // true
        // System.out.println(search(root, 9));  // false

        // root = mirror(root);
        // preOrder(root); // 5 7 1 3 4 2 

        // delete(root, 1);
        // inOrder(root);  // 2 3 4 5 7   (1 delete ho gya )

        System.out.println(kthSmallest(root, 6)); // 7

    }
}
