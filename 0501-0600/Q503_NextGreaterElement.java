import java.util.*;

/*
 * Monotonic Stack 模板题
 * 
 * O(n) time (loop the array once) (每个元素最多被pop 一次，所以是O(1))
 * O(n) space (the result array)
 * 
 * last: #496
 * 
 * 2022/11/09
 */

class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[n];
        
        for (int i = 2 * n - 2; i >= 0; i--) {
            int currIndex = i % n;
            int currNum = nums[currIndex];
            if (stack.isEmpty()) {
                stack.push(currNum);
                result[currIndex] = -1;
                continue;
            }
            
            while (!stack.isEmpty() && stack.peek() <= currNum) {
                stack.pop();
            }
            
            result[currIndex] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(currNum);
        }
        
        return result;
    }
}