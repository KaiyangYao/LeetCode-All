/*
 * 剑指 Offer 46. 把数字翻译成字符串
 * 类似青蛙跳台阶、斐波那契dp
 * 
 * O(n) time
 * O(n) space (字符串需要额外空间) | O(1) space 如果用数字求余
 * 
 * 2023/02/03
 */
class QJZ46 {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int[] dp = new int[s.length() + 1];
        dp[0] = dp[1] = 1;
        for (int i = 1; i < s.length(); i++) {
            String group = s.substring(i-1, i+1);
            if (group.compareTo("10") >= 0 && group.compareTo("25") <= 0) {
                dp[i+1] = dp[i-1] + dp[i];
            } else {
                dp[i+1] = dp[i];
            }
        }
        return dp[s.length()];
    }
}