import java.util.*;

/**
 * 数学
 * 2023/01/17
 * 
 * 这道题要求的是，我们使数组的每一位非0数都相同，至少要拿出多少魔法豆。
 * 也就是说，假设我们最终的那个非 0 数为 num。那么比 num 小的元素不能增加，只能变成 0；
 * 比 num 大元素则都变成 num。
 *  作者：画图小匠
 * 链接：https://leetcode.cn/problems/removing-minimum-number-of-magic-beanssolutions/2608877/javapython3cpai-xu-qian-hou-zhui-he-shu-yv5sg/
 */

/**
 * O(n logn) time | O(log n) space for sorting
 */
class Solution2171 {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        int n = beans.length;
        long ans = Long.MAX_VALUE;
        long sum = 0;
        for (int bean : beans) {
            sum += bean;
        }

        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, sum - (long) beans[i] * (n - i));
        }

        return ans;
    }
}