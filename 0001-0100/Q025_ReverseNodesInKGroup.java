/**
 * Reverse Linked List
 * 
 * O(n) time | O(1) space
 * 
 * 20240918
 * 
 * Similar to Q092!
 */

class Solution {
  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public ListNode reverseKGroup(ListNode head, int k) {
      // Step 1: find number of loops we need to flip
      int n = 0;
      ListNode temp = head;
      while (temp != null) {
          temp = temp.next;
          n++;
      }

      int numLoops = n / k;
      
      // Step 2: Do the flip. Same as Q092
      ListNode dummy = new ListNode();
      dummy.next = head;
      ListNode p0 = dummy;
      ListNode prev = null, curr = head;

      for (int i = 0; i < numLoops; i++) {
          for (int j = 0; j < k; j++) {
              ListNode next = curr.next;
              curr.next = prev;
              prev = curr;
              curr = next;
          }

          ListNode nextP0 = p0.next;
          p0.next.next = curr;
          p0.next = prev;
          p0 = nextP0;
      }

      return dummy.next;
  }
}