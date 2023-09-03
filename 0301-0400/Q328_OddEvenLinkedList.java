/**
 * Linked List
 * 2023/09/02
 */

/**
 * O(n) time | O(1) space
 */
class Solution328 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode oddHead = head, evenHead = head.next;
        ListNode p1 = oddHead, p2 = evenHead;
        while (p2 != null && p2.next != null) {
            p1.next = p2.next;
            p1 = p1.next;
            p2.next = p1.next;
            p2 = p2.next;
        }
        p1.next = evenHead;
        return head;
    }
}