import java.util.*;

/**
 * Bubble Sort
 * O(n^2) time | O(1) space
 */
class Solution912_01 {
    public int[] sortArray(int[] nums) {
        boolean sorted = false;
        int count = 0;
        while (!sorted) {
            boolean swap = false;
            for (int i = 1; i < nums.length - count; i++) {
                if (nums[i] < nums[i - 1]) {
                    swap = true;
                    int temp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = temp;
                }
            }
            count++;
            sorted = !swap;
        }

        return nums;
    }
}

/**
 * Selection Sort
 * O(n^2) time | O(1) space
 */
class Solution912_02 {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int smallest = nums[i];
            int smallestIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < smallest) {
                    smallest = nums[j];
                    smallestIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = smallest;
            nums[smallestIndex] = temp;
        }
        return nums;
    }
}

/**
 * Insertion Sort
 * O(n^2) time | O(1) space
 */
class Solution912_03 {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int curr = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > curr) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = curr;
        }
        return nums;
    }
}

/**
 * Merge Sort
 * O(n logn) time | O(n) space
 */
class Solution912_04 {
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int l, int r) {
        if (l >= r)
            return;
        int m = l + (r - l) / 2;
        sort(nums, l, m);
        sort(nums, m + 1, r);
        merge(nums, l, m, r);
    }

    private void merge(int[] nums, int l, int m, int r) {
        int[] left = new int[m - l + 1];
        int[] right = new int[r - m];
        for (int i = 0; i < left.length; i++) {
            left[i] = nums[l + i];
        }

        for (int j = 0; j < right.length; j++) {
            right[j] = nums[m + 1 + j];
        }

        int p1 = 0, p2 = 0, index = l;
        while (p1 < left.length && p2 < right.length) {
            if (left[p1] < right[p2]) {
                nums[index++] = left[p1++];
            } else {
                nums[index++] = right[p2++];
            }
        }

        while (p1 < left.length) {
            nums[index++] = left[p1++];
        }

        while (p2 < right.length) {
            nums[index++] = right[p2++];
        }
    }
}

/**
 * Quick Sort
 * O(log n) time | O(log n) space [递归的栈空间]
 * 
 * Quick Select: 215
 */
class Solution912_05 {
    Random rand = new Random();

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end)
            return;
        int partitionIndex = partition(nums, start, end);
        quickSort(nums, start, partitionIndex - 1);
        quickSort(nums, partitionIndex + 1, end);
    }

    private int partition(int[] nums, int start, int end) {
        int randomIndex = start + rand.nextInt(end - start + 1);
        swap(nums, start, randomIndex);
        int pivot = nums[start];
        int l = start + 1, r = end;
        while (l <= r) {
            while (l <= r && nums[l] < pivot) {
                l++;
            }
            while (l <= r && nums[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            swap(nums, l, r);
            l++;
            r--;
        }
        swap(nums, start, r);
        return r;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}