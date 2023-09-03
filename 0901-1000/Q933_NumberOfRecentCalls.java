import java.util.*;

/**
 * Queue
 * 2023/09/01
 */
class RecentCounter {
    Queue<Integer> queue;
    int count;

    public RecentCounter() {
        queue = new ArrayDeque<>();
        count = 0;
    }

    public int ping(int t) {
        queue.offer(t);
        count++;
        while (queue.peek() + 3000 < t) {
            queue.poll();
            count--;
        }
        return count;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */