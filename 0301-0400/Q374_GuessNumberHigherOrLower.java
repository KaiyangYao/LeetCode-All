/**
 * Binary Search
 * 2023/09/08
 */

/**
 * O(log n) time | O(1) space
 */

/**
 * Forward declaration of guess API.
 * 
 * @param num your guess
 * @return -1 if num is higher than the picked number
 *         1 if num is lower than the picked number
 *         otherwise return 0
 *         int guess(int num);
 */

class GuessGame {
    public int guess(int x) {
        return -1;
    }
}

class Solution374 extends GuessGame {
    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) == -1) {
                right = mid - 1;
            } else if (guess(mid) == 1) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}