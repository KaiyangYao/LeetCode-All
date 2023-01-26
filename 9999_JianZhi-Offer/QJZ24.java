
/*
 * 剑指 Offer 24. 翻转链表
 * 
 * Iteration
 * O(n) time, O(1) space
 * 
 * Recursion
 * O(n) time, O(n) space
 * 
 * 2023/01/26
 * 
 * same as LeetCode Q206
 */

class QJZ24 {
    public class ListNode {
        int val;
        ListNode next;
    
        ListNode(int x) {
            val = x;
        }
    }

    // Iteration 1
    public ListNode reverseList1(ListNode head) {
        if (head == null)
            return null;

        ListNode p1 = null;
        ListNode p2 = head;
        ListNode nextNode;

        while (p2 != null) {
            nextNode = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = nextNode;
        }

        return p1;
    }

    // Iteration 2
    public ListNode reverseList2(ListNode head) {
        if (head == null)
            return null;

        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p2 != null) {
            if (p1 == head) {
                p1.next = null;
            }
            ListNode nextNode = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = nextNode;
        }

        return p1;
    }


    // Recursion
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode node = reverseList3(head).next;
        head.next.next = head;
        head.next = null;

        return node;
    }
    
}