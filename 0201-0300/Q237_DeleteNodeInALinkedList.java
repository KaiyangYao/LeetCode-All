/**
 * 前后指针 删除链表
 * 
 * 2024/09/19
 * 
 * O(1) time | O(1) space
 */
class Solution237 {
  public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }

  public void deleteNode(ListNode node) {
      node.val = node.next.val;
      node.next = node.next.next;
  }
}