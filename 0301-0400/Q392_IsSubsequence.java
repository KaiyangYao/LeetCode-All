/*
 * Two pointer
 * 
 * O(m+n) time (m = len(s), n = len(t))
 * O(1) space
 * 
 * 2022/11/15, 2023/01/25, 2023/08/30
 */
class Solution392_01 {
    public boolean isSubsequence(String s, String t) {
        int p1 = 0;
        int p2 = 0;
        while (p1 < s.length() && p2 < t.length()) {
            if (s.charAt(p1) == t.charAt(p2)) {
                p1++;
            }
            p2++;
        }

        return p1 == s.length();
    }
}

/**
 * DP 进阶 (for > 10亿个 s)
 * O(n) time for each comparasion after the O(m) preprocessing
 */
class Solution_02 {
    public boolean isSubsequence(String s, String t) {
        t = " " + t;
        int n = t.length();
        int[][] dp = new int[n][26];
        for (int i = 0; i < 26; i++) {
            int p = -1;
            for (int j = n - 1; j >= 0; j--) {
                dp[j][i] = p;
                if (t.charAt(j) == 'a' + i) {
                    p = j;
                }
            }
        }

        int i = 0;
        for (char ch : s.toCharArray()) {
            i = dp[i][ch - 'a'];
            if (i == -1) return false;
        }

        return true;
    }
}