import java.util.*;

/*
 * 剑指 Offer 35. 复杂链表的复制
 * 
 * O(n) time
 * O(n) space
 * 
 * Also at LeetCode 138
 * 
 * 2023/01/26
 */

class QJZ35 {
    class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Node t = head;
        Node dummy = new Node(-1);
        Node curr = dummy;
        Map<Node, Node> map = new HashMap<>();

        while (head != null) {
            Node node = new Node(head.val);
            map.put(head, node);
            curr.next = node;
            curr = curr.next;
            head = head.next;
        }

        curr = dummy.next;
        head = t;
        while (head != null) {
            curr.random = map.get(head.random);
            curr = curr.next;
            head = head.next;
        }

        return dummy.next;
    }
}