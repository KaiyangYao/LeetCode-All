/**
 * Linked List
 * 
 * 2023/01/14
 * 2024/09/19
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

    public ListNode deleteDuplicates01(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode curr = dummy;

        while (curr.next != null && curr.next.next != null) {
            if (curr.next.val == curr.next.next.val) {
                ListNode temp = curr.next.next.next;
                while (temp != null && temp.val == curr.next.val) {
                    temp = temp.next;
                }
                curr.next = temp;
            } else {
                curr = curr.next;
            }
        }

        return dummy.next;
    }

    public ListNode deleteDuplicates02(ListNode head) {
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