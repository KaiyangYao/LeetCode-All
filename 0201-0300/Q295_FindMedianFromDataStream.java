import java.util.*;

/*
 * PriorityQueue (heap)
 * 
 * addNum: O(log(n)) time
 * findMedian: O(1) time
 * 
 * O(1) space
 * 
 * 2022/11/12
 */
class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
        // left = new PriorityQueue<>((a, b) -> b - a);
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (left.size() == right.size()) {
            if (left.isEmpty() || num <= right.peek()) {
                left.add(num);
            } else {
                left.add(right.poll());
                right.add(num);
            }
        } else {
            if (num < left.peek()) {
                right.add(left.poll());
                left.add(num);
            } else if (num >= left.peek()) {
                right.add(num);
            }
        }
    }
    
    public double findMedian() {
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return left.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */