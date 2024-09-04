/*
 * 缩减空间模板题
 * 
 * O(n) time | O(1) space
 * 
 * 类似: #167, #240
 * 
 */
class Solution011_01 {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            if (area > max) {
                max = area;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}

class Solution011_02 {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int result = Math.min(height[i], height[j]) * (j - i);
        while (i < j) {
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
            result = Math.max(result, Math.min(height[i], height[j]) * (j - i));
        }
        return result;
    }
}