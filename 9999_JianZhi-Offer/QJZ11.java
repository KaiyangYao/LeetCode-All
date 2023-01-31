/*
 * 剑指 Offer 11. 旋转数组的最小数字
 * 
 * O(log(n)) time | O(1) space
 * 
 * 2023/01/28
 */
class QJZ11 {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (numbers[mid] < numbers[right]) {
                right = mid;  // 注意这里的判断的信息只能知道numbers[right]可能是最小的
            } else if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] == numbers[right]) {
                /**
                 * 此操作不会使最小值丢失：假设 nums[right]nums[right]nums[right] 是最小值，有两种情况：
                    若 nums[right]nums[right]nums[right] 是唯一最小值：那就不可能满足判断条件 nums[mid] == nums[right]，因为 mid < right（left != right 且 mid = (left + right) // 2 向下取整）；
                    若 nums[right]nums[right]nums[right] 不是唯一最小值，由于 mid < right 而 nums[mid] == nums[right]，即还有最小值存在于 [left,right−1][left, right - 1][left,right−1] 区间，因此不会丢失最小值。
                 */
                right = right - 1;
            }
        }
        // return left > numbers.length - 1 ? numbers[numbers.length - 1] : numbers[left];
        return numbers[left];  // left 不会 index out of bound。如果在最后一个，最后一次loop的操作是right--
    }
}