import java.util.*;

/*
 * Monotonic Stack (单调栈)
 * 
 * O(n) time  (calling next n times)
 * O(n) space (每个元素都被 push 入栈了一次，而最多会被 pop 一次，没有任何冗余操作。所以总的计算规模是和元素规模 n 成正比的，也就是 O(n) 的复杂度。)
 * 
 * 2022/11/09
 */
class StockSpanner {
    Deque<int[]> stack;

    public StockSpanner() {
        stack = new ArrayDeque<>();
    }
    
    public int next(int price) {
        if (stack.isEmpty()) {
            stack.push(new int[]{price, 1});
            return 1;
        }
        
        int day = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            day += stack.peek()[1];
            stack.pop();
        }
        stack.push(new int[]{price, day});
        
        return day;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */