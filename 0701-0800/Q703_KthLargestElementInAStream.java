import java.util.*;

/**
 * Heap / Priority Queue
 * 2023/09/17
 */

/**
 * O(n log k) time
 * O(k) space
 */
class KthLargest {
    PriorityQueue<Integer> pq;
    int size;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>(k);
        size = k;
        for (int i = 0; i < k && i < nums.length; i++) {
            pq.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > pq.peek()) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }
    }

    public int add(int val) {
        if (pq.size() < size) {
            pq.offer(val);
        } else if (val > pq.peek()) {
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */