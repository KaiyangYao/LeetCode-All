 /*
 * 
 * O(m+n) time | O(1) space
 * 
 * 2023/02/05
 */
class Solution160 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int a = 0;
        int b = 0;
        ListNode p1 = headA;
        ListNode p2 = headB;
        while(p1 != null) {
            a++;
            p1 = p1.next;
        }
        while(p2 != null) {
            b++;
            p2 = p2.next;
        }

        for (int i = 0; i < Math.abs(a-b); i++) {
            if (a < b) {
                headB = headB.next;
            } else {
                headA = headA.next;
            }
        }

        while (headA != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }
}