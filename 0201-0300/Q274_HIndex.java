import java.util.*;

/**
 * 1. Binary Search
 * 2. Sort + Array
 * 2023/09/10
 */

/**
 * Solution 1: Binary Search
 * O(n logn) time | O(1) space
 */
class Solution274_01 {
    public int hIndex(int[] citations) {
        int left = 0, right = citations.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = findCount(mid, citations);
            if (count >= mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private int findCount(int curr, int[] citations) {
        int count = 0;
        for (int c : citations) {
            if (c >= curr) {
                count++;
            }
        }
        return count;
    }
}

/*
 * Solution 2: Sort + Array
 * 
 * O(nlog(n)) time
 * O(log(n)) space
 * 
 * 2023/02/24
 */
class Solution274_02 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        int i = citations.length - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }
}