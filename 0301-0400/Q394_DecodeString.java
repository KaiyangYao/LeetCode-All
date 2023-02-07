import java.util.*;

/*
 * 双栈解法
 * 
 * O(n) time | O(n) space
 * 
 * 2023/02/06
 */
class Solution394 {
    public String decodeString(String s) {
        int i = 0;
        char[] arr = s.toCharArray();
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<StringBuilder> stack2 = new ArrayDeque<>();
        stack2.push(new StringBuilder());
        while (i < arr.length) {
            char c = arr[i];
            if (c <= '9' && c >= '0') {
                int p = i;
                while (i < arr.length && arr[i] <= '9' && arr[i] >= '0') {
                    i++;
                }
                stack.push(Integer.parseInt(s.substring(p, i)));
                stack2.push(new StringBuilder());
            } else if (c >= 'a' && c <= 'z') {
                stack2.peek().append(c);
            } else if (c == ']') {
                int times = stack.pop();
                String lastSb = stack2.pop().toString();
                stack2.peek().append(lastSb.repeat(times));
            }
            i++;
        }
        return stack2.peek().toString();
    }
}