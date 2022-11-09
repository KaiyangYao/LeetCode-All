/*
 * Set DummyHead
 * 
 * O(n) time | O(1) space
 * 
 * 2022/11/09
 */
class Solution203 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode curr = pre;
        
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        
        return pre.next;
    }
}