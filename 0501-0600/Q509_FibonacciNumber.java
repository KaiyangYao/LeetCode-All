/*
 * Multiple Solutions, see below
 * 
 * 2023/01/29
 */
class Solution509 {
    // 1. 暴力递归
    // O(2^n) time  (More precisely, O(1.618^n)), fib(n) has ~n levels of recursion binary tree
    // O(n) space
    public int fib1(int n) {
        if (n == 0 || n == 1) return n;
        return fib1(n - 1) + fib1(n - 2);
    }


    // 2. 递归 + memo数组 (自顶向下递归 + 自底向上回溯)
    // O(n) time
    // O(n) space
    public int fib2(int n) {
        int[] memo = new int[n+1];
        return helper(memo, n);
    }
    private int helper(int[] memo, int n) {
        if (n == 0 || n == 1) return n;
        if (memo[n] != 0) return memo[n];
        memo[n] = helper(memo, n-1) + helper(memo, n);
        return memo[n];
    }


    // 3. Dynamic Programming 自底向上迭代
    // O(n) time
    // O(n) space
    public int fib3(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n+1];
        dp[0] = 0; dp[1] = 1;
        // 状态转移
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    // 4. Advanced DP (only use a,b, not the whole array)
    // O(n) time
    // O(1) space
    public int fib4(int n) {
        if (n < 2) {
            return n;
        }
        int a = 0;
        int b = 1;
        int sum = a + b;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }
}