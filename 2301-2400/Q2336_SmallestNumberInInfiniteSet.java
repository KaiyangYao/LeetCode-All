import java.util.*;

/**
 * Priority Queue
 * 2023/09/16
 */

/**
 * min前面都是被污染过的，如过加回来，需要用pq
 */
class SmallestInfiniteSet {
    int min;
    PriorityQueue<Integer> pq;

    public SmallestInfiniteSet() {
        min = 1;
        pq = new PriorityQueue<>();
    }

    public int popSmallest() {
        if (!pq.isEmpty()) {
            return pq.poll();
        }
        return min++;
    }

    public void addBack(int num) {
        if (num < min && !pq.contains(num)) {
            pq.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */