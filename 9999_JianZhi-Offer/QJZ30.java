import java.util.*;

/*
 * 剑指 Offer 30. 包含min函数的栈
 * 
 * O(1) time for all methods
 * O(n) space
 * 
 * Also at LeetCode Q155
 * 
 * 2023/01/25
 */
class QJZ30 {
    class MinStack {
        Deque<Integer> stack;
        Deque<Integer> minStack;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new ArrayDeque<>();
            minStack = new ArrayDeque<>();
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty() || x <= minStack.peek()) {
                minStack.push(x);
            }
        }

        // Note here: We store Integer in the stack, so we should use .equals instead of ==
        // We can only use == in the interval [-128, 127]! See the Integer Class Implementation
        public void pop() {
            if (minStack.peek().equals(stack.pop())) {
                minStack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.min();
     */
}
