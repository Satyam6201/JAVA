
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueusAll {

    // First Non Repation character
    public static void firstNonRep(String s) {
        Queue <Character> q = new LinkedList<>();

        int freq[] = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;
        }

        while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
            q.remove();
        }

        if (q.isEmpty()) {
            System.out.println("Queue have no non-repeating character!");
            return;
        }
        else {
            System.out.println(q.peek());
        }
    }
    
    // interLeave 2 halves Queue 1 2 3 4 = 1 3 2 4 ans
    public static void interLeave(Queue<Integer> q) {
        Queue<Integer> qt = new LinkedList<>();

        int size = q.size();  // find the size
        for (int i = 0; i < size / 2; i++) {  // size is hlft tk hi chalna hai 
            qt.add(q.remove());  // 1, 2, 3, 4, 5
        }

        while (!qt.isEmpty()) {
            q.add(qt.remove()); // 6, 7, 8, 9, 10, 1, 2, 3, 4, 5
            q.add(q.remove()); // 1, 6, 2, 7, 3, 8, 4, 9, 5, 10
        }
        System.out.println(q);
    }
     
    // Queue using 2 stack
    static class Queues { 
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        // IsEmpty()
        public static boolean  isEmpty() {
            return s1.isEmpty() && s2.isEmpty();
        }

        // Add 
        public static void add(int data) {
            if (!s1.isEmpty()) {
                s2.push(s1.pop());  // s2 me sara s1 ka value add kr denge 
            }
            s1.push(data); // data sabse pahle add kr denge 
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            } 
        }

        // Remove
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Stack is Empty!");
                return -1;
            }
            return s1.pop(); // top most element remove kr denge
        }
    }
    
    // Stack by using 2 Queue 
    static class Stacks {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        // IsEmpty 
        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        // Push
        public static void push(int data) {
            if (!q1.isEmpty()) {
                q1.add(data);
            }
            else {
                q2.add(data);
            }
        }

        // pop
        public static int pop() {
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            int top = -1;
            
            if(!q1.isEmpty()){
                while (!q1.isEmpty()) {
                    top = q1.remove(); // top = 1,2,3
                    if(q1.isEmpty()){
                        break;
                    }
                    q2.add(top);
                }
            }
            else{
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if(q2.isEmpty()){
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }

        // peek
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty!");
                return -1;
            }
            
            int top = -1;

            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();          
                q2.add(top);
                }
            }
            else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }
    }
    public static void main(String[] args) {
        // String s = "aabbcd";
        // firstNonRep(s);  // c

        // Queue<Integer> q = new LinkedList<>();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // q.add(5);
        // q.add(6);
        // q.add(7);
        // q.add(8);
        // q.add(9);
        // q.add(10);
        // interLeave(q);   //1, 6, 2, 7, 3, 8, 4, 9, 5, 10

        // Queues q = new Queues();
        // q.add(1);
        // q.add(2);
        // while (!q.isEmpty()) {
        //     System.out.println(q.remove());
        // }
 
        Stacks s = new Stacks();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
