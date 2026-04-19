import java.util.LinkedList;
import java.util.Queue;

public class Trees {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // InBuild Feature used for the preOrder, InOrder, PostOrder
    static class BinaryTree {
        static int index = -1;

        // Bulid a tree
        public static Node buildTree(int nodes[]) {
            index++; // 0

            // agar -1 huaa to null usko manenge 
            if (nodes[index] == -1) {
                return null;
            }

            // new node bnaenge 
            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        // PreOrder (root -> left -> right)
        public static void preOrder(Node root) {
            if (root == null) {
                return;
            }

            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        // InOrder (left -> root -> right)
        public static void inOrder(Node root) {
            if (root == null) {
                return;
            }

            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        // PostOrder (left -> rigth -> root)
        public static void postOrder(Node root) {
            if (root == null) {
                return;
            }

            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    
        // Level Order
        public static void level(Node root) {
            if (root == null) {
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node currNode = q.remove();

                if (currNode == null) {
                    System.out.println();

                    if (q.isEmpty()) {
                        break;
                    }
                    else {
                        q.add(null);
                    }
                }
                else {
                    System.out.print(currNode.data + " ");

                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }


        }
    
    }

    //Max Height of the tree
    public static int maxHeight(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = maxHeight(root.left);
        int rightHeight = maxHeight(root.right);

        int max = Math.max(leftHeight, rightHeight);
        return max + 1;
    }
    
    // Total height of the tree
    public static int totalHeight(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = totalHeight(root.left);
        int rightHeight = totalHeight(root.right);
        int totalHeight = leftHeight + rightHeight + 1;

        return totalHeight;
    }
    
    // Sum of the node 
    public static int sumOfNode(Node root) {
        if (root == null) {
            return 0;
        } 

        int leftNode = sumOfNode(root.left);
        int rightNode = sumOfNode(root.right);

        int sum = leftNode + rightNode + root.data;

        return sum;
    }

    // Diameter og the tree
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int totalHeight = Math.max(leftHeight, rightHeight) + 1;

        return totalHeight;
    }
    public static int diameter(Node root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);

        int totalHeight = left + right + 1;
        int laftRightDiameter = Math.max(leftDiameter, rightDiameter);

        int max = Math.max(totalHeight, laftRightDiameter);
        return max;
    }
    public static void main(String[] args) {
        // int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        // BinaryTree tree = new BinaryTree();
        // Node root = tree.buildTree(nodes);

        // System.out.println(root.data);  // 1

        // tree.preOrder(root); //1 2 4 5 3 6 
        // tree.inOrder(root); // 4 2 5 1 3 6  
        // tree.postOrder(root); // 4, 5, 2, 6, 3, 1

        // tree.level(root);

        // maxHeight
            //        1
            //       /  \
            //      2     3
            //     / \   / \
            //    4   5 6   7
        // Node root = new Node(1);
        // root.left = new Node(2);
        // root.right = new Node(3);
        // root.left.left = new Node(4);
        // root.left.right = new Node(5);
        // root.right.left = new Node(6);
        // root.right.right = new Node(7);
        // System.out.println(maxHeight(root));  // 3

            //        1
            //       /  \
            //      2     3
            //     / \   
            //    4   5 
            //         \
            //          6
            //           \
            //            7

        // Node root = new Node(1);
        // root.left = new Node(2);
        // root.right = new Node(3);
        // root.left.left = new Node(4);
        // root.left.right = new Node(5);
        // root.left.right.right = new Node(6);
        // root.left.right.right.right = new Node(7);
        // // System.out.println(maxHeight(root)); // 5
        // // System.out.println(totalHeight(root));  // 7
        // System.out.println(sumOfNode(root));  // 28 (1+2+3+4+5+6+7)

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(diameter(root));  // 5
    }
}