/**
 * Linked List Deletion
 * 根据题目模拟
 * 
 * 2024/09/19
 */

/**
 * O(n + m) time | O(1) space
 * n = len(list1), m = len(list2)
 */
class Solution1669 {
  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
      ListNode start = list1;
      for (int i = 0; i < a - 1; i++) {
          start = start.next;
      }

      ListNode end = start;
      for (int i = 0; i < b - a + 2; i++) {
          end = end.next;
      }

      start.next = list2;

      ListNode temp = list2;
      while (temp.next != null) {
          temp = temp.next;
      }
      temp.next = end;

      return list1;
  }
}