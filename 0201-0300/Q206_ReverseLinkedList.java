/*
 * O(n) time
 * O(1) space
 * 
 * 2022/11/06
 * 
 * https://leetcode.cn/problems/reverse-linked-list/description/
 */
class Solution206 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}