import java.util.*;

/**
 * LRU Caceh
 * 2023/12/05
 */
class LRUCache {
    class Node {
        int key, val;
        Node next, prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class DoubleLinkedList {
        Node head, tail;
        int size;

        public DoubleLinkedList() {
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            this.size = 0;
            head.next = tail;
            tail.prev = head;
        }

        public void addLast(Node x) {
            x.prev = tail.prev;
            x.next = tail;
            x.prev.next = x;
            x.next.prev = x;
            size++;
        }

        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        public Node getFirst() {
            return head.next;
        }

        public int getSize() {
            return size;
        }
    }

    Map<Integer, Node> map;
    DoubleLinkedList cache;
    int cap;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        cache = new DoubleLinkedList();
        cap = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node x = map.get(key);
        cache.remove(x);
        cache.addLast(x);
        return x.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            cache.remove(map.get(key));
            map.remove(key);
        }
        if (cache.getSize() == cap) {
            Node toDelete = cache.getFirst();
            cache.remove(toDelete);
            map.remove(toDelete.key);
        }

        Node toAdd = new Node(key, value);
        cache.addLast(toAdd);
        map.put(key, toAdd);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */