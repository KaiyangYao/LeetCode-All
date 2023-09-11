import java.util.*;

/**
 * Binary Search + Two Pointer
 * 2023/09/11
 */

/**
 * O(logn + k) time | O(1) space
 */
class Solution658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int mid = getClosest(arr, x);
        System.out.println(mid);
        if (mid + 1 < n && Math.abs(arr[mid + 1] - x) < Math.abs(arr[mid] - x)) {
            mid = mid + 1;
        }
        int left = mid - 1, right = mid + 1;
        while (right - left - 1 < k) { // Don't include left and right
            if (left >= 0 && right < n) {
                if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                    left--;
                } else {
                    right++;
                }
            } else if (left >= 0) {
                left--;
            } else {
                right++;
            }
        }

        System.out.println(left);
        System.out.println(right);

        List<Integer> ans = new ArrayList<>();
        for (int i = left + 1; i <= right - 1; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }

    private int getClosest(int[] arr, int x) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else if (arr[mid] > x) {
                right = mid - 1;
            }
        }

        return right < 0 ? 0 : right; // The last one that's smaller than x.
    }
}