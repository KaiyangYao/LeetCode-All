/*
 * Two pointer
 * 
 * O(m+n) time | O(1) space
 * 
 * 2022/11/06
 */
class Solution21 {
    public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode curr = prehead;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        
        if (l1 != null) {
            curr.next = l1;
        }
        
        if (l2 != null) {
            curr.next = l2;
        }
        
        return prehead.next;
    }
}


/*
 * Recursion
 * 
 * O(m+n) time | O(m+n) space
 */

// class Solution {
//     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//         if (l1 == null) {
//             return l2;
//         } else if (l2 == null) {
//             return l1;
//         } else if (l1.val < l2.val) {
//             l1.next = mergeTwoLists(l1.next, l2);
//             return l1;
//         } else {
//             l2.next = mergeTwoLists(l1, l2.next);
//             return l2;
//         }
//     }
// }