/* 
 * 20240904
 * 定长滑动窗口
 * 
 * O(n) time | O(1) space
 * 
*/
class Solution1343 {
  public int numOfSubarrays(int[] arr, int k, int threshold) {
    int targetSum = threshold * k;
    int sum = 0;
    int ans = 0;

    for (int i = 0; i < k; i++) {
      sum += arr[i];
    }

    if (sum >= targetSum) {
      ans += 1;
    }

    for (int i = k; i < arr.length; i++) {
      sum += arr[i];
      sum -= arr[i - k];
      if (sum >= targetSum) {
        ans += 1;
      }
    }

    return ans;
  }
}