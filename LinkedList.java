
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
    
    // Find and Remove nth node from the end
    public void deleteNthfromEnd(int n) {
        int size = 0;
        Node Temp = Head;

        while (Temp != null) {
            Temp = Temp.next;
            size++;
        }
        
        // Agar head hi ko remove krna ho to 
        if (n == size) {
            Head = Head.next;
            return;
        }

        // size - n
        int i = 1;
        int iToFind = size - n;
        Node prev = Head;

        while (i < iToFind) {   // 1 to n 
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return;
    }
    
    // Find Mid value 
    public void midValue() {
        if (Head == null || Head.next == null) {
            System.out.println(Head);
            return;
        }

        int count = 0;
        Node Temp = Head;

        while (Temp != null) {
            count++;
            Temp = Temp.next;
        }

        // Calculate the position of the middle node.
        int mid = count / 2 + 1;
        Temp = Head;

        while (Temp != null) {
            mid = mid - 1;

            if (mid == 0) {
                break;
            }

            // Move temp ahead
            Temp = Temp.next;
        }

        // Return the middle node.
        System.out.println("Mid value = " + Temp.data);
    }

    // Find mid value optimizied code (Slow and fast approach)
    public void midValueSlowAndFast() {
        if (Head == null || Head.next == null) {
            System.out.println(Head);
            return;
        }

        Node fast = Head;
        Node slow = Head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;  // fast = 2 se aage jaega
            slow = slow.next; // slow = 1 se aage jaega
        }
        System.out.println("Mid Value = " + slow.data);
    }
    
    // Detect a loop is cycyle or not 
    public static boolean isCycle() {
        Node fast = Head;
        Node slow = Head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    // Remove cycle
    public static void removeCycle() {
        Node fast = Head;
        Node slow = Head;
        boolean isCycle =  false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {  // detect it is cycle or not
                isCycle = true;
                break;
            }           
        }
        if (isCycle == false) {
            return;
        }

        slow = Head;
        Node prev = null;

        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        prev.next = null;  // remove cycle
           
    }
    
    // Merge sort 
    public static Node midValue(Node Head1) {
        Node fast = Head1.next;
        Node slow = Head1;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return  slow;
    }
    public static Node merge(Node Head1, Node Head2) {
        // Define length
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;

        while (Head1 != null && Head2 != null) {
            // Check head1 ka data bara hai ya chota 
            if (Head1.data <= Head2.data) {
                temp.next = Head1;
                Head1 = Head1.next;
                temp = temp.next;
            }
            else {
                temp.next = Head2;
                Head2 = Head2.next;
                temp = temp.next;
            }
        }

        while (Head1 != null) {
            temp.next = Head1;
            Head1 = Head1.next;
            temp = temp.next;
        }
        while (Head2 != null) {
            temp.next = Head2;
            Head2 = Head2.next;
            temp = temp.next;
        }

        return mergeLL.next;
    }
    public static Node mergeSort(Node Head) {
        if (Head == null || Head.next == null) {
            return Head;
        }

        // find mid value 
        Node mid = midValue(Head);

        Node right = mid.next;
        mid.next = null;

        Node leftNode = mergeSort(Head);
        Node righNode = mergeSort(right);

        return merge(leftNode, righNode);
    }
    
    // searching in the linkedlist (if value is present the return index otherwise return -1)
    public static int IterativeSearch(int key) {
        if (Head == null) {
            return -1;
        }

        Node temp = Head;
        int index = 0;

        while (temp != null) {
            if (temp.data == key) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }
    
    
    public static void main(String[] args) {
        LinkedList li = new LinkedList();
        // li.addFirst(2);
        // li.addFirst(1);

        // li.addLast(3);
        // li.addLast(4);

        // // li.print();  // 1, 2, 3, 4

        // li.add(2, 5);  // 1, 2, 5, 3, 4
        // li.print();
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
        
        // li.reverse();  // 4, 3, 5, 2, 1
        // System.out.println("Reverse LinkList!");
        // li.print();
        
        // li.deleteNthfromEnd(2);
        // li.print();

        // li.midValue(); // 5
        // li.midValueSlowAndFast(); // 5


        // Head = new Node(1);
        // Node temp = new Node(2);
        // Head.next = temp;
        // Head.next.next = new Node(3);
        // Head.next.next.next = new Node(4);
        // Head.next.next.next.next = new Node(5);
        // Head.next.next.next.next.next = temp;  // 1->2->3->4->5->2 
        // // System.out.println(isCycle()); // True
        // removeCycle();
        // System.out.println(isCycle());  // false

        // li.addFirst(1);
        // li.addFirst(2);
        // li.addFirst(3);
        // li.addFirst(4);
        // li.addFirst(6);
        // li.addFirst(5);
        // li.print();     // 5->6->4->3->2->1
        // li.Head = li.mergeSort(li.Head);
        // System.out.println("After sort");
        // li.print();

        li.addFirst(1);
        li.addFirst(2);
        li.addFirst(3);
        li.addFirst(4);
        li.addFirst(6);
        li.addFirst(5);
        System.out.println(li.IterativeSearch(2)); // index = 4
        System.out.println(li.IterativeSearch(7)); //-1 (not present)
    }
}