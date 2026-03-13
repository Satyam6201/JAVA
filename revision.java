
import java.util.Stack;

public class revision {
    public static class Node {
        int data;
        Node next;

        public Node (int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node Head;
    public static Node Tail;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        
        if (Head == null) {
            Head = Tail = newNode;
            return;
        }

        newNode.next = Head;
        Head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);

        if (Head == null) {
            Head = Tail = newNode;
            return;
        }
        
        Tail.next = newNode;
        Tail = newNode;
    }

    public static void add(int index, int data) {
        Node newNode = new Node(data);
        
        if (index == 0) {
            newNode.next = Head;
            Head = newNode;
            return;
        }
        Node temp = Head;
        int i = 0;

        while (i < index - 1) {
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public static void removeFirst() {
        if (Head == null) {
            System.out.println("LinkList is empty!");
            return;
        }
        
        int value = Head.data;

        if (Head == Tail) {
            Head = Tail = null;
            return;
        }
        else {
            Head = Head.next;
        }

        System.out.println(value);
    }
    
    public static void removeLast() {

        Node prev = null;

        if (Head == null) {
            System.out.println("Linkedlist is empty!");
            return;
        }

        int val = Tail.data;
        if (Head == Tail) {
            Head = Tail = null;
            return;
        }
        Node temp = Head;

        while (temp.next != Tail) {
            temp = temp.next;
        }
        temp.next = null;
        Tail = temp;
        System.out.println(val);
    }
    
    public static void remove(int index) {
        if (index == 0) {
            int val = Head.data;
            Head = Head.next;
            System.out.println(val);
            return;
        }

        int i = 0;
        Node temp = Head;

        while (i < index - 1) {
            temp = temp.next;
            i++;
        }

        int val = temp.next.data;
        temp.next = temp.next.next;
        System.out.println(val);
    }
    
    public static void length() {
        int count = 0;
        Node temp = Head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println("Count = " + count);
    }
    
    public static void search(int index) {
        Node temp = Head;

        while (temp != null) {
            if (temp.data == index) {
                System.out.println("Value is find");
                return;
            }
            temp = temp.next;
        }
        System.out.println("value is Not Find");
    }

    public void print() {
        Node temp = Head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void reverse() {
        if (Head == null) {
            System.out.println("linkList is empty!");
            return;
        }

        Node curr = Head;
        Node prev = null;
        Node next = null;
    
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Head = prev;
    }

    public void mid() {
        Node slow = Head;
        Node fast = Head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println(slow.data);
    }









    public static void main(String[] args) {
        // revision l = new revision();
        // l.addFirst(2);
        // l.addFirst(1);
        // l.addLast(3);
        // l.add(0, -1);
        
        // l.mid();

        String str = "({})";
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            }

            else {
                if (s.isEmpty()) {
                    System.out.println("Not a valid paranthesis!");
                    return;
                }

                else if (s.peek() == '(' && ch == ')' || s.peek() == '{' && ch == '}' || s.peek() == '[' && ch == ']') {
                    s.pop();
                }
            }
        } 
        if (s.isEmpty()) {
            System.out.println("Valid paranthesis");
        }
        else {
            System.out.println("Not Valid");
        }
    }
}
