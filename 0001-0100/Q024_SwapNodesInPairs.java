/**
 * Reverse Linked List
 * 
 * O(n) time | O(1) space
 * 
 * 20240918
 */
class Solution024 {
  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public ListNode swapPairs(ListNode head) {
      ListNode dummy = new ListNode();
      dummy.next = head;

      ListNode p0 = dummy, node1, node2, node3;
      ListNode curr = head;
      while (curr != null && curr.next != null) {
          node1 = curr;
          node2 = node1.next;
          node3 = node2.next;

          p0.next = node2;
          node2.next = node1;
          node1.next = node3;

          p0 = node1;
          curr = node3;
      }

      return dummy.next;
  }
}