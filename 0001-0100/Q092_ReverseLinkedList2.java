/**
 * Reverse Linked List
 * 
 * O(n) time | O(1) space
 * 
 * 20240918
 * 
 * More difficult: Q025!
 */

class Solution092 {
  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public ListNode reverseBetween01(ListNode head, int left, int right) {
    ListNode dummy = new ListNode();
    dummy.next = head;

    ListNode p0 = dummy;
    for (int i = 0; i < left - 1; i++) {
        p0 = p0.next;
    }

    ListNode prev = null, curr = p0.next;
    for (int i = 0; i < right - left + 1; i++) {
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }

    p0.next.next = curr;
    p0.next = prev;

    return dummy.next;
  }

  public ListNode reverseBetween02(ListNode head, int left, int right) {
      ListNode dummy = new ListNode();
      dummy.next = head;

      ListNode curr = head, prev = dummy, next;
      ListNode start;
      ListNode reverseStart;

      for (int i = 0; i < left - 1; i++) {
          prev = curr;
          curr = curr.next;
      }

      start = prev;
      reverseStart = curr;

      for (int i = 0; i < right - left + 1; i++) {
          next = curr.next;
          curr.next = prev;
          prev = curr;
          curr = next;
      }

      start.next = prev;
      reverseStart.next = curr;

      return dummy.next;
  }
}