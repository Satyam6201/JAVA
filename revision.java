
public class revision {
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node Head;
    public static Node Tail;

    public void add(int data) {
        Node newNode = new Node(data);

        if (Head == null) {
            Head = Tail = newNode;
            return;
        }

        newNode.next = Head;
        Head = newNode;
    }

    // Print
    public void print() {
        Node temp = Head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public void removeFirst() {
        if (Head == null) {
            return;
        }

        int value = Head.data;
        Head = Head.next;
        
        System.out.println(value);
    }
    
    public void addvalue(int data, int index) {
        Node newNode = new Node(data);
        int i = 0;

        Node temp = Head;
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    } 
    
    public void removeValue(int key) {
        if (Head == null) {
            System.out.println("Linklist is Empty!");
            return;
        }
        if (key == Head.data) {
            Head = Head.next;
            System.out.println(key);
            return;
        }

        Node temp = Head;
        while (temp.next != null && temp.next.data != key) {
            temp = temp.next;
        }

        int value = temp.next.data;
        temp.next = temp.next.next;
        System.out.println(value);
    }
    
    public void length() {
        Node temp = Head;
        int length = 0;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        System.out.println(length);
    }
    
    public void nthNode(int n) {
        if (Head == null) {
            System.out.println("LinkedList is Empty!");
            return;
        }

        int length = 0;
        Node temp = Head;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        if (n == length) {
            int val = Head.data;
            Head = Head.next;
            System.out.println(val);
            return;
        }

        int i = 0;
        int index = length - n;
        
        Node prev = Head;

        while (i < index - 1) {
            prev = prev.next;
            i++;
        }

        int val = prev.next.data;
        prev.next = prev.next.next;
        System.out.println(val);

    }
           public static void main(String []args) {
        revision li = new revision();
        li.add(1);
        li.add(2);
        li.add(3);

        li.addvalue(5, 2);
        li.addvalue(6, 3);

        li.print();
        System.out.println();
        li.nthNode(3);
        li.print();
    }
}