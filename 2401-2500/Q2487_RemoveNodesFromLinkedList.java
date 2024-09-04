import java.util.*;

/**
 * 20240102 CN Daily
 * 单调栈 Monotonic stack
 */

/**
 * O(n) time | O(n) space
 */
class Solution2487 {
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

    public ListNode removeNodes(ListNode head) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ListNode node = head;
        while (node != null) {
            int val = node.val;
            while (!stack.isEmpty() && stack.peek() < val) {
                stack.pop();
            }
            stack.push(val);
            node = node.next;
        }

        node = new ListNode(stack.pop());
        ListNode prev = null;
        while (!stack.isEmpty()) {
            prev = new ListNode(stack.pop());
            prev.next = node;
            node = prev;
        }
        return node;
    }
}