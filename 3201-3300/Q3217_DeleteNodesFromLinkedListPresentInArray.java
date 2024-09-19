import java.util.*;

/**
 * Linked List Deletion
 * 
 * 2024/09/19
 */

/**
 * O(n + m) time | O(n) space
 * n = len(nums), m = len(LinkedList)
 */
class Solution3217 {
  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public ListNode modifiedList(int[] nums, ListNode head) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }

    ListNode dummy = new ListNode();
    dummy.next = head;

    ListNode curr = dummy;
    while (curr.next != null) {
      if (set.contains(curr.next.val)) {
        curr.next = curr.next.next;
      } else {
        curr = curr.next;
      }
    }

    return dummy.next;
  }
}