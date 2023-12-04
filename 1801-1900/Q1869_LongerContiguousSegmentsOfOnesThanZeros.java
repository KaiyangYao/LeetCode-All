/**
 * 分组循环
 * 2023/11/29
 */

/**
 * O(n) time
 * O(1) space
 */
class Solution1869 {
    public boolean checkZeroOnes(String s) {
        int[] ans = new int[2]; // ans[0] = max0, ans[1] = max1;
        int n = s.length();
        int i = 0;
        while (i < n) {
            int j;
            for (j = i + 1; j < n; j++) {
                if (s.charAt(j) != s.charAt(j - 1)) {
                    break;
                }
            }
            ans[s.charAt(i) - '0'] = Math.max(ans[s.charAt(i) - '0'], j - i);
            i = j;
        }

        return ans[1] > ans[0];
    }
}