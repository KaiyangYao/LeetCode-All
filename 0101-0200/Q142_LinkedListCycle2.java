/*
 * fast-slow pointer
 * 
 * O(n) time, O(1) space
 * 
 * - a items in path, b items in cycle.  f = 2s,  f - s = nb(整数倍的环),  2s = s + nb,  s = nb
   - 环入口: a + nb
   - 所以相遇后slow还要再走a到环入口
   - 新指针指向head
   - 从head开始走a步 (head和slow相交时候)
 * 
 * 2022/11/07
 */
class Solution142 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode answer = head;
        
        while (fast != null) {
            if (fast.next == null) {
                return null;
            }
            
            slow = slow.next;
            fast = fast.next.next;  // Might be null, doesn't matter
            if (slow == fast) {
                while (true) {
                    if (answer == slow) {
                        return answer;
                    }
                    answer = answer.next;
                    slow = slow.next;
                }
            }
        }
        
        return null;
    }
}