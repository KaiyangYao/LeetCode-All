/*
 * Method1: 1 pointer (loop 2 times)
 * O(n) time | O(1) space
 * 
 * Method2: 2 pointer (fast-slow pointer)
 * O(n) time | O(1) space
 * 
 * 2022/11/07
 */
class Solution876 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode middleNode(ListNode head) {
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            length++;
        }
        
        curr = head;
        int count = 0;
        while (count < length / 2) {
            curr = curr.next;
            count++;
        }
        
        return curr;
    }
}