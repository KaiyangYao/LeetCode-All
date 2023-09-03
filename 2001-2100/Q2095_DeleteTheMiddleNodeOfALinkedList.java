/**
 * Linked List
 * 2023/09/02
 */

/**
 * O(n) time | O(1) space
 */

class Solution2095 {
    public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode prev = null;
        ListNode p1 = head, p2 = head;
        while (p2 != null && p2.next != null) {
            prev = p1;
            p1 = p1.next;
            p2 = p2.next.next;
        }
        prev.next = p1.next;
        return head;
    }
}

