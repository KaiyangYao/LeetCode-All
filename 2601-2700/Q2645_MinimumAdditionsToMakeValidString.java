/**
 * 2023/01/10
 */

/**
 * 算周期
 * O(n) time | O(1) space
 * 周期数 * 3 是总数
 */
class Solution2645_01 {
    public int addMinimum(String word) {
        int group = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) <= word.charAt(i - 1)) {
                group++;
            }
        }
        return group * 3 - word.length();
    }
}

/**
 * 算相邻两个字母之间要插入几个，然后再加上头尾
 */
class Solution2645_02 {
    public int addMinimum(String word) {
        // 相邻字母:
        // a c -> (c - a - 1 + 3) % 3 = 1 -> 需要加1个
        // c b -> (a - c - 1 + 3) % 3 = 1 -> 需要加1个
        // 公式: x y -> (y - x + 2) % 3

        // 头:
        // s[0] - 'a'

        // 尾:
        // 'c' = s[n - 1]

        // 合并:
        // s[0] - s[n - 1] + 2

        char[] c = word.toCharArray();
        int count = c[0] - c[word.length() - 1] + 2;
        for (int i = 1; i < word.length(); i++) {
            count += (c[i] - c[i - 1] + 2) % 3;
        }
        return count;
    }
}