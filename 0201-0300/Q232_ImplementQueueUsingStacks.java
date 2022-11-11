import java.util.*;

/*
 * in/out stack
 * 
 * O(1) time 均摊 for pop() 和 peek()
 *   均摊：空了才会挪动。一般n个data挪动一次O(n), 所以单次是O(n)/n = O(1)
 * O(n) space  O(n*2) = O(n)
 * 
 * 2022/11/11
 */
class MyQueue {
    Deque<Integer> in;
    Deque<Integer> out;

    public MyQueue() {
        in = new ArrayDeque<>();
        out = new ArrayDeque<>();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        if (out.isEmpty()) {
            inToOut();
        }
        return out.pop();
    }
    
    public int peek() {
        if (out.isEmpty()) {
            inToOut();
        }
        return out.peek();
    }
    
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
    
    private void inToOut() {
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */