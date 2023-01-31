import java.util.*;
/**
 * 状态：最小编辑距离
 * 选择：插入 / 删除 / 替换
 * 定义：dp[i][j] 返回 word1[0..i-1] 和 word2[0..j-1] 的最小编辑距离
 * base case：如果一个word是空，最小编辑距离是另一个word的长度
 */

// 1. 暴力递归
class Solution072_M1 {
    public int minDistance(String word1, String word2) {
        return dp(word1.length()-1, word2.length()-1, word1, word2);
    }
    // 定义：dp(i, j) 返回 word1[0..i] 和 word2[0..j] 的最小编辑距离
    // 状态：最小编辑距离
    private int dp(int i, int j, String word1, String word2) {
        // base case
        if (i == -1) return j + 1;  // i到头了，能做的只能是把j前面所有的字符都删除掉
        if (j == -1) return i + 1;
        // 状态转移
        if (word1.charAt(i) == word2.charAt(j)) {
            return dp(i-1, j-1, word1, word2);
        } else {
            return Math.min(
                Math.min(
                    dp(i-1, j, word1, word2),
                    dp(i, j-1, word1, word2)
                ),
                dp(i-1, j-1, word1, word2)
            ) + 1;
        }
    }
}

// 2. 备忘录优化
class Solution072_M2 {
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length()][word2.length()];
        for (int[] row: memo) {
            Arrays.fill(row, -1);
        }
        return dp(word1.length()-1, word2.length()-1, word1, word2, memo);
    }
    // 定义：dp(i, j) 返回 word1[0..i] 和 word2[0..j] 的最小编辑距离
    // 状态：函数的参数
    private int dp(int i, int j, String word1, String word2, int[][] memo) {
        // base case
        if (i == -1) return j + 1;  // i到头了，能做的只能是把j前面所有的字符都删除掉
        if (j == -1) return i + 1;

        // 查备忘录
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        // 状态转移
        if (word1.charAt(i) == word2.charAt(j)) {
            memo[i][j] = dp(i-1, j-1, word1, word2, memo);
        } else {
            memo[i][j] =  Math.min(
                Math.min(
                    dp(i-1, j, word1, word2, memo),
                    dp(i, j-1, word1, word2, memo)
                ),
                dp(i-1, j-1, word1, word2, memo)
            ) + 1;
        }
        return memo[i][j];
    }
}

// 3. 自底向上迭代
class Solution {
    // 定义：dp[i][j] 返回 word1[0..i-1] 和 word2[0..j-1] 的最小编辑距离 (注意细微差别)
    // 状态：dp数组的索引
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];

        // 因为是数组，所以base case是0不是1，因此总长度要+1
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }


        // 自底向上求解
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {  // 注意这里索引的转化
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(
                        Math.min(dp[i-1][j], dp[i][j-1]),
                        dp[i-1][j-1]
                    );
                }
            }
        }

        // 存储着整个 s1 和 s2 的最小编辑距离
        return dp[m][n];
    }
}