/*
 * 缩减空间
 * 
 * O(n) time | O(1) space
 * 
 * 类似: #11, #240
 * 
 */
class Solution167 {
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int left = 0;
            int right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[left] + numbers[right];
                if (sum == target) {
                    break;
                } else if (sum < target) {
                    left += 1;
                } else {
                    right -= 1;
                }
            }
            return new int[] { left + 1, right + 1 };
        }
    }
}