/**
 * Linked List
 *
 * 2024/09/18
 * 
 * 也可以用反转链表 + 两数相加做!! (Q206 + Q2 or Q445)
 */

 /**
  * O(n) time | O(1) space
  */
class Solution2816 {
  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public ListNode doubleIt(ListNode head) {
      ListNode dummy = new ListNode();
      ListNode ans = dummy;

      if (head.val > 4) {
          ans.next = new ListNode(1);
          ans = ans.next;
      }

      ListNode curr = head;
      while (curr != null) {
          ListNode next = curr.next;
          int carry = next == null || next.val <= 4 ? 0 : 1;
          ans.next = new ListNode(curr.val * 2 % 10 + carry);
          ans = ans.next;
          curr = curr.next;
      }

      return dummy.next;
  }
}