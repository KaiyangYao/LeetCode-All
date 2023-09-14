
/**
 * The ugliest solution even
 * Two Pointer
 * O(m+n) time | O(1) spacr
 */
class Solution004_01 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m == 0 && n == 0)
            return 0.0;
        int end = (m + n) / 2;
        boolean isEven = (m + n) % 2 == 0;
        int p1 = 0, p2 = 0;
        int count = 0;
        while (p1 < m && p2 < n && count < end - 1) {
            if (nums1[p1] <= nums2[p2]) {
                p1++;
                count++;
            } else {
                p2++;
                count++;
            }
        }

        while (count < end - 1) {
            if (p1 < m) {
                p1++;
            } else {
                p2++;
            }
            count++;
        }

        double ans = -1;
        if (p1 < m && p2 < n) {
            if (nums1[p1] < nums2[p2]) {
                ans = nums1[p1++];
            } else {
                ans = nums2[p2++];
            }
        } else if (p1 < m) {
            ans = nums1[p1++];
        } else {
            ans = nums2[p2++];
        }

        double next = Integer.MIN_VALUE;
        if (p1 < m && p2 < n) {
            if (nums1[p1] < nums2[p2]) {
                next = nums1[p1++];
            } else {
                next = nums2[p2++];
            }
        } else if (p1 < m) {
            next = nums1[p1++];
        } else if (p2 < n) {
            next = nums2[p2++];
        }

        ans = isEven ? (ans + next) / 2.0 : (next == Integer.MIN_VALUE ? ans : next);

        return ans;
    }
}