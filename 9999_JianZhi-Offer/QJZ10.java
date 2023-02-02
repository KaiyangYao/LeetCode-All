/*
 * 剑指 Offer 10 - DP
 * 
 * I. 斐波那契数列 (同LeetcodeQ509)
 * O(n) time | O(1) space
 * 
 * II. 青蛙跳台阶问题 (同LeetcodeQ70)
 * O(n) time | O(1) space
 * 
 * 2023/01/31
 */
class QJZ10_01 {
    /**
     * 1. 1000000007是一个质数（素数），对质数取余能最大程度避免冲突～
     * 2. int32位的最大值为2147483647，所以对于int32位来说1000000007足够大
     * 3. int64位的最大值为2^63-1，对于1000000007来说它的平方不会在int64中溢出
     * 所以在大数相乘的时候，因为(a*b)%c=((a%c)*(b%c))%c，所以相乘时两边都对1000000007取模，再保存在int64里面不会溢出
     */
    public int fib(int n) {
        if (n < 2) return n;
        int pre = 0;
        int curr = 1;
        for (int i = 2; i <= n; i++) {
            int temp = (pre + curr) % 1000000007; // 这里取模防止大数越界
            pre = curr;
            curr = temp;
        }
        return curr;
    }
}

class QJZ10_02 {
    public int numWays(int n) {
        if (n < 2) return n == 0 ? 1 : n;

        int twoStep1 = 1;
        int oneStep = 1;
        int curr;
        for (int i = 2; i <= n; i++) {
            curr = (twoStep1 + oneStep) % 1000000007;
            twoStep1 = oneStep;
            oneStep = curr;
        }
        return oneStep;
    }
}