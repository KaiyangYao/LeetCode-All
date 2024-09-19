/*
 * 快慢指针 + 反转链表
 * 
 * O(n) time, O(1) space
 * 
 * 2024/09/18
 * 
 * Similar: Q143
 */
class Solution234 {
  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public boolean isPalindrome(ListNode head) {
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

      // 3. 操作 (检查回文)
      ListNode p1 = head;
      ListNode p2 = prev;
      while (p1 != null && p2 != null) {
          if (p1.val != p2.val) {
              return false;
          }
          p1 = p1.next;
          p2 = p2.next;
      }

      return true;
  }
}