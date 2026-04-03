
import java.util.HashMap;

public class LRUCache {
    
        class Node {
            int key, value;
            Node prev, next;
    
            Node(int k, int v) {
                key = k;
                value = v;
            }
        }
    
        private int capacity;
        private HashMap<Integer, Node> map;
        private Node head, tail;
    
        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
    
            head = new Node(0, 0); // dummy head
            tail = new Node(0, 0); // dummy tail
    
            head.next = tail;
            tail.prev = head;
        }
    
        // node ko remove karne ka function
        private void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    
        // node ko end me add karne ka function (most recent)
        private void insert(Node node) {
            Node prevNode = tail.prev;
    
            prevNode.next = node;
            node.prev = prevNode;
    
            node.next = tail;
            tail.prev = node;
        }
    
        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
    
            Node node = map.get(key);
    
            // use hua → recent bana do
            remove(node);
            insert(node);
    
            return node.value;
        }
    
        public void put(int key, int value) {
    
            if (map.containsKey(key)) {
                remove(map.get(key));
            }
    
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insert(newNode);
    
            // capacity exceed → LRU hatao
            if (map.size() > capacity) {
                Node lru = head.next; // first real node
                remove(lru);
                map.remove(lru.key);
            }
        }
        public static void main(String[] args) {
            LRUCache obj = new LRUCache(2);

        System.out.println("null");
        obj.put(1,1); 
        System.out.println("null");
        obj.put(2,2); 
        System.out.println("null");
        System.out.println(obj.get(1)); // 1
        obj.put(3,3); 
        System.out.println("null");
        System.out.println(obj.get(2)); // -1
        obj.put(4,4); 
        System.out.println("null");
        System.out.println(obj.get(1)); // -1
        System.out.println(obj.get(3)); // 3
        System.out.println(obj.get(4)); // 4
        }
    }
