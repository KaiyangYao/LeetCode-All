import java.util.*;

/**
 * Heap / Priority Queue
 * 2023/09/17
 */

/**
 * O(n log candidates) time | O(candidates) space
 */
class Solution2462 {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(candidates);
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(candidates);

        int nextLeft = candidates;
        int nextRight = Math.max(nextLeft - 1, n - candidates - 1);

        for (int i = 0; i < nextLeft; i++) {
            pq1.offer(costs[i]);
        }
        for (int i = n - 1; i > nextRight; i--) {
            pq2.offer(costs[i]);
        }

        long ans = 0;
        for (int i = 0; i < k; i++) {
            if (!pq1.isEmpty() && !pq2.isEmpty()) {
                if (pq1.peek() <= pq2.peek()) {
                    ans += pq1.poll();
                    if (nextLeft <= nextRight) {
                        pq1.offer(costs[nextLeft++]);
                    }
                } else {
                    ans += pq2.poll();
                    if (nextLeft <= nextRight) {
                        pq2.offer(costs[nextRight--]);
                    }
                }
            } else if (!pq1.isEmpty()) {
                ans += pq1.poll();
                if (nextLeft <= nextRight) {
                    pq1.offer(costs[nextLeft++]);
                }
            } else {
                ans += pq2.poll();
                if (nextLeft <= nextRight) {
                    pq2.offer(costs[nextRight--]);
                }
            }

        }

        return ans;
    }
}