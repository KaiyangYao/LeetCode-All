/**
 * 分组循环
 * 2023/11/28
 */

/**
 * O(n) time
 * O(1) space
 */
class Solution1446 {
    public int maxPower(String s) {
        int n = s.length();
        int ans = 0;
        int i = 0;
        while (i < n) {
            char c = s.charAt(i);
            int j;
            for (j = i; j < n; j++) {
                if (s.charAt(j) != c) {
                    break;
                }
            }

            ans = Math.max(ans, j - i);
            i = j;
        }

        return ans;
    }
}