/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 */

// @lc code=start
class Solution {
    // 1 3 5 4 2
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i > -1 && nums[i] >= nums[i + 1]) { i--; }
        if (i == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int j = firstBiggerIndex(nums, i + 1, nums.length - 1, nums[i]);
        swap(nums, i, j);
        reverse(nums, i + 1, nums.length - 1);
    }

    // Desc Order. 4 3 2 1
    private int firstBiggerIndex(int[] array, int begin, int end, int x) {
        if (begin >= end) { return end; }
        int mid = (begin + end) / 2;
        if (array[mid] > x && !(array[mid + 1] > x)) { return mid; }
        else if (array[mid] <= x) { return firstBiggerIndex(array, begin, mid - 1, x); }
        else { return firstBiggerIndex(array, mid + 1, end, x); }
    }

    private void swap(int[] array, int i, int j) {
        array[i] = array[i] - array[j];
        array[j] += array[i];
        array[i] = -array[i] + array[j];
    }

    private void reverse(int[] array, int begin, int end) {
        while (begin < end) {
            swap(array, begin++, end--);
        }
    }
}
// @lc code=end

