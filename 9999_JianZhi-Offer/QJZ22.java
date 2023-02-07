/*
 * 剑指 Offer 22. 链表中倒数第k个节点
 * 
 * Two Pointers
 * O(n) time | O(1) space
 * 
 * 2023/02/04
 */
class QJZ22 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode prev = head;
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            curr = curr.next;
        }

        while (curr != null) {
            prev = prev.next;
            curr = curr.next;
        }
        
        return prev;
    }
}