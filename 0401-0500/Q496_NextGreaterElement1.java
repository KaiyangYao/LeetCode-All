import java.util.*;

/*
 * Monotonic Stack 模板题
 * 
 * O(m+n) time (loop each array once)
 * O(n) space (the hashmap)
 * 
 * next: #503
 * 
 * 2022/11/09
 */
class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = nums2.length - 1; i >= 0; i--) {
            int currNum = nums2[i];
            if (stack.isEmpty()) {
                stack.push(currNum);
                map.put(currNum, -1);
                continue;
            }
            
            while (!stack.isEmpty() && stack.peek() <= currNum) {
                stack.pop();
            }
            
            map.put(currNum, stack.isEmpty() ? -1 : stack.peek());
            stack.push(currNum);                   
        }
        
        int[] answer = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            answer[i] = map.get(nums1[i]);
        }
        
        return answer;
    }
}