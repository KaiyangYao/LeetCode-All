/**
 * 前后指针 删除链表
 * 
 * 2024/09/19
 * 
 * O(n) time | O(1) space
 */
class Solution {
  public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode dummy = new ListNode();
      dummy.next = head;

      ListNode left = dummy;
      ListNode right = dummy;
      for (int i = 0; i < n + 1; i++) {
          right = right.next;
      }

      while (right != null) {
          left = left.next;
          right = right.next;
      }

      left.next = left.next.next;

      return dummy.next;
  }
}