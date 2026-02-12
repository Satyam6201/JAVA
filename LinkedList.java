public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node Head;
    public static Node Tail;
    public static int size;

    // Add First 
    public void addFirst(int data) {
        // Create newNode
        Node newNode = new Node(data);
        size++;

        // Base Condition(agar 1 hi node ho tab)
        if (Head == null) {
            Head = Tail = newNode;
            return;
        }

        // NewNode next ko head bna denge 
        newNode.next = Head;

        // newNode ko ab head bna denge 
        Head = newNode;
    }

    // Add Last
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;

        if (Head == null) {
            Head = Tail = null;
            return;
        }

        //NewNode next ko tail bna denge 
        Tail.next = newNode;

        // Ab tail jo hai usko newNode bna denge
        Tail = newNode;

    }
    
    // Print
    public void print() {
        Node temp = Head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    // Add in Middle
    public void add(int index, int data) {
        Node newNode = new Node(data);
        size++;

        Node temp = Head;
        int i = 0;

        while (i < index - 1) {
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }
    

    
    public static void main(String[] args) {
        LinkedList li = new LinkedList();
        li.addFirst(1);
        li.addFirst(2);

        li.addLast(3);
        li.addLast(4);

        // li.print();  // 2, 1, 3, 4

        li.add(2, 5); 
        li.print();
        System.out.println("Size = " + li.size);
        
    }
}