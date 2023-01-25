import java.util.*;

/*
 * 剑指 Offer 09. 用两个栈实现队列
 * 
 * 
 * appendTail: O(1) time
 * deleteHead: Amortized O(1) time
 * 
 * 2023/01/25
 */
class QJZ09 {
    class CQueue {
        Deque<Integer> stack1;
        Deque<Integer> stack2;
    
        public CQueue() {
            stack1 = new ArrayDeque<>();
            stack2 = new ArrayDeque<>();
        }
        
        public void appendTail(int value) {
            stack1.push(value);
        }
        
        public int deleteHead() {
            if (!stack2.isEmpty()) {
                return stack2.pop();
            } else if (!stack1.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
                return stack2.pop();
            }
            return -1;
        }
    }
    
    /**
     * Your CQueue object will be instantiated and called as such:
     * CQueue obj = new CQueue();
     * obj.appendTail(value);
     * int param_2 = obj.deleteHead();
     */
}

