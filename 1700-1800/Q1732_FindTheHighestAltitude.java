/**
 * 2023/08/30
 */

/**
 * O(n) time | O(1) space
 */
class Solution1732 {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int curr = 0;
        for (int i = 0; i < gain.length; i++) {
            curr += gain[i];
            max = Math.max(max, curr);
        }
        return max;
    }
}