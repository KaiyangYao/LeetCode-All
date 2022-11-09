/*
 * Two pointer
 * 
 * O(m+n) time | O(1) space
 * 
 * Similar: #2
 * 
 * 2022/11/06
 */
class Solution021 {
    public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode pre = new ListNode(-1);
        ListNode curr = pre;
        
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                curr.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            curr = curr.next;
        }
        
        if (list1 != null) {
            curr.next = list1;
        }
        if (list2 != null) {
            curr.next = list2;
        }
        
        return pre.next;
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