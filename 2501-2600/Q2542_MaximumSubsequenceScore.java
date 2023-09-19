import java.util.*;

/**
 * Heap / Priority Queue
 * 2023/09/17
 * 
 * 反悔贪心: 有约束，多维求最佳常用的一种方式。其中 A 可以是 除法/加法等，B 为单个元素（最大/最小值）
 */

/**
 * O(n log n) time
 * O(n) space   (Max(n, log n))
 */
class Solution2542 {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums2.length;
        Integer[] index = new Integer[n]; // Array.sort custom comparator can not take primitive type!
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> nums2[b] - nums2[a]);

        long sum = 0l;
        long ans = 0l;
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            pq.offer(nums1[index[i]]);
            sum += nums1[index[i]];
        }
        ans = sum * nums2[index[k - 1]];

        for (int i = k; i < n; i++) {
            int next = nums1[index[i]];
            if (next > pq.peek()) {
                sum -= pq.poll();
                sum += next;
                pq.offer(next);
                ans = Math.max(ans, sum * nums2[index[i]]);
            }
        }

        return ans;
    }
}