import java.util.*;

/**
 * 周赛373
 * 2023/11/28
 */

/**
 * 知识点
 * 1. 如果要sort，要用Integer[]，而不是int[]
 * 2. compare 最好用 Integer.compare()，不用 nums[a] - nums[b]，防止溢出
 * 3. Arrays.copyOfRange 和 s.substring一样，左闭右开
 * 
 * 方法:
 * 分组循环!!
 */

/*
 * O(n log n) time
 * O(log n ) space
 */
class Solution2948 {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> (Integer.compare(nums[a], nums[b])));

        int i = 0;
        int[] ans = new int[n];

        // O(n) 分组循环
        // 外层: 准备工作 + 更新答案
        // 内层: 寻找当前的末尾位置
        while (i < n) {
            int j;
            for (j = i + 1; j < n; j++) {
                if (nums[index[j]] - nums[index[j - 1]] > limit) {
                    break;
                }
            }
            Integer[] subIndex = Arrays.copyOfRange(index, i, j);
            Arrays.sort(subIndex);
            for (int si = 0; si < subIndex.length; si++) {
                ans[subIndex[si]] = nums[index[i + si]];
            }
            i = j;
        }

        return ans;
    }
}