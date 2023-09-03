import java.util.*;

/**
 * Linked List + Stack
 * 2023/09/02
 */

/**
 * O(n) time | O(n) space
 */
class Solution2130 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int pairSum(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();
        ListNode p1 = new ListNode(0);
        ListNode p2 = new ListNode(0);
        p1.next = head;
        p2.next = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            stack.push(p1.val);
        }

        int result = Integer.MIN_VALUE;
        while (p1.next != null) {
            p1 = p1.next;
            result = Math.max(result, p1.val + stack.pop());
        }

        return result;
    }
}