import java.util.*;

/*
 * Priority Queue
 * 
 * O(n log(n)) time  (n是石头数量。每次从队列中取出元素需要花费 O(log⁡n) 的时间，最多共需要粉碎 n−1 次石头。)
 * O(n) space
 * 
 * 2023/02/07
 */
class Solution1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        for (int stone: stones) {
            queue.offer(stone);
        }
        while (queue.size() > 1) {
            int y = queue.poll();
            int x = queue.poll();
            if (x != y) {
                queue.offer(y - x);
            }
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }
}