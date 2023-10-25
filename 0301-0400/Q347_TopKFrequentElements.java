import java.util.*;

/**
 * Priority Queue
 * O(n logk) time | O(n) space
 */
class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<int[]> values = new ArrayList<>();
        for (int key : map.keySet()) {
            values.add(new int[] { key, map.get(key) });
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int i = 0; i < values.size(); i++) {
            pq.offer(values.get(i));
            while (pq.size() > k) {
                pq.poll();
            }
        }

        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
}