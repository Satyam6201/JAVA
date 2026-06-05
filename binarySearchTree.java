import java.util.ArrayList;

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
    
    // 9 Check a tree is valid Binary search tree
    public static boolean isValidBST(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.data <= min.data) {
           return false;
        }

        if (max != null && root.data >= max.data) {
           return false;
        }
        
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
    
    // 10 Merge 2 binary search tree 
    public static void getInOrder(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }

        getInOrder(root.left, list);
        list.add(root.data);
        getInOrder(root.right, list);
    } 
    public static Node balanceBST(ArrayList<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }
        
        int mid = (start + end) / 2; // mid
        Node root = new Node(list.get(mid));

        root.left = balanceBST(list, start, mid - 1);
        root.right = balanceBST(list, mid + 1, end);

        return root;
    }
    public static Node mergeBST(Node root1, Node root2) {
        
        // Step-1 InOrder Sequence
        ArrayList<Integer> inOrder1 = new ArrayList<>();
        getInOrder(root1, inOrder1);

        // Step-2 InOrder Sequence
        ArrayList<Integer> inOrder2 = new ArrayList<>();
        getInOrder(root2, inOrder2);

        // step-3 merge
        int i = 0;
        int j = 0;

        ArrayList<Integer> result = new ArrayList<>();

        while (i < inOrder1.size() && j < inOrder2.size()) {
            if (inOrder1.get(i) <= inOrder2.get(j)) {
                result.add(inOrder1.get(i));
                i++;
            }
            else {
                result.add(inOrder2.get(j));
                j++;
            }
        }

        while (i < inOrder1.size()) {
            result.add(inOrder1.get(i));
            i++;
        }
        while (j < inOrder2.size()) {
            result.add(inOrder2.get(j));
            j++;
        }
        return balanceBST(result, 0, result.size() - 1);
    }

    // 11 Inorder Successor/Predecessor in BST
    static Node predecessor = null;
    static Node successor = null;
    public static void findPreSuc(Node root, int key) {
        while (root != null) {
            
            // Predecessor 
            if (root.data < key) {  // left side 
                predecessor = root;
                root = root.right;
            }
            // Successor
            else if (root.data > key) {
                successor = root;
                root = root.left;
            }
            else {
               // predecessor = max value in left subtree
                if (root.left != null) {
                    Node temp = root.left;

                    while (temp.right != null) {  // root.left.right != null
                        temp = temp.right;
                    }
                    predecessor = temp;
                }

                // successor = min value in right subtree
                if (root.right != null) { 
                    Node temp = root.right;

                    while (temp.left != null) {  // root.right.left != null
                        temp = temp.left;
                    }

                    successor = temp;
                }
                break;
            }
        }
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
        // int value[] = {5, 1, 3, 4, 2, 7};  
        // Node root = null;

        // for (int i = 0; i < value.length; i++) {
        //     root = insert(root, value[i]);    //5 -> 1 -> 3 -> 2 -> 4 -> 7
        // }
        
        // preOrder(root); // 5 1 3 2 4 7 
        // inOrder(root); // 1 2 3 4 5 7 
        // postOrder(root);  // 2 4 3 1 7 5 
        
        // System.out.println(search(root, 7));  // true
        // System.out.println(search(root, 9));  // false

        // root = mirror(root);
        // preOrder(root); // 5 7 1 3 4 2 

        // delete(root, 1);
        // inOrder(root);  // 2 3 4 5 7   (1 delete ho gya )

        // System.out.println(kthSmallest(root, 6)); // 7

        // System.out.println(isValidBST(root, null, null));

        // Node root1 = new Node(2);
        // root1.left = new Node(1);
        // root1.right = new Node(4);
        // Node root2 = new Node(9);
        // root2.left = new Node(3);
        // root2.right = new Node(12);
        // Node roots = mergeBST(root1, root2);
        // preOrder(roots); //3 1 2 9 4 12 

        /*
                20
               /  \
             10    30
            / \    / \
           5  15  25  35
        */
        
        Node root = new Node(20);
        root.left = new Node(10);
        root.right = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(15);
        root.right.left = new Node(25);
        root.right.right = new Node(35);

        int key = 25;
        findPreSuc(root, key);
        System.out.println(predecessor.data);  // 20
        System.out.println(successor.data); // 30
    }
}
