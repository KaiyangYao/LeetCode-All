/*
 * Two Pointer
 * 
 * O(max(m,n)) time
 * O(1) space
 * 
 * 2022/11/09
 * 
 * Same as Q67, Q415
 */
class Solution002 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);  // fack head
        ListNode curr = pre; // moveable pointer
        int carry = 0;
        
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            
            curr.next = new ListNode(sum % 10);
            carry = sum / 10;
            
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            curr = curr.next;
        }
        
        if (carry == 1) {
            curr.next = new ListNode(1);
        }
        
        return pre.next;
    }
}