/**
 * 异或运算模板题
 * 
 * a^0 = 0
 * a^a = 0
 * 
 * 2023/06/27
 * 
 * Similar: Q389
 */

/**
 * O(n) time | O(1) space
 */
class Solution136 {
    public int singleNumber(int[] nums) {
        // a^0 = 0
        // a^a = 0
        int result = 0;
        for (int n : nums) {
            result ^= n;
        }
        return result;
    }
}