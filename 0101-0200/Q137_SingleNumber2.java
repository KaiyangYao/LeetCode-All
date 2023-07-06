/**
 * Bit Manipulation
 * 
 * 2023/07/04 Global Daily
 */
/**
 * O(n) time | O(1) space
 */
class Solution137 {
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        for (int x : nums) {
            for (int i = 0; i < 32; i++) {
                if (((x >> i) & 1) == 1) {
                    count[i]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (count[i] % 3 == 1) {
                ans += (1 << i);
            }
        }

        return ans;
    }
}