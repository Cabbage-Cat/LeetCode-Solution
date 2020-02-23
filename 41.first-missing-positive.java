/*
 * @lc app=leetcode id=41 lang=java
 *
 * [41] First Missing Positive
 */

// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) { return 1; }
        int l = nums.length;
        for (int i = 0; i < nums.length; i++) {
            advancedSwap(nums, i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) { return i+1; }
        }
        return nums.length+1;
    }
    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private void advancedSwap(int[] array, int i) {
        int l = array.length;
        if (i < 0 || i >= l) { return; }
        int number = array[i];
        if (number == i + 1 || number > l || number < 1) { return; }
        if (array[number - 1] != number) {
            swap(array, i, number - 1);
            advancedSwap(array, i);
        }
    }
}
// @lc code=end

