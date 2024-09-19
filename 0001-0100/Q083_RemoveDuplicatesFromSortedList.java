/*
 * LinkedList
 * 
 * O(n) time | O(1) space
 * 
 * 2022/11/11
 * 2024/09/19
 */
class Solution083 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates01(ListNode head) {
        ListNode curr = head;
        
        while (curr != null && curr.next != null) {
            if (curr.next.val == curr.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }


    // 一次到位 丑陋写法
    public ListNode deleteDuplicates02(ListNode head) {
        if (head == null) {
            return head;
        }
        
        ListNode left = head;
        ListNode right = head.next;

        while (right != null) {
            while (right != null && right.val == left.val) {
                right = right.next;
            }

            left.next = right;

            if (right == null) {
                break;
            }
            left = right;
            right = right.next;
        }
        
        return head;
    }
}