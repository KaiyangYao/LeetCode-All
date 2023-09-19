import java.util.*;

/**
 * Solution 1:
 * QuickSort 应用: QuickSelect
 * 2023/09/16
 */
class Solution215_01 {
    Random rand = new Random();

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (true) {
            int pivotIndex = partition(nums, left, right);
            if (pivotIndex == n - k) {
                return nums[pivotIndex];
            } else if (pivotIndex > n - k) {
                right = pivotIndex - 1;
            } else {
                left = pivotIndex + 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        int randIndex = left + rand.nextInt(right - left + 1);
        swap(nums, left, randIndex);
        int pivot = nums[left];
        int p1 = left + 1, p2 = right;
        while (p1 <= p2) {
            while (p1 <= p2 && nums[p1] < pivot) {
                p1++;
            }
            while (p1 <= p2 && nums[p2] > pivot) {
                p2--;
            }

            if (p1 >= p2) {
                break;
            }
            swap(nums, p1, p2);
            p1++;
            p2--;
        }
        swap(nums, left, p2);
        return p2;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}

/**
 * Solution 2: Priority Queue
 * 维护一个长度为k的最小堆 (nums里最大的k个)，最小的那个就是第k大的数
 * 如果后面的数 > pq.peek(), 就把当前这个poll()，然后再offer新的
 */

/**
 * O(n log k) time  (堆内元素调整消耗 log k)
 * O(k) spacr
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> Integer.compare(a, b));
        for (int i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > pq.peek()) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        return pq.peek();
    }
}