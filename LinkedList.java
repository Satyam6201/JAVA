
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
            System.out.println(temp.data + " ");
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

    // Remove First
    public void removeFirst() {
        if (size == 0) {
            System.out.println("Linked List is Empty!");
        }
        else if (size == 1) {
            int value = Head.data;
            Head = Tail = null;
            size = 0;
            System.out.println(value);
        } 

        int value = Head.data;
        Head = Head.next;
        size--;
        System.out.println("Value of first deleted value is = " + value);
    }

    // Remove last
    public void removeLast() {

        Node prev = Head;

        if (size == 0) {
            System.out.println("LinkedList is Empty");
        }
        else if (size == 1) {
            int value = Tail.data;
            Head = Tail = null;
            size = 0;
            System.out.println(value);
        }

        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }

        int value = prev.next.data;
        prev.next = null;
        Tail = prev;
        size--;
        System.out.println("Value of Last deleted is = " + value);
    }

    // Remove any place any number
    public void remove(int key) {
        if (Head == null) {
            System.out.println("LinkedList is empty!");
            return;
        }

        if (Head.data == key) {  // target hi head raha tb
            Head = Head.next;
            System.out.println("Value which is delete " + key);
            return;
        }

        Node temp = Head;

        while (temp.next != null && temp.next.data != key) {  // agr temp ka next null huaa or temp.next ka data key k barabar nhi hai tb tk
            temp = temp.next;
        }

        if (temp.next != null) {
            int value = temp.next.data;
            temp.next = temp.next.next;
            System.out.println("Value which is deleted = " + value);
        } else {
            System.out.println("Value not found");
        }
    }
    
    // Length of the LinkedList:-
    public void length() {
        Node Temp = Head;
        int count = 0;

        while (Temp != null) {
            count++;
            Temp = Temp.next;
        }
        System.out.println("Length of the LinkedList = " + count);
    }

    // Search an element in the linkedlist
    public void search(int target) {       
        Node Temp = Head;

        while (Temp != null) {

            if (Temp.data == target) {
                System.out.println("Value is Found!");
                return;
            }
            Temp = Temp.next;                       
        }
        System.out.println("Not Found!");
    }
    
    // Reverse the linkedlist 
    public void reverse() {
        Node curr = Head;
        Node next = null;
        Node prev = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Head = prev;
    }
    public static void main(String[] args) {
        LinkedList li = new LinkedList();
        li.addFirst(2);
        li.addFirst(1);

        li.addLast(3);
        li.addLast(4);

        // li.print();  // 1, 2, 3, 4

        li.add(2, 5);  // 1, 2, 5, 3, 4
        li.print();
        // System.out.println("Size = " + li.size); size = 5
    
        // li.removeFirst();
        // li.removeLast();
        // // li.print();

        // li.remove(5);
        // // li.print();

        // li.length();
        // li.print();
        // li.search(3);  // Value is Found
        // li.search(5);  // value is not found
        
        li.reverse();  // 4, 3, 5, 2, 1
        System.out.println("Reverse LinkList!");
        li.print();

    }
}