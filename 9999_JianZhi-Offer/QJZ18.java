/*
 * 剑指 Offer 18. 删除链表的节点
 * 
 * Two Pointers
 * O(n) time | O(1) space
 * 
 * 2023/02/04
 */
class QJZ18 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) return head.next;
        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null && curr.val != val) {
            curr = curr.next;
            prev = prev.next;
        }
        prev.next = curr.next;
        return head;
    }
}