import java.util.*;

/*
 * 剑指 Offer 06. 从尾到头打印链表
 * 
 * O(n) time, O(n) space
 * 
 * 2023/01/26
 */

// Method 1: recursion
class QJZ06 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    int[] result;
    int count = 0;
    int i = 0;

    public int[] reversePrint(ListNode head) {
        solve(head);
        return result;
    }

    public void solve(ListNode node) {
        if (node == null) {
            result = new int[count];
            return;
        }
        count++;
        solve(node.next);
        result[i++] = node.val;
    }
}


// Method 2: stack
class QJZ06V2 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    Deque<Integer> stack = new ArrayDeque<>();

    public int[] reversePrint(ListNode head) {
        while(head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }
        return result;
    }
}