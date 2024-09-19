/*
 * 快慢指针 + 反转链表
 * 
 * O(n) time, O(1) space
 * 
 * 2024/09/18
 * 
 * Similar: Q234
 */
class Solution143 {
  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public void reorderList(ListNode head) {
      // 1. 快慢指针 (Q141)
      ListNode mid = head;
      ListNode temp = head;
      while (temp != null && temp.next != null) {
          mid = mid.next;
          temp = temp.next.next;
      }

      // 2. 反转链表 (Q206)
      ListNode prev = null, curr = mid;
      while (curr != null) {
          ListNode next = curr.next;
          curr.next = prev;
          prev = curr;
          curr = next;
      }

      // 3. 操作
      ListNode leftHead = head;
      ListNode RightHead = prev;

      while (RightHead.next != null) {
          ListNode newLeftHead = leftHead.next;
          ListNode newRightHead = RightHead.next;
          leftHead.next = RightHead;
          RightHead.next = newLeftHead;

          leftHead = newLeftHead;
          RightHead = newRightHead;
      }
  }
}