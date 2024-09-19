/*
 * fast-slow pointer
 * 
 * O(n) time, O(1) space
 * 
 * 2022/11/07
 * 2024/09/18
 */

class Solution141 {
  class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
  }

  public boolean hasCycle(ListNode head) {
      ListNode slow = head;
      ListNode fast = head;
      
      while (fast != null && fast.next != null) {
          slow = slow.next;
          fast = fast.next.next;
          if (slow == fast) {
              return true;
          }
      }
      
      return false;
  }
}