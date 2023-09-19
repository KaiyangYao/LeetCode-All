import java.util.*;
/*
 * Multiple Solutions, see below
 * 
 * 2023/01/29
 */

/**
 * 状态：目标金额 amount
 * 选择：coins 数组中列出的所有硬币面额
 * 函数的定义：凑出总金额 amount，至少需要 coinChange(coints, amount) 枚硬币
 * base case：amount == 0 需要0枚硬币，amount < 0 不可能凑出
 * 
 * coinChange([1,2,5], 11)
 * = 1 + min (coinChange([1,2,5], 10), coinChange([1,2,5], 9),
 * coinChange([1,2,5], 6))
 */

class Solution322 {
    // 1. 暴力递归解法
    // Let amount = n, coins.length = k
    // O(x^n) time | (O(k)) space
    public int coinChange1(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem = coinChange1(coins, amount - coin);
            // 子问题无解则跳过
            if (subProblem == -1)
                continue;
            // 在子问题中选择最优解，然后 + 1
            res = Math.min(res, subProblem + 1);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    // 2. 自顶向下递归 w/ 备忘录
    // O(k)*O(n) = O(kn) time 每次调用循环k次，一共最多调用n次 (0~amount 不同种金额)
    // O(n) space
    // 备忘录
    int[] memo;

    public int coinChange2(int[] coins, int amount) {
        memo = new int[amount + 1];
        // memo 数组全部初始化为特殊值
        Arrays.fill(memo, -666);
        return dp(coins, amount);
    }

    private int dp(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;
        // 查备忘录，防止重复计算
        if (memo[amount] != -666) {
            return memo[amount];
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem = dp(coins, amount - coin);
            // 子问题无解则跳过
            if (subProblem == -1)
                continue;
            // 在子问题中选择最优解，然后 + 1
            res = Math.min(res, subProblem + 1);
        }

        // 把计算结果存入备忘录
        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memo[amount];
    }

    // 3. 自底向上迭代 DP
    // O(k n) time | O(n) space
    public int coinChange3(int[] coins, int amount) {
        // dp 数组的定义：凑出总金额amount，至少需要dp[amount]枚硬币
        int[] dp = new int[amount + 1];
        // dp 数组全部初始化为特殊值 amount + 1
        Arrays.fill(dp, amount + 1);

        // base case
        dp[0] = 0;
        // 外层 for 循环在遍历所有状态的所有取值
        for (int i = 0; i < dp.length; i++) {
            // 内层 for 循环在求所有选择的最小值
            for (int coin : coins) {
                // 子问题无解，跳过
                if (i - coin < 0)
                    continue;
                // 状态转移
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }

        // 看看金额 amount 能不能凑出来
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}