import java.util.*;

/**
 * 排序 + 双指针
 * 
 * O(n logn) time | O(log n) space for sorting
 */

/**
 * 注意固定最大头，因为需要用 a + b > c 来判断
 * 
 * 
 * a+c>b 是必然成立的，因为 a+c≥a+b>b（注意 a 至少是 1）。
 * 
 * 同样的，b+c>a 也必然成立，因为 b+c≥a+a=2a>a（注意 a 至少是 1）。
 * 
 * 所以只需要考虑第一个式子，那么问题变成，从 nums 中选三个数，满足 1≤a≤b≤c 且 a+b>c 的方案数。
 * 
 * 为什么要固定大头?
 * 
 * 问题出在a + b == c这种情况,由于数组有序,那么这个式子有两种含义(要找ab之和大于c的):
 * a+b太小了,a是固定的,所以j要往大的方向走,即j++
 * c太大了,k往小的方向走,即k--
 * 这一个分支里不可能同时包含这两种处理方式,因为j++和k--是相向而行的,这必定会少得到一些情况。其次，就算只用其中一种处理办法，也会漏掉。事实也是如此,我学完三数之和后做三角形题就直接套了下去,发现不论用j++还是k--,示例1都会各自少一种情况。
 */
class Solution611 {
  public int triangleNumber(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    int ans = 0;

    for (int k = 2; k < n; k++) {
      int i = 0;
      int j = k - 1;
      while (i < j) {
        if (nums[i] + nums[j] > nums[k]) {
          ans += j - i;
          j -= 1;
        } else {
          i += 1;
        }
      }
    }

    return ans;
  }
}