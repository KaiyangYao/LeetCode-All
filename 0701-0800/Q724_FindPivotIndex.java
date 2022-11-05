import java.util.*;

/*
 * o(n) time | O(1) space
 * 
 * Cannot use two pointer because the array is not sorted! (Don't know when to move the pointers)
 * 2022/11/05
 */
class Solution724 {
    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        
        return -1;
    }
}