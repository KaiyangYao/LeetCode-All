/**
 * 2023/01/14
 * Linked List
 */

/**
 * O(n) time | O(1) space
 */
class Solution082 {
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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            int val = curr.next.val;
            if (curr.next.next.val == val) {
                while (curr.next != null && curr.next.val == val) {
                    curr.next = curr.next.next;
                }
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}