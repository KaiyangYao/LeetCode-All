/**
 * 2023/07/10
 */

 /**
  * O(n) time | O(1) space
  */
class Solution445 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = reverseList(l1);
        ListNode p2 = reverseList(l2);
        return reverseList(addTwoNums(p1, p2));
    }

    private ListNode reverseList(ListNode x) {
        ListNode prev = null;
        ListNode curr = x;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private ListNode addTwoNums(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode dummy = head;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int sum = carry + v1 + v2;
            head.next = new ListNode(sum % 10);
            carry = sum / 10;

            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
            head = head.next;
        }

        if (carry != 0) {
            head.next = new ListNode(carry);
        }

        return dummy.next;
    }
}