import java.util.*;

/**
 * 递减单调栈
 * 2023/10/26
 */

/**
 * O(n) time | O(n) space
 */
class Solution853 {
    public class Car {
        int pos;
        int speed;

        public Car(int pos, int speed) {
            this.pos = pos;
            this.speed = speed;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        Car[] arr = new Car[position.length];
        for (int i = 0; i < position.length; i++) {
            arr[i] = new Car(position[i], speed[i]);
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a.pos, b.pos));
        Deque<Double> stack = new ArrayDeque<>();

        for (int i = 0; i < position.length; i++) {
            double t = (target - arr[i].pos) / (double) arr[i].speed;
            while (!stack.isEmpty() && stack.peek() <= t) {
                stack.pop();
            }
            stack.push(t);
        }

        return stack.size();
    }
}